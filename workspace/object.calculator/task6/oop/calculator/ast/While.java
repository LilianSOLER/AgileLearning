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

public class While extends Statement {

  Expression m_cond;
  Block m_block;

  public While(Expression exp, Block b) {
    m_cond = exp;
    m_block = b;
  }

  public String toString() {
    String s = "while " + m_cond + " {\n";
    s += m_block.toString();
    s += "}\n";
    return s;
  }

  public void prettyPrint(PrintStream ps, int nspaces) {
    Statement.tab(ps, nspaces);
    ps.print("while ");
    m_cond.prettyPrint(ps, nspaces);
    ps.println("{");
    m_block.prettyPrint(ps, nspaces + 2);
    Statement.tab(ps, nspaces);
    ps.println("}");
    return;
  }

  @Override
  public Value eval(Scope parent) throws CalculatorException {
    throw new RuntimeException("Not Yet Implemented");
  }

}
