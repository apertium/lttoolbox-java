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
import java.util.Vector;

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
        transitions = new TreeMap<Integer, Dest>();
    }
   
    /**
     * Copy constructor 
     * @param n the node to be copied
     */
    Node(Node n) {
        copy(n);
    }

    /**
     * Copy method
     * @param n the node to be copied
     */
    void copy(Node n) {
        transitions = new TreeMap<Integer, Dest>(n.transitions);
    }

    /**
     * Making a link between this node and another
     * @param i input symbol
     * @param o output symbol
     * @param d destination
     */
    void addTransition(int i, int o, Node d) {
        if (!transitions.containsKey(i)) {
            transitions.put(i, new Dest());
        }
        List<Integer> out_tag = new Vector<Integer>(transitions.get(i).out_tag);
        List<Node> dest = new Vector<Node>(transitions.get(i).dest);

        out_tag.add(transitions.get(i).size, o);
        dest.add(transitions.get(i).size, d);
        transitions.get(i).out_tag = out_tag;
        transitions.get(i).dest = dest;
        transitions.get(i).size++;
    }

   public String toString() {
    return "Node{transitions: "+this.transitions+"}";
  }

}
