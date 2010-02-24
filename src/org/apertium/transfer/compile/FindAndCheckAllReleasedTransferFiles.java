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
import java.util.ArrayList;
import java.util.Arrays;
import org.apertium.lttoolbox.process.FSTProcessor;
import org.apertium.transfer.ApertiumTransfer;
import org.apertium.transfer.ApertiumTransferCompile;

/**
 *
 * @author Jacob Nordfalk
 */
public class FindAndCheckAllReleasedTransferFiles {

  static String datadir = "/home/j/esperanto/apertium-svn/apertium/trunk";

static String[] transferFilesWithDifferences = {
"apertium-nn-nb/apertium-nn-nb.nn-nb.t1x",
"apertium-cy-en/apertium-cy-en.en-cy.t1x",
"apertium-cy-en/apertium-cy-en.cy-en.t1x",
"apertium-en-ca/apertium-en-ca.en-ca.t1x",
"apertium-es-ast/apertium-es-ast.es-ast.t1x",
};

  public static String[] findAlllTransferFilesOnDisk() throws IOException {
    ArrayList<String> transerFiles = new ArrayList<String>();
    Process pf=Runtime.getRuntime().exec(new String[] {"find", ".", "-name", "*.t1x"}, null, new File(datadir));
    BufferedReader br=new BufferedReader(new InputStreamReader(pf.getInputStream()));
    String t1xFile;
    while ((t1xFile=br.readLine())!=null) {
      if (t1xFile.startsWith("./")) t1xFile = t1xFile.substring(2); // strip ./
      transerFiles.add(t1xFile);
    }

    return transerFiles.toArray(new String[transerFiles.size()]);
  }




