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
 */
package object.gui.window;

/**
 * This is the mouse listener telling you about what happens
 * with the mouse, if it is moved or if its buttons are pressed
 * or released.
 */

public interface MouseListener {

  public static final int NOBUTTON = 0;
  public static final int BUTTON1 = 1;
  public static final int BUTTON2 = 2;
  public static final int BUTTON3 = 3;

  /**
   * Tells the mouse moved to the given location (x,y)
   */
  public void mouseMoved(int x, int y);

  /**
   * Tells the given button was pressed when the mouse
   * was at the given location (x,y).
   */
  public void mousePressed(int x, int y, int button);

  /**
   * Tells the given button was released when the mouse
   * was at the given location (x,y).
   */
  public void mouseReleased(int x, int y, int button);

  /**
   * Tells the mouse entered the window.
   */
  public void mouseEntered(int x, int y);

  /**
   * Tells the mouse exited the window.
   */
  public void mouseExited();

}
