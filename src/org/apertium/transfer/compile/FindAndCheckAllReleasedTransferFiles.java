/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.transfer.compile;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import org.apertium.lttoolbox.process.FSTProcessor;
import org.apertium.transfer.ApertiumTransfer;
import org.apertium.transfer.ApertiumTransferCompile;

/**
 *
 * @author Jacob Nordfalk
 */
public class FindAndCheckAllReleasedTransferFiles {

    public static void main(String[] args) throws Exception {
      //Process p = Runtime.getRuntime().exec(new String[] {"find", ".", "-name", "'*.t1x'"}, null, new File("/home/j/esperanto/apertium-svn/apertium/trunk"));
      Process p = Runtime.getRuntime().exec("find /home/j/esperanto/apertium-svn/apertium/trunk -name *.t1x");

      BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

      String file;
      int n=0;
      while ((file = br.readLine()) != null) try {
        System.err.println("\n============");
        String dir = "testdata/transfer/";
        String outFile = "/tmp/transfer-output-malgranda.txt"+n++;
        Process p2 = Runtime.getRuntime().exec("apertium-validate-transfer "+file);
        if (p2.waitFor()!=0) {
          System.err.println(file+" does not pass apertium-validate-transfer");
          continue;
        }

        ApertiumTransferCompile.main(new String[]{file, "/tmp/transfer.class"});
        Runtime.getRuntime().exec("apertium-preprocess-transfer "+file+" /tmp/transfer.bin"+n).waitFor();
        ApertiumTransfer.main(new String[]{"/tmp/transfer.class", "/tmp/transfer.bin"+n, dir+"en-eo.autobil.bin",
          dir+"transferinput-en-eo.t1x-malgranda.txt", outFile});

        Runtime.getRuntime().exec(new String[]{"apertium-transfer", file, "/tmp/transfer.bin"+n, dir+"en-eo.autobil.bin",
          dir+"transferinput-en-eo.t1x-malgranda.txt", outFile+".expect"}).waitFor();

      } catch (Exception e) {
        e.printStackTrace();
      }
  }




}
