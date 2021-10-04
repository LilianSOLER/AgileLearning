package object.gui.examples;

import object.events.Event;
import object.gui.EventQueue;
import object.gui.window.Graphics;
import object.gui.window.Window;
import object.gui.window.WindowListener;

public class EventQueueTests implements Runnable, WindowListener {
  Window m_win;
  EventQueue m_queue;

  public EventQueueTests() {
    m_win = Window.InitWindow();
    m_win.setCallback(this);
    m_win.setWindowListener(this);
  }

  public static void main(String[] args) {
    EventQueueTests tests;
    tests = new EventQueueTests();
    while (true)
      try {
        Thread.sleep(1000);
      } catch (InterruptedException ex) {
        return;
      }
  }

  @Override
  public void run() {
    m_queue = new EventQueue(m_win, System.out);
    TestEvent e = new TestEvent(100);
    m_queue.push(e);
    e = new TestEvent(200);
    m_queue.push(e);
    e = new TestEvent(150);
    m_queue.push(e);
  }

  class TestEvent extends Event {
    int m_delay;
    long m_created;
    long m_eta;

    protected TestEvent(int delay) {
      super(delay);
      m_delay = delay;
      m_created = System.currentTimeMillis();
      m_eta = m_created + delay;
    }

    @Override
    protected void react() throws Exception {
      long now = System.currentTimeMillis();
      System.out.println(" delta=" + (now - m_eta));
      if (m_delay > 10) {
        m_delay -= 10;
        m_queue.push(this);
      } else if (m_queue.length() == 0)
        System.exit(0);
    }

    @Override
    protected boolean equals(Event e) {
      return false;
    }

  }

  @Override
  public void paint(Graphics g) {
  }

  @Override
  public void resized(int width, int height) {
  }

  @Override
  public void expired() {
    m_queue.expired();
  }
}
