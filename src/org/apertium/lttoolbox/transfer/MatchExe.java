package org.apertium.lttoolbox.transfer;
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


import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import org.apertium.lttoolbox.compile.Transducer;

public class MatchExe {

  /**
   * Initial state
   */
  int initial_id;

  /**
   * MatchNode list
   */
  List<MatchNode> node_list = new Vector<MatchNode>();

  /**
   * Set of final nodes
   */
  Map<MatchNode, Integer> finals;

  MatchExe() {
  }

  MatchExe(MatchExe te) {
    copy(te);
  }

  MatchExe(Transducer t, Map<Integer, Integer> final_type) {

    for (Integer first : t.transitions.keySet()) {
      final Map<Integer, Set<Integer>> second = t.transitions.get(first);
      node_list.add(new MatchNode(second.size()));
    }

    // set up finals
    for (Integer first : final_type.keySet()) {
      final Integer second = final_type.get(first);
      finals.put(node_list.get(first), second);
    }

    // set up initial node
    initial_id = t.getInitial();

    // set up the transitions
    for (Integer itFirst : t.transitions.keySet()) {
      MatchNode mynode = node_list.get(itFirst);
      int i = 0;
      final Map<Integer, Set<Integer>>  itSecond = t.transitions.get(itFirst);
      for (Integer it2First : itSecond.keySet()) {
        final Collection<Integer> it2Second = itSecond.get(it2First);
        for (Integer integer : it2Second) {
          mynode.addTransition(it2First, node_list.get(integer), i++);
        }
      }
    }
  }

  public void copy(MatchExe te) {
    initial_id = te.initial_id;
    node_list = te.node_list;
    finals = te.finals;
  }

  public MatchNode getInitial() {
    return node_list.get(initial_id);
  }

  public Map<MatchNode, Integer> getFinals() {
    return finals;
  }

}