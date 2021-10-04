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

import oop.filesys.EOFException;
import oop.filesys.FSException;
import oop.filesys.IDirectory;
import oop.filesys.task4.Directory;
import oop.filesys.task4.File;

public class RamFile extends File {

  public RamFile(Directory parent, String name) throws FSException {
    super(parent, name);
    throw new RuntimeException("Not Yet Implemented");
  }
  
  @Override
  public int size()  throws FSException {
    // Where should this method be implemented?
    // Here, on class File, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public int available() throws FSException {
    // Where should this method be implemented?
    // Here, on class File, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public byte read() throws FSException, EOFException {
    // Where should this method be implemented?
    // Here, on class File, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public void write(byte val) throws FSException {
    // Where should this method be implemented?
    // Here, on class File, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public void seek(int offset) throws FSException {
    // Where should this method be implemented?
    // Here, on class File, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public boolean valid() {
    // Where should this method be implemented?
    // Here, on class File, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public boolean move(IDirectory dir, String newName) {
    // Where should this method be implemented?
    // Here, on class File, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

}
