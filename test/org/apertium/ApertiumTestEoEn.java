package org.apertium;

import static org.apertium.utils.IOUtils.addTrailingSlash;
import static org.apertium.utils.IOUtils.readFile;
import static org.apertium.utils.IOUtils.writeFile;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

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

/**
 * @author Stephen Tigner
 *
 */
public class ApertiumTestEoEn {
    String lingDataDir = "../apertium-eo-en/";
    String testDataDir = "testdata/full_pipeline/";
    String tempDir = addTrailingSlash(System.getProperty("java.io.tmpdir"));

    @Test
    public void testEnEo100() throws IOException {
        String inputFilename = testDataDir + "en-input-100.txt";
        String outputFilename = tempDir + "full_pipeline-en-eo-100-output.txt";
        String expOutputFilename = testDataDir + "en-eo-output-100.txt";
        runInputFileTest(inputFilename, outputFilename, expOutputFilename, "en-eo", 
                "testEnEo100");
    }
    
    private void runInputFileTest(String inputFilename, String outputFilename,
            String expOutputFilename, String direction, String testName) 
            throws IOException {
        String[] args = {"-d", lingDataDir, direction, inputFilename, outputFilename};
        ApertiumMain.main(args);
        String output = readFile(outputFilename);
        String expOut = readFile(expOutputFilename);
        assertEquals("ApertiumTestEoEn -- " + testName + " failed", expOut, output);
    }

    @Test
    public void testEnEoSingleSentence() throws IOException {
        String inputFilename = tempDir + "en-input.txt";
        String outputFilename = tempDir + "full_pipeline-en-eo-100-output.txt";
        writeFile(inputFilename, "     3.   Social anarchism is one of two different broad categories of anarchism, the other category being individualist anarchism.");
        String[] args = {"-d", lingDataDir, "en-eo", inputFilename, outputFilename};
        ApertiumMain.main(args);
        String output = readFile(outputFilename);
        String expOut = "     3.    Socia anarkiismo estas unu el du malsamaj larĝaj kategorioj de anarkiismo, la alia kategorio estanta individuisma anarkiismo.";
        assertEquals("ApertiumTestEoEn -- testEnEoSingleSentence failed", expOut, output);
    }
    
    @Test
    public void testEoEn2Sentences() throws IOException {
        String inputFilename = testDataDir + "eo-input-2.txt";
        String outputFilename = tempDir + "full_pipeline-eo-en-2-output.txt";
        String expOutputFilename = testDataDir + "eo-en-output-2.txt";
        runInputFileTest(inputFilename, outputFilename, expOutputFilename, "eo-en", 
                "testEoEn2Sentences");
    }
}
