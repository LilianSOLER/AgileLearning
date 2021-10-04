package object.gui.window;

import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.BufferCapabilities;
import java.awt.BufferCapabilities.FlipContents;
import java.awt.Graphics;
import java.awt.ImageCapabilities;
import java.awt.Toolkit;

public class GuiCanvas extends java.awt.Canvas {

  private static final long serialVersionUID = 1L;
  
  GuiWindow m_window;

  GuiCanvas(GuiWindow win) {
    m_window = win;
  }

  //  public void setPaintListener(ricm3.gui.PaintListener pl) {
  //    m_pl = pl;
  //    if (m_pl!=null)
  //      m_pl.resized(getWidth(), getHeight());
  //  }

  @Override
  public final void paint(Graphics g) {
    if (m_window.m_callback==null) {
      // early paint... do nothing,
      return;
    }
    if (m_window.m_graphics == null) {
      m_window.m_graphics = g.create();
      m_window.m_callback.run();
      object.gui.window.WindowListener wl;
      wl = m_window.m_wl;
      if (wl != null)
        wl.resized(getWidth(), getHeight());
    }
    object.gui.window.WindowListener pl;
    pl = m_window.m_wl;
    GuiGraphics gg;
    gg = new GuiGraphics(m_window,g);
    if (pl == null)
      super.paint(g);
    else
      pl.paint(gg);
    Toolkit.getDefaultToolkit().sync();
  }

  @Override
  public void setBounds(int x, int y, int width, int height) {
    super.setBounds(x, y, width, height);
    if (m_window.m_graphics != null) {
      object.gui.window.WindowListener wl;
      wl = m_window.m_wl;
      if (wl != null)
        wl.resized(width, height);
      try {
      BufferCapabilities caps = new BufferCapabilities(new ImageCapabilities(true),new ImageCapabilities(true),FlipContents.PRIOR);
      this.createBufferStrategy(2, caps);
      } catch(AWTException ex) {
        ex.printStackTrace();
      }
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