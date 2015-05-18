
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import org.apertium.lttoolbox.LTComp;
import org.apertium.tagger.Tagger;
import org.apertium.transfer.Transfer;
import org.apertium.utils.IOUtils;
import org.apertium.utils.Timing;

/**
 *
 *
 * @author Jacob Nordfalk
 */
public class Profiling {
  static long now = System.currentTimeMillis();

  public static void report(String action) {
    System.out.println(action + " took sec " + (System.currentTimeMillis() - now) + " msec");

    now = System.currentTimeMillis();
  }

  public static void main(String[] argv) throws Exception {

    IOUtils.timing = new Timing("overall");

    Profiling p = new Profiling();
    System.out.println(System.getProperties());
    System.out.println("Profiling " + new java.util.Date() + " " + System.getProperty("java.vm.name") + " " + System.getProperty("java.version"));
    report("start " + new File(".").getAbsolutePath());
    //System.gc();
    //p.testTransfer();
    System.gc();
    p.testjavaAnalysis();
    System.gc();
    p.testTagger();
    System.gc();
    p.testjavaGeneration();
    System.gc();
    p.testjavaDGeneration();
    System.gc();
    p.testjavaNGeneration();
    System.gc();
    p.testjavaPostgeneration();
    System.gc();
    p.testjavaAnalysis();

    System.gc();
//    LTComp.main(new String[] { "rl", "testdata/apertium-fr-es.fr.dix", "tmp/testJava.bin"}); report("lt-comp");
/*  */
    //System.err.println("SetOfCharacters.max_encountered = " + SetOfCharacters.max_encountered);
    IOUtils.timing.report();
  }
  String dir = "testdata/regression/";
  String tdir = "testdata/transfer/";

  public void testjavaAnalysis() throws Exception {
    String outFile = "./tmp/lt-proc-output1a.txt";
    org.apertium.lttoolbox.LTProc.main(new String[]{"-a", dir + "fr-es.automorf.bin", dir + "analysis_input", outFile});
    report("analysis -a  ");
  }

  public void testjavaGeneration() throws Exception {
    String outFile = "./tmp/lt-proc-output1b.txt";
    org.apertium.lttoolbox.LTProc.main(new String[]{"-g", dir + "fr-es.autogen.bin", dir + "generator_input", outFile});
    report("generation -g");
  }

  public void testjavaDGeneration() throws Exception {
    String outFile = "./tmp/lt-proc-output3g.txt";
    org.apertium.lttoolbox.LTProc.main(new String[]{"-d", dir + "fr-es.autogen.bin", dir + "generator_input", outFile});
    report("generation -d");
  }

  public void testjavaNGeneration() throws Exception {
    String outFile = "./tmp/lt-proc-output4.txt";
    org.apertium.lttoolbox.LTProc.main(new String[]{"-n", dir + "fr-es.autogen.bin", dir + "generator_input", outFile});
    report("generation -n");
  }

  public void testjavaPostgeneration() throws Exception {
    String outFile = "./tmp/lt-proc-output5.txt";
    org.apertium.lttoolbox.LTProc.main(new String[]{"-p", dir + "fr-es.autopgen.bin", dir + "postgenerator_input", outFile});
    report("generation -p");
  }

	/*
  private void testTransfer() throws Exception {

    Transfer t;

    //Class transferClass =org.apertium.transfer.generated.apertium_eo_en_en_eo_t1x.class;
    Class transferClass = org.apertium.transfer.old.generated.apertium_en_ca_en_ca_t1x.class;

    t = new Transfer();
//      t.read(transferClass, tdir+"en-eo.t1x.bin", tdir+"en-eo.autobil.bin");
    t.read(transferClass, tdir + "en-ca.t1x.bin", tdir + "en-eo.autobil.bin");
    report("transfer-init " + transferClass.getSimpleName());
    Reader input = new FileReader(tdir + "transferinput-en-eo.t1x-malgranda.txt");
    String outFile = "./tmp/transfer-output-malgranda.txt";
    Writer output = new FileWriter(outFile);
    t.process(input, output);
    output.close();
    report("transfer");
  }
	*/

