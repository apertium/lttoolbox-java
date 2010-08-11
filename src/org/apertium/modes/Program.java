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
import java.util.Arrays;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * @author Stephen Tigner
 *
 */
public class Program {
    
    public enum Programs {
        LT_PROC, TAGGER, PRETRANSFER, TRANSFER, INTERCHUNK, POSTCHUNK,
        TXT_DEFORMAT, TXT_REFORMAT, UNKNOWN
    }
    
    //Each program has a "name" which is a command line.
    private String _commandName;
    private final Programs _program;
    //Each program also has a list of files, which are used, in order.
    private String _parameters;

    public Program(String commandLine) {
        /* Splits on spaces, assumes path won't have internal spaces.
         * This only splits the command from the parameters. The parameters
         * are left as a single string.
         * This is to make it easier to run the command when the time comes.
         * If a specific command needs to have the parameters split up for some
         * reason, that can still be done later.
         */
        String[] paramList = commandLine.split(" ", 2);

        /* Split off the command name from the rest of the path, as the paths in
         * mode files are absolute unix paths and will fail in cygwin, as Java
         * doesn't run in the cygwin filesystem.
         * Running the executables w/o a path prefix will work in Windows with
         * cygwin, provided that the user has the cygwin bin dir in their path.
         */
        String[] commandPathList = paramList[0].trim().split("\\/");
        //Grab the last entry
        _commandName = commandPathList[commandPathList.length - 1];
        _parameters = paramList[1];

        if(_commandName.equals("lt-proc")) {
            _program = Programs.LT_PROC;
        } else if(_commandName.equals("apertium-tagger")) {
            _program = Programs.TAGGER;
        } else if(_commandName.equals("apertium-pretransfer")) {
            _program = Programs.PRETRANSFER;
        } else if(_commandName.equals("apertium-transfer")) {
            _program = Programs.TRANSFER;
        } else if(_commandName.equals("apertium-interchunk")) {
            _program = Programs.INTERCHUNK;
        } else if(_commandName.equals("apertium-postchunk")) {
            _program = Programs.POSTCHUNK;
        } else if(_commandName.equals("apertium-destxt")) {
            _program = Programs.TXT_DEFORMAT;
        } else if(_commandName.equals("apertium-retxt")) {
            _program = Programs.TXT_REFORMAT;
        } else {
            _program = Programs.UNKNOWN;
        }
    }

    public String getCommandName() {
        return _commandName;
    }
    
    public Programs getProgram() {
        return _program;
    }
    
    /**
     * Allows for all the filename strings to be retrieved at once.
     * @return A copy of the internal list of parameters.
     */
    public String getParameters() {
        return _parameters;
    }
    
    @Override
    public String toString() {
        StringBuilder tempString = new StringBuilder();
        tempString.append("{Program -- " + _commandName + " (" + 
                _program.toString() + "): \n");
        tempString.append("Parameters: " + _parameters + " }");
        return tempString.toString();
    }
}
