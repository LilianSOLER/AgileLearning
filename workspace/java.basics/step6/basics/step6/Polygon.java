package basics.step6;

import java.io.PrintStream;

public class Polygon {
  Point[] points;
  Polygon(Point pts[]) {
    points = pts;
  }
  
  /*
   * Tells if the this polygon and the given polygon 
   * are the same mathematical polygon, that is, 
   * if they have their points at the same position
   */
  boolean same(Polygon p) {
    if (points.length!= p.points.length)
      return false;
    for (int i=0;i<points.length;i++)
      if (!points[i].same(p.points[i]))
        return false;
    return true;
  }

  void translate(int dx, int dy) {
    for (int i=0;i<points.length;i++)
      points[i].translate(dx, dy);
  }

  static void print(PrintStream ps,Point p) {
    ps.print('(');
    ps.print(p.x);
    ps.print(',');
    ps.print(p.y);
    ps.print(')');
  }
  
  void print(PrintStream ps) {
    for (int i=0;i<points.length;i++)
      print(ps,points[i]);
  }
}
