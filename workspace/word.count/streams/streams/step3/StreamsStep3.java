package streams.step3;

import java.io.EOFException;
import java.io.IOException;
import java.util.Random;

public class StreamsStep3 {

  static public void main(String[] args) throws EOFException, IOException {
    System.out.println("StreamStep3...");
    test00();
    test01();
    test02();
    System.out.println("That's all folks.");
    System.exit(0);
  }
  
  static void test00() throws EOFException, IOException  {

    Random rand = new Random();
    InMemoryFile file = new InMemoryFile();
    FileOutputStream os = new FileOutputStream(file);
    int size = rand.nextInt(1000) + 64;
    for (int i = 0; i < size; i++)
      os.write((byte)i);
    System.out.printf(" - wrote %d bytes\n",size);
    
    FileInputStream is = new FileInputStream(file); 
    int length = is.available();
    if (length != size)
      throw new Error("FILE ERROR");
    for (int i = 0; i < length; i++) {
      byte b = is.read();
      if ((byte)i != b)
        throw new Error("FILE ERROR");
    }
    System.out.printf(" - read %d bytes\n",length);
    for (int i = 0; i < length; i++) {
      is.seek(i);
      byte b = is.read();
      if ((byte)i != b)
        throw new Error("FILE ERROR");
    }
    System.out.printf(" - seek & read %d bytes\n",length);
  }

  static void test01() throws EOFException, IOException {

    Random rand = new Random();
    InMemoryFile file = new InMemoryFile();
    FileOutputStream os = new FileOutputStream(file);
    DataOutputStream dos = new DataOutputStream(os);
    int size = rand.nextInt(1000) + 64;
    for (int i = 0; i < size; i++)
      dos.writeInt(i);
    System.out.printf(" - wrote %d integers\n",size);
    
    FileInputStream is = new FileInputStream(file); 
    DataInputStream dis = new DataInputStream(is);
    int length = is.available();
    if (length != 4*size)
      throw new Error("FILE ERROR");
    for (int i = 0; i < size; i++) {
      int value = dis.readInt();
      if (i != value)
        throw new Error("FILE ERROR");
    }
    System.out.printf(" - read %d integers\n",size);
    for (int i = 0; i < size; i++) {
      is.seek(4*i);
      int value = dis.readInt();
      if (i != value)
        throw new Error("FILE ERROR");
    }
    System.out.printf(" - seek & read %d integers\n",size);
  }

  static void test02() throws EOFException, IOException {

    InMemoryFile file = new InMemoryFile();
    FileOutputStream os = new FileOutputStream(file);
    DataOutputStream dos = new DataOutputStream(os);
    
    dos.writeUTF("Un été à la plage.");
    dos.writeUTF("L'hiver à la montage.");
    dos.writeUTF("L'écologie et l'économie doivent s'associer à l'avenir.");
    
    FileInputStream is = new FileInputStream(file); 
    DataInputStream dis = new DataInputStream(is);
    for (int i = 0; !dis.endOfStream(); i++) {
      String s = dis.readUTF();
      System.out.println(" \""+s+"\"");
    }
  }

}
