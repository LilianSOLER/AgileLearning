package object.collections.step1;

public class Line {
  public Point start;
  public Point end;

  /*
   * Translating a line is just translating both points.
   */
  public void translate(int dx, int dy) {
    this.start.translate(dx, dy);
    this.end.translate(dx, dy);
  }

  /*
   * Rotating a line is just translating the end point.
   */
  public void rotate(int dx, int dy) {
    this.end.translate(dx, dy);
  }

}
