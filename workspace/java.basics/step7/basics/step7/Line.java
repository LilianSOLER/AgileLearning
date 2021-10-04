package basics.step7;

import java.awt.Graphics;

public class Line {
  Point p1;
  Point p2;

  Line(Point p1, Point p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

  /*
   * Translating a line is just translating both points.
   */
  void translate(int dx, int dy) {
    p1.translate(dx, dy);
    p2.translate(dx, dy);
  }

  /*
   * Orienting a line is just translating the end point.
   */
  void orient(int dx, int dy) {
    p2.translate(dx, dy);
  }

  /*
   * Draw this line on the screen through the Graphics object,
   * applying a translation to the given origin.
   */
  public void draw(Graphics g, Point origin) {
    int x1, y1, x2, y2;
    x1 = (int) (p1.x + origin.x);
    y1 = (int) (p1.y + origin.y);
    x2 = (int) (p2.x + origin.x);
    y2 = (int) (p2.y + origin.y);

    /*
     * Draws a line on the screen, using the Graphics object.
     * This is the nicest thing about object, if you know their
     * behavior, what they can do, that all you need to know to use
     * them. Isn't that cool or what?
     */
    g.drawLine(x1, y1, x2, y2);
    return;
  }
}
