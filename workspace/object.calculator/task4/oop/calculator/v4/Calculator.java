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
package oop.calculator.v4;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import oop.calculator.CalculatorException;
import oop.calculator.Scope;
import oop.calculator.ast.Statement;
import oop.calculator.ast.Value;
import oop.calculator.parser.Parser;

public class Calculator {

  private PrintStream m_ps;
  private boolean m_interactive = true;
  private Scope m_scope;
  private Builder m_builder;
  
  void interactive(boolean interactive) {
    m_interactive = interactive;
  }

  public Calculator(PrintStream ps) {
    m_ps = ps;
  }

  public Scope resetContext() throws CalculatorException {
    m_scope = new Scope();
    m_builder = new Builder();
    return m_scope;
  }

  private Statement parse(Parser parser) throws Exception {
    while (true) {
      try {
        parser.setBuilder(m_builder);
        Statement any = parser.parse();
        return any;
      } catch (CalculatorException e) {
        m_ps.println();
        e.printStackTrace(m_ps);
        throw new CalculatorException();
      }
    }
  }

  public void loop(InputStream is) throws IOException {
    Parser parser;
    parser = new Parser(is);
    try {
      resetContext();
      while (true) {
        if (m_interactive) {
          m_ps.print("> ");
          m_ps.flush();
        }
        Statement any;
        try {
          any = parse(parser);
        } catch (CalculatorException th) {
          m_ps.flush();
          parser.ReInit(is);
          continue;
        }
        if (any == null) {
          if (!m_interactive) {
            System.out.println("Done.");
            return;
          }
        } else
          try {
            System.out.print("OK: ");
            any.prettyPrint(System.out, 0);
            System.out.println();
            Value res = any.eval(m_scope);
            if (res != null)
              System.out.println("-> " + res);
          } catch (Exception e) {
            System.out.println();
            e.printStackTrace(System.err);
            System.err.flush();
          }
      }
    } catch (Throwable t) {
      System.out.println();
      System.out.flush();
      t.printStackTrace(System.err);
      System.out.println("Oops. Bye now.");
      System.exit(-1);
    }

  }

}
