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

import java.io.DataInputStream;
import java.io.IOException;
import java.io.Writer;
import java.text.Collator;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;

public class FSTProcessor {
    private boolean isLastBlankTM;

  
    
    public enum GenerationMode {

        gm_clean, // clear all
        gm_unknown, // display unknown words, clear transfer and generation tags
        gm_all         // display all
    }
    Collator myCollator = Collator.getInstance();
    /**
     * Transducers in FSTP
     */
    Map<String, TransExe> transducers = new TreeMap<String, TransExe>(myCollator);
    /**
     * Current state of lexical analysis
     */
    //State current_state;
    /**
     * Initial state of every token
     */
    State initial_state;
    /**
     * Set of final states of incoditional sections in the dictionaries
     */
    Set<Node> inconditional;
    /**
     * Set of final states of standard sections in the dictionaries
     */
    Set<Node> standard;
    /**
     * Set of final states of postblank sections in the dictionaries
     */
    Set<Node> postblank;
    /**
     * Set of final states of preblank sections in the dictionaries
     */
    Set<Node> preblank;
    /**
     * Merge of 'inconditional', 'standard', 'postblank' and 'preblank' sets
     */
    Set<Node> all_finals;
    /**
     * Queue of blanks, used in reading methods
     */
    ArrayDeque<String> blankqueue;
    /**
     * Set of characters being considered alphabetics
     */
    Set<Character> alphabetic_chars;
    /**
     * Set of characters to escape with a backslash
     */
    Set<Character> escaped_chars = new HashSet<Character>();
    /**
     * Alphabet
     */
    Alphabet alphabet = new Alphabet();
    /**
     * Input buffer
     */
    Buffer input_buffer;
    /**
     * Begin of the transducer
     */
    Node root;
    /**
     * true if the position of input stream is out of a word
     */
    boolean outOfWord;
    /**
     * if true, makes always difference between uppercase and lowercase
     * characters
     */
    boolean caseSensitive;
    /**
     * if true, flush the output when the null character is found
     */
    boolean nullFlush;
    ArrayList<String> numbers;

    public FSTProcessor() {
        // escaped_chars chars
        escaped_chars.add('[');
        escaped_chars.add(']');
        escaped_chars.add('{');
        escaped_chars.add('}');
        escaped_chars.add('^');
        escaped_chars.add('$');
        escaped_chars.add('/');
        escaped_chars.add('\\');
        escaped_chars.add('@');
        escaped_chars.add('<');
        escaped_chars.add('>');
        caseSensitive = false;
        nullFlush = false;
        root = new Node();
        initial_state = new State();
        //not really elegant, but the Pool attribute is static, 
        //thus shared by all the instances of the class
        //and it needs to be initialized somewhere
        // JACOB initial_state.poolInit();
        postblank = new HashSet<Node>();
        inconditional = new HashSet<Node>();
        standard = new HashSet<Node>();
        preblank = new HashSet<Node>();
        input_buffer = new Buffer(2048); 
        blankqueue = new ArrayDeque<String>();

    }

    void streamError() {
        throw new RuntimeException("Error: Malformed input stream.");
    }

    Character readEscaped(DataInputStream input) throws IOException {
        
        
        if (input.available() == 0) {
            streamError();
        }

        Character val = read(input);
        //System.out.println("read "+val);

        if (input.available() == 0 || (!escaped_chars.contains(val))) {
            streamError();
        }

        return val;
    }

    String readFullBlock(DataInputStream input, Character delim1, Character delim2) throws IOException {
        String result = "";
        result += delim1;
        Character c = delim1;

        while (input.available() != 0 && c != delim2) {
            c=read(input);
        //System.out.println("read "+c);
            result += c;
            if (c != '\\') {
                continue;
            } else {
                result += readEscaped(input);
            }
        }

        if (c != delim2) {
            streamError();
        }

        return result;
    }

    char readAnalysis(DataInputStream input) throws IOException {
//        while(input.available()>0) {
//            System.err.println(read(input));
//        }
        //System.out.println("entering readAnalysis");
//        if (input.available() == 0) {
//            System.out.println("exiting readAnalysis");
//            return (char) 0;
//        }
        if (!input_buffer.isEmpty()) {
            //System.out.println("inside the if : input buffer is not empty");
            //System.out.println("exiting readAnalysis with input_buffer : "+input_buffer);
            return input_buffer.next();
        }
if (input.available() == 0) {
            //System.out.println("exiting readAnalysis");
            return (char) 0;
        }
        Character val = read(input);
        //System.out.println("readA "+val);
        char altval = (char) 0;
//        System.out.println("input.available() == "+input.available());
//        if (input.available() == 0) {
//            System.out.println("exiting readAnalysis");
//            return (char) 0;
//        }

        if (escaped_chars.contains(val)) {
            //System.out.println("the read char is an escaped char");
            switch (val) {
                case '<':
                    altval = (char) (alphabet.cast(readFullBlock(input, '<', '>')));
                    input_buffer.add(altval);
                    return altval;

                case '[':
                    blankqueue.addLast(readFullBlock(input, '[', ']'));
                    input_buffer.add((' '));
                    return (' ');

                case '\\':
                    val = read(input);
        //System.out.println("read "+val);
                    if (!escaped_chars.contains(val)) {
                        streamError();
                    }
                    input_buffer.add((val));
                    return val;

                default:
                    streamError();
            }
        }

        input_buffer.add(val);
        //System.out.println("exiting readAnalysis");
        return val;
    }

    private char readTMAnalysis(DataInputStream input) throws IOException {
        isLastBlankTM = false;
        if (!input_buffer.isEmpty()) {
            return input_buffer.next();
        }
        if (input.available() == 0) {
            //System.out.println("exiting readAnalysis");
            return (char) 0;
        }
        Character val = read(input);
        //System.out.println("readA "+val);
        char altval = (char) 0;
//        System.out.println("input.available() == "+input.available());
//        if (input.available() == 0) {
//            System.out.println("exiting readAnalysis");
//            return (char) 0;
//        }

        if (escaped_chars.contains(val)||iswdigit(val)) {
            //System.out.println("the read char is an escaped char");
            switch (val) {
                case '<':
                    altval = (char) (alphabet.cast(readFullBlock(input, '<', '>')));
                    input_buffer.add(altval);
                    return altval;

                case '[':
                    blankqueue.addLast(readFullBlock(input, '[', ']'));
                    input_buffer.add((' '));
                    isLastBlankTM = true;
                    return (' ');

                case '\\':
                    val = read(input);
                    if (!escaped_chars.contains(val)) {
                        streamError();
                    }
                    input_buffer.add((val));
                    return val;

                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    String s = "";
                    if (!input.markSupported()) {
                        throw new RuntimeException("The inpput stream doesn't support marks."
                            +"There will be a problem to find an equivalent to the ungetwc function");
                    }
                    do {
                        s+=val;
                        input.mark(3);
                        val = read(input);
                    } while (iswdigit(val));
                    input.reset();
                    input_buffer.add((char)alphabet.cast("<n>"));
                    numbers.add(s);
                    return (char)alphabet.cast(s);
                default:
                    streamError();
            }
        }

        input_buffer.add(val);
        return val;
    }

