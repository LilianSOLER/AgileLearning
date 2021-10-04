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

/**
 * A frame is the local context to a function call.
 * See CallSite, when calling a function, it creates
 * a new frame. So the frames constitute the call stack.
 */
public class Frame extends Scope {
  private Function m_func;
  
  public Frame(Scope parent, Function f, IList params) throws CalculatorException  {
    super(parent);
    throw new RuntimeException("Not Yet Implemented");
  }

  public Function func() {
    return m_func;
  }
    
  /**
   * Lookup the variable definition in this context,
   * or in the global context, but not in any other parent 
   * in between (that is the stack of our callers).
   * @param name
   * @return
   */
  public Variable lookup(String name) {
    throw new RuntimeException("Not Yet Implemented");
  }

}
