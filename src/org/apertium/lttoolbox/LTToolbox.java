/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.lttoolbox;

import java.util.Arrays;

/**
 *
 * @author Jacob Nordfalk
 */
public class LTToolbox {

    public static final String PACKAGE_VERSION = "3.2j";

    static void showHelp(String invocationCommand) {
      String bareCommand = "";
      if (invocationCommand == null) {
        String jar = System.getProperty("java.class.path");
        if (jar.contains(":") || !jar.endsWith("lttoolbox.jar")) jar = "lttoolbox.jar";
        bareCommand = "java -jar " +jar;
        invocationCommand = bareCommand +" [task]";
      }
      /*
      System.out.println(System.getProperty("java.class.path"));
      System.out.println(System.getProperties());
      System.out.println(System.getenv());
      System.out.println(LTToolbox.class.getResource("/x"));
      System.out.println(LTToolbox.class.getResource("."));
       */
        System.err.println("lttoolbox: a toolbox for lexical processing, morphological analysis and generation of words\n" +
            "USAGE: "+invocationCommand+"\n" +
            "Examples:\n" +
            " " +bareCommand+ " lt-expand dictionary.dix     expand a dictionary\n" +
            " " +bareCommand+ " lt-comp lr dic.dix dic.bin   compile a dictionary\n" +
            " " +bareCommand+ " lt-proc dic.bin              morphological analysis/generation\n" +
            " " +bareCommand+ " lt-validate -dix dic.dix     validate a  dictionary\n" +
//            "For more help, run without a task, like: " +bareCommand+ "\n" +
            "For more help on a task, run it, like: " +bareCommand+ " lt-proc\n" +
            "See also http://wiki.apertium.org/wiki/Lttoolbox-java");
        System.exit(-1);
    }

  public static void main(String[] argv) throws Exception {
    if (argv.length == 0) showHelp(null);
      String task = argv[0];

      // strip evt path
      int n = task.lastIndexOf('/');
      if (n>=0) task = task.substring(n+1);

      String[] restOfArgs = Arrays.copyOfRange(argv, 1 , argv.length);
      if (task.startsWith("lt-proc")) LTProc.main(restOfArgs);
      else if (task.startsWith("lt-expand")) LTExpand.main(restOfArgs);
      else if (task.startsWith("lt-comp")) LTComp.main(restOfArgs);
      else if (task.startsWith("lt-validate")) LTValidate.main(restOfArgs);
      else {
        System.err.println("Command not recognized: "+task); // Arrays.toString(argv).replaceAll(", ", " ")
        showHelp(null);
      }
    }

}
