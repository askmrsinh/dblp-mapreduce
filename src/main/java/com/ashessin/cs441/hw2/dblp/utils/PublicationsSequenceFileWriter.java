package com.ashessin.cs441.hw2.dblp.utils;

import com.ctc.wstx.api.WstxInputProperties;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.DefaultCodec;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.ArrayList;

public class PublicationsSequenceFileWriter extends Configured implements Tool {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        long memstart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.setProperty("entityExpansionLimit", String.valueOf(Integer.MAX_VALUE));
        int res = ToolRunner.run(new Configuration(), new PublicationsSequenceFileWriter(), args);

        long memend = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long end = System.currentTimeMillis();

        System.out.println("Sequence File Writer, Memory used (bytes): "
                + (memend - memstart));
        System.out.println("Sequence File Writer, Time taken (ms): "
                + (end - start));

        System.exit(res);
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
     * @throws Exception
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

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        // disable resolving of external DTD entities
        xmlInputFactory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, Boolean.FALSE);
        // javax.xml.stream.XMLStreamException: Maximum entity expansion count limit (100000) exceeded
        xmlInputFactory.setProperty(WstxInputProperties.P_MAX_ENTITY_COUNT, Integer.MAX_VALUE);

        String localFilePath = args[0];
        final String HDFS = "hdfs://localhost:9000";
        Path outputPath = new Path(new URI(HDFS + args[1]));

        FileSystem hdfs = FileSystem.get(URI.create(HDFS), conf);
        // delete existing directory
        if (hdfs.exists(outputPath)) {
            hdfs.delete(outputPath, true);
        }

        try (SequenceFile.Writer writer = SequenceFile.createWriter(conf,
                SequenceFile.Writer.file(outputPath),
                SequenceFile.Writer.keyClass(Text.class),
                SequenceFile.Writer.valueClass(PublicationWritable.class),
                SequenceFile.Writer.compression(
                        SequenceFile.CompressionType.BLOCK,
                        new DefaultCodec())
        )) {

            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(localFilePath));

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
                    if (endElement.getName().getLocalPart().equals(publrecord)) {
                        if (authors != null && !authors.isEmpty()) {
                            pub.setAuthors(authors);
                        }
                        if (editors != null && !editors.isEmpty()) {
                            pub.setEditors(editors);
                        }
                        if (urls != null && !urls.isEmpty()) {
                            pub.setUrls(urls);
                        }
                        if (editors != null && !ees.isEmpty()) {
                            pub.setEes(ees);
                        }
                        if (cites != null && !cites.isEmpty()) {
                            pub.setCites(cites);
                        }
                        if (schools != null && !schools.isEmpty()) {
                            pub.setSchool(schools);
                        }
                        k.set(pub.getKey());
                        writer.append(k, pub);
                        counter += 1;
                        // System.out.println(pub.toString());
                        System.out.print("Publications processed: " + counter + "\r");
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
