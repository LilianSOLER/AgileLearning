package oop.calculator.ast;

import oop.calculator.CastException;
import oop.calculator.types.Type;

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
public abstract class ArithValue extends Value {

  protected ArithValue(Type t) {
    super(t);
  }
  
  /*
   * Is this value the 'zero value'?
   */
  abstract public boolean isZero();

  /*
   * These are the supported arithmetic operations.
   * Look at the corresponding operator classes
   * (NegOp, AddOp, SubOp, MulOp, DivOp).
   * Examples:
   *        -3
   *        2 + 3
   *        2 - 3
   *        2 * 3
   *        2 / 3
   */
  abstract public ArithValue neg() throws CastException;
  abstract public ArithValue add(ArithValue v) throws CastException;
  abstract public ArithValue sub(ArithValue v) throws CastException;
  abstract public ArithValue mul(ArithValue v) throws CastException;
  abstract public ArithValue div(ArithValue v) throws CastException;

  /*
   * These are the supported comparison operators:
   *    lt: '<'  : less than
   *    le: '<=' : less than or equal
   *    gt: '>'  : greater than
   *    ge: '>=' : greater than or equal
   * Examples:
   *    (x < y)
   *    (x <= y)
   *    (x > y)
   *    (x >= y)
   */
  public abstract BoolValue lt(ArithValue v) throws CastException;
  public abstract BoolValue le(ArithValue v) throws CastException;
  public abstract BoolValue gt(ArithValue v) throws CastException;
  public abstract BoolValue ge(ArithValue v) throws CastException;


}
