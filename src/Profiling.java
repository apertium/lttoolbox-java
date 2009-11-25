
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.apertium.lttoolbox.LTComp;
import org.apertium.lttoolbox.SetOfCharacters;


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
        //System.out.println(System.getProperties() );
        System.out.println("Profiling "+new java.util.Date() );
/*
        p.testjavaAnalysis();
        p.testjavaGeneration();
        p.testjavaDGeneration();
        p.testjavaNGeneration();
        p.testjavaPostgeneration();
        p.testjavaAnalysis();
 /**/
    LTComp.main(new String[] { "rl", "testdata/apertium-fr-es.fr.dix", "tmp/testJava.bin"});
    report("lt-comp  ");

        //System.err.println("SetOfCharacters.max_encountered = " + SetOfCharacters.max_encountered);
      }



  String dir = "testdata/regression/";


  public void testjavaAnalysis() throws Exception {
    String outFile = "/tmp/lt-proc-output1a.txt";
    org.apertium.lttoolbox.LTProc.main(new String[] {"-a",dir+"fr-es.automorf.bin", dir+"analysis_input", outFile});
    report("analysis -a  ");
  }


  public void testjavaGeneration() throws Exception {
    String outFile = "/tmp/lt-proc-output1b.txt";
    org.apertium.lttoolbox.LTProc.main(new String[] {"-g",dir+"fr-es.autogen.bin",dir+"generator_input", outFile});
    report("generation -g");
  }


  public void testjavaDGeneration() throws Exception {
    String outFile = "/tmp/lt-proc-output3g.txt";
    org.apertium.lttoolbox.LTProc.main(new String[] {"-d",dir+"fr-es.autogen.bin",dir+"generator_input", outFile});
    report("generation -d");
  }


  public void testjavaNGeneration() throws Exception {
    String outFile = "/tmp/lt-proc-output4.txt";
    org.apertium.lttoolbox.LTProc.main(new String[] {"-n",dir+"fr-es.autogen.bin",dir+"generator_input", outFile});
    report("generation -n");
  }


  public void testjavaPostgeneration() throws Exception {
    String outFile = "/tmp/lt-proc-output5.txt";
    org.apertium.lttoolbox.LTProc.main(new String[] {"-p",dir+"fr-es.autopgen.bin",dir+"postgenerator_input", outFile});
    report("generation -p");
  }


}


/* Progress log

{java.runtime.name=Java(TM) SE Runtime Environment, sun.boot.library.path=/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/i386, java.vm.version=14.2-b01, java.vm.vendor=Sun Microsystems Inc., java.vendor.url=http://java.sun.com/, path.separator=:, java.vm.name=Java HotSpot(TM) Server VM, file.encoding.pkg=sun.io, sun.java.launcher=SUN_STANDARD, user.country=US, sun.os.patch.level=unknown, java.vm.specification.name=Java Virtual Machine Specification, user.dir=/home/j/esperanto/apertium/lttoolbox-java, java.runtime.version=1.6.0_16-b01, java.awt.graphicsenv=sun.awt.X11GraphicsEnvironment, java.endorsed.dirs=/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/endorsed, os.arch=i386, java.io.tmpdir=/tmp, line.separator=
, java.vm.specification.vendor=Sun Microsystems Inc., os.name=Linux, sun.jnu.encoding=UTF-8, java.library.path=/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/i386/server:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/i386:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/../lib/i386:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/i386/client:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/i386:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/../lib/i386:/usr/java/packages/lib/i386:/lib:/usr/lib, java.specification.name=Java Platform API Specification, java.class.version=50.0, sun.management.compiler=HotSpot Tiered Compilers, os.version=2.6.31-14-generic, user.home=/home/j, user.timezone=Europe/Copenhagen, java.awt.printerjob=sun.print.PSPrinterJob, file.encoding=UTF-8, java.specification.version=1.6, java.class.path=/home/j/esperanto/apertium/lttoolbox-java/build/classes:/home/j/esperanto/apertium/lttoolbox-java/src, user.name=j, java.vm.specification.version=1.0, java.home=/usr/lib/jvm/java-6-sun-1.6.0.16/jre, sun.arch.data.model=32, user.language=en, java.specification.vendor=Sun Microsystems Inc., java.vm.info=mixed mode, java.version=1.6.0_16, java.ext.dirs=/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/ext:/usr/java/packages/lib/ext, sun.boot.class.path=/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/resources.jar:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/rt.jar:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/sunrsasign.jar:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/jsse.jar:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/jce.jar:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/charsets.jar:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/classes, java.vendor=Sun Microsystems Inc., file.separator=/, java.vendor.url.bug=http://java.sun.com/cgi-bin/bugreport.cgi, sun.io.unicode.encoding=UnicodeLittle, sun.cpu.endian=little, sun.desktop=gnome, sun.cpu.isalist=}

Profiling Mon Nov 23 16:54:59 CET 2009
analysis -a   took sec 3697 msec
generation -g took sec 2768 msec
generation -d took sec 2544 msec
generation -n took sec 2631 msec
generation -p took sec 1669 msec
analysis -a   took sec 2464 msec
 

Profiling Tue Nov 24 08:45:18 CET 2009
analysis -a   took sec 3417 msec
generation -g took sec 2669 msec
generation -d took sec 2601 msec
generation -n took sec 2506 msec
generation -p took sec 1666 msec
analysis -a   took sec 2690 msec

// Changed way profiling works
Profiling Tue Nov 24 10:27:40 CET 2009
analysis -a   took sec 3095 msec
generation -g took sec 2149 msec
generation -d took sec 1876 msec
generation -n took sec 2015 msec
generation -p took sec 1272 msec
analysis -a   took sec 2240 msec

// Use system UTF8 decoding instead of hand-made way of decoding UTF-8
analysis -a   took sec 2483 msec
generation -g took sec 885 msec
generation -d took sec 859 msec
generation -n took sec 979 msec
generation -p took sec 451 msec
analysis -a   took sec 1044 msec
 lt-comp   took sec 10917 msec


// Use SetOfCharacters with array of boolean implementation
Profiling Tue Nov 24 14:26:37 CET 2009
analysis -a   took sec 2759 msec
generation -g took sec 928 msec
generation -d took sec 880 msec
generation -n took sec 681 msec
generation -p took sec 448 msec
analysis -a   took sec 1166 msec
lt-comp   took sec 9485 msec

 
 avoid
                    if (transitions.containsKey(it2)) {
                        for (Integer it3 : transitions.get(it2).keySet()) {
use
                    Map<Integer, Set<Integer>> xxx = transitions.get(it2);
                    if (xxx!=null) {
                        for (Integer it3 : xxx.keySet()) {

Profiling Wed Nov 25 05:16:23 CET 2009
analysis -a   took sec 2537 msec
generation -g took sec 838 msec
generation -d took sec 750 msec
generation -n took sec 794 msec
generation -p took sec 461 msec
analysis -a   took sec 1689 msec
lt-comp   took sec 9907 msec
 */
