/*
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Created on: Jan 19, 2017
 *      Author: Pr. Olivier Gruber <olivier dot gruber at acm dot org>
 */
package edu.java.debug;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This is your third lesson in Java debug, via Eclipse.
 * 
 * You will learn the basics about exceptions.
 * 
 * You will also practice what you have learned in Lesson1 and Lesson2. - step
 * in (F5) - run to selection (Ctrl-F5) - step over (F6) - step out (F7) - run
 * to selected line (Ctrl-R) - run (F8)
 *
 * @author Pr. Olivier Gruber <olivier dot gruber at acm dot org>
 *
 */

public class Lesson3 {

  static float divide(float f1, float f2) {
    if (f2 == 0)
      throw new IllegalArgumentException("Division by zero");
    return (f1 / f2);
  }

  public static void main(String[] args) throws FileNotFoundException, IOException {

    /*
     * First time around, hit F8 to resume the execution. An exception will be thrown
     * and the execution will be terminated. Look at the output in the console.
     * Then follow the task recommendation.
     */
    lesson();

    System.out.println("Congratulations! You made it through your second lesson.");
    System.out.println("That's all folks.");
    return;
  }

  static void lesson() {

    float f1 = 32.0F;
    float f2 = 0.0F;

    
    f1 = divide(f1, f2);

    int f, k = 0;

    try {
      /*
       * Step over this invocation, see what happens...
       */
      f = foo(k);
    } catch (Throwable th) {
      /* So? what happened? 
       * This is not the regular execution path, is it?
       * So there was an exception thrown: 
       *   (1) which one?
       *   (2) where was it thrown?
       */
      th.printStackTrace();
      /*
      *  See the output in the console, each underlined text is an hyperlink.
      *  
      *  Click the source hyperlinks to see where it happened.
      *  Eclipse will navigate you at the right line in the right source.
      * 
      *  This is cool, but you do not have access to the values of local variables and arguments.
      *  In this case, things are pretty simple, k=0.
      *  
      *  But it would be nice to be able to stop right before the exception is thrown.
      *  What you need is to set a breakpoint for ArithmeticException.
      *  
      *  Click on the hyperlink (java.lang.ArithmeticException) in the console... 
      *  You get a popup dialog that allows to setup a breakpoint on that exception. 
      *  Say OK and verify in your Breakpoints view that the breakpoint has been added.
      *  
      *  Now step over until the next invocation of foo2(k) below...
      */
    }

    try {
      /*
       * Step over the next line, see what happens now.
       */
      f = foo2(k);
    } catch (ArithmeticException th) {
      /*
       * Congratulations, you just stepped through your first 
       * stack unrolling. 
       * We are done now, let's step out with F7
       */
      f = 0;
    }
    return;
  }

  /*
   * Meaningless method, just to illustrate runtime exceptions.
   */
  static int bar(int k, int f) {
    /* 
     * Now you are here and you can see that the exception was caused
     * by a division by zero with k=0.
     * 
     * But how do you get back to where you were before?
     * 
     * Remember that you can use the call stack in the Debug view
     * to navigate up and down. So just select the Step3.caughtUncaught() line
     * and Eclipse will navigate you back.
     * 
     * You could also use the back yellow arrow on the toolbar.
     */
    return f / k;
  }

  /*
   * Meaningless method, just to illustrate runtime exceptions
   */
  static int foo(int k) {
    int f = 1;
    return bar(k, f);
  }

  /*
   * Meaningless method, just to illustrate runtime exceptions
   */
  static int bar2(int k, int f) {
    /* 
     * See, this time, the execution stop right before raising 
     * the exception because of the division by zero.
     * 
     * Look at the Debug view, it tells you why the execution has stopped:
     * 
     *    Thread [main] (Suspended (exception ArithmeticException))
     *    
     * Now single step your way through the unrolling of the stack
     * back to the handler.
     */
    return f / k;
  }

  static boolean foo2HasRaisedArithmeticException = false;

  /*
   * Meaningless method, just to illustrate runtime exceptions
   */
  static int foo2(int k) {
    int f = 1;
    try {
      return bar2(k, f);
    } catch (RuntimeException ex) {
      /*
       * Not very useful, but this handler shows you that you can catch
       * an exception, do some local processing, and then rethrow it.
       */
      foo2HasRaisedArithmeticException = true;
      throw ex;
    }
  }

  static int fact(int f) {
    /*
     * Don't want to be here and step through the recursion?
     * Just step out of this invocation: use F7
     */
    if (f == 1)
      return 1;

    return f * fact(f - 1);
  }

}