    char readPostgeneration(DataInputStream input) throws IOException {
        if (!input_buffer.isEmpty()) {
//            System.out.println("here");
//            System.exit(-1);
            return input_buffer.next();
        }

        if (input.available() == 0) {
            return (char) 0;
        }
        Character val = read(input);
        //System.out.println("read "+val);
        char altval = (char) 0;


        switch (val) {
            case '<':
                altval = (char) (alphabet.cast(readFullBlock(input, '<', '>')));
                input_buffer.add(altval);
                return altval;

            case '[':
                blankqueue.addLast(readFullBlock(input, '[', ']'));
                input_buffer.add((' '));
                return (' ');

            case '\\':
                val = read(input);
                //System.out.println("read "+val);
                if (!escaped_chars.contains(val)) {
                    streamError();
                }
                input_buffer.add((val));
                return val;

            default:
                input_buffer.add(val);
                return val;
        }
    }

    void skipUntil(DataInputStream input, Writer output, char character) throws IOException {
        while (true) {
            if (input.available() == 0) {
                return;
            }
            char val = read(input);
            //System.out.println("read "+val);


            if (val == '\\') {
                if (input.available() == 0) {
                    return;
                }
                val = read(input);
                //System.out.println("read "+val);

                output.write('\\');
                output.write(val);
            } else if (val == character) {
                return;
            } else {
                output.write(val);
            }
        }
    }

    int readGeneration(DataInputStream input, Writer output) throws IOException {
       
        if (input.available() == 0) {
            return 0x7fffffff;
        }
        char val = read(input);
        //System.out.println("read "+val);

        

        if (outOfWord) {
            if (val == '^') {
                if (input.available() == 0) {
                    return 0x7fffffff;
                }
                val = read(input);
        //System.out.println("read "+val);
                
            } else if (val == '\\') {
                output.write(val);
                if (input.available() == 0) {
                    return 0x7fffffff;
                }
                val = read(input);
        //System.out.println("read "+val);
                
                output.write(val);
                skipUntil(input, output, '^');
                 if (input.available() == 0) {
                    return 0x7fffffff;
                }
                val = read(input);
        //System.out.println("read "+val);
               
            } else {
                output.write(val);
                skipUntil(input, output, '^');
                if (input.available() == 0) {
                    return 0x7fffffff;
                }
                val = read(input);
        //System.out.println("read "+val);
                
            }
            outOfWord = false;
        }

        if (val == '\\') {
            val = read(input);
        //System.out.println("read "+val);
            return (int) (val);
        } else if (val == '$') {
            outOfWord = true;
            return (int) ('$');
        } else if (val == '<') {
            String cad = "";
            cad += val;
            
            
            if (input.available() == 0) {
                    streamError();
                }
            val = read(input);
        //System.out.println("read "+val);
            while (val != '>') {
               cad += val;
                if (input.available() == 0) {
                    streamError();
                }
                val = read(input);
        //System.out.println("read "+val);
            }
            cad += val;
            return alphabet.cast(cad);
        } else if (val == '[') {
            output.write(readFullBlock(input, '[', ']'));
            return readGeneration(input, output);
        } else {
            return (int) (val);
        }

    // return 0x7fffffff;
    }

    void flushBlanks(Writer output) throws IOException {
        for (int i = blankqueue.size(); i > 0; i--) {
            output.write(blankqueue.getFirst());
            blankqueue.removeFirst();
        }
    }

    void calcInitial() {
        //System.out.println("call to calcInitial");
        for (String first : transducers.keySet()) {
            root.addTransition(0, 0, transducers.get(first).getInitial());
        }
        //System.out.println("plp");
        initial_state.init(root);
        //System.out.println("exiting calcInitial");
    }

    boolean endsWith(String str, String suffix) {
        if (str.length() < suffix.length()) {
            return false;
        } else {
            return str.substring(str.length() - suffix.length()).equals(suffix);
        }
    }

    void classifyFinals() {
        for (String first : transducers.keySet()) {
            final TransExe second = transducers.get(first);
            if (endsWith(first, "@inconditional")) {
                inconditional.addAll(second.getFinals());
            } else if (endsWith(first, "@standard")) {
                standard.addAll(second.getFinals());
            } else if (endsWith(first, "@postblank")) {
                postblank.addAll(second.getFinals());
            } else if (endsWith(first, "@preblank")) {
                preblank.addAll(second.getFinals());
            } else {
                throw new RuntimeException("Error: Unsupported transducer type for '" + first + "'.");
            }
        }
    }

    void writeEscaped(String str, Writer output) throws IOException {
        for (int i = 0,  limit = str.length(); i < limit; i++) {
            if (escaped_chars.contains(charAt(str,i))) {
                output.write('\\');
            }
            output.write(charAt(str,i));
        }
    }

    void printWord(String sf, String lf, Writer output) throws IOException {
        output.write('^');
        writeEscaped(sf, output);
        output.write(lf);
        output.write('$');
    }

    void printUnknownWord(String sf, Writer output) throws IOException {
//        try {
//            throw new RuntimeException("toto");
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//            //System.exit(-1);
//        }
        output.write('^');
        writeEscaped(sf, output);
        output.write('/');
        output.write('*');
        writeEscaped(sf, output);
        output.write('$');
    }

