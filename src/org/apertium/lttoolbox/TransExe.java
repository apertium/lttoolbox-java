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
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;

/**
 * Transducer class for execution of lexical processing algorithms
 * @author Raah
 */
public class TransExe {
    
    /**
     * Initial state
     */
    int initial_id;
    /**
     * Node list
     */
    TreeMap<Integer,Node> node_list;
    /**
     * Set of final nodes
     */
    ArrayList<Node> finals;

    //Index of the last node added to node_list
    private Integer index =0;
    
    TransExe() {
        node_list = new TreeMap<Integer,Node>();
        finals = new ArrayList<Node>();
        index = 0;
    }

    void read(DataInputStream input, Alphabet alphabet) throws IOException {
        node_list = new TreeMap<Integer,Node>();
        index = 0;
        initial_id = Compression.multibyte_read(input);
        int finals_size = Compression.multibyte_read(input);
        finals = new ArrayList<Node>(finals_size);
        //System.out.println("finals_size : "+finals_size);
        int base = 0;

        Set<Integer> myfinals = new TreeSet<Integer>();

        while (finals_size > 0) {
            
            finals_size--;
            base += Compression.multibyte_read(input);
            myfinals.add(base);
            if (!node_list.containsKey(base)) {
                node_list.put(base,new Node());
            }
            finals.add(node_list.get(base));
        }

        base = Compression.multibyte_read(input);

        int number_of_states = base;
        //System.out.println("number of states : "+number_of_states);
        int current_state = 0;

        while (number_of_states > 0) {
            
          int number_of_local_transitions = Compression.multibyte_read(input);
          int tagbase = 0;
          if (!node_list.containsKey(current_state)) {
              node_list.put(current_state,new Node());
          }
          Node mynode = node_list.get(current_state);

          while (number_of_local_transitions > 0) {
              number_of_local_transitions--;
              tagbase += Compression.multibyte_read(input);
              int state = (current_state + Compression.multibyte_read(input)) % base;
              int i_symbol = alphabet.decode(tagbase).first;
              int o_symbol = alphabet.decode(tagbase).second;
              //System.out.println("i : "+i_symbol+", o : "+o_symbol);
              if (!node_list.containsKey(state)) {
                  node_list.put(state,new Node());
              }
              //System.out.println(node_list.get(state));
              mynode.addTransition(i_symbol, o_symbol, node_list.get(state));
              //mynode.addTransition(current_state, tagbase, new_t.node_list.get(state));
               }
            number_of_states--;
            current_state++;
        }
    }

    void unifyFinals() {

        index++;
        while (node_list.containsKey(index)) {
            index++;
        }
        node_list.put(index,new Node());

        Node newfinal = node_list.get(index);

        for (Node it : finals) {

            it.addTransition(0, 0, newfinal);
        }

        finals.clear();
        finals.add(newfinal);
    }

    public Node getInitial() {
        return node_list.get(initial_id);
    }

    ArrayList<Node> getFinals() {
        return finals;
    }

    public String toString() {
      return "index="+this.index +"/initial_id="+ this.initial_id +"/finals="+  this.finals;
    }
}
