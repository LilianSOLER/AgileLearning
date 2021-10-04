package object.gui.examples;

import java.io.File;
import java.io.FileInputStream;

import object.gui.Container;
import object.gui.Frame;
import object.gui.Toolkit;
import object.gui.layout.FlowLayout;
import object.gui.widgets.Button;
import object.gui.widgets.ButtonListener;
import object.gui.widgets.Label;
import object.gui.window.Font;
import object.gui.window.Image;
import object.gui.window.Window;

public class IconButtonExample implements Runnable {

  static IconButtonExample sample;

  public static void main(String args[]) throws Exception {
    sample = new IconButtonExample(args);
  }

  Toolkit m_tk;
  Frame m_frame;
  Button m_button;
  Label m_label;

  IconButtonExample(String args[]) {
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

    ButtonListener bl;
    bl = new SimpleListener("Rasp-Pi");
    b.setListener(bl);

    final String label = "Click the raspberry button";
    Label l = new Label(cont);
    l.setText(label);
    l.setFont(font);
    l.setBorder(border);

    m_frame.layout();
    m_frame.repaint();

    m_button = b;
    m_label = l;

  }

  class SimpleListener implements ButtonListener {
    String m_name;

    SimpleListener(String name) {
      m_name = name;
    }

    @Override
    public void clicked(Button b) {
      if (b == m_button) {
        System.out.println("\nButton " + m_name + " clicked!");
        System.out.println("\nCongratulations!");
        System.out.println("Toggling the lable (raised/flushed)");

        m_label.raise(!m_label.isRaised());
      }
    }

    @Override
    public void pressed(Button b) {
      if (b == m_button)
        System.out.println("Button pressed...");
    }

    @Override
    public void released(Button b) {
      if (b == m_button)
        System.out.println("Button released...");
    }
  };
}