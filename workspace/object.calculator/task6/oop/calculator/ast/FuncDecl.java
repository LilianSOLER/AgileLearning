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
import oop.calculator.Function;
import oop.calculator.GlobalScope;
import oop.calculator.Scope;
import oop.calculator.ast.Statement;
import oop.calculator.ast.Value;

public class FuncDecl extends Statement {

  private Function m_func;
  
  public FuncDecl(Function f) {
    m_func = f;
  }
  
  public String toString() {
    return m_func.toString();
  }
  
  @Override
  public void prettyPrint(PrintStream ps, int nspaces) {
    m_func.prettyPrint(ps,nspaces);
  }


  public Function function() {
    return m_func;
  }
  
  @Override
  public Value eval(Scope scope) throws CalculatorException {
    ((GlobalScope)scope).declare(m_func);
    return null;
  }
}
