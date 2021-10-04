package object.gui.layout;

import object.gui.Component;
import object.gui.Container;
import object.gui.Dimension;

public class FlowLayout extends LayoutManager {

  public static final int VERTICAL = 0;
  public static final int HORIZONTAL = 1;

  int m_direction;

  public FlowLayout(int dir) {
    m_direction = dir;
  }

  @Override
  public Dimension preferredSize(Container target) {
    if (m_direction == VERTICAL)
      return preferredVerticalLayoutSize(target);
    else
      return preferredHorizontalLayoutSize(target);
  }

  @Override
  public void layout(Container target) {
    if (m_direction == VERTICAL)
      layoutVertically(target);
    else
      layoutHorizontally(target);
  }

  private Dimension preferredVerticalLayoutSize(Container target) {
    Dimension dim = new Dimension();
    int childrenCount = target.childrenCount();
    for (int i = 0; i < childrenCount; i++) {
      Component c = target.childrenAt(i);
      Dimension d = c.getPreferredSize();
      dim.m_width = Math.max(dim.m_width, d.width());
      dim.m_height += d.m_height;
    }
    return dim;
  }

  private Dimension preferredHorizontalLayoutSize(Container target) {
    Dimension dim = new Dimension();
    int childrenCount = target.childrenCount();
    for (int i = 0; i < childrenCount; i++) {
      Component c = target.childrenAt(i);
      Dimension d = c.getPreferredSize();
      dim.m_height = Math.max(dim.m_height, d.height());
      dim.m_width += d.m_width;
    }
    return dim;
  }

  private void layoutVertically(Container target) {
    int x, y;
    int h = target.height() / target.childrenCount();
    int w = target.width();
    x = y = 0;
    int childrenCount = target.childrenCount();
    for (int i = 0; i < childrenCount - 1; i++) {
      Component c = target.childrenAt(i);
      Dimension d = c.getPreferredSize();
      if (d.m_height != 0 && d.m_height < h) {
        c.setBounds(x, y, w, d.m_height);
        y += d.m_height;
        h = (target.height() - y) / (childrenCount - i - 1);
      } else {
        c.setBounds(x, y, w, h);
        y += h;
      }
    }
    Component c = target.childrenAt(childrenCount - 1);
    Dimension d = c.getPreferredSize();
    if (d.m_height != 0 && d.m_height < h)
      c.setBounds(x, y, w, d.m_height);
    else
      c.setBounds(x, y, w, h);
  }

  private void layoutHorizontally(Container target) {
    int childrenCount = target.childrenCount();
    int x, y;
    int h = target.height();
    int w = target.width() / childrenCount;
    x = y = 0;
    for (int i = 0; i < childrenCount - 1; i++) {
      Component c = target.childrenAt(i);
      Dimension d = c.getPreferredSize();
      if (d.m_width != 0 && d.m_width < w) {
        c.setBounds(x, y, d.m_width, h);
        x += d.m_width;
        w = (target.width() - x) / (childrenCount - i - 1);
      } else {
        c.setBounds(x, y, w, h);
        x += w;
      }
    }
    Component c = target.childrenAt(childrenCount - 1);
    Dimension d = c.getPreferredSize();
    if (d.m_width != 0 && d.m_width < w)
      c.setBounds(x, y, d.m_width, h);
    else
      c.setBounds(x, y, w, h);
  }
}
