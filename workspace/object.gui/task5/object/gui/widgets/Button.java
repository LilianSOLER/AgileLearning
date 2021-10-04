package object.gui.widgets;

import object.gui.Component;
import object.gui.Container;
import object.gui.Dimension;
import object.gui.KeyListener;
import object.gui.MouseListener;
import object.gui.window.Font;
import object.gui.window.Graphics;
import object.gui.window.Image;
import object.gui.window.Window;

public class Button extends Component {

  public Button(Container parent) {
    super(parent);
  }

  public void setBorder(int border) {
    throw new RuntimeException("Not Yet Implemented");
  }

  public int getBorder() {
    throw new RuntimeException("Not Yet Implemented");
  }

  public String getLabel() {
    return null; 
  }

  public void setListener(ButtonListener l) {
    // Wait to implement this method until you are asked to do so.
    throw new RuntimeException("Not Yet Implemented");
  }

  public void setFont(Font f) {
    throw new RuntimeException("Not Yet Implemented");
  }

  public void setLabel(String txt) {
    throw new RuntimeException("Not Yet Implemented");
  }

  public void setImages(Image released, Image pressed) {
    // Wait to implement this method until you are asked to.
    throw new RuntimeException("Not Yet Implemented");
  }

}
