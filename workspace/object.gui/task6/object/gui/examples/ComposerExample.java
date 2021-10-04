package object.gui.examples;

import java.util.Random;

import object.gui.Container;
import object.gui.Frame;
import object.gui.TimerListener;
import object.gui.Toolkit;
import object.gui.layout.FlowLayout;
import object.gui.widgets.Blinker;
import object.gui.widgets.Button;
import object.gui.widgets.ButtonListener;
import object.gui.widgets.ProgressBar;
import object.gui.widgets.ProgressBar.ProgressListener;
import object.gui.window.Font;
import object.gui.window.Window;

public class ComposerExample implements Runnable {

  static ComposerExample sample;

  public static void main(String args[]) throws Exception {
    sample = new ComposerExample(args);
  }

  private static final int MAXIMUM = 100;
  private static final int MINIMUM = 0;
  private static final int ORANGE_THRESHOLD = 50;
  private static final int RED_THRESHOLD = 75;

  Toolkit m_tk;
  Frame m_frame;
  ProgressBar m_bar;
  Blinker m_blinker;
  long m_last;
  float m_delta;
  float m_progress;
  Random m_rand;
  Ticker m_ticker;
  Button m_button;

  ComposerExample(String args[]) {
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

    int border = 4;
    m_button = new Button(cont);
    m_button.setLabel("#");
    m_button.setBorder(border);
    m_button.setFont(font);
    m_button.setListener(new Composer());

    m_blinker = new Blinker(cont);
    m_blinker.setPreferredSize(64, 64);
    m_blinker.setState(Blinker.GREEN);

    m_frame.layout();
    m_frame.repaint();

  }

  class Composer implements ButtonListener {
    boolean m_wired = false;

    @Override
    public void clicked(Button b) {
    }

    @Override
    public void pressed(Button b) {
      m_wired = !m_wired;
      if (m_wired) {
        m_bar.setListener(new UpdateListener());
        m_button.setLabel("=");
      } else {
        m_bar.setListener(null);
        m_button.setLabel("#");
        m_blinker.setState(Blinker.GREEN);
      }
    }

    @Override
    public void released(Button b) {
    }
  }

  class UpdateListener implements ProgressListener {

    @Override
    public void progressUpdate(ProgressBar bar) {
      int progress = bar.getProgress();
      if (progress < ORANGE_THRESHOLD)
        m_blinker.setState(Blinker.GREEN);
      else if (progress < RED_THRESHOLD)
        m_blinker.setState(Blinker.ORANGE);
      else
        m_blinker.setState(Blinker.RED);
    }
  };

  class Ticker implements TimerListener {
    @Override
    public void expired() {
      long now = System.currentTimeMillis();
      if (now - m_last > 5000) {
        float next = m_rand.nextInt(100);
        m_delta = (next - (float) m_bar.getProgress()) / 50F;
        m_last = now;
        System.out.println(" next=" + next + "  (delta=" + m_delta + ")");
      } else {
        m_progress += m_delta;
        m_bar.setProgress((int) m_progress);
      }
      Toolkit tk = Toolkit.getToolkit();
      tk.setTimer(100, this);
    }
  }
}