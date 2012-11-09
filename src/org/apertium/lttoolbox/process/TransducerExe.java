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
import java.io.File;
import org.apertium.lttoolbox.*;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import org.apertium.lttoolbox.Alphabet.IntegerPair;

/**
 Transducer class for execution of lexical processing algorithms. Formerly named TransExe, but its really the runtime
 parallel to compile.Transducer

 @author Raah
 */
public class TransducerExe {
  /**
   Initial state
   */
  private int initial_id;
  /**
   Node list
   */
  private Node[] node_list;

  /**
   Node positions in the byteBuffer
   */
  private int[] byteBufferPositions;

  /**
   Used for delayed loading
   */
  private ByteBuffer byteBuffer;
  /**
   Used for delayed loading
   */
  private int number_of_states;
  /**
   Used for delayed loading
   */
  private Alphabet alphabet;
  /**
   Set of final node indexes
   */
  private HashSet<Integer> final_ids = new HashSet<Integer>();

  int getInitialId() {
    return initial_id;
  }

  public HashSet<Integer> getFinals() {
    return final_ids;
  }


  /**
   Note that this method is neccesarily very slow as the number of nodes increases, as the nodes don't (and for memory
   usage reasont shouldnt) know their own node number
   */
  public void show_DEBUG(Alphabet a) {
    for (int i = 0; i < node_list.length; i++) {
      Node n = getNode(i);
      n.show_DEBUG(i, a, node_list);
    }
  }

  public static boolean DELAYED_NODE_LOADING = true;

  Node getNode(int node_no) {
    Node node = node_list[node_no];
    if (node==null) {
      node_list[node_no] = node = new Node();
      loadNode(node, node_no);
    }
    return node;
  }

  boolean isFinal(int where_node_id) {
    return final_ids.contains(where_node_id);
  }

  void loadNode(Node sourceNode, int nodeNo__current_state) {
    //assert check: if (node_list[nodeNo__current_state] != sourceNode) throw new InternalError();

    int byteBufferPosition = byteBufferPositions[nodeNo__current_state];
    byteBuffer.position(byteBufferPosition); // seek to correct place in file
    int number_of_local_transitions = Compression.multibyte_read(byteBuffer); // typically 20-40, max seen is 694

    sourceNode.initTransitions(number_of_local_transitions);
    int tagbase = 0;
    while (number_of_local_transitions > 0) {
      number_of_local_transitions--;
      tagbase += Compression.multibyte_read(byteBuffer);
      int target_nodeNo = (nodeNo__current_state + Compression.multibyte_read(byteBuffer)) % number_of_states;
      IntegerPair pair = alphabet.decode(tagbase);
      int i_symbol = pair.first;
      int o_symbol = pair.second;
      //Node targetNode = node_list[target_nodeNo];
      sourceNode.addTransition(i_symbol, o_symbol, target_nodeNo);
    }
  }


  /*
   nodes   46191

   public static boolean DELAYED_NODE_LOADING = true;
   WITH BYTEBUFFER and a direct file after 9 nov 2012
   alloc  425424

   WITH BYTEBUFFER and a direct file before 9 nov 2012
   alloc 2085984

   public static boolean DELAYED_NODE_LOADING = false;
   alloc 9556192
   */
  public void read(ByteBuffer input, Alphabet alphabet) throws IOException {
    initial_id = Compression.multibyte_read(input);  // 0 for eo-en.dix)
    final int finals_size = Compression.multibyte_read(input); // xx  (5 for eo-en.dix)
    //System.out.println("finals_size : "+finals_size);

    this.alphabet = alphabet;

    // first comes the list of the final nodes
    int[] myfinals = new int[finals_size]; // xx  ([679, 14875, 27426, 27883, 35871] for eo-en.dix)
    int base = 0;
    for (int i = 0; i < finals_size; i++) {
      base += Compression.multibyte_read(input);
      myfinals[i] = base;
    }


    final int number_of_statesl = Compression.multibyte_read(input); // xx  (46191 for eo-en.dix)
    number_of_states = number_of_statesl;

    // We need to pre-allocate all the Node objects as they will be set to refer to each other
    node_list = new Node[number_of_statesl];
    //for (int current_state = 0; current_state < number_of_statesl; current_state++) {
    //  node_list[current_state] = new Node();
    //}

    byteBufferPositions = new int[number_of_statesl];

    // Keep reference to bytebuffer for delayed node loading
    byteBuffer = input;

    // Now load the nodes
    for (int nodeNo__current_state = 0; nodeNo__current_state < number_of_statesl; nodeNo__current_state++) {

      byteBufferPositions[nodeNo__current_state] = input.position();
      //nodeLoadInfo.byteBufferPosition = input.position();
      int number_of_local_transitions = Compression.multibyte_read(input); // typically 20-40, max seen is 694

      //nodeLoadInfo.number_of_transitions = number_of_local_transitions;
      //System.out.println(number_of_states+" NodeLoadInfo "+nodeLoadInfo.nodeNo__current_state+ " "+nodeLoadInfo.byteBufferPosition);

      if (DELAYED_NODE_LOADING) {
        Compression.multibyte_skip(input, 2 * number_of_local_transitions);
      } else {
        Node sourceNode = new Node();
        node_list[nodeNo__current_state] = sourceNode;
        loadNode(sourceNode, nodeNo__current_state); // skips the correct number of positions
      }
    }

    //System.err.println(ant1 + " ettere ud af  " + number_of_states);
    for (int i = 0; i < finals_size; i++) {
      int final_index = myfinals[i];
      final_ids.add(final_index);
    }
  }
}
