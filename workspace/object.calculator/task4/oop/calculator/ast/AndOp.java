package oop.calculator.ast;

import oop.calculator.CalculatorException;
import oop.calculator.CastException;
import oop.calculator.Scope;

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

public class AndOp extends BinaryOp {

  public AndOp(Expression l, Expression r) throws CastException {
    super("&", l, r);
  }

  @Override
  public Value eval(Scope scope) throws CalculatorException {
    BoolValue l, r;
    l = (BoolValue)left.eval(scope);
    r = (BoolValue)right.eval(scope);    
    return l.and(r);
  }
  
}
