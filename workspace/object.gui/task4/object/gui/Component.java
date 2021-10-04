package object.gui;

import object.gui.window.Color;
import object.gui.window.Graphics;

/**
 * This is a mock class, here only to allow the other classes
 * to compile... This needs to be replaced by your implementation
 * done in the previous task (task3).
 * 
 * @author Pr. Olivier Gruber  (olivier dot gruber at acm dot org)
 */

public class Component {

  protected Container m_parent;
  protected int m_x, m_y, m_width, m_height;
  protected Color m_bgColor; // background color
  protected Color m_fgColor; // foreground color
  protected Dimension m_prefSize;
  
  public Dimension getPreferredSize() { return null; }
  public void setPreferredSize(Dimension d) {
  }
  public void setPreferredSize(int w, int h) {}
  public Component() {
  }
  public Component(Container parent) {}
  public String getName() {
    return null;
  }
  public void setName(String name) {
  }
  public void setBackgroundColor(Color c) {
  }
  public void setForegroundColor(Color c) {
  }
  public void setKeyListener(KeyListener kl) {
  }
  public void setMouseListener(MouseListener ml) {
  }
  public Dimension dimension() {
    return null;
  }
  public int x() {
    return 0;
  }

  public int y() {
    return 0;
  }

  public int width() {
    return 0;
  }
  public int height() {
    return 0;
  }
  public void setBounds(int x, int y, int w, int h) {
  }
  public void paint(Graphics g) {
  }
  public void repaint() {
  }

}
