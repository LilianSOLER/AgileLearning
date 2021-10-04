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
package oop.filesys.task5.dev;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * A block device is a block-oriented mass storage,
 * that is, a sequence of blocks of bytes. Each block 
 * has the same size. 
 * 
 * In this implementation, our block device is using 
 * a Java file, on your Linux disk, as a way to make
 * its blocks persist.
 * 
 * Nota Bene: the Linux file is not initialized. A block
 * that has never been written has an unknown content.
 *  
 * @author Pr. Olivier Gruber
 */
public class BlockDevice {

  RandomAccessFile m_file;
  int m_blockSize;
  int m_blockCount;

  public BlockDevice(File file, int blockSize, int blockCount) throws IOException {
    if (!file.exists())
      file.createNewFile();
    m_file = new RandomAccessFile(file, "rw");
    m_blockSize = blockSize;
    m_blockCount = blockCount;
    int length = blockSize*blockCount;
    if (file.length()<length) {
      m_file.seek(length-1);
      m_file.write(0);
    }
  }

  public int getBlockSize() {
    return m_blockSize;
  }

  public int getBlockCount() {
    return m_blockCount;
  }

  public void write(int bn, byte[] buffer) throws IOException {
    m_file.seek(bn * m_blockSize);
    m_file.write(buffer);
  }

  public void read(int bn, byte[] buffer) throws IOException {
    m_file.seek(bn * m_blockSize);
    m_file.readFully(buffer);
  }

}