  private void testTagger() throws Exception {


    String dir = "testdata/tagger/";
    String prob = dir + "en-es.prob";
    String inFile = dir + "en-tagger-input.txt";
    String outputFile = "./tmp/taggerout";
    String[] argv = {"-g", prob, inFile, outputFile};

    Tagger.main(argv);
    report("tagger");
  }
}


/* Progress log
 *
 * {java.runtime.name=Java(TM) SE Runtime Environment, sun.boot.library.path=/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/i386, java.vm.version=14.2-b01, java.vm.vendor=Sun Microsystems Inc., java.vendor.url=http://java.sun.com/, path.separator=:, java.vm.name=Java HotSpot(TM) Server VM, file.encoding.pkg=sun.io, sun.java.launcher=SUN_STANDARD, user.country=US, sun.os.patch.level=unknown, java.vm.specification.name=Java Virtual Machine Specification, user.dir=/home/j/esperanto/apertium/lttoolbox-java, java.runtime.version=1.6.0_16-b01, java.awt.graphicsenv=sun.awt.X11GraphicsEnvironment, java.endorsed.dirs=/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/endorsed, os.arch=i386, java.io.tmpdir=/tmp, line.separator=
 * , java.vm.specification.vendor=Sun Microsystems Inc., os.name=Linux, sun.jnu.encoding=UTF-8, java.library.path=/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/i386/server:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/i386:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/../lib/i386:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/i386/client:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/i386:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/../lib/i386:/usr/java/packages/lib/i386:/lib:/usr/lib, java.specification.name=Java Platform API Specification, java.class.version=50.0, sun.management.compiler=HotSpot Tiered Compilers, os.version=2.6.31-14-generic, user.home=/home/j, user.timezone=Europe/Copenhagen, java.awt.printerjob=sun.print.PSPrinterJob, file.encoding=UTF-8, java.specification.version=1.6, java.class.path=/home/j/esperanto/apertium/lttoolbox-java/build/classes:/home/j/esperanto/apertium/lttoolbox-java/src, user.name=j, java.vm.specification.version=1.0, java.home=/usr/lib/jvm/java-6-sun-1.6.0.16/jre, sun.arch.data.model=32, user.language=en, java.specification.vendor=Sun Microsystems Inc., java.vm.info=mixed mode, java.version=1.6.0_16, java.ext.dirs=/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/ext:/usr/java/packages/lib/ext, sun.boot.class.path=/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/resources.jar:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/rt.jar:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/sunrsasign.jar:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/jsse.jar:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/jce.jar:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/lib/charsets.jar:/usr/lib/jvm/java-6-sun-1.6.0.16/jre/classes, java.vendor=Sun Microsystems Inc., file.separator=/, java.vendor.url.bug=http://java.sun.com/cgi-bin/bugreport.cgi, sun.io.unicode.encoding=UnicodeLittle, sun.cpu.endian=little, sun.desktop=gnome, sun.cpu.isalist=}
 *
 * Profiling Mon Nov 23 16:54:59 CET 2009
 * analysis -a took sec 3697 msec
 * generation -g took sec 2768 msec
 * generation -d took sec 2544 msec
 * generation -n took sec 2631 msec
 * generation -p took sec 1669 msec
 * analysis -a took sec 2464 msec
 *
 *
 * Profiling Tue Nov 24 08:45:18 CET 2009
 * analysis -a took sec 3417 msec
 * generation -g took sec 2669 msec
 * generation -d took sec 2601 msec
 * generation -n took sec 2506 msec
 * generation -p took sec 1666 msec
 * analysis -a took sec 2690 msec
 *
 * // Changed way profiling works
 * Profiling Tue Nov 24 10:27:40 CET 2009
 * analysis -a took sec 3095 msec
 * generation -g took sec 2149 msec
 * generation -d took sec 1876 msec
 * generation -n took sec 2015 msec
 * generation -p took sec 1272 msec
 * analysis -a took sec 2240 msec
 *
 * // Use system UTF8 decoding instead of hand-made way of decoding UTF-8
 * analysis -a took sec 2483 msec
 * generation -g took sec 885 msec
 * generation -d took sec 859 msec
 * generation -n took sec 979 msec
 * generation -p took sec 451 msec
 * analysis -a took sec 1044 msec
 * lt-comp took sec 10917 msec
 *
 *
 * // Use SetOfCharacters with array of boolean implementation
 * Profiling Tue Nov 24 14:26:37 CET 2009
 * analysis -a took sec 2759 msec
 * generation -g took sec 928 msec
 * generation -d took sec 880 msec
 * generation -n took sec 681 msec
 * generation -p took sec 448 msec
 * analysis -a took sec 1166 msec
 * lt-comp took sec 9485 msec
 *
 *
 * avoid
 * if (transitions.containsKey(it2)) {
 * for (Integer it3 : transitions.get(it2).keySet()) {
 * use
 * Map<Integer, Set<Integer>> xxx = transitions.get(it2);
 * if (xxx!=null) {
 * for (Integer it3 : xxx.keySet()) {
 *
 * Profiling Wed Nov 25 05:16:23 CET 2009
 * analysis -a took sec 2537 msec
 * generation -g took sec 838 msec
 * generation -d took sec 750 msec
 * generation -n took sec 794 msec
 * generation -p took sec 461 msec
 * analysis -a took sec 1689 msec
 * lt-comp took sec 9907 msec
 *
 *
 * various optimizations
 *
 * Profiling Wed Nov 25 07:26:42 CET 2009
 * analysis -a took sec 2409 msec
 * generation -g took sec 981 msec
 * generation -d took sec 641 msec
 * generation -n took sec 792 msec
 * generation -p took sec 441 msec
 * analysis -a took sec 1016 msec
 * lt-comp took sec 9327 msec
 * BUILD SUCCESSFUL (total time: 16 seconds)
 *
 *
 *
 * Profiling Wed Nov 25 13:49:13 CET 2009
 * analysis -a took sec 2272 msec
 * generation -g took sec 806 msec
 * generation -d took sec 687 msec
 * generation -n took sec 796 msec
 * generation -p took sec 460 msec
 * analysis -a took sec 1239 msec
 * final@inconditional 61 858
 * main@standard 62442 96775
 * lt-comp took sec 10204 msec
 * BUILD SUCCESSFUL (total time: 16 seconds)
 *
 *
 * Profiling Wed Nov 25 16:39:13 CET 2009
 * analysis -a took sec 1915 msec
 * generation -g took sec 751 msec
 * generation -d took sec 527 msec
 * generation -n took sec 744 msec
 * generation -p took sec 500 msec
 * analysis -a took sec 1170 msec
 * final@inconditional 61 858
 * main@standard 62442 96775
 * lt-comp took sec 10017 msec
 * BUILD SUCCESSFUL (total time: 15 seconds)
 *
 *
 * Making Transitions a linked list instead of using 2 arrays of objecs.
 *
 * Profiling Wed Nov 25 22:14:38 CET 2009
 * analysis -a took sec 2137 msec
 * generation -g took sec 576 msec
 * generation -d took sec 492 msec
 * generation -n took sec 455 msec
 * generation -p took sec 471 msec
 * analysis -a took sec 735 msec
 * lt-comp took sec 10081 msec
 * BUILD SUCCESSFUL (total time: 15 seconds)
 *
 *
 * make readFullBlock use char instread of Character
 *
 * Profiling Wed Nov 25 22:40:04 CET 2009
 * analysis -a took sec 1679 msec
 * generation -g took sec 737 msec
 * generation -d took sec 481 msec
 * generation -n took sec 494 msec
 * generation -p took sec 151 msec
 * analysis -a took sec 508 msec
 * lt-comp took sec 9960 msec
 * BUILD SUCCESSFUL (total time: 15 seconds)
 *
 *
 * Profiling Wed Nov 25 23:11:14 CET 2009
 * analysis -a took sec 1442 msec
 * generation -g took sec 761 msec
 * generation -d took sec 447 msec
 * generation -n took sec 557 msec
 * generation -p took sec 143 msec
 * analysis -a took sec 502 msec
 * final@inconditional 61 858
 * main@standard 62442 96775
 * lt-comp took sec 10407 msec
 * BUILD SUCCESSFUL (total time: 14 seconds)
 *
 * Ran into and changed Character -> char in FSTProcessor. 10% speed increase
 *
 * Profiling Sat Nov 28 23:04:20 CET 2009
 * analysis -a took sec 1328 msec
 * generation -g took sec 760 msec
 * generation -d took sec 443 msec
 * generation -n took sec 405 msec
 * generation -p took sec 134 msec
 * analysis -a took sec 564 msec
 * lt-comp took sec 10110 msec
 * BUILD SUCCESSFUL (total time: 13 seconds)
 *
 *
 * Profiling Fri Mar 05 11:54:16 CET 2010
 * analysis -a took sec 1324 msec
 * generation -g took sec 540 msec
 * generation -d took sec 382 msec
 * generation -n took sec 366 msec
 * generation -p took sec 162 msec
 * analysis -a took sec 411 msec
 * final@inconditional 61 858
 * main@standard 62442 96775
 * lt-comp took sec 8136 msec
 * BUILD SUCCESSFUL (total time: 12 seconds)
 *
 *
 * Profiling Sun Mar 07 17:46:47 NPT 2010
 * start /home/j/esperanto/a/lttoolbox-java/. took sec 39 msec
 * transfer-init apertium_en_ca_en_ca_t1x took sec 417 msec
 * transfer took sec 923 msec
 * analysis -a took sec 851 msec
 * generation -g took sec 526 msec
 * generation -d took sec 402 msec
 * generation -n took sec 402 msec
 * generation -p took sec 168 msec
 * analysis -a took sec 490 msec
 * final@inconditional 61 858
 * main@standard 62442 96775
 * lt-comp took sec 8011 msec
 * BUILD SUCCESSFUL (total time: 12 seconds)
 *
 *
 *
 * Alfabet cacher mest brugte bogstaver
 * Profiling Sun Mar 07 18:20:41 NPT 2010
 * start /home/j/esperanto/a/lttoolbox-java/. took sec 41 msec
 * transfer-init apertium_en_ca_en_ca_t1x took sec 464 msec
 * transfer took sec 751 msec
 * analysis -a took sec 849 msec
 * generation -g took sec 776 msec
 * generation -d took sec 386 msec
 * generation -n took sec 372 msec
 * generation -p took sec 110 msec
 * analysis -a took sec 447 msec
 * final@inconditional 61 858
 * main@standard 62442 96775
 * lt-comp took sec 7820 msec
 * BUILD SUCCESSFUL (total time: 12 seconds)
 *
 *
 * Har optimeret State og bruger objektpulje
 * Profiling Tue Apr 20 21:40:32 CEST 2010
 * start /home/j/esperanto/a/lttoolbox-java/. took sec 28 msec
 * transfer-init apertium_en_ca_en_ca_t1x took sec 388 msec
 * transfer took sec 738 msec
 * analysis -a took sec 782 msec
 * generation -g took sec 586 msec
 * generation -d took sec 312 msec
 * generation -n took sec 372 msec
 * generation -p took sec 192 msec
 * analysis -a took sec 349 msec
 * final@inconditional 61 858
 * main@standard 62442 96775
 * lt-comp took sec 6053 msec
 * BUILD SUCCESSFUL (total time: 10 seconds)
 *
 * Har skiftet til -client:
 * Profiling Fri Apr 23 09:47:09 CEST 2010 Java HotSpot(TM) Client VM 1.6.0_19
 * start /home/j/esperanto/a/lttoolbox-java/. took sec 40 msec
 * transfer-init apertium_en_ca_en_ca_t1x took sec 384 msec
 * transfer took sec 363 msec
 * analysis -a took sec 539 msec
 * generation -g took sec 473 msec
 * generation -d took sec 459 msec
 * generation -n took sec 436 msec
 * generation -p took sec 320 msec
 * analysis -a took sec 496 msec
 * final@inconditional 61 858
 * main@standard 62442 96775
 * lt-comp took sec 6807 msec
 * BUILD SUCCESSFUL (total time: 10 seconds)
 *
 *
 *
 * Profiling Mon Aug 02 21:01:15 CEST 2010 Java HotSpot(TM) Server VM 1.6.0_20
 * start /home/j/esperanto/a/lttoolbox-java/. took sec 95 msec
 * transfer-init apertium_en_ca_en_ca_t1x took sec 401 msec
 * transfer took sec 837 msec
 * analysis -a took sec 709 msec
 * tagger took sec 431 msec
 * generation -g took sec 548 msec
 * generation -d took sec 331 msec
 * generation -n took sec 370 msec
 * generation -p took sec 182 msec
 * analysis -a took sec 358 msec
 * final@inconditional 61 858
 * main@standard 62442 96775
 * lt-comp took sec 6290 msec
 * BUILD SUCCESSFUL (total time: 11 seconds)
 *
 *
 * Client stats:
 *
 * Profiling Mon Aug 02 21:06:02 CEST 2010 Java HotSpot(TM) Client VM 1.6.0_20
 * start /home/j/esperanto/a/lttoolbox-java/. took sec 48 msec
 * transfer-init apertium_en_ca_en_ca_t1x took sec 364 msec
 * transfer took sec 301 msec
 * analysis -a took sec 544 msec
 * tagger took sec 182 msec
 * generation -g took sec 486 msec
 * generation -d took sec 478 msec
 * generation -n took sec 450 msec
 * generation -p took sec 116 msec
 * analysis -a took sec 473 msec
 * final@inconditional 61 858
 * main@standard 62442 96775
 * lt-comp took sec 6572 msec
 * BUILD SUCCESSFUL (total time: 10 seconds)
 *
 * {java.runtime.name=Java(TM) SE Runtime Environment, sun.boot.library.path=/usr/lib/jvm/java-6-sun-1.6.0.20/jre/lib/i386, java.vm.version=16.3-b01, java.vm.vendor=Sun Microsystems Inc., java.vendor.url=http://java.sun.com/, path.separator=:, java.vm.name=Java HotSpot(TM) Client VM, file.encoding.pkg=sun.io, sun.java.launcher=SUN_STANDARD, user.country=DK, sun.os.patch.level=unknown, java.vm.specification.name=Java Virtual Machine Specification, user.dir=/home/j/esperanto/a/lttoolbox-java, java.runtime.version=1.6.0_20-b02, java.awt.graphicsenv=sun.awt.X11GraphicsEnvironment, java.endorsed.dirs=/usr/lib/jvm/java-6-sun-1.6.0.20/jre/lib/endorsed, os.arch=i386, java.io.tmpdir=/tmp, line.separator=
 * , java.vm.specification.vendor=Sun Microsystems Inc., os.name=Linux, sun.jnu.encoding=UTF-8, java.library.path=/usr/lib/jvm/java-6-sun-1.6.0.20/jre/lib/i386/client:/usr/lib/jvm/java-6-sun-1.6.0.20/jre/lib/i386:/usr/lib/jvm/java-6-sun-1.6.0.20/jre/../lib/i386:/usr/java/packages/lib/i386:/lib:/usr/lib, java.specification.name=Java Platform API Specification, java.class.version=50.0, sun.management.compiler=HotSpot Client Compiler, os.version=2.6.32-24-generic, user.home=/home/j, user.timezone=, java.awt.printerjob=sun.print.PSPrinterJob, file.encoding=UTF-8, java.specification.version=1.6, java.class.path=/home/j/esperanto/apertium/lttoolbox-java/build/classes:/home/j/esperanto/apertium/lttoolbox-java/src, user.name=j, java.vm.specification.version=1.0, java.home=/usr/lib/jvm/java-6-sun-1.6.0.20/jre, sun.arch.data.model=32, user.language=da, java.specification.vendor=Sun Microsystems Inc., java.vm.info=mixed mode, sharing, java.version=1.6.0_20, java.ext.dirs=/usr/lib/jvm/java-6-sun-1.6.0.20/jre/lib/ext:/usr/java/packages/lib/ext, sun.boot.class.path=/usr/lib/jvm/java-6-sun-1.6.0.20/jre/lib/resources.jar:/usr/lib/jvm/java-6-sun-1.6.0.20/jre/lib/rt.jar:/usr/lib/jvm/java-6-sun-1.6.0.20/jre/lib/sunrsasign.jar:/usr/lib/jvm/java-6-sun-1.6.0.20/jre/lib/jsse.jar:/usr/lib/jvm/java-6-sun-1.6.0.20/jre/lib/jce.jar:/usr/lib/jvm/java-6-sun-1.6.0.20/jre/lib/charsets.jar:/usr/lib/jvm/java-6-sun-1.6.0.20/jre/classes, java.vendor=Sun Microsystems Inc., file.separator=/, java.vendor.url.bug=http://java.sun.com/cgi-bin/bugreport.cgi, sun.io.unicode.encoding=UnicodeLittle, sun.cpu.endian=little, sun.desktop=gnome, sun.cpu.isalist=}
 * Profiling Sat Aug 21 09:08:14 CEST 2010 Java HotSpot(TM) Client VM 1.6.0_20
 * start /home/j/esperanto/a/lttoolbox-java/. took sec 22 msec
 * transfer-init apertium_en_ca_en_ca_t1x took sec 333 msec
 * transfer took sec 297 msec
 * analysis -a took sec 529 msec
 * tagger took sec 173 msec
 * generation -g took sec 504 msec
 * generation -d took sec 507 msec
 * generation -n took sec 472 msec
 * generation -p took sec 133 msec
 * analysis -a took sec 485 msec
 * final@inconditional 61 858
 * main@standard 62442 96775
 * lt-comp took sec 6363 msec
 * BUILD SUCCESSFUL (total time: 10 seconds)
 *
 *
 *
 * Profiling Fri Nov 09 14:48:14 CET 2012 Java HotSpot(TM) Client VM 1.7.0_09
 *
 * DELAYED_NODE_LOADING = true
 * transfer-init apertium_en_ca_en_ca_t1x took sec 200 msec
 * transfer took sec 524 msec
 * analysis -a took sec 508 msec
 * tagger took sec 225 msec
 * generation -g took sec 453 msec
 * generation -d took sec 401 msec
 * generation -n took sec 366 msec
 * generation -p took sec 111 msec
 * analysis -a took sec 396 msec
 *
 * DELAYED_NODE_LOADING = false
 * transfer-init apertium_en_ca_en_ca_t1x took sec 179 msec
 * transfer took sec 380 msec
 * analysis -a took sec 504 msec
 * tagger took sec 191 msec
 * generation -g took sec 440 msec
 * generation -d took sec 439 msec
 * generation -n took sec 411 msec
 * generation -p took sec 103 msec
 * analysis -a took sec 446 msec
 * final@inconditional 61 858
 * main@standard 62442 96775
 * lt-comp took sec 6832 msec
 *
 */
