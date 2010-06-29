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

package org.apertium.transfer;

/**
 * A list of nodes currently matched.
 * @author Jacob Nordfalk
 */
import java.util.ArrayList;
import java.util.Arrays;

public class MatchState {

  private int[] state;

  private int first = 0;

  private int last = 0;

  private static int BUF_LIMIT = 1024;

  /** Copy of node list from MatchExe.
   * @see MatchExe
   */
  int[][] node_list;


  public MatchState(MatchExe me) {
    node_list = me.node_list;
    first = last = 0;
    state = new int[BUF_LIMIT];
  }

  public MatchState(MatchState s) {
    _copy(s);
  }

  void clear() {
    first = last = 0;
  }

  private void _copy(MatchState s) {
    System.arraycopy(s.state, 0, state, 0, BUF_LIMIT);
    //XXX - Does this need to be arraycopy'd as well?
    node_list = s.node_list;
    first = s.first;
    last = s.last;
  }

  public int size() {
    return last >= first ? last - first : last + BUF_LIMIT - first;
  }

  public void init(int initial) {
    first = 0;
    last = 1;
    state[0] = initial;
  }

  private void applySymbol(int pnode, int symbol) {
    int[] node = node_list[pnode];

    for (int i=0; i<node.length-1; i+=2) { // TODO binary seach - No: only ca. 1%  cpu is used here anyway
      if (node[i]==symbol) {
        int aux = node[i+1];
        state[last] = aux;
        last = (last + 1) % BUF_LIMIT;
        break; 
      }
    }
  }

	private boolean DEBUG = true;

  public void step(int input) {
		if (DEBUG) System.out.println("step "+input);
    int mylast = last;
    for (int i = first; i != mylast; i = (i + 1) % BUF_LIMIT) {
      applySymbol(state[i], input);
    }
    first = mylast;
  }

  public void step(int input, int alt) {
		if (DEBUG) System.out.println("step "+input+" "+alt);
    int mylast = last;
    for (int i = first; i != mylast; i = (i + 1) % BUF_LIMIT) {
      applySymbol(state[i], input);
      applySymbol(state[i], alt);
    }
    first = mylast;
  }

	/**
	 * Gets the output symbol if there is a final
	 * @return the output symbol (In transfer this is a rule number). Returns -1 if there isnt a final state.
	 */
  public int classifyFinals() {
    int result = Integer.MAX_VALUE;
    for (int i = first; i != last; i = (i + 1) % BUF_LIMIT) {
      int[] node = node_list[state[i]];

      //System.err.println("2node["+i+"] state = " + state[i]);
      if (node.length % 2 == 1) {
        result = Math.min(result, node[node.length-1]); // last elem is the value
      }
    }
    result = (result < Integer.MAX_VALUE) ? result : (-1);

    //System.err.println("2result = " + result);
    return result;
  }

  public String toString() {
    return "ms["+first +";"+last+"]=" + Arrays.toString(Arrays.copyOfRange(state, first, last));
  }
}
