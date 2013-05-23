/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.lttoolbox.compile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import org.apertium.lttoolbox.Alphabet;
import org.apertium.lttoolbox.Compression;

/**
 *
 * @author j
 */
public class TransducerCollection {
  public String letters;
  public Alphabet alphabet;
  public LinkedHashMap<String, TransducerComp> sections;

  public void read(String file) throws IOException {
    InputStream input = new BufferedInputStream (new FileInputStream(file));
    letters = Compression.String_read(input);
    alphabet = Alphabet.read(input);
    sections = new LinkedHashMap<String, TransducerComp>();

    int len = Compression.multibyte_read(input);
    while (len > 0) {
      String name = Compression.String_read(input);
      System.err.println("read "+name+ "  @" + file);

      TransducerComp t = TransducerComp.TEST_read(input);
      sections.put(name, t);
      len--;
    }
    input.close();
  }

}
