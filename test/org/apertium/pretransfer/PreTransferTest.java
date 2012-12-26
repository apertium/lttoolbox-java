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
import static org.apertium.utils.IOUtils.readFile;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * @author Stephen
 *
 */
public class PreTransferTest {
  String dir = "testdata/pretransfer/";

  /**
   * Test method for {@link org.apertium.pretransfer.PreTransfer#main(java.lang.String[])}.
   * pretransfer takes the output from the tagger as its input and outputs to transfer.
   * This tests pretransfer with a single constructed sample sentence: That
   * ^this<prn><tn><mf><sg>+be<vbser><pri><p3><sg>$ will become
   * ^this<prn><tn><mf><sg>$ ^be<vbser><pri><p3><sg>$
   */
  @Test
  public void testMainThisIsATest() throws IOException {
    String testin = "^this<prn><tn><mf><sg>+be<vbser><pri><p3><sg>$ ^a<det><ind><sg>$ ^test<n><sg>$^.<sent>$";
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
