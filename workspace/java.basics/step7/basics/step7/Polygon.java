package basics.step7;

import java.awt.Graphics;
import java.io.PrintStream;

public class Polygon {

  Point[] points;
  int npoints;

  Polygon() {
    points = new Point[4];
    npoints = 0;
  }

  void grow() {
    Point tmp[];
    tmp = new Point[npoints + 4];
    System.arraycopy(points, 0, tmp, 0, npoints);
    points = tmp;
  }

  /*
   * Adds a point at the end
   */
  void add(Point p) {
    if (npoints == points.length)
      grow();
    points[npoints++] = p;
  }

  /*
   * Adds a point at the given index.
   */
  void add(Point p, int idx) {
    if (npoints == points.length)
      grow();
    for (int i = npoints; i > idx; i--)
      points[i] = points[i - 1];

    points[idx] = p;
    npoints++;
  }

  /*
   * Tells if the this polygon and the given polygon 
   * are the same, that is, if they have their points
   * at the same position
   */
  boolean same(Polygon p) {
    if (npoints != p.npoints)
      return false;
    for (int i = 0; i < npoints; i++)
      if (!points[i].same(p.points[i]))
        return false;
    return true;
  }

  void translate(float dx, float dy) {
    for (int i = 0; i < npoints; i++)
      points[i].translate(dx, dy);
  }

  void translate(Point p) {
    for (int i = 0; i < npoints; i++)
      points[i].translate(p);
  }

  static void print(PrintStream ps, Point p) {
    ps.print('(');
    ps.print(p.x);
    ps.print(',');
    ps.print(p.y);
    ps.print(')');
  }

  void print(PrintStream ps) {
    for (int i = 0; i < points.length; i++)
      print(ps, points[i]);
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  public String toString() {
    String s = "[";
    for (int i = 0; i < npoints; i++)
      s += points[i].toString();
    s += "]";
    return s;
  }

  /*
   * Draw this circle on the screen through 
   * the given Graphics object,
   * with the circle center at the given origin.
   */
  void draw(Graphics g, Point origin) {
    if (npoints > 1) {
      Point p1, p2;
      for (int i = 0; i < npoints - 1; i++) {
        p1 = points[i];
        p2 = points[i + 1];
        Line l = new Line(p1, p2);
        l.draw(g, origin);
      }
      p1 = points[npoints - 1];
      p2 = points[0];
      Line l = new Line(p1, p2);
      l.draw(g, origin);
    }
  }
}
