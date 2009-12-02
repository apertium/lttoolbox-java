package org.apertium.lttoolbox.process;

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

import java.io.StringWriter;
import org.apertium.lttoolbox.*;
import java.io.InputStream;
import java.io.Reader;
import java.io.IOException;
import java.io.Writer;
import java.text.Collator;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;

public class FSTProcessor {
    private boolean isLastBlankTM;

    private boolean do_decomposition = false;

  public void setCompoundAnalysis(boolean b) {
    do_decomposition = true;
    
    System.err.println("compoundSymbol = " + compoundSymbol);
  }

  int compoundSymbol = 0;
  
  public void setCompoundingSymbol(String symbol) {
    compoundSymbol = alphabet.cast("<"+symbol+">");
    System.err.println("compoundSymbol = " + compoundSymbol);
    // remove this symbol from output
    alphabet.setSymbol(compoundSymbol, "");

  }

    
    public enum GenerationMode {

        gm_clean, // clear all
        gm_unknown, // display unknown words, clear transfer and generation tags
        gm_all,         // display all
        gm_tagged   // tagged generation
    }
    //private Collator myCollator = Collator.getInstance();
    /**
     * Transducers in FSTP
     */
    private Map<String, TransExe> transducers = new TreeMap<String, TransExe>();
    /**
     * Current state of lexical analysis
     */
    //State current_state;
    /**
     * Initial state of every token
     */
    State initial_state = new State();
    /**
     * Set of final states of incoditional sections in the dictionaries
     */
    private Set<Node> inconditional = new HashSet<Node>();
    /**
     * Set of final states of standard sections in the dictionaries
     */
    private Set<Node> standard = new HashSet<Node>();
    /**
     * Set of final states of postblank sections in the dictionaries
     */
    private Set<Node> postblank = new HashSet<Node>();
    /**
     * Set of final states of preblank sections in the dictionaries
     */
    private Set<Node> preblank = new HashSet<Node>();

    private Set<Node> compoundL = new HashSet<Node>();
    private Set<Node> compoundR = new HashSet<Node>();
    /**
     * Merge of 'inconditional', 'standard', 'postblank' and 'preblank' sets
     */
    private Set<Node> all_finals;
    /**
     * Queue of blanks, used in reading methods
     */
    private ArrayDeque<String> blankqueue = new ArrayDeque<String>();

