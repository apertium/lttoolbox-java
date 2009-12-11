package org.apertium.lttoolbox;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by Nic Cottrell, Jan 27, 2009 5:00:21 PM
 */

public class PatternList {

  Alphabet alphabet;

  PatternStore patterns;

  boolean sequence;

  List<List<Integer>> sequence_data;

  Transducer transducer;

  Map<Integer, Integer> final_type;

  int sequence_id;

  /**
   * This symbol stands for any char
   */
  static String ANY_CHAR;

  /**
   * This symbol stands for any tag
   */
  static String ANY_TAG;

  /**
   * This symbol marks a word queue
   */
  static String QUEUE;

  /**
   * Constructor
   */
  PatternList() {
  }


  void
  beginSequence() {
    if (sequence) {
      throw new RuntimeException("Error: opening an unended sequence");

    }
    sequence = true;
    sequence_data.clear();
  }

  void endSequence() {
    if (!sequence) {
      throw new RuntimeException("Error: ending an unopened sequence");
    }
    sequence = false;

    for (List<Integer> it : sequence_data) {

      it.add(Alphabet.A.cast(QUEUE));
      patterns.put(sequence_id, it);
    }
  }

  void
  insertOutOfSequence(String lemma, String tags,
                      List<Integer> result) {
    if (lemma.equals("")) {
      result.add(Alphabet.A.cast(ANY_CHAR));
    } else {
      for (int i = 0, limit = lemma.length(); i < limit; i++) {
        if (lemma.charAt(i) == '*') {
          result.add(Alphabet.A.cast(ANY_CHAR));
        } else {
          result.add((int) lemma.charAt(i));
        }
      }
    }
    if (tags.equals("")) {
      result.add(Alphabet.A.cast(ANY_TAG));
    } else {
      for (int i = 0, limit = tagCount(tags); i < limit; i++) {
        String tag = "<" + tagAt(tags, i) + ">";

        if (tag.equals("<*>")) {
          result.add(Alphabet.A.cast(ANY_TAG));
        } else {
          alphabet.includeSymbol(tag);
          result.add(Alphabet.A.cast(tag));
        }
      }
    }
  }

  void
  insertIntoSequence(int id, String lemma,
                     String tags) {
    sequence_id = id;

    if (sequence_data.size() == 0) {
      List<Integer> new_vector = new Vector<Integer>();
      insertOutOfSequence(lemma, tags, new_vector);
      sequence_data.add(new_vector);
    } else {
      for (List<Integer> it : sequence_data) {
        it.add((int) '+');
        insertOutOfSequence(lemma, tags, it);
      }
    }
  }

  void insert(int id, String lemma, String tags) {
    if (!sequence) {
      List<Integer> local = new Vector<Integer>();
      insertOutOfSequence(lemma, tags, local);
      local.add(Alphabet.A.cast(QUEUE));
      patterns.put(id, local);
    } else {
      insertIntoSequence(id, lemma, tags);
    }
  }

  void insert(int id, int otherid) {
    if (!sequence) {
      throw new RuntimeException("Error: using labels outside of a sequence");

    }

    sequence_id = id;

    if (sequence_data.size() == 0) {
      final Collection<List<Integer>> p2 = patterns.get(otherid);
      for (List<Integer> pSecond : p2) {
        sequence_data.add(pSecond);
      }
    } else {
      List<List<Integer>> new_sequence_data = new Vector<List<Integer>>();

      for (List<Integer> it : sequence_data) {
        for (List<Integer> p : patterns.get(otherid)) {
          List<Integer> temp = new Vector<Integer>(it);
          temp.add((int) '+');
          temp.addAll(p);
          new_sequence_data.add(temp);
        }
      }

      sequence_data = new_sequence_data;
    }
  }

  int tagCount(String tags) {
    int count = 0;

    for (int i = 0, limit = tags.length(); i < limit; i++) {
      if (i == 0) {
        count++;
      } else if (tags.charAt(i) == '.') {
        count++;
      }
    }

    return count;
  }

  String tagAt(String tags, int index) {
    int start = 0;
    int end = 0;
    int count = 0;

    for (int i = 0, limit = tags.length(); i < limit; i++) {
      if (tags.charAt(i) == '.') {
        count++;
        if (end == 0) {
          start = 0;
        } else {
          start = end + 1;
        }
        end = i;
      }
      if (count == index + 1) {
        return tags.substring(start, end - start);
      }
    }

    if (index > count) {
      return "";
    }
    if (end != 0) {
      return tags.substring(end + 1);
    } else {
      return tags.substring(end);
    }
  }

  PatternStore getPatterns() {
    return patterns;
  }

  void buildTransducer() {

    for (int itFirst = 0; itFirst < sequence_data.size(); itFirst++) {
      List<Integer> itSecond = sequence_data.get(itFirst);

      int state = transducer.getInitial();
      int prevstate = -1;
      for (int i = 0, limit2 = itSecond.size(); i != limit2; i++) {
        int val = itSecond.get(i);
        if (Alphabet.A.cast(ANY_CHAR) == val || Alphabet.A.cast(ANY_TAG) == val) {
          state = transducer.insertSingleTransduction(val, state);
          if (prevstate != -1) {
            transducer.linkStates(prevstate, state, val);
            prevstate = -1;
          }
          transducer.linkStates(state, state, val);
        } else if (Alphabet.A.cast(QUEUE) == val) {
          if (prevstate != -1) {
            // ignore second (and next) possible consecutive queues
            continue;
          }

          // optional queue
          prevstate = state;
          state = transducer.insertSingleTransduction((int) ('_'), state);
          transducer.linkStates(prevstate, state, (int) (' '));
          transducer.linkStates(prevstate, state, (int) ('#'));
          transducer.linkStates(state, state, Alphabet.A.cast(ANY_CHAR));
        } else {
          state = transducer.insertSingleTransduction(val, state);
          if (prevstate != -1) {
            transducer.linkStates(prevstate, state, val);
            prevstate = -1;
          }
        }
      }
      if (prevstate != -1) {
        if (!transducer.isFinal(prevstate)) {
          transducer.setFinal(prevstate);
          final_type.put(prevstate, itFirst);
        }
        prevstate = -1;
      }
      if (!transducer.isFinal(state)) {
        transducer.setFinal(state);
        final_type.put(state, itFirst);
      }
    }
  }

  void write(Writer output) throws IOException {
    alphabet.write(output);
    String tagger_name = "tagger";

    output.write(1);
    output.write(tagger_name);
    transducer.write(output, alphabet.size());

    output.write(final_type.size());

    for (Map.Entry<Integer, Integer> it : final_type.entrySet()) {
      output.write(it.getKey());
      output.write(it.getValue());
    }
  }

  void read(FileInputStream input) throws IOException {
    sequence = false;
    final_type.clear();

    alphabet.read(input);
    if (input.read() == 1) {
      int mystr = input.read();
      Transducer.read(input, alphabet.size());

      int finalsize = input.read();
      for (; finalsize != 0; finalsize--) {
        int key = input.read();
        final_type.put(key, input.read());
      }
    }
  }

  MatchExe newMatchExe() {
    return new MatchExe(transducer, final_type);
  }

  Alphabet getAlphabet() {
    return alphabet;
  }

}
