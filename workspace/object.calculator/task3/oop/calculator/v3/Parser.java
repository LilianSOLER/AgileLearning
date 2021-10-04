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

public class Parser {

  private char chars[];
  private int offset;
  private IFactory factory;

  public Parser(IFactory fact) {
    this.factory = fact;
  }

  public Expression parse(String line) {
    chars = line.toCharArray();
    offset = 0;
    if (chars.length > 0) {
      skipSeparators();
      if (chars[offset]=='#')
        return null;
      return parse();
    } else 
      return null;
  }

  private void skipSeparators() {
    while (factory.isSeparator(chars[offset]))
      offset++;
  }

  private Expression parse() {
    skipSeparators();
    char c = chars[offset++];
    if (factory.isOperator(c)) {
      char op = c;
      if (factory.isBinary(op)) {
        // the '-' operator is usually binary, but we need to 
        // handle the special case of negative values.
        c = chars[offset];
        if (!factory.isSeparator(c)) { 
          offset--;
          return parseValue();
        }
        Expression left, right;
        left = parse();
        right = parse();
        return factory.newExpression(op, left, right);
      } else {
        Expression exp;
        exp = parse();
        return factory.newExpression(op, exp);
      }
    } else {
      offset--;
      return parseValue();
    }
  }

  private Value parseValue() {
    skipSeparators();
    int start = offset;
    while (offset < chars.length) {
      char c = chars[offset];
      if (factory.isSeparator(c))
        break;
      offset++;
    }
    int ndigits = offset - start;
    return factory.newValue(chars, start, ndigits);
  }

}
