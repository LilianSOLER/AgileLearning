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

import oop.calculator.ast.Value;
import oop.calculator.types.Type;

/* 
 * A variable is a <em>named storage</em> that holds a value
 * of a certain type. A variable lives within a scope.
 * A variable can be written, with a new value, through an assignment.
 * An initialized variable can be read, reading the value it holds, in
 * any expression, using the variable name as a symbol in the 
 * expression. 
 */
public class Variable {

  private Type m_type;   
  private String m_name; 
  private Value m_value; 

  public Variable(Type type, String name) {
    m_type = type;
    m_name = name;
  }

  public String toString() {
    String s = m_type + " " + m_name;
    if (m_value != null)
      s += " = " + m_value;
    return s;
  }

  public Type type() {
    return m_type;
  }

  public String name() {
    return m_name;
  }

  /**
   * Write the given value in this variable.
   */
  public void write(Value value) {
    if (m_type != value.type())
      throw new IllegalArgumentException("wrong value ("+value.type()+")");
    m_value = value;
  }

  /**
   * @return the value of this variable.
   */
  public Value read() {
    return m_value;
  }

}
