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

package org.apertium.tagger;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map;

/**
 *
 * @author jimregan
 */
public class TaggerData {
    // FIXME: IntSet?
    private Set<Integer> open_class;
    private ArrayList<TForbidRule> forbid_rules;
    //  map<wstring, TTag, Ltstr> tag_index;
    private ArrayList<String> array_tags;
    private ArrayList<TEnforceAfterRule> enforce_rules;
    private ArrayList<String> prefer_rules;
    private ConstantManager constants;
    private int N;
    private int M;
/*
  vector<wstring> prefer_rules;
  Collection output;
  double **a;
  double **b;
  PatternList plist;
*/
}
