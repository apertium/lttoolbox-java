
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;


/**
 *
 *
 * @author Jacob Nordfalk
 */
public class Profiling {

      static long now = System.currentTimeMillis();
      public static void report(String action) {
      System.out.println(action + " took sec "+ (System.currentTimeMillis()-now) + " msec" );

        now = System.currentTimeMillis();
      }

      public static void main(String[] argv) throws Exception {
        Profiling p = new Profiling();
        System.out.println("Profiling "+new java.util.Date() );
        System.out.println(System.getProperties() );
  
        p.testjavaAnalysis();
        p.testjavaGeneration();
        p.testjavaDGeneration();
        p.testjavaNGeneration();
        p.testjavaPostgeneration();
        p.testjavaAnalysis();
      }



  String dir = "testdata/regression/";


  InputStream systemin = System.in;
  PrintStream systemout = System.out;

  public void testjavaAnalysis() throws Exception {
    String outFile = "/tmp/lt-proc-output.txt";
    System.setIn(new FileInputStream(dir+"analysis_input"));
    System.setOut(new PrintStream(outFile));
    org.apertium.lttoolbox.LTProc.main(new String[] {"-a",dir+"fr-es.automorf.bin"});
    System.setIn(systemin);
    System.setOut(systemout);
    report("analysis -a  ");
  }


  public void testjavaGeneration() throws Exception {
    String outFile = "/tmp/lt-proc-output.txt";
    System.setIn(new FileInputStream(dir+"generator_input"));
    System.setOut(new PrintStream(outFile));
    org.apertium.lttoolbox.LTProc.main(new String[] {"-g",dir+"fr-es.autogen.bin"});
    System.setIn(systemin);
    System.setOut(systemout);
    report("generation -g");
  }


  public void testjavaDGeneration() throws Exception {
    String outFile = "/tmp/lt-proc-output.txt";
    System.setIn(new FileInputStream(dir+"generator_input"));
    System.setOut(new PrintStream(outFile));
    org.apertium.lttoolbox.LTProc.main(new String[] {"-d",dir+"fr-es.autogen.bin"});
    System.setIn(systemin);
    System.setOut(systemout);
    report("generation -d");
  }


  public void testjavaNGeneration() throws Exception {
    String outFile = "/tmp/lt-proc-output.txt";
    System.setIn(new FileInputStream(dir+"generator_input"));
    System.setOut(new PrintStream(outFile));
    org.apertium.lttoolbox.LTProc.main(new String[] {"-n",dir+"fr-es.autogen.bin"});
    System.setIn(systemin);
    System.setOut(systemout);
    report("generation -n");
  }


  public void testjavaPostgeneration() throws Exception {
    String outFile = "/tmp/lt-proc-output.txt";
    System.setIn(new FileInputStream(dir+"postgenerator_input"));
    System.setOut(new PrintStream(outFile));
    org.apertium.lttoolbox.LTProc.main(new String[] {"-p",dir+"fr-es.autopgen.bin"});
    System.setIn(systemin);
    System.setOut(systemout);
    report("generation -p");
  }

}


/* Progress log


Profiling Mon Nov 23 16:54:59 CET 2009
analysis -a   took sec 3697 msec
generation -g took sec 2768 msec
generation -d took sec 2544 msec
generation -n took sec 2631 msec
generation -p took sec 1669 msec
analysis -a   took sec 2464 msec
 

 */
