package basics.step7;

import java.awt.Graphics;

public class Circle {
  Polygon poly;
  int radius;

  /*
   * Construct a circle with a polygon of only four points. Needless to say
   * that it does not look like a circle, more like a parallelogram... But we
   * will smooth it out into a circle later.
   */
  Circle(int r) {
    Point p;
    poly = new Polygon();
    radius = r;
    p = new Point(radius, 0);
    poly.add(p);
    p = new Point(0, radius);
    poly.add(p);
    p = new Point(-radius, 0);
    poly.add(p);
    p = new Point(0, -radius);
    poly.add(p);
    Counters.nCircles++;
  }

  /*
   * Computes a midway point, on the circle, between two points that are on
   * the circle already. By midway, we mean the point whose rotation angle is
   * the midway angle between the rotation angle of p1 and p2. Example:
   * Assuming a radius of 1.
   * 
   * p1 at 0 degrees (x=1,y=0) p2 at 90 degrees (x=0,y=1) -> p3 at 45 degrees
   * (x=0.707,y=0.707) or p1 at 120 degrees (x=0,y=1) p2 at 180 degrees
   * (x=-1,y=0) -> p3 at 150 degrees (x=-0.866,y=0.499)
   * 
   */
  Point midPoint(Point p1, Point p2) {
    double a1, a2;
    a1 = p1.theta();
    a2 = p2.theta();
    if (a2 < a1)
      a2 += 2 * Math.PI;
    assert (a1 >= 0.0);
    assert (a2 >= 0.0);
    double am = (a1 + a2) / 2.0;
    float mx, my;
    mx = radius * (float) Math.cos(am);
    my = radius * (float) Math.sin(am);
    return new Point(mx, my);
  }

  /*
   * This method improves the smoothness of this circle, 
   * doubling the number of points to the polygon.
   */
  void smoother() {
	long start = System.nanoTime();
    int npoints = poly.npoints;
    Point p1, p2, mp;
    int i;
    for (i = 0; i < npoints - 1; i++) {
      p1 = poly.points[2 * i];
      p2 = poly.points[2 * i + 1];
      mp = midPoint(p1, p2);
      poly.add(mp, 2 * i + 1);
    }
    p1 = poly.points[2 * i];
    p2 = poly.points[0];
    mp = midPoint(p1, p2);
    poly.add(mp);
    long end= System.nanoTime();
    Counters.nCircleSmooths++;
    Counters.elapsedCircleSmooths+=(end-start);
  }

  /*
   * Draw this circle on the screen through the given Graphics object, with
   * the circle center at the given origin.
   */
  void draw(Graphics g, Point origin) {
	  long start = System.nanoTime();
      poly.draw(g, origin);
      long end= System.nanoTime();
      Counters.nCircleDraws++;
      Counters.elapsedCircleDraws+=(end-start);
  }

}
