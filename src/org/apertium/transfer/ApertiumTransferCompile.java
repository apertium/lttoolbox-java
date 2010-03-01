package org.apertium.transfer;

/*
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 */

//import com.sun.tools.javac.Main;
import org.apertium.lttoolbox.*;
import org.apertium.lttoolbox.process.FSTProcessor;
import java.io.*;
import java.lang.reflect.Method;
import org.apertium.lttoolbox.process.State;
import org.apertium.transfer.compile.ParseTransferFile;
import static org.apertium.lttoolbox.LTProc.*;

/**
 * 
 * @author Raah
 */
public class ApertiumTransferCompile {


    static void endProgram(String name) {
        System.out.print(name + LTToolbox.PACKAGE_VERSION +": \n" +
"USAGE: "+name+" trules  trules-class\n" +
"  trules     transfer rule (.t1x) source file\n" +
"  trules-class  Java bytecode compiled transfer rules (.class) output file\n" +
"");
        System.exit(-1);

    }

  public static void main(String[] argv) throws Exception {

      if (argv.length != 2) {
          endProgram("apertium-preprocess-transfer-bytecode-j");
      }

      ParseTransferFile p = new ParseTransferFile();
      System.err.println("Parsing " + argv[0]);
      p.parse(argv[0]);

      File dest = new File(argv[1]);
      File dir = dest.getParentFile();
      if (dir!=null) {
        dir.mkdirs();
      } else {
        dir = new File(".");
      }
      File javaDest = new File(dir, p.className+".java");
      File classDest = new File(dir, p.className+".class");

      //System.err.println("Writing Java source code to " + javaDest);
      //System.out.println("p.javaCode = " + p.getJavaCode());

      FileWriter fw = new FileWriter(javaDest);
      fw.append(p.getOptimizedJavaCode());
      fw.close();
     
      // don't depend on an internal javac - this might not be Sun's javac
      //System.err.println("Compiling " + javaDest);
      //com.sun.tools.javac.Main.compile( new String[] { javaDest.getPath() } );
      /*
       * see http://kickjava.com/src/com/caucho/java/InternalCompiler.java.htm
       *
      try {
        String[] args = { javaDest.getPath() };
        Method compileMet = Class.forName("com.sun.tools.javac.Main").getMethod("compile", args.getClass());
        compileMet.invoke(null,  new Object[] { args });
      } catch (Exception e) {
        e.printStackTrace();
      }*/

      if (!classDest.exists()) {
        // Try invoking javac
        String cps =  System.getProperty("lttoolbox.jar");
        File cp = new File(cps!=null? cps : "lttoolbox.jar");
        if (!cp.exists()) cp = new File("dist/lttoolbox.jar");
        if (!cp.exists()) cp = new File("/usr/local/share/apertium/lttoolbox.jar");
        if (!cp.exists()) cp = new File("/usr/share/apertium/lttoolbox.jar");
        if (!cp.exists()) cp = new File("dist/lttoolbox.jar"); // fall back to this, to give the best suggestion below
        if (cps==null) {
            System.err.println("Please specify location of lttoolbox.jar, for example writing java -Dlttoolbox.jar="+cp.getPath());
        }

        String exec = "javac -cp "+cp.getPath()+" "+javaDest;
        System.err.println("Compiling: "+exec);
        if (!cp.exists()) {
          System.err.println("Error: "+cp.getPath()+" is missing.");
          System.err.println("Please rebuild lttoolbox-java to make it appear.");
          throw new FileNotFoundException(cp.getPath()+" is needed to be able to compile transfer files.");
        }
        exec(exec);
      }


      if (!classDest.exists()) {
        throw new InternalError("Compilation error - compiled "+javaDest+" but "+classDest+" didnt appear.");
      }
      
      if (!classDest.equals(dest)) {
        //System.err.println("Renaming " + classDest+" to "+dest);
        classDest.renameTo(dest);
      }
    }
  
	private static void close(Closeable c) {
		if (c != null) {
			try {
				c.close();
			} catch (IOException e) {
				// ignored
			}
		}
	}

	public static String exec(String cmd) throws IOException,
			InterruptedException {
		Process p = null;
		String output = "";
		try {
			p = Runtime.getRuntime().exec(cmd);
			String s;
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((s = br.readLine()) != null)
				output = output + s + "\n";
			br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while ((s = br.readLine()) != null)
				output = output + s + "\n";
			p.waitFor();
			if (p.exitValue() != 0)
				throw new RuntimeException(cmd + " reported an error: "	+ output);
			/*
			 * if (output.length()>0) { System.err.println("exec: " + cmd);
			 * System.err.println("output: " + output); return cmd+"\n"+output;
			 * }
			 */
		} catch (Exception err) {
			err.printStackTrace();
		} finally {
			if (p != null) {
				close(p.getOutputStream());
				close(p.getInputStream());
				close(p.getErrorStream());
				p.destroy();
			}
		}
		return output;
	}
}
