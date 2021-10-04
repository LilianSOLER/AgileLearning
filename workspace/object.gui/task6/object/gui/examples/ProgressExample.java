package object.gui.examples;

import java.util.Random;

import object.gui.Container;
import object.gui.Frame;
import object.gui.TimerListener;
import object.gui.Toolkit;
import object.gui.layout.FlowLayout;
import object.gui.widgets.ProgressBar;
import object.gui.window.Font;
import object.gui.window.Window;

public class ProgressExample implements Runnable {

  static ProgressExample sample;

  public static void main(String args[]) throws Exception {
    sample = new ProgressExample(args);
  }

  private static final int MAXIMUM = 100;
  private static final int MINIMUM = 0;
  private static final int ORANGE_THRESHOLD = 50;
  private static final int RED_THRESHOLD = 75;
  
  Toolkit m_tk;
  Frame m_frame;
  ProgressBar m_bar;
  long m_last;
  float m_delta;
  float m_progress;
  Random m_rand;
  Ticker m_ticker;

  ProgressExample(String args[]) {
    m_tk = new Toolkit();
    m_tk.setCallback(this);
    m_rand = new Random();
    m_ticker = new Ticker();
    m_tk.setTimer(1000, m_ticker);
  }

  @Override
  public void run() {

    Window win = Window.getWindow();
    m_frame = m_tk.getFrame();

    Container cont = new Container(m_frame);
    cont.setBounds(10, 30, 500, 100);
    FlowLayout fl = new FlowLayout(FlowLayout.HORIZONTAL);
    cont.layoutManager(fl);

    Font font = win.font(Window.MONOSPACED, 12F);
    font = font.derive(Font.ITALIC | Font.BOLD, 24F);

    m_bar = new ProgressBar(cont);
    m_bar.m_minimum = MINIMUM;
    m_bar.m_maximum = MAXIMUM;
    m_bar.m_thickness = 32;

    m_frame.layout();
    m_frame.repaint();

  }

  class Ticker implements TimerListener {
    @Override
    public void expired() {
      long now = System.currentTimeMillis();
      if (now - m_last > 5000) {
        float next = m_rand.nextInt(100);
        m_delta = (next - (float) m_bar.getProgress()) / 50F;
        m_last = now;
      } else {
        m_progress += m_delta;
        m_bar.setProgress((int) m_progress);
      }
      Toolkit tk = Toolkit.getToolkit();
      tk.setTimer(100, this);
    }
  }
}