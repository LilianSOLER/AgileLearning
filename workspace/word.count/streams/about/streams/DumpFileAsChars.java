package about.streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DumpFileAsChars {
  
  public static void main(String[] args) {
    String name;
    if (args.length==0)
      name = "fileWithBytes";
    else
      name = args[0];
      
    try {
      System.out.println("================================================================================");
      System.out.println("Dumping Character Values:");
      System.out.println("================================================================================");
      readCharacters(name);
    } catch(IOException ex) {
      ex.printStackTrace(System.err);
      System.exit(-1);
    }
  }
  
  static void readCharacters(String name) throws IOException {
    File file = new File(name);
    InputStream is = new FileInputStream(file);
    int count = 0;
    int length = is.available();
    for (int i=0;i < length;i++) {
      char c = (char)is.read();
      System.out.printf(" %c",c);
      if (++count==16) {
        System.out.println();
        count = 0;
      }
    }
    is.close();
  }
  
}
