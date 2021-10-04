package object.gui.examples;


import object.gui.Component;
import object.gui.Container;
import object.gui.Dimension;
import object.gui.Frame;
import object.gui.Toolkit;
import object.gui.layout.BorderLayout;
import object.gui.window.Color;

public class BorderLayoutExample implements Runnable {

  static BorderLayoutExample sample;

  public static void main(String args[]) throws Exception {
    sample = new BorderLayoutExample(args);
  }

  Toolkit m_tk;
  Frame m_frame;

  BorderLayoutExample(String args[]) {
    m_tk = new Toolkit();
    m_tk.setCallback(this);
  }

  @Override
  public void run() {
    
    m_frame = m_tk.getFrame();
        
    BorderLayout bl = new BorderLayout();
    Container cont = new Container(m_frame);
    cont.setBackgroundColor(Color.lightGray);
    cont.setBounds(50, 100, 200, 200);    
    cont.layoutManager(bl);
    
    Component north = new Component(cont);
    north.setPreferredSize(new Dimension(20,20));
    north.setBackgroundColor(Color.green);
    bl.setup(north, BorderLayout.NORTH);
    
    Component south = new Component(cont);
    south.setPreferredSize(new Dimension(20,20));
    south.setBackgroundColor(Color.red);
    bl.setup(south, BorderLayout.SOUTH);

    Component west = new Component(cont);
    west.setPreferredSize(new Dimension(20,20));
    west.setBackgroundColor(Color.blue);
    bl.setup(west, BorderLayout.WEST);

    Component east = new Component(cont);
    east.setPreferredSize(new Dimension(20,20));
    east.setBackgroundColor(Color.magenta);
    bl.setup(east, BorderLayout.EAST);

    Component center = new Component(cont);
    center.setPreferredSize(new Dimension(20,20));
    center.setBackgroundColor(Color.darkGray);
    bl.setup(center, BorderLayout.CENTER);
    
    cont.layout();
    m_frame.repaint();
  }
  
}