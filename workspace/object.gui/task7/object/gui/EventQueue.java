package object.gui;

import java.io.PrintStream;

import object.gui.window.Window;

public class EventQueue extends object.events.EventQueue {

  Window m_win; // provided of the global timer

  public EventQueue(Window win, PrintStream log) {
    super(log);
    m_win = win;
  }

  public void expired() {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  protected void setTimer(long delay) {
    throw new RuntimeException("Not Yet Implemented");
  }

}
