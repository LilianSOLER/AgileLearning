/*
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Created on: November, 2019
 *      Author: Pr. Olivier Gruber <olivier dot gruber at acm dot org>
 */package object.gui.window;

/**
 * This is the object that provides all the drawing operations
 * necessary to paint a window.
 */

public interface Graphics {

  /**
   * Creates a new Graphics object based on this
   * Graphics object, but with a new translation and clip area.
   * The new Graphics object has its origin
   * translated to the specified point (x,y).
   * Its clip area is determined by the intersection of the original
   * clip area with the specified rectangle (x,y,w,h).  
   * The arguments are all interpreted in the coordinate system of this
   * Graphics object. 
   * 
   * @param      x   the x coordinate.
   * @param      y   the y coordinate.
   * @param      width   the width of the clipping rectangle.
   * @param      height   the height of the clipping rectangle.
   * @return     a new graphics context.
   */
  public Graphics create(int x, int y, int width, int height);

  /**
   * Disposes of this graphics context and releases
   * any system resources that it is using.
   * A Graphics object cannot be used after
   * dispose has been called.
   * 
   * Graphics objects which are provided as arguments to the
   * paint and update methods of components are automatically 
   * disposed of by the system when those methods return. 
   * 
   * If you create a new Graphics object, you must call dispose 
   * when finished using that Graphics object.
   */
  public abstract void dispose();

  /**
   * Gets this graphics context's current color.
   * @return    this graphics context's current color.
   */
  public abstract Color getColor();

  /**
   * Sets this graphics context's current color to the specified
   * color. All subsequent graphics operations using this graphics
   * context use this specified color.
   * @param     c   the new rendering color.
   */
  public abstract void setColor(Color c);

  /**
   * Sets the paint mode of this graphics context to overwrite the
   * destination with this graphics context's current color.
   * This sets the logical pixel operation function to the paint or
   * overwrite mode.  All subsequent rendering operations will
   * overwrite the destination with the current color.
   */
  public abstract void setPaintMode();

  /**
   * Sets the paint mode of this graphics context to alternate between
   * this graphics context's current color and the new specified color.
   * This specifies that logical pixel operations are performed in the
   * XOR mode, which alternates pixels between the current color and
   * a specified XOR color.
   *
   * When drawing operations are performed, pixels which are the
   * current color are changed to the specified color, and vice versa.
   *
   * Pixels that are of colors other than those two colors are changed
   * in an unpredictable but reversible manner; if the same figure is
   * drawn twice, then all pixels are restored to their original values.
   * @param     c1 the XOR alternation color
   */
  public abstract void setXORMode(Color c1);

  /**
   * Sets the current clip to the rectangle specified by the given
   * coordinates.  This method sets the user clip, which is
   * independent of the clipping associated with device bounds
   * and window visibility.
   * Rendering operations have no effect outside of the clipping area.
   * @param       x the x coordinate of the new clip rectangle.
   * @param       y the y coordinate of the new clip rectangle.
   * @param       width the width of the new clip rectangle.
   * @param       height the height of the new clip rectangle.
   */
  public abstract void setClip(int x, int y, int width, int height);
  
  
  /**
   * Draws a line, using the current color, between the points
   * (x1,&nbsp;y1) and (x2,&nbsp;y2)
   * in this graphics context's coordinate system.
   * @param   x1  the first point's x coordinate.
   * @param   y1  the first point's y coordinate.
   * @param   x2  the second point's x coordinate.
   * @param   y2  the second point's y coordinate.
   */
  public abstract void drawLine(int x1, int y1, int x2, int y2);

  /**
   * Fills the specified rectangle.
   * The left and right edges of the rectangle are at
   * x and x&nbsp;+&nbsp;width&nbsp;-&nbsp;1.
   * The top and bottom edges are at
   * y and y&nbsp;+&nbsp;height&nbsp;-&nbsp;1.
   * The resulting rectangle covers an area
   * width pixels wide by
   * height pixels tall.
   * The rectangle is filled using the graphics context's current color.
   * @param         x   the x coordinate
   *                         of the rectangle to be filled.
   * @param         y   the y coordinate
   *                         of the rectangle to be filled.
   * @param         width   the width of the rectangle to be filled.
   * @param         height   the height of the rectangle to be filled.
   */
  public abstract void fillRect(int x, int y, int width, int height);

