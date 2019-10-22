package com.ashessin.cs441.hw2.dblp;

import com.ctc.wstx.api.WstxInputProperties;

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
import java.util.ArrayList;
import java.util.List;

public class StaxXMLReader {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long memstart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        String fileName = args[0];
        System.setProperty("entityExpansionLimit", String.valueOf(Integer.MAX_VALUE));
        List<Publication> pubList = parseXML(fileName);
        System.out.println("Publications processed: " + pubList.size());
        System.out.println(pubList.get(0).toString());
        System.out.println(pubList.get(pubList.size() - 1).toString());

        long memend = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long end = System.currentTimeMillis();

        System.out.println("StAX XML Parser, Memory used (bytes): "
                + (memend - memstart));
        System.out.println("StAX XML Parser, Time taken (ms): "
                + (end - start));
    }

    public static List<Publication> parseXML(String fileName) {
        String publrecord = "";
        List<Publication> pubList = new ArrayList<>();
        List<String> authors = null;
        Publication pub = null;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        // disable resolving of external DTD entities
        xmlInputFactory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, Boolean.FALSE);
        // javax.xml.stream.XMLStreamException: Maximum entity expansion count limit (100000) exceeded
        xmlInputFactory.setProperty(WstxInputProperties.P_MAX_ENTITY_COUNT, Integer.MAX_VALUE);

        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));

            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();

                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    String startElementName = startElement.getName().getLocalPart();
                    if (startElementName.equals("article") ||
                            startElementName.equals("inproceedings") ||
                            startElementName.equals("proceedings") ||
                            startElementName.equals("book") ||
                            startElementName.equals("incollection") ||
                            startElementName.equals("phdthesis") ||
                            startElementName.equals("mastersthesis") ||
                            startElementName.equals("www") ||
                            startElementName.equals("data")) {
                        publrecord = startElementName;
                        authors = new ArrayList<>();
                        //Get the 'key' attribute from publication element
                        Attribute keyAttr = startElement.getAttributeByName(new QName("key"));
                        //Get the 'publtype' attribute from publication element
                        Attribute publtypeAttr = startElement.getAttributeByName(new QName("publtype"));
                        if (keyAttr != null) {
                            pub = new Publication(keyAttr.getValue(), 0,
                                    publtypeAttr != null ? publtypeAttr.getValue() : "",
                                    publrecord, (ArrayList<String>) authors, "");
                        }
                    } else if (startElement.getName().getLocalPart().equals("author")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        authors.add(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("journal")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        pub.setJournal(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("year")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        pub.setYear(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }
                }

                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals(publrecord)) {
                        if (!authors.isEmpty()) {
                            pub.setAuthors(authors);
                        }
                        pubList.add(pub);
                    }
                    System.out.print("Publications processed: " + pubList.size() + "\r");
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }

        return pubList;
    }
}
