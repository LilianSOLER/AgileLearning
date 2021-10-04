package object.collections.step1;

import java.util.Random;

public class VectorTest {

  static Random rand = new Random();

  public static void ensure(boolean cond, String msg) {
    if (!cond)
      throw new RuntimeException(msg);
  }

  public static void ensure(boolean cond) {
    if (!cond)
      throw new RuntimeException("Failed assert.");
  }

  public static void main(String args[]) {
    try {
      test0();
      test1();
      test2();
      test3();
      System.out.println("Vector tests: PASSED");
      
      test4();
      System.out.println("Iterator tests: PASSED");
      
    } catch (Throwable th) {
      th.printStackTrace(System.err);
      System.err.println("Test: FAILED");
    }
  }

  static void test0() throws Exception {

    int length = 10 + rand.nextInt(100);
    Object[] elements = new Object[length];
    for (int i = 0; i < length; i++)
      elements[i] = new Integer(i);

    Vector v = new Vector();
    for (int i = 0; i < length; i++)
      v.insertAt(v.length(), elements[i]);

    ensure(v.length() == length);

    for (int i = 0; i < length; i++)
      ensure(elements[i] == v.elementAt(i));

    for (int i = 0; i < length; i++)
      ensure(elements[i] == v.updateAt(i, elements[length - i - 1]));

    for (int i = 0; i < length; i++)
      ensure(elements[length - i - 1] == v.elementAt(i));

  }

  static void test1() throws Exception {

    Object[] elements = new Object[1000];
    for (int i = 0; i < 100; i++)
      elements[i] = new Integer(i);

    Vector v = new Vector();
    for (int i = 0; i < 1000; i++)
      v.insertAt(v.length(), elements[i]);

    ensure(v.length() == 1000);

    for (int i = 0; i < 1000; i++)
      ensure(elements[i] == v.elementAt(i));

    for (int i = 998; i >= 0; i -= 2)
      v.removeAt(i);

    ensure(v.length() == 500);

    for (int i = 0; i < 500; i++)
      ensure(elements[2 * i + 1] == v.elementAt(i));

  }

  static void test2() throws Exception {

    Vector v = new Vector();
    for (int i = 0; i < 1000; i += 2)
      v.insertAt(i, new Integer(i));

    ensure(v.length() == 999);

    for (int i = 0; i < 999; i += 2)
      ensure(new Integer(i).equals(v.elementAt(i)));

    for (int i = 1; i < 999; i += 2)
      ensure(v.elementAt(i) == null);

  }

  static void test3() throws Exception {

    Object[] elements = new Object[1000];
    for (int i = 0; i < 100; i++)
      elements[i] = new Integer(i);

    Vector v = new Vector();
    for (int i = 0; i < 1000; i++)
      v.insertAt(i, elements[i]);

    for (int i = 999; i >= 500; i--)
      ensure(elements[i] == v.removeAt(i));

    ensure(v.length() == 500);

    v.insertAt(999, elements[999]);

    ensure(v.length() == 1000);

    for (int i = 0; i < 500; i++)
      ensure(elements[i] == v.elementAt(i));

    for (int i = 500; i < 999; i++)
      ensure(v.elementAt(i) == null);

    ensure(elements[999] == v.elementAt(999));

  }

  static void test4() throws Exception {

    Object[] elements = new Object[100];
    for (int i=0;i<100;i++)
      elements[i] = new Integer(i);
    
    Vector v = new Vector();
    for (int i=0;i<100;i++)
      v.insertAt(v.length(), elements[i]);

    ensure(v.length() == 100);
    
    Vector.Iterator iter=v.iterator();
    int i =0;
    while (iter.hasNext()) {
      Object elem = iter.next();
      ensure(elements[i] == elem);
      ensure(elem == v.elementAt(i));
      i++;
    }
  }

}