  /**
   * Draws the outline of the specified rectangle.
   * The left and right edges of the rectangle are at
   * x and x&nbsp;+&nbsp;width.
   * The top and bottom edges are at
   * y and y&nbsp;+&nbsp;height.
   * The rectangle is drawn using the graphics context's current color.
   * @param         x   the x coordinate
   *                         of the rectangle to be drawn.
   * @param         y   the y coordinate
   *                         of the rectangle to be drawn.
   * @param         width   the width of the rectangle to be drawn.
   * @param         height   the height of the rectangle to be drawn.
   */
  public abstract void drawRect(int x, int y, int width, int height);

  /**
   * Draws the outline of an oval.
   * The result is a circle or ellipse that fits within the
   * rectangle specified by the x, y,
   * width, and height arguments.
   * 
   * The oval covers an area that is
   * width&nbsp;+&nbsp;1 pixels wide
   * and height&nbsp;+&nbsp;1 pixels tall.
   * @param       x the x coordinate of the upper left
   *                     corner of the oval to be drawn.
   * @param       y the y coordinate of the upper left
   *                     corner of the oval to be drawn.
   * @param       width the width of the oval to be drawn.
   * @param       height the height of the oval to be drawn.
   */
  public abstract void drawOval(int x, int y, int width, int height);

  /**
   * Fills an oval bounded by the specified rectangle with the
   * current color.
   * @param       x the x coordinate of the upper left corner
   *                     of the oval to be filled.
   * @param       y the y coordinate of the upper left corner
   *                     of the oval to be filled.
   * @param       width the width of the oval to be filled.
   * @param       height the height of the oval to be filled.
   */
  public abstract void fillOval(int x, int y, int width, int height);

  /**
   * Draws the outline of a circular or elliptical arc
   * covering the specified rectangle.
   * 
   * The resulting arc begins at startAngle and extends
   * for arcAngle degrees, using the current color.
   * Angles are interpreted such that 0&nbsp;degrees
   * is at the 3&nbsp;o'clock position.
   * A positive value indicates a counter-clockwise rotation
   * while a negative value indicates a clockwise rotation.
   * 
   * The center of the arc is the center of the rectangle whose origin
   * is (x,&nbsp;y) and whose size is specified by the
   * width and height arguments.
   * 
   * The resulting arc covers an area
   * width&nbsp;+&nbsp;1 pixels wide
   * by height&nbsp;+&nbsp;1 pixels tall.
   * 
   * The angles are specified relative to the non-square extents of
   * the bounding rectangle such that 45 degrees always falls on the
   * line from the center of the ellipse to the upper right corner of
   * the bounding rectangle. As a result, if the bounding rectangle is
   * noticeably longer in one axis than the other, the angles to the
   * start and end of the arc segment will be skewed farther along the
   * longer axis of the bounds.
   * @param        x the x coordinate of the
   *                    upper-left corner of the arc to be drawn.
   * @param        y the y  coordinate of the
   *                    upper-left corner of the arc to be drawn.
   * @param        width the width of the arc to be drawn.
   * @param        height the height of the arc to be drawn.
   * @param        startAngle the beginning angle.
   * @param        arcAngle the angular extent of the arc,
   *                    relative to the start angle.
   */
  public abstract void drawArc(int x, int y, int width, int height,
                               int startAngle, int arcAngle);

  /**
   * Fills a circular or elliptical arc covering the specified rectangle.
   * 
   * The resulting arc begins at startAngle and extends
   * for arcAngle degrees.
   * Angles are interpreted such that 0&nbsp;degrees
   * is at the 3&nbsp;o'clock position.
   * A positive value indicates a counter-clockwise rotation
   * while a negative value indicates a clockwise rotation.
   * 
   * The center of the arc is the center of the rectangle whose origin
   * is (x,&nbsp;y) and whose size is specified by the
   * width and height arguments.
   * 
   * The resulting arc covers an area
   * width&nbsp;+&nbsp;1 pixels wide
   * by height&nbsp;+&nbsp;1 pixels tall.
   * 
   * The angles are specified relative to the non-square extents of
   * the bounding rectangle such that 45 degrees always falls on the
   * line from the center of the ellipse to the upper right corner of
   * the bounding rectangle. As a result, if the bounding rectangle is
   * noticeably longer in one axis than the other, the angles to the
   * start and end of the arc segment will be skewed farther along the
   * longer axis of the bounds.
   * @param        x the x coordinate of the
   *                    upper-left corner of the arc to be filled.
   * @param        y the y  coordinate of the
   *                    upper-left corner of the arc to be filled.
   * @param        width the width of the arc to be filled.
   * @param        height the height of the arc to be filled.
   * @param        startAngle the beginning angle.
   * @param        arcAngle the angular extent of the arc,
   *                    relative to the start angle.
   */
  public abstract void fillArc(int x, int y, int width, int height,
                               int startAngle, int arcAngle);

