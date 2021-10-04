package basics.step1;

/**
 * A class that represents the concept of a point, positioned at the coordinates
 * (x,y) on a plane.
 */
public class Point {
  int x, y;

  Point() {
  }

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  void translate(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }
}
