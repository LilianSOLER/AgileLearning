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
 * Represents a font that is used to draw text in a window, via
 * a Graphics object.
 */

public abstract class Font {
  
  /**
   * The plain style constant.
   */
  public static final int PLAIN       = 0;

  /**
   * The bold style constant.  This can be combined with the other style
   * constants (except PLAIN) for mixed styles.
   */
  public static final int BOLD        = 1;

  /**
   * The italicized style constant.  This can be combined with the other
   * style constants (except PLAIN) for mixed styles.
   */
  public static final int ITALIC      = 2;
  
  /**
   * Derive a new font from this font, with the given style and size.
   * @param style
   * @param size
   * @return
   */
  public abstract Font derive(int style, float size);

  /**
   * @return the size of this font.
   */
  public abstract float getSize();
  
  /**
   * @return the style of this font.
   */
  public abstract int getStyle();


  /**
   * Returns the advance width of the specified character in this
   * Font.  The advance is the
   * distance from the leftmost point to the rightmost point on the
   * character's baseline.  Note that the advance of a
   * String is not necessarily the sum of the advances
   * of its characters.
   *
   * @param ch the character to be measured
   * @return     the advance width of the specified character
   *                  in the Font described by this
   *                  FontMetrics object.
   */
  public abstract int charWidth(char ch);

  /**
   * Returns the total advance width for showing the specified array
   * of characters in this Font.  The advance is the
   * distance from the leftmost point to the rightmost point on the
   * string's baseline.  The advance of a String
   * is not necessarily the sum of the advances of its characters.
   * This is equivalent to measuring a String of the
   * characters in the specified range.
   * @param data the array of characters to be measured
   * @param off the start offset of the characters in the array
   * @param len the number of characters to be measured from the array
   * @return    the advance width of the subarray of the specified
   *               char array in the font described by
   *               this FontMetrics object.
   * @throws    NullPointerException if data is null.
   * @throws    IndexOutOfBoundsException if the off
   *            and len arguments index characters outside
   *            the bounds of the data array.
   */
  public abstract int charsWidth(char data[], int off, int len);

  /**
   * Gets the standard height of a line of text in this font.  This
   * is the distance between the baseline of adjacent lines of text.
   * It is the sum of the leading + ascent + descent. Due to rounding
   * this may not be the same as getAscent() + getDescent() + getLeading().
   * There is no guarantee that lines of text spaced at this distance are
   * disjoint; such lines may overlap if some characters overshoot
   * either the standard ascent or the standard descent metric.
   * @return    the standard height of the font.
   */
  public abstract int getHeight();

  
  /**
   * Determines the <em>standard leading</em> of the
   * <code>Font</code> described by this <code>FontMetrics</code>
   * object.  The standard leading, or
   * interline spacing, is the logical amount of space to be reserved
   * between the descent of one line of text and the ascent of the next
   * line. The height metric is calculated to include this extra space.
   * @return    the standard leading of the <code>Font</code>.
   */
  public abstract int getLeading();

  /**
   * Determines the <em>font ascent</em> of the <code>Font</code>
   * described by this <code>FontMetrics</code> object. The font ascent
   * is the distance from the font's baseline to the top of most
   * alphanumeric characters. Some characters in the <code>Font</code>
   * might extend above the font ascent line.
   * @return     the font ascent of the <code>Font</code>.
   */
  public abstract int getAscent();
  
  /**
   * Determines the <em>font descent</em> of the <code>Font</code>
   * described by this
   * <code>FontMetrics</code> object. The font descent is the distance
   * from the font's baseline to the bottom of most alphanumeric
   * characters with descenders. Some characters in the
   * <code>Font</code> might extend
   * below the font descent line.
   * @return     the font descent of the <code>Font</code>.
   * @see        #getMaxDescent()
   */
  public abstract int getDescent();

}
