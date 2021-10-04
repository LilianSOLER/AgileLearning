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
 * A file is a sequence of bytes that can be read or written.
 * 
 * A file belongs to a directory, always, when valid. When a file
 * is removed from its directory, it becomes invalid and most methods
 * throw IllegalStateException. Once invalid, the file remains invalid
 * and should no longer be used. References to an invalid file should be
 * cut.
 * 
 * A file maintains a current position where to read a byte value 
 * from or write a byte value to. That position is automatically
 * incremented when reading or writing, but it can be also manually
 * set to any position. 
 * It is legal to set the current position beyond the current end 
 * of the file, in effect, growing the file, when written at that position.
 * Correspondingly, a read will indicate the end-of-file condition 
 * when reaching the end of the file while a write will grow the file. 
 * 
 * @author Pr. Olivier Gruber (olivier dot gruber at acm dot org)
 */
public interface IFile {

  /**
   * @return true if this file was not removed from its parent.
   */
  public boolean valid();

  /**
   * @return the parent of this file, even if this file is no longer valid.
   */
  public IDirectory parent();

  /**
   * @return the name of this file, even if this file is no longer valid.
   */
  public String name();

  /**
   *  @return the full path to this file, even if this file is no longer valid.
   *  The full path is the full path of the parent plus the name of this file.
   */
  public String path();

  /**
   * @return the size of this file in bytes
   * @throws FSException for unexpected situations.
   */
  public int size() throws FSException;

  /**
   * @return the number of available bytes to read
   *         from the current position, see seek
   * @throws FSException for unexpected situations.
   */
  public int available() throws FSException;

  /**
   * @return the byte at the current position and increments
   *         that position by one.
   * @throws EOFException if the end of file has been reached.
   * @throws FSException for unexpected situations.
   */
  public byte read() throws FSException, EOFException;

  /**
   * Writes the given byte at the current position 
   * and increments that position by one.
   * @param val
   * @throws FSException for unexpected situations.
   */
  public void write(byte val) throws FSException;

  /**
   * A file maintains a current position to read from
   * or to write at. This method allows to change 
   * that position at the given offset, even passed
   * the current end of file, which effectively grows
   * the file. 
   * @throws FSException for unexpected situations.
   */
  public void seek(int offset) throws FSException;

  /**
   * Moves and renames this file.
   * @return true if the renaming was possible, false otherwise.
   * @throws FSException for unexpected situations.
   */
  public boolean move(IDirectory dst, String name) throws FSException;

}
