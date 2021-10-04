package object.gui;

import object.gui.window.Window;

/**
 * This is a mock class, here only to allow the other classes
 * to compile... This needs to be replaced by your implementation
 * done in the previous task (task3).
 * 
 * @author Pr. Olivier Gruber  (olivier dot gruber at acm dot org)
 */

public class Toolkit  {
  public static Toolkit getToolkit() {
    return null;
  }
  protected Window m_win;
  public Toolkit() {
  }
  public Toolkit(int width, int height) {
  }
  public void setCallback(Runnable callback) {
  }
  public void setTimer(int delay, TimerListener listener) {
  }
  public void expired() {}
  
  public Frame getFrame() { return null; }

}
