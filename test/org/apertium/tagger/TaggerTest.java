/*
 * Copyright 2010 Jimmy O'Regan
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
package org.apertium.tagger;

import java.io.InputStream;
import java.io.OutputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

/**
 *
 * @author jimregan
 */
public class TaggerTest {

    String dir = "testdata/tagger/";

    public TaggerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Tagger.
     */
    @Test
    public void testMain() throws IOException {
        //fail("This test is not ready yet. Comment this line to try it out, at your own risk.");
        System.out.println("main");

        String prob = dir + "en-es.prob";
        String testin = "^this/this<det><dem><sg>/this<prn><tn><mf><sg>$ ^is/be<vbser><pri><p3><sg>$ ^a/a<det><ind><sg>$ ^test/test<n><sg>/test<vblex><inf>/test<vblex><pres>$^./.<sent>$";
        String testout = "^this<prn><tn><mf><sg>$ ^be<vbser><pri><p3><sg>$ ^a<det><ind><sg>$ ^test<n><sg>$^.<sent>$";
        String[] argv = {"-g", prob, "./tmp/taggerin", "./tmp/taggerout"};

        FileOutputStream f = new FileOutputStream("./tmp/taggerin");
        f.write(testin.getBytes("UTF-8"));
        f.close();

        Tagger.main(argv);
        
        FileInputStream fIn = new FileInputStream("./tmp/taggerout");
        int numBytesRead;
        int numBytesToRead = fIn.available();
        byte[] byteArray = new byte[numBytesToRead];
        numBytesRead = fIn.read(byteArray);
        String testOutput = new String(byteArray, "UTF-8");
        assertEquals("TaggerTest.testMain() failed: output does not match expected output.", testout, testOutput);
    }
    
    /**
     * Test of main method, using external text files.
     */
    @Test
    public void testMainExternal() throws IOException {
        System.out.println("main");

        String prob = dir + "en-es.prob";
        String inFile = dir + "en-tagger-input.txt";
        String outputFile = "./tmp/taggerout";
        String compareOutFile = dir + "en-tagger-output.txt";
        String[] argv = {"-g", prob, inFile, outputFile};

        Tagger.main(argv);
        
        //Read actual output into a string
        FileInputStream fIn = new FileInputStream(outputFile);
        int numBytesRead;
        int numBytesToRead = fIn.available();
        byte[] byteArray = new byte[numBytesToRead];
        numBytesRead = fIn.read(byteArray);
        String testOutput = new String(byteArray, "UTF-8");
        
        fIn = new FileInputStream(compareOutFile);
        numBytesToRead = fIn.available();
        byteArray = new byte[numBytesToRead];
        numBytesRead = fIn.read(byteArray);
        String expectedOutput = new String(byteArray, "UTF-8");
        
        assertEquals("TaggerTest.testMain() failed: output does not match expected output.", expectedOutput, testOutput);
    }
}
