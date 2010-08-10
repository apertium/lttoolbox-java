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

package org.apertium.pipeline;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Stephen Tigner
 *
 */
public class PipelineModes {
    //PipelineModes is fed an XML file.
    
    //A list of mode objects.
    Map<String, Mode> _modes = null;
    
    public PipelineModes(String filename) throws SAXException, IOException, 
            ParserConfigurationException {
        parseModeFile(filename);
    }
    
    private void parseModeFile(String filename) throws SAXException, IOException, 
            ParserConfigurationException {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(filename));
        Element root = doc.getDocumentElement();

        _modes = new HashMap<String, Mode>();
        
        //Iterate through each mode and add it to the modes list
        NodeList modeNodes = root.getElementsByTagName("mode");
        int numModes = modeNodes.getLength();
        for(int i = 0; i < numModes; i++) {
            Element currMode = (Element) modeNodes.item(i);
            String modeName = currMode.getAttribute("name");
            _modes.put(modeName, new Mode(currMode));
        }
    }
    
    public Mode getModeByName(String modeName) {
        if(_modes != null) {
            return _modes.get(modeName);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder tempString = new StringBuilder();
        tempString.append("{PipelineModes: \n");
        for(String currModeName : _modes.keySet()) {
            tempString.append(_modes.get(currModeName).toString());
        }
        tempString.append(" }");
        return tempString.toString();
    }
}
