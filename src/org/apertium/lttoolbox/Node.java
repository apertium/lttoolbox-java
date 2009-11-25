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
    Map<Integer, Dest> transitions;

    /**
     * The constructor
     */
    Node() {
    }
   

  void initTransitions(int number_of_local_transitions) {
        transitions = new HashMap<Integer, Dest>(number_of_local_transitions);
  }
    /**
     * Making a link between this node and another
     * @param i input symbol
     * @param o output symbol
     * @param d destination
     */
    void addTransition(int i, int o, Node d) {
        Dest transition = transitions.get(i);
        if (transition==null) {
          transition = new Dest();
          transitions.put(i, transition);
        }
        transition.out_tag.add(o);
        transition.dest.add(d);
        transition.size++;
    }

   public String toString() {
    return "Node{transitions: "+this.transitions+"}";
  }

}
