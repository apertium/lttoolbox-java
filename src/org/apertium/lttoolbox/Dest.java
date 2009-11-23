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

import java.util.List;
import java.util.ArrayList;


/**
 * 
 * @author Raah
 */
public class Dest {

  int size;

  List<Integer> out_tag;

  List<Node> dest;

  void copy(Dest d) {
    size = d.size;
    out_tag = new ArrayList<Integer>(d.out_tag);
    dest = new ArrayList<Node>(dest);
  }

  void init() {
    size = 0;
    out_tag = new ArrayList<Integer>();
    dest = new ArrayList<Node>();
  }

 public Dest() {
    init();
  }

 public Dest(Dest d) {
    copy(d);
  }

   public String toString() {
    return "size="+this.size +"/out_tag="+ this.out_tag +"/dest="+  this.dest;
  }

}