    public static void main(String[] args) throws Exception {
      String testdir = "testdata/transfer/";
      String inputFile = testdir+"transferinput-en-eo.t1x-malgranda.txt";
      //String inputFile = testdir+"transferinput-en-eo.t1x.txt";

      //String[] transferFiles = transferFilesWithDifferences;
      String[] transferFiles = findAlllTransferFilesOnDisk();
      //printFilesAsJavaArray(transferFiles);


      ArrayList<String> doesentValidate = new ArrayList<String>();
      ArrayList<String> interpretedTranferFails = new ArrayList<String>();
      ArrayList<String> compiledTranferFails = new ArrayList<String>();
      ArrayList<String> tranferCompareOK = new ArrayList<String>();
      ArrayList<String> tranferCompareFail = new ArrayList<String>();



      for (String relFile : transferFiles) try {
        System.err.println("\n============");
        String absFile = datadir + File.separator + relFile;
        String relFileWOSufffix = relFile.substring(0,relFile.lastIndexOf('.'));
        String rootDir = "/tmp/transfertest/";
        new File(rootDir+"/res/"+relFile).getParentFile().mkdirs();
        String resFileWOSufffix = rootDir+"/res/"+relFileWOSufffix;
        new File(rootDir+"/actual/"+relFile).getParentFile().mkdirs();
        new File(rootDir+"/expected/"+relFile).getParentFile().mkdirs();
        int ret = exec("apertium-validate-transfer "+absFile);
        if (ret!=0) {
//          System.err.println(t1xFile+" does not pass apertium-validate-transfer");
          System.err.println("ERROR: "+absFile+"\ndoes not pass apertium-validate-transfer. Skipping...");
          doesentValidate.add(relFile);
          continue;
        }

        ApertiumTransferCompile.main(new String[]{absFile, resFileWOSufffix+".class"});
        exec("apertium-preprocess-transfer "+absFile+" "+resFileWOSufffix+".bin");


        exec("cp "+absFile+" "+new File(rootDir+"/res/"+relFile).getParent());


        long time = System.currentTimeMillis();
        ret = exec(new String[]{"apertium-transfer", absFile, resFileWOSufffix+".bin", testdir+"en-eo.autobil.bin",
          inputFile, rootDir+"/expected/"+relFileWOSufffix+".txt"});

        if (ret!=0) interpretedTranferFails.add(relFile);


        long interpretedTime = System.currentTimeMillis()-time;
        System.err.println("Interpreted transfer took " + (interpretedTime/10)*0.01+" secs");
        time = System.currentTimeMillis();

        try {
        ApertiumTransfer.main(new String[]{resFileWOSufffix+".class", resFileWOSufffix+".bin", testdir+"en-eo.autobil.bin",
          inputFile, rootDir+"/actual/"+relFileWOSufffix+".txt"});
        } catch (Exception e) {
          e.printStackTrace();
          compiledTranferFails.add(relFile);
          ret = -1;
        }

        long bytecodeCompiledTime = System.currentTimeMillis()-time;
        System.err.println("bytecode compiled transfer took " + (bytecodeCompiledTime/10)*0.01+" secs");

        if (ret!=0) {
          System.err.println("(transfer failed so not comparing)");
        } else {
          System.err.println("Speedup factor: " + (100*interpretedTime/bytecodeCompiledTime)/100.0);
          ret = exec("diff -q "+rootDir+"/expected/"+relFileWOSufffix+".txt "+rootDir+"/actual/"+relFileWOSufffix+".txt");
          if (ret==0) {
            System.err.println("OK: Output of interpreted and bytecode compiled transfer is exactly the same");
            tranferCompareOK.add(relFile);

          } else {
            System.err.println("FAIL: Output of interpreted and bytecode compiled transfer HAS DIFFERENCES");
            tranferCompareFail.add(relFile);
          }
        }

        /*
        ApertiumTransfer.main(new String[]{resFileWOSufffix+".class", resFileWOSufffix+".bin", testdir+"en-eo.autobil.bin",
          testdir+"transferinput-en-eo.t1x-malgranda.txt"});
//        ApertiumTransfer.main(new String[]{resFileWOSufffix+".class", resFileWOSufffix+".bin", testdir+"en-eo.autobil.bin",
//          testdir+"transferinput-en-eo.t1x-malgranda.txt"});
*/
      } catch (Exception e) {
        e.printStackTrace();
      }

      print("doesentValidate", doesentValidate);
      print("interpretedTranferFails", interpretedTranferFails);
      print("compiledTranferFails", compiledTranferFails);
      print("tranferCompareOK", tranferCompareOK);
      print("tranferCompareFail",tranferCompareFail );

    }

  public static void printFilesAsJavaArray(String[] transferFiles) {
    System.out.println("static String[] transferFiles = {");
    for (String relFile : transferFiles) {
      System.out.println("\""+relFile+"\",");
    }
    System.out.println("};");
  }

  private static int exec(String[] cmd) throws Exception {
    //System.err.println("exec: " + Arrays.toString(cmd));
      Process p = Runtime.getRuntime().exec(cmd);
    BufferedReader br=new BufferedReader(new InputStreamReader(p.getErrorStream()));
    String s=br.readLine();
    if (s!=null) {
      System.err.println(s);
      p.destroy();
      return -1;
    }
      int ret = p.waitFor();
   // System.err.println("exec finish");
      p.getErrorStream().close();
      p.getInputStream().close();
      p.getOutputStream().close();
      return ret;
  }

  private static int exec(String cmd) throws Exception {
    return exec(cmd.split(" "));
/*
    System.err.println("exec: " + cmd);
    Process p = Runtime.getRuntime().exec(cmd);
    BufferedReader br=new BufferedReader(new InputStreamReader(p.getErrorStream()));
    String s=br.readLine();
    if (s!=null) {
      System.err.println(s);
      p.destroy();
    }
      int ret = p.waitFor();
    System.err.println("exec finish");

 p.getErrorStream().close();
      p.getInputStream().close();
      p.getOutputStream().close();
      return ret;
*/
  }

  private static void print(String string, ArrayList<String> doesentValidate) {
    System.err.println(string+" "+doesentValidate.size()+": "+doesentValidate);
  }



}
