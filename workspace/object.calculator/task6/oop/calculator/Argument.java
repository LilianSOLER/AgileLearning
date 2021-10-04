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
 *  Created on: November, 2018
 *      Author: Pr. Olivier Gruber <olivier dot gruber at acm dot org>
 */
package oop.calculator;

import oop.calculator.types.Type;

public class Argument {
  private Type m_type;
  private String m_name;

  public Argument(Type type, String name) {
    m_type = type;
    m_name = name;
  }

  public String toString() {
    String s = m_type + " " + m_name;
    return s;
  }

  public Type type() {
    return m_type;
  }

  public String name() {
    return m_name;
  }
}
