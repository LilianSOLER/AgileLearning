package streams.step3;

import java.io.IOException;

/**
 * This is an input stream that wraps a in-memory file,
 * allowing to process the file as a stream of signed bytes.
 * 
 * @author Pr. Olivier Gruber.
 */

public class FileOutputStream {
  private InMemoryFile file;
  private int offset;

  public FileOutputStream(InMemoryFile file) {
    this.file = file;
    this.offset = 0;
  }

  /**
   * @return the overall size of the steam.
   * @throws IOException if an internal error happens
   */
  public int size() throws IOException {
    return file.size();
  }

  /**
   * Set the position in the file at the given offset.
   * NOTA BENE: the given offset can be beyond the current end of the file.
   * @param offset
   * @throws IOException if an internal error happens
   */
  public void seek(int offset) throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }

  /**
   * Write at the given offset the given byte value.
   * NOTA BENE: if the offset is passed the current end of
   * the file, the end of the file is moved accordingly
   * and the write happens at the given offset.  
   * @param value
   * @throws IOException if an internal error happens
   */
  public void write(byte value) throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }
  
  public void write(byte[] bytes, int start, int length) throws IOException {
    for (int i=0; i < length; i++)
      write(bytes[start+i]);
  }

}
