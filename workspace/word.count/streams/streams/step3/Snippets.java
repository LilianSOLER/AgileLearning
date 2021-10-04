package streams.step3;

public class Snippets {

  static short snippetA(short s1) {

    // let's decompose the short value in two bytes
    byte b1 = (byte) ((s1 >> 8) & 0xFF);
    byte b2 = (byte) (s1 & 0xFF);

    // let's recompose the short value from those two bytes
    int i = ((b1 << 8) & 0xFF00) | b2;
    short s2 = (short) i;
    return s2;
  }

  static short snippetB(short s1) {
    // let's decompose the short value in two bytes
    byte b1 = (byte) ((s1 >> 8) & 0xFF);
    byte b2 = (byte) ((s1 >> 0) & 0xFF);

    // let's re-compose the short value from those two bytes
    int i1 = ((b1 << 8) & 0xFF00);
    int i2 = b2;
    int i = i1 | i2;
    short s2 = (short) i;
    return s2;
  }

  static short snippetC(short s1) {
    // let's decompose the short value in two bytes
    byte b1 = (byte) ((s1 >> 8) & 0xFF);
    byte b2 = (byte) ((s1 >> 0) & 0xFF);

    // let's re-compose the short value from those two bytes
    int i1 = ((b1 << 8) & 0xFF00);
    int i2 = b2 & 0xFF;
    int i = i1 | i2;
    short s2 = (short) i;
    return s2;
  }

  static short snippetD(short s1) {
    // let's decompose the short value in two bytes
    byte b1 = (byte) ((s1 >> 8) & 0xFF);
    byte b2 = (byte) ((s1 >> 0) & 0xFF);

    // let's re-compose the short value from those two bytes
    int i = ((b1 << 8) & 0xFF00) | (b2 & 0xFF);
    return (short) i;
  }

  static void checkAllValues() {
    short s1, s2;
    for (s1 = Short.MIN_VALUE; s1 < Short.MAX_VALUE; s1++) {
      s2 = snippetD(s1);
      if (s1 != s2) {
        System.err.println(s1 + " != " + s2);
        System.exit(-1);
      }
    }
    s2 = snippetD(s1);
    if (s1 != s2) {
      System.err.println(s1 + " != " + s2);
      System.exit(-1);
    }
  }

  static void check(String prefix, short s1, short s2) {
    if (s1 != s2)
      System.out.println(prefix + ": " + s1 + " != " + s2);
    else
      System.out.println(prefix + ": " + s1 + " == " + s2);
  }

  public static void main(String args[]) {
    short s1, s2;
    s1 = -2;
    s2 = snippetA(s1);
    check("snippetA", s1, s2);
    s1 = 0x1FE;
    s2 = snippetA(s1);
    check("snippetA", s1, s2);

    s1 = -2;
    s2 = snippetB(s1);
    check("snippetB", s1, s2);
    s1 = 0x1FE;
    s2 = snippetB(s1);
    check("snippetB", s1, s2);

    s1 = -2;
    s2 = snippetC(s1);
    check("snippetC", s1, s2);
    s1 = 0x1FE;
    s2 = snippetC(s1);
    check("snippetC", s1, s2);

    checkAllValues();
    System.out.println("Done.");
  }
}
