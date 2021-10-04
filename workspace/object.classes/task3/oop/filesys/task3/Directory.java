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
package oop.filesys.task3;


import edu.polytech.oop.collections.IList;
import oop.filesys.FSException;
import oop.filesys.IDirectory;
import oop.filesys.IFile;
import oop.filesys.IFileSystem;

public class Directory extends Node implements IDirectory {

  IList nodes;
  IFileSystem fs;

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
  public String toString() {
    return path();
  }

  public IFileSystem getFileSystem() {
    return fs;
  }

  @Override
  public String path() {
    return super.path() + "/";
  }

  @Override
  public IDirectory dir(String name) throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public IDirectory[] dirs() throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public IFile file(String name) throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public IFile[] files() throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public IDirectory mkdir(String name) throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public boolean rmdir(String name) throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public IFile touch(String name) throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public boolean rm(String name) throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public boolean valid() {
    throw new RuntimeException("Not Yet Implemented");
  }

}
