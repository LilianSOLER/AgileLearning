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

public class Factory2 implements IFactory {

  @Override
  public boolean isSeparator(char op) {
    return op == ' ';
  }

  @Override
  public boolean isOperator(char op) {
    switch (op) {
    case '+':
    case '-':
    case '*':
    case '/':
    case '&':
    case '|':
    case '!':
      return true;
    }
    return false;
  }

  @Override
  public boolean isBinary(char op) {
    switch (op) {
    case '+':
    case '-':
    case '*':
    case '/':
    case '&':
    case '|':
      return true;
    case '!':
      return false;
    default:
      throw new IllegalStateException();
    }
  }

  @Override
  public Expression newExpression(char op, Expression left, Expression right) {
    return new BinaryOp(op, left, right);
  }

  @Override
  public Expression newExpression(char op, Expression exp) {
    return new UnaryOp(op, exp);
  }

  @Override
  public Value newValue(char chars[], int off, int len) {
    if (chars[off] == 'T' && len == 1)
      return new BoolValue(true);
    else if (chars[off] == 'F' && len == 1)
      return new BoolValue(false);
    String digits = new String(chars, off, len);
    int val = Integer.parseInt(digits);
    return new IntValue(val);
  }

}
