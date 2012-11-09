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


import java.io.IOException;
import java.nio.ByteBuffer;
import org.apertium.lttoolbox.Compression;

/**
 * The container object that contains all states (and transitions betweem them)
 * @author Jacob Nordfalk
 */
public class MatchExe {

  /**
   * Initial state
   */
  private int initial_id;

  final ByteBuffer data;
  final int[] state_to_data_index;
  final short[] final_state_to_symbol;
  final int number_of_states;
  final int decalage;


  public MatchExe(ByteBuffer in, int decalage) throws IOException {
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


    // set up finals
   //  values for en_ca_t1x: {14=1, 41=2, 48=2, 55=2, 62=2, 69=2, 76=2, 83=2, 90=2, 97=2, 103=90, 106=90, 109=90, ...
   // ... 420739=211, 420741=213, 420743=215, 420745=215, 420747=215, 420749=216}
   // noOfFinals == number of rules


    _readAndAddFinals(in);
  }

  public int[] loadNode(int current_state) {
    data.position( state_to_data_index[current_state] );
    int number_of_local_transitions=Compression.multibyte_read(data);
    if (number_of_local_transitions>0) {
      int[] mynode = new int[number_of_local_transitions*2];
      int symbol=0;
      int n=0;
      for (int j=number_of_local_transitions; j>0; j--) {
        symbol+=Compression.multibyte_read(data)-decalage;
        int target_state=(current_state+Compression.multibyte_read(data))%number_of_states;
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
    if (number_of_local_transitions>0) {
      for (int j=number_of_local_transitions; j>0; j--) {
        Compression.multibyte_skip(in);
        Compression.multibyte_skip(in);
      }
    }
  }

  private void _readAndAddFinals(ByteBuffer in) throws IllegalStateException, IOException {

    int number_of_finals=Compression.multibyte_read(in);


    for (int i=0; i!=number_of_finals; i++) {
      int key=Compression.multibyte_read(in);
      int value=Compression.multibyte_read(in); // value == rule number (method nomber)
      final_state_to_symbol[key]=(short) value;
      //System.err.println("node_list["+key+"] = " + Arrays.toString(node_list[key]));
      //System.err.println("node_list["+key+"] = " + Arrays.toString(node_list[key]));
    }
  }


  public int getInitial() {
    return initial_id;
  }


}