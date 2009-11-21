package org.apertium.lttoolbox;

/*
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * Class to test the cursor type XML parsing
 * @author Raah
 */
public class CursorPrinterTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         if (args.length != 1) {
            throw new RuntimeException("\n it needs one file address as argument.\n" +
                "you might want to try : " +
                "java -jar lttoolbox-1.0-SNAPSHOT.jar ../src/test/org/apertium/lttoolbox/short.dix\n");
        }
        try {
            System.err.print("Reading " + args[0] + "\n");
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(args[0]));
            while (reader.hasNext()) {
                printEvent(reader);
                reader.next();
            }
            reader.close();
            System.out.println("");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error: Cannot open '" + args[0] + "'.");
        } catch (XMLStreamException e) {
            throw new RuntimeException("Error: An error occured parsing '" + args[0] + "'.");
        }
    }


    public static void printEvent(XMLStreamReader reader) {

        switch (reader.getEventType()) {

            case XMLStreamConstants.START_ELEMENT:
                System.out.print("<");
                printName(reader);
                printNamespaces(reader);
                printAttributes(reader);
                System.out.print(">");
                break;

            case XMLStreamConstants.END_ELEMENT:
                System.out.print("</");
                printName(reader);
                System.out.print(">");
                break;

            case XMLStreamConstants.SPACE:

            case XMLStreamConstants.CHARACTERS:
                int start = reader.getTextStart();
                int length = reader.getTextLength();
                System.out.print(new String(reader.getTextCharacters(),
                    start,
                    length));
                break;

            case XMLStreamConstants.PROCESSING_INSTRUCTION:
                System.out.print("<?");
                if (reader.hasText()) {
                    System.out.print(reader.getText());
                }
                System.out.print("?>");
                break;

            case XMLStreamConstants.CDATA:
                System.out.print("<![CDATA[");
                start = reader.getTextStart();
                length = reader.getTextLength();
                System.out.print(new String(reader.getTextCharacters(),
                    start,
                    length));
                System.out.print("]]>");
                break;

            case XMLStreamConstants.COMMENT:
                System.out.print("<!--");
                if (reader.hasText()) {
                    System.out.print(reader.getText());
                }
                System.out.print("-->");
                break;

            case XMLStreamConstants.ENTITY_REFERENCE:
                System.out.print(reader.getLocalName() + "=");
                if (reader.hasText()) {
                    System.out.print("[" + reader.getText() + "]");
                }
                break;

            case XMLStreamConstants.START_DOCUMENT:
                System.out.print("<?xml");
                System.out.print(" version='" + reader.getVersion() + "'");
                System.out.print(" encoding='" + reader.getCharacterEncodingScheme() + "'");
                if (reader.isStandalone()) {
                    System.out.print(" standalone='yes'");
                } else {
                    System.out.print(" standalone='no'");
                }
                System.out.print("?>");
                break;

        }
    }

    private static void printName(XMLStreamReader reader) {
        if (reader.hasName()) {
            String prefix = reader.getPrefix();
            String uri = reader.getNamespaceURI();
            String localName = reader.getLocalName();
            printName(prefix, uri, localName);
        }
    }

    private static void printName(String prefix,
        String uri,
        String localName) {
        if (uri != null && !("".equals(uri))) {
            System.out.print("['" + uri + "']:");
        }
        if (localName != null) {
            System.out.print(localName);
        }
    }

    private static void printAttributes(XMLStreamReader reader) {
        for (int i = 0; i < reader.getAttributeCount(); i++) {
            printAttribute(reader, i);
        }
    }

    private static void printAttribute(XMLStreamReader reader, int index) {
        String prefix = reader.getAttributePrefix(index);
        String namespace = reader.getAttributeNamespace(index);
        String localName = reader.getAttributeLocalName(index);
        String value = reader.getAttributeValue(index);
        System.out.print(" ");
        printName(prefix, namespace, localName);
        System.out.print("='" + value + "'");
    }

    private static void printNamespaces(XMLStreamReader reader) {
        for (int i = 0; i < reader.getNamespaceCount(); i++) {
            printNamespace(reader, i);
        }
    }

    private static void printNamespace(XMLStreamReader reader, int index) {
        String prefix = reader.getNamespacePrefix(index);
        String uri = reader.getNamespaceURI(index);
        System.out.print(" ");
        if (prefix == null) {
            System.out.print("xmlns ='" + uri + "'");
        } else {
            System.out.print("xmlns:" + prefix + "='" + uri + "'");
        }
    }
}
