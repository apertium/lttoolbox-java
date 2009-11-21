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
import java.util.Iterator;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.XMLEvent;

/**
 * Class to test the event type XML parsing
 * @author Raah
 */
public class EventPrinterTest {

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
            XMLEventReader reader = factory.createXMLEventReader(new FileReader(args[0]));

            while (reader.hasNext()) {
                XMLEvent e = reader.nextEvent();
                int eventType = e.getEventType();

                if (e.isStartDocument()) {
                    System.out.print("start");
                }
                if (e.isStartElement()) {
                    System.out.print("<" + e.asStartElement().getName() + " ");
                    for (Iterator<Attribute> it = e.asStartElement().getAttributes(); it.hasNext();) {
                        Attribute attribute = it.next();
                        System.out.print(" " + attribute.toString() + " ");
                    }
                    System.out.println(">");
                } else if (e.isCharacters()) {
                    System.out.print(" " + e.asCharacters().getData() + " ");
                } else if (e.isEndElement()) {
                    System.out.println("</" + e.asEndElement().getName() + ">");
                }
                if (e.isEndDocument()) {
                    System.out.print("end");
                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error: Cannot open '" + args[0] + "'.");
        } catch (XMLStreamException e) {
            throw new RuntimeException("Error: An error occured parsing '" + args[0] + "'.");
        }
    }
}


