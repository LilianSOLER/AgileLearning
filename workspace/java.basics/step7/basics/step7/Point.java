package basics.step7;

/*
 * A class that represents the concept of a point,
 * positioned at the coordinates (x,y)
 */
public class Point {
  float x, y;

  Point(float x, float y) {
    this.x = x;
    this.y = y;
  }

  Point(Point p) {
    x = p.x;
    y = p.y;
  }

  public String toString() {
    return "(" + x + "," + y + ")";
  }

  void translate(float dx, float dy) {
    x += dx;
    y += dy;
  }

  void translate(Point p) {
    x += p.x;
    y += p.y;
  }

  /*
   * Tells if this point and the given point 
   * are at the same location (x,y).
   */
  boolean same(Point p) {
    return (x == p.x) && (y == p.y);
  }

  double theta() {
    double theta = (x == 0 && y == 0) ? 0.0 : (Math.atan2(y, x) + 2 * Math.PI) % (2 * Math.PI);
    return theta;
  }

  double rho() {
    double rho;
    rho = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    return rho;
  }

}