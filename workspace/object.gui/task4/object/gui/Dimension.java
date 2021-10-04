package object.gui;

public class Dimension {
  public int m_width, m_height;

  public Dimension() {
    this(0, 0);
  }

  public Dimension(int width, int height) {
    m_width = width;
    m_height = height;
  }

  public Dimension(Dimension d) {
    if (d != null) {
      m_width = d.m_width;
      m_height = d.m_height;
    }
  }

  public void max(int width, int height) {
    if (m_width < width) 
      m_width = width;
    if (m_height < height)
      m_height = height;
  }

  public boolean equals(Dimension d) {
    return d!=null && (d.m_width == m_width && d.m_height == m_height);
  }

  public String toString() {
    return "(" + m_width + "," + m_height + ")";
  }

  public void add(int width, int height) {
    m_width += width;
    m_height += height;
  }

  public void set(int width, int height) {
    m_width = width;
    m_height = height;
  }

  public int width() {
    return m_width;
  }

  public int height() {
    return m_height;
  }

}
