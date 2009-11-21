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
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

/**
 * XML parsing test class
 * @author Raah
 */
public class CompilerTest {

    
    public static void parse(String file, String dir) {
        try {
            System.err.print("Reading " + file+"\n");
            XMLInputFactory factory = XMLInputFactory.newInstance();
            //System.out.println("FACTORY: " + factory);
            XMLEventReader reader = factory.createXMLEventReader(new FileReader(file));
            //System.out.println("READER: " + reader);

            while (reader.hasNext()) {
                XMLEvent e = reader.nextEvent();
                System.out.println(e);
                //procNode();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error: Cannot open '" + file + "'.");
        } catch (XMLStreamException e) {
            throw new RuntimeException("Error: An error occured parsing '" + file + "'.");
        }        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        if (args.length !=1) {
            throw new RuntimeException ("takes one file address as argument");
        }
        parse(args[0],"");
        
        
        //with java -jar lttoolbox-1.0-SNAPSHOT.jar ../src/test/org/apertium/lttoolbox/short.dix 
        //we get <?xml version="1.0" encoding='null' standalone='no'?>
        //why do we loose encoding="UTF-8" ?
        //the rest of the dictionnary is displayed normally
    }

}
