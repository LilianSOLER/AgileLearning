package streams.step3;

import java.io.EOFException;

/**
 * This is an in-memory file, holding a sequence of signed bytes.
 * @author Pr. Olivier Gruber.
 */
public class InMemoryFile {

  byte[] bytes;  // to hold the sequence of bytes, from 0 to nbytes
  int    nbytes; // the number of bytes in that sequence

  public InMemoryFile() {
    bytes = new byte[1024];
  }

  /**
   * @return total size in bytes of this file.
   */
  public int size() {
    return nbytes;
  }
  
  /**
   * Write a byte at the given offset, growing the file if necessary,
   * by chunks of 1K bytes (1024 bytes).
   * @param offset
   * @param value
   */
  public void write(int offset, byte value) {
    if (offset >= bytes.length) {
      int len = (offset+1024) & ~(1024-1);
      byte[] tmp = new byte[len];
      System.arraycopy(bytes, 0, tmp, 0, bytes.length);
      bytes = tmp;
    }
    bytes[offset++] = value;
    if (offset>nbytes)
      nbytes = offset;
  }

  /**
   * Reading the byte at the given offset, 
   * for valid offset between 0 and size().
   * @param offset
   * @return byte at offset or -1 if offset is illegal.
   * @throws end-of-file exception if the offset is passed the end of the file
   */
  public byte read(int offset) throws EOFException {
    if (offset >= nbytes) 
      throw new EOFException();
    return bytes[offset];
  }

}
