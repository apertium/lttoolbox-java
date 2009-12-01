package org.apertium.lttoolbox.process;

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

import org.apertium.lttoolbox.Alphabet;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

/**
 * Class to represent the states of a transducer 
 * @author Raah
 */
public class State {

/**
 * Class to represent the current state of transducer processing
 * @author Raah
 */
private static class TNodeState {

    Node where;
    List<Integer> sequence;
    boolean dirty;

    public TNodeState(Node w, List<Integer> s, boolean dirty) {
        this.where = w;
        this.sequence = s;
        this.dirty = dirty;
    }

    public TNodeState(TNodeState other) {
        this.where = other.where;
        this.sequence = other.sequence;
        this.dirty = other.dirty;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(sequence.size());
        for (int i : sequence) sb.append((char)i);
        sb.append('→');
        for (int i : where.transitions.keySet()) sb.append((char)i);
        return sb.toString() + "/" + dirty;
    }
}


    private List<TNodeState> state;
    
    /**
     * Pool of characters ArrayLists, for efficiency (static class)
     */
    //JACOBstatic Pool<List<Integer>> pool;

     private static final boolean DEBUG=false;

  State copy(State initial_state) {
    this.state.clear();
    this.state.addAll(initial_state.state);
    return this;
  }

    /**
     * Initialisation method for the static attribute
     */
    void poolInit() {
        //JACOB pool = new Pool<List<Integer>>();
    }

    /**
     * The constructor
     */
    public State() {
        state = new ArrayList<TNodeState>();
    }

    /**
     * Copy constructor
     * @param s the state to be copied
    public State(State s) {
        copy(s);
    }
     */

    /**
     * Copy method
     * @param s the state to be copied
    void copy(State s) {
        // release references
        for (int i = 0,  limit = state.size(); i != limit; i++) {
            pool.release(state.get(i).sequence);
        }

        state = s.state;

        for (int i = 0,  limit = state.size(); i != limit; i++) {
            List<Integer> tmp = pool.get();
            tmp = (state.get(i).sequence);
            state.get(i).sequence = tmp;
        }
    }
     */

    /**
     * Number of alive transductions
     * @return the size
     */
    int size() {
        return state.size();
    }

    /**
     * Init the state with the initial node and empty output
     * @param initial the initial node of the transducer
     */
    public void init(Node initial) {
        state.clear();
        state.add(0, new TNodeState(initial, new ArrayList<Integer>(), false)); // JACOBpool.get()
        state.get(0).sequence = new ArrayList<Integer>();
        epsilonClosure();
    }

    /**
     * Make a transition, version for lowercase letters and symbols
     * @param input the input symbol
     */
    void apply(int input) {

        List<TNodeState> new_state = new ArrayList<TNodeState>();

        if (input == 0) {
            state = new_state;
            return;
        }

        if (DEBUG) System.err.println("apply(" + (char) input + "  state="+state.size());

        for (int i = 0,  limit = state.size(); i != limit; i++) {
            TNodeState state_i = state.get(i);
            Transition it = state_i.where.transitions.get(input);
            while (it != null) {
              //XXX no pool now: List<Integer> new_v = pool.get();
              List<Integer> new_v = new ArrayList<Integer>();
              new_v.addAll(state_i.sequence);

              if (DEBUG) System.err.println(i + " " +  (char) input + "  state="+state.size());

              if (input != 0) {
                  new_v.add(it.out_tag);
              }
              new_state.add(new TNodeState(it.dest, new_v, state_i.dirty));
              it = it.next;
            }
            //XXX no pool now: pool.release(state.get(i).sequence);
        }


        state = new_state;
    }

    /**
     * Make a transition, version for lowercase and uppercase letters
     * @param input the input symbol
     * @param alt the alternative input symbol
     */
    void apply(int input, int alt) {

        List<TNodeState> new_state = new ArrayList<TNodeState>();

        for (int i = 0,  limit = state.size(); i != limit; i++) {
            TNodeState state_i = state.get(i);
            Transition it = state_i.where.transitions.get(input);
            while (it != null) {
                    List<Integer> new_v;// JACOB = pool.get();
                    new_v = new ArrayList<Integer>(state_i.sequence);
                    if (input != 0) {
                        new_v.add(it.out_tag);
                    }
                    new_state.add(new TNodeState(it.dest, new_v, state_i.dirty));
                    it = it.next;
            }
            it = state_i.where.transitions.get(alt);
            while (it != null) {
                    List<Integer> new_v; // JACOB = pool.get();
                    new_v = new ArrayList<Integer>(state_i.sequence);
                    if (alt != 0) {
                        new_v.add(it.out_tag);
                    }
                    new_state.add(new TNodeState(it.dest, new_v, true));
                    it = it.next;
            }
            //JACOBpool.release(state.get(i).sequence);
        }

        state = new_state;
    }

