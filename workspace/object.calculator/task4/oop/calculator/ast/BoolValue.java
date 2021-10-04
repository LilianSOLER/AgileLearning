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

import java.io.PrintStream;

import oop.calculator.CalculatorException;
import oop.calculator.CastException;
import oop.calculator.Scope;
import oop.calculator.types.Type;
import oop.calculator.types.TypeSystem;

public class BoolValue extends Value {
  boolean val;

  public BoolValue(boolean v) {
    super(TypeSystem.BOOL);
    val = v;
  }

  @Override
  public String toString() {
    return Boolean.toString(val);
  }


  @Override
  public int toInt() throws CastException {
    throw new CastException(TypeSystem.INT,this);
  }

  @Override
  public boolean toBool() throws CastException {
    return val;
  }

  @Override
  public float toFloat() throws CastException {
    throw new CastException(TypeSystem.FLOAT,this);
  }

  @Override
  public Value eval(Scope scope) throws CalculatorException {
    return this;
  }

  @Override
  public void prettyPrint(PrintStream ps,int nspaces) {
    ps.print(val);
  }

  public BoolValue and(BoolValue v) throws CastException {
    return new BoolValue(val && v.toBool());
  }
  public BoolValue or(BoolValue v) throws CastException {
    return new BoolValue(val || v.toBool());
  }
  public BoolValue not() throws CastException {
    return new BoolValue(!val);
  }

  @Override
  public BoolValue eq(Value v) throws CastException {
    return new BoolValue(val == v.toBool());
  }

  @Override
  public BoolValue ne(Value v) throws CastException {
    return new BoolValue(val != v.toBool());
  }
}
