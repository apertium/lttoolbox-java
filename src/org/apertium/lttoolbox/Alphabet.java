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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

/**
 * Alphabet class.
 * Encodes pairs of symbols into an integer.
 * @author Raah
 */
public class Alphabet {


/**
 * Class to represent a pair of integers
 * @author Raah
 */
public static class IntegerPair implements Comparable {

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


    /**
     * Symbol-identifier relationship.
     */
    Map<String, Integer> slexic = new HashMap<String, Integer>();
    
    /**
     * Identifier-symbol relationship.
     */
    List<String> slexicinv = new Vector<String>();
    
    Map<IntegerPair, Integer> spair;
    
    Vector<IntegerPair> spairinv;


/**
 * IntegerPair comparaison class, to conveniently use Maps
 * @author Raah
 */
private static class IntegerPairComparator implements Comparator<IntegerPair> {


    @Override
    public int compare(IntegerPair p0, IntegerPair p1) {
        if (p0.first > p1.first) {
            return 1;
        }
        if (p0.first < p1.first) {
            return -1;
        }
        if (p0.second > p1.second) {
            return 1;
        }
        if (p0.second < p1.second) {
            return -1;
        }
        return 0;
    }

}

    private final static IntegerPairComparator integerPairComparator = new IntegerPairComparator();

    /**
     * The constructor
     */
    public Alphabet() {
        spair = new TreeMap<IntegerPair, Integer>();
        spair.put(new IntegerPair(0, 0), 0);
        spairinv = new Vector<IntegerPair>();
        spairinv.add(new IntegerPair(0, 0));
    }

    /**
     * Include a symbol into the alphabet.
     * @param s the symbol to include
     */
    void includeSymbol(String s) {
        if (!slexic.containsKey(s)) {
            int slexic_size = slexic.size();
            slexic.put(s, -(slexic_size + 1));
            slexicinv.add(s);
        }
    }

    /**
     * Get an unique code for a pair of characters
     * @param c1 left symbol
     * @param c2 right symbol
     * @return the code for (c1, c2)
     */
    int cast(int c1, int c2) {
        IntegerPair p = new IntegerPair(0, 0);
        IntegerPair tmp = new IntegerPair(c1, c2);
        if (!spair.containsKey(tmp)) {
            int spair_size = spair.size();
            spair.put(tmp, spair_size);
            spairinv.add(tmp);
        }
        return spair.get(tmp);
//        if (!containsKey(spair, tmp)) {
//            int spair_size = spair.size();
//            put(spair, tmp, spair_size);
//            spairinv.add(tmp);
//        }
//        return get(spair, tmp);
    }

    /**
     * Gets the individual symbol identifier.
     * @param s symbol to be identified.
     * @return the symbol identifier.
     */
    int cast(String s) {
        return slexic.get(s);
    }

    /**
     * Check wether the symbol is defined in the alphabet.
     * @param s the symbol to check.
     * @return true if the symbol is defined.
     */
    boolean isSymbolDefined(String s) {
        return slexic.containsKey(s);
    }

    /**
     * Give the size of the alphabet.
     * @return the number of symbols of the alphabet.
     */
    int size() {
        return slexic.size();
    }

    /**
     * Write the alphabet to a stream.
     * @param output the outputstream.
     * @throws java.io.IOException.
     */
    void write(DataOutputStream output) throws IOException {
        // First, we write the taglist
        Compression.multibyte_write(slexicinv.size(), output);

        for (int i = 0,  limit = slexicinv.size(); i < limit; i++) {
            Compression.String_write(slexicinv.get(i).substring(1, 1 + slexicinv.get(i).length() - 2), output);
        }

        // Then we write the list of pairs
        // All numbers are biased + slexicinv.size() to be positive or zero
        int bias = slexicinv.size();

        Compression.multibyte_write(spairinv.size(), output);
        for (int i = 0,  limit = spairinv.size(); i != limit; i++) {
            Compression.multibyte_write(spairinv.get(i).first + bias, output);
            Compression.multibyte_write(spairinv.get(i).second + bias, output);
        }
    }

