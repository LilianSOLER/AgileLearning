package object.gui.window;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class BufferedGuiCanvas extends java.awt.Canvas {

  private static final long serialVersionUID = 1L;

  GuiWindow m_window;
  Image b1, b2;
  Image m_renderBuffer;
  Image m_drawBuffer;

  BufferedGuiCanvas(GuiWindow win) {
    m_window = win;
  }

  private void initImages() {
    int w = getWidth();
    int h = getHeight();
    b1 = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    b2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    Graphics gc = b1.getGraphics();
    gc.setColor(Color.black);
    gc.fillRect(0, 0, w, h);
    gc = b2.getGraphics();
    gc.setColor(Color.black);
    gc.fillRect(0, 0, w, h);
    m_renderBuffer = b2;
    m_drawBuffer = b1;
  }

  private void swap() {
    if (m_renderBuffer == b1) {
      m_renderBuffer = b2;
      m_drawBuffer = b1;
    } else {
      m_renderBuffer = b1;
      m_drawBuffer = b2;
    }
  }

  /* Necessary override to avoid repainting 
   * the background, which is done in the 
   * java.awt.Canvas.update(Graphics) method.
   */
  @Override
  public final void update(Graphics g) {
    paint(g);
  }

  @Override
  public final void paint(Graphics g) {
    if (m_window.m_callback == null) {
      // early paint... do nothing
      return;
    }
    if (m_window.m_graphics == null) {
      m_window.m_graphics = g.create();
      m_window.m_callback.run();
      object.gui.window.WindowListener wl;
      wl = m_window.m_wl;
      if (wl != null)
        wl.resized(getWidth(), getHeight());
      initImages();
    }
    object.gui.window.WindowListener pl;
    pl = m_window.m_wl;
    if (pl == null)
      super.paint(g);
    else {
      GuiGraphics gg;
      gg = new GuiGraphics(m_window, m_drawBuffer.getGraphics());
      pl.paint(gg);
      swap();
      g.drawImage(m_renderBuffer, 0, 0, this);
      Toolkit.getDefaultToolkit().sync();
    }
    return;
  }

  @Override
  public void setBounds(int x, int y, int width, int height) {
    super.setBounds(x, y, width, height);
    if (m_window.m_graphics != null) {
      object.gui.window.WindowListener wl;
      wl = m_window.m_wl;
      if (wl != null)
        wl.resized(width, height);
      initImages();
    }

  }

  /*
   * Over load processEvent which is inherited from class java.awt.Window
   * Our defined SimpleAWTEvent will be handled here.
   */
  protected void processEvent(AWTEvent event) {
    if (event instanceof GuiWindow.RunnableEvent) {
      GuiWindow.RunnableEvent tr = (GuiWindow.RunnableEvent) event;
      tr.run();
    } else
      super.processEvent(event);
  }

}