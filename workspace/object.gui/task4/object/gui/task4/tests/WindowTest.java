package object.gui.task4.tests;

import object.gui.Component;
import object.gui.Frame;
import object.gui.KeyListener;
import object.gui.MouseListener;
import object.gui.Toolkit;
import object.gui.window.Color;

public class WindowTest implements Runnable {

  static WindowTest self;

  public static void main(String args[]) throws Exception {
    self = new WindowTest();
  }

  Toolkit m_tk;
  Frame m_root;
  Component m_north, m_south, m_east, m_west, m_center;

  WindowTest() {
    m_tk = new Toolkit();
    m_tk.setCallback(this);
  }

  @Override
  public void run() {

    m_root = m_tk.getFrame(); // new Frame(200, 200);
    m_root.setBackgroundColor(Color.lightGray);
    m_root.setName("Root Frame");

    m_north = new Component(m_root);
    m_north.setBackgroundColor(Color.green);
    m_north.setName("North Component");

    m_south = new Component(m_root);
    m_south.setBackgroundColor(Color.red);
    m_south.setName("South Component");

    m_west = new Component(m_root);
    m_west.setBackgroundColor(Color.blue);
    m_west.setName("West Component");

    m_east = new Component(m_root);
    m_east.setBackgroundColor(Color.magenta);
    m_east.setName("East Component");

    m_center = new Component(m_root);
    m_center.setBackgroundColor(Color.darkGray);
    m_center.setName("Center Component");

    layout();
    m_root.repaint();
  }

  private void setListeners() {
    Listener l = new Listener();

    m_root.setKeyListener(l);
    m_root.setMouseListener(l);
    m_north.setKeyListener(l);
    m_north.setMouseListener(l);
    m_south.setKeyListener(l);
    m_south.setMouseListener(l);
    m_west.setKeyListener(l);
    m_west.setMouseListener(l);
    m_east.setKeyListener(l);
    m_east.setMouseListener(l);
    m_center.setKeyListener(l);
    m_center.setMouseListener(l);
  }

  private void layout() {
    int border = 10;
    int gap = 4;
    int w = m_root.width();
    int h = m_root.height();
    int ratio = 5;

    m_north.setBounds(border, border, w - 2 * border, h / ratio);
    m_south.setBounds(border, h - border - h / ratio, w - 2 * border, h / ratio);
    m_west.setBounds(border, border + gap + h / ratio, w / ratio, h - 2 * (gap + border + h / ratio));
    m_east.setBounds(w - border - w / ratio, border + gap + h / ratio, w / ratio, h - 2 * (gap + border + h / ratio));
    m_center.setBounds(border + gap + w / ratio, border + gap + h / ratio, w - 2 * (gap + border + w / ratio),
        h - 2 * (gap + border + h / ratio));

    setListeners();
  }

  //  private void paint(Graphics g, Component comp, int x, int y) {
  //    Color c = comp.getBackgroundColor();
  //    if (c == null)
  //      g.setColor(Color.lightGray);
  //    else
  //      g.setColor(c);
  //    Location loc = new Location();
  //    comp.toGlobal(loc);
  //    g.fillRect(loc.x(), loc.y(), comp.width(), comp.height());
  //  }

  //  @Override
  //  public void resized(int width, int height) {
  //    if (m_root != null) {
  //      m_root.setBounds(0, 0, width, height);
  //      layout();
  //    }
  //    //m_win.repaint(0, 0, width, height);
  //  }

  private class Listener implements MouseListener, KeyListener {

    @Override
    public void keyPressed(Component c, char k, int code) {
      System.out.println("keyPressed: " + k + "(" + code + ") on " + c.getName());
    }

    @Override
    public void keyReleased(Component c, char k, int code) {
      System.out.println("keyReleased: " + k + "(" + code + ") on " + c.getName());
    }

    @Override
    public void mouseMoved(Component c, int x, int y) {
      System.out.println("mouseMoved: " + "(" + x + "," + y + ") on " + c.getName());
    }

    @Override
    public void mousePressed(Component c, int x, int y, int button) {
      System.out.println("mousePressed: button=" + button + " at (" + x + "," + y + ") on " + c.getName());
    }

    @Override
    public void mouseReleased(Component c, int x, int y, int button) {
      System.out.println("mouseReleased: button=" + button + " at (" + x + "," + y + ") on " + c.getName());
    }

    @Override
    public void mouseEntered(Component c, int x, int y) {
      System.out.println("mouseEntered: at (" + x + "," + y + ") on " + c.getName());
    }

    @Override
    public void mouseExited(Component c) {
      System.out.println("mouseExited: " + c.getName());
    }

  }
}
