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

import java.io.InputStream;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Transducer class for execution of lexical processing algorithms
 * @author Raah
 */
public class TransExe {
    
    /**
     * Initial state
     */
    private int initial_id;
    /**
     * Node list
     */
    private Node[] node_list2;
    /**
     * Set of final nodes
     */
    private ArrayList<Node> finals2 = new ArrayList<Node>();

    //Index of the last node added to node_list
    private Integer index =0;
    
    TransExe() {
    }

    void read(InputStream input, Alphabet alphabet) throws IOException {
        index = 0;
        initial_id = Compression.multibyte_read(input);
        final int finals_size = Compression.multibyte_read(input);
        //System.out.println("finals_size : "+finals_size);


        int base = 0;

        // first comes the list of all final nodes
        int[] myfinals2 = new int[finals_size];
        for (int i=0; i<finals_size; i++) {
            base += Compression.multibyte_read(input);
            myfinals2[i] = base;
        }


        final int number_of_states = Compression.multibyte_read(input);

        node_list2 = new Node[number_of_states];
        for (int current_state = 0; current_state<number_of_states; current_state++) {
          node_list2[current_state] = new Node();
        }

        base = number_of_states;
        //System.out.println("number of states : "+number_of_states);

        for (int current_state = 0; current_state<number_of_states; current_state++) {
            
          int number_of_local_transitions = Compression.multibyte_read(input);
          int tagbase = 0;

          Node mynode2 = node_list2[current_state];

          while (number_of_local_transitions > 0) {
              number_of_local_transitions--;
              tagbase += Compression.multibyte_read(input);
              int state = (current_state + Compression.multibyte_read(input)) % base;
              int i_symbol = alphabet.decode(tagbase).first;
              int o_symbol = alphabet.decode(tagbase).second;
              Node n2 = node_list2[state];
              mynode2.addTransition(i_symbol, o_symbol, n2);

            }
        }

        for (int i=0; i<finals_size; i++) {
            base = myfinals2[i];
            finals2.add(node_list2[base]);
        }

    }
/*
    private void unifyFinals() {

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
*/
    public Node getInitial() {
        return node_list2[initial_id];
    }

    ArrayList<Node> getFinals() {
        return finals2;
    }
/*
    public String toString() {
      return "index="+this.index +"/initial_id="+ this.initial_id +"/finals="+  this.finals;
    }*/
}
