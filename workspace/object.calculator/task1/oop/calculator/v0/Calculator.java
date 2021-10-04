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
package oop.calculator.v0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Calculator {

  private BufferedReader br;
  private char chars[];
  private int offset;
  private PrintStream ps;

  public Calculator(InputStream is, PrintStream ps) {
    this.ps = ps;
    br = new BufferedReader(new InputStreamReader(is));
  }

  /*
   * Never-ending loop that reads a line  
   * and evaluates the corresponding value.
   */
  public void loop() throws IOException {
    String line;
    ps.println("Welcome.");
    ps.println("> ");
    ps.flush();
    line = br.readLine();
    while (line != null) {
      try {
        int val = evaluate(line);
        ps.println("-> " + val);
      } catch (Exception ex) {
        ps.println("malformed expression: " + ex.getMessage());
      }
      ps.println("> ");
      ps.flush();
      line = br.readLine();
    }
  }

  /* 
   * Evaluate the given line, computing the corresponding
   * integer value.
   */
  public int evaluate(String line) {
    chars = line.toCharArray();
    offset = 0;
    return expression();
  }

  /*
   * The name says it all... 
   * The method skips separator characters
   */
  private void skipSeparators() {
    while (chars[offset] == ' ')
      offset++;
  }

  /*
   * This is the core of the parsing and evaluation.
   * Notice the switch for the recognized operators
   * and the call to the methods that carry the evaluation.
   * Also notice that a value is an expression.
   */
  private int expression() {
    int val;
    skipSeparators();
    switch (chars[offset++]) {
    case '+':
      val = add();
      break;
    case '-':
      val = sub();
      break;
    case '*':
      val = mul();
      break;
    case '/':
      val = div();
      break;
    default:
      offset--;
      val = value();
    }
    return val;
  }

  private int value() {
    skipSeparators();
    int start = offset;
    while (offset < chars.length) {
      char c = chars[offset];
      if (c < '0' || c > '9')
        break;
      offset++;
    }
    int ndigits = offset - start;
    String digits = new String(chars, start, ndigits);
    return Integer.parseInt(digits);
  }

  private int add() {
    return expression() + expression();
  }

  private int sub() {
    // the '-' operator is usually binary, but we need to 
    // handle the special case of negative values.
    if (chars[offset] != ' ') {
      return -value();
    }
    return expression() - expression();
  }

  private int mul() {
    return expression() * expression();
  }

  private int div() {
    int q = expression();
    int d = expression();
    if (d==0)
      throw new IllegalStateException("division by zero");
    return q / d;
  }
}
