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

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Node class of TransExe.
 * @author Raah
 */
public class Node {

    /**
     * The outgoing transitions of this node.
     * Schema: (input symbol, (output symbol, destination))
     */
    Map<Integer, Transition> transitions;

    /**
     * The constructor
     */
    Node() {
    }
   
/*
number_of_local_transitions = 1
number_of_local_transitions = 1
number_of_local_transitions = 1
number_of_local_transitions = 1
number_of_local_transitions = 47
number_of_local_transitions = 14
number_of_local_transitions = 16
number_of_local_transitions = 15
number_of_local_transitions = 15
number_of_local_transitions = 28
number_of_local_transitions = 28
number_of_local_transitions = 29
number_of_local_transitions = 28
number_of_local_transitions = 1
number_of_local_transitions = 1
number_of_local_transitions = 1
number_of_local_transitions = 1
number_of_local_transitions = 1
number_of_local_transitions = 0
number_of_local_transitions = 10
number_of_local_transitions = 1
number_of_local_transitions = 14
number_of_local_transitions = 1
number_of_local_transitions = 1
number_of_local_transitions = 3
number_of_local_transitions = 2
number_of_local_transitions = 27
number_of_local_transitions = 28
number_of_local_transitions = 28
number_of_local_transitions = 12
number_of_local_transitions = 1
number_of_local_transitions = 2
number_of_local_transitions = 2
number_of_local_transitions = 1
number_of_local_transitions = 1
number_of_local_transitions = 1


 number_of_local_transitions = 2
addTransition(i = 116
addTransition(i = 115
number_of_local_transitions = 1
addTransition(i = 101
number_of_local_transitions = 2
addTransition(i = 105
addTransition(i = 32
number_of_local_transitions = 14
addTransition(i = 114
addTransition(i = 100
addTransition(i = 116
addTransition(i = 112
addTransition(i = 98
addTransition(i = 99
addTransition(i = 102
addTransition(i = 103
addTransition(i = 106
addTransition(i = 108
addTransition(i = 109
addTransition(i = 110
addTransition(i = 115
addTransition(i = 118
number_of_local_transitions = 4
addTransition(i = 114
addTransition(i = 99
addTransition(i = 110
addTransition(i = 117

 */
    void initTransitions(int number_of_local_transitions) {

//    System.err.println("number_of_local_transitions = " + number_of_local_transitions);
        transitions = new HashMap<Integer, Transition>(number_of_local_transitions);
    }
    /**
     * Making a link between this node and another
     * @param i input symbol
     * @param o output symbol
     * @param d destination
     */
    void addTransition(int i, int o, Node d) {

      //System.err.println("addTransition(i = " + i);

        Transition transition = transitions.get(i);
        if (transition==null) {
          transition = new Transition();
          transitions.put(i, transition);
        }
        transition.out_tag.add(o);
        transition.dest.add(d);
        transition.size++;

        //System.err.println("transition.size = " + transition.size);
    }

   public String toString() {
    return "Node{transitions: "+this.transitions+"}";
  }

}
