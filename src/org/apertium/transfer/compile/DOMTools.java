/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.transfer.compile;

import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Jacob Nordfalk
 */
public class DOMTools {


  public static Iterable<Element> list(final NodeList nl) {
    return new Iterable<Element>() {

      @Override
      public Iterator<Element> iterator() {
        return new Iterator<Element>() {
          int i = 0;
          public boolean hasNext() {
            while (i<nl.getLength() && !(nl.item(i) instanceof Element)) i++;
            return (nl.item(i) instanceof Element);
          }

          { hasNext(); } // initialization, in case hasNext() isnt called

          public Element next() {
            return (Element) nl.item(i++);
          }

          public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
          }
        };
      }
    };
  }

  public static Iterable<Element> children(Element e) {
    return list(e.getChildNodes());
  }


  public static Element getFirstChildElement(Element e) {
    return findElementSibling(e.getFirstChild());
  }


  public static Iterable<Element> getChildsChildrenElements(Element e0, String tagName) {
    for (Element e : list(e0.getChildNodes()))
      if (e.getTagName().equals(tagName))
        return list(e.getChildNodes());
    return new ArrayList<Element>(0);
  }

  public static Element getChildrenElement(Element e0, String tagName) {
    for (Element e : list(e0.getChildNodes()))
      if (e.getTagName().equals(tagName))
        return findElementSibling((e.getFirstChild()));

    new IllegalStateException(e0+" has no child "+tagName).printStackTrace();
    return null;
  }

  public static Element findElementSibling(Node n) {
    while (n!=null && !(n instanceof Element)) n = n.getNextSibling();
    return (Element) n;
  }


  public static boolean isTag(Element e, String string) {
    String n = e.getTagName();
    //System.err.println("isTag("+string+") for "+n);
    return string.equals(n);
  }
}