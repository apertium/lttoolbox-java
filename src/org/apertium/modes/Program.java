/*
 * Copyright (C) 2010 Stephen Tigner
 * 
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

package org.apertium.modes;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * @author Stephen Tigner
 *
 */
public class Program {
    //Each program has a "name" which is a command line.
    String _commandLine;
    //Dunno what this is for yet, but it's in the DTD
    String _prefix;
    //Each program also has a list of files, which are used, in order.
    ArrayList<String> _files;
    
    public Program(Element progElem) {
        _commandLine = progElem.getAttribute("name");
        _prefix = progElem.getAttribute("prefix");
        _files = new ArrayList<String>();
        
        _files = new ArrayList<String>();
        NodeList fileNodeList = progElem.getElementsByTagName("file");
        int numFiles = fileNodeList.getLength();
        for(int i = 0; i < numFiles; i++) {
            Element currFile = (Element) fileNodeList.item(i);
            _files.add(currFile.getAttribute("name"));
        }
    }

    public String getCommandLine() {
        return _commandLine;
    }
    
    public String getPrefix() {
        return _prefix;
    }
    
    public String getFile(int index) {
        return _files.get(index);
    }

    /**
     * Allows for all the filename strings to be retrieved at once.
     * @return A copy of the internal list of filename strings.
     */
    public ArrayList<String> getFiles() {
        return new ArrayList<String>(_files);
    }
    
    @Override
    public String toString() {
        StringBuilder tempString = new StringBuilder();
        tempString.append("{Program -- " + _commandLine + ": \n");
        tempString.append("Files: " + _files + " }");
        return tempString.toString();
    }
}
