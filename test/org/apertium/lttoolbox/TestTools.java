/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.lttoolbox;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Jacob Nordfalk
 */
public class TestTools {

  public static String rm(String filename) {
    File f = new File(filename);
    if (f.isDirectory()) for (File f2 : f.listFiles()) rm(f2.getPath());
    f.delete();
    return filename;
  }




  public static String exec(String cmd) throws IOException, InterruptedException, IOException {
    Process p=Runtime.getRuntime().exec(cmd);
    String output="";
    String s;
    BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
    while ((s=br.readLine())!=null)  output=output+s+"\n";
    br=new BufferedReader(new InputStreamReader(p.getErrorStream()));
    while ((s=br.readLine())!=null)  output=output+s+"\n";
    //p.waitFor();
    //if (p.exitValue()!=0) Assert.fail(cmd+" reported an error");

    /*
    if (output.length()>0) {
      System.err.println("exec: " + cmd);
      System.err.println("output: " + output);
      return cmd+"\n"+output;
    }*/
    return output;
  }


  public static Process exep(String dir, String cmd) throws IOException, InterruptedException {

    File wd=new File(dir);

    Process p=Runtime.getRuntime().exec(cmd, null, wd);

    class Print extends Thread {

      BufferedReader br;

      private Print(InputStream errorStream) {
        br=new BufferedReader(new InputStreamReader(errorStream));
        start();
      }

      public void run() {
        try {
          String s;
          while ((s=br.readLine())!=null) {
            System.err.println(s);
          }
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    }
    new Print(p.getInputStream());
    new Print(p.getErrorStream());
    p.waitFor();

    return p;
  }

}
