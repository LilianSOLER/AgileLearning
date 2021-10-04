package object.gui.examples;

import object.gui.Component;
import object.gui.Container;
import object.gui.Dimension;
import object.gui.Frame;
import object.gui.Toolkit;
import object.gui.layout.BorderLayout;
import object.gui.layout.FlowLayout;
import object.gui.window.Color;
import object.gui.window.Image;

public class FlowLayoutExample implements Runnable {

  static FlowLayoutExample sample;

  public static void main(String args[]) throws Exception {
    sample = new FlowLayoutExample(args);
  }

  Toolkit m_tk;
  Frame m_frame;

  FlowLayoutExample(String args[]) {
    m_tk = new Toolkit();
    m_tk.setCallback(this);
  }

  @Override
  public void run() {
    Image i1, i2;
    
    m_frame = m_tk.getFrame();
    
    testFlowLayout(m_frame,FlowLayout.HORIZONTAL, 50,50);
    testFlowLayout(m_frame,FlowLayout.VERTICAL, 300,50);
  }
  
  private void testFlowLayout(Frame frame, int dir, int x, int y) {
    FlowLayout bl = new FlowLayout(dir);
    Container cont = new Container(frame);
    cont.setBackgroundColor(Color.darkGray);
    cont.setBounds(x, y, 200, 200);    
    cont.layoutManager(bl);
    
    Component n = new Component(cont);
    // n.setPreferredSize(new Dimension(20,20));
    n.setBackgroundColor(Color.green);
    
    Component s = new Component(cont);
    //s.setPreferredSize(new Dimension(20,20));
    s.setBackgroundColor(Color.red);

    Component w = new Component(cont);
    //w.setPreferredSize(new Dimension(20,20));
    w.setBackgroundColor(Color.blue);

    Component e = new Component(cont);
    //e.setPreferredSize(new Dimension(20,20));
    e.setBackgroundColor(Color.yellow);

    Component c = new Component(cont);
    //c.setPreferredSize(new Dimension(20,20));
    c.setBackgroundColor(Color.magenta);
    cont.layout();
  }

}