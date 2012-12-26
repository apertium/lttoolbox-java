/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.postchunk;

import org.apertium.interchunk.*;
import org.apertium.transfer.*;
import org.apertium.transfer.old.compile.ApertiumTransferCompile;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import org.apertium.transfer.old.development.FindAndCompareAllReleasedTransferFiles;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.apertium.lttoolbox.TestTools.*;

/**
 *
 * @author Jacob Nordfalk
 */
public class PostchunkEnEoTest {
  String dir = "testdata/postchunk/";

  // NOTE: Here the case of just one rule is tested. This actually fails.
  @Test
  public void testPostchunk1Prase() throws Exception {
    Postchunk t = new Postchunk();

    // apertium-preprocess-transfer apertium-eo-en.en-eo.t2x en-eo.t2x.bin
    Class transferClass = org.apertium.transfer.old.generated.apertium_eo_en_en_eo_t3x.class;
    //t.DEBUG = true;
    t.read(transferClass, dir + "en-eo.t3x.bin");

    // big cat
    String inp = "^preadv?_adj_nom<SN><sg><nom>{^granda<adj><2><3>$ ^kato<n><sg><3>$}$\n";
    String exp = "^granda<adj><sg><nom>$ ^kato<n><sg><nom>$\n";
    StringReader input = new StringReader(inp);
    Writer output = new StringWriter();
    t.process(input, output);

    String out = output.toString();

    System.err.println("out = " + out);

    System.err.println("exp = " + exp);
    assertEquals(exp, out);
  }
}