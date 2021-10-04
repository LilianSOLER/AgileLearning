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
package object.gui;

/**
 * This is the mouse listener telling you about what happens
 * with the mouse, if it is moved or if its buttons are pressed
 * or released.
 */

public interface MouseListener {

  public static final int NOBUTTON = object.gui.window.MouseListener.NOBUTTON;
  public static final int BUTTON1 = object.gui.window.MouseListener.BUTTON1;
  public static final int BUTTON2 = object.gui.window.MouseListener.BUTTON2;
  public static final int BUTTON3 = object.gui.window.MouseListener.BUTTON3;

  /**
   * Tells the mouse moved to the given location (x,y)
   */
  public void mouseMoved(Component c, int x, int y);

  /**
   * Tells the given button was pressed when the mouse
   * was at the given location (x,y).
   */
  public void mousePressed(Component c, int x, int y, int button);

  /**
   * Tells the given button was released when the mouse
   * was at the given location (x,y).
   */
  public void mouseReleased(Component c, int x, int y, int button);

  /**
   * Tells the mouse entered the window.
   */
  public void mouseEntered(Component c, int x, int y);

  /**
   * Tells the mouse exited the window.
   */
  public void mouseExited(Component c);

}
