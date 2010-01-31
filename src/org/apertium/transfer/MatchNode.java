package org.apertium.transfer;
/*
 * Copyright (C) 2005 Universitat d'Alacant / Universidad de Alicante
 *
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class MatchNode {


  /**
   * The outgoing transitions from this node.
   * Schema: (input symbol, destination)
   */
  Map<Integer,MatchNode> transitions = new HashMap<Integer,MatchNode>();

  public MatchNode() {
  }

  public MatchNode(int svsize) {
    //transitions = new Vector<MatchNode>(svsize);
  }

  public MatchNode(MatchNode n) {
    transitions.putAll(n.transitions);
  }

  /*
   * Hmm ..... se: ../../lttoolbox/lttoolbox/sorted_vector.*
   */

  void addTransition(int i, MatchNode d, int pos) {
      //System.err.println(this+".addTransition("+ i+", "+d+",  "+pos);

    //  transitions[i] = d;
    MatchNode n = transitions.put(i, d);
    if (n!=null) {
      System.err.println("HMM!!! n = " + n);
    }

  }

}
