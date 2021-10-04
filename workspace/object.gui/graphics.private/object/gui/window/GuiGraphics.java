package object.gui.window;

import java.awt.FontMetrics;

public class GuiGraphics implements object.gui.window.Graphics {

  GuiWindow m_win;
  java.awt.Graphics g;
  object.gui.window.Color color;
  GuiFont font;

  GuiGraphics(GuiWindow win, java.awt.Graphics g) {
    m_win = win;
    this.g = g;
    FontMetrics fm = g.getFontMetrics();
    this.font = new GuiFont(m_win,fm);
    java.awt.Color c = g.getColor();
    int rgb = c.getRGB();
    int alpha = c.getAlpha();
    this.color = new object.gui.window.Color(rgb, alpha);
  }

  private static java.awt.Color awtColor(Color color) {
    return new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
  }

  @Override
  public Graphics create(int x, int y, int width, int height) {
    return new GuiGraphics(m_win,g.create(x, y, width, height));
  }

  @Override
  public void dispose() {
    g.dispose();
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public void setColor(Color c) {
    color = c;
    g.setColor(awtColor(c));
  }

  @Override
  public void setPaintMode() {
    g.setPaintMode();
  }

  @Override
  public void setXORMode(Color c) {
    g.setXORMode(awtColor(c));
  }

  @Override
  public void setClip(int x, int y, int width, int height) {
    g.setClip(x, y, width, height);
  }

  @Override
  public void drawLine(int x1, int y1, int x2, int y2) {
    g.drawLine(x1, y1, x2, y2);
  }

  @Override
  public void fillRect(int x, int y, int width, int height) {
    g.fillRect(x, y, width, height);
  }

  @Override
  public void drawRect(int x, int y, int width, int height) {
    g.drawRect(x, y, width, height);
  }

  @Override
  public void drawOval(int x, int y, int width, int height) {
    g.drawOval(x, y, width, height);
  }

  @Override
  public void fillOval(int x, int y, int width, int height) {
    g.fillOval(x, y, width, height);
  }

  @Override
  public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
    g.drawArc(x, y, width, height, startAngle, arcAngle);
  }

  @Override
  public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
    g.fillArc(x, y, width, height, startAngle, arcAngle);
  }

  @Override
  public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
    g.drawPolyline(xPoints, yPoints, nPoints);
  }

  @Override
  public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
    g.drawPolygon(xPoints, yPoints, nPoints);
  }

//  @Override
//  public void drawString(String str, int x, int y) {
//    g.drawString(str, x, y);
//  }

  @Override
  public void drawString(char[] chars, int offset, int length, int x, int y) {
    g.drawChars(chars, offset, length, x, y);
  }

  @Override
  public Font getFont() {
    return font;
  }

  @Override
  public void setFont(Font f) {
    font = (GuiFont) f;
    g.setFont(font.m_font);
  }

  @Override
  public int getFontHeight() {
    FontMetrics fm = g.getFontMetrics();
    return fm.getHeight();
  }

  public int getStringWidth(String s) {
    FontMetrics fm = g.getFontMetrics();
    int w = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      w += fm.charWidth(c);
    }
    return w;
  }

  @Override
  public int getStringWidth(char[] chars, int offset, int length) {
    FontMetrics fm = g.getFontMetrics();
    int w = 0;
    for (int i = offset; i < length; i++) {
      char c = chars[i];
      w += fm.charWidth(c);
    }
    return w;
  }

  @Override
  public int getCharWidth(char c) {
    FontMetrics fm = g.getFontMetrics();
    return fm.charWidth(c);
  }

  @Override
  public void drawImage(Image img, int x, int y, int width, int height) {
    if (img != null) {
      GuiImage gi = (GuiImage) img;
      g.drawImage(gi.img, x, y, width, height, null);
    }
  }

  @Override
  public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
    g.fillPolygon(xPoints, yPoints, nPoints);
  }

}