    /**
     * Compare with another instance of alphabet
     * Was written for debugging purpose
     * @param a the alphabet to compare to
     * @return true if both alphabets are similar
     */
    boolean compare(Alphabet a) {
        System.out.println("now comparing the alphabets");
        boolean sameSlexic = true;
        for (String s : a.slexic.keySet()) {
            if (!slexic.containsKey(s)) {
                sameSlexic = false;
                break;
            }
            if (!slexic.get(s).equals(a.slexic.get(s))) {
                sameSlexic = false;
                break;
            }
            slexic.remove(s);
        }
        System.out.println("the slexic attributes are the same : " + sameSlexic);
        boolean sameSlexicinv = true;
        for (int i = 0,  limit = a.slexicinv.size(); i < limit; i++) {
            boolean temp = false;
            for (int j = i,  limit2 = slexicinv.size() + i; j < limit2; j++) {
                int k = j % slexicinv.size();
                if (a.slexicinv.get(i).equals(slexicinv.get(k))) {
                    temp = true;
                    break;
                }
            }
            if (!temp) {
                sameSlexicinv = false;
                break;
            }

        }
        boolean sameSpair = true;
        System.out.println("the slexicinv attributes are the same : " + sameSlexicinv);
        for (IntegerPair p : a.spair.keySet()) {
            if(!spair.containsKey(p)) {
            //if (!containsKey(spair, p)) {
                sameSpair = false;
                break;
            }
            //if (!(get(spair, p).equals(get(a.spair, p)))) {
            if (!spair.get(p).equals(a.spair.get(p))) {
                sameSpair = false;
                break;
            }
        }
        System.out.println("the spair attributes are the same : " + sameSpair);
        boolean sameSpairinv = true;
        for (int i = 0,  limit = a.spairinv.size(); i < limit; i++) {
            boolean temp = false;
            for (int j = i,  limit2 = spairinv.size() + i; j < limit2; j++) {
                int k = j % spairinv.size();
                if (a.spairinv.get(i).equals(spairinv.get(k))) {
                    temp = true;
                    break;
                }
            }
            if (!temp) {
                sameSpairinv = false;
                break;
            }
        }
        System.out.println("the spairinv attributes are the same : " + sameSpairinv);
        return (sameSpairinv && sameSpair && sameSlexic && sameSlexicinv);
    }

    /**
     * Write the alphabet to a file, read it again,
     * and then check that both are similar
     * Was written for debugging purpose
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public void testIO() throws FileNotFoundException, IOException {
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("testAlphabet.bin")));
        this.write(output);
        output.close();
        DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("testAlphabet.bin")));
        Alphabet a = new Alphabet();
        a = read(input);
        input.close();
        if (this.compare(a)) {
            System.out.println("the two alphabets are the same : true");
        } else {
            System.out.println("the two alphabets are the same : false");
        }
    }

    /**
     * display the alphabet
     */
    public void display() {
        System.out.println("slexicinv : \n" + slexicinv);
        System.out.println("slexic : \n" + slexic);
        System.out.println("spairinv :\n ");
        System.out.print("[");
        for (int i = 0; i < spairinv.size() - 1; i++) {
            System.out.print("<" + spairinv.get(i).first + "," + spairinv.get(i).second + ">; ");
        }
        System.out.print("<" + spairinv.get(spairinv.size() - 1).first + "," + spairinv.get(spairinv.size() - 1).second + ">");
        System.out.println("]");
        System.out.println("spair :\n ");
        System.out.print("[");
        for (IntegerPair pair : spair.keySet()) {
            System.out.print("{<" + pair.first + "," + pair.second + "> =>" + spair.get(pair) + "}, ");
        }
        System.out.println("]");

    }

    /**
     * Read an alphabet from an input stream
     * @param input the stream to read from
     * @return the alphabet read from th input
     * @throws java.io.IOException
     */
    public static Alphabet read(DataInputStream input) throws IOException {
        Alphabet a_new = new Alphabet();
        a_new.spairinv.clear();
        a_new.spair.clear();

        // Reading of taglist
        int tam = Compression.multibyte_read(input);
        while (tam > 0) {
            tam--;
            String mytag = "<" + Compression.String_read(input) + ">";
            a_new.slexicinv.add(mytag);
            a_new.slexic.put(mytag, -a_new.slexicinv.size());
        }

        // Reading of pairlist
        int bias = a_new.slexicinv.size();
        tam = Compression.multibyte_read(input);
        while (tam > 0) {
            tam--;
            int first = Compression.multibyte_read(input);
            int second = Compression.multibyte_read(input);
            IntegerPair tmp2 = new IntegerPair(first - bias, second - bias);
            int spair_size = a_new.spair.size();
            a_new.spair.put(tmp2, spair_size);
            a_new.spairinv.add(tmp2);
        }

        return a_new;
    }

    public String toString() {
    	return slexicinv+"\n/"+spairinv +"\n/"+ spair;
    }


    /**
     * Concat the symbol symbol to the string s.
     * @param s string to which to add the symbol
     * @param symbol the symbol to be added
     * @return the concatenation of the string s and the symbol symbol 
     * (in lower case)
     */
    String getSymbol(String s, int symbol) {
        return getSymbol(s, symbol, false);
    }

    /**
     * Concat the symbol symbol to the string s.
     * @param s string to which to add the symbol
     * @param symbol the symbol to be added
     * @param uppercase true if we want an uppercase symbol
     * @return the concatenation of the string s and the symbol symbol
     */
    String getSymbol(String s, int symbol, boolean uppercase) {
        String result = new String(s);
        if (symbol == 0) {
            return result;
        }
        if (!uppercase) {
            if (symbol >= 0) {
                result += (char) (symbol);
            } else {
                result += (slexicinv.get(-symbol - 1));
            }
        } else if (symbol >= 0) {
            result += Character.toUpperCase((char) (symbol));
        } else {
            result += (slexicinv.get(-symbol - 1));
        }
        return result;
    }

    /**
     * Checks whether a symbol is a tag or not
     * @param symbol the code of the symbol
     * @return true if the symbol is a tag
     */
    boolean isTag(int symbol) {
        return symbol < 0;
    }

    public IntegerPair decode(int code) {
        return spairinv.get(code);
    }

}
