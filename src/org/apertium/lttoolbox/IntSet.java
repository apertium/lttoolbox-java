/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.lttoolbox;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author Jacob Nordfalk
 */
public class IntSet { //implements Iterable<Integer> { //extends TreeSet<Integer> {
  private BitSet bs = new BitSet(4096);
  private int size = 0;

  public IntSet() {
  }

  public void clear() {
    bs.clear();
  }

  public int size() {
    return size;
  }

  public void add(int state) {
    bs.set(state);
    size++;
  }

  public void remove(int state) {
    bs.clear(state);
    size--;
  }

  public boolean contains(int state) {
    return bs.get(state);
  }

  public int first() {
    return bs.nextSetBit(0);
  }

  public int next(int i) {
    return bs.nextSetBit(i);
  }

}