    /**
     * Calculate the epsilon closure over the current state, replacing
     * its content.
     */
    void epsilonClosure() {
        for (int i = 0; i != state.size(); i++) {
            TNodeState state_i = state.get(i);
            Transition it2 = state_i.where.transitions.get(0);
            while (it2 != null) {
                List<Integer> tmp; // JACOB = pool.get();
                tmp = new ArrayList<Integer>(state_i.sequence);
                if (it2.out_tag != 0) {
                    tmp.add(it2.out_tag);
                }
                state.add(new TNodeState(it2.dest, tmp, state_i.dirty));
                it2 = it2.next;
            }
        }
    }

    /**
     * step = apply + epsilonClosure
     * @param input the input symbol
     */
    void step(int input) {
        if (DEBUG) System.err.println();
        if (DEBUG) System.err.println("state f = " + state);
        if (DEBUG) System.err.println("apply (" + (char) input);

        apply(input);
        if (DEBUG) System.err.println("state e1= " + state);
        epsilonClosure();
        if (DEBUG) System.err.println("state e2= " + state);
    }

    /**
     * step = apply + epsilonClosure
     * @param input the input symbol
     * @param alt the alternative input symbol
     */
    void step(int input, int alt) {
        apply(input, alt);
        epsilonClosure();
    }

