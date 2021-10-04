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
 *  Created on: November, 2019
 *      Author: Pr. Olivier Gruber <olivier dot gruber at acm dot org>
 */
package object.gui.task1;

public class Task1Main {

  static void test(ButtonDriver bd, String s, int count) {
    System.out.println("Test: "+s);
    try {
      if (!bd.drive(s, count))
        System.out.println("  FAILED: " + s+ " count="+count);
      System.out.println("  PASSED");
    } catch (IllegalSequenceException e) {
      e.printStackTrace();
      System.out.println("  should not have happened.");
    }
  }

  static void checkRejected(String s) {
    ButtonDriver bd = new ButtonDriver();
    System.out.println("Test: "+s);
    try {
      bd.drive(s, 0);
      System.out.println("  FAILED (accepted sequence)" + s);
    } catch (IllegalSequenceException e) {
      System.out.println("  PASSED (rejected sequence)");
    }
  }

  public static void main(String[] args) {
    ButtonDriver bd = new ButtonDriver();
    test(bd,"EDUL",1);
    test(bd,"EDUDUL",2);
    test(bd,"EUDUL",1);
    test(bd,"EUDL",0);

    checkRejected("L");
    checkRejected("EUDE");
    checkRejected("EDDL");
    checkRejected("EUUL");
    
    System.out.println("Done.");
  }

}
