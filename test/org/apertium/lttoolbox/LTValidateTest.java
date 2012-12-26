/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.lttoolbox;

import junit.framework.TestCase;

/**
 *
 * @author Jacob Nordfalk
 */
public class LTValidateTest extends TestCase {
  public void testDixvalidation() throws Exception {
    assertTrue(LTValidate.validateDix("testdata/short.dix"));
    assertFalse(LTValidate.validateDix("testdata/short-invalid.dix"));
    assertFalse(LTValidate.validateDix("nonexisant.dix"));
  }

  public void testAcxvalidation() throws Exception {
    assertTrue(LTValidate.validateAcx("testdata/apertium-fr-es.fr.acx"));
  }
}
