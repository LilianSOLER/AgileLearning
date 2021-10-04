package object.gui.widgets;

import object.gui.Component;
import object.gui.Container;
import object.gui.window.Graphics;

public class Blinker extends Component {
  public static final int GREEN = 0;
  public static final int ORANGE = 1;
  public static final int RED = 2;

  int m_state;
  
  public Blinker(Container parent) {
    super(parent);
    throw new RuntimeException("Not Yet Implemented");
  }

  public void setState(int state) {
    if (state==m_state)
      return;
    m_state = state;
    throw new RuntimeException("Not Yet Implemented");
  }

  public int getState() {
    return m_state;
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    throw new RuntimeException("Not Yet Implemented");
  }
}
