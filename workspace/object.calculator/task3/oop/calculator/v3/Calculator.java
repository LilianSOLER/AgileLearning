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
package oop.calculator.v3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Calculator {

  private PrintStream m_ps;
  private Parser m_parser;

  Calculator(PrintStream ps, IFactory factory) {
    m_ps = ps;
    m_parser = new Parser(factory);
  }

  public void loop(InputStream is) throws IOException {
    BufferedReader br;
    br = new BufferedReader(new InputStreamReader(is));

    String line;
    m_ps.println("> ");
    m_ps.flush();
    line = br.readLine();
    while (line != null) {
      line = line.trim();
      if (!line.startsWith("#")) {
        try {
          Expression exp;
          exp = m_parser.parse(line);
          if (exp != null) {
            m_ps.print("-> ");
            exp.print(m_ps);
            Value value;
            value = exp.eval();
            m_ps.println("\n= " + value);
          }
        } catch (Exception ex) {
          m_ps.println();
          m_ps.println("  exception: " + ex.toString());
        }
      }
      m_ps.println("> ");
      m_ps.flush();
      line = br.readLine();
    }
  }

}
