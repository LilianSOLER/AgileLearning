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

public class ButtonDriver {

  static class ClickListener implements ClickDetector.ClickListener {
    int expectedClickCount;

    ClickListener(int count) {
      expectedClickCount = count;
    }

    @Override
    public void clicked(Button b) {
      expectedClickCount--;
    }

    boolean check() {
      return (expectedClickCount == 0);
    }
  }
  
  Button b;
  ClickDetector cd;

  public ButtonDriver() {
    b = new Button();
    cd = new ClickDetector(b);
  }

  public boolean drive(String s, int count) {
    ClickListener cl = new ClickListener(count);
    cd.setListener(cl);
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      switch (c) {
      case 'E':
        b.m_listener.enter(b);
        break;
      case 'L':
        b.m_listener.leave(b);
        break;
      case 'D':
        b.m_listener.down(b);
        break;
      case 'U':
        b.m_listener.up(b);
        break;
      }
    }
    return cl.check();
  }
}
