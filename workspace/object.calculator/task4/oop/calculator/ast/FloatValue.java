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

import oop.calculator.CastException;
import oop.calculator.Scope;
import oop.calculator.types.TypeSystem;

public class FloatValue extends ArithValue {

  float val;

  public FloatValue(float v) {
    super(TypeSystem.FLOAT);
    val = v;
  }

  @Override
  public String toString() {
    return Float.toString(val);
  }

  @Override
  public boolean isZero() {
    return val==0.0F;
  }

  @Override
  public int toInt() throws CastException {
    return (int)val;
  }

  @Override
  public boolean toBool() throws CastException {
    throw new CastException(TypeSystem.BOOL,this);
  }

  @Override
  public float toFloat() throws CastException {
    return val;
  }

  @Override
  public Value eval(Scope scope) {
    return this;
  }

  @Override
  public void prettyPrint(PrintStream ps, int nspaces) {
    ps.print(Float.toString(val));    
  }

  @Override
  public ArithValue neg() throws CastException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public ArithValue add(ArithValue v) throws CastException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public ArithValue sub(ArithValue v) throws CastException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public ArithValue mul(ArithValue v) throws CastException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public ArithValue div(ArithValue v) throws CastException {
    throw new RuntimeException("Not Yet Implemented");
  }


  @Override
  public BoolValue eq(Value v) throws CastException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public BoolValue ne(Value v) throws CastException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public BoolValue lt(ArithValue v) throws CastException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public BoolValue le(ArithValue v) throws CastException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public BoolValue gt(ArithValue v) throws CastException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public BoolValue ge(ArithValue v) throws CastException {
    throw new RuntimeException("Not Yet Implemented");
  }

}
