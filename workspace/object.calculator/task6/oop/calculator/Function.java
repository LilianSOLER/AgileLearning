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

import java.io.PrintStream;

import edu.polytech.oop.collections.IList;
import oop.calculator.ast.Block;
import oop.calculator.ast.Statement;
import oop.calculator.ast.Value;
import oop.calculator.types.Type;

public class Function {
  private String m_name;
  private IList/*Argument*/ m_args; 
  private Type m_ret;
  private Block m_body;

  public Function(String name, Type ret) {
    m_name = name;
    m_ret = ret;
  }

  public void prettyPrint(PrintStream ps, int nspaces) {
    ps.println();
    Statement.tab(ps,nspaces);
    ps.print(m_ret.toString());
    ps.print(" ");
    ps.print(m_name);
    if (m_args != null)
      ps.print(m_args.toString());
    else
      ps.print("()");
    ps.print(" ");
    if (m_body == null) {
      ps.println("{}");
    } else {
      ps.println("{");
      m_body.prettyPrint(ps, nspaces+2);
      Statement.tab(ps,nspaces);
      ps.println("}");
    }
    return;
  }
  
  public void setArgs(IList/*Argument*/ args) {
    m_args = args;
  }

  public IList.Iterator/*Argument*/ arguments() {
    if (m_args != null)
      return m_args.iterator();
    return null;
  }

  public IList args() {
    return m_args;
  }

  public Type type() {
    return m_ret;
  }

  public void setBody(Block body) {
    m_body = body;
  }

  public String toString() {
    String s = m_ret + " " + m_name;
    if (m_args != null)
      s += m_args;
    else
      s += "()";
    if (m_body != null)
      s += "{\n" + m_body + "}\n";
    else
      s += "{}\n";
    return s;
  }

  public String signature() {
    String s = m_ret + " " + m_name;
    if (m_args != null)
      s += m_args;
    else
      s += "()";
    return s;
  }

  public String name() {
    return m_name;
  }

  public Block body() {
    return m_body;
  }
  
  public Value eval(Scope scope) throws CalculatorException {
    throw new RuntimeException("Not Yet Implemented");
  }

}
