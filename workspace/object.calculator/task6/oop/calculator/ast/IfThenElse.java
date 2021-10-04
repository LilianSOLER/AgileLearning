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
import oop.calculator.ast.Expression;
import oop.calculator.ast.Statement;
import oop.calculator.ast.Value;

public class IfThenElse extends Statement {

  Expression m_cond;
  Block m_if;
  Block m_else;

  public IfThenElse(Expression exp, Block b1, Block b2) {
    m_cond = exp;
    m_if = b1;
    m_else = b2;
  }

  public String toString() {
    String s = "if " + m_cond + " {\n";
    s += m_if.toString();
    if (m_else != null) {
      s += "} else {\n";
      s += m_else.toString();
    }
    s += "}\n";
    return s;
  }
  
  @Override
  public void prettyPrint(PrintStream ps,int nspaces) {
    Statement.tab(ps,nspaces);
    ps.print("if ");
    m_cond.prettyPrint(ps, nspaces);
    ps.println(" {");
    m_if.prettyPrint(ps, nspaces+2);
    if (m_else != null) {
      Statement.tab(ps,nspaces);
      ps.println("} else {");
      m_else.prettyPrint(ps, nspaces+2);
    }
    Statement.tab(ps,nspaces);
    ps.println("}");
    return;
  }

  @Override
  public Value eval(Scope parent) throws CalculatorException {
    throw new RuntimeException("Not Yet Implemented");
  }

}
