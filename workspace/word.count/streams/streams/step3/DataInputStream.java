package streams.step3;

import java.io.IOException;
import java.io.UTFDataFormatException;

/**
 * This is an data input stream that wraps an input-stream,
 * allowing to read Java types as possible to signed bytes
 * 
 * @author Pr. Olivier Gruber.
 */

public class DataInputStream {
  FileInputStream is;

  DataInputStream(FileInputStream is) {
    this.is = is;
  }

  /**
   * @return true if the end of the stream has been reached,
   *         false otherwise.
   */
  public boolean endOfStream() throws IOException {
    return is.available()==0;
  }

  private int readUnsigned() throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }

  /**
   * Reads a 4-byte signed float value
   * at the current offset, increasing 
   * the current offset accordingly.
   * @return the re-composed signed value
   * @throws IOException if an internal error occurs
   */
  public float readFloat() throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }

  /**
   * Reads a 4-byte signed integer value
   * at the current offset, increasing 
   * the current offset accordingly.
   * @return the re-composed signed value
   * @throws IOException if an internal error occurs
   */
  public int readInt() throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }

  /**
   * Reads a 2-byte signed integer value
   * at the current offset, increasing 
   * the current offset accordingly.
   * @return the re-composed signed value
   * @throws IOException if an internal error occurs
   */
  public short readShort() throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }

  /**
   * @return a boolean value.
   * @throws IOException if an internal error occurs
   */
  public boolean readBoolean() throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }

  /**
   * Reads a UTF-8 encoded character 
   * at the current offset, increasing 
   * the current offset accordingly.
   * @return the read character
   * @throws IOException if an internal error occurs
   */
  public char readChar() throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }

  /**
   * Reads a string of UTF-8 encoded characters 
   * at the current offset, increasing 
   * the current offset accordingly.
   * @return the read string
   * @throws IOException if an internal error occurs
   */
  public String readUTF() throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }

}
