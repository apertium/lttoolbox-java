package org.apertium.transfer;
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


import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.apertium.lttoolbox.Compression;

/**
 * The container object that contains all states (and transitions betweem them)
 * @author Jacob Nordfalk
 */
public class MatchExe {

  /**
   * Initial state
   */
  private final int initial_id;

  final ByteBuffer data;
  final int[] state_to_data_index;
  final short[] final_state_to_symbol;
  final int number_of_states;
  final int decalage;

  private static final int MAX_OUTPUT_SYMBOLS_POWS_OF_2 = 11;
  private static final int MAX_OUTPUT_SYMBOLS_SHIFT = 32 - MAX_OUTPUT_SYMBOLS_POWS_OF_2; // 32 bits in an int
  private static final int MAX_OUTPUT_SYMBOLS = (1 << MAX_OUTPUT_SYMBOLS_POWS_OF_2) - 1;  // 2047
  private static final int MAX_STATE_INDEX_NO = (1 << MAX_OUTPUT_SYMBOLS_SHIFT) - 1;

  public MatchExe(ByteBuffer in, int decalage, File cachedFile) throws IOException {
    data = in;
    this.decalage = decalage;
    //reading the initial state - set up initial node
    initial_id = Compression.multibyte_read(in);

    //reading the list of final states - not used
    int number_of_finals = Compression.multibyte_read(in);

    /* Discard the bytes
      * for the list of final states, since this implementation doesn't actually
      * use that list. But we need to advance the read pointer past the finals
      * list.
      */
    Compression.multibyte_skip(in, number_of_finals);


    //reading the transitions
    number_of_states = Compression.multibyte_read(in);

    // memory allocation
    state_to_data_index = new int[number_of_states];
    final_state_to_symbol = new short[number_of_states];

    int current_state=0;
    for (int i=number_of_states; i>0; i--) {
      state_to_data_index[current_state] = in.position();
      skipNode(in);
      current_state++;
    }

    if (state_to_data_index[current_state-1]>MAX_STATE_INDEX_NO) throw new IllegalStateException("Cannot hold state index value. File too large: "+in.position());


    // set up finals
   //  values for en_ca_t1x: {14=1, 41=2, 48=2, 55=2, 62=2, 69=2, 76=2, 83=2, 90=2, 97=2, 103=90, 106=90, 109=90, ...
   // ... 420739=211, 420741=213, 420743=215, 420745=215, 420747=215, 420749=216}
   // noOfFinals == number of rules


    int number_of_finals2=Compression.multibyte_read(in);  // == number_of_finals


    for (int i=0; i!=number_of_finals; i++) {
      int key=Compression.multibyte_read(in);
      int value=Compression.multibyte_read(in); // value == rule number (method nomber)
      if (value>MAX_OUTPUT_SYMBOLS) throw new IllegalStateException("Output symbol index value too large: "+value);

//      state_to_data_index[key] |=  value>> (32-MAX_OUTPUT_SYMBOLS_POWS_OF_2);

      final_state_to_symbol[key]=(short) value;
//      state_to_data_index[key] = -state_to_data_index[key]; // negative sign signals a final state
//      System.err.println("node_list["+key+"] = " + value);
      //System.err.println("node_list["+key+"] = " + Arrays.toString(node_list[key]));
    }
  }


  public int[] loadNode(int node_id) {
    int index = state_to_data_index[node_id];

    data.position( index );
    int number_of_local_transitions=Compression.multibyte_read(data);
    if (number_of_local_transitions>0) {
      int[] mynode = new int[number_of_local_transitions*2];
      int symbol=0;
      int n=0;
      for (int j=number_of_local_transitions; j>0; j--) {
        symbol+=Compression.multibyte_read(data)-decalage;
        int target_state=(node_id+Compression.multibyte_read(data))%number_of_states;
        mynode[n++]=symbol;
        mynode[n++]=target_state;
        //              System.err.println(current_state+ "( "+symbol+" "+(char)symbol+")  -> "+target_state);
      }
      return mynode;
    } else {
      // then it must be a final state - we handle that elsewhere
      return null;
    }
  }


  private void skipNode(ByteBuffer in) {
    int number_of_local_transitions=Compression.multibyte_read(in);
    for (int j=number_of_local_transitions; j>0; j--) {
      Compression.multibyte_skip(in);
      Compression.multibyte_skip(in);
    }
  }


  public int getInitial() {
    return initial_id;
  }


}