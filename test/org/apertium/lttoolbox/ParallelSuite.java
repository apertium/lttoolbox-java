/*
 * Source:
 * https://parallel-junit.dev.java.net/source/browse/parallel-junit/parallel-junit/src/org/kohsuke/junit4/ParallelSuite.java?rev=1.2&view=markup

 Copyright (c) 2004, Kohsuke Kawaguchi
 All rights reserved.

 Redistribution and use in source and binary forms,
 with or without modification, are permitted provided
 that the following conditions are met:

 * Redistributions of source code must retain
 the above copyright notice, this list of
 conditions and the following disclaimer.
 * Redistributions in binary form must reproduce
 the above copyright notice, this list of
 conditions and the following disclaimer in
 the documentation and/or other materials
 provided with the distribution.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT
 HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS
 OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY
 AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS
 BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER
 IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF
 THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 THE POSSIBILITY OF SUCH DAMAGE.

 */
package org.apertium.lttoolbox;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import junit.textui.TestRunner;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;
import org.junit.runners.model.Statement;

/**
 * {@link ParallelSuite} that runs TestClass in parallel.
 *
 * <p>
 * <b>TestSuite Example</b>:<br/>
 * <code>@RunWith(ParallelSuite.class)</code><br/>
 * <code>@SuiteClasses(
 * {Test1.class, Test2.class,Test3.class, Test4.class, Test5.class})</code><br/>
 * <code>@NThreads(5)</code><br/>
 * <code>public class TestSuiteClass{}</code><br/>
 *
 * <p>
 * NThreads is number of threads, and is omissible.
 *
 * @see org.junit.runners.Suite
 *
 * @author cactusman
 * @author royzumi
 */
public class ParallelSuite extends Suite {
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  public @interface NThreads {
    /**
     * @return Number of Threads.
     */
    public int value();
  }

  private int nThreads;

  public ParallelSuite(Class<?> klass, RunnerBuilder builder) throws InitializationError {
    super(klass, builder);
    nThreads = getNThreads(klass);
  }

  private static int getNThreads(Class<?> klass) throws InitializationError {
    NThreads annotation = klass.getAnnotation(NThreads.class);
    if (annotation == null) {
      return defaultThreadSize();
    } else {
      return annotation.value();
    }
  }

  private static final int defaultThreadSize() {
    return 4;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Statement childrenInvoker(final RunNotifier notifier) {
    return new Statement() {
      public void evaluate() {
        runChildren(notifier);
      }
    };
  }

  private void runChildren(final RunNotifier notifier) {
    ExecutorService es = Executors.newFixedThreadPool(nThreads);
    CompletionService<Object> completionService =
        new ExecutorCompletionService<Object>(es);
    for (final Runner runner : getChildren()) {
      completionService.submit(new Callable<Object>() {
        public Object call() {
          runChild(runner, notifier);
          return null;
        }
      });
    }
    int n = getChildren().size();
    try {
      for (int i = 0; i < n; i++) {
        try {
          completionService.take().get();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    } finally {
      es.shutdown();
    }
  }
}
