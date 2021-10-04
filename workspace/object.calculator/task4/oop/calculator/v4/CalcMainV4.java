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
 *  Created on: November, 2018
 *      Author: Pr. Olivier Gruber <olivier dot gruber at acm dot org>
 */
package oop.calculator.v4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CalcMainV4 {

  public static void load(Calculator cal, String filename) {
    File file = new File(filename);
    if (file.exists()) {
      cal.interactive(false);
      try {
        System.out.println("Loading file: " + file);
        InputStream is = new FileInputStream(file);
        cal.loop(is);
        System.out.println("Done (" + file + ")");
        return;
      } catch (Exception e) {
        System.out.println("Exception: " + e.toString());
      }
      cal.interactive(true);
    }
  }

  public static void main(String[] args) throws IOException {

    Calculator cal = new Calculator(System.out);

    System.out.println("Welcome.");

    for (int i = 0; i < args.length; i++)
      load(cal, args[i]);

    cal.loop(System.in);
  }

}
