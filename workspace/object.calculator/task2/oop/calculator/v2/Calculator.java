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
package oop.calculator.v2;

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
    ps.print("> ");
    ps.flush();
    line = br.readLine();
    while (line != null) {
      try {
        Expression exp;
        exp = parse(line);
        ps.print("-> ");
        exp.print(ps);
        ps.println();
        Value value;
        value = exp.eval();
        ps.println("\n= " + value);

      } catch (Exception ex) {
        ps.println();
        ex.printStackTrace(ps);
        ps.flush();
      }
      ps.print("> ");
      ps.flush();
      line = br.readLine();
    }
  }

  public Expression parse(String line) {
    chars = line.toCharArray();
    offset = 0;
    skipSeparators();
    switch (chars[offset]) {
    case '+':
    case '-':
    case '*':
    case '/': {
      return parseIntExpression();
    }
    case '&':
    case '|':
    case '!': {
      return parseBoolExpression();
    }
    default:
      try {
        return new BoolValue(boolValue());
      } catch (Exception ex) {
        return new IntValue(intValue());
      }
    }
  }

  private void skipSeparators() {
    while (chars[offset] == ' ')
      offset++;
  }

  private Expression parseIntExpression() {
    Expression left, right;
    skipSeparators();
    char op = chars[offset++];
    switch (op) {
    case '-':
      // the '-' operator is usually binary, but we need to 
      // handle the special case of negative values.
      if (chars[offset] != ' ') {
        return new IntValue(-intValue());
      }
    case '+':
    case '*':
    case '/':
      left = parseIntExpression();
      right = parseIntExpression();
      return new BinaryOp(op, left, right);
    case '!':
    case '&':
    case '|':
      throw new IllegalStateException();
    default:
      offset--;
      return new IntValue(intValue());
    }
  }

  private int intValue() throws NumberFormatException {
    skipSeparators();
    int start = offset;
    while (offset < chars.length) {
      char c = chars[offset];
      if (c < '0' || c > '9')
        break;
      offset++;
    }
    try {
      int ndigits = offset - start;
      String digits = new String(chars, start, ndigits);
      return Integer.parseInt(digits);
    } catch (NumberFormatException ex) {
      offset = start;
      throw ex;
    }
  }

  private boolean boolValue() {
    skipSeparators();
    char c = chars[offset++];
    if (c == 'T')
      return true;
    else if (c == 'F')
      return false;
    else {
      offset--;
      throw new IllegalStateException();
    }
  }

  private Expression parseBoolExpression() {
    Expression left, right;
    skipSeparators();
    char op = chars[offset++];
    switch (op) {
    case '&':
    case '|':
      left = parseBoolExpression();
      right = parseBoolExpression();
      return new BinaryOp(op, left, right);
    case '!':
      left = parseBoolExpression();
      return new UnaryOp(op, left);
    case '+':
    case '-':
    case '*':
    case '/':
      throw new IllegalStateException();
    default:
      offset--;
      return new BoolValue(boolValue());
    }
  }

}
