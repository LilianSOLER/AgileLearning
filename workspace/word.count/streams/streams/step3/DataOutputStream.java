package streams.step3;

import java.io.IOException;

/**
 * This is an output stream that wraps a in-memory file,
 * allowing to process the file as a stream of signed bytes.
 * 
 * @author Pr. Olivier Gruber.
 */

public class DataOutputStream {
  FileOutputStream os;
  
  public DataOutputStream(FileOutputStream os) {
    this.os = os;
  }

  /**
   * Writes a 4-byte signed float value
   * at the current offset, increasing 
   * the current offset accordingly.
   * @throws IOException if an internal error occurs
   */
  public void writeFloat(float value) throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }

  /**
   * Writes a 4-byte signed integer value
   * at the current offset, increasing 
   * the current offset accordingly.
   * @throws IOException if an internal error occurs
   */
  public void writeInt(int value) throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }
  
  /**
   * Writes a 2-byte signed integer value
   * at the current offset, increasing 
   * the current offset accordingly.
   * @throws IOException if an internal error occurs
   */
  public void writeShort(short value) throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }

  /**
   * Writes the given boolean value
   * at the current offset, increasing 
   * the current offset accordingly.
   * @throws IOException if an internal error occurs
   */
  public void writeBoolean(boolean value) throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }

  /**
   * Writes a UTF-8 encoded character 
   * at the current offset, increasing 
   * the current offset accordingly.
   * @throws IOException if an internal error occurs
   */
  public void writeChar(char c) throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }

  /**
   * Writes a string of UTF-8 encoded characters 
   * at the current offset, increasing 
   * the current offset accordingly.
   * @throws IOException if an internal error occurs
   */
  public void writeUTF(String s) throws IOException {
    // TODO
    throw new Error("Not Yet Implemented");
  }

}