    /**
     * Return true if at least one record of the state references a
     * final node of the set
     * @param finals set of final nodes 
     * @return true if the state is final
     */
    boolean isFinal(Set<Node> finals) {
        //if (finals.isEmpty()) return false;
        for (int i = 0,  limit = state.size(); i != limit; i++) {
            if (finals.contains(state.get(i).where)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Print all outputs of current parsing, preceeded by a bar '/', from the final nodes of the state. Examples:
     * /le<prn><pro><p3><nt>/le<det><def><m><sg>/le<prn><pro><p3><m><sg>
     * /domaine<n><m><sg>
     * /,<cm>
     * @param finals the set of final nodes
     * @param alphabet the alphabet to decode strings
     * @param escaped_chars the set of chars to be preceeded with one backslash
     * @param uppercase true if the word is uppercase
     * @param firstupper true if the first letter of a word is uppercase
     * @return the result of the transduction
     */
    String filterFinals(Set<Node> finals, Alphabet alphabet, SetOfCharacters escaped_chars,
        boolean uppercase, boolean firstupper) {
      int firstchar = 0;

      if (DEBUG) System.err.println("filterFinals( " + uppercase + " "+ firstupper + " "+ firstchar);

        StringBuilder result = new StringBuilder();

        for (int i = 0,  limit = state.size(); i != limit; i++) {
            TNodeState state_i = state.get(i);
            if (finals.contains(state_i.where)) {
                if (state_i.dirty) {
                    result.append('/');
                    int first_char = result.length() + firstchar;

                    for (int j = 0,  limit2 = state_i.sequence.size(); j != limit2; j++) {
                        if (escaped_chars.contains((char) ((state_i.sequence)).get(j).intValue())) {
                            result.append('\\');
                        }
                        // alphabet.getSymbol(result, (*(state[i].sequence))[j], uppercase); was missing
                        result.replace(0, Integer.MAX_VALUE, alphabet.getSymbol(result.toString(), (state_i.sequence).get(j).intValue(), uppercase));
                    }
                    if (firstupper) {

                        if (result.charAt(first_char) == '~') {
                            // skip post-generation mark
                            result.setCharAt(first_char + 1, Character.toUpperCase(result.charAt(first_char + 1)));
                        } else {
                            result.setCharAt(first_char, Character.toUpperCase(result.charAt(first_char)));
                        }
                    }
                } else {
                    result.append('/');
                    for (int j = 0,  limit2 = state_i.sequence.size(); j != limit2; j++) {
                        int symbol = ((state_i.sequence).get(j)).intValue();
                        if (escaped_chars.contains((char) symbol)) {
                            result.append('\\');
                        }
                        result.replace(0, Integer.MAX_VALUE, alphabet.getSymbol(result.toString(), symbol));
                    }
                }
            }
        }
      //System.err.println("filterFinals RET ( " + result);
        return result.toString();
    }

    /**
     * Same as previous one, but  the output is adapted to the SAO system
     * @param finals the set of final nodes
     * @param alphabet the alphabet to decode strings
     * @param escaped_chars the set of chars to be preceeded with one backslash
     * @param uppercase true if the word is uppercase
     * @param firstupper true if the first letter of a word is uppercase
     * @param firstchar first character of the word
     * @return the result of the transduction
     */
    String filterFinalsSAO(Set<Node> finals,
        Alphabet alphabet,
        SetOfCharacters escaped_chars,
        boolean uppercase, boolean firstupper, int firstchar) {
        StringBuilder result = new StringBuilder("");

        for (int i = 0,  limit = state.size(); i != limit; i++) {
            TNodeState state_i = state.get(i);
            if (finals.contains(state_i.where)) {
                result.append('/');
                int first_char = result.length() + firstchar;
                for (int j = 0,  limit2 = state_i.sequence.size(); j != limit2; j++) {
                    if (escaped_chars.contains((char) (state_i.sequence).get(j).intValue())) {
                        result.append('\\');
                    }
                    if (alphabet.isTag(((state_i.sequence)).get(j))) {
                        result.append('&');
                        result.replace(0, Integer.MAX_VALUE, alphabet.getSymbol(result.toString(), state_i.sequence.get(j)));
                        result.setCharAt(result.length() - 1, ';');
                    } else {
                        result.replace(0, Integer.MAX_VALUE, alphabet.getSymbol(result.toString(), ((state_i.sequence)).get(j), uppercase));
                    }
                }
                if (firstupper) {
                    if (result.charAt(first_char) == '~') {
                        // skip post-generation mark
                        result.setCharAt(first_char + 1, Character.toUpperCase(result.charAt(first_char + 1)));
                    } else {
                        result.setCharAt(first_char, Character.toUpperCase(result.charAt(first_char)));
                    }
                }
            }
        }

        return result.toString();
    }

    /**
     * Same as previous one, but  the output is adapted to the TM system
     * @param finals the set of final nodes
     * @param alphabet the alphabet to decode strings
     * @param escaped_chars the set of chars to be preceeded with one backslash
     * @param uppercase true if the word is uppercase
     * @param firstupper true if the first letter of a word is uppercase
     * @param firstchar first character of the word
     * @return the result of the transduction
     */
    String filterFinalsTM(Set<Node> finals, Alphabet alphabet, SetOfCharacters escaped_chars, ArrayDeque<String> blankqueue, ArrayList<String> numbers) {
        String result = "";
        for (int i = 0,  limit = state.size(); i < limit; i++) {
            TNodeState state_i = state.get(i);
            if (finals.contains(state_i.where)) {
                result += '/';
                for (int j = 0,  limit2 = state_i.sequence.size(); j < limit2; j++) {
                    if (escaped_chars.contains((char) state_i.sequence.get(j).intValue())) {
                        result += '\\';
                    }
                    result = alphabet.getSymbol(result, state_i.sequence.get(j));
                }
            }
        }
        String result2 = "";
        ArrayList<String> fragments = new ArrayList<String>();
        fragments.add("");
        for (int i = 0,  limit = result.length(); i < limit; i++) {
            if (result.charAt(i) == ')') {
                fragments.add("");
            } else {
                fragments.set(fragments.size() - 1, fragments.get(fragments.size() - 1) + result.charAt(i));
            }
        }

        for (int i = 0,  limit = fragments.size(); i < limit; i++) {
            if (i < limit - 1) {
                if (fragments.get(i).length() >= 2 &&
                    fragments.get(i).substring(fragments.get(i).length() - 2).equals("(#")) {
                    String whitespace = "";
                    if (blankqueue.size() != 0) {
                        whitespace = blankqueue.getFirst().substring(1);
                        blankqueue.removeFirst();
                        whitespace = whitespace.substring(0, whitespace.length() - 1);
                    }
                    fragments.set(i, fragments.get(i).substring(0, fragments.get(i).length() - 2) + whitespace);
                } else {
                    boolean replaced = false;
                    for (int j = fragments.size() - 1; j >= 0; j--) {
                        if (fragments.get(i).length() > 3 &&
                            fragments.get(i).charAt(j) == '\\' &&
                            fragments.get(i).charAt(j + 1) == '@' &&
                            fragments.get(i).charAt(j + 2) == '(') {
                            int num = 0;
                            boolean correct = true;
                            for (int k = j + 3,  limit2 = fragments.get(i).length(); k < limit2; k++) {

                                if (iswdigit(fragments.get(i).charAt(k))) {
                                    num *= 10;
                                    num += ((int) fragments.get(i).charAt(k)) - 48;
                                } else {
                                    correct = false;
                                    break;
                                }
                            }
                            if (correct) {
                                fragments.set(i, fragments.get(i).substring(0, j) + numbers.get(num - 1));
                                replaced = true;
                                break;
                            }
                        }
                    }
                    if (!replaced) {
                        fragments.set(i, fragments.get(i) + ')');
                    }
                }
            }
        }
        result = "";
        for (int i = 0,  limit = fragments.size(); i < limit; i++) {
            result += fragments.get(i);
        }
        return result;
    }
    
    /**
     * Compute if a character is a digit (gives the same results as 
     * the c++ iswdigit() function
     * @param c the character
     * @return true if the c is a digit
     */
    private boolean iswdigit(char c) {
        int i = (int)c;
        return ((i>=48&&i<=57)||i==178||i==179||i==185);
    }
}
