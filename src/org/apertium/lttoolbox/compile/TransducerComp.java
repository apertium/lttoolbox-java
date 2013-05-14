/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.lttoolbox.compile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apertium.lttoolbox.Alphabet;
import org.apertium.lttoolbox.Compression;
import org.apertium.lttoolbox.collections.AbundantIntSet;
import org.apertium.lttoolbox.collections.IntSet;
import org.apertium.lttoolbox.collections.SlowIntegerHashSet;
import org.apertium.lttoolbox.collections.SlowIntegerTreeSet;

/**
 * Transducer extended with methods handy for compilation of transducer
 *
 * @author j
 */
public class TransducerComp extends org.apertium.lttoolbox.collections.Transducer {
  /**
   * Clear transducer
   */
  void clear() {
    finals.clear();
    transitions.clear();
    initial = newState();
  }

  /**
   * Check if the transducer is empty
   *
   * @return true if the transducer is empty
   */
  boolean isEmpty() {
    return finals.size() == 0 && transitions.size() == 1;
  }

  /**
   * Transducer minimization
   * Minimize = reverse + determinize + reverse + determinize
   */
  void minimize() {
    reverse();
    determinize();
    reverse();
    determinize();
  }

  /**
   * Insertion of a single transduction, forcing create a new target
   * state
   *
   * @param tag the tag of the transduction being inserted
   * @param source the source state of the new transduction
   * @return the target state
   */
  Integer insertNewSingleTransduction(Integer tag, Integer source) {
    /*
     * Map<Integer, Set<Integer>> place = transitions.get(source);
     * if (place==null) {
     * place = new HashMap<Integer, Set<Integer>>();
     * transitions.put(source, place);
     * }
     */
    Map<Integer, IntSet> place;
    if (transitions.size() <= source) {
      place = new HashMap<Integer, IntSet>();
      transitions.add(place);
    } else {
      place = transitions.get(source);
    }

    if (DEBUG)
      System.err.println(transitions + "  place = " + place);
    IntSet set = place.get(tag);

    if (set == null) {
      set = new SlowIntegerHashSet();
      place.put(tag, set);
    }
    Integer state = newState();
    set.add(state);
    return state;
  }

  /**
   * Insertion of a transducer in a given source state, unifying their
   * final states using a optionally given epsilon tag
   *
   * @param source the source state
   * @param t the transducer being inserted
   * @return the new target state
   */
  Integer insertTransducer(Integer source, TransducerComp t) {

    // base of node translation
    final int first_state = transitions.size();

    // copy transducer
    for (int i = 0; i < t.transitions.size(); i++) {
      Integer local_source = newState();
      for (Integer tag : t.transitions.get(i).keySet()) {
        IntSet destset = new SlowIntegerHashSet();
        for (Integer destination : t.transitions.get(i).get(tag)) {
          destset.add(destination + first_state);
        }
        transitions.get(local_source).put(tag, destset);
      }
    }

    // link initial state of the new transducer
    // with epsilon_tag in source
    this.linkStates(source, first_state + t.initial, epsilon_tag);

    // return the unique final state of the inserted transducer
    int untranslated_final = t.finals.firstInt();
    return first_state + untranslated_final;
  }

  /**
   * Computes the number of transitions of a transducer
   *
   * @return the number of transitions
   */
  int numberOfTransitions() {
    int counter = 0;
    for (int i = 0; i < transitions.size(); i++) {
      for (IntSet destinations : transitions.get(i).values()) {
        counter += destinations.size();
      }
    }
    return counter;
  }

