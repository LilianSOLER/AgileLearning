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

import oop.filesys.FSException;
import oop.filesys.task5.dev.BlockDevice;

public class Shell {

  public static void main(String[] args) throws FSException,IOException {
    boolean format = true;
    int nBlocks = 2048;
    String filename = "disk.img";
    for (int i = 0; i < args.length; i++) {
      if ("-cold".equals(args[i]))
        format = true;
      else if ("-warm".equals(args[i]))
        format = false;
      else if ("-file".equals(args[i]))
        filename = args[++i];
      else if ("-count".equals(args[i]))
        nBlocks = Integer.valueOf(args[++i]);
      else if ("-help".equals(args[i])) 
        System.out.println("Usage: shell [-cold] [-warm] [-file toto] [-count 1024");
    }
    File file = new File(filename);
    BlockDevice dev = new BlockDevice(file, 512, nBlocks);
    FileSystem fs = new FileSystem("/oop/disk", dev, format);
    oop.shell.Shell shell;
    shell = new oop.shell.Shell(System.out, System.in, fs);
    shell.loop();
    System.out.println("Bye.");
    fs.sync();
  }

}
