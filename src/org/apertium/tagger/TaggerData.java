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
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import org.apertium.lttoolbox.Compression;

/**
 *
 * @author jimregan
 */
public class TaggerData {
    // FIXME: IntSet?
    private Set<Integer> open_class;
    private ArrayList<TForbidRule> forbid_rules;
    Map<String, Integer> tag_index;
    private ArrayList<String> array_tags;
    private ArrayList<TEnforceAfterRule> enforce_rules;
    private ArrayList<String> prefer_rules;
    private ArrayList<String> discard;
    private ConstantManager constants;
    private PatternList plist;
    private int N;
    private int M;
    private double[][] a;
    private double[][] b;
    private Collection output;

    private double ZERO = 1e-10;

    public TaggerData () {
        a = null;
        b = null;
        N = 0;
        M = 0;
        // I'm just gonna go nuts with initialisations, k?
        discard = new ArrayList<String>();
        enforce_rules = new ArrayList<TEnforceAfterRule>();
        prefer_rules = new ArrayList<String>();
        array_tags = new ArrayList<String>();
        open_class = new HashSet<Integer>();
        forbid_rules = new ArrayList<TForbidRule>();
        tag_index = new HashMap<String, Integer>();
    }

    Set<Integer> getOpenClass () {
        return open_class;
    }

    void setOpenClass (Set<Integer> oc) {
        open_class = oc;
    }

    ArrayList<TForbidRule> getForbidRules() {
        return forbid_rules;
    }

    void setForbidRules(ArrayList<TForbidRule> rules) {
        this.forbid_rules = rules;
    }

    Map<String, Integer> getTagIndex () {
        return tag_index;
    }

    void setTagIndex (Map<String, Integer> ti) {
        tag_index = ti;
    }

    ArrayList<String> getArrayTags() {
        return array_tags;
    }

    void setArrayTags(ArrayList<String> at) {
        this.array_tags = at;
    }

    ArrayList<TEnforceAfterRule> getEnforceRules() {
        return enforce_rules;
    }

    void setEnforceRules(ArrayList<TEnforceAfterRule> ea) {
        this.enforce_rules = ea;
    }

    Collection getOutput () {
        return output;
    }

    void setOutput (Collection c) {
        output = c;
    }

    public void read (InputStream in) throws IOException {
      // open class
      int val = 0;
      for (int i = Compression.multibyte_read(in); i != 0; i--) {
          val += Compression.multibyte_read(in);
          open_class.add(val);
      }
   
      // forbid_rules
      for (int i = Compression.multibyte_read(in); i != 0; i--) {
          TForbidRule aux = new TForbidRule();
          aux.tagi = Compression.multibyte_read(in);
          aux.tagj = Compression.multibyte_read(in);
          forbid_rules.add(aux);
      }

      // array_tags
      for (int i = Compression.multibyte_read(in); i != 0; i--) {
          array_tags.add(Compression.String_read(in));
      }

      // tag_index
      for (int i = Compression.multibyte_read(in); i != 0; i--) {
          String tmp = Compression.String_read(in);
          int t = Compression.multibyte_read(in);
          tag_index.put(tmp, t);
      }
  
      // enforce_rules
      for (int i = Compression.multibyte_read(in); i != 0; i--) {
          TEnforceAfterRule aux = new TEnforceAfterRule();
          aux.tagi = Compression.multibyte_read(in);
          for (int j = Compression.multibyte_read(in); j != 0; j--) {
              aux.tagsj.add(Compression.multibyte_read(in));
          }
          enforce_rules.add(aux);
      }

      // prefer_rules
      for (int i = Compression.multibyte_read(in); i != 0; i--) {
          prefer_rules.add(Compression.String_read(in));
      }

      // constants
      constants.read(in);

      // output
      output.read(in);

      // dimensions
      N = Compression.multibyte_read(in);
      M = Compression.multibyte_read(in);

      a = new double[N][];
      b = new double[N][];
      for (int i = 0; i != N; i++) {
          a[i] = new double[N];
          b[i] = new double[M];
      }
   
      // read a
      for (int i = 0; i != N; i++) {
          for (int j = 0; j != N; j++) {
              a[i][j] = EndianDoubleUtil.read(in);
          }
      }

      // initializing b matrix
      for (int i = 0 ; i != N; i++) {
          for (int j = 0; j != M; j++) {
              b[i][j] = ZERO;
          }
      }

      // read nonZERO values of b
      int nval = Compression.multibyte_read(in);

      for (; nval != 0; nval--) {
          int i = Compression.multibyte_read(in);
          int j = Compression.multibyte_read(in);
          b[i][j] = EndianDoubleUtil.read(in);
      }

      // read pattern list
      plist.read(in);
    
      // read discards on ambiguity
      discard.clear();

      int limit = Compression.multibyte_read(in);
      if (limit == -1) {
          return;
      }
  
      for (int i = 0; i < limit; i++) {
          discard.add(Compression.String_read(in));
      }


    }

    PatternList getPatternList () {
        return plist;
    }

    void setPatternList (PatternList pl) {
        plist = pl;
    }

    ConstantManager getConstants () {
        return constants;
    }

    void setConstants (ConstantManager c) {
        constants = c;
    }

    ArrayList<String> getDiscardRules () {
        return discard;
    }

    void setDiscardRules (ArrayList<String> v) {
        discard = v;
    }

    void setProbabilities (int MyN, int MyM, double[][] myA, double[][] myB) {
        N = MyN;
        M = MyM;

        if (N != 0 && M != 0) {
            a = new double[N][];
            for (int i=0; i != N; i++) {
                a[i] = new double[N];
                if (myA != null) {
                    for (int j=0; j!=N;j++) {
                        a[i][j] = myA[i][j];
                    }
                }
            }

            b = new double[N][];
            for (int i=0; i != N; i++) {
                b[i] = new double[M];
                if (myB != null) {
                    for (int j=0; j!=M;j++) {
                        b[i][j] = myB[i][j];
                    }
                }
            }

        }
        else {
            a = null;
            b = null;
        }
    }

    void setProbabilities (int MyN, int MyM) {
        this.setProbabilities(MyN, MyM, null, null);
    }

    double[][] getA () {
        return a;
    }

    double[][] getB () {
        return b;
    }

    int getN () {
        return N;
    }

    int getM () {
        return M;
    }

}
