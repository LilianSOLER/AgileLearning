package object.collections.step2;

import java.util.Random;

public class ListTest {

  static Random rand = new Random();

  public static void ensure(boolean cond, String msg) {
    if (!cond)
      throw new RuntimeException(msg);
  }

  public static void ensure(boolean cond) {
    if (!cond)
      throw new RuntimeException("Failed assert.");
  }

  static void echoElapsed(long elapsed) {
    if (elapsed > 1000000L) {
      double f = (double) elapsed / 1000000.0;
      System.out.printf("Elapsed: %.2fms\n", f);
    } else if (elapsed > 1000L) {
      double f = (double) elapsed / 1000.0;
      System.out.printf("Elapsed: %.2fus\n", f);
    } else
      System.out.println("Elapsed: " + elapsed + "ns");
  }

  public static void main(String args[]) {
    try {
      long start = System.nanoTime();
      test0();
      test00();
      test1();
      test2();
      test3();
      System.out.println("List tests: PASSED");

      test4();
      System.out.println("Iterator tests: PASSED");

      long end = System.nanoTime();
      echoElapsed(end - start);

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

    List l = new List();
    for (int i = 0; i < length; i++)
      l.insertAt(l.length(), elements[i]);

    ensure(l.length() == length);

    for (int i = 0; i < length; i++)
      ensure(elements[i] == l.elementAt(i));

    for (int i = 0; i < length; i++)
      ensure(elements[i] == l.updateAt(i, elements[length - i - 1]));

    for (int i = 0; i < length; i++)
      ensure(elements[length - i - 1] == l.elementAt(i));

  }
  
  static void test00() throws Exception {

    int length = 10 + rand.nextInt(100);
    Object[] elements = new Object[length];
    for (int i = 0; i < length; i++)
      elements[i] = new Integer(i);

    List l = new List();
    for (int i = 0; i < length; i++)
      l.insertAt(0, elements[length-1-i]);

    ensure(l.length() == length);

    for (int i = 0; i < length; i++)
      ensure(elements[i] == l.elementAt(i));

    for (int i = 0; i < length; i++)
      ensure(elements[i] == l.updateAt(i, elements[length - i - 1]));

    for (int i = 0; i < length; i++)
      ensure(elements[length - i - 1] == l.elementAt(i));

  }


  static void test1() throws Exception {

    Object[] elements = new Object[1000];
    for (int i = 0; i < 100; i++)
      elements[i] = new Integer(i);

    List l = new List();
    for (int i = 0; i < 1000; i++)
      l.insertAt(l.length(), elements[i]);

    ensure(l.length() == 1000);

    for (int i = 0; i < 1000; i++)
      ensure(elements[i] == l.elementAt(i));

    for (int i = 998; i >= 0; i -= 2)
      l.removeAt(i);

    ensure(l.length() == 500);

    for (int i = 0; i < 500; i++)
      ensure(elements[2 * i + 1] == l.elementAt(i));

  }

  static void test2() throws Exception {

    List l = new List();
    for (int i = 0; i < 1000; i += 2)
      l.insertAt(i, new Integer(i));

    ensure(l.length() == 999);

    for (int i = 0; i < 999; i += 2)
      ensure(new Integer(i).equals(l.elementAt(i)));

    for (int i = 1; i < 999; i += 2)
      ensure(l.elementAt(i) == null);

  }

  static void test3() throws Exception {

    Object[] elements = new Object[1000];
    for (int i = 0; i < 100; i++)
      elements[i] = new Integer(i);

    List l = new List();
    for (int i = 0; i < 1000; i++)
      l.insertAt(i, elements[i]);

    for (int i = 999; i >= 500; i--)
      ensure(elements[i] == l.removeAt(i));

    ensure(l.length() == 500);

    l.insertAt(999, elements[999]);

    ensure(l.length() == 1000);

    for (int i = 0; i < 500; i++)
      ensure(elements[i] == l.elementAt(i));

    for (int i = 500; i < 999; i++)
      ensure(l.elementAt(i) == null);

    ensure(elements[999] == l.elementAt(999));

    for (int i = 999; i >= 500; i--)
      l.removeAt(i);
    ensure(l.length() == 500);

    for (int i = 0; i < 500; i++)
      l.removeAt(0);
    ensure(l.length() == 0);

    l = new List();
    for (int i = 0; i < 1000; i++)
      l.insertAt(i, elements[i]);
    
    for (int i = 999; i >= 0; i-=2)
      ensure(l.remove(elements[i]));
    ensure(l.length() == 500);

    for (int i = 998; i >= 0; i-=2)
      ensure(l.remove(elements[i]));
    ensure(l.length() == 0);
  }

  static void test4() throws Exception {

    Object[] elements = new Object[100];
    for (int i = 0; i < 100; i++)
      elements[i] = new Integer(i);

    List l = new List();
    for (int i = 0; i < 100; i++)
      l.insertAt(l.length(), elements[i]);

    ensure(l.length() == 100);

    List.Iterator iter = l.iterator();
    int i = 0;
    while (iter.hasNext()) {
      Object elem = iter.next();
      ensure(elements[i] == elem);
      ensure(elem == l.elementAt(i));
      i++;
    }
    ensure(i==elements.length);
  }

}
