package object.classes.ex1;

public class Foo extends Object {
  private int a;
  protected char b;

  protected Foo() {
    init(0, ' ');
  }
  
  public Foo(int a, char b) {
    init(a, b);
  }

  private void init(int a, char b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public String toString() {
    return "Foo"+b+a;
  }

  public float method(float x) {
    return a*x;
  }

}
