/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.transfer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import org.apertium.transfer.development.FindAndCompareAllReleasedTransferFiles;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.apertium.lttoolbox.TestTools.*;

/**
 * This is for testing apertium-transfer -n command
 * @author Jacob Nordfalk
 */
public class TransferEnEo_minusN {

    String dir = "testdata/transfer/";

  @Test
  public void testTransfer1Prase() throws Exception {
      Transfer t = new Transfer();

      Class transferClass = org.apertium.transfer.generated.apertium_eo_en_en_eo_genitive_t1x.class;
      t.read(transferClass, dir+"en-eo.genitive.t1x.bin", dir+"en-eo.autobil.bin");
      t.transferObject.debug = true;

      StringReader input = new StringReader("^Prpers<prn><subj><p3><m><sg>$  \\$^see<vblex><past>$ ^the<det><def><sp>$ ^saw<n><sg>$^'s<gen>$ ^tooth<n><sg>$   ^.<sent>$\n");
      Writer output = new StringWriter();
      t.transfer( input, output);

     assertEquals("^prnpers<SN><nom>{^Prpers<prn><p3><m><sg><2>$}$  \\$^verb_all<SV><aliaj><past>{^vidi<vblex><3>$}$ ^det_nom_gen_det_nom<SN><nom>{^la<det><def><sp>$ ^dento<n><sg><2>$ ^de<gen>$ ^la<det><def><sg><nom>$ ^segilo<n><sg><nom>$}$   ^sent<S>{^.<sent>$}$\n", output.toString());
  }

  @Test
  public void testTransferMalgranda_en_eo() throws Exception {
      Transfer t = new Transfer();
      Class transferClass = org.apertium.transfer.generated.apertium_eo_en_en_eo_t1x.class;
      t.read(transferClass, dir+"en-eo.t1x.bin", dir+"en-eo.autobil.bin");
      Reader input = new FileReader(dir+"transferinput-en-eo.t1x-malgranda.txt");
      String outFile = "./tmp/transferoutput-en-eo.t1x-malgranda.txt";
      Writer output = new FileWriter(outFile);
      t.transfer( input, output);
      output.close();
      assertEquals("Difference", "", exec("diff "+dir+"transferoutput-en-eo.t1x-malgranda.txt "+outFile));
      rm(outFile);
  }



  @Test
  public void testInterpretedTransferMalgranda_en_eo() throws Exception {
    String outFile = "./tmp/transferoutput-en-eo.t1x-malgranda.txt";
    String t1xFile = dir+"apertium-eo-en.en-eo.t1x";
    String binFile = dir+"en-eo.t1x.bin";
    FindAndCompareAllReleasedTransferFiles.exec("apertium-transfer", t1xFile, binFile, dir+"en-eo.autobil.bin", dir+"transferinput-en-eo.t1x-malgranda.txt", outFile);
    assertEquals("Difference", "", exec("diff "+dir+"transferoutput-en-eo.t1x-malgranda.txt "+outFile));
    rm(outFile);
  }


}