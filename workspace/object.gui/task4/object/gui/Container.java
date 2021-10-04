package object.gui;

import object.gui.layout.LayoutManager;

/**
 * This is a mock class, here only to allow the other classes
 * to compile... This needs to be replaced by your implementation
 * done in the previous task (task3).
 * 
 * @author Pr. Olivier Gruber (olivier dot gruber at acm dot org)
 */

public class Container extends Component {

  Container() {
  }
  public Container(Container parent) {
    super(parent);
  }
  public void layoutManager(LayoutManager mgr) {
  }
  public void layout() {
  }
  public int childrenCount() {
    return 0;
  }
  public Component childrenAt(int i) {
    return null;
  }

}
