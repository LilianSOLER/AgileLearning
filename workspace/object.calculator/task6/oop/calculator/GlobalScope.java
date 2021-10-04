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
package oop.calculator;

import edu.polytech.oop.collections.IList;
import edu.polytech.oop.collections.LinkedList;

public class GlobalScope extends Scope {

  public interface ICalculator {
    public void setEcho(boolean status);

    public void setTerm(boolean status);

    public void load(String filename);
  }

  protected IList m_funcs;
  private ICalculator m_calc;

  public GlobalScope(ICalculator calc) {
    m_funcs = new LinkedList();
    m_calc = calc;
  }

  public void setEcho(boolean status) {
    m_calc.setEcho(status);
  }

  public void setTerm(boolean status) {
    m_calc.setTerm(status);
  }

  public void load(String filename) {
    m_calc.load(filename);
  }

  @Override
  public String toString() {
    String s ="Variables:\n";
    s += "  "+super.toString();
    s+="\nFunctions:\n";
    IList.Iterator iter;
    iter = m_funcs.iterator();
    if (iter != null) {
      while (iter.hasNext()) {
        Function f = (Function) iter.next();
        s += "\n  "+ f.signature() + ",";
      }
    }
    s +="\n";
    return s;
  }

  @Override
  public GlobalScope getRoot() {
    return this;
  }

  public IList.Iterator functions() {
    return m_funcs.iterator();
  }

  /**
   * Declare the given variable in this context.
   * @param v
   * @throws CalculatorException if a name collision occurs with another variable or function
   */
  @Override
  public void declare(Variable v) throws CalculatorException {
    throw new RuntimeException("Not Yet Implemented");
  }

  /**
   * Declare the given function in this context.
   * Local functions shadow parents' functions.
   * @param v
   * @throws CalculatorException if a name collision occurs with another function or variable.
   */
  public void declare(Function f) throws CalculatorException {
    throw new RuntimeException("Not Yet Implemented");
  }

  public Function find(String name) {
    throw new RuntimeException("Not Yet Implemented");
  }

}