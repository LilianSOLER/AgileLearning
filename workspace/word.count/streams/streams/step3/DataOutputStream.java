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
	int a = Float.floatToIntBits(value);
    writeInt(a);
  }

  /**
   * Writes a 4-byte signed integer value
   * at the current offset, increasing 
   * the current offset accordingly.
   * @throws IOException if an internal error occurs
   */
  public void writeInt(int value) throws IOException {
    // TODO
	int l = 4;
    for(int i = 0; i < l; i++) {
    	byte b = (byte)  ((value >> ((8) * ((l - 1) - i))) & 0xFF);
    	os.write(b);
    }
  }
  
  /**
   * Writes a 2-byte signed integer value
   * at the current offset, increasing 
   * the current offset accordingly.
   * @throws IOException if an internal error occurs
   */
  public void writeShort(short value) throws IOException {
    // TODO
	  int l = 2;
	    for(int i = 0; i < l; i++) {
	    	byte b = (byte)  ((value >> ((8) * ((l - 1) - i))) & 0xFF);
	    	os.write(b);
	    }
  }

  /**
   * Writes the given boolean value
   * at the current offset, increasing 
   * the current offset accordingly.
   * @throws IOException if an internal error occurs
   */
  public void writeBoolean(boolean value) throws IOException {
    // TODO
	os.write((byte) (value ? 1 : 0));
  }

  /**
   * Writes a UTF-8 encoded character 
   * at the current offset, increasing 
   * the current offset accordingly.
   * @throws IOException if an internal error occurs
   */
  public void writeChar(char c) throws IOException {
    // TODO
	os.write((byte) c);
  }

  /**
   * Writes a string of UTF-8 encoded characters 
   * at the current offset, increasing 
   * the current offset accordingly.
   * @throws IOException if an internal error occurs
   */
  public void writeUTF(String s) throws IOException {
    // TODO
    int slen = s.length();
    
    int ulen = 0;
    int ch;
    for(int i = 0; i < slen; i++) {
    	ch = s.charAt(i);
    	if ((ch >= 0x0001) && (ch <= 0x007F)) {
            ulen++;
        } else {
        	if (ch > 0x07FF) {
                ulen += 3;
            } else {
                ulen += 2;
            }
        }
    }
    writeShort((short) ulen);
    
    for(int i = 0; i < slen; i++) {
    	ch = s.charAt(i);
    	if ((ch >= 0x0001) && (ch <= 0x007F)) {
            os.write((byte) ch);
        } else {
        	if (ch > 0x07FF) {
        		os.write((byte) (0xE0 | ((ch >> 12) & 0x0F)));
                os.write((byte) (0x80 | ((ch >>  6) & 0x3F)));
                os.write((byte) (0x80 | ((ch >>  0) & 0x3F)));
            } else {
            	os.write((byte) (0xC0 | ((ch >>  6) & 0x1F)));
                os.write((byte) (0x80 | ((ch >>  0) & 0x3F)));
            }
          }
    }
  }
}
