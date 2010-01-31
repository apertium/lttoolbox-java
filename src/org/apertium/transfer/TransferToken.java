/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.transfer;

/**
 *
 * @author Jacob Nordfalk
 */
class TransferToken {

  enum TransferTokenType
  {
    tt_eof,
    tt_word,
    tt_blank
  };

  TransferTokenType type;
  String content;

  TransferToken(String content, TransferTokenType type) {
    this.content = content;
    this.type = type;
  }

  public String toString() {
    return content;
  }
}
