package object.classes.ex1;

import object.classes.ex2.Zorg;

public class MainEx1 {

  public static void main(String[] args) {
    
    Foo f = new Foo(999,'x');
    String s = f.toString();
    
    f = new Bar(3.4F,'z');
    s = f.toString();
    
    f = new Bar(2,3);
    s = f.toString();
    
    f = new Zorg(2,3);
    s = f.toString();
    
    guessWhichMethod1();
    guessWhichMethod2();
    guessWhichMethod3();
    guessWhichMethod4();
    guessWhichMethod5();
    
    dumpClasses();

  }

  static void guessWhichMethod1() {
    int v = 3;
    Foo f = new Foo(1, 'F');

    f.method(v); // which method will execute?
  }

  static void guessWhichMethod2() {
    int v = 3;
    Foo f = new Bar(1, 2);

    f.method(v); // which method will execute?
  }

  static void guessWhichMethod3() {
    int v = 3;
    Foo f = new Bar(1, 2);

    f.method(-v); // which method will execute?
  }

  static void guessWhichMethod4() {
    int v = 3;
    Bar b = new Bar(1, 2);

    b.method(-v); // which method will execute?
  }

  static void guessWhichMethod5() {
    int v = 3;
    Foo f = new Zorg(1, 2);

    f.method(-v); // which method will execute?
    
    if (f instanceof Zorg) {
      Zorg z = (Zorg)f;
      z.method(-v); // which method will execute?
    }
  }

  static void dumpClasses() {

    Foo f = new Foo(999,'x');
    Class cls = f.getClass();
    Util.dumpClassOf(System.out, cls);
    
    f = new Bar(3.4F,'z');
    cls = f.getClass();
    Util.dumpClassOf(System.out, cls);
    
    f = new Bar(2,3);
    cls = f.getClass();
    Util.dumpClassOf(System.out, cls);
    
    f = new Zorg(2,3);
    cls = f.getClass();
    Util.dumpClassOf(System.out, cls);
  }

}
