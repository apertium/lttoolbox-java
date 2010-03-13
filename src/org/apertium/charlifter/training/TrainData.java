/*
 * Copyright 2010 Jimmy O'Regan
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

package org.apertium.charlifter.training;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

/**
 *
 * @author jimregan
 */
public class TrainData {
    /**
     * same as "tableref" below, but for chars not words!  
     * In resolution, look to see if char is ambiguous and if so consider 
     * each possible resolution - determined entirely by chars in xx-clean.txt 
     * word list!!  The counts themselves are not used anywhere!!  All 
     * character stats are in charprobspref.
     */
    HashMap<Character, Integer> charsref;
    /**
     * keys are asciified known-good words; vals are hashrefs with all
     * known-good words in the corpus with the given asciification as keys,
     * counts as values; stores more than clean since words are added to this
     * from prettyclean and corpus.  Used only for dictionary lookup in
     * restoration phase; if context is being used, these counts are used
     * to compute the necessary probabilities, and without context the choice
     * with the highest count is selected
     */
    HashMap<String, HashMap <String, Integer>> tableref;
    /**
     * keys are chars with diacritics, val is initially count, then turned
     * into a log prob
     */
    HashMap<Character, Integer> charcount;
    HashMap<Character, Double> charprobsref;
    /**
     * hash counts the number of times each feature is seen in the training
     * corpus. keys are strings of the form "CXXX/N", char C with full
     * diacritics, XXX is the ngram feature, N is the start index of the ngram
     * relative to C.  Value is the count of this feature.
     */
    HashMap<String, Integer> featuresref;
    /**
     * keys are strings that look like "ár|+|bpost" or "ar|-|me" and values
     * are at first counts, then turned into a log prob - first example is
     * probability of seeing something which asciifies to "bpost" following
     * (+) the word "ár".
     */
    HashMap<String, Integer> contextcount;
    HashMap<String, Double> contextref;

    TrainData () {
        charsref = new HashMap<Character, Integer>();
        tableref = new HashMap<String, HashMap <String, Integer>>();
        charcount = new HashMap<Character, Integer>();
        charprobsref = new HashMap<Character, Double>();
        featuresref = new HashMap<String, Integer>();
        contextcount = new HashMap<String, Integer>();
        contextref = new HashMap<String, Double>();
    }
}
