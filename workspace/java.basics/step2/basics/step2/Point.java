package basics.step2;

/**
 * A class that represents the concept of a point, positioned at the coordinates
 * (x,y) on a plane.
 */
public class Point {
  int x, y;

  void translate(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }
}
