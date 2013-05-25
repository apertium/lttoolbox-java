/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.lttoolbox.compile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apertium.lttoolbox.Alphabet;
import org.apertium.lttoolbox.LTPrint;
import org.apertium.lttoolbox.LTTrim;
import org.apertium.lttoolbox.collections.IntSet;
import static org.apertium.lttoolbox.collections.Transducer.DEBUG;
import org.apertium.lttoolbox.process.BasicFSTProcessor;
import org.apertium.lttoolbox.process.State;

/**
 *
 * @author j
 */
public class TransducerTrim extends TransducerComp {

  public TransducerTrim(TransducerComp t) {
    shallowCopy(t);
  }


  public void trim(Alphabet alphabet, BasicFSTProcessor bil) {
    joinFinals();
    //determinize();
    boolean[] visited = new boolean[transitions.size()];
    bil.calc_initial_state();
    State bilstate = bil.initial_state.copy();
    trim(alphabet, 0, visited, "", "", bil, bilstate);
  }




  private void xshowLtExpandish(Alphabet alphabet, PrintStream out, int state, boolean[] visited, String left, String right) {
    if (finals.contains(state)) {
      out.println(left + ":" + right);
      return;
    }
    visited[state] = true;

    Map<Integer, IntSet> it = transitions.get(state);
    for (Map.Entry<Integer, IntSet> it2 : it.entrySet()) {
      Integer it2_first = it2.getKey();
      Alphabet.IntegerPair t = alphabet.decode(it2_first);
      for (Integer target_state : it2.getValue()) {
        String l = alphabet.getSymbol(t.first);
        String r = alphabet.getSymbol(t.second);
        if (visited[target_state]) {
          out.println("__CYCLE__ "+  left+l + ":" + right+r);
          return;
        }
        xshowLtExpandish(alphabet, out, target_state, visited, left+l, right+r);
      }
    }
    visited[state] = false;
  }

  public void xshowLtExpandish(Alphabet alphabet, PrintStream out) {
    joinFinals();
    boolean[] visited = new boolean[transitions.size()];
    xshowLtExpandish(alphabet, out, 0, visited, "", "");
  }




  private void trim(Alphabet alphabet, int state, boolean[] visited, String left, String right, BasicFSTProcessor bil, State bilstate) {
    //System.out.println(left + ":" + right + "  "+bilstate.isFinal()+" "+bilstate.size());
    visited[state] = true;

    Map<Integer, IntSet> it = transitions.get(state);
    for (Iterator<Map.Entry<Integer, IntSet>> iter2 = it.entrySet().iterator(); iter2.hasNext();) {
      Map.Entry<Integer, IntSet> it2 = iter2.next();
      Integer it2_first = it2.getKey();
      Alphabet.IntegerPair t = alphabet.decode(it2_first);

      String l = alphabet.getSymbol(t.first);
      String r = alphabet.getSymbol(t.second);
      String left2 = left + l;
      String right2 = right + r;
      int outsym = t.second>=0?t.second : bil.alphabet.cast(r);
      System.out.println("rsym = "+outsym + ", da r="+r);
      State newbilstate = bilstate.copy();
      newbilstate.step(outsym);
      if (newbilstate.isFinal()) {
        if (DEBUG) System.out.println("Keep: " +left2 + ":" + right2);
        continue;
      }
      if (newbilstate.size()==0) {
        if (DEBUG) {
          System.out.println("Trim: " +left2 + "…"+":" + right2+"…");
        }

        iter2.remove(); // =it.remove(it2_first);
        continue;
      }


      for (Integer target_state : it2.getValue()) {
        if (visited[target_state]) {
          if (DEBUG) System.out.println("Keepc: " +left2 + ":" + right2); // Cyclic, probably a regular expression
          return;
        }
        if (finals.contains(target_state)) {
          if (DEBUG) System.out.println("Keepf: " +left2 + ":" + right2);
          return;
        }


        trim(alphabet, target_state, visited, left2, right2, bil, newbilstate);
      }
    }
    visited[state] = false;
  }


  public static void main(String[] args) throws IOException {
    LTTrim.main(new String[]{"-v", "testdata/compounding/eo-en.automorf.bin","testdata/bilingual/eo-en.autobil.bin","/tmp/x" });
  }
  
  public static void xmain(String[] args) throws FileNotFoundException, IOException {
    LTPrint.main(new String[]{"-s", "testdata/trimming/test-en.bin" });
    //LTPrint.main(new String[]{"-s", "testdata/bilingual/eo-en.autobil.bin" });
  }
}
