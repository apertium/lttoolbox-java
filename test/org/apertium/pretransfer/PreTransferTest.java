/*
 * Copyright (C) 2010 Stephen
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

package org.apertium.pretransfer;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apertium.tagger.Tagger;
import org.junit.Test;

/**
 * @author Stephen
 *
 */
public class PreTransferTest {

    String dir = "testdata/pretransfer/";

    private String readFile(String path) throws IOException {
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
     * Test method for {@link org.apertium.pretransfer.PreTransfer#main(java.lang.String[])}.
     * pretransfer takes the output from the tagger as its input and outputs to transfer.
     * This tests pretransfer with a single sample sentence.
     */
    @Test
    public void testMainThisIsATest() throws IOException {
        String testin = "^this<prn><tn><mf><sg>$ ^be<vbser><pri><p3><sg>$ ^a<det><ind><sg>$ ^test<n><sg>$^.<sent>$";
        String expTestout = "^this<prn><tn><mf><sg>$ ^be<vbser><pri><p3><sg>$ ^a<det><ind><sg>$ ^test<n><sg>$^.<sent>$";
        String[] argv = {"./tmp/pretransferin", "./tmp/pretransferout"};

        FileWriter f = new FileWriter("./tmp/pretransferin");
        f.append(testin);
        f.close();
        
        PreTransfer.main(argv);
        String testOutput = readFile("./tmp/pretransferout");

        System.err.println("output = " + testOutput);
        System.err.println("expout = " + expTestout);
        assertEquals("PreTransferTest.testMainThisIsATest() failed: output does not match expected output.", expTestout, testOutput);
    }

    /**
     * Test of main method, using external text files.
     */
    @Test
    public void testMain200Sentences() throws IOException {
        String inFile = dir + "en-pretransfer-input.txt";
        String outputFile = "./tmp/pretransferout";
        String compareOutFile = dir + "en-pretransfer-output.txt";
        String[] argv = {inFile, outputFile};

        PreTransfer.main(argv);

        //Read actual output into a string
        String testOutput = readFile("./tmp/pretransferout");
        String expectedOutput = readFile(compareOutFile);

        assertEquals("PreTransferTest.testMain200Sentences() failed: output does not match expected output.", expectedOutput, testOutput);
    }
}
