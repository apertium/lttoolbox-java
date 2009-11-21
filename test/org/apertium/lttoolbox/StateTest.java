/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.lttoolbox;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.Vector;
import junit.framework.TestCase;

/**
 *
 * @author Jacob Nordfalk
 */
public class StateTest extends TestCase {


    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }


  public void testStateRaphaëlPleaseFinish() throws IOException {
      FSTProcessor fstp = new FSTProcessor();
      fstp.load(new DataInputStream(new BufferedInputStream(new FileInputStream("src/test/org/apertium/lttoolbox/correct-test.bin"))));


      System.err.println("fstp.transducers = " + fstp.transducers);
      Node root = new Node();

        //System.out.println("call to calcInitial");
        for (String first : fstp.transducers.keySet()) {
            root.addTransition(0, 0, fstp.transducers.get(first).getInitial());
        }

        System.err.println("transitions = " + root.transitions);

        //System.out.println("plp");
        State initial_state = new State();

        initial_state.init(root);
        //System.out.println("exiting calcInitial");

  }



  /*
  public void testPoolInit() {
    System.out.println("poolInit");
    State instance=new State();
    instance.poolInit();
    fail("The test case is a prototype.");
  }

  public void testCopy() {
    System.out.println("copy");
    State s=null;
    State instance=new State();
    instance.copy(s);
    fail("The test case is a prototype.");
  }

  public void testSize() {
    System.out.println("size");
    State instance=new State();
    int expResult=0;
    int result=instance.size();
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }

  public void testInit() {
    System.out.println("init");
    Node initial=null;
    State instance=new State();
    instance.init(initial);
    fail("The test case is a prototype.");
  }

  public void testApply_int() {
    System.out.println("apply");
    int input=0;
    State instance=new State();
    instance.apply(input);
    fail("The test case is a prototype.");
  }

  public void testApply_int_int() {
    System.out.println("apply");
    int input=0;
    int alt=0;
    State instance=new State();
    instance.apply(input, alt);
    fail("The test case is a prototype.");
  }

  public void testEpsilonClosure() {
    System.out.println("epsilonClosure");
    State instance=new State();
    instance.epsilonClosure();
    fail("The test case is a prototype.");
  }

  public void testStep_int() {
    System.out.println("step");
    int input=0;
    State instance=new State();
    instance.step(input);
    fail("The test case is a prototype.");
  }

  public void testStep_int_int() {
    System.out.println("step");
    int input=0;
    int alt=0;
    State instance=new State();
    instance.step(input, alt);
    fail("The test case is a prototype.");
  }

  public void testIsFinal() {
    System.out.println("isFinal");
    Set<Node> finals=null;
    State instance=new State();
    boolean expResult=false;
    boolean result=instance.isFinal(finals);
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }

  public void testFilterFinals_5args() {
    System.out.println("filterFinals");
    Set<Node> finals=null;
    Alphabet alphabet=null;
    Set<Character> escaped_chars=null;
    boolean uppercase=false;
    boolean firstupper=false;
    State instance=new State();
    String expResult="";
    String result=instance.filterFinals(finals, alphabet, escaped_chars, uppercase, firstupper);
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }

  public void testFilterFinals_6args() {
    System.out.println("filterFinals");
    Set<Node> finals=null;
    Alphabet alphabet=null;
    Set<Character> escaped_chars=null;
    boolean uppercase=false;
    boolean firstupper=false;
    int firstchar=0;
    State instance=new State();
    String expResult="";
    String result=instance.filterFinals(finals, alphabet, escaped_chars, uppercase, firstupper, firstchar);
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }

  public void testFilterFinalsSAO() {
    System.out.println("filterFinalsSAO");
    Set<Node> finals=null;
    Alphabet alphabet=null;
    Set<Character> escaped_chars=null;
    boolean uppercase=false;
    boolean firstupper=false;
    int firstchar=0;
    State instance=new State();
    String expResult="";
    String result=instance.filterFinalsSAO(finals, alphabet, escaped_chars, uppercase, firstupper, firstchar);
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }

  public void testFilterFinalsTM() {
    System.out.println("filterFinalsTM");
    Set<Node> finals=null;
    Alphabet alphabet=null;
    Set<Character> escaped_chars=null;
    ArrayDeque<String> blankqueue=null;
    Vector<String> numbers=null;
    State instance=new State();
    String expResult="";
    String result=instance.filterFinalsTM(finals, alphabet, escaped_chars, blankqueue, numbers);
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }
*/
}
