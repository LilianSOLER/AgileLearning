package object.classes.ex2;

import object.classes.ex1.Foo;

public class Zorg extends Foo {

  float a;
  int b;

  public Zorg(int a, int b) {
    init(a,b);
  }

  public Zorg(float a, int b) {
    this.a = a;
    this.b = b;
    super.b = 'x';
  }

  private void init(int a, int b) {
    this.a = (float)a;
    this.b = b;
  }

  int method(int x) {
    return x;
  }

  @Override
  public float method(float x) {
    if (x > 0)
      throw new IllegalArgumentException();
    return super.method(x);
  }

}
