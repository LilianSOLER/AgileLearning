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
import edu.polytech.oop.collections.LinkedList;
import oop.calculator.CalculatorException;
import oop.calculator.Scope;

public class Block extends Statement {
  Block m_parent;
  IList/*Statement*/ m_statements;

  public Block(Block parent) {
    m_statements = new LinkedList();
    m_parent = parent;
  }

  @Override
  public String toString() {
    String str = "";
    IList.Iterator iter = m_statements.iterator();
    while (iter.hasNext()) {
      Statement s = (Statement) iter.next();
      str += s.toString();
      str += "\n";
    }
    return str;
  }

  /**
   * Append the given statement at the end
   * of the list of statements.
   * @param s
   */
  public void append(Statement s) {
    m_statements.insertAt(m_statements.length(), s);
  }

  /**
   * Prepend the given statement at the beginning 
   * of the list of statements.
   * @param s
   */
  public void prepend(Statement s) {
    m_statements.insertAt(0, s);
  }

  @Override
  public void prettyPrint(PrintStream ps, int nspaces) {
    IList.Iterator iter = m_statements.iterator();
    while (iter.hasNext()) {
      Statement s = (Statement) iter.next();
      if (s instanceof CallSite) {
        Statement.tab(ps,nspaces);
        s.prettyPrint(ps, nspaces);
        ps.println(";");
      } else 
        s.prettyPrint(ps, nspaces);
    }
    return;
  }

  @Override
  public Value eval(Scope ctxt) throws CalculatorException {
    throw new RuntimeException("Not Yet Implemented");
  }

}
