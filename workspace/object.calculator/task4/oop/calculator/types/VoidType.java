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

import oop.calculator.CastException;
import oop.calculator.ast.Expression;
import oop.calculator.ast.Value;

public class VoidType extends Type {

  public VoidType() {
    super("void");
  }

  @Override
  public Expression assign(Expression exp) throws CastException {
    throw new CastException(this, exp.type());
  }

  @Override
  public Value cast(Value v) throws CastException {
    throw new Error("PANIC: should never happen");
  }

  @Override
  public Type lift(Type t2) throws CastException {
    throw new CastException(this, t2);
  }

}
