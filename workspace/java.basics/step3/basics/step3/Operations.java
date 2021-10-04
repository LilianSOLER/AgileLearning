package basics.step3;

public class Operations {

  /*
   * Translating a point.
   */
  static void translate(Point self, int dx, int dy) {
    self.x += dx;
    self.y += dy;
  }

  /*
   * Translating a line is just translating both points.
   */
  static void translate(Line self, int dx, int dy) {
    translate(self.start,dx, dy);
    translate(self.end,dx, dy);
  }

  /*
   * Rotating a line is just translating the end point.
   */
  static void rotate(Line self, int dx, int dy) {
    translate(self.end,dx, dy);
  }


}
