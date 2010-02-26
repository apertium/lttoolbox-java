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
 *
 * @author Jacob Nordfalk
 */
public class TransferEoEnTest {

    String folder = "testdata/transfer/";
    String dir = "eo-en";
    String tlx = "eo-en."+dir+".t1x";
    
    String outFile = "transferoutput-"+dir+".t1x-malgranda.txt";
    String t1xFile = folder+"apertium-"+tlx;
    String binFile = folder+dir+".t1x.bin";

  @Test
  public void testTransferMalgranda() throws Exception {
      Transfer t = new Transfer();
      //Class transferClass = org.apertium.transfer.generated.apertium_eo_en_en_eo_t1x.class;
      Class transferClass = Class.forName("org.apertium.transfer.generated.apertium_"+tlx.replaceAll("[-\\.]", "_"));
      t.read(transferClass, folder+dir+".t1x.bin", folder+"en-eo.autobil.bin");
      Reader input = new FileReader(folder+"transferinput-en-eo.t1x-malgranda.txt");
      Writer output = new FileWriter("/tmp/"+outFile);
      t.transfer( input, output);
      output.close();
      assertEquals("Difference", "", exec("diff "+folder+outFile+" /tmp/"+outFile));
      rm(outFile);
  }


  @Test
  public void testTransferAndCompilationMalgranda() throws Exception {
    ApertiumTransferCompile.main(new String[]{t1xFile, "/tmp/t1x.bin.class"});

    /////////////////////////////
    //
    // NOTE:  You *need* dist/lttoolbox.jar  , so do a full rebuiild if this test fails
    //
    ///////////////////////////
    ApertiumTransfer.main(new String[]{"/tmp/t1x.bin.class", binFile, folder+"en-eo.autobil.bin", folder+"transferinput-en-eo.t1x-malgranda.txt", "/tmp/"+outFile});

    assertEquals("Difference", "", exec("diff "+folder+outFile+" /tmp/"+outFile));
    rm(outFile);
  }


  @Test
  public void testInterpretedTransferMalgranda() throws Exception {
    FindAndCompareAllReleasedTransferFiles.exec("apertium-transfer", t1xFile, binFile, folder+"en-eo.autobil.bin", folder+"transferinput-en-eo.t1x-malgranda.txt", "/tmp/"+outFile);
    assertEquals("Difference", "", exec("diff "+folder+outFile+" /tmp/"+outFile));
    rm(outFile);
  }

}