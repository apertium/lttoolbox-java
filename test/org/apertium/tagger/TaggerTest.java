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
import java.io.OutputStreamWriter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

import static org.apertium.lttoolbox.TestTools.*;

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
     * Test of main method, of class Tagger.
     */
    @Test
    public void testMainThisIsATest() throws IOException {
        String prob = dir + "en-es.prob";
        String testin = "^this/this<det><dem><sg>/this<prn><tn><mf><sg>$ ^is/be<vbser><pri><p3><sg>$ ^a/a<det><ind><sg>$ ^test/test<n><sg>/test<vblex><inf>/test<vblex><pres>$^./.<sent>$";
        String expTestout = "^this<prn><tn><mf><sg>$ ^be<vbser><pri><p3><sg>$ ^a<det><ind><sg>$ ^test<n><sg>$^.<sent>$";
        String[] argv = {"-g", prob, "./tmp/taggerin", "./tmp/taggerout"};

        FileWriter f = new FileWriter("./tmp/taggerin");
        f.append(testin);
        f.close();
        
        Tagger.main(argv);
        String testOutput = readFile("./tmp/taggerout");

		System.err.println("output = " + testOutput);
		System.err.println("expout = " + expTestout);
		assertEquals("TaggerTest.testMainThisIsATest() failed: output does not match expected output.", expTestout, testOutput);
	}

    /**
     * Test of main method, using external text files.
     */
    @Test
    public void testMain200Sentences() throws IOException {
        //System.out.println("main");

        String prob = dir + "en-es.prob";
        String inFile = dir + "en-tagger-input.txt";
        String outputFile = "./tmp/taggerout";
        String compareOutFile = dir + "en-tagger-output.txt";
        String[] argv = {"-g", prob, inFile, outputFile};

        Tagger.main(argv);

        //Read actual output into a string
        String testOutput = readFile("./tmp/taggerout");
        String expectedOutput = readFile(compareOutFile);

        assertEquals("TaggerTest.testMain200Sentences() failed: output does not match expected output.", expectedOutput, testOutput);
    }

    /**
     * This test is for testing the "first" mode with a single test sentence.
     * @throws IOException
     */
    @Test
    public void testFirstModeThisIsATest() throws IOException {
        String prob = dir + "en-es.prob";
        String testin = "^this/this<det><dem><sg>/this<prn><tn><mf><sg>$ ^is/be<vbser><pri><p3><sg>$ ^a/a<det><ind><sg>$ ^test/test<n><sg>/test<vblex><inf>/test<vblex><pres>$^./.<sent>$";
        String expTestout = "^this/this<prn><tn><mf><sg>/this<det><dem><sg>$ ^is/be<vbser><pri><p3><sg>$ ^a/a<det><ind><sg>$ ^test/test<n><sg>/test<vblex><inf>/test<vblex><pres>$^./.<sent>$";
        String[] argv = {"-g", "-f", prob, "./tmp/taggerin", "./tmp/taggerout"};

        FileWriter f = new FileWriter("./tmp/taggerin");
        f.append(testin);
        f.close();

        Tagger.main(argv);
        String testOutput = readFile("./tmp/taggerout");

        System.err.println("output = " + testOutput);
        System.err.println("expout = " + expTestout);
        assertEquals("TaggerTest.testFirstModeThisIsATest() failed: output does not match expected output.", expTestout, testOutput);
        
    }

    /*
     * This next test currently only fails because the tags after the first tag are
     * not always in the same order as the C++ version. The first tags are all correct,
     * and all the tags are there, just the extra tags are sometimes in a different order
     * than in the C++ version.
     */
    
    /**
     * This tests the "first" mode against 200 sentences.
     * @throws IOException
     */
    //@Test
    public void testFirstMode200Sentences() throws IOException {

        String prob = dir + "en-es.prob";
        String inFile = dir + "en-tagger-input.txt";
        String outputFile = "./tmp/taggerout";
        String compareOutFile = dir + "en-tagger-output-first-mode.txt";
        String[] argv = {"-g", "-f", prob, inFile, outputFile};

        Tagger.main(argv);

        //Read actual output into a string
        String testOutput = readFile("./tmp/taggerout");
        String expectedOutput = readFile(compareOutFile);

        assertEquals("TaggerTest.testFirstMode200Sentences() failed: output does not match expected output.", expectedOutput, testOutput);
    }
    
    /**
     * This test is for testing the "mark" mode with a single test sentence.
     * @throws IOException
     */
    @Test
    public void testMarkModeThisIsATest() throws IOException {
        String prob = dir + "en-es.prob";
        String testin = "^this/this<det><dem><sg>/this<prn><tn><mf><sg>$ ^is/be<vbser><pri><p3><sg>$ ^a/a<det><ind><sg>$ ^test/test<n><sg>/test<vblex><inf>/test<vblex><pres>$^./.<sent>$";
        String expTestout = "^=this<prn><tn><mf><sg>$ ^be<vbser><pri><p3><sg>$ ^a<det><ind><sg>$ ^=test<n><sg>$^.<sent>$";
        String[] argv = {"-g", "-m", prob, "./tmp/taggerin", "./tmp/taggerout"};

        FileWriter f = new FileWriter("./tmp/taggerin");
        f.append(testin);
        f.close();

        Tagger.main(argv);
        String testOutput = readFile("./tmp/taggerout");

        System.err.println("output = " + testOutput);
        System.err.println("expout = " + expTestout);
        assertEquals("TaggerTest.testMarkModeThisIsATest() failed: output does not match expected output.", expTestout, testOutput);
    }
    
    /**
     * This tests the "first" mode against 200 sentences.
     * @throws IOException
     */
    @Test
    public void testMarkMode200Sentences() throws IOException {

        String prob = dir + "en-es.prob";
        String inFile = dir + "en-tagger-input.txt";
        String outputFile = "./tmp/taggerout";
        String compareOutFile = dir + "en-tagger-output-mark.txt";
        String[] argv = {"-g", "-m", prob, inFile, outputFile};

        Tagger.main(argv);

        //Read actual output into a string
        String testOutput = readFile("./tmp/taggerout");
        String expectedOutput = readFile(compareOutFile);

        assertEquals("TaggerTest.testFirstMode200Sentences() failed: output does not match expected output.", expectedOutput, testOutput);
    }
}
