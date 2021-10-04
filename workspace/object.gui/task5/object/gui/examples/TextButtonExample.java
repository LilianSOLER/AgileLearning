package object.gui.examples;

import object.gui.Container;
import object.gui.Frame;
import object.gui.Toolkit;
import object.gui.layout.FlowLayout;
import object.gui.widgets.Button;
import object.gui.widgets.Label;
import object.gui.window.Font;
import object.gui.window.Window;

public class TextButtonExample implements Runnable {

  static TextButtonExample sample;

  public static void main(String args[]) throws Exception {
    sample = new TextButtonExample(args);
  }

  Toolkit m_tk;
  Frame m_frame;
  Button m_button;
  Label m_label;

  TextButtonExample(String args[]) {
    m_tk = new Toolkit();
    m_tk.setCallback(this);
  }

  @Override
  public void run() {

    Window win = Window.getWindow();
    m_frame = m_tk.getFrame();

    Container cont = new Container(m_frame);
    cont.setBounds(10, 30, 500, 50);
    FlowLayout fl = new FlowLayout(FlowLayout.HORIZONTAL);
    cont.layoutManager(fl);

    Font font = win.font(Window.MONOSPACED, 12F);
    font = font.derive(Font.ITALIC | Font.BOLD, 24F);

    Button b;
    int border = 4;
    b = new Button(cont);
    b.setLabel("OK");
    b.setBorder(border);
    b.setFont(font);
    m_button = b;

    Label l = new Label(cont);
    l.setText("Please click the button p q g");
    l.setFont(font);
    l.setBorder(0); //border);
    m_label = l;

    m_frame.layout();
    m_frame.repaint();
  }

}