package com.ashessin.cs441.hw2.dblp.utils;

import com.ctc.wstx.api.WstxInputProperties;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;
import org.apache.hadoop.io.compress.DefaultCodec;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static org.apache.hadoop.fs.CommonConfigurationKeysPublic.FS_DEFAULT_NAME_KEY;
import static org.apache.log4j.PropertyConfigurator.configure;

/**
 * DBLP Publications sequence file writer.
 */
public final class PublicationsSequenceFileWriter extends Configured implements Tool {
    private static final Logger logger = LoggerFactory.getLogger(PublicationsSequenceFileWriter.class);

    public static void main(String[] args) throws Exception {
        configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
        long start = System.currentTimeMillis();
        long memstart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        int res = ToolRunner.run(new Configuration(), new PublicationsSequenceFileWriter(), args);

        long memend = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long end = System.currentTimeMillis();

        logger.info("Sequence File Writer, Memory used (bytes): {}", memend - memstart);
        logger.info("Sequence File Writer, Time taken (ms): {}", end - start);

        // System.exit(res);
    }

    static boolean isPubicationRecord(String startElementName) {
        return startElementName.equals("article") ||
                startElementName.equals("inproceedings") ||
                startElementName.equals("proceedings") ||
                startElementName.equals("book") ||
                startElementName.equals("incollection") ||
                startElementName.equals("phdthesis") ||
                startElementName.equals("mastersthesis") ||
                startElementName.equals("www") ||
                startElementName.equals("data");
    }

    /**
     * Execute the command with the given arguments.
     *
     * @param args command specific arguments.
     * @return exit code.
     * @throws Exception in case of errors
     */
    @Override
    public int run(String[] args) throws Exception {
        Configuration conf = super.getConf();

        PublicationWritable pub = null;
        int counter = 0;
        Text k = new Text();

        String publrecord = "";
        ArrayList<String> authors = null;
        ArrayList<String> editors = null;
        int year = -1;
        String journal = "";
        ArrayList<String> urls = null;
        ArrayList<String> ees = null;
        ArrayList<String> cites = null;
        String crossref = "";
        ArrayList<String> schools = null;

        System.setProperty("entityExpansionLimit", String.valueOf(Integer.MAX_VALUE));
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        // disable resolving of external DTD entities
        xmlInputFactory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, Boolean.FALSE);
        // javax.xml.stream.XMLStreamException: Maximum entity expansion count limit (100000) exceeded
        xmlInputFactory.setProperty(WstxInputProperties.P_MAX_ENTITY_COUNT, Integer.MAX_VALUE);

        Path dblpXmlFilePath = new Path(args[0]);
        Path dblpSequnceFilePath = new Path(args[1]);

        final FileSystem SOURCE_FS = dblpXmlFilePath.getFileSystem(conf);
        final FileSystem TARGET_FS = dblpSequnceFilePath.getFileSystem(conf);

        logger.info("Source Filesystem is: {}", SOURCE_FS);
        logger.info("Target Filesystem is: {}", TARGET_FS);

        if (SOURCE_FS.getUri() == TARGET_FS.getUri()) {
            conf.set(FS_DEFAULT_NAME_KEY, String.valueOf(TARGET_FS.getUri()));
            logger.info("Setting default filesystem as: {}", conf.get(FS_DEFAULT_NAME_KEY));
        } else {
            logger.warn("The default filesystem is: {}", conf.get(FS_DEFAULT_NAME_KEY));
        }

        // delete existing directory
        if (TARGET_FS.exists(dblpSequnceFilePath)) {
            TARGET_FS.delete(dblpSequnceFilePath, true);
        }

