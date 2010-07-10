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

package org.apertium.formatter;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * @author Stephen Tigner
 * Test for the org.apertium.formatter.TextFormatter class.
 */
public class TestTextFormatter {

    /* Copied from the test org.apertium.tagger.TaggerTest
     */
    public String readFile(String path) throws IOException {
        File outFile = new File(path);
        FileInputStream fis = new FileInputStream(outFile);
        InputStreamReader fisReader = new InputStreamReader(fis, "UTF-8");
        char[] charArray = new char[(int) outFile.length()];
        fisReader.read(charArray);
        fisReader.close();
        String testOutput = new String(charArray);
        return testOutput;
    }
    
    /**
     * Test method for {@link org.apertium.formatter.TextFormatter#main(java.lang.String[])}.
     * This passing currently means nothing as it doesn't actually test anything in the 
     * jUnit sense, instead it's used for launching the TextFormatter with certain
     * parameters easily in the IDE for testing and debugging purposes.
     */
    @Test
    public void testMain() throws IOException {
        String[] args = {"-d", "-i", "./tmp/txtfmtin"};
        String testin = "$100 cash+\n@No refunds *\\ > ~ < \tfoo\tbar {} //// \t  #<blah>";

        FileWriter f = new FileWriter("./tmp/txtfmtin");
        f.append(testin);
        f.close();

        TextFormatter.main(args);
    }

}