    /**
     * Set of characters being considered alphabetics
     */
    private SetOfCharacters alphabetic_chars;
    /**
     * Set of characters to escape with a backslash
     */
    private SetOfCharacters escaped_chars = new SetOfCharacters();
    /**
     * Alphabet
     */
    private Alphabet alphabet = new Alphabet();
    /**
     * Input buffer
     */
    private Buffer input_buffer= new Buffer(2048);
    /**
     * true if the position of input stream is out of a word
     */
    private boolean outOfWord;
    /**
     * if true, makes always difference between uppercase and lowercase
     * characters
     */
    private boolean caseSensitive = false;
    /**
     * if true, flush the output when the null character is found
     */
    private boolean nullFlush = false;
    private ArrayList<String> tmNumbers;

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
        //not really elegant, but the Pool attribute is static, 
        //thus shared by all the instances of the class
        //and it needs to be initialized somewhere
        // JACOB initial_state.poolInit();
    }

    private void streamError() {
        throw new RuntimeException("Error: Malformed input stream.");
    }

    private char readEscaped(Reader input) throws IOException {
        if (!input.ready()) {
            streamError();
        }

        char val = read(input);

        if (!input.ready() || (!escaped_chars.contains(val))) {
            streamError();
        }

        return val;
    }

    private String readFullBlock(Reader input, char delim1, char delim2) throws IOException {
        StringBuilder result = new StringBuilder();
        result.append(delim1);

        char c = delim1;

        while (input.ready() && c != delim2) {
            c=read(input);
            result.append(c);
            if (c == '\\') {
                result.append(readEscaped(input));
            }
        }

        if (c != delim2) {
            streamError();
        }

        return result.toString();
    }


    private char readAnalysis(Reader input) throws IOException {
        if (!input_buffer.isEmpty()) {
            return input_buffer.next();
        }
        if (!input.ready()) {
            return (char) 0;
        }
        char val = read(input);
        //if (val == -1) return (char) 0; // Jacob

        char altval = (char) 0;

        if (escaped_chars.contains(val)) {
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
        return val;
    }



    private char readTMAnalysis(Reader input) throws IOException {
        isLastBlankTM = false;
        if (!input_buffer.isEmpty()) {
            return input_buffer.next();
        }
        if (!input.ready()) {
            return (char) 0;
        }
        char val = read(input);
        char altval = (char) 0;

        if (escaped_chars.contains(val)||iswdigit(val)) {
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
                    tmNumbers.add(s);
                    return (char)alphabet.cast(s);
                default:
                    streamError();
            }
        }

        input_buffer.add(val);
        return val;
    }

    private char readPostgeneration(Reader input) throws IOException {
        if (!input_buffer.isEmpty()) {
            return input_buffer.next();
        }

        if (!input.ready()) {
            return (char) 0;
        }
        char val = read(input);
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

    private void skipUntil(Reader input, Writer output, char character) throws IOException {
        while (true) {
            if (!input.ready()) {
                return;
            }
            char val = read(input);

            if (val == '\\') {
                if (!input.ready()) {
                    return;
                }
                val = read(input);

                output.write('\\');
                output.write(val);
            } else if (val == character) {
                return;
            } else {
                output.write(val);
            }
        }
    }

    private int readGeneration(Reader input, Writer output) throws IOException {
       
        if (!input.ready()) {
            return 0x7fffffff;
        }
        char val = read(input);
        

        if (outOfWord) {
            if (val == '^') {
                if (!input.ready()) {
                    return 0x7fffffff;
                }
                val = read(input);
                
            } else if (val == '\\') {
                output.write(val);
                if (!input.ready()) {
                    return 0x7fffffff;
                }
                val = read(input);

                output.write(val);
                skipUntil(input, output, '^');
                 if (!input.ready()) {
                    return 0x7fffffff;
                }
                val = read(input);
               
            } else {
                output.write(val);
                skipUntil(input, output, '^');
                if (!input.ready()) {
                    return 0x7fffffff;
                }
                val = read(input);
                
            }
            outOfWord = false;
        }

        if (val == '\\') {
            val = read(input);
            return (int) (val);
        } else if (val == '$') {
            outOfWord = true;
            return (int) ('$');
        } else if (val == '<') {
            String cad = "";
            cad += val;
            
            
            if (!input.ready()) {
                    streamError();
                }
            val = read(input);
            while (val != '>') {
               cad += val;
                if (!input.ready()) {
                    streamError();
                }
                val = read(input);
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

    private void flushBlanks(Writer output) throws IOException {
        for (int i = blankqueue.size(); i > 0; i--) {
            output.write(blankqueue.getFirst());
            blankqueue.removeFirst();
        }
    }

    private void calcInitial() {
        Node root = new Node();
        root.initTransitions(transducers.size());
        for (String first : transducers.keySet()) {
            root.addTransition(0, 0, transducers.get(first).getInitial());
        }
        //System.out.println("plp");
        initial_state.init(root);
        //System.out.println("exiting calcInitial");
    }

    private boolean endsWith(String str, String suffix) {
      return str.endsWith(suffix);
      /*
        if (str.length() < suffix.length()) {
            return false;
        } else {
            return str.substring(str.length() - suffix.length()).equals(suffix);
        }*/
    }

    private void classifyFinals() {
        for (String name : transducers.keySet()) {
            final TransExe transducer = transducers.get(name);
            if (endsWith(name, "@inconditional")) {
                inconditional.addAll(transducer.getFinals());
            } else if (endsWith(name, "@standard")) {
                standard.addAll(transducer.getFinals());
            } else if (endsWith(name, "@postblank")) {
                postblank.addAll(transducer.getFinals());
            } else if (endsWith(name, "@preblank")) {
                preblank.addAll(transducer.getFinals());
            } else if (endsWith(name, "@compound-L")) {
                compoundL.addAll(transducer.getFinals());
            } else if (endsWith(name, "@compound-R")) {
                compoundR.addAll(transducer.getFinals());
            } else {
                throw new RuntimeException("Error: Unsupported transducer type for '" + name + "'.");
            }
        }
    }

    private void writeEscaped(String str, Writer output) throws IOException {
      //int len = str.length();
      //System.err.println("writeEscaped( str.length() = " + str.length());
        for (int i = 0,  limit = str.length(); i < limit; i++) {
          char ch = str.charAt(i);
            if (escaped_chars.contains(ch)) {
                output.write('\\');
            }
            output.write(ch);
        }
    }

    private void printWord(String surfaceForm, String lexicalForm, Writer output) throws IOException {
        output.write('^');
        writeEscaped(surfaceForm, output);
        output.write(lexicalForm);
        output.write('$');
    }

    private void printUnknownWord(String surfaceForm, Writer output) throws IOException {
        output.write('^');
        writeEscaped(surfaceForm, output);
        output.write('/');
        output.write('*');
        writeEscaped(surfaceForm, output);
        output.write('$');
    }

    private int lastBlank(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (!alphabetic_chars.contains(str.charAt(i))) {
                return (i);
            }
        }
        return 0;
    }

    void printSpace(char val, Writer output) throws IOException {
        if (blankqueue.size() > 0) {
            flushBlanks(output);
        } else {
            output.write(val);
        }
    }

    private boolean isEscaped(char c) {
        return escaped_chars.contains(c);
    }

    private boolean isAlphabetic(char c) {
        return alphabetic_chars.contains(c);
    }

    public void load( InputStream input) throws IOException {
        // letters
   
        int len = Compression.multibyte_read(input);
        alphabetic_chars = new SetOfCharacters();

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

            TransExe tx = transducers.get(name);
            if (tx==null) {
                tx = new TransExe();
                transducers.put(name,tx);
            } else {
                System.err.println(this.getClass()+".load() Why has transducer already name "+ name);
            }

            //System.out.println("reading : "+name);
            tx.read(input, alphabet);
            len--;
            //System.out.println(len);
        }

        //if (DEBUG)  System.err.println("  transducers = " + transducers.toString());
        
    }

    public void initAnalysis() {
        calcInitial();
        classifyFinals();
        all_finals = standard;
        all_finals.addAll(inconditional);
        all_finals.addAll(postblank);
        all_finals.addAll(preblank);
    }

  public void initDecomposition() {
    initAnalysis();
    for (String first : transducers.keySet()) {
        final TransExe second = transducers.get(first);

        System.err.println("first = " + first);

        if (endsWith(first, "@standard")) {
          System.err.println("Initial = " + second.getInitial());
          {
          Node n = second.getInitial();
            for (Integer i: n.transitions.keySet()) {
              String symbol = alphabet.getSymbol(i);

              System.err.println("symbol = " + symbol);
            }
          }

          System.err.println("Finals = " + second.getFinals());
          for (Node n : second.getFinals()) {
            System.err.println("n = " + n);
            for (Integer i: n.transitions.keySet()) {
              String symbol = alphabet.getSymbol(i);
              System.err.println(i + "symbol = " + symbol);
            }
          }
        }
    }
  }


    public void initTMAnalysis() {
        tmNumbers = new ArrayList<String>();
        all_finals = new HashSet<Node>();
        calcInitial();
        for (TransExe t : transducers.values()) {
            all_finals.addAll(t.getFinals());
        }
    }

    public void initGeneration() {
        calcInitial();
        all_finals = new HashSet<Node>();
        for (String first : transducers.keySet()) {            
            all_finals.addAll(transducers.get(first).getFinals());
        }
    }

    public void initPostgeneration() {
        initGeneration();
    }

    public void initBiltrans() {
        initGeneration();
    }

    private final static boolean DEBUG = true;

    /*
    private final char charAt(String s, int index) {
        return s.charAt(index);
    }
*/
    
    public void analysis(Reader input, Writer output) throws IOException {
        if (getNullFlush()) {
            analysis_wrapper_null_flush(input, output);
        }

        boolean last_incond = false;
        boolean last_postblank = false;
        boolean last_preblank = false;
        State current_state = initial_state.copy();
        String lf = ""; // lexical form
        String sf = ""; // surface form
        int last = 0;

        char val;
        while ((val = readAnalysis(input)) != (char)0) {
            if (current_state.isFinal(all_finals)) {
                if (current_state.isFinal(inconditional)) {
                    boolean firstupper = Character.isUpperCase(sf.charAt(0));
                    boolean uppercase = firstupper && Character.isUpperCase(sf.charAt(sf.length() - 1));
                    lf = current_state.filterFinals(all_finals, alphabet, escaped_chars, uppercase, firstupper);
                    last = input_buffer.getPos();
                    last_incond = true;
                } else if (current_state.isFinal(postblank)) {
                    boolean firstupper = Character.isUpperCase(sf.charAt(0));
                    boolean uppercase = firstupper && Character.isUpperCase(sf.charAt(sf.length() - 1));
                    lf = current_state.filterFinals(all_finals, alphabet, escaped_chars, uppercase, firstupper);
                    last = input_buffer.getPos();
                    last_postblank = true;
                } else if (current_state.isFinal(preblank)) {
                    boolean firstupper = Character.isUpperCase(sf.charAt(0));
                    boolean uppercase = firstupper && Character.isUpperCase(sf.charAt(sf.length() - 1));
                    lf = current_state.filterFinals(all_finals, alphabet, escaped_chars, uppercase, firstupper);
                    last = input_buffer.getPos();
                    last_preblank = true;
                } else if (!isAlphabetic(val)) {
                    boolean firstupper = Character.isUpperCase(sf.charAt(0));
                    boolean uppercase = firstupper && Character.isUpperCase(sf.charAt(sf.length() - 1));
                    lf = current_state.filterFinals(all_finals, alphabet, escaped_chars, uppercase, firstupper);
                    last = input_buffer.getPos();
                    last_postblank = last_preblank = last_incond = false;
                } 
            } else if (sf.equals("") && Character.isSpaceChar(val)) {
                lf = "/*";
                lf+=sf;
                last_postblank = last_preblank = last_incond = false;
                last = input_buffer.getPos();
            }

            current_state.step_case(val, caseSensitive);

            if (current_state.size() != 0) {
                sf=sf+alphabet.getSymbol(val);

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
                    printWord(sf.substring(0, sf.length() - input_buffer.diffPrevPos(last)), lf, output);
                    output.write(' ');
                    input_buffer.setPos(last);
                    input_buffer.back(1);
                } else if (last_preblank) {
                    output.write(' ');
                    printWord(sf.substring(0, sf.length() - input_buffer.diffPrevPos(last)), lf, output);
                    input_buffer.setPos(last);
                    input_buffer.back(1);
                } else if (last_incond) {
                    printWord(sf.substring(0, sf.length() - input_buffer.diffPrevPos(last)), lf, output);
                    input_buffer.setPos(last);
                    input_buffer.back(1);
                } else if (isAlphabetic(val) && ((sf.length() - input_buffer.diffPrevPos(last)) > lastBlank(sf) || lf.equals(""))) {
                    do {
                        sf=sf+alphabet.getSymbol(val);
                    } while (((val = readAnalysis(input)) != (char)0 )&& isAlphabetic(val));

                    int limit = firstNotAlpha(sf);                    
                    int size = sf.length();
                    limit = (limit == Integer.MAX_VALUE ? size : limit);
                    if (limit == 0) {
                        input_buffer.back(sf.length());
                        output.write(sf.charAt(0));
                    } else {
                        input_buffer.back(1 + (size - limit));
                        String unknownWord = sf.substring(0, limit);
                        if (do_decomposition) {
                          String compound = compoundAnalysis(unknownWord);
                          if (compound!=null) {
                            printWord(unknownWord, compound, output);
                          } else {
                            printUnknownWord(unknownWord, output);
                          }
                        } else {
                          printUnknownWord(unknownWord, output);
                        }
                    }
                } else if (lf.equals("")) {
                    int limit = firstNotAlpha(sf);
                    int size = sf.length();
                    limit = (limit == Integer.MAX_VALUE ? size : limit);
                    if (limit == 0) {
                        input_buffer.back(sf.length());
                        output.write(sf.charAt(0));
                    } else {
                        input_buffer.back(1 + (size - limit));
                        //printUnknownWord(sf.substring(0, limit), output);
                        String unknownWord = sf.substring(0, limit);
                        if (do_decomposition) {
                          String compound = compoundAnalysis(unknownWord);
                          if (compound!=null) {
                            printWord(unknownWord, compound, output);
                          } else {
                            printUnknownWord(unknownWord, output);
                          }
                        } else {
                          printUnknownWord(unknownWord, output);
                        }
                    }
                } else {
                    printWord(sf.substring(0, sf.length() - input_buffer.diffPrevPos(last)), lf, output);
                    input_buffer.setPos(last);
                    input_buffer.back(1);
                }

                current_state.copy(initial_state);
                lf = sf = "";
                last_incond = last_postblank = last_preblank = false;
                Math.random();
            }
        }

        // print remaining blanks
        flushBlanks(output);
    }





    public String compoundAnalysis(String input_word) {
      // Francis' heuristic
      if (input_word.length()<9) return null;

        State current_state = initial_state.copy();
        //input_word += " ";

        // List compound elements. Each element can have multiple alternatives
        ArrayList<String[]> compoundElements = new ArrayList<String[]>();

        boolean firstupper = Character.isUpperCase(input_word.charAt(0));
        boolean uppercase = firstupper && Character.isUpperCase(input_word.charAt(1));

        for (int i = 0; i<=input_word.length(); i++) {
          boolean endOfWord=(i==input_word.length());

          State previous_state =new State().copy(current_state);

          if (!endOfWord) {
            char val=input_word.charAt(i);
              current_state.step_case(val, caseSensitive);
          }

          String result=previous_state.filterFinals(all_finals, alphabet, escaped_chars, uppercase, firstupper);
          if (DEBUG) System.err.println(i + " result = "+result);

          if (current_state.size()==0||endOfWord) {
            // longest match exceeded has come - or end of word

            if (previous_state.isFinal(all_finals)) {

              String[] alternatives=result.substring(1).split("/");
              // Add array of possible analyses
              compoundElements.add(alternatives);

              // start over
              if (!endOfWord) {
                current_state.copy(initial_state);
                // do again on current char
                i--;
              }
            } else {
              // word is not present
              return null;
            }
          }

            // Francis' heuristic
            if (compoundElements.size()>2) return null;
        }
        if (DEBUG) System.err.println("compoundElements = " + compoundElements);

        final int MAX_COMBINATIONS = 500;
        int combinations = 1;

        // Build list of combination tuples
        ArrayList<String> tuples=null;
        for (String[] arr : compoundElements) {
          // abort if too many alternatives
          combinations *= arr.length;
          if (combinations>MAX_COMBINATIONS) {
            System.err.println("Warning: compoundAnalysis' MAX_COMBINATIONS exceeded for " + input_word);
            return null;
          }

          if (tuples==null) {
            tuples = new ArrayList<String>();
            for (String part : arr) tuples.add(part);
          } else {
            ArrayList<String> tuples2 = new ArrayList<String>(tuples.size() * arr.length);

            if (DEBUG) System.err.println("tuples.size() * arr.length = " + tuples.size() * arr.length);
            for (String head : tuples) {
              for (String part : arr) tuples2.add(head+"+"+part);
            }
            tuples = tuples2;
          }
        }

        // build resulting string
        StringBuilder result = new StringBuilder();
        result.delete(0, result.length());
        for (String word : tuples) {
          result.append('/');
          result.append(word);
        }

        if (DEBUG) System.err.println("compoundAnalysis("+input_word);
        if (DEBUG) System.err.println(result);
        return result.toString();
    }




    public String compoundAnalysis2(String input_word) {


        State current_state = initial_state.copy();

        boolean firstupper = Character.isUpperCase(input_word.charAt(0));
        boolean uppercase = firstupper && Character.isUpperCase(input_word.charAt(1));

        for (int i = 0; i<input_word.length(); i++) {
            char val=input_word.charAt(i);
            current_state.step_case(val, caseSensitive);
            String result=current_state.filterFinals(all_finals, alphabet, escaped_chars, uppercase, firstupper);
            if (DEBUG) System.err.println(i + " result = "+result);
            current_state.restartFinals(all_finals, alphabet, initial_state, '+');
            if (current_state.size()==0) {
                // word is not present
                return null;
            }
        }
        return null;
    }





    private void analysis_wrapper_null_flush(Reader input, Writer output) throws IOException {
        setNullFlush(false);
        while (input.ready()) {
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

    private void generation_wrapper_null_flush(Reader input, Writer output, GenerationMode mode) throws IOException{
        setNullFlush(false);
        while (input.ready()) {
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

    private void postgeneration_wrapper_null_flush(Reader input, Writer output) throws IOException {
        setNullFlush(false);
        while (input.ready()) {
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

    private void transliteration_wrapper_null_flush(Reader input, Writer output) throws IOException {
        setNullFlush(false);
        while (input.ready()) {
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

    private void tm_analysis(Reader input, Writer output) throws IOException {

        State current_state = initial_state.copy();
        String lf = "";
        String sf = "";
        int last = 0;

        char val;
        while ((val = readAnalysis(input)) != (char) 0) {
            // test for final states
            if (current_state.isFinal(all_finals)) {
                if (iswpunct(val)) {
                    lf = current_state.filterFinalsTM(all_finals, alphabet, escaped_chars, blankqueue, tmNumbers).substring(1);
                    last = input_buffer.getPos();
                    tmNumbers.clear();
                }
            } else if (sf.equals("") && Character.isSpaceChar(val)) {
                lf += sf;
                last = input_buffer.getPos();
            }

            current_state.step_case(val, false);

            if (current_state.size() != 0) {
                if (val == -1) {
                    sf += tmNumbers.get(tmNumbers.size() - 1);
                } else if (isLastBlankTM && val == ' ') {
                    sf += blankqueue.getLast();
                } else {
                    sf = sf+alphabet.getSymbol(val);
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
                            sf += tmNumbers.get(tmNumbers.size() - 1);
                        } else if (isLastBlankTM && val == ' ') {
                            sf += (blankqueue.getLast());
                        } else {
                            sf += alphabet.getSymbol(val);
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


    public void generation(Reader input, Writer output, GenerationMode mode) throws IOException {
        if (getNullFlush()) {
            generation_wrapper_null_flush(input, output, mode);
        }

        State current_state = initial_state.copy();
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
                if (sf.charAt(0) == '*' || sf.charAt(0) == '%') {
                    if (mode != GenerationMode.gm_clean) {
                        writeEscaped(sf, output);
                    } else {
                        writeEscaped(sf.substring(1), output);
                    }
                } else if (sf.charAt(0) == '@') {
                    if (mode == GenerationMode.gm_all) {
                        writeEscaped(sf, output);
                    } else if (mode == GenerationMode.gm_clean) {
                        writeEscaped(removeTags(sf.substring(1)), output);
                    } else if (mode == GenerationMode.gm_unknown) {
                        writeEscaped(removeTags(sf), output);
                    }
                } else if (current_state.isFinal(all_finals)) {
                    boolean uppercase = sf.length() > 1 && Character.isUpperCase(sf.charAt(1));
                    boolean firstupper = Character.isUpperCase(sf.charAt(0));
                    if (mode == GenerationMode.gm_tagged) {
                      output.write('^');
                    }
                    output.write(current_state.filterFinals(all_finals, alphabet, 
                            escaped_chars, uppercase, firstupper).substring(1));
                    if (mode == GenerationMode.gm_tagged) {
                      output.write('/');
                      output.write(sf);
                      output.write('$');
                    }

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
            } else if (sf.length() > 0 && (sf.charAt(0) == '*' || sf.charAt(0) == '%')) {
                sf+=alphabet.getSymbol(val);
            } else {
                sf+=alphabet.getSymbol(val);
                current_state.step_case(val, caseSensitive);
            }
        }
    }

    public void postgeneration(Reader input, Writer output) throws IOException {
        if (getNullFlush()) {
            postgeneration_wrapper_null_flush(input, output);
        }

        boolean skip_mode = true;
        State current_state = initial_state.copy();
        StringBuilder lf = new StringBuilder();
        String sf = "";
        SetOfCharacters empty_escaped_chars = new SetOfCharacters();
        int last = 0;

        char val;
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
                    boolean firstupper = Character.isUpperCase(sf.charAt(1));
                    boolean uppercase = sf.length() > 1 && firstupper && Character.isUpperCase(sf.charAt(2));
                    lf = new StringBuilder(current_state.filterFinals(all_finals, alphabet, empty_escaped_chars, uppercase, firstupper));

                    // case of the beggining of the next word

                    String mybuf = "";
                    for (int i = sf.length() - 1; i >= 0; i--) {
                        if (!Character.isLetter(sf.charAt(i))) {
                            break;
                        } else {
                            mybuf = sf.charAt(i) + mybuf;
                        }
                    }

                    if (mybuf.length() > 0) {
                        boolean myfirstupper = Character.isUpperCase(mybuf.charAt(0));
                        boolean myuppercase = mybuf.length() > 1 && Character.isUpperCase(mybuf.charAt(1));

                        for (int i = lf.length() - 1; i >= 0; i--) {
                            if (!Character.isLetter(lf.charAt(i))) {
                                if (myfirstupper && i != lf.length() - 1) {
                                    lf.setCharAt(i + 1, Character.toUpperCase(lf.charAt(i + 1)));
                                } else {
                                    lf.setCharAt(i + 1, Character.toLowerCase(lf.charAt(i + 1)));
                                }
                                break;
                            } else {
                                if (myuppercase) {
                                    lf.setCharAt(i, Character.toUpperCase(lf.charAt(i)));
                                } else {
                                    lf.setCharAt(i, Character.toLowerCase(lf.charAt(i)));
                                }
                            }
                        }
                    }

                    last = input_buffer.getPos();
                }

                current_state.step_case(val, caseSensitive);

                if (current_state.size() != 0) {
                    sf+=alphabet.getSymbol(val);
                } else {
                    if (lf.length()==0) {
                        int mark = sf.length();
                        for (int i = 1,  limit = sf.length(); i < limit; i++) {
                            if (sf.charAt(i) == '~') {
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
                        val = lf.charAt(lf.length() - 2);
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

    public void transliteration(Reader input, Writer output) throws IOException {
        if (getNullFlush()) {
            transliteration_wrapper_null_flush(input, output);
        }

        State current_state = initial_state.copy();
        String lf = "";
        String sf = "";
        int last = 0;

        char val;
        while ((val = readPostgeneration(input)) != (char)0) {
            if (iswpunct(val) || Character.isSpaceChar(val)) {
                boolean firstupper = false;
                boolean uppercase = false;
                if (!sf.isEmpty()) {
                    firstupper = Character.isUpperCase(sf.charAt(1));
                    uppercase = sf.length() > 1 && firstupper && Character.isUpperCase(sf.charAt(2));
                }
                lf = current_state.filterFinals(all_finals, alphabet, escaped_chars, uppercase, firstupper);
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
                    boolean firstupper = Character.isUpperCase(sf.charAt(1));
                    boolean uppercase = sf.length() > 1 && firstupper && Character.isUpperCase(sf.charAt(2));
                    lf = current_state.filterFinals(all_finals, alphabet, escaped_chars, uppercase, firstupper);
                    last = input_buffer.getPos();
                }

                current_state.step(val);
                if (current_state.size() != 0) {
                    sf+=alphabet.getSymbol(val);
                } else {
                    if (lf.length() > 0) {
                        output.write(lf.substring(1));
                        input_buffer.setPos(last);
                        input_buffer.back(1);
                        val = lf.charAt(lf.length() - 1);
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
        State current_state = initial_state.copy();
        StringBuilder result = new StringBuilder("");
        int start_point = 1;
        int end_point = input_word.length() - 2;
        StringBuilder queue = new StringBuilder("");
        boolean mark=false;
        
        if (!with_delim) {
            start_point = 0;
            end_point = input_word.length() - 1;
        }

        if (input_word.charAt(start_point) == '*') {
            return input_word;
        }
        
        if(input_word.charAt(start_point) == '=') {
            start_point++;
            mark = true;
        }
        boolean firstupper = Character.isUpperCase(input_word.charAt(start_point));
        boolean uppercase = firstupper && Character.isUpperCase(input_word.charAt(start_point + 1));

        for (int i = start_point; i <= end_point; i++) {
            int val;
            String symbol = "";

            if (input_word.charAt(i) == '\\') {
                i++;
                val = (int) (input_word.charAt(i));
            } else if (input_word.charAt(i) == '<') {
                symbol = "<";
                for (int j = i + 1; j <= end_point; j++) {
                    symbol += input_word.charAt(j);
                    if (input_word.charAt(j) == '>') {
                        i = j;
                        break;
                    }
                }
                val = alphabet.cast(symbol);
            } else {
                val = (int) (input_word.charAt(i));
            }

            current_state.step_case(val, caseSensitive);

            if (current_state.isFinal(all_finals)) {
                result = new StringBuilder(current_state.filterFinals(all_finals, alphabet, escaped_chars, uppercase, firstupper));
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
                switch (result.charAt(i)) {
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
                result_with_queue.append(result.charAt(i));
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
        State current_state = initial_state.copy();
        StringBuilder result = new StringBuilder("");
        int start_point = 1;
        int end_point = input_word.length() - 2;
        StringBuilder queue = new StringBuilder("");
        boolean mark=false;
        
        if (!with_delim) {
            start_point = 0;
            end_point = input_word.length() - 1;
        }

        if (input_word.charAt(start_point) == '*') {
            return new Pair<String, Integer>(input_word, 0);
        }

        if (input_word.charAt(start_point) == '=') {
            start_point++;
            mark = true;
        }

        boolean firstupper = Character.isUpperCase(input_word.charAt(start_point));
        boolean uppercase = firstupper && Character.isUpperCase(input_word.charAt(start_point + 1));

        for (int i = start_point; i <= end_point; i++) {
            int val = 0;
            String symbol = "";

            if (input_word.charAt(i) == '\\') {
                i++;
                val = input_word.charAt(i);
            } else if (input_word.charAt(i) == '<') {
                symbol = "<";
                for (int j = i + 1; j <= end_point; j++) {
                    symbol += input_word.charAt(j);
                    if (input_word.charAt(j) == '>') {
                        i = j;
                        break;
                    }
                }
                val = alphabet.cast(symbol);
            } else {
                val = input_word.charAt(i);
            }

            current_state.step_case(val, caseSensitive);

            if (current_state.isFinal(all_finals)) {
                result = new StringBuilder(current_state.filterFinals(all_finals, alphabet, escaped_chars, uppercase, firstupper));
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
                switch (result.charAt(i)) {
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
                result_with_queue.append(result.charAt(i));
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
        State current_state = initial_state.copy();
        StringBuilder result = new StringBuilder("");
        int start_point = 1;
        int end_point = input_word.length() - 2;
        boolean mark = false;
        
        if (!with_delim) {
            start_point = 0;
            end_point = input_word.length() - 1;
        }

        if (input_word.charAt(start_point) == '*') {
            return input_word;
        }

        if(input_word.charAt(start_point) == '=')  {
            start_point++;
            mark = true;
        }
        
        boolean firstupper = Character.isUpperCase(input_word.charAt(start_point));
        boolean uppercase = firstupper && Character.isUpperCase(input_word.charAt(start_point + 1));

        for (int i = start_point; i <= end_point; i++) {
            int val;
            String symbol = "";

            if (input_word.charAt(i) == '\\') {
                i++;
                val = (int) (input_word.charAt(i));
            } else if (input_word.charAt(i) == '<') {
                symbol = "<";
                for (int j = i + 1; j <= end_point; j++) {
                    symbol += input_word.charAt(j);
                    if (input_word.charAt(j) == '>') {
                        i = j;
                        break;
                    }
                }
                val = alphabet.cast(symbol);
            } else {
                val = (int) (input_word.charAt(i));
            }

            current_state.step_case(val, caseSensitive);

            if (current_state.isFinal(all_finals)) {
                result = new StringBuilder(current_state.filterFinals(all_finals, alphabet, escaped_chars, uppercase, firstupper));
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

    public boolean valid() {
        if (initial_state.isFinal(all_finals)) {
            System.err.println("Error: Invalid dictionary (hint: the left side of an entry is empty)");
            return false;
        } else {
            State s = initial_state.copy();
            s.step(' ');
            if (s.size() != 0) {
                System.err.println("Error: Invalid dictionary (hint: entry beginning with whitespace)");
                return false;
            }
        }
        return true;
    }

    char readSAO(Reader input) throws IOException {
        if (!input_buffer.isEmpty()) {
            return input_buffer.next();
        }
        
        if (!input.ready()) {
            return (char)0;
        }
        char val = read(input);
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
            if (lf.charAt(i) == '/') {
                break;
            }
            output.write(lf.charAt(i));
        }
    }

    public void SAO(Reader input, Writer output) throws IOException {
        boolean last_incond = false;
        boolean last_postblank = false;
        State current_state = initial_state.copy();
        String lf = "";
        String sf = "";
        int last = 0;

        escaped_chars.clear();
        escaped_chars.add('\\');
        escaped_chars.add(('<'));
        escaped_chars.add(('>'));

        char val;
        while ((val = readSAO(input)) != (char)0) {
            // test for final states
            if (current_state.isFinal(all_finals)) {
                if (current_state.isFinal(inconditional)) {
                    boolean firstupper = Character.isUpperCase(sf.charAt(0));
                    boolean uppercase = firstupper && Character.isUpperCase(sf.charAt(sf.length() - 1));

                    lf = current_state.filterFinalsSAO(all_finals, alphabet, escaped_chars, uppercase, firstupper, 0);
                                        
                    last_incond = true;
                    last = input_buffer.getPos();
                } else if (current_state.isFinal(postblank)) {
                    boolean firstupper = Character.isUpperCase(sf.charAt(0));
                    boolean uppercase = firstupper && Character.isUpperCase(sf.charAt(sf.length() - 1));

                    lf = current_state.filterFinalsSAO(all_finals, alphabet, escaped_chars, uppercase, firstupper, 0);
                    
                    last_postblank = true;
                    last = input_buffer.getPos();
                } else if (!isAlphabetic(val)) {
                    boolean firstupper = Character.isUpperCase(sf.charAt(0));
                    boolean uppercase = firstupper && Character.isUpperCase(sf.charAt(sf.length() - 1));

                    lf = current_state.filterFinalsSAO(all_finals, alphabet, escaped_chars, uppercase, firstupper, 0);
                    
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

            current_state.step_case(val, caseSensitive);

            if (current_state.size() != 0) {
                sf+=alphabet.getSymbol(val);
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
                } else if (isAlphabetic(val) && ((sf.length() - input_buffer.diffPrevPos(last)) > lastBlank(sf) || lf.equals(""))) {
                    do {
                        sf+=alphabet.getSymbol(val);
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
            if (str.charAt(i) == '<' && i >= 1 && str.charAt(i - 1) != '\\') {
                return str.substring(0, i);
            }
        }

        return str;
    }

    public void setCaseSensitiveMode(boolean value) {
        caseSensitive = value;
    }

    public void setNullFlush(boolean value) {
        nullFlush = value;
    }

    public boolean getNullFlush() {
        return nullFlush;
    }

    int firstNotAlpha(String sf) {
        for (int i = 0,  limit = sf.length(); i < limit; i++) {
            if (!isAlphabetic(sf.charAt(i))) {
                return i;
            }
        }
        //throw new RuntimeException("Should not have gotten here");
        return Integer.MAX_VALUE;
    }
    

    private char read(Reader input) throws IOException {
      return (char) input.read();
        /*
        int read = input.read();
        if ((128 & read) == 0) {
            return (char) read;
        } else if ((224 & read) == 192) {
            return (char) (((read & 31) << 6) + (input.read() & 63));
        } else {
            return (char) (((read & 15) << 12) + ((input.read() & 63) << 6) + (input.read() & 63));
        }
         */
    }

    private boolean iswdigit(char val) {
        int i = (int) val;
        return ((i>=48&&i<=57)||i==178||i==179||i==185);
    }

    private boolean iswpunct(char val) {
        int i = (int) val;
        return ((i >= 161 && i <= 191) ||
            (i >= 33 && i <= 47) ||
            (i >= 58 && i <= 64) ||
            (i >= 91 && i <= 96) ||
            (i >= 123 && i <= 126));
    }
}
