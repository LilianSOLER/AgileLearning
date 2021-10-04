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
package oop.filesys;

/**
 * A directory may contain directories and files.
 * Therefore, directories form a tree of directories.
 * 
 * @author Pr. Olivier Gruber (olivier dot gruber at acm dot org)
 *
 */
public interface IDirectory {

  /**
   * @return true if this directory was not removed from its parent.
   */
  public boolean valid();

  /**
   * @return the file system of this directory, even if this directory is no longer valid.
   */
  public IFileSystem getFileSystem();

  /**
   * @return the parent directory of this directory, even if this directory is no longer valid.
   */
  public IDirectory parent();

  /**
   * @return the name of this directory, even if this directory is no longer valid.
   */
  public String name();

  /**
   * @return the full path to this directory, even if this directory is no longer valid.
   *         The full path is the full path of the parent directory 
   *         plus the name of this directory.
   */
  public String path();

  /**
   * Searches for a directory with the given name.
   * @param the name of the wanted directory (not a path)
   * @return the directory with the given name, if found,
   *         null otherwise.
   * @throws FSException for unexpected situations.
   */
  public IDirectory dir(String name) throws FSException;

  /**
   * @return an array with all the sub-directories found
   *         in this directory.
   * @throws FSException for unexpected situations.
   */
  public IDirectory[] dirs() throws FSException;

  /**
   * Searches for a file with the given name (not a path).
   * @param the name of the wanted file (not a path)
   * @return the file with the given name, if found,
   *         null otherwise.
   * @throws FSException for unexpected situations.
   */
  public IFile file(String name) throws FSException;

  /**
   * @return an array with all the files found in this
   *         directory.
   * @throws FSException for unexpected situations.
   */
  public IFile[] files() throws FSException;

  /**
   * Creates a directory as a child of this directory if there is no name conflict.
   * Name conflict: a directory may not have the same name as a file,
   *                two directories may not have the same name.
   * @param desired name
   * @return the created directory
   * @throws FSException for unexpected situations.
   */
  public IDirectory mkdir(String name) throws FSException;

  /**
   * Removes a directory with the given name, only if the directory is empty.
   * the removed directory becomes invalid.
   * @param name
   * @return true if the directory was found and removed,
   *         false otherwise.
   * @throws FSException for unexpected situations.
   */
  public boolean rmdir(String name) throws FSException;

  /**
   * Create a file with the given name, or returns it if it exits already.
   * @param the name of the wanted file (not a path)
   * @return the created file.
   * @throws FSException for unexpected situations.
   */
  public IFile touch(String name) throws FSException;

  /**
   * Removes the file by the given name.
   * @param name
   * @return true if the file was found and removed,
   *         false otherwise.
   * @throws FSException for unexpected situations.
   */
  public boolean rm(String name) throws FSException;
  
  /**
   * Moves and renames this directory.
   * @return true if the renaming was possible, false otherwise.
   * @throws FSException for unexpected situations.
   */
  public boolean move(IDirectory dst, String name) throws FSException;

}
