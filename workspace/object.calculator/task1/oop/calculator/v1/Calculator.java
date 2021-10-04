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
package oop.calculator.v1;

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

  public void loop() throws IOException {
    String line;
    ps.println("Welcome.");
    ps.println("> ");
    ps.flush();
    line = br.readLine();
    while (line != null) {
      ps.println("> ");
      ps.flush();
      try {
        evaluate(line);
      } catch (Exception ex) {
        ps.println("malformed expression");
        ex.printStackTrace();
      }
      ps.println("> ");
      ps.flush();
      line = br.readLine();
    }
  }

  private void skipSeparators() {
    while (chars[offset] == ' ')
      offset++;
  }

  /* 
   * Evaluate the given line, computing the corresponding
   * integer value.
   */
  public void evaluate(String line) {
    chars = line.toCharArray();
    offset = 0;
    skipSeparators();
    switch (chars[offset]) {
    case '+':
    case '-':
    case '*':
    case '/': {
      int val = intExpression();
      ps.println("-> "+val);
      break;
    }
    case '&':
    case '|':
    case '!': {
      boolean val = boolExpression();
      ps.println("-> "+val);
      break;
    }
    default:
      try {
        boolean val = boolValue();
        ps.println("-> "+val);
      } catch (Exception ex) {
        int val = intValue();
        ps.println("-> "+val);
      }
    }
  }

  private int intExpression() {
    int val;
    skipSeparators();
    switch (chars[offset++]) {
    case '+':
      val = add();
      break;
    case '-':
      // the '-' operator is usually binary, but we need to 
      // handle the special case of negative values.
      if (chars[offset] != ' ') {
        return -intValue();
      }
      val = sub();
      break;
    case '*':
      val = mul();
      break;
    case '/':
      val = div();
      break;
    case '&':
    case '|':
    case '!':
      throw new IllegalStateException();
    default:
      offset--;
      val = intValue();
    }
    return val;
  }

  private int intValue() {
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

  private boolean boolValue() {
    skipSeparators();
    char c = chars[offset++];
    if (c=='T')
      return true;
    else if (c=='F')
      return false;
    else {
      throw new IllegalStateException();
    }
  }


  private boolean boolExpression() {
    boolean val;
    skipSeparators();
    switch (chars[offset++]) {
    case '&':
      val = and();
      break;
    case '|':
      val = or();
      break;
    case '!':
      val = not();
      break;
    case '+':
    case '-':
    case '*':
    case '/':
      throw new IllegalStateException();
    default:
      offset--;
      val = boolValue();
    }
    return val;
  }

  private boolean not() {
    return !boolExpression();
  }

  private boolean and() {
    // Note Bene: you must call both boolExpression() 
    //            to read the characters for both arguments 
    //            return boolExpression() && boolExpression()
    //            would not work if the first expression would be false
    boolean b1 = boolExpression();
    boolean b2 = boolExpression();
    return b1 && b2;
  }

  private boolean or() {
    // Note Bene: you must call both boolExpression() 
    //            to read the characters for both arguments 
    //            return boolExpression() || boolExpression()
    //            would not work if the first expression would be true
    boolean b1 = boolExpression();
    boolean b2 = boolExpression();
    return b1 || b2;
  }

  private int add() {
    return intExpression() + intExpression();
  }

  private int sub() {
    return intExpression() - intExpression();
  }

  private int mul() {
    return intExpression() * intExpression();
  }

  private int div() {
    int q = intExpression();
    int d = intExpression();
    if (d==0)
      throw new IllegalStateException("division by zero");
    return q / d;
  }
}
