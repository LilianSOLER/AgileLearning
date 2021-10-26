package about.streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WriteReadFile {

  static void writeFile(int n) throws IOException {
    File file = new File("fileWithBytes");
    OutputStream os = new FileOutputStream(file);
    for (int i=0;i < n;i++)
      os.write(i);
    os.close(); // always close the stream when you are done writing.
  }

  static void readFile(int n) throws IOException {
    File file = new File("fileWithBytes");
    InputStream is = new FileInputStream(file);
    int j=0;
    for (int i=0;i < n;i++,j++) {
      int value = is.read();
      if (j % 16 == 15)
        System.out.printf(" %4d\n",value);
      else
        System.out.printf(" %4d",value);
    }
    is.close(); // always close the stream when you are done reading.
  }

  public static void main(String[] args) {
    try {
      int n = 300;
      // writing something first, before reading it back.
      writeFile(n);
      // re-reading what we wrote earlier.
      readFile(n);
      System.out.println("\nDone.");
    } catch(IOException ex) {
      ex.printStackTrace(System.err);
      System.exit(-1);
    }
  }
  
}
