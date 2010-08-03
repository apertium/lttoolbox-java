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

package org.apertium.interchunk;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apertium.pretransfer.PreTransfer;
import org.apertium.transfer.compile.ApertiumTransferCompile;
import org.junit.Test;


/**
 * @author Stephen Tigner
 *
 */
public class TestInterchunk {
    
    static String testDataDir = "testdata/interchunk/";
    static String tempDir = "./tmp/";

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
    
    //@Test
    public void testInterchunkCompile() throws Exception {
        /* This method was setup to be able to more easily debug the transfer compile.
         * Can be launched to try and compile a t2x file and then step through it to see
         * where things are going wrong.
         */
        String inFile = testDataDir + "apertium-en-es.en-es.t2x";
        String outFile = tempDir + "apertium_en_es_en_es_t2x.class";
        
        String args[] = {inFile, outFile};
        
        ApertiumTransferCompile.main(args);
    }
    
    /**
     * Test method for {@link org.apertium.interchunk.Interchunk#main(java.lang.String[])}.
     * Interchunk takes the output from transfer as its input and outputs to postchunk.
     * This tests Interchunk with a single constructed sample sentence.
     */
    @Test
    public void testMainThisIsATest() throws IOException {
        String testin = "^Prn<SN><tn><m><sp>{^esto<prn><tn><3><4>$}$ ^be<Vcop><vbser><pri><p3><sg>{^ser<vbser><3><4><5>$}$ ^det_nom<SN><DET><f><sg>{^uno<det><ind><3><4>$ ^prueba<n><3><4>$}$^punt<sent>{^.<sent>$}$";
        String expTestout = "^Prn<SN><tn><m><sp>{^esto<prn><tn><3><4>$}$ ^be<Vcop><vbser><pri><p3><sg>{^ser<vbser><3><4><5>$}$ ^det_nom<SN><DET><f><sg>{^uno<det><ind><3><4>$ ^prueba<n><3><4>$}$^punt<sent>{^.<sent>$}$";
        String inputFile = tempDir + "interchunkin";
        String outputFile = tempDir + "interchunkout";
        String t2xFile = testDataDir + "apertium_en_es_en_es_t2x.class";
        String preprocFile = testDataDir + "en-es.t2x.bin";
        String[] argv = {t2xFile, preprocFile, inputFile, outputFile};

        FileWriter f = new FileWriter(inputFile);
        f.append(testin);
        f.close();
        
        ApertiumInterchunk.main(argv);
        String testOutput = readFile(outputFile);

        System.err.println("output = " + testOutput);
        System.err.println("expout = " + expTestout);
        assertEquals("TestInterchunk.testMainThisIsATest() failed: output does not match expected output.", expTestout, testOutput);
    }

}
