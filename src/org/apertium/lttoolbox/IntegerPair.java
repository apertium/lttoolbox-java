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

/**
 * Class to represent a pair of integers
 * @author Raah
 */
public class IntegerPair implements Comparable {

    int first;
    int second;
    
    public IntegerPair(Integer i1, Integer i2) {
        first = i1;
        second = i2;
    }
  
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }        
        if (! (o instanceof IntegerPair)) {
            return false;
        }        
        IntegerPair p = (IntegerPair)o;
        return ((first == p.first)&& (second == p.second));
    }
   
    public int compareTo(IntegerPair p) {
        if (first > p.first) {
            return 1;
        }
        if (first < p.first) {
            return -1;
        }
        if (second > p.second) {
            return 1;
        }
        if (second < p.second) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return new String("<" + (first>0?(char)first:"") + first + "," + (second>0?(char)second:"") + second + ">");
    }

    @Override
    public int compareTo(Object o) {
        if (o==this) return 0;
        IntegerPair p = (IntegerPair)o;
        return compareTo(p);
    }
}
