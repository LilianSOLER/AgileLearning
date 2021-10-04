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
package oop.calculator.types;

import oop.calculator.CalculatorException;
import oop.calculator.CastException;
import oop.calculator.ast.CastOp;
import oop.calculator.ast.Expression;

public class TypeSystem {

  public static Type VOID;
  public static Type INT;
  public static Type FLOAT;
  public static Type BOOL;

  static {
    VOID = new VoidType();
    BOOL = new BoolType();
    INT = new IntType();
    FLOAT = new FloatType();
  }

  /**
   * Looks a type by name.
   * @param name
   * @param ndims
   * @return
   * @throws Exception
   */
  public static Type lookup(String name) throws Exception {
    if (name.equals("void"))
      return VOID;
    if (name.equals("int"))
      return INT;
    if (name.equals("float"))
      return FLOAT;
    if (name.equals("bool"))
      return BOOL;
    throw new CalculatorException("PANIC: unknown type " + name);
  }

  public static Expression assign(Type dst, Expression exp) throws CastException {
    return dst.assign(exp);
  }

  public static Expression cast(Type type, Expression exp) throws CastException {
    if (type != exp.type())
      exp = new CastOp(type, exp);
    return exp;
  }

  public static Type lift(Type t1, Type t2) throws CastException {
    return t1.lift(t2);
  }
}
