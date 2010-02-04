/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apertium.transfer.generated;

/**
 *
 * @author Jacob Nordfalk
 */
public abstract class GeneratedTransferBase {
  public void init() {
  }
  public abstract boolean isOutputChunked();

  public boolean debug;

  protected void logCall(String met) {
    System.err.println("call:" + met);
  }
}
