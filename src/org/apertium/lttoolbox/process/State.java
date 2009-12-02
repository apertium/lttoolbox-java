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
 * one state element in  the current set of states of transducer processing
 * @author Raah
 */
class TNodeState {

    /** Which node are we currently visiting */
    Node where;

    /** The list of output symbols we produced while getting to this node */
    List<Integer> sequence;


    /** caseWasChanged means input was lowercased - thus we should consider uppercasing the output symbols  before outputting */
    boolean caseWasChanged;

    public TNodeState(Node where, List<Integer> sequence, boolean caseWasChanged) {
        this.where = where;
        this.sequence = sequence;
        this.caseWasChanged = caseWasChanged;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(sequence.size());
        for (int i : sequence) sb.append((char)i);
        sb.append('→');
        for (int i : where.transitions.keySet()) sb.append((char)i);
        return sb.toString() + "/" + caseWasChanged;
    }
}

/**
 * Class to represent the set of alive states of a transducer
 * @author Raah
 */
public class State {


    private List<TNodeState> state = new ArrayList<TNodeState>();
    
    /**
     * Pool of characters ArrayLists, for efficiency (static class)
     */
    //JACOBstatic Pool<List<Integer>> pool;

     private static final boolean DEBUG=false;

      State copy(State other_state) {
        this.state.clear();
        this.state.addAll(other_state.state);
        return this;
      }

      State copy() {
        return new State().copy(this);
      }

    /**
     * Initialisation method for the static attribute
     */
    void poolInit() {
        //JACOB pool = new Pool<List<Integer>>();
    }

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
    private void apply(int input) {
        List<TNodeState> new_state = new ArrayList<TNodeState>();
        for (int i = 0,  limit = state.size(); i != limit; i++) {
            TNodeState state_i = state.get(i);
            Transition it = state_i.where.transitions.get(input);
            while (it != null) {
              ArrayList<Integer> new_sequence = new ArrayList<Integer>(state_i.sequence.size()+1); //XXX no pool for now: new_v = pool.get();
              new_sequence.addAll(state_i.sequence);
              new_sequence.add(it.output_symbol);
              new_state.add(new TNodeState(it.dest, new_sequence, state_i.caseWasChanged));
              it = it.next;
            } //XXX no pool now: pool.release(state.get(i).sequence);
        }
        state = new_state;
    }

    /**
     * Make a transition, version for lowercase and uppercase letters
     * @param input the input symbol (which is actually always uppercase)
     * @param lowerCasedInput the alternative input symbol (actually its always Character.toLowerCase(input))
     */
    private void apply(int input, int lowerCasedInput) {

        List<TNodeState> new_state = new ArrayList<TNodeState>();

        for (int i = 0,  limit = state.size(); i != limit; i++) {
            TNodeState state_i = state.get(i);
            Transition it = state_i.where.transitions.get(input);
            while (it != null) {
              ArrayList<Integer> new_sequence = new ArrayList<Integer>(state_i.sequence.size()+1); //XXX no pool for now: new_v = pool.get();
              new_sequence.addAll(state_i.sequence);
              new_sequence.add(it.output_symbol);
              new_state.add(new TNodeState(it.dest, new_sequence, state_i.caseWasChanged));
              it = it.next;
            } //XXX no pool now: pool.release(state.get(i).sequence);

            // try also apply lowerCasedInput
            it = state_i.where.transitions.get(lowerCasedInput);
            while (it != null) {
              ArrayList<Integer> new_sequence = new ArrayList<Integer>(state_i.sequence.size()+1); //XXX no pool for now: new_v = pool.get();
              new_sequence.addAll(state_i.sequence);
              new_sequence.add(it.output_symbol);
              new_state.add(new TNodeState(it.dest, new_sequence, true)); // caseWasChanged=true - lowercased version of input
              it = it.next;
            }
            //JACOBpool.release(state.get(i).sequence);
        }

        state = new_state;
    }

