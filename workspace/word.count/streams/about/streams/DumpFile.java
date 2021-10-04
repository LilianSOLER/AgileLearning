package about.streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DumpFile {
  
  public static void main(String[] args) {
    String name;
    if (args.length==0)
      name = "fileWithBytes";
    else
      name = args[0];
      
    try {
      System.out.println("================================================================================");
      System.out.println("Dumping Unsigned Byte Values:");
      System.out.println("================================================================================");
      readUnsignedValues(name);
      System.out.println("\n================================================================================");
      System.out.println("Dumping Signed Byte Values:");
      System.out.println("================================================================================");
      readSignedValues(name);
      System.out.println("\n================================================================================");
    } catch(IOException ex) {
      ex.printStackTrace(System.err);
      System.exit(-1);
    }
  }
  
  static void readSignedValues(String name) throws IOException {
    File file = new File(name);
    InputStream is = new FileInputStream(file);
    int offset = 0;
    int length = is.available();
    for (int i=0;i < length;i++) {
      byte value = (byte)is.read();
      System.out.printf(" %4d",value);
      if (++offset==16) {
        System.out.println();
        offset = 0;
      }
    }
    is.close();
  }
  
  static void readUnsignedValues(String name) throws IOException {
    File file = new File(name);
    InputStream is = new FileInputStream(file);
    int offset = 0;
    int length = is.available();
    for (int i=0;i < length;i++) {
      int value = is.read();
      System.out.printf(" %4d",value);
      if (++offset==16) {
        System.out.println();
        offset = 0;
      }
    }
    is.close();
  }

}
