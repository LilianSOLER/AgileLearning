package object.gui.widgets;

/**
 * Copied and adapted from java.awt.Rectangle.
 * @author Pr. Olivier Gruber.
 *
 */
public class Rectangle {

  public int x, y, width, height;

  public Rectangle() {
  }

  /**
   * Constructs a new <code>Rectangle</code>, initialized to match
   * the values of the specified <code>Rectangle</code>.
   * @param r  the <code>Rectangle</code> from which to copy initial values
   *           to a newly constructed <code>Rectangle</code>
   */
  public Rectangle(Rectangle r) {
    this(r.x, r.y, r.width, r.height);
  }

  /**
   * Constructs a new <code>Rectangle</code> whose upper-left corner is
   * specified as
   * {@code (x,y)} and whose width and height
   * are specified by the arguments of the same name.
   * @param     x the specified X coordinate
   * @param     y the specified Y coordinate
   * @param     width    the width of the <code>Rectangle</code>
   * @param     height   the height of the <code>Rectangle</code>
   */
  public Rectangle(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  /**
   * Constructs a new <code>Rectangle</code> whose upper-left corner
   * is at (0,&nbsp;0) in the coordinate space, and whose width and
   * height are specified by the arguments of the same name.
   * @param width the width of the <code>Rectangle</code>
   * @param height the height of the <code>Rectangle</code>
   */
  public Rectangle(int width, int height) {
    this(0, 0, width, height);
  }

  /**
   * Checks whether or not this <code>Rectangle</code> contains the
   * point at the specified location {@code (x,y)}.
   *
   * @param  x the specified X coordinate
   * @param  y the specified Y coordinate
   * @return    <code>true</code> if the point
   *            {@code (x,y)} is inside this
   *            <code>Rectangle</code>;
   *            <code>false</code> otherwise.
   */
  public boolean contains(double X, double Y) {
    return contains((int)X,(int)Y);
  }
  
  public boolean contains(int X, int Y) {
    int w = this.width;
    int h = this.height;
    if ((w | h) < 0) {
      // At least one of the dimensions is negative...
      return false;
    }
    // Note: if either dimension is zero, tests below must return false...
    int x = this.x;
    int y = this.y;
    if (X < x || Y < y) {
      return false;
    }
    w += x;
    h += y;
    //    overflow || intersect
    return ((w < x || w > X) && (h < y || h > Y));
  }

  /**
   * Checks whether two rectangles are equal.
   * <p>
   * The result is <code>true</code> if and only if the argument is not
   * <code>null</code> and is a <code>Rectangle</code> object that has the
   * same upper-left corner, width, and height as
   * this <code>Rectangle</code>.
   * @param obj the <code>Object</code> to compare with
   *                this <code>Rectangle</code>
   * @return    <code>true</code> if the objects are equal;
   *            <code>false</code> otherwise.
   */
  public boolean equals(Object obj) {
    if (obj instanceof Rectangle) {
      Rectangle r = (Rectangle) obj;
      return ((x == r.x) && (y == r.y) && (width == r.width) && (height == r.height));
    }
    return super.equals(obj);
  }

  /**
   * Returns a <code>String</code> representing this
   * <code>Rectangle</code> and its values.
   * @return a <code>String</code> representing this
   *               <code>Rectangle</code> object's coordinate and size values.
   */
  public String toString() {
    return getClass().getName() + "[x=" + x + ",y=" + y + ",width=" + width + ",height=" + height + "]";
  }

}