  /**
   * Computes whether two sets have elements in common
   *
   * @param s1 the firstInt set
   * @param s2 the second set
   * @return true if the sets don't intersect
   */
  private boolean isEmptyIntersection(Set<Integer> s1, Set<Integer> s2) {
    for (Integer i : s1) {
      if (s2.contains(i)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Computes whether two sets have elements in common
   *
   * @param s1 the firstInt set
   * @param s2 the second set
   * @return true if the sets don't intersect
   */
  private boolean isEmptyIntersection(Set<Integer> s1, IntSet s2) {
    for (Integer i : s1) {
      if (s2.contains(i)) {
        return false;
      }
    }
    return true;
  }

  /**
   * set the epsilon tag
   *
   * @param e the value to which set the epsilon tag
   */
  void setEpsilon_Tag(int e) {
    epsilon_tag = e;
  }

  /**
   * Determinize the transducer
   */
  private void determinize() {
    List<Set<Integer>> R = new ArrayList<Set<Integer>>(2);
    // MUST be TreeSet to retain binary compatibility:
    R.add(new TreeSet<Integer>()); // new SlowIntegerTreeSet() giver problemer. Hvorfor???
    R.add(new TreeSet<Integer>()); // new SlowIntegerTreeSet() giver problemer. Hvorfor???

    Map<Integer, Set<Integer>> Q_prima = new HashMap<Integer, Set<Integer>>();
    Map<Set<Integer>, Integer> Q_prima_inv = new HashMap<Set<Integer>, Integer>(); // setComparator

    // MUST be ordered to retain binary compatibility:
    ArrayList<Map<Integer, IntSet>> transitions_prima = new ArrayList<Map<Integer, IntSet>>();

    int talla_Q_prima = 0;

    Set<Integer> initial_closure = closure(initial);
    Q_prima.put(0, initial_closure);
    Q_prima_inv.put(initial_closure, 0);
    R.get(0).add(0);

    int initial_prima = 0;
    AbundantIntSet finals_prima = new AbundantIntSet();

    if (finals.contains(initial)) {
      finals_prima.add(0);
    }

    int t = 0;

    while (talla_Q_prima != Q_prima.size()) {
      talla_Q_prima = Q_prima.size();
      R.get((t + 1) % 2).clear();

      for (Integer it : R.get(t)) {
        if (!isEmptyIntersection(Q_prima.get(it), finals)) {
          finals_prima.add(it);
        }

        Map<Integer, Set<Integer>> mymap = new TreeMap<Integer, Set<Integer>>();

        for (Integer it2 : Q_prima.get(it)) {
          if (it2 < transitions.size()) {
            Map<Integer, IntSet> xxx = transitions.get(it2);
            for (Integer it3 : xxx.keySet()) {
              if (!it3.equals(epsilon_tag)) {
                for (Integer it3p : xxx.get(it3)) {
                  Set<Integer> c = closure(it3p);
                  Set<Integer> zzz = mymap.get(it3);
                  if (zzz == null) {
                    mymap.put(it3, c);
                  } else {
                    zzz.addAll(c);
                  }
                }
              }
            }
          }
        }
        // adding new states
        for (Map.Entry<Integer, Set<Integer>> it2 : mymap.entrySet()) {
          if (!Q_prima_inv.containsKey(it2.getValue())) {
            int etiq = Q_prima.size();
            Q_prima.put(etiq, it2.getValue());
            Q_prima_inv.put(it2.getValue(), etiq);
            R.get((t + 1) % 2).add(Q_prima_inv.get(it2.getValue()));
            //transitions_prima.add(new TreeMap<Integer, Set<Integer>>());
            while (transitions_prima.size() <= etiq)
              transitions_prima.add(new TreeMap<Integer, IntSet>());
            transitions_prima.set(etiq, new TreeMap<Integer, IntSet>());

          }

          while (transitions_prima.size() <= it) {
            transitions_prima.add(new TreeMap<Integer, IntSet>());
          }
          transitions_prima.get(it).put(it2.getKey(), new SlowIntegerTreeSet());
          transitions_prima.get(it).get(it2.getKey()).add(Q_prima_inv.get(it2.getValue()));
        }
      }

      t = (t + 1) % 2;
    }

    transitions = transitions_prima;
    finals = finals_prima;
    initial = initial_prima;

  }

  /**
   * Join all finals in one using epsilon transductions
   *
   * @return the only final state
   */
  void joinFinals() {
    if (finals.size() > 1) {
      Integer state = newState();

      for (int it = finals.next(0); it >= 0; it = finals.next(it + 1)) {
        linkStates(it, state, epsilon_tag);
      }
      /*
       * Iterator<Integer> it = finals.iterator();
       * while (it.hasNext()) {
       * linkStates(it.next(), state, epsilon_tag);
       * }
       */
      finals.clear();
      finals.add(state);
      //return state;
    } else if (finals.size() == 0) {
      throw new RuntimeException("Error: empty set of final states");
    } else {
      //return finals.iterator().next();
    }
  }

  /**
   * Make a transducer cyclic (link final states with initial state with
   * empty transductions)
   */
  void oneOrMore() {
    joinFinals();
    int state = newState();
    linkStates(state, initial, epsilon_tag);
    initial = state;

    state = newState();
    linkStates((Integer) finals.firstInt(), state, epsilon_tag);
    finals.clear();
    finals.add(state);
    linkStates(state, initial, epsilon_tag);
  }

  /**
   * Make a transducer optional (link initial state with final states with
   * empty transductions)
   */
  void optional() {
    joinFinals();
    int state = newState();
    linkStates(state, initial, epsilon_tag);
    initial = state;

    state = newState();
    linkStates((Integer) finals.firstInt(), state, epsilon_tag);
    finals.clear();
    finals.add(state);
    linkStates(initial, state, epsilon_tag);
  }

  /**
   * Reverse all the transductions of a transducer
   */
  private void reverse() {
    joinFinals();

    ArrayList<Map<Integer, IntSet>> result = new ArrayList<Map<Integer, IntSet>>();

//        for (Map.Entry<Integer, Map<Integer, Set<Integer>>> it : transitions.entrySet()) {
//            Integer dest = it.getKey();
    for (int i = 0; i < transitions.size(); i++) {
      Integer dest = i;
      for (Map.Entry<Integer, IntSet> it2 : transitions.get(i).entrySet()) {
        Integer tag = it2.getKey();
        for (Integer origin : it2.getValue()) {
          boolean added = result.size() <= origin;
          while (result.size() <= origin)
            result.add(new TreeMap<Integer, IntSet>());
          Map<Integer, IntSet> res_origin = result.get(origin);
          if (added) {
            res_origin.put(tag, new SlowIntegerTreeSet());

            IntSet aux = new SlowIntegerTreeSet();
            aux.add(dest);

            Map<Integer, IntSet> aux2 = new TreeMap<Integer, IntSet>();
            aux2.put(tag, aux);
            result.set(origin, aux2);
          } else {
            IntSet res_origin_tag = res_origin.get(tag);
            if (res_origin_tag == null) {
              res_origin_tag = new SlowIntegerTreeSet();
              res_origin.put(tag, res_origin_tag);
            }
            res_origin_tag.add(dest);
          }
        }
      }
    }
    Integer newInitial = finals.firstInt();
    finals.clear();
    finals.add(initial);
    initial = newInitial;
    transitions = result;
  }

  /**
   * Set the state as a final or not, yes by default
   *
   * @param e the state
   */
  void setFinal(Integer e) {
    if (!finals.contains(e)) {
      finals.add(e);
    }
  }

  /**
   * Compute the number of states that are the source of at least one transition
   *
   * @return this number of states
   */
  int size() {
    return transitions.size();
  }

  /**
   * zeroOrMore = oneOrMore + optional
   */
  void zeroOrMore() {
    oneOrMore();
    optional();
  }

  static TransducerComp TEST_read(InputStream input) throws IOException {


    TransducerComp t = new TransducerComp();

    t.initial = Compression.multibyte_read(input);
    int finals_size = Compression.multibyte_read(input);

    int base = 0;

    Set<Integer> myfinals = new TreeSet<Integer>();

    while (finals_size > 0) {
      System.out.println("finals_size : " + finals_size);
      finals_size--;
      base += Compression.multibyte_read(input);
      t.finals.add(base);
    }

    base = Compression.multibyte_read(input);

    int number_of_states = base;
    int current_state = 0;
    /*
     * while (number_of_states > 0) {
     * //System.out.println("number of states : "+number_of_states);
     * int number_of_local_transitions = Compression.multibyte_read(input);
     * int tagbase = 0;
     * if (!t.transitions.containsKey(current_state)) {
     * t.transitions.put(current_state,new TreeMap<Integer,Set<Integer>>());
     * }
     *
     * while (number_of_local_transitions > 0) {
     * //System.out.println("number of local transitions "+number_of_local_transitions);
     * number_of_local_transitions--;
     * tagbase += Compression.multibyte_read(input);
     * int state = (current_state + Compression.multibyte_read(input)) % base;
     * //int i_symbol = alphabet.decode(tagbase).firstInt;
     * //int o_symbol = alphabet.decode(tagbase).second;
     * //System.out.println("i : "+i_symbol+", o : "+o_symbol);
     *
     * if (!t.transitions.get(current_state).containsKey(tagbase)) {
     * t.transitions.get(current_state).put(tagbase, new TreeSet<Integer>());
     * }
     * t.transitions.get(current_state).get(tagbase).add(state);
     * }
     * number_of_states--;
     * current_state++;
     * }
     *
     */
    return t;
  }

  public static void main(String[] args) throws FileNotFoundException, IOException {


    Compile c = new Compile();
    Compile c2 = new Compile();
    c.parse("testdata/apertium-fr-es.fr.dix", Compile.COMPILER_RESTRICTION_LR_VAL);
    //c.parse("../src/test/org/apertium/lttoolbox/test3.dix", NewCompiler.COMPILER_RESTRICTION_LR_VAL);
    //c.parse("../src/test/org/apertium/lttoolbox/test4.dix", NewCompiler.COMPILER_RESTRICTION_LR_VAL);
    //c.parse("../src/test/org/apertium/lttoolbox/test5.dix", NewCompiler.COMPILER_RESTRICTION_LR_VAL);
    //c.parse("../src/test/org/apertium/lttoolbox/test6.dix", NewCompiler.COMPILER_RESTRICTION_LR_VAL);
    //c.parse("../src/test/org/apertium/lttoolbox/test7.dix", NewCompiler.COMPILER_RESTRICTION_LR_VAL);
    //c.parse("../src/test/org/apertium/lttoolbox/short.dix", NewCompiler.COMPILER_RESTRICTION_LR_VAL);


    for (String s : c.sections.keySet()) {
      System.out.println("considering transducer of section " + s);
      System.out.println("number of states : " + c.sections.get(s).transitions.size());
      int temp = 0;
      int max = 0;
      float average = 0;
      for (int i = 0; i < c.sections.get(s).transitions.size(); i++) {
        temp += c.sections.get(s).transitions.get(i).size();
        average += temp;
        max = (temp > max) ? temp : max;
        temp = 0;
      }
      System.out.println("maximal number of transitions leaving a state " + max);
      System.out.println("average number of transitions leaving a state " + average / ((float) c.sections.get(s).transitions.size()));
    }

    //System.exit(-1);
    OutputStream output = new BufferedOutputStream(new FileOutputStream("testTransducer2.bin"));
    c.write(output);
    output.close();
    //InputStream input = new InputStream(new BufferedInputStream (new FileInputStream("testTransducer2.bin")));
    InputStream input = new BufferedInputStream(new FileInputStream("outc"));
    //c2 = c.DEBUG_read(input);

    //FSTProcessor fstp = new FSTProcessor();
    //fstp.load(input);
    String letters = Compression.String_read(input);
    Alphabet a = new Alphabet();
    a.read(input);

    Map<String, TransducerComp> sections = new HashMap<String, TransducerComp>();

    int len = Compression.multibyte_read(input);

    while (len > 0) {
      String name = Compression.String_read(input);

      if (!sections.containsKey(name)) {
        sections.put(name, new TransducerComp());
      }
      System.out.println("reading : " + name);
      //if (len ==2) {System.exit(-1);}
      sections.put(name, TEST_read(input));

      len--;
      if (c.sections.get(name) != null && sections.get(name) != null) {
        System.out.println(c.sections.get(name).DEBUG_compare(sections.get(name)));
      }
      //System.exit(-1);
      //throw new RuntimeException("section "+name+" was totaly DEBUG_read");
    }
    input.close();

    for (String s : c.sections.keySet()) {
      int count1 = 0;
      int max1 = 0;
      int count2 = 0;
      int max2 = 0;
      for (int i = 0; i < c.sections.get(s).transitions.size(); i++) {
        if (i > max1) {
          max1 = i;
        }
        for (Integer j : c.sections.get(s).transitions.get(i).keySet()) {

          count1 += c.sections.get(s).transitions.get(i).get(j).size();
        }
      }
      for (int i = 0; i < sections.get(s).transitions.size(); i++) {
        if (i > max2) {
          max2 = i;
        }
        for (Integer j : sections.get(s).transitions.get(i).keySet()) {
          count2 += sections.get(s).transitions.get(i).get(j).size();
        }
      }

      System.out.println("comparing transducers of section " + s);
      //System.out.println("original transducer : "+c.sections.get(s));
      System.out.println("original transducer has " + count1 + " transitions");
      System.out.println("original transducer higher state is " + max1);
      //System.out.println("DEBUG_read transducer : "+sections.get(s));
      System.out.println("read transducer has " + count2 + " transitions");
      System.out.println("read transducer higher state is " + max2);
      //System.out.println(c.sections.get(s).DEBUG_compare(sections.get(s)));
    }

    //System.out.println(c.DEBUG_compare(c2));


  }
}