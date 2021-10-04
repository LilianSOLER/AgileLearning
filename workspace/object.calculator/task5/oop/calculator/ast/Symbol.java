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
import oop.calculator.ast.Value;
import oop.calculator.types.Type;

public class Symbol extends Expression {

  private String m_name;

  public Symbol(String name, Type type) {
    super(type);
    m_name = name;
  }

  public Type type() {
    return m_type;
  }

  public String name() {
    return m_name;
  }

  public String toString() {
    return m_name;
  }

  @Override
  public void prettyPrint(PrintStream ps, int nspaces) {
    ps.print(m_name);
    return;
  }

  /**
   * Reads the value from the variable named by this symbol
   * in the given scope
   */
  @Override
  public Value eval(Scope scope) throws CalculatorException {
    throw new RuntimeException("Not Yet Impletemented");
  }
  
}
