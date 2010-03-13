/*
# This file is part of Charlifter.
# Copyright 2008-2009 Kevin P. Scannell <kscanne at gmail dot com>
#
#     Charlifter is free software: you can redistribute it and/or modify
#     it under the terms of the GNU General Public License as published by
#     the Free Software Foundation, either version 3 of the License, or
#     (at your option) any later version.
#
#     Charlifter is distributed in the hope that it will be useful,
#     but WITHOUT ANY WARRANTY; without even the implied warranty of
#     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#     GNU General Public License for more details.
#
#     You should have received a copy of the GNU General Public License
#     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.apertium.charlifter;
import java.util.HashMap;

/**
 *
 * @author jimregan
 */
public class Data {
    HashMap<Character, Integer> CharRef;
    HashMap<Character, HashMap<Character, Integer>> CharsRef;
    HashMap<String, Integer> WordRef;
    HashMap<String, HashMap<String, Integer>> WordsRef;
    HashMap<Character, Double> CharProbsRef;
    HashMap<String, Double> FeaturesRef;
    HashMap<String, Double> ContextRef;

    public void Data () {
        CharRef = new HashMap<Character, Integer>();
        CharsRef = new HashMap<Character, HashMap<Character, Integer>>();
        WordRef = new HashMap<String, Integer>();
        WordsRef = new HashMap<String, HashMap<String, Integer>>();
        CharProbsRef = new HashMap<Character, Double>();
        FeaturesRef = new HashMap<String, Double>();
        ContextRef = new HashMap<String, Double>();
    }
}
