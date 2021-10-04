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
 *  Created on: November, 2017
 *      Author: Pr. Olivier Gruber <olivier dot gruber at acm dot org>
 */
package oop.filesys.task4.ramfs;

import java.io.IOException;

import oop.filesys.EOFException;
import oop.filesys.FSException;
import oop.filesys.task4.Directory;
import oop.filesys.task4.FileSystem;
import oop.filesys.tests.TestSuite;;

public class RamTests {

  public static void main(String[] args) throws IOException {
    try {
      System.out.println("Testing RamDirectory:");
      tests();
      System.out.println("    PASSED.");
      System.exit(0);
    } catch (Throwable th) {
      th.printStackTrace();
      System.out.println("FAILED.");
      System.exit(-1);
    }
  }

  public static void tests() throws FSException, EOFException, IOException {
    Factory factory = new Factory();
    FileSystem fs = new FileSystem("/oop/disk", factory);
    Directory root = new RamDirectory(fs);
    fs.setRoot(root);
    TestSuite.test00(root);
  }

}