  /**
   * Draws a sequence of connected lines defined by
   * arrays of x and y coordinates.
   * Each pair of (x,&nbsp;y) coordinates defines a point.
   * The figure is not closed if the first point
   * differs from the last point.
   * @param       xPoints an array of x points
   * @param       yPoints an array of y points
   * @param       nPoints the total number of points
   */
  public abstract void drawPolyline(int xPoints[], int yPoints[],
                                    int nPoints);

  /**
   * Draws a closed polygon defined by
   * arrays of x and y coordinates.
   * Each pair of (x,&nbsp;y) coordinates defines a point.
   * 
   * This method draws the polygon defined by nPoint line
   * segments, where the first nPoint&nbsp;-&nbsp;1
   * line segments are line segments from
   * (xPoints[i&nbsp;-&nbsp;1],&nbsp;yPoints[i&nbsp;-&nbsp;1])
   * to (xPoints[i],&nbsp;yPoints[i]), for
   * 1&nbsp;&le;&nbsp;i&nbsp;&le;&nbsp;nPoints.
   * The figure is automatically closed by drawing a line connecting
   * the final point to the first point, if those points are different.
   * @param        xPoints   a an array of x coordinates.
   * @param        yPoints   a an array of y coordinates.
   * @param        nPoints   a the total number of points.
   */
  public abstract void drawPolygon(int xPoints[], int yPoints[],
                                   int nPoints);

  /**
   * Fills a closed polygon defined by
   * arrays of x and y coordinates.
   * 
   * This method draws the polygon defined by nPoint line
   * segments, where the first nPoint&nbsp;-&nbsp;1
   * line segments are line segments from
   * (xPoints[i&nbsp;-&nbsp;1],&nbsp;yPoints[i&nbsp;-&nbsp;1])
   * to (xPoints[i],&nbsp;yPoints[i]), for
   * 1&nbsp;&le;&nbsp;i&nbsp;&le;&nbsp;nPoints.
   * The figure is automatically closed by drawing a line connecting
   * the final point to the first point, if those points are different.
   * 
   * The area inside the polygon is defined using an
   * even-odd fill rule, also known as the alternating rule.
   * @param        xPoints   a an array of x coordinates.
   * @param        yPoints   a an array of y coordinates.
   * @param        nPoints   a the total number of points.
   */
  public abstract void fillPolygon(int xPoints[], int yPoints[],
                                   int nPoints);

  /**
   * Draws the text given by the specified string, using this
   * graphics context's current font and color. The baseline of the
   * leftmost character is at position (x,&nbsp;y) in this
   * graphics context's coordinate system.
   * @param       str      the string to be drawn.
   * @param       x        the x coordinate.
   * @param       y        the y coordinate.
   * @throws NullPointerException if str is null.
   */
//  public abstract void drawString(String str, int x, int y);
//  public abstract void drawString(String str, int offset, int length, int x, int y);
  public abstract void drawString(char[] chars, int offset, int length, int x, int y);

  public abstract Font getFont();
  public abstract void setFont(Font f);
  
  /**
   * @return the current font height in pixels.
   */
  public abstract int getFontHeight();

  /**
   * @return the string width in pixels when drawn.
   */
  public abstract int getStringWidth(char chars[], int offset, int length);
  public abstract int getCharWidth(char c);

  /**
   * The image is drawn with its top-left corner at (x,y) in 
   * this graphics context's coordinate space. 
   * Transparent pixels in the image do not affect whatever
   * pixels are already there.
   * @param    img the specified image to be drawn. This method does
   *               nothing if img is null.
   * @param    x   the x coordinate.
   * @param    y   the y coordinate.
   * @param    width   
   * @param    height
   */
  public abstract void drawImage(Image img, int x, int y, int width, int height);

}
