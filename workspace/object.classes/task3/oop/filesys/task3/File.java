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


import oop.filesys.EOFException;
import oop.filesys.FSException;
import oop.filesys.IDirectory;
import oop.filesys.IFile;

public class File extends Node implements IFile {

  /**
   * The constructor must add this file to the given parent, 
   * with the given name.
   * Note: a directory may not have the same name as a file,
   *       two files may not have the same name.
   * @throws FSException if there is a name conflict as described 
   *         in the note above.
   */
  public File(Directory parent, String name) throws FSException {
    super(parent, name);
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public String toString() {
    return path();
  }

  public int size() throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  public int available() throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  public byte read() throws FSException, EOFException {
    throw new RuntimeException("Not Yet Implemented");
  }

  public void write(byte val) throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  public void seek(int offset) throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public boolean valid() {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public boolean move(IDirectory dst, String name) throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

}
