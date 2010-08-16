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

package org.apertium.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Stephen Tigner
 *
 */
public class StringTable {
    /*public enum Entries {
        UNSUPPORTED_ENCODING, FILE_NOT_FOUND, GENERIC_EXCEPTION,
        IO_EXCEPTION, UNEXPECTED_FILE_NOT_FOUND, UNEXPECTED_UNSUPPORTED_ENCODING,
        COMPILATION_FAILURE
    }*/

    public static final String UNSUPPORTED_ENCODING = 
        "Your system does not support UTF-8 " + 
        "encoding. Cannot continue. Please enable UTF-8 support, or find " +
        "a system that supports UTF-8 and try again.";

    public static final String FILE_NOT_FOUND = 
        "Unable to find and/or open the specified file, please check " +
        "the filename and try again.";

    public static final String GENERIC_EXCEPTION =
        "An exception occured during execution.";

    public static final String IO_EXCEPTION =
        "An I/O exception occured during execution.";

    public static final String UNEXPECTED_FILE_NOT_FOUND =
        "Got a FileNotFoundException whle parsing the commandLine from " +
        "the modes file. This should not happen, so you must have found " + 
        "a bug. Here's a stack trace to help track that down.";

    public static final String UNEXPECTED_UNSUPPORTED_ENCODING =
        "Got an UnsupportedEncodingException whle parsing the commandLine " +
        "from the modes file. This should not happen, so you must have " + 
        "found a bug. Here's a stack trace to help track that down.";

    public static final String COMPILATION_FAILURE =
        "Prechunk/Interchunk/Transfer compilation failed.";
    
    //private static Map<Entries, String> stringMap = null;
    
    /*private static void initializeMap() {
        stringMap = new HashMap<Entries, String>();

        String tempString = "Your system does not support UTF-8 " + 
        "encoding. Cannot continue. Please enable UTF-8 support, or find " +
        "a system that supports UTF-8 and try again.";
        
        stringMap.put(Entries.UNSUPPORTED_ENCODING, tempString);
        
        tempString = "Unable to find and/or open the specified file, please check " +
        		"the filename and try again.";
        
        stringMap.put(Entries.FILE_NOT_FOUND, tempString);
        
        tempString = "An exception occured during execution.";
        
        stringMap.put(Entries.GENERIC_EXCEPTION, tempString);
        
        tempString = "An I/O exception occured during execution.";
        
        stringMap.put(Entries.IO_EXCEPTION, tempString);
        
        tempString =
            "Got a FileNotFoundException whle parsing the commandLine from " +
            "the modes file. This should not happen, so you must have found " + 
            "a bug. Here's a stack trace to help track that down.";

        stringMap.put(Entries.UNEXPECTED_FILE_NOT_FOUND, tempString);
        
        tempString =
            "Got an UnsupportedEncodingException whle parsing the commandLine " +
            "from the modes file. This should not happen, so you must have " + 
            "found a bug. Here's a stack trace to help track that down.";
        
        stringMap.put(Entries.UNEXPECTED_UNSUPPORTED_ENCODING, tempString);
        
        tempString = "Prechunk/Interchunk/Transfer compilation failed.";
        
        stringMap.put(Entries.COMPILATION_FAILURE, tempString);
    }*/
    
    /*public static String getString(Entries entry) {
        if(stringMap == null) { initializeMap(); }
        
        return(stringMap.get(entry));
    }*/
}
