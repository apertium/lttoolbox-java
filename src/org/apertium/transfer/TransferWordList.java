/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.transfer;

import java.util.HashSet;

/**
 *
 * @author Jacob Nordfalk
 */
public class TransferWordList {
  private HashSet elements;
  private HashSet elementsLowercase;

  public TransferWordList(String[] list) {
    int cap = Math.max((int) (list.length/.75f) + 1, 16);
    elements = new HashSet(cap);
    elementsLowercase = new HashSet(cap);
    for (String e : list) {
      elements.add(e);
      elementsLowercase.add(e.toLowerCase());
    }
  }

  public boolean containsIgnoreCase(String source) {
    return elementsLowercase.contains(source.toLowerCase());
  }

  public boolean contains(String source) {
    return elements.contains(source);
  }

}
