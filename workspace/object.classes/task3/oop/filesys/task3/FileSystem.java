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

import oop.filesys.FSException;
import oop.filesys.IDirectory;
import oop.filesys.IFileSystem;

public class FileSystem implements IFileSystem {
  private String name;
  private Directory root;

  public FileSystem(String name) throws FSException {
    this.name = name;
    root = new Directory(this);
  }

  @Override
  public String name() {
    return name;
  }
  
  @Override
  public IDirectory root() {
    return root;
  }
  
  @Override
  public void sync() throws FSException {
    // Nothing to do here
  }
}
