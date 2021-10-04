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
package oop.filesys.task5.fs;

import java.io.File;
import java.io.IOException;

import oop.filesys.EOFException;
import oop.filesys.FSException;
import oop.filesys.IDirectory;
import oop.filesys.IFile;
import oop.filesys.IFileSystem;
import oop.filesys.task5.dev.BlockDevice;
import oop.filesys.tests.TestSuite;;

public class Tests {

  public static void main(String[] args) throws FSException {
    try {
      System.out.println("Testing File System:");
      tests(false);
      System.out.println("    PASSED.");
      System.exit(0);
    } catch (Throwable th) {
      th.printStackTrace();
      System.out.println("FAILED.");
      System.exit(-1);
    }
  }

  public static void tests(boolean useMap) throws FSException, EOFException, IOException {
    File file = new File("disk.img");
    BlockDevice dev = new BlockDevice(file,512,2048);
    FileSystem fs = new FileSystem("/oop/disk", dev, true);
    IDirectory root = fs.root();
    TestSuite.test00(root);
    fs.sync();
    
    dev = new BlockDevice(file,512,2048);
    fs = new FileSystem("/oop/disk", dev, false);
    root = fs.root();
    createFileSystem(fs);
    fs.sync();
    
    dev = new BlockDevice(file,512,2048);
    fs = new FileSystem("/oop/disk", dev, false);
    root = fs.root();
    checkFileSystem(fs);
  }

  static private void createFileSystem(IFileSystem fs) throws FSException {
    IDirectory root = fs.root();
    IDirectory dir, home;
    home = root.dir("home");
    dir = home.mkdir("ogruber");

    IFile file = dir.touch("data");
    for (int i = -128; i <= 127; i++)
      file.write((byte) i);
  }

  static private void checkFileSystem(IFileSystem fs) throws FSException, EOFException {
    IDirectory root = fs.root();
    IDirectory dir, home;
    home = root.dir("home");
    dir = home.dir("ogruber");

    IFile file = dir.file("data");
    for (int i = -128; i <= 127; i++) {
      byte val = file.read();
      ensure(((byte) i) == val);
    }
  }

  static void ensure(boolean cond) {
    if (!cond) {
      System.out.println("FAILED!");
      throw new Error();
    }
  }

}
