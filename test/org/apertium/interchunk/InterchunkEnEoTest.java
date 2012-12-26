/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.interchunk;

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
public class InterchunkEnEoTest {
  String dir = "testdata/interchunk/";

  @Test
  public void testInterchunk1Prase() throws Exception {
    Interchunk t = new Interchunk();

    // apertium-preprocess-transfer apertium-eo-en.en-eo.t2x en-eo.t2x.bin
    Class transferClass = org.apertium.transfer.old.generated.apertium_eo_en_en_eo_t2x.class;
    //t.DEBUG = true;
    t.read(transferClass, dir + "en-eo.t2x.bin");
    t.transferObject.debug = true;

    // do you know the cat?
    String inp = "^vbdo<SV><aliaj><pres>{^fari<vblex><3>$}$ ^prnpers<SN><sp><nom>{^prpers<prn><p2><mf><sp><3>$}$ ^verb_all<SV><aliaj><pres>{^scii<vblex><3>$}$ ^det_nom<SN><sg><nom>{^la<det><def><sg><3>$ ^kato<n><sg><3>$}$^sent<S>{^?<sent>$}$\n";
    String exp = "^ĉu<adv><itg>{^ĉu<adv><itg>$}$ ^prnpers<SN><sp><nom>{^prpers<prn><p2><mf><sp><3>$}$ ^verb_all<SV><aliaj><pres>{^scii<vblex><3>$}$ ^det_nom<SN><sg><nom>{^la<det><def><sg><3>$ ^kato<n><sg><3>$}$^sent<S>{^?<sent>$}$\n";
    StringReader input = new StringReader(inp);
    Writer output = new StringWriter();
    t.process(input, output);

    String out = output.toString();

    System.err.println("out = " + out);

    System.err.println("exp = " + exp);
    assertEquals(exp, out);
  }

  /*
   * @Test
   * public void testTransferAndCompilationMalgranda_en_eo() throws Exception {
   * String outFile = "./tmp/transferoutput-en-eo.t1x-malgranda.txt";
   * String t1xFile = dir+"apertium-eo-en.en-eo.t1x";
   * String binFile = dir+"en-eo.t1x.bin";
   *
   * /////////////////////////////
   * //
   * // NOTE: You *need* dist/lttoolbox.jar , so do a full rebuiild if this test fails
   * //
   * ///////////////////////////
   * ApertiumTransferCompile.main(new String[]{t1xFile, "./tmp/t1x.bin.class"});
   *
   *
   * ApertiumTransfer.main(new String[]{"./tmp/t1x.bin.class", binFile, dir+"en-eo.autobil.bin", dir+"transferinput-en-eo.t1x-malgranda.txt", outFile});
   *
   * assertEquals("Difference", "", exec("diff "+dir+"transferoutput-en-eo.t1x-malgranda.txt "+outFile));
   * rm(outFile);
   * }
   *
   *
   * @Test
   * public void testInterpretedTransferMalgranda_en_eo() throws Exception {
   * String outFile = "./tmp/transferoutput-en-eo.t1x-malgranda.txt";
   * String t1xFile = dir+"apertium-eo-en.en-eo.t1x";
   * String binFile = dir+"en-eo.t1x.bin";
   * FindAndCompareAllReleasedTransferFiles.exec("apertium-transfer", t1xFile, binFile, dir+"en-eo.autobil.bin", dir+"transferinput-en-eo.t1x-malgranda.txt", outFile);
   * assertEquals("Difference", "", exec("diff "+dir+"transferoutput-en-eo.t1x-malgranda.txt "+outFile));
   * rm(outFile);
   * }
   */
}