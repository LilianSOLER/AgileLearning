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
package oop.calculator.ast;

import java.io.PrintStream;

import oop.calculator.CastException;
import oop.calculator.types.Type;

public abstract class BinaryOp extends Expression {

  String op;
  Expression left, right;

  public BinaryOp(String op, Expression l, Expression r) throws CastException {
    this.op = op;
    this.left = l;
    this.right = r;
  }

  @Override
  public String toString() {
    return "("+left+op+right+")";
  }

  @Override
  public void prettyPrint(PrintStream ps, int nspaces) {
    ps.print('(');
    left.prettyPrint(ps,nspaces);
    ps.print(' ');
    ps.print(op);
    ps.print(' ');
    right.prettyPrint(ps,nspaces);
    ps.print(')');
  }
  
}
