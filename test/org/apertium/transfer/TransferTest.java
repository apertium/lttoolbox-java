/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.transfer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.apertium.lttoolbox.TestTools.*;

/**
 *
 * @author Jacob Nordfalk
 */
public class TransferTest {

    public TransferTest() {
    }

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }



  @Test
  public void testTransfer1Prase() throws Exception {
      Transfer t = new Transfer();
      String dir = "testdata/transfer/";

      Class transferClass =
       Class.forName("org.apertium.transfer.generated.apertium_eo_en_en_eo_t1x");


      t.read(transferClass, dir+"en-eo.t1x.bin", dir+"en-eo.autobil.bin");

      StringReader input = new StringReader("^Prpers<prn><subj><p3><m><sg>$ ^see<vblex><past>$ ^the<det><def><sp>$ ^saw<n><sg>$^'s<gen>$ ^tooth<n><sg>$   ^.<sent>$\n");
      Writer output = new StringWriter();
      t.transfer( input, output);

     assertEquals("^prnpers<SN><nom>{^Prpers<prn><p3><m><sg><2>$}$ ^verb_all<SV><aliaj><past>{^vidi<vblex><3>$}$ ^det_nom_gen_det_nom<SN><nom>{^la<det><def><sp>$ ^dento<n><sg><2>$ ^de<gen>$ ^la<det><def><sg><nom>$ ^segilo<n><sg><nom>$}$   ^sent<S>{^.<sent>$}$\n", output.toString());
  }

  @Test
  public void testTransferMalgranda() throws Exception {
      Transfer t = new Transfer();
      String dir = "testdata/transfer/";

      Class transferClass =
       Class.forName("org.apertium.transfer.generated.apertium_eo_en_en_eo_t1x");


      t.read(transferClass, dir+"en-eo.t1x.bin", dir+"en-eo.autobil.bin");

      Reader input = new FileReader(dir+"transferinput-en-eo.t1x-malgranda.txt");
      //StringReader input = new StringReader("^Prpers<prn><subj><p3><m><sg>$ ^see<vblex><past>$ ^the<det><def><sp>$ ^saw<n><sg>$^'s<gen>$ ^tooth<n><sg>$   ^.<sent>$  \n");
      //Writer output = new StringWriter(); //new PrintWriter(System.err); //
      //Writer output = new OutputStreamWriter(System.out);
      String outFile = "/tmp/transfer-output-malgranda.txt";
      Writer output = new FileWriter(outFile);
      t.transfer( input, output);
      output.close();

     assertEquals("Difference", "", exec("diff "+dir+"transferoutput-en-eo.t1x-malgranda.txt "+outFile));
     rm(outFile);
  }

  @Test
  public void testTransferAndCompilationMalgranda() throws Exception {
    String dir = "testdata/transfer/";
    String outFile = "/tmp/transfer-output-malgranda.txt";
    ApertiumTransferCompile.main(new String[]{"testdata/transfer/apertium-eo-en.en-eo.t1x", "/tmp/en-eo.t1x.bin.class"});

    /////////////////////////////
    //
    // NOTE:  You *need* dist/lttoolbox.jar  , so do a full rebuiild if this test fails
    //
    ///////////////////////////

    ApertiumTransfer.main(new String[]{"/tmp/en-eo.t1x.bin.class", dir+"en-eo.t1x.bin", dir+"en-eo.autobil.bin",
      dir+"transferinput-en-eo.t1x-malgranda.txt", outFile});

     assertEquals("Difference", "", exec("diff "+dir+"transferoutput-en-eo.t1x-malgranda.txt "+outFile));
     rm(outFile);
  }


/*
  @Test
  public void testTransferGranda() throws Exception {
      Transfer t = new Transfer();
      String dir = "testdata/transfer/";

      Class transferClass =
       Class.forName("org.apertium.transfer.generated.apertium_eo_en_en_eo_t1x");


      t.read(transferClass, dir+"en-eo.t1x.bin", dir+"en-eo.autobil.bin");

      Reader input = new FileReader(dir+"transferinput-en-eo.t1x.txt");
      String outFile = "/tmp/transfer-output.txt";
      Writer output = new FileWriter(outFile);
      t.transfer( input, output);
      output.close();

     assertEquals("Difference", "", exec("diff "+dir+"transferoutput-en-eo.t1x.txt "+outFile));
     rm(outFile);
  }
*/
}