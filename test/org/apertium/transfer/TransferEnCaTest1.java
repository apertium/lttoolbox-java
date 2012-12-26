/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.transfer;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jacob Nordfalk
 */
public class TransferEnCaTest1 {
  String folder = "testdata/transfer/";
  String dir = "en-ca";
  String tlx = "en-ca." + dir + ".t1x";
  String outFile = "transferoutput-" + dir + ".t1x-malgranda.txt";
  String t1xFile = folder + "apertium-" + tlx;
  String binFile = folder + dir + ".t1x.bin";

  @Test
  public void testTransfer1Phrase() throws Exception {
    Transfer t = new Transfer();
    //Class transferClass = org.apertium.transfer.generated.apertium_eo_en_en_eo_t1x.class;
    Class transferClass = Class.forName("org.apertium.transfer.generated.apertium_" + tlx.replaceAll("[-\\.]", "_"));
    t.read(transferClass, folder + dir + ".t1x.bin", folder + "en-eo.autobil.bin");
    //Reader input = new StringReader("^Aruba<np><top><sg>$^'s<gen>$ ^educational<adj>$ ^system<n><sg>$^,<cm>$ ^*patterned$ ^after<pr>$ ^the<det><def><sp>$ ^Dutch<adj>$ ^system<n><sg>$^,<cm>$ ^provide<vblex><pres><p3><sg>$ ^for<pr>$ ^education<n><sg>$ ^at<pr>$ ^all<predet><sp>$ ^level<n><pl>$^.<sent>$\n");
    //String expect = "^nom<SN><UNDET><sg>{^Arubo<4>$}$^pr<GEN>{^de<gen>$}$ ^nom_adj<SN><UNDET><GD><sg>{^sistemo<n><4>$ ^eduka<adj><3><4>$}$^coma<cm>{^,<cm>$}$ ^unknown<unknown>{^*patterned$}$ ^pr<PREP>{^post<pr>$}$ ^det_nom_adj<SN><DET><GD><sg>{^la<det><def><3><4><sp>$ ^sistemo<n><4>$ ^nederlanda<adj><3><4>$}$^coma<cm>{^,<cm>$}$ ^default<default>{^provizi<vblex><pres><p3><sg>$}$ ^pr<PREP>{^por<pr>$}$ ^nom<SN><UNDET><sg>{^edukado<n><4>$}$ ^pr<PREP>{^ĉe<pr>$}$ ^det_det_nom1<SN><DET><GD><pl>{^ĉiuj<predet><3><4><sp>$ ^el<det><def><3><pl>$ ^nivelo<n><4>$}$^punt<sent>{^.<sent>$}$\n";
    Reader input = new StringReader("^all<predet><sp>$ ^level<n><pl>$\n");
    String expect = "^Det_det_nom1<SN><DET><GD><pl>{^ĉiuj<predet><3><4><sp>$ ^el<det><def><3><pl>$ ^nivelo<n><4>$}$\n";
    Writer output = new StringWriter();
    t.transferObject.debug = true;
    t.process(input, output);


    System.err.println("expect = " + expect);
    System.err.println("output = " + output);
    assertEquals(expect, output.toString());
  }
}