        try (SequenceFile.Writer writer = SequenceFile.createWriter(conf,
                SequenceFile.Writer.file(dblpSequnceFilePath),
                SequenceFile.Writer.keyClass(Text.class),
                SequenceFile.Writer.valueClass(PublicationWritable.class),
                SequenceFile.Writer.compression(
                        SequenceFile.CompressionType.BLOCK,
                        new DefaultCodec())
        )) {
            CompressionCodecFactory compressionCodecFactory = new CompressionCodecFactory(conf);
            CompressionCodec compressionCodec = compressionCodecFactory.getCodec(dblpXmlFilePath);
            // allow processing gz file as it is without the need to uncompress manually first
            try (InputStream is = compressionCodec == null ?
                    SOURCE_FS.open(dblpXmlFilePath).getWrappedStream() :
                    compressionCodec.createInputStream(SOURCE_FS.open(dblpXmlFilePath))) {
                xmlInputFactory.setXMLResolver((publicId, systemId, externalForm, entityName) -> {
                    logger.info("Source XML publicId: {}, systemId: {}, externalForm: {}, entityName: {}",
                            publicId, systemId, externalForm, entityName);
                    Path dtdFilePath = new Path(dblpXmlFilePath.getParent() + File.separator + systemId);
                    logger.info("Attempting to load DTD from {}", dtdFilePath);
                    try {
                        if (SOURCE_FS.exists(dtdFilePath)) {
                            return SOURCE_FS.open(dtdFilePath).getWrappedStream();
                        } else {
                            throw new FileNotFoundException();
                        }
                    } catch (IOException e) {
                        logger.error("Exception::", e);
                    }
                    return null;
                });
                XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(is);

                while (xmlEventReader.hasNext()) {
                    XMLEvent xmlEvent = xmlEventReader.nextEvent();

                    if (xmlEvent.isStartElement()) {
                        StartElement startElement = xmlEvent.asStartElement();
                        String startElementName = startElement.getName().getLocalPart();
                        if (isPubicationRecord(startElementName)) {
                            publrecord = startElementName;
                            authors = new ArrayList<>();
                            editors = new ArrayList<>();
                            urls = new ArrayList<>();
                            ees = new ArrayList<>();
                            cites = new ArrayList<>();
                            schools = new ArrayList<>();
                            //Get the 'key' attribute from publication element
                            Attribute keyAttr = startElement.getAttributeByName(new QName("key"));
                            //Get the 'publtype' attribute from publication element
                            Attribute publtypeAttr = startElement.getAttributeByName(new QName("publtype"));
                            pub = new PublicationWritable(keyAttr.getValue(), publrecord,
                                    publtypeAttr != null ? publtypeAttr.getValue() : "",
                                    authors, editors, year, journal, urls, ees, cites, crossref, schools);
                        } else if (startElement.getName().getLocalPart().equals("author")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            authors.add(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("editor")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            editors.add(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("year")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            pub.setYear(Integer.parseInt(xmlEvent.asCharacters().getData()));
                        } else if (startElement.getName().getLocalPart().equals("journal")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            pub.setJournal(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("url")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            urls.add(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("ee")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            ees.add(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("cite")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            cites.add(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("crossref")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            pub.setCrossref(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("school")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            schools.add(xmlEvent.asCharacters().getData());
                        }
                    }

                    if (xmlEvent.isEndElement()) {
                        EndElement endElement = xmlEvent.asEndElement();
                        if (endElement.getName().getLocalPart().equals(publrecord) && (pub != null)) {
                            if (authors != null && !authors.isEmpty()) {
                                pub.setAuthors(authors);
                            }
                            if (editors != null && !editors.isEmpty()) {
                                pub.setEditors(editors);
                            }
                            if (urls != null && !urls.isEmpty()) {
                                pub.setUrls(urls);
                            }
                            if (ees != null && !ees.isEmpty()) {
                                pub.setEes(ees);
                            }
                            if (cites != null && !cites.isEmpty()) {
                                pub.setCites(cites);
                            }
                            if (schools != null && !schools.isEmpty()) {
                                pub.setSchools(schools);
                            }
                            k.set(pub.getKey());
                            writer.append(k, pub);
                            counter += 1;
                            if (logger.isDebugEnabled()) {
                                logger.info(pub.toString());
                            }
                            System.out.print(String.format("Publications processed: %s\r", counter));
                        }
                    }
                }
                logger.info("Publications processed: {}", counter);
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            logger.error("Exception :: ", e);
        }

        return counter;
    }
}
