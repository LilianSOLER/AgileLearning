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

public class Scope {

  protected Scope m_parent;
  protected IList m_vars;
  
  public Scope() {
    m_vars = new LinkedList();
  }

  public Scope(Scope parent) {
    m_parent = parent;
    m_vars = new LinkedList();
  }

  @Override
  public String toString() {
    String s="(";
    IList.Iterator iter = m_vars.iterator();
    while (iter.hasNext()) {
      Variable v = (Variable) iter.next();
      s+=v+",";
    }    
    return s+")";
  }

  public Scope getParent() {
    return m_parent;
  }

  public GlobalScope getRoot() {
    return m_parent.getRoot();
  }

  public IList.Iterator variables() {
    return m_vars.iterator();
  }

  protected Variable _lookup(String name) {
    IList.Iterator iter = m_vars.iterator();
    while (iter.hasNext()) {
      Variable v = (Variable) iter.next();
      if (name.equals(v.name()))
        return v;
    }
    return null;
  }

   /**
   * Lookup the variable definition in this context
   * or in any of the parent scopes.
   * @param name
   * @return
   */
  public Variable lookup(String name) {
    Variable v = _lookup(name);
    if (v == null && m_parent != null)
      v = m_parent.lookup(name);
    return v;
  }

  /**
   * Declare the given variable in this context.
   * Local variables shadow parents' variables.
   * @param v
   * @throws CalculatorException if a name collision occurs with another variable or function
   */
  public void declare(Variable v) throws CalculatorException {
    if (_lookup(v.name()) != null)
      throw new CalculatorException("Variable conflit: "+v.name());
    m_vars.insertAt(0, v);
  }

}