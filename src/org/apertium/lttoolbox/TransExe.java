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
    private int initial_id;
    /**
     * Node list
     */
    private TreeMap<Integer,Node> node_list  = new TreeMap<Integer,Node>();
    /**
     * Set of final nodes
     */
    private ArrayList<Node> finals = new ArrayList<Node>();

    //Index of the last node added to node_list
    private Integer index =0;
    
    TransExe() {
    }

    void read(InputStream input, Alphabet alphabet) throws IOException {
        node_list = new TreeMap<Integer,Node>();
        index = 0;
        initial_id = Compression.multibyte_read(input);
        int finals_size = Compression.multibyte_read(input);
        finals.ensureCapacity(finals_size);
        //System.out.println("finals_size : "+finals_size);
        int base = 0;

        Set<Integer> myfinals = new TreeSet<Integer>();

        while (finals_size > 0) {    
            finals_size--;
            base += Compression.multibyte_read(input);
            myfinals.add(base);
            Node n = node_list.get(base);
            if (n == null) {
               n = new Node();
                node_list.put(base, n);
            }
            finals.add(n);
        }

        base = Compression.multibyte_read(input);

        int number_of_states = base;
        //System.out.println("number of states : "+number_of_states);
        int current_state = 0;

        while (number_of_states > 0) {
            
          int number_of_local_transitions = Compression.multibyte_read(input);
          int tagbase = 0;
          Node mynode = node_list.get(current_state);
          if (mynode == null) {
            mynode=new Node();
            node_list.put(current_state,mynode);
          }

          while (number_of_local_transitions > 0) {
              number_of_local_transitions--;
              tagbase += Compression.multibyte_read(input);
              int state = (current_state + Compression.multibyte_read(input)) % base;
              int i_symbol = alphabet.decode(tagbase).first;
              int o_symbol = alphabet.decode(tagbase).second;
              Node n = node_list.get(state);
              if (n == null) {
                 n=new Node();
                 node_list.put(state,n);
              }
              mynode.addTransition(i_symbol, o_symbol, n);
            }
            number_of_states--;
            current_state++;
        }
    }

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
