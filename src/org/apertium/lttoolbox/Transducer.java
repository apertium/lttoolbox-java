package org.apertium.lttoolbox;

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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Class to represent a letter transducer during the dictionary compilation
 * @author Raah
 */
public class Transducer {

    /**
     * Initial state
     */
    Integer initial;
    
    /**
     * tag for epsilon transitions
     */
    Integer epsilon_tag  = new Integer(0);
        
    /**
     * Final state set
     */
    Set<Integer> finals = new HashSet<Integer>();

    /**
     * Transitions of the transducer
     */
    Map<Integer, Map<Integer, Set<Integer>>> transitions = new HashMap<Integer, Map<Integer, Set<Integer>>>();



    /**
     * String conversion method to be able to display a transducer
     * @return a string description of the transducer
     */
    public String toString() {
        String res = "";
        res+="initial :\n"+initial+"\n";
        res+= "finals :\n"+finals+"\n";
        res+= "transitions : \n"+transitions+"\n";
        return res;
    }

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
     * @return true if the transducer is empty
     */
    boolean isEmpty() {
        return finals.size() == 0 && transitions.size() == 1;
     }

    /**
     * Transducer minimization
     * Minimize = reverse + determinize + reverse + determinize
     */
    void minimize(){
        reverse();
        determinize();
        reverse();
        determinize();
     }
      
    /**
     * Returns the initial state of a transducer
     * @return the initial state identifier
     */
    Integer getInitial() {
        return initial;
    }

