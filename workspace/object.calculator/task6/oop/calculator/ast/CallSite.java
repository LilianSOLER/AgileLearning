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

import edu.polytech.oop.collections.IList;
import oop.calculator.CalculatorException;
import oop.calculator.Function;
import oop.calculator.Scope;

public class CallSite extends Expression {

  Function m_func;
  IList/*Expression*/ m_params;

  public CallSite(Function f, IList params) throws CalculatorException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public String toString() {
    String s = m_func.name();
    if (m_params != null)
      s += m_params;
    else
      s += "()";
    return s;
  }

  @Override
  public void prettyPrint(PrintStream ps, int nspaces) {
    ps.print(m_func.name());
    ps.print('(');
    IList.Iterator iter = m_params.iterator();
    while (iter.hasNext()) {
      Expression param = (Expression) iter.next();
      param.prettyPrint(ps,nspaces);
      if (iter.hasNext())
        ps.print(", ");
    }
    ps.print(')');
    return;
  }

  @Override
  public Value eval(Scope scope) throws CalculatorException {
    throw new RuntimeException("Not Yet Implemented");
  }

}
