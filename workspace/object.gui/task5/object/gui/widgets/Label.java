package object.gui.widgets;

import object.gui.Component;
import object.gui.Container;
import object.gui.Dimension;
import object.gui.window.Color;
import object.gui.window.Font;
import object.gui.window.Graphics;
import object.gui.window.Window;

public class Label extends Component {

  char[] m_chars;
  Font m_font;
  int m_border;
  boolean m_raised;

  public Label(Container parent) {
    super(parent);
    Window win = Window.getWindow();
    m_font = win.font(Window.MONOSPACED, 12F);
    m_chars = new char[0];
  }

  private void computePreferredSize() {
    Dimension d = new Dimension(m_font.charsWidth(m_chars,0,m_chars.length), m_font.getHeight());
    d.add(2 * m_border, 2 * m_border);
    setPreferredSize(d);
  }

  public String getText() {
    return new String(m_chars);
  }

  public void setText(String text) {
    if (text==null)
      m_chars = new char[0];
    else 
      m_chars = text.toCharArray();
    computePreferredSize();
  }

  public void setBorder(int border) {
    m_border = border;
    computePreferredSize();
  }

  public int getBorder() {
    return m_border;
  }

  public void raise(boolean raised) {
    m_raised = raised;
  }

  public boolean isRaised() {
    return m_raised;
  }

  public void setFont(Font f) {
    m_font = f;
    computePreferredSize();
  }

  public Font getFont() {
    return m_font;
  }

  /**
   * Paint this label.
   * What you must know about drawing text on screen.
   * A line of text is composed of three parts:
   *    - leading
   *    - ascent
   *    - descent
   * So the height of a font is the sum of the three:
   *    height = leading+ascent+descent
   * This height is the distance between two adjacent
   * baselines. The baseline is the drawing reference
   * for text. 
   * Any character of a font will not raise above 
   * the baseline more than the font ascent. Also,
   * it will not drop below the baseline more than 
   * the font descent. 
   * When drawing a line of text, via the graphics:
   *      g.drawString(m_chars, 0, m_chars.length, x, y);
   * The vertical location (y) is in fact the one
   * for the baseline.
   */
  @Override
  public void paint(Graphics g) {
    int x, y, h, a, d;
    super.paint(g);
    if (m_raised) 
      Util.paintRaisedComponentShadow(g,this);
    g.setFont(m_font);
    a = m_font.getAscent();
    d = m_font.getDescent();
    h = m_font.getHeight(); // leading + ascent + descent
    // align the text left
    x = m_border;
    // center the text vertically.
    // compute first the middle of the widget, accounting for the border
    // then shift it down for the font baseline
    y = m_border + (m_height - 2*m_border) / 2;
    y = y + (h-d)/2;
    g.setColor(m_fgColor);
    g.drawString(m_chars, 0, m_chars.length, x, y);    
    return;
  }

}
