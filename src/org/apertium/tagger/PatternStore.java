package org.apertium.tagger;

//import org.apache.commons.collections15.multimap.MultiHashMap;

import java.util.ArrayList;
import java.util.Collection;
//import java.util.List; //Unused, swapped to ArrayList

/**
 * Created by Nic Cottrell, Jan 27, 2009 5:02:30 PM
 */

//TODO This class needs implementation.
public class PatternStore {//extends MultiHashMap<Integer, ArrayList<Integer>> {

  PatternStore() {
	  //placeholder
  }
  
  PatternStore(PatternStore o) {
	  copy(o);
  }
  
  void copy(PatternStore o) {
	  //does nothing currently.
  }

  Collection<ArrayList<Integer>> get(int otherid) {
    throw new UnsupportedOperationException("Not yet implemented");
  }
  void put(int sequence_id, ArrayList<Integer> it) {
    throw new UnsupportedOperationException("Not yet implemented");
  }

}
