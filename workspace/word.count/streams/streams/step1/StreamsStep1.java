package streams.step1;

public class StreamsStep1 {

  static public void main(String[] args) {
    System.out.println("StreamStep1...");
    byte[] buffer = new byte[256];
    OutputStream os = new OutputStream(buffer);
    for (int i = 0; i < 255; i++)
      os.write((byte)i);
    InputStream is = new InputStream(buffer);
    for (int i = 0; i < 255; i++)
      assert ((byte)i == is.read());
    System.out.println("That's all folks.");
    System.exit(0);
  }

}