    /**
     * Link two existing states by a transduction
     * @param source the source state
     * @param destination the target state
     * @param label the tag of the transduction
     */
    void linkStates(Integer source, Integer destination, Integer label) {

        if (transitions.size() > source && transitions.size() > destination) {
            Map<Integer, Set<Integer>> place = transitions.get(source);
            Set<Integer> set = place.get(label);
            if (set == null) {
                set = new HashSet<Integer>();
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
    Integer newState() {
        Integer nstate = new Integer(transitions.size());
        transitions.put(nstate, new HashMap<Integer, Set<Integer>>());
        return nstate;
    }

    /**
     * Constructor
     */
    Transducer() {
        initial = newState();
    }

    /**
     * Insertion of a single transduction, creating a new target state
     * if needed  
     * @param tag the tag of the transduction being inserted
     * @param source the source state of the new transduction
     * @return the target state
     */
    Integer insertSingleTransduction(Integer tag, Integer source) {
        Map<Integer, Set<Integer>> place = transitions.get(source);
        Set<Integer> set = place.get(tag);

        if (set != null) {
            return set.iterator().next();
        } else {
            set = new HashSet<Integer>();
            Integer i = newState();
            set.add(i);
            place.put(tag, set);
            return i;
        }
    }

    /**
     * Insertion of a single transduction, forcing create a new target
     * state
     * @param tag the tag of the transduction being inserted
     * @param source the source state of the new transduction
     * @return the target state
     */
    Integer insertNewSingleTransduction(Integer tag, Integer source) {
        Integer state = newState();
        Map<Integer, Set<Integer>> place = transitions.get(source);
        Set<Integer> set = place.get(tag);

        if (set == null) {
            set = new HashSet<Integer>();
            place.put(tag, set);
        }
        set.add(state);
        return state;
    }

    /**
     * Insertion of a transducer in a given source state, unifying their
     * final states using a optionally given epsilon tag
     * @param source the source state
     * @param t the transducer being inserted
     * @return the new target state
     */    
    Integer insertTransducer(Integer source, Transducer t) {
        Integer untranslated_final = t.joinFinals();

        // base of node translation
        final int first_state = transitions.size();

        // copy transducer
        for (int i = 0; i < t.transitions.size(); i++) {
            Integer local_source = newState();
            for (Integer tag : t.transitions.get(i).keySet()) {
                Set<Integer> destset = new HashSet<Integer>();
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
        return first_state + untranslated_final;
    }
    
    /**
     * Computes the number of transitions of a transducer
     * @return the number of transitions
     */
    int numberOfTransitions() {
        int counter = 0;
        for (Integer i : transitions.keySet()) {
            for (Set<Integer> destinations : transitions.get(i).values()) {
                counter += destinations.size();
            }
        }
        return counter;
    }

    /**
     * Set the state as a final or not, yes by default
     * @param e the state
     */
    void setFinal(Integer e) {
        if (!finals.contains(e)) {
            finals.add(e);
        }
    }

    /**
     * Compute the number of states that are the source of at least one transition
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

    /**
     * Computes whether two sets have elements in common
     * @param s1 the first set
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
     * Determinize the transducer
     */
    private void determinize() {
        List<Set<Integer>> R = new ArrayList<Set<Integer>>(2);
        // MUST be TreeSet to retain binary compatibility:
        R.add(new TreeSet<Integer>());
        R.add(new TreeSet<Integer>());

        Map<Integer, Set<Integer>> Q_prima = new HashMap<Integer, Set<Integer>>();
        Map<Set<Integer>, Integer> Q_prima_inv = new HashMap<Set<Integer>, Integer>(); // setComparator

        // MUST be TreeMap to retain binary compatibility:
        Map<Integer, Map<Integer, Set<Integer>>> transitions_prima = new TreeMap<Integer, Map<Integer, Set<Integer>>>();

        int talla_Q_prima = 0;

        Set<Integer> initial_closure = closure(initial);
        Q_prima.put(0, initial_closure);
        Q_prima_inv.put(initial_closure, 0);
        R.get(0).add(0);

        int initial_prima = 0;
        Set<Integer> finals_prima = new TreeSet<Integer>();

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
                    Map<Integer, Set<Integer>> xxx = transitions.get(it2);
                    if (xxx!=null) {
                        for (Integer it3 : xxx.keySet()) {
                            if (!it3.equals(epsilon_tag)) {
                                for (Integer it3p : transitions.get(it2).get(it3)) {
                                    Set<Integer> c = closure(it3p);
                                    Set<Integer> zzz = mymap.get(it3);
                                    if (zzz==null) {
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
                        transitions_prima.put(etiq, new TreeMap<Integer, Set<Integer>>());
                    }

                    if (transitions_prima.size() < it || transitions_prima.get(it) == null) {
                        transitions_prima.put(it, new TreeMap<Integer, Set<Integer>>());
                        transitions_prima.get(it).put(it2.getKey(), new TreeSet<Integer>());
                    } else if (!transitions_prima.get(it).containsKey(it2.getKey())) {
                        transitions_prima.get(it).put(it2.getKey(), new TreeSet<Integer>());
                    }

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
     * @return the only final state
     */
    Integer joinFinals() {
        if (finals.size() > 1) {
            Integer state = newState();
            Iterator<Integer> it = finals.iterator();
            while (it.hasNext()) {
                linkStates(it.next(), state, epsilon_tag);
            }
            finals.clear();
            finals.add(state);
            return state;
        } else if (finals.size() == 0) {
            throw new RuntimeException("Error: empty set of final states");
        } else {
            return finals.iterator().next();
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
        linkStates((Integer) finals.toArray()[0], state, epsilon_tag);
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
        linkStates((Integer) finals.toArray()[0], state, epsilon_tag);
        finals.clear();
        finals.add(state);
        linkStates(initial, state, epsilon_tag);
    }

    /**
     * Reverse all the transductions of a transducer
     */
    private void reverse() {
        Integer newInitial = joinFinals();

        Map<Integer, Map<Integer, Set<Integer>>> result = new TreeMap<Integer, Map<Integer, Set<Integer>>>();

        for (Map.Entry<Integer, Map<Integer, Set<Integer>>> it : transitions.entrySet()) {
            Integer dest = it.getKey();
            for (Map.Entry<Integer, Set<Integer>> it2 : it.getValue().entrySet()) {
                Integer tag = it2.getKey();
                for (Integer origin : it2.getValue()) {
                    Map<Integer, Set<Integer>> res_origin = result.get(origin);
                    if (res_origin==null) {
                        res_origin = new TreeMap<Integer, Set<Integer>>();
                        result.put(origin, res_origin);
                        res_origin.put(tag, new TreeSet<Integer>());

                        Set<Integer> aux = new TreeSet<Integer>();
                        aux.add(dest);

                        Map<Integer, Set<Integer>> aux2 = new TreeMap<Integer, Set<Integer>>();
                        aux2.put(tag, aux);
                        result.put(origin, aux2);
                    } else {
                       Set<Integer> res_origin_tag = res_origin.get(tag);
                        if (res_origin_tag==null) {
                          res_origin_tag = new TreeSet<Integer>();
                          res_origin.put(tag, res_origin_tag);
                        }
                        res_origin_tag.add(dest);
                    }
                }
            }
        }
        finals.clear();
        finals.add(initial);
        initial = newInitial;
        transitions = result;
    }

    /**
     * set the epsilon tag
     * @param e the value to which set the epsilon tag
     */
    public void setEpsilon_Tag (int e) {
        epsilon_tag = e;
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
            Map<Integer, Set<Integer>> place = transitions.get(auxest);
            if (place != null) {
              Set<Integer> set = place.get(epsilon_tag);
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
     * Add a transduction to the transducer
     * @param source the source state
     * @param label the tag
     * @param destination the target state
     */
    void addTransition(Integer current_state, Integer tagbase, Integer state) {
        Map<Integer, Set<Integer>> place = transitions.get(current_state);
        if (place == null) {
            place = new TreeMap<Integer, Set<Integer>>();
            transitions.put(current_state, place);
        }

        // unneccesary according to test , but needed according to C++ code:
        // new_t.transitions[state].clear(); // force create
        Map<Integer, Set<Integer>> destplace = transitions.get(state);
        if (destplace == null) {
           destplace = new TreeMap<Integer, Set<Integer>>();
            transitions.put(state, destplace);
        }

        // new_t.transitions[current_state].insert(pair<int, int>(tagbase, state));
        Set<Integer> set = new TreeSet<Integer>();
        place.put(tagbase, set);
/*
        Set<Integer> set = place.get(tagbase);
        if (set == null) {
            set = new TreeSet<Integer>();
            place.put(tagbase, set);
        }
 */
        set.add(state);
    }

    /**
     * Compare the tranducer with another one
     * @param t the transducer to compare to
     * @return true if the two transducers are similar
     */
    boolean compare(Transducer t) {
        boolean sameSize = true;
        boolean sameInitial = true;
        boolean sameFinals = true;
        if (t == null) {
            System.out.println("comparing with a null transducer");
            return false;
        }
        if (!(initial.equals(t.initial))) {
            System.out.println("the two transducer have different initial states");
            sameInitial = false;
        }
        if (finals.size() != t.finals.size()) {
            System.out.println("the two transducer have a different number of final states");
            sameFinals = false;
        }
        for (Integer i : finals) {
            if (!t.finals.contains(i)) {
                System.out.println("the state " + i + " is a final state in the first transducer but not in the second one");
                sameFinals = false;
            }
        }
        if (transitions.size() != t.transitions.size()) {
            System.out.println("the two transducers have different sizes for their attribute transitions");
            sameSize = false;
        }
        boolean sameTransducer = true;
        for (Integer source : transitions.keySet()) {
            boolean sameTransitionsFromSource = true;
            if (!t.transitions.containsKey(source)) {
                System.out.println("key " + source + " exists in this.transitions, but not in t.transitions");
                sameTransducer = false;
                continue;
            }
            if (!(transitions.get(source).size() == t.transitions.get(source).size())) {
                System.out.println("the transducers have a different number of transitions leaving the state " + source);
                sameTransducer = false;
                continue;
            }
            for (Integer label : transitions.get(source).keySet()) {
                if (!t.transitions.get(source).containsKey(label)) {
                    System.out.println("the state " + source + " has a transition with label " + label + " in this.transitions, but not in t.transitions");
                    sameTransducer = false;
                    continue;
                }
                if (!(t.transitions.get(source).get(label).size() == t.transitions.get(source).get(label).size())) {
                    System.out.println("the transducers have a different number of transitions leaving the state " + source + " with the label " + label);
                    sameTransducer = false;
                    continue;
                }
                for (Integer destination : transitions.get(source).get(label)) {
                    if (!t.transitions.get(source).get(label).contains(destination)) {
                        System.out.println("there is a transition from the state " + source +
                            " to the state " + destination + " with the label " + label +
                            " which is in this.transitions and not in t.transitions");
                        sameTransducer = false;
                    }
                }
            }
        }
        return (sameInitial && sameFinals && sameSize && sameTransducer);
    }

    /**
     * Read a transducer from an input stream
     * @param input the stream to read from
     * @param alphabet the alphabet to decode the symbols
     * @return the transducer read from the stream
     * @throws java.io.IOException
     */
    public static Transducer read(DataInputStream input, Alphabet alphabet) throws IOException {

        Transducer t = new Transducer();
        t.transitions.clear();

        //reading the initial state
        t.initial = Compression.multibyte_read(input);

        //reading the final states
        int base = 0;
        for (int i = Compression.multibyte_read(input); i > 0; i--) {
            int read = Compression.multibyte_read(input);
            t.finals.add(read + base);
            base += read;
        }

        //reading the transitions
        int number_of_states = Compression.multibyte_read(input);
        base = number_of_states;
        int current_state = 0;

        for (int i = number_of_states; i > 0; i--) {
            int number_of_local_transitions = Compression.multibyte_read(input);
            int tagbase = 0;

            for (int j = number_of_local_transitions; j > 0; j--) {
                tagbase += Compression.multibyte_read(input);
                int state = (current_state + Compression.multibyte_read(input)) % number_of_states;
                t.addTransition(current_state, tagbase, state);
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
    void write(DataOutputStream output, int decalage) throws IOException {
        Compression.multibyte_write(initial, output);
        Compression.multibyte_write(finals.size(), output);
        int base = 0;
        for (Integer it : finals) {
            Compression.multibyte_write(it - base, output);
            base = it;
        }
        base = transitions.size();
        Compression.multibyte_write(base, output);
        for(Integer itFirst : transitions.keySet()) {
            int size = 0;
            Map<Integer, Set<Integer>> place = transitions.get(itFirst);
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
