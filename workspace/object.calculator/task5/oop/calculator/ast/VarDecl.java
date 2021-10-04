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
import oop.calculator.Scope;
import oop.calculator.Variable;
import oop.calculator.ast.Expression;
import oop.calculator.ast.Statement;
import oop.calculator.ast.Value;
import oop.calculator.types.Type;
import oop.calculator.types.TypeSystem;

public class VarDecl extends Statement {

  private Variable m_var;
  private Expression m_exp;

  public VarDecl(Type type, String name, Expression exp) {
    m_var = new Variable(type, name);
    m_exp = exp;
  }

  public String toString() {
    return m_var.toString();
  }

  @Override
  public void prettyPrint(PrintStream ps, int nspaces) {
    Statement.tab(ps, nspaces);
    ps.print(m_var.toString());
    if (m_exp!=null) {
      ps.print(" = "+m_exp.toString());
    }
    ps.println(";");
    return;
  }

  public Variable variable() {
    return m_var;
  }

  @Override
  public Value eval(Scope scope) throws CalculatorException {
    scope.declare(m_var);
    if (m_exp != null) {
      Expression exp;
      exp = TypeSystem.assign(m_var.type(),m_exp); 
      Value v = exp.eval(scope);
      m_var.write(v);
      return v;
    }
    return null;
  }
}
