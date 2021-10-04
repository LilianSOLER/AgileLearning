package basics.step4;

public class Line {
  Point start;
  Point end;
  
  /*
   * Translating a line is just translating both points.
   */
  void translate(int dx, int dy) {
    this.start.translate(dx, dy);
    this.end.translate(dx, dy);
  }

  /*
   * Rotating a line is just translating the end point.
   */
  void rotate(int dx, int dy) {
    this.end.translate(dx, dy);
  }
}
