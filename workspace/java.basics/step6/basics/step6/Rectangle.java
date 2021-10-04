package basics.step6;

/*
 * A class that represents the concept of a rectangle,
 * positioned at the coordinates (x,y)
 * and dimensioned by (width,height).
 */
public class Rectangle {
  int x, y, width, height;

  Rectangle(int x, int y, int w, int h) {
    this.x = x;
    this.y = y;
    width = w;
    height = h;
  }

  void translate(int dx, int dy) {
    x += dx;
    y += dy;
  }

  void stretch(int dw, int dh) {
    width += dw;
    height += dh;
  }

  boolean contains(Point p) {
    if (p.x < x || p.x >= (x + width))
      return false;
    if (p.y < y || p.y >= (y + height))
      return false;
    return true;
  }

}