package object.classes.ex1;

public class Bar extends Foo {

  float a;
  int b;

  Bar(int a, int b) {
    super(-1, 'b');
    this.a = (float) a;
    this.b = b;
  }

  Bar(float a, int b) {
    super.b = 'b';
    this.a = a;
    this.b = b;
  }

  int method(int x) {
    return x;
  }

  @Override
  public float method(float x) {
    if (x > 0)
      return (int) (a * x + b);
    else
      return super.method(x);
  }

}
