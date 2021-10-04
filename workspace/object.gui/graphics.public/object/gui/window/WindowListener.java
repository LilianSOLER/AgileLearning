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
 * The listener is told when the window is resized and when it needs
 * to be repainted. 
 * The invocations respect the following regular expression:
 *    ( resized paint* )+
 * So you always have a resized event first, telling you the
 * initial size of the window before you are asked to repaint.
 */
public interface WindowListener {

  /**
   * Ask that the window be repainted.
   * @param g
   */
  void paint(Graphics g);

  /**
   * Tells that the window has been resized to the given dimension.
   * @param width
   * @param height
   */
  void resized(int width, int height);
  
  /**
   * Expired timer.
   */
  void expired();
}
