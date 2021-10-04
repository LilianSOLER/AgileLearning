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

public interface IFactory {
  
  /*
   * A separator is usually ' ' but it could be another character
   * or even several characters.
   */
  public boolean isSeparator(char op);
  
  /**
   * An operator is not a digit and not a separator,
   * they are the operator recognized.
   * Examples: '+' or '&'
   * @param op
   * @return
   */
  public boolean isOperator(char op);

  public boolean isBinary(char op);

  public Expression newExpression(char op, Expression left, Expression right);

  public Expression newExpression(char op, Expression exp);

  public Value newValue(char chars[], int off, int len);

}
