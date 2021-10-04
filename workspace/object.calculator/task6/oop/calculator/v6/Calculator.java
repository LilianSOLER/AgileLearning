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
package oop.calculator.v6;

import java.io.InputStream;
import java.io.PrintStream;

import oop.calculator.CalculatorException;
import oop.calculator.GlobalScope;
import oop.calculator.ast.Statement;
import oop.calculator.ast.Value;
import oop.calculator.parser.Parser;

public class Calculator {

  static boolean term = true;
  static boolean echo = true;

  private PrintStream m_ps;
  private InputStream m_is;
  private GlobalScope m_ctxt;
  private Parser m_parser;

  void interactive(boolean interactive) {
    term = interactive;
  }

  public Calculator(PrintStream ps) throws Exception {
    m_ps = ps;
    resetContext();
  }

  public GlobalScope resetContext() throws CalculatorException {
    m_ctxt = new GlobalScope(null);
    return m_ctxt;
  }

  public GlobalScope getContext() {
    return m_ctxt;
  }

  private Statement parse() throws Exception {
    while (true) {
      try {
        Builder builder = new Builder(m_ctxt);
        m_parser.setBuilder(builder);
        Statement any = m_parser.parse();
        return any;
      } catch (CalculatorException e) {
        m_ps.println();
        e.printStackTrace(m_ps);
        throw new CalculatorException();
      }
    }
  }

  public void loop(InputStream is) {
    m_is = is;
    m_parser = new Parser(m_is);
    try {
      while (true) {
        if (term) {
          m_ps.print("> ");
          m_ps.flush();
        }
        Statement any;
        try {
          any = parse();
        } catch (CalculatorException th) {
          m_ps.flush();
          m_parser.ReInit(m_is);
          continue;
        }
        if (any == null) {
          if (!term) {
            System.out.println("Done.");
            return;
          }
        } else
          try {
            if (echo) {
              System.out.print("OK: ");
              any.prettyPrint(System.out, 0);
              System.out.println();
              Value res = any.eval(m_ctxt);
              if (res != null)
                System.out.println("-> " + res);
            } else {
              any.eval(m_ctxt);
            }
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
