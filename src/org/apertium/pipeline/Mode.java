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

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * @author Stephen Tigner
 *
 */
public class Mode {
    //Each mode has a pipeline, which is a list of programs to run.
    ArrayList<Program> _pipeline = new ArrayList<Program>();
    //Mode name 
    String _modeName;
    //Install flag
    boolean _install;

    public Mode(Element currMode) {
        Element pipelineElem = (Element) currMode.getElementsByTagName("pipeline").item(0);
        NodeList progList = pipelineElem.getElementsByTagName("program");
        _modeName = currMode.getAttribute("name");
        /* Install is an optional attribute, assuming the default is "yes"
         * when the attribute is not present.
         * Thus we want to test if it equals "no" rather than if it equals
         * "yes", because if it was missing, it wouldn't match "yes" when
         * it should be yes.
         * If it equals "no", then we want install to equal false, hence the
         * '!' invert the result of that equals statement.
         */
        _install = (!currMode.getAttribute("install").equals("no"));
        
        int numProgs = progList.getLength();
        for(int i = 0; i < numProgs; i++) {
            Element currProg = (Element) progList.item(i);
            _pipeline.add(new Program(currProg));
        }
    }
    
    public String getModeName() {
        return _modeName;
    }
    
    public boolean getInstallFlag() {
        return _install;
    }
    
    public Program getProgByIndex(int index) {
        return _pipeline.get(index);
    }

    @Override
    public String toString() {
        StringBuilder tempString = new StringBuilder();
        tempString.append("[Mode -- " + _modeName + ": \n");
        for(Program currProg : _pipeline) {
            tempString.append(currProg.toString());
        }
        tempString.append(" ]");
        return tempString.toString();
    }
}
