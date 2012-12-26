package org.apertium.lttoolbox.collections;

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

import org.apertium.lttoolbox.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Class to represent a letter transducer during the dictionary compilation
 * @author Raah
 */
public class Transducer {

    /**
     * Initial state
     */
    protected Integer initial;

    /**
     * tag for epsilon transitions
     */
    protected Integer epsilon_tag  = 0;

    /**
     * Final state set
     */
    protected AbundantIntSet finals = new AbundantIntSet();

    /**
     * Transitions of the transducer.
     * Before we used a Map here, but as the keys are 1, 2, 3, 4, 5, ...up to the number of states its been changed to an ArrayList
     */
    public ArrayList<Map<Integer, IntSet>> transitions = new ArrayList<Map<Integer, IntSet>>();
    //public Map<Integer, Map<Integer, Set<Integer>>> transitions = new HashMap<Integer, Map<Integer, Set<Integer>>>();

    public static boolean DEBUG=false;



    /**
     * String conversion method to be able to display a transducer
     * @return a string description of the transducer
     */
    @Override
    public String toString() {
        String res = "";
        res+="initial :"+initial+" - ";
        res+= "finals :"+finals+"\n";
        res+= "transitions :"+transitions+"";
        return res;
    }

    /**
     * Returns the initial state of a transducer
     * @return the initial state identifier
     */
    public Integer getInitial() {
        return initial;
    }

    public boolean isFinal(int state) {
      return finals.contains(state);
    }

    public void setFinal(int state) {
      //setFinal(state, true);
      finals.add(state);
    }

    public void setFinal(int state, boolean valor) {
      if (valor) {
        finals.add(state);
      } else {
        finals.remove(state);
      }
    }

   /**
     * Link two existing states by a transduction
     * @param source the source state
     * @param destination the target state
     * @param label the tag of the transduction
     */
    public void linkStates(Integer source, Integer destination, Integer label) {

        if (transitions.size() > source && transitions.size() > destination) {
            Map<Integer, IntSet> place = transitions.get(source);
            IntSet set = place.get(label);
            if (set == null) {
                set = new SlowIntegerHashSet();
                place.put(label, set);
            }
            set.add(destination);
        } else {
            throw new RuntimeException("Error: Trying to link nonexistent states (" + source + ", " + destination + ", " + label + ")");
        }
    }

    /**
     * New state creator
     * @return the new state number
     */
    protected Integer newState() {
        Integer nstate = transitions.size();
        //transitions.put(nstate, new HashMap<Integer, Set<Integer>>());
        transitions.add(new HashMap<Integer, IntSet>());
        return nstate;
    }

    /**
     * Constructor
     */
    public Transducer() {
        initial = newState();
    }

    /**
     * Creates a new Transducer object by copying the one passed in.
     * @param t - The Transducer object to copy.
     */
    public Transducer(Transducer t) {
    	copy(t);
    }

    /**
     * Copies the passed-in Transducer object to this one.
     * @param t - The Transducer object to copy.
     */
    private void copy(Transducer t) {
    	initial = t.initial;
    	finals = new AbundantIntSet(t.finals);
    	transitions = new ArrayList<Map<Integer, IntSet>>(t.transitions);
    }

    /**
     * Insertion of a single transduction, creating a new target state
     * if needed
     * @param tag the tag of the transduction being inserted
     * @param source the source state of the new transduction
     * @return the target state
     */
    public Integer insertSingleTransduction(Integer tag, Integer source) {
      //while (transitions.size()<=source) transitions.add(new TreeMap<Integer, Set<Integer>>());

      Map<Integer, IntSet> place = transitions.get(source);
        IntSet set = place.get(tag);

        if (set == null) {
            set = new SlowIntegerHashSet();
            place.put(tag, set);
        } else {
            return set.iterator().next();
        }
        Integer state = newState();
        set.add(state);
        return state;
    }

