package object.gui.layout;

import object.gui.Container;
import object.gui.Dimension;

public abstract class LayoutManager {

  /**
   * Lays out the given container.
   * Most applications do not call this method directly. 
   * This method is called from the container method doLayout().
   * 
   * @param parent the container to be laid out
   */
  public abstract void layout(Container target);

  /**
   * Determines the preferred size of the <code>target</code>
   * container using this layout manager, based on the components
   * in the container.
   * Most applications do not call this method directly,
   * it is called from the container method getPreferredSize().
   * 
   * @param   target   the container in which to do the layout.
   * @return  the preferred dimension for the target container.
   */
  public abstract Dimension preferredSize(Container target);

}