    /**
     * Calculate the epsilon closure over the current state, replacing its content.
     * i.e. expand to all states reachable consuming θ (the empty input symbol)
     */
    private void epsilonClosure() {
        for (int i = 0; i != state.size(); i++) {
            TNodeState state_i = state.get(i);
            // get the transitions consuming θ (the empty input symbol)
            Transition it2 = state_i.where.transitions.get(0);  
            while (it2 != null) {
                List<Integer> tmp; // JACOB = pool.get();
                tmp = new ArrayList<Integer>(state_i.sequence);
                if (it2.output_symbol != 0) {
                    tmp.add(it2.output_symbol);
                }
                state.add(new TNodeState(it2.dest, tmp, state_i.caseWasChanged));
                it2 = it2.next;
            }
        }
    }

    /**
     * step = apply + epsilonClosure
     * @param input the input symbol
     */
    public void step(int input) {
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
     * @param alt the alternative input symbol (typically lowercase version of input symbol)
     */
    public void step(int input, int lowerCasedInput) {
        apply(input, lowerCasedInput);
        epsilonClosure();
    }



    public void step_case(char val, boolean caseSensitive) {
        if (!Character.isUpperCase(val) || caseSensitive) {
            step(val);
        } else {
            step(val, Character.toLowerCase(val));
        }
    }

    public void step_case(int val, boolean caseSensitive) {
        if (Alphabet.isTag(val) || !Character.isUpperCase(val) || caseSensitive) {
            step(val);
        } else {
            step(val, Character.toLowerCase(val));
        }
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
    String filterFinals(Set<Node> finals, Alphabet alphabet, SetOfCharacters escaped_chars, boolean uppercase, boolean firstupper) {

        StringBuilder result = new StringBuilder();

        for (int i = 0,  limit = state.size(); i != limit; i++) {
            TNodeState state_i = state.get(i);
            if (finals.contains(state_i.where)) {
                result.append('/');
                int first_char = result.length();

                // make uppercase if uppercase &&  case was changed during step (state_i.caseWasChanged)
                boolean upc = uppercase &&  state_i.caseWasChanged;

                for (int j = 0,  limit2 = state_i.sequence.size(); j != limit2; j++) {
                    int symbol = ((state_i.sequence).get(j)).intValue();
                    if (escaped_chars.contains((char) symbol)) {
                        result.append('\\');
                    }
                    result.append(alphabet.getSymbol(symbol, upc));
                }


                if (firstupper && state_i.caseWasChanged ) {
                    if (result.charAt(first_char) == '~') {
                        // skip post-generation mark
                        result.setCharAt(first_char + 1, Character.toUpperCase(result.charAt(first_char + 1)));
                    } else {
                        result.setCharAt(first_char, Character.toUpperCase(result.charAt(first_char)));
                    }
                }
            }
        }
      //System.err.println("filterFinals RET ( " + result);
        return result.toString();
    }


    void restartFinals(Set<Node> finals, Alphabet alphabet, State initial_state, int restartSymbol) {

        for (int i = 0,  limit = state.size(); i != limit; i++) {
            TNodeState state_i = state.get(i);
            if (finals.contains(state_i.where)) {

                // state is final - restart it, conserving old symbols
                for (TNodeState initst : initial_state.state) {
                    ArrayList<Integer> new_sequence = new ArrayList<Integer>(state_i.sequence.size()+1); //XXX no pool for now: new_v = pool.get();
                    new_sequence.addAll(state_i.sequence);
                    new_sequence.add(restartSymbol);
                    state.add(new TNodeState(initst.where, new_sequence, state_i.caseWasChanged));
                }
            }
        }
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
                        result.append(alphabet.getSymbol(state_i.sequence.get(j)));
                        result.setCharAt(result.length() - 1, ';');
                    } else {
                        result.append(alphabet.getSymbol(((state_i.sequence)).get(j), uppercase));
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
                    result += alphabet.getSymbol(state_i.sequence.get(j));
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
