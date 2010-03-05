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


import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import org.apertium.lttoolbox.Compression;
import org.apertium.lttoolbox.compile.Transducer;

public class MatchExe {

  /**
   * Initial state
   */
  private int initial_id;

  /**
   * MatchNode list
   */
  private MatchNode[] node_list;

  /**
   * Set of final nodes
   */
  private Map<MatchNode, Integer> finals= new HashMap<MatchNode, Integer>();

  /** in practice the number of elements are known, so use an array directly .
     therefore this constructur has been deleted 
  public MatchExe() {
    node_list = new Vector<MatchNode>();
  }
*/

  public MatchExe(MatchExe te) {
    copy(te);
  }



  public MatchExe(Transducer t, InputStream in) throws IOException {

    setupTransitionsAndNodes(t);

    // set up finals
    for (int i=0, limit=Compression.multibyte_read(in); i!=limit; i++) {
      int key=Compression.multibyte_read(in);
      finals.put(node_list[key], Compression.multibyte_read(in));
    }
  }


  public MatchExe(Transducer t, Map<Integer, Integer> final_type) {
    // System.err.println("final_type = " + new TreeMap<Integer, Integer>(final_type));
    // approx evry 7th value is set. For en-ca (big pair)
    // final_type = {14=1, 41=2, 48=2, 55=2, 62=2, 69=2, 76=2, 83=2, 90=2, 97=2, 103=90, 106=90, 109=90,
    // ...
    // 420739=211, 420741=213, 420743=215, 420745=215, 420747=215, 420749=216}


    setupTransitionsAndNodes(t);

    // set up finals
    for (Integer first : final_type.keySet()) {
      final Integer second = final_type.get(first);
      finals.put(node_list[first], second);
    }
  }

  private void setupTransitionsAndNodes(Transducer t) {
    // set up initial node
    initial_id = t.getInitial();

    // memory allocation
    node_list = new MatchNode[t.transitions.size()];
    int limit=t.transitions.size();

    for (int first =0; first<limit; first++) {
      final Map<Integer, Set<Integer>> second = t.transitions.get(first);
      node_list[first] = new MatchNode(second.size());
    }


    // set up the transitions
    for (int first =0; first<t.transitions.size(); first++) {
      MatchNode mynode=node_list[first];
      int i=0;
      final Map<Integer, Set<Integer>> second=t.transitions.get(first);
      for (Integer it2First : second.keySet()) {
        final Collection<Integer> it2Second=second.get(it2First);
        for (Integer integer : it2Second) {
          mynode.addTransition(it2First, node_list[integer], i++);
        }
      }

      //System.err.println("mynode = " + mynode.transitions.keySet());
    }
  }


  public void copy(MatchExe te) {
    initial_id = te.initial_id;
    node_list = te.node_list;
    finals = te.finals;
  }

  public MatchNode getInitial() {
    return node_list[initial_id];
  }

  public Map<MatchNode, Integer> getFinals() {
    return finals;
  }

}