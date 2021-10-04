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
package object.gui.task1;

import object.gui.task1.Button.ButtonListener;

public class ClickDetector implements ButtonListener {

  public interface ClickListener {
    void clicked(Button b);
  }

  Button m_button;
  ClickListener m_listener;

  ClickDetector(Button b) {
    m_button = b;
    b.setListener(this);
  }

  void setListener(ClickListener cl) {
    m_listener = cl;
  }

  /**
   * @throws IllegalSequenceException if any illegal 
   *         sequence of events.
   */
  @Override
  public void enter(Button b) {
    throw new RuntimeException("Not Yet Implemented");
  }

  /**
   * @throws IllegalSequenceException if any illegal 
   *         sequence of events.
   */
  @Override
  public void leave(Button b) {
    throw new RuntimeException("Not Yet Implemented");
  }

  /**
   * @throws IllegalSequenceException if any illegal 
   *         sequence of events.
   */
  @Override
  public void down(Button b) {
    throw new RuntimeException("Not Yet Implemented");
  }

  /**
   * @throws IllegalSequenceException if any illegal 
   *         sequence of events.
   */
  @Override
  public void up(Button b) {
    throw new RuntimeException("Not Yet Implemented");
  }

}
