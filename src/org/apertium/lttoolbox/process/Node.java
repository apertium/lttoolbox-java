package org.apertium.lttoolbox.process;

/*
 This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public
 License as published by the Free Software Foundation; either version 2 of the License, or (at your option) any later
 version.

 This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

 You should have received a copy of the GNU General Public License along with this program; if not, write to the Free
 Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
import java.util.HashMap;
import java.util.Map;
import org.apertium.lttoolbox.process.TransducerExe.NodeLoadInfo;


/**
 * A linked list of transitions.
 * Experiments show that 95 % nodes have only 1 transition, and the rest have less than 8 transitions
 * @author Jacob Nordfalk
 */
class Transition {

  /** The output symbol (character/tag) sent when making this transition */
  int output_symbol;

  /** Destination node when makine this transition */
  Node node_dest;

  /** Next transition in the linked list */
  Transition next;
}





class Node {
  /**
   The outgoing transitions of this node. Schema: (input symbol, (output symbol, destination node))
   */
  private Map<Integer, Transition> transitions;
  private NodeLoadInfo nodeLoadInfo = null;

  void setNodeLoadInfo(NodeLoadInfo nodeLoadInfo) {
    this.nodeLoadInfo = nodeLoadInfo;
  }


  void initTransitions(int number_of_local_transitions) {
    transitions = new HashMap<Integer, Transition>();//number_of_local_transitions);
  }

  private static final boolean FAST_BUT_REVERSE_ORDER = false;
  /**
   Making a link between this node and another

   @param ins input symbol
   @param outs output symbol
   @param node_dest destination
   */
  void addTransition(int ins, int outs, Node node_dest) {

    Transition newTransition = new Transition();
    newTransition.output_symbol = outs;
    newTransition.node_dest = node_dest;

    if (FAST_BUT_REVERSE_ORDER) {
      Transition oldTransition = transitions.put(ins, newTransition);
      // if there was already a transition it is putted behind the new one in a linked list structure
      newTransition.next = oldTransition;
    } else {
      Transition oldTransition = transitions.get(ins);
      if (oldTransition == null) {
        transitions.put(ins, newTransition);
      } else {
        while (oldTransition.next != null) {
          oldTransition = oldTransition.next;
        }
        oldTransition.next = newTransition;
      }
    }
  }

  Transition transitions_get(int i) {
    // Check to see if we need to load this node first
    if (nodeLoadInfo!=null) {
      load();
    }
    return transitions.get(i);
  }

  @Override
  public String toString() {
    return "Node{" + this.transitions + "}@" + hashCode();
  }

  void load() {
    nodeLoadInfo.loadNode(this);
    nodeLoadInfo = null;
  }
}