    /**
     * Returns the epsilon closure of a given state
     * @param state the state
     * @return the set of the epsilon-connected states
     */
    public Set<Integer> closure(Integer state) {
        HashSet<Integer> nonvisited = new HashSet<Integer>();
        HashSet<Integer> result = new HashSet<Integer>();
        nonvisited.add(state);
        result.add(state);
        while (nonvisited.size() > 0) {
            Integer auxest = nonvisited.iterator().next();
            if (auxest< transitions.size()) {
              Map<Integer, IntSet> place = transitions.get(auxest);
              IntSet set = place.get(epsilon_tag);
                if (set !=null) {
                    for (Integer i : set) {
                        if (!result.contains(i)) {
                            nonvisited.add(i);
                            result.add(i);
                        }
                    }
                }
            }
            result.add(auxest);
            nonvisited.remove(auxest);
        }
        return result;
    }

    /**
     * Compare the tranducer with another one
     * @param t the transducer to DEBUG_compare to
     * @return true if the two transducers are similar
     */
    public boolean DEBUG_compare(Transducer other) {
        boolean sameSize = true;
        boolean sameInitial = true;
        boolean sameFinals = true;
        System.out.println(("comparing this:\n"+this+"\nwith other:\n "+other)); // .replaceAll("\n", " ")
       if (other == null) {
            System.out.println("comparing with a null transducer");
            return false;
        }
        if (!(initial.equals(other.initial))) {
            System.out.println("the two transducer have different initial states");
            sameInitial = false;
            return false;
        }
        if (finals.size() != other.finals.size()) {
            System.out.println("the two transducer have a different number of final states");
            sameFinals = false;
            return false;
        }
        /*
        for (Integer i : finals) {
            if (!other.finals.contains(i)) {
                System.out.println("the state " + i + " is a final state in the firstInt transducer but not in the second one");
                sameFinals = false;
            return false;
            }
        }
         */
        if (transitions.size() != other.transitions.size()) {
            System.out.println("the two transducers have different sizes for their attribute transitions");
            sameSize = false;
        }
        boolean sameTransducer = true;
        /*
        for (Integer source : transitions.keySet()) {
            boolean sameTransitionsFromSource = true;
            if (!other.transitions.containsKey(source)) {
                System.out.println("key " + source + " exists in this.transitions, but not in t.transitions");
                sameTransducer = false;
                break;
            }
            if (!(transitions.get(source).size() == other.transitions.get(source).size())) {
                System.out.println("the transducers have a different number of transitions leaving the state " + source);
                sameTransducer = false;
                break;
            }
            for (Integer label : transitions.get(source).keySet()) {
                if (!other.transitions.get(source).containsKey(label)) {
                    System.out.println("the state " + source + " has a transition with label " + label + " in this.transitions, but not in t.transitions");
                    sameTransducer = false;
                    break;
                }
                if (!(transitions.get(source).get(label).size() == other.transitions.get(source).get(label).size())) {
                    System.out.println("the transducers have a different number of transitions leaving the state " + source + " with the label " + label);
                    sameTransducer = false;
                    break;
                }
                for (Integer destination : transitions.get(source).get(label)) {
                    if (!other.transitions.get(source).get(label).contains(destination)) {
                        System.out.println("there is a transition from the state " + source +
                            " to the state " + destination + " with the label " + label +
                            " which is in this.transitions and not in t.transitions");
                        sameTransducer = false;
                    }
                }
            }
        }
         */
        return (sameInitial && sameFinals && sameSize && sameTransducer);
    }
  Map<Integer, IntSet> getCreatePlace(int state) {
    // new_t.transitions[state].clear(); // force create

   // System.err.println("transitions.size() = " + transitions.size()+ "   " +state);
    Map<Integer, IntSet> place;
    if (transitions.size()<=state) {
      place = new TreeMap<Integer, IntSet>();
      transitions.add(place);
    } else {
      place=transitions.get(state);
    }

    return place;
  }

      private void ensureCreatedPlace(int state) {
    if (transitions.size()<=state) {
      transitions.add(new TreeMap<Integer, IntSet>());
    }
  }


