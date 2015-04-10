package org.apertium.pipeline;

import org.apertium.pipeline.ApertiumMain;
import static org.apertium.utils.IOUtils.addTrailingSlash;
import static org.apertium.utils.IOUtils.readFile;
import static org.apertium.utils.IOUtils.writeFile;
import static org.apertium.utils.IOUtils.openFile;
import static org.junit.Assert.*;

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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
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
public class ApertiumEoEnTest {
  String lingDataDir = "../apertium-eo-en/";
  String testDataDir = "testdata/pipeline/";
  String tempDir = addTrailingSlash(System.getProperty("java.io.tmpdir"));

  @Test
  public void testEnEo100() throws Exception {
    String inputFilename = testDataDir + "en-input-100.txt";
    String outputFilename = tempDir + "full_pipeline-en-eo-100-output.txt";
    String expOutputFilename = testDataDir + "en-eo-output-100.txt";
    runInputFileTest(inputFilename, outputFilename, expOutputFilename, "en-eo", "testEnEo100");
  }

  /*
   * @Test
   * public void testEnEo20000() throws IOException {
   * String inputFilename = lingDataDir + "corpa/en.crp.txt";
   * String outputFilename = tempDir + "full_pipeline-en-eo-20000-output.txt";
   * String expOutputFilename = testDataDir + "en-eo-output-2000.txt";
   * runInputFileTest(inputFilename, outputFilename, expOutputFilename, "en-eo", "testEnEo20000");
   * }
   */
  private void runInputFileTest(String inputFilename, String outputFilename,
      String expOutputFilename, String direction, String testName)
      throws Exception {
    // skip test if directory or some of the files don't exist
    if (!openFile(lingDataDir).exists())
      return;
    if (!openFile(inputFilename).exists())
      return;
    if (!openFile(expOutputFilename).exists())
      return;
    String[] args = {"-d", lingDataDir, direction, inputFilename, outputFilename};
    ApertiumMain.main(args);
    String output = readFile(outputFilename);
    String expOut = readFile(expOutputFilename);
    assertEquals(testName + " difference in "+outputFilename+" compared to expected "+expOutputFilename, expOut, output);
  }

  /**
   * This tests a feature in interchunk: the special <clip part="contents"/> part.
   *
   * @throws Exception
   */
  @Test
  public void testEnEoSingleSentence() throws Exception {
    assertTrue(lingDataDir + " must exist", openFile(lingDataDir).exists());

    String inputFilename = tempDir + "en-input.txt";
    String outputFilename = tempDir + "full_pipeline-en-eo-100-output.txt";
    writeFile(inputFilename, "two different  categories");
    String[] args = {"-d", lingDataDir, "en-eo", inputFilename, outputFilename};
    ApertiumMain.main(args);
    String output = readFile(outputFilename);
    String expOut = "du malsamaj  kategorioj";
    assertEquals("ApertiumTestEoEn -- testEnEoSingleSentence failed", expOut, output);
  }

  /**
   * There was a problem with brackets
   * < 2496.	La israela ambasadoro al Angolo estas *Avraham Benjamin.[1] En 2005, Prezidanto José Eduardo *dos Santos vizitis Israelon.
   * ---
   * > 2496.	La israela ambasadoro al Angolo estas *Avraham Benjamin[.1] En 2005, Prezidanto José Eduardo *dos Santos vizitis Israelon.
   * 6111c6111
   * That issue has now been resolved, leaving test in here for verification purposes
   *
   * @throws Exception
   */
  @Test
  public void testEnEoSingleSentence2() throws Exception {
    assertTrue(lingDataDir + " must exist", openFile(lingDataDir).exists());

    String inputFilename = tempDir + "en-input.txt";
    String outputFilename = tempDir + "full_pipeline-en-eo-100-output.txt";
    writeFile(inputFilename, "Avraham Benjamin.[1] In 2005");
    String[] args = {"-d", lingDataDir, "en-eo", inputFilename, outputFilename};
    ApertiumMain.main(args);
    String output = readFile(outputFilename);
    String expOut = "*Avraham Benjamin.[1] En 2005";
    assertEquals("ApertiumTestEoEn -- testEnEoSingleSentence failed", expOut, output);
  }

  @Test
  public void testEoEn2Sentences() throws Exception {
    String inputFilename = testDataDir + "eo-input-2.txt";
    String outputFilename = tempDir + "full_pipeline-eo-en-2-output.txt";
    String expOutputFilename = testDataDir + "eo-en-output-2.txt";
    runInputFileTest(inputFilename, outputFilename, expOutputFilename, "eo-en", "testEoEn2Sentences");
  }
}
