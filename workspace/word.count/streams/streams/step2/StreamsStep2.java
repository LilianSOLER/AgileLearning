package streams.step2;

import java.io.EOFException;
import java.util.Random;

public class StreamsStep2 {

  static public void main(String[] args) throws EOFException {
    System.out.println("StreamStep2...");
    Random rand = new Random();
    OutputStream os = new OutputStream(64);
    int size = rand.nextInt(1000) + 64;
    for (int i = 0; i < size; i++)
      os.write((byte)i);
    System.out.printf(" - wrote %d bytes\n",size);
    assert(size==os.getSize());
    
    InputStream is = new InputStream(os); 
    assert(size==is.getSize());
    for (int i = 0; i < is.getSize(); i++)
      assert ((byte)i == is.read());
    System.out.printf(" - read %d bytes\n",size);
    System.out.println("That's all folks.");
    System.exit(0);
  }

}
