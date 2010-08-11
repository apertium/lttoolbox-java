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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Stephen Tigner
 *
 */
public class IOUtils {
    
    public static String readFile(String path) throws IOException {
        return readFile(path, "UTF-8");
    }

    public static String readFile(String path, String encoding) throws IOException {
        File outFile = new File(path);
        FileInputStream fis = new FileInputStream(outFile);
        /* If we don't do it this way, by explicitly setting UTF-8 encoding
         * when reading in a file, we get mojibake (scrambled character encodings).
         */
        InputStreamReader fisReader = new InputStreamReader(fis, encoding);
        /* This will leave us with a bunch of extra nulls at the end if the
         * input file has any multi-byte characters in it, we take care of that
         * further down before returning the string.
         */
        char[] charArray = new char[(int) outFile.length()];
        fisReader.read(charArray);
        fisReader.close();
        String testOutput = new String(charArray);
        /* Work backwards from the end of the string to find the first non-null
         * character. That is the true end of the string. (Java strings don't have
         * a null at the end of them to mark the end, since they know exactly how
         * long they are, which is why we can have a bunch of nulls at the end of
         * the string.)
         * 
         * The reason why we need to remove these nulls is that they cause the string
         * to be longer than it actually should be, and messes up testing diffs.
         */
        for(int i = testOutput.length() - 1; i > -1; i--) {
            if(testOutput.charAt(i) != '\0') {
                testOutput = testOutput.substring(0, i + 1);
                break;
            }
        }
        return testOutput;
    }

}
