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
package oop.calculator.ast;

import oop.calculator.CastException;
import oop.calculator.types.Type;

public abstract class Value extends Expression {

  protected Value(Type t) {
    super(t);
  }
  
  /*
   * Conversion methods between our values and Java primitive values.
   * This is a conversion, without type checking. In other words,
   * if the conversion is possible, even with loss of information, 
   * it is always done. 
   * 
   * @throws CastException only when the conversion is impossible,
   *         such as bool to int or float to bool.
   */
  abstract public int toInt() throws CastException;
  abstract public boolean toBool() throws CastException;
  abstract public float toFloat() throws CastException;

  /*
   * These are the supported comparison operators:
   *    eq: '==' : equal
   *    ne: '!=' : not equal
   * Examples:
   *    (x == y)
   *    (x != y)
   */
  public abstract BoolValue eq(Value v) throws CastException;
  public abstract BoolValue ne(Value v) throws CastException;

}
