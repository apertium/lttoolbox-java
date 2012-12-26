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

import static org.apertium.utils.IOUtils.readFile;
import static org.junit.Assert.*;

import org.junit.Test;
import java.io.*;

/**
 *
 * @author nordfalk
 */
public class TaggerTestEnEo {
  private String dir = TaggerTest.dir;

  /**
   * Test of main method, of class Tagger.
   * This test also covers find_similar_ambiguity_class in HMM.java, via the code piece:
   * if (output.has_not(tags)) {
   * if (debug) {
   * String errors;
   * errors = "A new ambiguity class was found. \n";
   * errors += "Retraining the tagger is neccessary to take it into account.\n";
   * errors += "Word '" + word.get_superficial_form() + "'.\n";
   * errors += "New ambiguity class: " + word.get_string_tags() + "\n";
   * System.err.print(errors);
   * }
   * tags = find_similar_ambiguity_class(tags);
   * }
   *
   */
  @Test
  public void testEnEoOneBut() throws IOException {
    String prob = dir + "en-eo.prob";

    String testin = "^one/one<num><sg>/one<prn><tn><mf><sg>$ ^but/but<cnjcoo>/but<pr>$";
    String expTestout = "^one<num><sg>$ ^but<pr>$";
    String[] argv = {"-g", prob, "./tmp/taggerin", "./tmp/taggerout"};

    FileWriter f = new FileWriter("./tmp/taggerin");
    f.append(testin);
    f.close();

    Tagger.main(argv);
    String testOutput = readFile("./tmp/taggerout");

    System.err.println("output = " + testOutput);
    System.err.println("expout = " + expTestout);
    assertEquals("TaggerTestEnEo.testEnEoOneBut() failed: output does not match expected output.", expTestout, testOutput);

    //fail("Great, it works! Now, enable testEnEo200Sentences() as well");
  }

  /**
   * This test also covers find_similar_ambiguity_class
   */
  @Test
  public void testEnEo200Sentences() throws IOException {

    String prob = dir + "en-eo.prob";
    String inFile = dir + "en-tagger-input.txt";
    String outputFile = "./tmp/taggerout-eo";
    String compareOutFile = dir + "en-eo-tagger-output.txt";
    String[] argv = {"-g", prob, inFile, outputFile};

    Tagger.main(argv);

    //Read actual output into a string
    String testOutput = readFile(outputFile);
    String expectedOutput = readFile(compareOutFile);

    assertEquals("TaggerTestEnEo.testEnEo200Sentences() failed: output does not match expected output.", expectedOutput, testOutput);
  }
}
