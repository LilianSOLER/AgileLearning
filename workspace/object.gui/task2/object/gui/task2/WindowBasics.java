package object.gui.task2;

import object.gui.window.Color;
import object.gui.window.Graphics;
import object.gui.window.KeyListener;
import object.gui.window.MouseListener;
import object.gui.window.Window;
import object.gui.window.WindowListener;

public class WindowBasics implements Runnable, MouseListener, KeyListener, WindowListener  {

  static WindowBasics bl;

  public static void main(String args[]) throws Exception {    
    bl = new WindowBasics(args);
  }

  Window m_win;

  WindowBasics(String args[]) {
    m_win = Window.InitWindow();
    m_win.setCallback(this);
  }

  @Override
  public void run() {
    m_win.setKeyListener(this);
    m_win.setMouseListener(this);
    m_win.setWindowListener(this);
  }

  @Override
  public void paint(Graphics g) {
    System.out.println("WindowBasics: paint requested");
    System.out.println("              width="+m_win.getWidth()+" height="+m_win.getHeight());
    g.setColor(Color.yellow);
    g.fillRect(0, 0, m_win.getWidth(), m_win.getHeight());
    g.setColor(Color.red);
    g.fillRect(50, 50, 100, 100);
  }

  @Override
  public void resized(int width, int height) {
    System.out.println("WindowBasics: resized: width="+width+" height="+height);
  }

  @Override
  public void keyPressed(char k, int code) {
    System.out.println("keyPressed: '"+k+"' ("+code+")");
  }

  @Override
  public void keyReleased(char k, int code) {
    System.out.println("keyReleased: '"+k+"' ("+code+")");
  }

  @Override
  public void mouseMoved(int x, int y) {
    System.out.println("mouseMoved: ("+x+","+y+")");
  }

  @Override
  public void mousePressed(int x, int y, int buttons) {
    System.out.println("mousePressed: ("+x+","+y+") buttons="+buttons);
  }

  @Override
  public void mouseReleased(int x, int y, int buttons) {
    System.out.println("mouseReleased: ("+x+","+y+") buttons="+buttons);
  }

  @Override
  public void mouseEntered(int x, int y) {
    System.out.println("mouseEntered: ("+x+","+y+")");
  }

  @Override
  public void mouseExited() {
    System.out.println("mouseExited");
  }

  @Override
  public void expired() {
  }

}