    int lastBlank(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (!alphabetic_chars.contains(charAt(str,i))) {
                return (i);
            }
        }
        return 0;
    }

    void printSpace(Character val, Writer output) throws IOException {
        if (blankqueue.size() > 0) {
            flushBlanks(output);
        } else {
            output.write(val);
        }
    }

    boolean isEscaped(Character c) {
        return escaped_chars.contains(c);
    }

    boolean isAlphabetic(Character c) {
        return alphabetic_chars.contains(c);
    }

    public void load( DataInputStream input) throws IOException {
        // letters
   
        int len = Compression.multibyte_read(input);
        alphabetic_chars = new HashSet<Character>(len);

        while (len > 0) {
            char c = (char) Compression.multibyte_read(input);
            //if (DEBUG) System.err.println("alphabetic_chars.add(" + c);
            alphabetic_chars.add(c);
            len--;
        }

        // symbols
        alphabet= Alphabet.read(input);
        
        if (DEBUG) System.err.println("alphabet = " + alphabet.toString());
        //if (DEBUG) alphabet.display();
       
        //loading the sections transducers
        len = Compression.multibyte_read(input);
        while (len > 0) {
            String name = Compression.String_read(input);
            if (!transducers.containsKey(name)) {
                transducers.put(name,new TransExe());
            } else {
              System.err.println(this.getClass()+".load() Why has transducer already name "+ name);
            }

            //System.out.println("reading : "+name);
            transducers.get(name).read(input, alphabet);
            len--;
            //System.out.println(len);
        }

        //if (DEBUG)  System.err.println("  transducers = " + transducers.toString());
        
    }

    void initAnalysis() {
        //System.out.println("entering initAnalysis");
    
        calcInitial();
        classifyFinals();
        all_finals = standard;
        all_finals.addAll(inconditional);
        all_finals.addAll(postblank);
        all_finals.addAll(preblank);
        //System.out.println("exiting initanalysis");
    }

    void initTMAnalysis() {
        numbers = new ArrayList<String>();
        all_finals = new HashSet<Node>();
        calcInitial();
        for (TransExe t : transducers.values()) {
            all_finals.addAll(t.getFinals());
        }
    }

    void initGeneration() {
        calcInitial();
        all_finals = new HashSet<Node>();
        for (String first : transducers.keySet()) {
            
            all_finals.addAll(transducers.get(first).getFinals());
        }
    }

    void initPostgeneration() {
        initGeneration();
    }

    public void initBiltrans() {
        initGeneration();
    }

    private static boolean DEBUG = false;

    //Maybe this wasn't really necessary,
    //but to prevent problems with the difference from the java charAt() method
    //and the c++ [] operator, I wrote this method
    Character charAt(String s, int index) {
        if (index>=s.length()) {
            return (char)0;
        }
        return s.charAt(index);
    }
    
    void analysis(DataInputStream input, Writer output) throws IOException {
        //System.out.println("entering analysis");
        if (getNullFlush()) {
            analysis_wrapper_null_flush(input, output);
        }

        boolean last_incond = false;
        boolean last_postblank = false;
        boolean last_preblank = false;
        State current_state = new State().copy(initial_state);
        String lf = "";
        String sf = "";
        int last = 0;

        Character val;
        while ((val = readAnalysis(input)) != (char)0) {
         if (DEBUG) System.err.println("inside while, val = "+val+" "+ (int)val);
            // test for final states
            if (current_state.isFinal(all_finals)) {
                //System.out.println("current_state.isFinal(all_finals)");
                if (current_state.isFinal(inconditional)) {
                //System.out.println("current_state.isFinal(inconditional)");
                    boolean firstupper = Character.isUpperCase(charAt(sf,0));
                    boolean uppercase = firstupper && Character.isUpperCase(charAt(sf,sf.length() - 1));

                    lf = current_state.filterFinals(all_finals, alphabet,
                            escaped_chars,
                            uppercase, firstupper);
                    last_incond = true;
                    last = input_buffer.getPos();
                } else if (current_state.isFinal(postblank)) {
                //System.out.println("current_state.isFinal(postblank)");
                    boolean firstupper = Character.isUpperCase(charAt(sf,0));
                    boolean uppercase = firstupper && Character.isUpperCase(charAt(sf,sf.length() - 1));

                    lf = current_state.filterFinals(all_finals, alphabet,
                            escaped_chars,
                            uppercase, firstupper);
                    last_postblank = true;
                    last = input_buffer.getPos();
                } else if (current_state.isFinal(preblank)) {
                //System.out.println("current_state.isFinal(preblank)");
                    boolean firstupper = Character.isUpperCase(charAt(sf,0));
                    boolean uppercase = firstupper && Character.isUpperCase(charAt(sf,sf.length() - 1));

                    lf = current_state.filterFinals(all_finals, alphabet,
                            escaped_chars,
                            uppercase, firstupper);
                    last_preblank = true;
                    last = input_buffer.getPos();
                } else if (!isAlphabetic(val)) {
                if (DEBUG) System.err.println("!isAlphabetic(val)");
                    boolean firstupper = Character.isUpperCase(charAt(sf,0));
                    boolean uppercase = firstupper && Character.isUpperCase(charAt(sf,sf.length() - 1));

                    lf = current_state.filterFinals(all_finals, alphabet,
                            escaped_chars,
                            uppercase, firstupper);
                    last_postblank = false;
                    last_preblank = false;
                    last_incond = false;
                    last = input_buffer.getPos();
                }
                if (DEBUG) System.err.println("1 sf="+sf + " lf="+lf);
            } else if (sf.equals("") && Character.isSpaceChar(val)) {
                //System.out.println("sf.equals(\"\") && Character.isSpaceChar(val)");
                lf = "/*";
                lf+=sf;
                last_postblank = false;
                last_preblank = false;
                last_incond = false;
                last = input_buffer.getPos();
                if (DEBUG) System.err.println("2 sf="+sf + " lf="+lf);
            }

            if (!Character.isUpperCase(val) || caseSensitive) {
                current_state.step(val);
            } else {
                current_state.step(val, Character.toLowerCase(val));
            }

            if (current_state.size() != 0) {
                sf=alphabet.getSymbol(sf, val);
                if (DEBUG) System.err.println("1 sf="+sf);

            } else {
                if (!isAlphabetic(val) && sf.equals("")) {
                    if (Character.isSpaceChar(val)) {
                        printSpace(val, output);
                    } else {
                        if (isEscaped(val)) {
                            output.write('\\');
                        }
                        output.write(val);
                    }
                } else if (last_postblank) {
                    printWord(sf.substring(0, sf.length() - input_buffer.diffPrevPos(last)),
                            lf, output);
                    output.write(' ');
                    input_buffer.setPos(last);
                    input_buffer.back(1);
                } else if (last_preblank) {
                    output.write(' ');
                    printWord(sf.substring(0, sf.length() - input_buffer.diffPrevPos(last)),
                            lf, output);
                    input_buffer.setPos(last);
                    input_buffer.back(1);
                } else if (last_incond) {
                    printWord(sf.substring(0, sf.length() - input_buffer.diffPrevPos(last)),
                            lf, output);
                    input_buffer.setPos(last);
                    input_buffer.back(1);
                } else if (isAlphabetic(val) &&
                        ((sf.length() - input_buffer.diffPrevPos(last)) > lastBlank(sf) ||
                        lf.equals(""))) {
                if (DEBUG) System.err.println("3 sf="+sf + " lf="+lf);
                    do {
        //System.out.println("read "+val);
                        sf=alphabet.getSymbol(sf, val);
                if (DEBUG) System.err.println("4 sf="+sf + " lf="+lf);
                    } while (((val = readAnalysis(input)) != (char)0 )&& isAlphabetic(val));
//System.out.println("val "+val);
//System.out.println("isAlphabetic(val) :"+isAlphabetic(val));
//System.out.println("val == (char)0 : "+(val==(char)0));
                    
                    //System.out.println("string read : '"+sf+"'");
                    if (sf.equals("content")) {
                        //System.out.println("tout lu, val = "+val);
                        //System.out.println("val == (char)0 "+(val == (char)0));
                        //System.out.println("readAnalysis(input) == (char)0 : "+(readAnalysis(input)==(char)0));
                    }
                    int limit = firstNotAlpha(sf);
                    
                    
                    int size = sf.length();
                    //System.err.println("size : "+size);
                    limit = (limit == Integer.MAX_VALUE ? size : limit);
                    //if (sf.equals("content")) {
                    //System.err.println("limit : "+limit);
                    //System.err.println("input_buffer : "+input_buffer.toString());
                    //System.exit(-1);
                    //}
                    if (limit == 0) {
                        input_buffer.back(sf.length());
                        output.write(charAt(sf,0));
                if (DEBUG) System.err.println("5 sf="+sf + " lf="+lf);
                    } else {
                        input_buffer.back(1 + (size - limit));
                        printUnknownWord(sf.substring(0, limit), output);
                if (DEBUG) System.err.println("6 sf="+sf + " lf="+lf);
                    }
                } else if (lf.equals("")) {
                    int limit = firstNotAlpha(sf);
                    int size = sf.length();
                    limit = (limit == Integer.MAX_VALUE ? size : limit);
                    if (limit == 0) {
                        input_buffer.back(sf.length());
                        output.write(charAt(sf,0));
                if (DEBUG) System.err.println("7 sf="+sf + " lf="+lf);
                    } else {
                        input_buffer.back(1 + (size - limit));
                        printUnknownWord(sf.substring(0, limit), output);
                if (DEBUG) System.err.println("8 sf="+sf + " lf="+lf);
                    }
                } else {
                    printWord(sf.substring(0, sf.length() - input_buffer.diffPrevPos(last)),
                            lf, output);
                    input_buffer.setPos(last);
                    input_buffer.back(1);
                if (DEBUG) System.err.println("9 sf="+sf + " lf="+lf);
                }

                current_state.copy(initial_state);
                lf = "";
                sf = "";
                last_incond = false;
                last_postblank = false;
                last_preblank = false;
            }
        }

        // print remaining blanks
        flushBlanks(output);
    }

    void analysis_wrapper_null_flush(DataInputStream input, Writer output) throws IOException {
        setNullFlush(false);
        while (input.available() >0) {
            analysis(input, output);
            output.write('\0');
            try {
            output.flush();
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Could not flush output");
            }
        }
    }

    void generation_wrapper_null_flush(DataInputStream input, Writer output,
            GenerationMode mode) throws IOException{
        setNullFlush(false);
        while (input.available() >0) {
            generation(input, output, mode);
            output.write('\0');
            try {
            output.flush();
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Could not flush output");
            }
        }
    }

    void postgeneration_wrapper_null_flush(DataInputStream input, Writer output) throws IOException {
        setNullFlush(false);
        while (input.available() >0) {
            postgeneration(input, output);
            output.write('\0');
            try {
            output.flush();
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Could not flush output");
            }
        }
    }

    void transliteration_wrapper_null_flush(DataInputStream input, Writer output) throws IOException {
        setNullFlush(false);
        while (input.available() >0) {
            transliteration(input, output);
            output.write('\0');
            try {
            output.flush();
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Could not flush output");
            }
        }
    }

    void tm_analysis(DataInputStream input, Writer output) throws IOException {

        State current_state = new State().copy(initial_state);
        String lf = "";
        String sf = "";
        int last = 0;

        Character val;
        while ((val = readAnalysis(input)) != (char) 0) {
            // test for final states
            if (current_state.isFinal(all_finals)) {
                if (iswpunct(val)) {
                    lf = current_state.filterFinalsTM(all_finals, alphabet,
                        escaped_chars,
                        blankqueue, numbers).substring(1);
                    last = input_buffer.getPos();
                    numbers.clear();
                }
            } else if (sf.equals("") && Character.isSpaceChar(val)) {
                lf += sf;
                last = input_buffer.getPos();
            }

            if (!Character.isUpperCase(val)) {
                current_state.step(val);
            } else {
                current_state.step(val, Character.toLowerCase(val));
            }

            if (current_state.size() != 0) {
                if (val == -1) {
                    sf += numbers.get(numbers.size() - 1);
                } else if (isLastBlankTM && val == ' ') {
                    sf += blankqueue.getLast();
                } else {
                    sf = alphabet.getSymbol(sf, val);
                }
            } else {
                if ((Character.isWhitespace(val) || iswpunct(val)) && sf.equals("")) {
                    if (Character.isWhitespace(val)) {
                        printSpace(val, output);
                    } else {
                        if (isEscaped(val)) {
                            output.write("\\");
                        }
                        output.write(val);
                    }
                } else if (!Character.isWhitespace(val) && !iswpunct(val) &&
                    ((sf.length() - input_buffer.diffPrevPos(last)) > lastBlank(sf) ||
                    lf.equals(""))) {

                    do {
                        if (val == -1) {
                            sf += numbers.get(numbers.size() - 1);
                        } else if (isLastBlankTM && val == ' ') {
                            sf += (blankqueue.getLast());
                        } else {
                            sf = alphabet.getSymbol(sf, val);
                        }
                    } while (((val = readTMAnalysis(input)) != (char) 0) && !Character.isWhitespace(val) && !iswpunct(val));

                    if (val == 0) {
                        output.write(sf);
                        return;
                    }
                    input_buffer.back(1);
                    output.write(sf);
                    while (blankqueue.size() > 0) {
                        if (blankqueue.size() == 1 && isLastBlankTM) {
                            break;
                        }
                        blankqueue.removeLast();
                    }
                } else if (lf.equals("")) {
                    input_buffer.back(1);

                    output.write(sf);
                    while (blankqueue.size() > 0) {
                        if (blankqueue.size() == 1 && isLastBlankTM) {
                            break;
                        }
                        blankqueue.removeLast();
                    }
                } else {

                    output.write('[');
                    output.write(lf);
                    output.write(']');
                    input_buffer.setPos(last);
                    input_buffer.back(1);
                }
                current_state.copy(initial_state);
                lf = "";
                sf = "";
            }
        }

        // print remaining blanks
        flushBlanks(output);
    }


    void generation(DataInputStream input, Writer output, GenerationMode mode) throws IOException {
        if (getNullFlush()) {
            generation_wrapper_null_flush(input, output, mode);
        }

        State current_state = new State().copy(initial_state);
        String sf = "";

        outOfWord = false;

        skipUntil(input, output, '^');
        int val;
        while ((val = readGeneration(input, output)) != 0x7fffffff) {
            if (sf.equals("") && val == '=') {
                output.write('=');
                val = readGeneration(input, output);
            }
            if (val == '$' && outOfWord) {
                if (charAt(sf,0) == '*' || charAt(sf,0) == '%') {
                    if (mode != GenerationMode.gm_clean) {
                        writeEscaped(sf, output);
                    } else {
                        writeEscaped(sf.substring(1), output);
                    }
                } else if (charAt(sf,0) == '@') {
                    if (mode == GenerationMode.gm_all) {
                        writeEscaped(sf, output);
                    } else if (mode == GenerationMode.gm_clean) {
                        writeEscaped(removeTags(sf.substring(1)), output);
                    } else if (mode == GenerationMode.gm_unknown) {
                        writeEscaped(removeTags(sf), output);
                    }
                } else if (current_state.isFinal(all_finals)) {
                    boolean uppercase = sf.length() > 1 && Character.isUpperCase(charAt(sf,1));
                    boolean firstupper = Character.isUpperCase(charAt(sf,0));

                    output.write(current_state.filterFinals(all_finals, alphabet,
                            escaped_chars,
                            uppercase, firstupper).substring(1));
                } else {
                    if (mode == GenerationMode.gm_all) {
                        output.write('#');
                        writeEscaped(sf, output);
                    } else if (mode == GenerationMode.gm_clean) {
                        writeEscaped(removeTags(sf), output);
                    } else if (mode == GenerationMode.gm_unknown) {
                        output.write('#');
                        writeEscaped(removeTags(sf), output);
                    }
                }

                current_state.copy(initial_state);
                sf = "";
            } else if (Character.isSpaceChar((char) val) && sf.length() == 0) {
            // do nothing
            } else if (sf.length() > 0 && (charAt(sf,0) == '*' || charAt(sf,0) == '%')) {
                sf=alphabet.getSymbol(sf, val);
            } else {
                sf=alphabet.getSymbol(sf, val);
                if (current_state.size() > 0) {
                    if (!alphabet.isTag(val) && Character.isUpperCase(val) && !caseSensitive) {
                        current_state.step(val, Character.toLowerCase(val));
                    } else {
                        current_state.step(val);
                    }
                }
            }
        }
    }

    void postgeneration(DataInputStream input, Writer output) throws IOException {
        if (getNullFlush()) {
            postgeneration_wrapper_null_flush(input, output);
        }

        boolean skip_mode = true;
        State current_state = new State().copy(initial_state);
        StringBuilder lf = new StringBuilder("");
        String sf = "";
        Set<Character> empty_escaped_chars = new HashSet<Character>();
        int last = 0;

        Character val;
        while ((val = readPostgeneration(input)) != (char)0) {

            if (val == '~') {
                skip_mode = false;
            }

            if (skip_mode) {
                if (Character.isSpaceChar(val)) {
                    printSpace(val, output);
                } else {
                    if (isEscaped(val)) {
                        output.write('\\');
                    }
                    output.write(val);
                }
            } else {
                // test for final states
                if (current_state.isFinal(all_finals)) {
                    boolean firstupper = Character.isUpperCase(charAt(sf,1));
                    boolean uppercase = sf.length() > 1 && firstupper && Character.isUpperCase(charAt(sf,2));
                    lf = new StringBuilder(current_state.filterFinals(all_finals, alphabet,
                            empty_escaped_chars,
                            uppercase, firstupper, 0));

                    // case of the beggining of the next word

                    String mybuf = "";
                    for (int i = sf.length() - 1; i >= 0; i--) {
                        if (!Character.isLetter(charAt(sf,i))) {
                            break;
                        } else {
                            mybuf = charAt(sf,i) + mybuf;
                        }
                    }

                    if (mybuf.length() > 0) {
                        boolean myfirstupper = Character.isUpperCase(charAt(mybuf,0));
                        boolean myuppercase = mybuf.length() > 1 && Character.isUpperCase(charAt(mybuf,1));

                        for (int i = lf.length() - 1; i >= 0; i--) {
                            if (!Character.isLetter(charAt(lf.toString(),i))) {
                                if (myfirstupper && i != lf.length() - 1) {
                                    lf.setCharAt(i + 1, Character.toUpperCase(charAt(lf.toString(),i + 1)));
                                } else {
                                    lf.setCharAt(i + 1, Character.toLowerCase(charAt(lf.toString(),i + 1)));
                                }
                                break;
                            } else {
                                if (myuppercase) {
                                    lf.setCharAt(i, Character.toUpperCase(charAt(lf.toString(),i)));
                                } else {
                                    lf.setCharAt(i, Character.toLowerCase(charAt(lf.toString(),i)));
                                }
                            }
                        }
                    }

                    last = input_buffer.getPos();
                }

                if (!Character.isUpperCase(val) || caseSensitive) {
                    current_state.step(val);
                } else {
                    current_state.step(val, Character.toLowerCase(val));
                }

                if (current_state.size() != 0) {
                    sf=alphabet.getSymbol(sf, val);
                } else {
                    if (lf.length()==0) {
                        int mark = sf.length();
                        for (int i = 1,  limit = sf.length(); i < limit; i++) {
                            if (charAt(sf,i) == '~') {
                                mark = i;
                                break;
                            }
                        }
                        output.write(sf.substring(1, mark - 1 + 1));
                        if (mark == sf.length()) {
                            input_buffer.back(1);
                        } else {
                            input_buffer.back(sf.length() - mark);
                        }
                    } else {
                        output.write(lf.substring(1, lf.length() - 3 +1));
                        input_buffer.setPos(last);
                        input_buffer.back(2);
                        val = charAt(lf.toString(),lf.length() - 2);
                        if (Character.isSpaceChar(val)) {
                            printSpace(val, output);
                        } else {
                            if (isEscaped(val)) {
                                output.write('\\');
                            }
                            output.write(val);
                        }
                    }

                    current_state.copy(initial_state);
                    lf = new StringBuilder("");
                    sf = "";
                    skip_mode = true;
                }
            }
        }

        // print remaining blanks
        flushBlanks(output);
    }

    void transliteration(DataInputStream input, Writer output) throws IOException {
        if (getNullFlush()) {
            transliteration_wrapper_null_flush(input, output);
        }

        State current_state = new State().copy(initial_state);
        String lf = "";
        String sf = "";
        int last = 0;

        Character val;
        while ((val = readPostgeneration(input)) != (char)0) {
            if (iswpunct(val) || Character.isSpaceChar(val)) {
                boolean firstupper = false;
                boolean uppercase = false;
                if (!sf.isEmpty()) {
                    firstupper = Character.isUpperCase(charAt(sf,1));
                    uppercase = sf.length() > 1 && firstupper && Character.isUpperCase(charAt(sf,2));
                }
                lf = current_state.filterFinals(all_finals, alphabet, escaped_chars,
                        uppercase, firstupper, 0);
                if (lf.length() > 0) {
                    output.write(lf.substring(1));
                    current_state.copy(initial_state);
                    lf = "";
                    sf = "";
                }
                if (Character.isSpaceChar(val)) {
                    printSpace(val, output);
                } else {
                    if (isEscaped(val)) {
                        output.write('\\');
                    }
                    output.write(val);
                }
            } else {
                if (current_state.isFinal(all_finals)) {
                    boolean firstupper = Character.isUpperCase(charAt(sf,1));
                    boolean uppercase = sf.length() > 1 && firstupper && Character.isUpperCase(charAt(sf,2));
                    lf = current_state.filterFinals(all_finals, alphabet, escaped_chars,
                            uppercase, firstupper, 0);
                    last = input_buffer.getPos();
                }

                current_state.step(val);
                if (current_state.size() != 0) {
                    sf=alphabet.getSymbol(sf, val);
                } else {
                    if (lf.length() > 0) {
                        output.write(lf.substring(1));
                        input_buffer.setPos(last);
                        input_buffer.back(1);
                        val = charAt(lf,lf.length() - 1);
                    } else {
                        if (Character.isSpaceChar(val)) {
                            printSpace(val, output);
                        } else {
                            if (isEscaped(val)) {
                                output.write('\\');
                            }
                            output.write(val);
                        }
                    }
                    current_state.copy(initial_state);
                    lf = "";
                    sf = "";
                }
            }
        }
        // print remaining blanks
        flushBlanks(output);
    }


    public String biltrans(String input_word, boolean with_delim) {
        State current_state = new State().copy(initial_state);
        StringBuilder result = new StringBuilder("");
        int start_point = 1;
        int end_point = input_word.length() - 2;
        StringBuilder queue = new StringBuilder("");
        boolean mark=false;
        
        if (!with_delim) {
            start_point = 0;
            end_point = input_word.length() - 1;
        }

        if (charAt(input_word,start_point) == '*') {
            return input_word;
        }
        
        if(charAt(input_word,start_point) == '=') {
            start_point++;
            mark = true;
        }
        boolean firstupper = Character.isUpperCase(charAt(input_word,start_point));
        boolean uppercase = firstupper && Character.isUpperCase(charAt(input_word,start_point + 1));

        for (int i = start_point; i <= end_point; i++) {
            int val;
            String symbol = "";

            if (charAt(input_word,i) == '\\') {
                i++;
                val = (int) (charAt(input_word,i));
            } else if (charAt(input_word,i) == '<') {
                symbol = "<";
                for (int j = i + 1; j <= end_point; j++) {
                    symbol += charAt(input_word,j);
                    if (charAt(input_word,j) == '>') {
                        i = j;
                        break;
                    }
                }
                val = alphabet.cast(symbol);
            } else {
                val = (int) (charAt(input_word,i));
            }
            if (current_state.size() != 0) {
                if (!alphabet.isTag(val) && Character.isUpperCase(val) && !caseSensitive) {
                    current_state.step(val, Character.toLowerCase(val));
                } else {
                    current_state.step(val);
                }
            }
            if (current_state.isFinal(all_finals)) {
                result = new StringBuilder(current_state.filterFinals(all_finals, alphabet,
                        escaped_chars,
                        uppercase, firstupper, 0));
                if (with_delim) {
                    if(mark) {
                        result = new StringBuilder("^="+result.substring(1));
                    } else {
                        result.setCharAt(0, '^');
                    }
                } else {
                    if(mark) {
                        result = new StringBuilder("="+result.substring(1));
                    } else {
                        result = new StringBuilder(result.substring(1));
                    }
                }
            }

            if (current_state.size() == 0) {
                if (!symbol.equals("") && !result.toString().equals("")){
                    queue.append(symbol);
                } else {
                    // word is not present
                    if (with_delim) {
                        result = new StringBuilder("^@" + input_word.substring(1));
                    } else {
                        result = new StringBuilder("@" + input_word);
                    }
                    return result.toString();
                }
            }
        }

        // attach unmatched queue automatically

        if (queue.length() != 0) {
            StringBuilder result_with_queue = new StringBuilder("");
            boolean multiple_translation = false;
            for (int i = 0,  limit = result.length(); i != limit; i++) {
                switch (charAt(result.toString(),i)) {
                    case '\\':
                        result_with_queue.append('\\');
                        i++;
                        break;

                    case '/':
                        result_with_queue.append(queue);
                        multiple_translation = true;
                        break;

                    default:
                        break;
                }
                result_with_queue.append(charAt(result.toString(),i));
            }
            result_with_queue.append(queue);

            if (with_delim) {
                result_with_queue.append('$');
            }
            return result_with_queue.toString();
        } else {
            if (with_delim) {
                result.append('$');
            }
            return result.toString();
        }
    }

    public Pair<String, Integer> biltransWithQueue(String input_word, boolean with_delim) {
        State current_state = new State().copy(initial_state);
        StringBuilder result = new StringBuilder("");
        int start_point = 1;
        int end_point = input_word.length() - 2;
        StringBuilder queue = new StringBuilder("");
        boolean mark=false;
        
        if (!with_delim) {
            start_point = 0;
            end_point = input_word.length() - 1;
        }

        if (charAt(input_word,start_point) == '*') {
            return new Pair<String, Integer>(input_word, 0);
        }

        if (charAt(input_word,start_point) == '=') {
            start_point++;
            mark = true;
        }

        boolean firstupper = Character.isUpperCase(charAt(input_word,start_point));
        boolean uppercase = firstupper && Character.isUpperCase(charAt(input_word,start_point + 1));

        for (int i = start_point; i <= end_point; i++) {
            int val = 0;
            String symbol = "";

            if (charAt(input_word,i) == '\\') {
                i++;
                val = charAt(input_word,i);
            } else if (charAt(input_word,i) == '<') {
                symbol = "<";
                for (int j = i + 1; j <= end_point; j++) {
                    symbol += charAt(input_word,j);
                    if (charAt(input_word,j) == '>') {
                        i = j;
                        break;
                    }
                }
                val = alphabet.cast(symbol);
            } else {
                val = charAt(input_word,i);
            }
            if (current_state.size() != 0) {
                if (!alphabet.isTag(val) && Character.isUpperCase(val) && !caseSensitive) {
                    current_state.step(val, Character.toLowerCase(val));
                } else {
                    current_state.step(val);
                }
            }
            if (current_state.isFinal(all_finals)) {
                result = new StringBuilder(current_state.filterFinals(all_finals, alphabet,
                        escaped_chars,
                        uppercase, firstupper, 0));
                if (with_delim) {
                    if (mark) {
                        result = new StringBuilder("^=" + result.substring(1));
                    } else {
                        result.setCharAt(0, '^');
                    }
                } else {
                    if (mark) {
                        result = new StringBuilder("=" + result.substring(1));
                    } else {
                    result = new StringBuilder(result.substring(1));
                    }
                }
            }

            if (current_state.size() == 0) {
                if (!symbol.equals("") && !result.toString().equals("")) {
                    queue.append(symbol);
                } else {
                    // word is not present
                    if (with_delim) {
                        result = new StringBuilder("^@" + input_word.substring(1));
                    } else {
                        result = new StringBuilder("@" + input_word);
                    }
                    return new Pair<String, Integer>(result.toString(), 0);
                }
            }
        }

        // attach unmatched queue automatically

        if (queue.length() > 0) {
            StringBuilder result_with_queue = new StringBuilder("");
            boolean multiple_translation = false;
            for (int i = 0,  limit = result.length(); i != limit; i++) {
                switch (charAt(result.toString(),i)) {
                    case '\\':
                        result_with_queue.append('\\');
                        i++;
                        break;

                    case '/':
                        result_with_queue.append(queue);
                        multiple_translation = true;
                        break;

                    default:
                        break;
                }
                result_with_queue.append(charAt(result.toString(),i));
            }
            result_with_queue.append(queue);

            if (with_delim) {
                result_with_queue.append('$');
            }
            return new Pair<String, Integer>(result_with_queue.toString(), queue.length());
        } else {
            if (with_delim) {
                result.append('$');
            }
            return new Pair<String, Integer>(result.toString(), 0);
        }
    }

    public String biltransWithoutQueue(String input_word, boolean with_delim) {
        State current_state = new State().copy(initial_state);
        StringBuilder result = new StringBuilder("");
        int start_point = 1;
        int end_point = input_word.length() - 2;
        boolean mark = false;
        
        if (!with_delim) {
            start_point = 0;
            end_point = input_word.length() - 1;
        }

        if (charAt(input_word,start_point) == '*') {
            return input_word;
        }

        if(charAt(input_word,start_point) == '=')  {
            start_point++;
            mark = true;
        }
        
        boolean firstupper = Character.isUpperCase(charAt(input_word,start_point));
        boolean uppercase = firstupper && Character.isUpperCase(charAt(input_word,start_point + 1));

        for (int i = start_point; i <= end_point; i++) {
            int val;
            String symbol = "";

            if (charAt(input_word,i) == '\\') {
                i++;
                val = (int) (charAt(input_word,i));
            } else if (charAt(input_word,i) == '<') {
                symbol = "<";
                for (int j = i + 1; j <= end_point; j++) {
                    symbol += charAt(input_word,j);
                    if (charAt(input_word,j) == '>') {
                        i = j;
                        break;
                    }
                }
                val = alphabet.cast(symbol);
            } else {
                val = (int) (charAt(input_word,i));
            }
            if (current_state.size() != 0) {
                if (!alphabet.isTag(val) && Character.isUpperCase(val) && !caseSensitive) {
                    current_state.step(val, Character.toLowerCase(val));
                } else {
                    current_state.step(val);
                }
            }
            if (current_state.isFinal(all_finals)) {
                result = new StringBuilder(current_state.filterFinals(all_finals, alphabet,
                        escaped_chars,
                        uppercase, firstupper, 0));
                if (with_delim) {
                    if (mark) {
                        result = new StringBuilder("^=" + result.substring(1));
                    } else {
                        result.setCharAt(0, '^');
                    }
                } else {
                    if (mark) {
                        result = new StringBuilder("=" + result.substring(1));
                    } else {
                        result = new StringBuilder(result.substring(1));
                    }
                }
            }

            if (current_state.size() == 0) {
                if (symbol.equals("")) {
                    // word is not present
                    if (with_delim) {
                        result = new StringBuilder("^@" + input_word.substring(1));
                    } else {
                        result = new StringBuilder("@" + input_word);
                    }
                    return result.toString();
                }
            }
        }

        if (with_delim) {
            result.append('$');
        }
        return result.toString();
    }

    boolean valid() {
        if (initial_state.isFinal(all_finals)) {
            System.err.println("Error: Invalid dictionary (hint: the left side of an entry is empty)");
            return false;
        } else {
            State s = new State().copy(initial_state);
            s.step(' ');
            if (s.size() != 0) {
                System.err.println("Error: Invalid dictionary (hint: entry beginning with whitespace)");
                return false;
            }
        }
        return true;
    }

    char readSAO(DataInputStream input) throws IOException {
        if (!input_buffer.isEmpty()) {
            return input_buffer.next();
        }
        
        if (input.available() == 0) {
            return (char)0;
        }
        Character val = read(input);
        //System.out.println("read "+val);
        

        if (escaped_chars.contains(val)) {
            if (val == '<') {
                String str = readFullBlock(input, '<', '>');
                if (str.substring(0, 9).equals("<![CDATA[")) {
                    while (!"]]>".equals(str.substring(str.length() - 3))) {
                        str += readFullBlock(input, '<', '>').substring(1);
                    }
                    blankqueue.addLast(str);
                    input_buffer.add((' '));
                    return (int) (' ');
                } else {
                    streamError();
                }
            } else if (val == '\\') {
                val = read(input);
        //System.out.println("read "+val);
                if (isEscaped(val)) {
                    input_buffer.add(val);
                    return (val);
                } else {
                    streamError();
                }
            } else {
                streamError();
            }
        }

        input_buffer.add(val);
        return (val);
    }

    void printSAOWord(String lf, Writer output) throws IOException {
        for (int i = 1,  limit = lf.length(); i != limit; i++) {
            if (charAt(lf,i) == '/') {
                break;
            }
            output.write(charAt(lf,i));
        }
    }

    void SAO(DataInputStream input, Writer output) throws IOException {
        boolean last_incond = false;
        boolean last_postblank = false;
        State current_state = new State().copy(initial_state);
        String lf = "";
        String sf = "";
        int last = 0;

        escaped_chars.clear();
        escaped_chars.add('\\');
        escaped_chars.add(('<'));
        escaped_chars.add(('>'));

        Character val;
        while ((val = readSAO(input)) != (char)0) {
            // test for final states
            if (current_state.isFinal(all_finals)) {
                if (current_state.isFinal(inconditional)) {
                    boolean firstupper = Character.isUpperCase(charAt(sf,0));
                    boolean uppercase = firstupper && Character.isUpperCase(charAt(sf,sf.length() - 1));

                    lf = current_state.filterFinalsSAO(all_finals, alphabet,
                            escaped_chars,
                            uppercase, firstupper, 0);
                                        
                    last_incond = true;
                    last = input_buffer.getPos();
                } else if (current_state.isFinal(postblank)) {
                    boolean firstupper = Character.isUpperCase(charAt(sf,0));
                    boolean uppercase = firstupper && Character.isUpperCase(charAt(sf,sf.length() - 1));

                    lf = current_state.filterFinalsSAO(all_finals, alphabet,
                            escaped_chars,
                            uppercase, firstupper, 0);
                    
                    last_postblank = true;
                    last = input_buffer.getPos();
                } else if (!isAlphabetic(val)) {
                    boolean firstupper = Character.isUpperCase(charAt(sf,0));
                    boolean uppercase = firstupper && Character.isUpperCase(charAt(sf,sf.length() - 1));

                    lf = current_state.filterFinalsSAO(all_finals, alphabet,
                            escaped_chars,
                            uppercase, firstupper, 0);
                    
                    last_postblank = false;
                    last_incond = false;
                    last = input_buffer.getPos();
                }
            } else if (sf.equals("") && Character.isSpaceChar(val)) {
                lf = "/*" + sf;
                last_postblank = false;
                last_incond = false;
                last = input_buffer.getPos();
            }

            if (!Character.isUpperCase(val) || caseSensitive) {
                current_state.step(val);
            } else {
                current_state.step(val, Character.toLowerCase(val));
            }

            if (current_state.size() != 0) {
                sf=alphabet.getSymbol(sf, val);
            } else {
                if (!isAlphabetic(val) && sf.equals("")) {
                    if (Character.isSpaceChar(val)) {
                        printSpace(val, output);
                    } else {
                        if (isEscaped(val)) {
                            output.write('\\');
                        }
                        output.write(val);
                    }
                } else if (last_incond) {
                    printSAOWord(lf, output);
                    input_buffer.setPos(last);
                    input_buffer.back(1);
                } else if (last_postblank) {
                    printSAOWord(lf, output);
                    output.write(' ');
                    input_buffer.setPos(last);
                    input_buffer.back(1);
                } else if (isAlphabetic(val) &&
                        ((sf.length() - input_buffer.diffPrevPos(last)) > lastBlank(sf) ||
                        lf.equals(""))) {
                    do {
                        sf=alphabet.getSymbol(sf, val);
                    } while ((val = readSAO(input)) != (char)0 && isAlphabetic(val));

                    int limit = firstNotAlpha(sf);
                    int size = sf.length();
                    limit = (limit == Integer.MAX_VALUE ? size : limit);
                    input_buffer.back(1 + (size - limit));
                    output.write("<d>");
                    output.write(sf);
                    output.write("</d>");
                } else if (lf.equals("")) {
                    int limit = firstNotAlpha(sf);
                    int size = sf.length();
                    limit = (limit == Integer.MAX_VALUE ? size : limit);
                    input_buffer.back(1 + (size - limit));
                    output.write("<d>" + sf + "</d>");
                } else {
                    printSAOWord(lf, output);
                    input_buffer.setPos(last);
                    input_buffer.back(1);
                }

                current_state.copy(initial_state);
                lf = "";
                sf = "";
                last_incond = false;
                last_postblank = false;
            }
        }

        // print remaining blanks
        flushBlanks(output);
    }

    String removeTags(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (charAt(str,i) == '<' && i >= 1 && charAt(str,i - 1) != '\\') {
                return str.substring(0, i);
            }
        }

        return str;
    }

    void setCaseSensitiveMode(boolean value) {
        caseSensitive = value;
    }

    void setNullFlush(boolean value) {
        nullFlush = value;
    }

    boolean getNullFlush() {
        return nullFlush;
    }

    int firstNotAlpha(String sf) {
        for (int i = 0,  limit = sf.length(); i < limit; i++) {
            if (!isAlphabetic(charAt(sf,i))) {
                return i;
            }
        }
        //throw new RuntimeException("Should not have gotten here");
        return Integer.MAX_VALUE;
    }
    

    private char read(DataInputStream input) throws IOException {
        int read = input.read();
        if ((128 & read) == 0) {
            return (char) read;
        } else if ((224 & read) == 192) {
            return (char) (((read & 31) << 6) + (input.read() & 63));
        } else {
            return (char) (((read & 15) << 12) + ((input.read() & 63) << 6) + (input.read() & 63));
        }
    }

    private boolean iswdigit(Character val) {
        int i = (int) val;
        return ((i>=48&&i<=57)||i==178||i==179||i==185);
    }

    private boolean iswpunct(Character val) {
        int i = (int) val;
        return ((i >= 161 && i <= 191) ||
            (i >= 33 && i <= 47) ||
            (i >= 58 && i <= 64) ||
            (i >= 91 && i <= 96) ||
            (i >= 123 && i <= 126));
    }
}
