package object.gui.layout;


import object.gui.Component;
import object.gui.Container;
import object.gui.Dimension;

public class BorderLayout extends LayoutManager {

  public static final int CENTER = 0;
  public static final int NORTH = 1;
  public static final int SOUTH = 2;
  public static final int WEST = 3;
  public static final int EAST = 4;

  Component m_north;
  Component m_south;
  Component m_west;
  Component m_east;
  Component m_center;
  int m_gap;

  public void setGap(int gap) {
    m_gap = gap;
  }
  
  public void setup(Component c, int where) {
    switch(where) {
    case CENTER:
      m_center = c;
      break;
    case NORTH:
      m_north = c;
      break;
    case SOUTH:
      m_south = c;
      break;
    case EAST:
      m_east = c;
      break;
    case WEST:
      m_west = c;
      break;
    }
  }

  @Override
  public Dimension preferredSize(Container target) {
    Dimension dim;
    if (m_center!=null)
      dim = new Dimension(m_center.getPreferredSize());
    else
      dim = new Dimension(0,0);
    
    Component c = null;
    c = m_north;
    if (c != null) {
      Dimension d = c.getPreferredSize();
      dim.m_height += d.height(); 
      dim.m_width = Math.max(d.width(),dim.width());
    } 
    dim.m_height += m_gap; 
      
    c = m_south;
    if (c != null) {
      Dimension d = c.getPreferredSize();
      dim.m_height += d.height(); 
      dim.m_width = Math.max(d.width(),dim.width());
    } 
    dim.m_height += m_gap; 
    
    c = m_east;
    if (c != null) {
      Dimension d = c.getPreferredSize();
      dim.m_width += d.width(); 
      dim.m_height += Math.max(d.height(),dim.height());
    } 
    dim.m_width += m_gap; 
    c = m_west;
    if (c != null) {
      Dimension d = c.getPreferredSize();
      dim.m_width += d.width(); 
      dim.m_height += Math.max(d.height(),dim.height());
    }
    dim.m_width += m_gap; 
    return dim;
  }

  @Override
  public void layout(Container target) {
    int top = 0;
    int bottom = target.height();
    int left = 0;
    int right = target.width();

    Component c = null;
    c = m_north;
    if (c != null) {
      Dimension d = c.getPreferredSize();
      c.setBounds(left, top, right - left, d.height());
      top += d.height();
    } 
    top += m_gap;
    
    c = m_south;
    if (c != null) {
      Dimension d = c.getPreferredSize();
      c.setBounds(left, bottom - d.height(), right - left, d.height());
      bottom -= d.height();
    }
    bottom -= m_gap;
    
    c = m_east;
    if (c != null) {
      Dimension d = c.getPreferredSize();
      c.setBounds(right - d.width(), top, d.width(), bottom - top);
      right -= d.width();
    }
    right -= m_gap;

    c = m_west;
    if (c != null) {
      Dimension d = c.getPreferredSize();
      c.setBounds(left, top, d.m_width, bottom - top);
      left += d.m_width; 
    }
    left += m_gap;
    c = m_center;
    if (c != null)
      c.setBounds(left, top, right - left, bottom - top);
  }

}
