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

import edu.polytech.oop.collections.ICollection.Iterator;
import oop.filesys.FSException;
import oop.filesys.IDirectory;
import oop.filesys.IFile;
import oop.filesys.task4.Directory;
import oop.filesys.task4.FileSystem;
import oop.filesys.task4.Node;

public class RamDirectory extends Directory {

  public RamDirectory(FileSystem fs) throws FSException {
    super(fs);

    // Use your LinkedList from your collections to hold
    // all the files and directories of this directory

    throw new RuntimeException("Not Yet Implemented -- Use LinkedList");
  }

  public RamDirectory(Directory parent, String name) throws FSException {
    super(parent, name);

    // Use your LinkedList from your collections to hold
    // all the files and directories of this directory

    throw new RuntimeException("Not Yet Implemented -- Use LinkedList");
  }

  @Override
  protected Iterator iterator() {
    // Where should this method be implemented?
    // Here, on class Directory, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  protected void add(Node child) throws FSException {
    // Where should this method be implemented?
    // Here, on class Directory, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  protected void remove(Node child) throws FSException {
    // Where should this method be implemented?
    // Here, on class Directory, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public boolean valid() {
    // Where should this method be implemented?
    // Here, on class Directory, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public IDirectory dir(String name) throws FSException {
    // Where should this method be implemented?
    // Here, on class Directory, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public IDirectory[] dirs() throws FSException {
    // Where should this method be implemented?
    // Here, on class Directory, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public IFile file(String name) throws FSException {
    // Where should this method be implemented?
    // Here, on class Directory, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public IFile[] files() throws FSException {
    // Where should this method be implemented?
    // Here, on class Directory, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public IDirectory mkdir(String name) throws FSException {
    // Where should this method be implemented?
    // Here, on class Directory, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public boolean rmdir(String name) throws FSException {
    // Where should this method be implemented?
    // Here, on class Directory, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public IFile touch(String name) throws FSException {
    // Where should this method be implemented?
    // Here, on class Directory, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public boolean rm(String name) throws FSException {
    // Where should this method be implemented?
    // Here, on class Directory, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public boolean move(IDirectory dir, String newName) {
    // Where should this method be implemented?
    // Here, on class Directory, or on class Node?
    throw new RuntimeException("Not Yet Implemented");
  }

}
