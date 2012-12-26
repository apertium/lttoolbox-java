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
import org.apertium.transfer.old.development.FindAndCompareAllReleasedTransferFiles;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.apertium.lttoolbox.TestTools.*;

/**
 * This is for testing apertium-transfer -n command. Its NOT READY
 *
 * @author Jacob Nordfalk
 */
public class TransferEnEo_minusN {
  String dir = "testdata/transfer/";

  @Test
  public void testTransfer1Prase() throws Exception {
    Transfer t = new Transfer();
    Class transferClass = org.apertium.transfer.old.generated.apertium_eo_en_en_eo_genitive_t1x.class;
    t.setUseBilingual(false);

    t.read(transferClass, dir + "en-eo.genitive.t1x.bin", null);
    t.transferObject.debug = true;

    StringReader input = new StringReader("^'<apos>$^Paris<np><ant><f><sg>$ ^'<gen>$ ^blue<adj>$ ^cat<n><pl>$ ^'<gen>$\n");
    Writer output = new StringWriter();
    t.process(input, output);

    String exp = "[']^Paris<np><ant><f><sg>$ ^'<gen>$ ^blue<adj>$ ^cat<n><pl>$[']\n";

    System.err.println("exp = " + output.toString());

    System.err.println("exp = " + exp);
    assertEquals(exp, output.toString());

  }
}