package object.gui.examples;

import java.io.File;
import java.io.FileInputStream;

import object.gui.Container;
import object.gui.Frame;
import object.gui.Toolkit;
import object.gui.layout.FlowLayout;
import object.gui.widgets.Blinker;
import object.gui.widgets.Button;
import object.gui.widgets.ButtonListener;
import object.gui.window.Font;
import object.gui.window.Image;
import object.gui.window.Window;

public class BlinkerExample implements Runnable {

  static BlinkerExample sample;

  public static void main(String args[]) throws Exception {
    sample = new BlinkerExample(args);
  }

  Toolkit m_tk;
  Frame m_frame;
  Button m_button;
  Blinker m_blinker;

  BlinkerExample(String args[]) {
    m_tk = new Toolkit();
    m_tk.setCallback(this);
  }

  private Image loadImage(Window win, String path) {
    try {
      return win.loadImage(new FileInputStream(new File(path)));
    } catch (Exception ex) {
      return null;
    }
  }

  @Override
  public void run() {
    Image i1, i2;

    Window win = Window.getWindow();
    m_frame = m_tk.getFrame();

    Container cont = new Container(m_frame);
    cont.setBounds(10, 30, 500, 100);
    FlowLayout fl = new FlowLayout(FlowLayout.HORIZONTAL);
    cont.layoutManager(fl);

    Font font = win.font(Window.MONOSPACED, 12F);
    font = font.derive(Font.ITALIC | Font.BOLD, 24F);

    Button b;
    int border = 4;
    b = new Button(cont);
    b.setBorder(border);
    b.setFont(font);
    i1 = loadImage(win, "images/raspberry-pi.png");
    i2 = loadImage(win, "images/raspberry-pi-bw-wire.png");
    b.setImages(i1, i2);
    b.setPreferredSize(64,64);
    m_button = b;

    ButtonListener bl;
    bl = new SimpleListener("Rasp-Pi");
    b.setListener(bl);

    m_blinker = new Blinker(cont);
    m_blinker.setPreferredSize(64,64);
    
    m_frame.layout();
    m_frame.repaint();

  }

  class SimpleListener implements ButtonListener {
    String m_name;

    SimpleListener(String name) {
      m_name = name;
    }

    @Override
    public void clicked(Button b) {
      if (b == m_button) {
        int state = m_blinker.getState();
        switch(state) {
        case Blinker.GREEN:
          m_blinker.setState(Blinker.ORANGE);
          break;
        case Blinker.ORANGE:
          m_blinker.setState(Blinker.RED);
          break;
        case Blinker.RED:
          m_blinker.setState(Blinker.GREEN);
          break;
        }

      }
    }

    @Override
    public void pressed(Button b) {
    }

    @Override
    public void released(Button b) {
    }
  };
}