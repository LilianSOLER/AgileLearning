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
	  int a = readInt();
	  return Float.intBitsToFloat(a);
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
	byte b1 = is.read();
	byte b2 = is.read();
	byte b3 = is.read();
	byte b4 = is.read();
	
	int a = (int) (b1 << 24) & 0xFF000000;
	int b = (int) (b2 << 16) & 0x00FF0000;
	int c = (int) (b3 << 8) & 0x0000FF00;
	int d = (int) (b4 << 0) & 0x000000FF;
	return a | b | c | d;
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
	byte b1 = is.read();
	byte b2 = is.read();
	
	return (short) (((b1 << 8) & 0xFF00) | b2);
  }

  /**
   * @return a boolean value.
   * @throws IOException if an internal error occurs
   */
  public boolean readBoolean() throws IOException {
    return is.read() != 0;
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
	return (char) is.read();
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
    int len = readShort();
    byte[] bytes = new byte[len];
    char[] chars = new char[len];
    
    for(int i = 0; i < len; i++) {
    	bytes[i] = is.read();
    	}
    
    int j = 0;
    int k = 0;
    int ch;
    while(j < len) {
    	ch = (int) bytes[j] & 0xff;
    	if(ch > 127) {
    		break;
    	}
    	chars[k++] = (char) ch;
    	j++;    		
    	}
    
    int ch2, ch3;
    while(j < len) {
    	ch = (int) bytes[j] & 0xff;
    	switch(ch >> 4) {
	    	case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:			
    		// Oxxx xxxx
    		case 7: 
    			j++;
    			chars[k++] = (char) ch;
    			break;
    		case 12:
    		//110x xxxx 10xx xxxx
    		case 13:
    			j+= 2;
    			ch2 = (int) bytes[j - 1];
    			chars[k++] = (char) (((ch & 0x1F) << 6) | (ch2 & 0x3F)); 
    			break;
    		case 14:
    			//1110 xxxx 10xx xxxx 10xx xxxx
    			j+= 3;
    			ch2 = (int) bytes[j - 2];
    			ch3 = (int) bytes[j - 1];
    			chars[k++] = (char) (((ch & 0x0F) << 12) | ((ch2 & 0x3F) << 6) | ((ch3 & 0x3F) << 0));
    			break;
    		//10xx xxxx, 1111 xxxx	
    		default:
    			throw new UTFDataFormatException("Problème au bit " + j);
		} 					
    }
    return new String(chars, 0, k);
   }
 }

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
