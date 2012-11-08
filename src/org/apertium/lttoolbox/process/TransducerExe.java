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
   Set of final nodes
   */
  private ArrayList<Node> finals = new ArrayList<Node>();


  public Node getInitial() {
    return node_list[initial_id];
  }

  public ArrayList<Node> getFinals() {
    return finals;
  }


  /**
   Note that this method is neccesarily very slow as the number of nodes increases, as the nodes don't (and for memory
   usage reasont shouldnt) know their own node number
   */
  public void show_DEBUG(Alphabet a) {
    for (int i = 0; i < node_list.length; i++) {
      Node n = node_list[i];
      n.show_DEBUG(i, a, node_list);
    }
  }

  public static boolean DELAYED_NODE_LOADING = true;
  /**
   Inner class to hold the info on loading nodes. Note that this has an implicit reference to the containing
   TransducerExe and can therefore access its fields (node_list, alphabet, base)
   */
  class NodeLoadInfo {
    // TransducerExe this_TransducerExe     <-- this reference is actually there
    //byte[] nodeData; not needed - we use the enclosing TransducerExe's  bytebuffer object
    //int number_of_transitions;
    int nodeNo__current_state;
    int byteBufferPosition;

    void loadNode(Node sourceNode) {
      //assert check: if (node_list[nodeNo__current_state] != sourceNode) throw new InternalError();

      byteBuffer.position(byteBufferPosition); // seek to correct place in file
      int number_of_local_transitions = Compression.multibyte_read(byteBuffer); // typically 20-40, max seen is 694
//      int number_of_local_transitions = number_of_transitions;
      sourceNode.initTransitions(number_of_local_transitions);
      int tagbase = 0;
      while (number_of_local_transitions > 0) {
        number_of_local_transitions--;
        tagbase += Compression.multibyte_read(byteBuffer);
        int state = (nodeNo__current_state + Compression.multibyte_read(byteBuffer)) % number_of_states;
        IntegerPair pair = alphabet.decode(tagbase);
        int i_symbol = pair.first;
        int o_symbol = pair.second;
        Node targetNode = node_list[state];
        sourceNode.addTransition(i_symbol, o_symbol, targetNode);
      }
    }
  }

  /*
   WITH BYTEBUFFER and a direct file
   public static boolean DELAYED_NODE_LOADING = true;
   alloc 2085984
           46191

   public static boolean DELAYED_NODE_LOADING = false;
   alloc 9556192

   WITH BYTEBUFFER and an inputstream
   public static boolean DELAYED_NODE_LOADING = true;
   alloc 2399304

   public static boolean DELAYED_NODE_LOADING = false;
   alloc 9869512

   BEFORE BYTEBUFFER
   public static boolean DELAYED_NODE_LOADING = true;
   alloc 2980024

   public static boolean DELAYED_NODE_LOADING = false;
   alloc 9556000
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
    for (int current_state = 0; current_state < number_of_statesl; current_state++) {
      node_list[current_state] = new Node();
    }

    // Keep reference to bytebuffer for delayed node loading
    byteBuffer = input;

    NodeLoadInfo nodeLoadInfo = new NodeLoadInfo();

    // Now load the nodes
    for (int nodeNo__current_state = 0; nodeNo__current_state < number_of_statesl; nodeNo__current_state++) {
      nodeLoadInfo.byteBufferPosition = input.position();
      int number_of_local_transitions = Compression.multibyte_read(input); // typically 20-40, max seen is 694

      nodeLoadInfo.nodeNo__current_state = nodeNo__current_state;
      //nodeLoadInfo.number_of_transitions = number_of_local_transitions;
      //System.out.println(number_of_states+" NodeLoadInfo "+nodeLoadInfo.nodeNo__current_state+ " "+nodeLoadInfo.byteBufferPosition);
      Node sourceNode = node_list[nodeNo__current_state];

      if (DELAYED_NODE_LOADING) {
        sourceNode.setNodeLoadInfo(nodeLoadInfo);
        Compression.multibyte_skip(input, 2 * number_of_local_transitions);
        nodeLoadInfo = new NodeLoadInfo();
      } else {
        nodeLoadInfo.loadNode(sourceNode); // skips the correct number of positions
      }
    }

    //System.err.println(ant1 + " ettere ud af  " + number_of_states);
    for (int i = 0; i < finals_size; i++) {
      int final_index = myfinals[i];
      finals.add(node_list[final_index]);
    }
  }
}
