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
 * This is your second lesson in Java debug, via Eclipse.
 * 
 * You will learn the basics about local variables and arguments.
 * 
 * You will also learn the ability to run to selection (Ctrl-F5),
 * a fantastic trick that will really help you.
 * 
 * You will also practice what you have learned in Lesson1.
 *    - step in (F5)
 *    - step over (F6)
 *    - step out (F7)
 *    - run to selected line (Ctrl-R)
 *    - run (F8)
 *
 * @author Pr. Olivier Gruber <olivier dot gruber at acm dot org>
 *
 */

public class Lesson2 {

  
  public static void main(String[] args) throws FileNotFoundException, IOException {

    /*
     * Welcome to your second Java debug lesson in Eclipse. 
     * 
     * This lesson is about local variables and arguments.
     *  
     * So here we go, let's step in lesson() -- Hit F5 please
     */
    lesson();
    
    System.out.println("Congratulations! You made it through your second lesson.");
    System.out.println("That's all folks.");
    return;
  }

  
  /*
   * Meaningless method, just to illustrate arguments and local variables.
   */
  static float bar(int k, float f) {
    /*
     * Notice that local variables are really local.
     * Move up and down between foo() and bar() and see the
     * value of d change.
     * 
     * Notice that the value of arguments are visible both on the call stack
     * and in the Variables view.
     */
    double d = (double)f;

    if (k!=0) 
      d = d / (double)k;
    
    return (float)d;
  }

  /*
   * Meaningless method, just to illustrate arguments and local variables.
   */
  static float foo(int i) {
    /*
     * Let's look at some local variables...
     * Please, single-step over the following lines
     * 
     * Look at the Variables view, while you single step.
     * See how local variables appear as they become initialized.
     */
    int k;
    float f = 1.0f;
    long j = Long.MAX_VALUE;
    double d = 2.0d;

    /*
     * Did you notice that variable k is not in the Variables view yet?
     * It is because it is not initialized yet.
     * Step over the next line and k will show up in the Variables view
     */
    k = 0;

    /*
     * You do not like the value of k... 
     * Oh well, just change it in the Variable views.
     * It is as easy as selecting the variable current value
     * and typing in the new value.
     * Set k to 2 for example.
     * 
     * Step into bar()...
     */
    return bar(k,f);
  }
  
  
  static int fact(int f) {
    /*
     * Don't want to be here and step through the recursion?
     * Just step out of this invocation: use F7
     */
    if (f==1)
      return 1;
    
    return f*fact(f-1); 
  }
  
  
  static void lesson() {

    /*
     * Look again at the Debug view and the call stack: 
     *    Lesson2.lesson() 
     *    Lesson2.main(String[]) 
     *    
     * Let's step-in foo(1)
     */
    foo(1);

    /*
     * Next line is a compound invocation: fact and bar.
     * What we want is to step through bar.
     * Try to step into, with F5, see what happens?
     * You will go down to fact, because it is the first invocation to step into.
     * You will step out of it using F7.
     * Then you will be back on this line and you can hit F5 again
     * and that will finally step into the bar invocation.
     */
    bar(2,fact(2));
    
    /* 
     * The situation above happens a lot, you have to step into a specific method
     * but the line contains many other invocations that you do not want to step
     * into.
     * 
     * So, how do I step into bar and not into fact?
     * 
     * Select the invocation you want to step into,
     * By selecting, we mean highlighting the bar text in the source with your mouse.
     * Then hit Ctlr-F5 (run to selection).
     * 
     * You will find yourself in bar(), after fact has been invoked and it has 
     * fully executed. It will be easy to verify since the f argument, in the bar 
     * invocation, has the value 120, which is fact(5)=120.
     */
    bar(2,fact(5));
    
    /*
     * Ok, so you are done with your step 2.
     * Resume the execution with F8
     */
    return;
  }

}
