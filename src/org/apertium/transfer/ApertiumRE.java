/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.transfer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apertium.lttoolbox.Compression;

/**
 *
 * @author Jacob Nordfalk
 */
public class ApertiumRE {
  Pattern re;

  public ApertiumRE(String regex) {
    re = Pattern.compile(regex, Pattern.DOTALL|Pattern.CASE_INSENSITIVE); // |Pattern.UNICODE_CASE
    // PCRE_DOTALL|PCRE_CASELESS|PCRE_EXTENDED|PCRE_UTF8,
  }

  ApertiumRE() {
  }

  String match(String source) {
    Matcher m = re.matcher(source);
    if (!m.find()) return "";
    return m.group();
  }

  String replace(String source, String value) {
    Matcher m = re.matcher(source);
    if (!m.find()) return source;
    return source.substring(0, m.start()) + value + source.substring(m.end());
  }
}
