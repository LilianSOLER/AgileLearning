package about.streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CharFile {

  static void write(OutputStream os, int value) throws IOException {
    os.write((value >>> 24) & 0xFF);
    os.write((value >>> 16) & 0xFF);
    os.write((value >>>  8) & 0xFF);
    os.write((value >>>  0) & 0xFF);
  }
  
  static void writeChar(OutputStream os, char c) throws IOException {
    int value = (int)c;
    os.write((value >>>  8) & 0xFF);
    os.write((value >>>  0) & 0xFF);    
  }
  
  static void write(OutputStream os, String s) throws IOException {
    int length = s.length();
    write(os,length);
    for (int i=0;i < length;i++)
      writeChar(os,s.charAt(i));
  }

  static int readInt(InputStream is) throws IOException {
    int byte1 = is.read();
    int byte2 = is.read();
    int byte3 = is.read();
    int byte4  = is.read();
    return ((byte1 << 24) + (byte2 << 16) + (byte3 << 8) + (byte4 << 0));
}

  static char readChar(InputStream is) throws IOException {
    int byte1 = is.read();
    int byte2 = is.read();
    int value = ((byte1 << 8) + (byte2 << 0));
    return (char)value;
}

  static String read(InputStream is) throws IOException {
    int length = readInt(is);
    char[] chars = new char[length];
    for (int i=0;i < length;i++) {
      chars[i] = readChar(is);
    }
    return new String(chars);
  }

  public static void main(String[] args) {
    try {
      if (args.length==0) 
        args = new String[] {"un", "deux", "trois" };
      System.out.println("Writing given string arguments to the file 'file.txt':");
      File file = new File("file.txt");
      OutputStream os = new FileOutputStream(file);
      for (int i=0;i<args.length;i++) 
        write(os,args[i]);
      os.close(); // always close the stream when you are done writing.
      
      System.out.println("Reading back the strings from the same file:");
      String s;
      InputStream is = new FileInputStream(file);
      for (int i=0;i<args.length;i++) { 
        s = read(is);
        System.out.println(" "+s);
      }      
      is.close(); // always close the stream when you are done reading.
      System.out.println("Done.");
    } catch(IOException ex) {
      ex.printStackTrace(System.err);
      System.exit(-1);
    }
  }

}
