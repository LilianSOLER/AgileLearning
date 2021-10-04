package object.gui.widgets;

import object.gui.Component;
import object.gui.Container;
import object.gui.window.Color;
import object.gui.window.Graphics;

public class Meter extends Component {

  float m_min;
  float m_max;
  float m_level;
  int m_border = 4;

  public Meter(Container parent, float min, float max, float level) {
    super(parent);
    m_min = min;
    m_max = max;
    m_level = level;
    setPreferredSize((int) (20 + 2 * m_border), (int) m_max);
  }

  public void setBorder(int border) {
    m_border = border;
    setPreferredSize((int) (20 + 2 * m_border), (int) m_max);
  }

  public void setLevel(int level) {
    if (level >= m_min && level <= m_max) {
      m_level = level;
      repaint();
    }
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Util.paintRaisedComponentShadow(g, this);
    int w = width() - 2 * m_border;
    int h = height() - 2 * m_border;
    g.setColor(m_fgColor);
    int watermark = (int) (h * m_level / m_max);
    int y = height() - m_border - watermark;
    g.fillRect(m_border, y, w, watermark);
    if (m_min != 0) {
      g.setColor(Color.black);
      y = height() - m_border - (int) (h * m_min / m_max);
      g.drawLine(m_border, y, w, y);
    }
  }
}
