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
 * This is your first lesson in Java debug, via Eclipse.
 * You will learn the basic controls of the execution.
 *
 * @author Pr. Olivier Gruber <olivier dot gruber at acm dot org>
 *
 */
public class Lesson1 {

 
  
  public static void main(String[] args) throws FileNotFoundException, IOException {

    /*
     * Welcome to your first Java debug lesson in Eclipse. 
     * 
     * This first lesson is about single stepping through the execution of your program.
     * You will learn the following concepts:
     *    - step in (F5)
     *    - step over (F6)
     *    - step out (F7)
     *    - run to selection (Ctrl-R)
     *    - run (F8)
     *  
     * So here we go, let's step in foo() -- Hit F5 please
     */
    foo();
    
    System.out.println("Congratulations! You made it through your first lesson.");
    System.out.println("That's all folks.");
    return;
  }


  static void echoStep1() {
    System.out.println("\n---------------------------------------");
    System.out.println("Step 1: controlling the execution:");
    System.out.println("---------------------------------------");

    System.out.println("  - Search in the Step1 class (use Ctlr-Shift-T) ");
    System.out.println("  - Search for the method called step (use Ctlr-O)");
    System.out.println("  - Double click on the first line of that method.");
    System.out.println("\nYou should see a round blue bullet on the line you double-clicked.");
    
    System.out.println("When ready, hit return in the console...");
    Utils.readline();
  }

  static int bar() {
    /*
     * Oh no, not again, a long loop ;-)
     * 
     * Now, you could do the same trick (Ctlr-R), selecting the line with the return.
     * 
     * But really, what you want is to step out of this method.
     * 
     * Just do so with F7. 
     * Don't be shy, hit F7 now... and then F6 to step to the next line
     */
    int k=0;
    for (int i=0;i<1000;i++) 
      k += i;
    return k;
  }
  
  static void foo() {
    /*
     * Look at the Debug view... see the call stack.
     * It tells you that you are executing Lesson1 as a Java Application.
     * It tells you that the execution has one thread (that is, one flow of execution).
     * It tells you that the thread called [main] is suspended.
     * It also gives you the current call stack:
     *      Lesson1.foo()
     *      Lesson1.main(String[])
     *      
     * You can click on the various lines, Eclipse will navigate
     * to the correct line in the correct source. Cool.
     * 
     * Once you are back here, let's step over this variable definition.
     * Hit F6 please.
     */
    int k =0;
    
    /*
     * See, it is easy to single step.
     * Look at the Variables view, you can see the local variable k and its current value (0).
     * 
     * Look at the next lines, it is a loop.
     * It is in fact a long running loop since it has 1000 iterations.
     * If we are to single step through it, we would need to single step through the 1000 iterations,
     * not fun and not efficient. 
     * 
     * Right?
     * 
     * So let's learn how to run to a selected line. 
     * First, select the first line right after the loop, that is, the invocation of bar().
     * Then, hit Ctrl-R 
     */
    for (int i=0;i<1000;i++) 
      k += i;
    
    /*
     * Fantastic, you just saved yourself a lot of pain!
     * 
     * Let's step into this function, using F6... oops... F6 is step over.
     * Use F5 to step in.
     */
    bar();
    
    /*
     * Hey, welcome back! 
     * So you learn F5, F6, F7, and even Ctlr-F5.
     * 
     * Let's learn F8, the go command.
     * Indeed we are done here.
     * So go ahead, hit F8
     */

    return;
  }
  
  /*
   * This is the beginning of this step.
   * If you followed the instruction, you should have a breakpoint
   * setup on this method line.
   */
  static void step()  {
    
    /* 
     * Look in the Variables view, do you see the variable i?
     * Not yet since the variable i is not defined yet.
     * Single step once, using F6.
     */
    int i=0;
    
    /*
     * Now you do see it, right?
     * 
     * Look at call stack in the Debug view.
     * You can click and navigate to the call sites, just click on the corresponding line
     * and Eclipse will navigate you to the correct source file, at the correct line.
     * 
     * Let's check that you got it.
     * Step in (F5) at the next line, down into myFirstLocalVariables()
     * 
     * Sometimes, if F5/F6 do not work, you need to click in the Debug view or Source view.
     * It is a focus problem in the Eclipse GUI.
     */
    foo();
    
    return;
  }
  

}
