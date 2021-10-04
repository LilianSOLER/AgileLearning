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

import java.io.IOException;

import oop.filesys.FSException;
import oop.filesys.IDirectory;


/** 
 * The abstract class representing a node in a directory,
 * a node being either a file or a directory, modeled as 
 * two concrete sub-classes.
 * 
 * @author: Pr. Olivier Gruber
 */

public abstract class Node extends Object {

  protected String name;
  protected Directory parent;

  protected Node() {
    this.name = "";
  }

  protected Node(Directory parent, String name) {
    this.name = name;
  }
  
  public String name() {
    return name;
  }

  public IDirectory parent() {
    return parent;
  }

  public String path() {
    if (parent != null)
      return parent.path() + name;
    else
      return name;
  }

  @Override
  public String toString() {
    return path();
  }
  
  /**
   * Moves this node to the given destination directory under
   * the given name. 
   * This operation only succeeds if there is no name conflict
   * at the destination directory (there is no file or directory
   * with the given name). 
   * If unsuccessful, this operation must have no effect at all,
   * leaving the file system in a state as if this method was never
   * invoked.
   * @param dst
   * @param name
   * @return true if the move was successful.
   * @throws IOException
   * @throws IllegalStateException if this directory or the destination
   *         directory were removed from its parent.
   */
  public boolean move(IDirectory dst, String name) throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  /**
   * Serves as a notification for this node, 
   * when this method is invoked, this node has just been 
   * removed from its parent (a directory).
   */
  public void removed() throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }
}
