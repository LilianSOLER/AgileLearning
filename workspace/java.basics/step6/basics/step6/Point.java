package basics.step6;

/*
 * A class that represents the concept of a point,
 * positioned at the coordinates (x,y)
 */
public class Point {
  int x, y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  Point(Point p) {
    x = p.x;
    y = p.y;
  }

  void translate(int dx, int dy) {
    x += dx;
    y += dy;
  }

  /*
   * Tells if this point and the given point 
   * are at the same location (x,y).
   */
  boolean same(Point p) {
    return (x == p.x) && (y == p.y);
  }

}