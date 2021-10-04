package streams.step3;

import java.io.EOFException;
import java.io.IOException;

/**
 * This is an input stream, wrapping an in-memory file.
 * The input stream maintain a current position in the file,
 * as an offset in the sequence of bytes of the file. 
 * When ask to read, it reads the byte at the current position
 * and then increases the position. 
 * 
 * @author Pr. Olivier Gruber
 */
public class FileInputStream {
  private InMemoryFile file;
  private int offset;

  /**
   * Constructs an input stream from the given output stream
   * Do NOT copy the buffer, alias it, so make sure the 
   * method getBuffer permits an alias (makes no copy).
   */
  FileInputStream(InMemoryFile file) {
    this.file = file;
  }

  /**
   * Set the position in the file at the given offset.
   * The offset must be in the range [0,size()[.
   * If the given offset is larger than the size of this stream,
   * it is set at the end of the stream.
   * @param offset
   * @throws IOException if an internal error happens
   */
  public void seek(int offset) throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }
  
  /**
   * @return the overall size of the steam.
   * @throws IOException if an internal error happens
   */
  public int size() throws IOException {
    return file.size();
  }

  /**
   * @return the available number of bytes,
   * from the current position to the end of the stream,
   * If the method returns 0, it means that the end of the stream has been reached. 
   * @throws IOException if an internal error happens
   */
  public int available() throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }

  /**
   * Reads the byte value at the current offset in the file.
   * @return
   * @throws EOFException if the current offset is at the end of the file.
   * @throws IOException if an internal error happens
   */
  public byte read() throws EOFException, IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }
  
  public int read(byte[] bytes, int off, int len) throws EOFException, IOException {
    int count;
    for (count = 0; count < len && file.nbytes-offset>0 ; count++)
      bytes[off+count] = read();
    return count;
  }
}
