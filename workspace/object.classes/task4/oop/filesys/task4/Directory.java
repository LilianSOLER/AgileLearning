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
package oop.filesys.task4;

import edu.polytech.oop.collections.ICollection;
import edu.polytech.oop.collections.ICollection.Iterator;
import oop.filesys.FSException;
import oop.filesys.IDirectory;
import oop.filesys.IFileSystem;

public abstract class Directory extends Node implements IDirectory {

  protected ICollection nodes;
  protected FileSystem fs;

  /**
   * Creates the root of the file system
   * 
   * @param fs
   * @throws FSException
   */
  public Directory(FileSystem fs) throws FSException {
    super();
    throw new RuntimeException("Not Yet Implemented");
  }

  /**
   * Creates a directory as a child of the given parent.
   * The constructor must add this directory to the given parent, 
   * with the given name.
   * Note: a directory may not have the same name as a file,
   *       two directories may not have the same name.
   * @throws FSException if there is a name conflict as described 
   *         in the note above.
   */
  public Directory(Directory parent, String name) throws FSException {
    super(parent, name);
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public IFileSystem getFileSystem() {
    return fs;
  }

  public String path() {
    return super.path() + "/";
  }

  /**
   * Adds the given node to the set of children of this directory.
   * @throws FSException if there is a problem, such as 
   * a name conflict.
   */
  abstract protected void add(Node node) throws FSException;

  /**
   * Removes the given node from the set of children of this directory.
   * 
   * Nota Bene: if your code invokes this method, it must also 
   *            invoke the method Node.removed() to notify the node
   *            that it was removed from its parent (this directory).
   */
  abstract protected void remove(Node node) throws FSException;

  /**
   * Gives an iterator on the nodes in this directory
   * @return
   */
  abstract protected Iterator iterator() throws FSException;

}
