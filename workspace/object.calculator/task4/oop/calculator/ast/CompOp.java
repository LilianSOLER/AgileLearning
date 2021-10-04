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
import oop.calculator.types.TypeSystem;

public class CompOp extends BinaryOp {

  public enum OPS {
    EQ("=="), NE("!="), LT("<"), LE("<="), GT(">"), GE(">=");
    
    String name;
    OPS(String n) {
      name = n;
    }
    public String toString() { return name; }
  }

  OPS m_op;

  public CompOp(Expression left, Expression right, OPS op) throws CastException {
    super(op.toString(),left,right);
    m_type = TypeSystem.BOOL;
    m_op = op;
  }

  public String toString() {
    return "("+left.toString() + " "+ m_op + " " + right.toString()+")";
  }
  
  @Override
  public void prettyPrint(PrintStream ps,int nspaces) {
    ps.print('(');
    left.prettyPrint(ps, nspaces+2);
    switch (m_op) {
    case EQ:
      ps.print(" == ");
      break;
    case NE:
      ps.print(" != ");
      break;
    case LT:
      ps.print(" < ");
      break;
    case LE:
      ps.print(" <= ");
      break;
    case GT:
      ps.print(" > ");
      break;
    case GE:
      ps.print(" >= ");
      break;
    default:
      throw new Error("PANIC");
    }
    right.prettyPrint(ps, nspaces+2);
    ps.print(')');
    return;
  }

  @Override
  public Value eval(Scope scope) throws CalculatorException {
    switch (m_op) {
    case EQ:
      throw new RuntimeException("Not Yet Implemented");
    case NE:
      throw new RuntimeException("Not Yet Implemented");
    case LT:
      throw new RuntimeException("Not Yet Implemented");
    case LE:
      throw new RuntimeException("Not Yet Implemented");
    case GT:
      throw new RuntimeException("Not Yet Implemented");
    case GE:
      throw new RuntimeException("Not Yet Implemented");
    default:
      throw new Error("PANIC");
    }
  }
  
}
