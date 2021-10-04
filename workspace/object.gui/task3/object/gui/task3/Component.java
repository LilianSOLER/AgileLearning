package object.gui.task3;

import object.gui.window.Color;
import object.gui.window.Graphics;
import object.gui.window.Window;

/**
 * Each component represents a surface, with a width and height.
 * Each component is at a location within its parent container.
 * Each child is painted above its parent, in terms of the z-order. 
 * Any surface of a child that is not within its parent's surface
 * is not visible and thus not selectable.
 * 
 * @author Pr. Olivier Gruber  (olivier dot gruber at acm dot org)
 */

public class Component {

  protected Container m_parent;
  protected int m_x, m_y, m_width, m_height;
  protected Color m_bgColor; // background color
  protected Color m_fgColor; // foreground color
  protected MouseListener m_ml;
  protected KeyListener m_kl;
  protected String m_name;
  protected Object m_attachment;
  
  public Component() {
    m_bgColor = Color.lightGray;
    m_fgColor = Color.black;
  }

  public Component(Container parent) {
    m_parent = parent;
    // add ourself to our parent
    parent.added(this);
    // inherit the parent foreground and background colors
    m_bgColor = parent.m_bgColor;
    m_fgColor = parent.m_fgColor;
  }

  public Object getAttachment() {
    return m_attachment;
  }

  public void setAttachment(Object o) {
    m_attachment = o;
  }

  public String getName() {
    return m_name;
  }

  public void setName(String name) {
    m_name = name;
  }

  public Color getBackgroundColor() {
    return m_bgColor;
  }

  public void setBackgroundColor(Color c) {
    m_bgColor = c;
  }

  public Color getForegroundColor() {
    return m_fgColor;
  }

  public void setForegroundColor(Color c) {
    m_fgColor = c;
  }
  
  public void setKeyListener(KeyListener kl) {
    m_kl = kl;
  }

  public KeyListener getKeyListener() {
    return m_kl;
  }

  public void setMouseListener(MouseListener ml) {
    m_ml = ml;
  }

  public MouseListener getMouseListener() {
    return m_ml;
  }


  public String toString() {
    String s = getClass().getSimpleName();
    if (m_name!=null)
      s += " "+m_name;
    s += " (" + m_x + "," + m_y + "," + m_width + "," + m_height + ")";
    return s;
  }

  /**
   * Convert a global location to a location that is local to this component
   * 
   * @param l
   */
  public void toLocal(Location l) {
    l.translate(-m_x, -m_y);
    if (m_parent != null)
      m_parent.toLocal(l);
  }

  /**
   * Convert a local location to a location that is global, that is, in the
   * coordinates of the root of the layout tree.
   * 
   * @param l
   */
  public void toGlobal(Location l) {
    l.translate(m_x, m_y);
    if (m_parent != null)
      m_parent.toGlobal(l);
  }

  /**
   * Checks whether this component "contains" the specified point,
   * where <code>x</code> and <code>y</code> are defined to be
   * local to the coordinate system of this component.
   * @param     x   the <i>x</i> coordinate of the point
   * @param     y   the <i>y</i> coordinate of the point
   */
  public boolean contains(int x, int y) {
    return (x >= 0) && (x < m_width) && (y >= 0) && (y < m_height);
  }

  /**
   * @return the parent container of this component
   */
  public Container parent() {
    return m_parent;
  }

  /**
   * removes this component from its parent container.
   * @throws IllegalStateException if this remove is not allowed.
   */
  public void remove() {
    m_parent.removed(this);
  }

  /**
   * @return the location of this component in the coordinate system of its
   *         parent.
   */
  public Location location() {
    return new Location(m_x, m_y);
  }

  /**
   * @return the location of this component in the coordinate system of its
   *         parent.
   */
  public Dimension dimension() {
    return new Dimension(m_width, m_height);
  }

  public int x() {
    return m_x;
  }

  public int y() {
    return m_y;
  }

  public int width() {
    return m_width;
  }

  public int height() {
    return m_height;
  }

  /**
   * Sets the bounds of this component.
   * The given location is expressed in the
   * coordinate system of its parent.
   */
  public void setBounds(int x, int y, int w, int h) {
    m_x = x;
    m_y = y;
    m_width = w;
    m_height = h;
  }

  /**
   * Tells if the given location is within this component.
   * The location is given in the parent's coordinates.
   * @param x
   * @param y
   * @return
   */
  public boolean inside(int x, int y) {
    int w = m_width;
    int h = m_height;
    // Check if at least one of the dimensions is negative...
    if ((w | h) < 0)
      return false;
    // Note: if either dimension is zero, tests below must return false...
    if (x < m_x || y < m_y)
      return false;
    w += m_x;
    h += m_y;
    // overflow || intersect
    return ((w < m_x || w > x) && (h < m_y || h > y));
  }

  /**
   * Paints this component.
   * This method is called when the contents of the component should
   * be painted; such as when the component is first being shown or
   * some of its rendered pixels were damaged on the screen.
   * The given graphics is clipped to the area that needs to be painted.
   *
   * @param g the graphics context to use for painting
   */
  public void paint(Graphics g) {
    g.setColor(m_bgColor);
    g.fillRect(0, 0, m_width, m_height);
  }

  /**
   * Requests that this component be repainted at a later time.
   */
  public void repaint() {
    Window win = Window.getWindow();
    win.repaint();
  }

  /**
   * Paint this component.
   * @param g
   */
  void doPaint(Graphics g) {
    /* TODO */
    throw new RuntimeException("Not Yet Implemented");
  }

  /**
   * Tells if the given location is within this component.
   * The location is given in local coordinates.
   * @param x
   * @param y
   * @return this component if the given local coordinates
   *         are within the bounds of this component.
   *         Otherwise, returns null.
   */
  public Component select(int x, int y) {
    /* TODO: NOT YET IMPLEMENTED */
    return null;
  }

}
