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
 * An image is a rectangular surface of pixels
 */

public abstract class Image {

  /**
   * @return the width of this image, in pixels.
   */
  public abstract int getWidth();
  /**
   * @return the height of this image, in pixels.
   */
  public abstract int getHeight();
  
  /**
   * @return the sub-image copied from the given bounds
   */
  public abstract Image getSubImage(int x, int y, int w, int h);

}
