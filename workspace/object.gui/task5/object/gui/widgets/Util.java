package object.gui.widgets;

import object.gui.Component;
import object.gui.window.Color;
import object.gui.window.Graphics;

public class Util {


  /**
   * Paints a shadow as if the component was slightly 
   * above the parent's surface.
   * @param g
   */
  static public void paintRaisedComponentShadow(Graphics g, Component c) {
    int width = c.width();
    int height = c.height();
    Color c1, c2;
    c1 = Color.white;
    c2 = Color.black;
    g.setColor(c1);
    g.drawLine(0, 0, width - 1, 0);
    g.drawLine(0, 0, 0, height - 1);
    g.setColor(c2);
    g.drawLine(width - 1, 0, width - 1, height - 1);
    g.drawLine(0, height - 1, width - 1, height - 1);
  }

  /**
   * Paints a shadow as if the component was slightly 
   * below the parent's surface.
   * @param g
   */
  static public void paintDepressedComponentShadow(Graphics g, Component c) {
    int width = c.width();
    int height = c.height();
    Color c1, c2;
    c2 = Color.white;
    c1 = Color.black;
    g.setColor(c1);
    g.drawLine(0, 0, width - 1, 0);
    g.drawLine(0, 0, 0, height - 1);
    g.setColor(c2);
    g.drawLine(width - 1, 0, width - 1, height - 1);
    g.drawLine(0, height - 1, width - 1, height - 1);
  }

}
