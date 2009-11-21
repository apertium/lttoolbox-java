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

import java.util.Vector;

/**
 * This is a "Compiler" helper class, to store the parts of each entry
 * before combining it to build the transducer being "compiled".
 * @author Raah
 */
public class EntryToken {

    /**
     * Type of tokens, inner enum.
     */
    public static int TYPE_PARADIGM = 1;
    public static int Type_single_transduction = 2;
    public static int Type_regexp = 3; //?? why was there a 2 here ?
    
    /**
     * Type of this token
     */
    int type;
    
    /**
     * Name of the paradigm (if it is of 'paradigm' 'type')
     */
    String parName;
    
    /**
     * Left side of transduction (if 'single_transduction')
     */
    Vector<Integer> leftSide;
    
    /**
     * Right side of transduction (if 'single_transduction')
     */
    Vector<Integer> rightSide;
    
    /**
     * Regular expression (if 'regexp')
     */
    String myregexp;

    /**
     * Non-parametric constructor 
     */
    EntryToken() {
        leftSide = new Vector<Integer>();
        rightSide = new Vector<Integer>();
        parName = "";
        type = 0;
    }

    /**
     * copy method
     * @param e the entryToken to be copied
     */
    void copy(EntryToken e) {
        type = e.type;
        leftSide = e.leftSide;
        rightSide = e.rightSide;
        parName = e.parName;
        myregexp = e.myregexp;
    }

    /**
     * Sets the name of the paradigm.
     * @param np the paradigm name
     */
    void setParadigm(String np) {
        parName = np;
        type = TYPE_PARADIGM;
    }

    /**
     * Set both parts of a single transduction.
     * @param pi left part
     * @param pd right part
     */
    void setSingleTransduction(Vector<Integer> pi, Vector<Integer> pd) {
        leftSide = pi;
        rightSide = pd;
        type = Type_single_transduction;
    }

    /**
     * Set regular expression.
     * @param r the regular expression specification.
     */
    void setRegexp(String r) {
        myregexp = r;
        type = Type_regexp;
    }

    /**
     * Test EntryToken to detect if is a paradigm.
     * @return true if it is a paradigm.
     */
    boolean isParadigm() {
        return type == TYPE_PARADIGM;
    }

    /**
     * Test EntryToken to check if it is a single transduction.
     * @return true if it is a single transduction.
     */
    boolean isSingleTransduction() {
        return type == Type_single_transduction;
    }

    /**
     * Test EntryToken to check if it is a single regular expression.
     * @return true if it is a regular expression.
     */
    boolean isRegexp() {
        return type == Type_regexp;
    }

    /**
     * Retrieve the name of the paradigm.
     * @return the name of the paradigm.
     */
    String paradigmName() {
        return parName;
    }

    /**
     * Retrieve the left part of the paradigm.
     * @return the left part of the paradigm.
     */
    Vector<Integer> left() {
        return leftSide;
    }

    /**
     * Retrieve the right part of the paradigm.
     * @return the right part of the paradigm.
     */
    Vector<Integer> right() {
        return rightSide;
    }

    /**
     * Retrieve the regular expression specification.
     * @return the regular expression specification.
     */
    String regExp() {
        return myregexp;
    }
    
    /**
     * Build a string representation of the entryToken
     * @return the representation of the entryToken
     */
    @Override
    public String toString() {
        String res= "";
        if (type==TYPE_PARADIGM) {
            res += "paradigm name : "+parName;
        } else if (type ==Type_regexp) {
            res+="regexp : "+myregexp;
        } else {
            res+="transduction : left "+leftSide+" right "+rightSide;
        }
        return res;
    }
}
