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

import java.io.PrintStream;

public class BinaryOp extends Expression {

  char op;
  Expression left, right;

  BinaryOp(char op, Expression l, Expression r) {
    this.op = op;
    this.left = l;
    this.right = r;
  }

  @Override
  public Value eval() throws CastException {
    throw new RuntimeException("Not Yet Impletemented");
  }

  @Override
  public void print(PrintStream ps) {
    ps.print('(');
    left.print(ps);
    ps.print(' ');
    ps.print(op);
    ps.print(' ');
    right.print(ps);
    ps.print(')');
  }
}
