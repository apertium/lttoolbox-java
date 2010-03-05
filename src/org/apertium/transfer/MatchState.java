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
 *
 * @author Jacob Nordfalk
 */


import java.util.Map;

public class MatchState {

  MatchNode[] state;

  int first = 0;

  int last = 0;

  static int BUF_LIMIT = 1024;

  MatchState() {
    first = last = 0;
    state = new MatchNode[BUF_LIMIT];
  }

  MatchState(MatchState s) {
    copy(s);
  }

  void clear() {
    first = last = 0;
  }

  void copy(MatchState s) {
    System.arraycopy(s.state, 0, state, 0, BUF_LIMIT);
    first = s.first;
    last = s.last;
  }

  int size() {
    return last >= first ? last - first : last + BUF_LIMIT - first;
  }

  void init(MatchNode initial) {
    first = 0;
    last = 1;
    state[0] = initial;
  }

  void applySymbol(MatchNode pnode, int symbol) {
    MatchNode aux = pnode.transitions_get(symbol);
    if (aux != null) {
      state[last] = aux;
      last = (last + 1) % BUF_LIMIT;
    }
  }

  void step(int input) {
    int mylast = last;
    for (int i = first; i != mylast; i = (i + 1) % BUF_LIMIT) {
      applySymbol(state[i], input);
    }
    first = mylast;
  }

  void step(int input, int alt) {
    int mylast = last;
    for (int i = first; i != mylast; i = (i + 1) % BUF_LIMIT) {
      applySymbol(state[i], input);
      applySymbol(state[i], alt);
    }
    first = mylast;
  }

  int classifyFinals(Map<MatchNode, Integer> final_class) {
    int result = Integer.MAX_VALUE;
    for (int i = first; i != last; i = (i + 1) % BUF_LIMIT) {
      final Integer it2 = final_class.get(state[i]);
      if (it2 != null) {
        if (it2 < result) {
          result = it2;
        }
      }
    }
    return (result < Integer.MAX_VALUE) ? result : (-1);
  }
}
