package object.gui.task3;

import object.gui.window.Graphics;
import object.gui.window.Window;

public class Toolkit implements Runnable, object.gui.window.WindowListener, object.gui.window.KeyListener,
    object.gui.window.MouseListener {

  Window m_win;
  Frame m_frame;
  Runnable m_callback;
  Component m_focus;
  private static Toolkit self;

  public static Toolkit getToolkit() {
    return self;
  }

  public Toolkit() {
    self = this;
    m_win = Window.InitWindow();
    m_win.setCallback(this);
  }

  public Toolkit(int width, int height) {
    self = this;
    m_win = Window.InitWindow(width, height);
    m_win.setCallback(this);
  }

  public void setCallback(Runnable callback) {
    m_callback = callback;
    m_win.repaint();
  }

  @Override
  public void run() {
    m_frame = new Frame();
    m_win.setWindowListener(this);
    m_win.setMouseListener(this);
    m_win.setKeyListener(this);
  }

  public Frame getFrame() {
    return m_frame;
  }

  @Override
  public void paint(Graphics g) {
    m_frame.doPaint(g);
  }

  @Override
  public void resized(int width, int height) {
    m_frame.setBounds(0, 0, width, height);
    if (m_callback != null) {
      m_callback.run();
      m_callback = null;
    }
  }

  /**
   * The mouse has moved.
   * Need to give the focus to the component at 
   * the new mouse location. If there is such a
   * component, we must deliver a mouse-moved event
   * to its listener, if it has one.
   * In case the focus has changed, we need to 
   * ensure the correct grammar, generating the
   * necessary events (mouse-entered and mouse-exited).
   */
  @Override
  public void mouseMoved(int x, int y) {
    // TODO: Not Yet Implemented
  }

  /**
   * A button has been pressed at the given mouse location.
   * Need to give the focus to the component at 
   * the new mouse location. If there is such a
   * component, we must deliver a mouse-pressed event
   * to its listener, if it has one.
   */
  @Override
  public void mousePressed(int x, int y, int button) {
    // TODO: Not Yet Implemented
  }

  /**
   * A button has been released at the given mouse location.
   * Need to give the focus to the component at 
   * the new mouse location. If there is such a
   * component, we must deliver a mouse-released event
   * to its listener, if it has one.
   */
  @Override
  public void mouseReleased(int x, int y, int button) {
    // TODO: Not Yet Implemented
  }

  /**
   * The mouse has entered the window at the given mouse location.
   * Need to give the focus to the component at 
   * the new mouse location. If there is such a
   * component, we must deliver a mouse-entered event
   * to its listener, if it has one.
   */
  @Override
  public void mouseEntered(int x, int y) {
    // TODO: Not Yet Implemented
  }

  /**
   * The mouse has exited the window at the given mouse location.
   * If a component has the focus and it has a mouse listener,
   * we must deliver a mouse-exited event.
   * We also have to remember that no component has the focus.
   */
  @Override
  public void mouseExited() {
    // TODO: Not Yet Implemented
  }

  /**
   * A key has been pressed on the keyboard. 
   * If a component has the focus and that component 
   * has a key listener, we need to deliver a key-pressed 
   * event to the listener.
   */
  @Override
  public void keyPressed(char k, int code) {
    // TODO: Not Yet Implemented
  }

  /**
   * A key has been released on the keyboard. 
   * If a component has the focus and that component 
   * has a key listener, we need to deliver a key-pressed 
   * event to the listener.
   */
  @Override
  public void keyReleased(char k, int code) {
    // TODO: Not Yet Implemented
  }

  /**
   * This method sets a timer to the given delay in milliseconds.
   * It cancels any pending timer, if there was any.
   * Use a delay=-1 to just cancel an existing timer without
   * setting a new one.
   * @param delay
   * @param listener
   */
  public void setTimer(int delay, TimerListener listener) {
    m_win.cancelTimer();
    if (delay >= 0) {
      m_tl = listener;
      m_win.setTimer(delay);
    } else
      m_tl = null;
  }

  TimerListener m_tl;

  @Override
  public void expired() {
    if (m_tl != null)
      m_tl.expired();
  }
}
