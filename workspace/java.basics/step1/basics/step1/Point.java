package basics.step1;

/**
 * A class that represents the concept of a point, positioned at the coordinates
 * (x,y) on a plane.
 */
public class Point {
  int x, y;
  
  void Point(Point p) {
    this.x = p.x;
    this.y = p.y;
  }

  void translate(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }
  
  void translate(Vector v) {
	  this.x += (int)(v.rho * Math.cos(v.theta));
	  this.y += (int)(v.rho * Math.sin(v.theta));
  }
}
