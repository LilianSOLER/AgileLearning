package object.collections.step1;

/**
 * A class that represents the concept of a point, positioned at the coordinates
 * (x,y) on a plane.
 */
public class Point {
  public int x, y;

  public void translate(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }
}
