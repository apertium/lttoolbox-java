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

import org.apertium.lttoolbox.*;
import java.util.HashMap;

/**
 * Not a test. Raphael's expertiments.
 * @author Raah
 */
public class testIntegerPairs {

    
    
    static Integer get(HashMap<IntegerPair, Integer> m, IntegerPair p) {
        for (IntegerPair p2 : m.keySet()) {
            if (p2.equals(p)) {
            //if(p==p2) {
                return m.get(p2);
            }
        }
        return null;
    }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntegerPair p = new IntegerPair(8,42);
        IntegerPair p2 = new IntegerPair(8,42);
        System.out.println("p==p2 : " + (p==p2));
        System.out.println("p.equals(p2) : " +(p.equals(p2)));
        
        HashMap<IntegerPair, Integer> spair;
        //IntegerPairComparator integerPairComparator = new IntegerPairComparator();
        //spair = new TreeMap<IntegerPair, Integer>(integerPairComparator);
        spair = new HashMap<IntegerPair, Integer>();
        spair.put(new IntegerPair(0, -17), 8);
        spair.put(new IntegerPair(0, -16), 7);
        spair.put(new IntegerPair(0, -15), 6);
        spair.put(new IntegerPair(0, -14), 24);
        spair.put(new IntegerPair(0, -13), 9);
        spair.put(new IntegerPair(0, -11), 23);
        spair.put(new IntegerPair(0, -10), 22);
        spair.put(new IntegerPair(0, 0), 0);
        spair.put(new IntegerPair(45, 45), 32);
        spair.put(new IntegerPair(46, 46), 26);
        spair.put(new IntegerPair(47, 47), 31);
        spair.put(new IntegerPair(48, 48), 10);
        spair.put(new IntegerPair(49, 49), 11);
        spair.put(new IntegerPair(50, 50), 12);
        spair.put(new IntegerPair(51, 51), 13);
        spair.put(new IntegerPair(52, 52), 14);
        spair.put(new IntegerPair(53, 53), 15);
        spair.put(new IntegerPair(54, 54), 16);
        spair.put(new IntegerPair(55, 55), 17);
        spair.put(new IntegerPair(56, 56), 18);
        spair.put(new IntegerPair(57, 57), 19);
        spair.put(new IntegerPair(58, 58), 30);
        spair.put(new IntegerPair(101, 101), 20);
        spair.put(new IntegerPair(104, 104), 27);
        spair.put(new IntegerPair(0, 105), 4);
        spair.put(new IntegerPair(0, 111), 3);
        spair.put(new IntegerPair(112, 112), 29);
        spair.put(new IntegerPair(114, 114), 21);
        spair.put(new IntegerPair(0, 114), 5);
        spair.put(new IntegerPair(116, 116), 28);
        spair.put(new IntegerPair(0, 118), 2);
        spair.put(new IntegerPair(97, 97), 1);
        spair.put(new IntegerPair(119, 119), 25);
        System.out.println("<0,0>="+get(spair, new IntegerPair(0, 0)));
        System.out.println("<0,1>="+get(spair, new IntegerPair(0, 1)));
        System.out.println("<1,0>="+get(spair, new IntegerPair(1, 0)));
        System.out.println("<97,97>="+get(spair, new IntegerPair(97, 97)));
        System.out.println("<0,0>="+get(spair, new IntegerPair(0, 0)));
        // <104,104>=27, <0,105>=4, <0,111>=3, <112,112>=29, <114,114>=21, <0,114>=5, <116,116>=28, <0,118>=2, <97,97>=1, <119,119>=25}

        // TODO code application logic here
    }

}