    /**
     * Add a transduction to the transducer
     * @param source the source state
     * @param label the tag
     * @param destination the target state
     */
    private void addTransition(int current_state, int symbol, int state) {
        Map<Integer, IntSet> place=getCreatePlace(current_state);
        addTransition(place, symbol, state);
    }

    /**
     * Add a transduction to the transducer
     * @param source the source state
     * @param label the tag
     * @param destination the target state
     */
    void addTransition(Map<Integer, IntSet> place, int symbol, int state) {
       // unneccesary according to test , but needed according to C++ code:
       // new_t.transitions[state].clear(); // force create
       ensureCreatedPlace(state);

        // new_t.transitions[current_state].insert(pair<int, int>(tagbase, state));
       /* old code
        Set<Integer> set = place.get(tagbase);
        if (set == null) {
            set = new TreeSet<Integer>();
            place.put(tagbase, set);
        }
         */
        // new faster code assumes no set it already present - might be wrong for new uses
        IntSet set = new SlowIntegerTreeSet();
        place.put(symbol, set);
        set.add(state);
    }

    /**
     * Read a transducer from an input stream
     * @param input the stream to read from
     * @param alphabet the alphabet to decode the symbols
     * @return the transducer read from the stream
     * @throws java.io.IOException
     */
    public static Transducer read(InputStream input) throws IOException {
      return read(input,0);
    }

    public static Transducer read(InputStream input, int decalage) throws IOException {

        Transducer t = new Transducer();
        t.transitions.clear();

        //reading the initial state
        t.initial = Compression.multibyte_read(input);


        //System.err.println("t.initial  = " + t.initial );

        //reading the final states
        int base = 0;
        for (int i = Compression.multibyte_read(input); i > 0; i--) {
            int read = Compression.multibyte_read(input);
            base += read;
            t.finals.add(base);
        }


        //System.err.println("t.finals = " + t.finals.size());

        //reading the transitions
        int number_of_states = Compression.multibyte_read(input);
        base = number_of_states;
        int current_state = 0;

        for (int i = number_of_states; i > 0; i--) {
            int number_of_local_transitions = Compression.multibyte_read(input);
            if (number_of_local_transitions>0) {
              int tagbase = 0;
              Map<Integer, IntSet> place=t.getCreatePlace(current_state);

              for (int j = number_of_local_transitions; j > 0; j--) {
                  tagbase += Compression.multibyte_read(input)- decalage;
                  int state = (current_state + Compression.multibyte_read(input)) % number_of_states;
                  // t.addTransition(current_state, tagbase, state);
                  t.addTransition(place, tagbase, state);
              }
            }
            current_state++;
        }

        return t;
    }

    /**
     * Write the transducer to an output stream
     * @param output the output strem
     * @param decalage offset to sum to the tags
     * @throws java.io.IOException
     */
    public void write(OutputStream output, int decalage) throws IOException {
        Compression.multibyte_write(initial, output);
        Compression.multibyte_write(finals.size(), output);
        int base = 0;

         for (int it = finals.next(0); it >= 0; it = finals.next(it+1)) {
            Compression.multibyte_write(it - base, output);
            base = it;
         }

        base = transitions.size();
        Compression.multibyte_write(base, output);
        for(int itFirst=0; itFirst<transitions.size(); itFirst++) {
            int size = 0;
            Map<Integer, IntSet> place = transitions.get(itFirst);
            for (Integer it2First : place.keySet()) {
                size+=place.get(it2First).size();
            }
            Compression.multibyte_write(size, output);
            int tagbase = 0;
            for (Integer it2First : place.keySet()) {
                for (Integer it2Second : place.get(it2First)) {
                    Compression.multibyte_write(it2First - tagbase + decalage, output);
                    tagbase = it2First;
                    if (it2Second >= itFirst) {
                        Compression.multibyte_write(it2Second - itFirst, output);
                    } else {
                        Compression.multibyte_write(it2Second + base - itFirst, output);
                    }
                }
            }
        }
    }
}
