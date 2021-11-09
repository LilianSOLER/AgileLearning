package streams.step2;

public class OutputStream {
  private byte[] buffer;
  private int position;

  /**
   * Constructs an output stream with an initial capacity
   * of the given number of bytes.
   * 
   * @param nbytes is the initial capacity in bytes
   */
  public OutputStream(int nbytes) {
    buffer = new byte[nbytes];
    position = 0;
  }

  /**
   * @return the current size of this output stream,
   * that is, the number of bytes it contains.
   */
  public int getSize() {
   return buffer.length;
  }
  
  /**
   * Returns the buffer, without making a copy.
   * This method must permit to alias the buffer.
   * Note: this method does not need to be public,
   * it is used by the class InputStream
   */
  byte[] getBuffer() { 
    return buffer;
  }
  
  /**
   * Writes the given byte into this stream
   */
  public void write(byte value) {
	  if (position >= this.getSize()) {
			byte[] tmp = new byte[position+1];
			for(int i = 0; i < position; i++) {
				tmp[i] = buffer[i];
			}
			buffer = tmp;
		}
		buffer[position] = value;
		position++;
  }
}
