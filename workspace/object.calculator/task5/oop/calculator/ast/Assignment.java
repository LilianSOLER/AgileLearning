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
import oop.calculator.ast.Expression;
import oop.calculator.ast.Statement;
import oop.calculator.ast.Value;


public class Assignment extends Statement {

  Symbol m_sym;
  Expression m_exp;

  /**
   * Constructs an assignment, with a symbol on 
   * the left-hand side and an expression on the right-hand side.
   * Nota Bene:
   *            Do not forget to leverage the method 
   *            TypeSystem.assign(Type,Expression)
   *            to be sure to store a correctly typed value in the variable.
   */
  public Assignment(Symbol sym, Expression exp) throws CastException {
    throw new RuntimeException("Not Yet Impletemented");
  }

  public String toString() {
    return m_sym.toString() + " = " + m_exp.toString() + ";";
  }

  @Override
  public void prettyPrint(PrintStream ps, int nspaces) {
    Statement.tab(ps,nspaces);
    ps.println(toString()); 
  }

  public Symbol getSymbol() {
    return m_sym;
  }

  /**
   * This statement is an assignment, of a variable with the 
   * value resulting from the evaluation of an expression.
   * @return the value resulting from the evaluation of the
   *         expression.
   * @throws CastException
   *           if the variable's type is incompatible with the value's type.
   */  
  @Override
  public Value eval(Scope scope) throws CalculatorException {
    throw new RuntimeException("Not Yet Impletemented");
  }


}
