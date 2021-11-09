package streams.step1;

public class InputStream {
	private byte[] buffer;
	private int position;

  /**
   * Constructs an input stream from an array of bytes.
   * Do NOT copy the buffer, alias it.
   */
  public InputStream(byte[] buff) {
	buffer = buff;
	position = 0;
  }

  /**
   * Reads the next byte from this input stream. <br>
   * Notice that this suggests a notion of a current position, where to read
   * from. Of course, the current position needs to be advanced.
   * 
   * @return the read byte
   */
  public byte read() {
	position++;
    return buffer[position - 1];
  }
}
