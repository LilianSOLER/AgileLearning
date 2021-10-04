package object.gui.window;

public class GuiFont extends Font {

  GuiWindow m_win;
  java.awt.Font m_font;
  java.awt.FontMetrics m_fm;

  GuiFont(GuiWindow win, java.awt.FontMetrics fm) {
    m_win = win;
    m_font = fm.getFont();
    m_fm = fm;
  }
  
  public Font derive(int style, float size) {
    java.awt.Font f = m_font.deriveFont(style, size);
    m_win.m_graphics.setFont(f);
    java.awt.FontMetrics fm = m_win.m_graphics.getFontMetrics();
    GuiFont gf = new GuiFont(m_win,fm);
    return gf;
  }
    
  @Override
  public float getSize() {
    return m_font.getSize2D();
  }
  @Override
  public int getStyle() {
    return m_font.getStyle();
  }

  @Override
  public int getHeight() {
    return m_fm.getHeight();
  }

  @Override
  public int getLeading() {
    return m_fm.getLeading();
  }

  @Override
  public int getAscent() {
    return m_fm.getAscent();
  }
  
  @Override
  public int getDescent() {
    return m_fm.getDescent();
  }

  @Override
  public int charWidth(char ch) {
    return m_fm.charWidth(ch);
  }
  
  @Override
  public int charsWidth(char data[], int off, int len) {
    return m_fm.charsWidth(data,off,len);
  }

//  public int stringWidth(String str) {
//    return m_fm.stringWidth(str);
//  }
}
