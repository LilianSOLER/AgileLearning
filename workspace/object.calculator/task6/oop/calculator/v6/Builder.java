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
package oop.calculator.v6;

import edu.polytech.oop.collections.IList;
import oop.calculator.Argument;
import oop.calculator.CalculatorException;
import oop.calculator.Function;
import oop.calculator.GlobalScope;
import oop.calculator.Scope;
import oop.calculator.UnknownVariableException;
import oop.calculator.Variable;
import oop.calculator.ast.AddOp;
import oop.calculator.ast.AndOp;
import oop.calculator.ast.Assignment;
import oop.calculator.ast.Block;
import oop.calculator.ast.BoolValue;
import oop.calculator.ast.CallSite;
import oop.calculator.ast.CastOp;
import oop.calculator.ast.CompOp;
import oop.calculator.ast.DivOp;
import oop.calculator.ast.Expression;
import oop.calculator.ast.FloatValue;
import oop.calculator.ast.FuncDecl;
import oop.calculator.ast.IfThenElse;
import oop.calculator.ast.IntValue;
import oop.calculator.ast.MulOp;
import oop.calculator.ast.NegOp;
import oop.calculator.ast.NotOp;
import oop.calculator.ast.OrOp;
import oop.calculator.ast.Return;
import oop.calculator.ast.Statement;
import oop.calculator.ast.SubOp;
import oop.calculator.ast.Symbol;
import oop.calculator.ast.VarDecl;
import oop.calculator.ast.While;
import oop.calculator.parser.IBuilder;
import oop.calculator.types.Type;
import oop.calculator.types.TypeSystem;

public class Builder implements IBuilder {

  Scope m_ctxt;
  GlobalScope m_root;

  public Builder(GlobalScope root) throws CalculatorException {
    m_root = new GlobalScope(null);
    m_ctxt = m_root;

    IList.Iterator iter;

    iter = root.variables();
    if (iter != null) {
      while (iter.hasNext()) {
        Variable v = (Variable) iter.next();
        m_root.declare(v);
      }
    }
    iter = root.functions();
    if (iter != null) {
      while (iter.hasNext()) {
        Function f = (Function) iter.next();
        m_root.declare(f);
      }
    }
  }

  /**
   * The parser has seen a function call site:
   * Example: 
   *          foo(2);
   */
  public Expression newCallSite(String name, IList params) throws Exception {
    Function f = m_root.find(name);
    return new CallSite(f, params);
  }

  /**
   * Creates an integer value.
   */
  public Expression newInteger(String s) throws Exception {
    int i = Integer.parseInt(s);
    return new IntValue(i);
  }

  /**
   * Creates an float value.
   */
  public Expression newFloat(String s) throws Exception {
    float f = Float.parseFloat(s);
    return new FloatValue(f);
  }

  /**
   * Creates an boolean value.
   */
  public Expression newBoolean(String s) throws Exception {
    boolean b = Boolean.parseBoolean(s);
    return new BoolValue(b);
  }

  /**
   * The parser has seen a symbol, that is, the name of a 
   * variable or of a function.
   */
  public Symbol newSymbol(String name) throws Exception {
    Variable v = m_ctxt.lookup(name);
    if (v == null) {
      Function f = m_root.find(name);
      if (f == null)
        throw new UnknownVariableException("Unknown symbol: " + name);
      return new Symbol(name, f.type());
    }
    return new Symbol(name, v.type());
  }

  /**
   * The parser has seen an addition.
   * Example: 
   *          2 + 5.6
   */
  public Expression newAddOp(Expression left, Expression right) throws Exception {
    return new AddOp(left, right);
  }

  /**
   * The parser has seen an subtraction.
   * Example: 
   *          2 - 5.6
   */
  public Expression newSubOp(Expression left, Expression right) throws Exception {
    return new SubOp(left, right);
  }

  /**
   * The parser has seen an division.
   * Example: 
   *          2 / 5.6
   */
  public Expression newDivOp(Expression left, Expression right) throws Exception {
    return new DivOp(left, right);
  }

  /**
   * The parser has seen an multiply.
   * Example: 
   *          2 * 5.6
   */
  public Expression newMulOp(Expression left, Expression right) throws Exception {
    return new MulOp(left, right);
  }

  /**
   * The parser has seen a "-" operator on an expression:
   * Example: 
   *          -z ;
   */
  public Expression newNegOp(Expression exp) throws Exception {
    return new NegOp(exp);
  }

  /**
   * The parser has seen a "!" operator on an expression:
   * Example: 
   *          ! z ;
   */

  public Expression newNotOp(Expression exp) throws Exception {
    return new NotOp(exp);
  }

  /**
   * The parser has seen an operator &&. (x && y)
   * Example: 
   *          x && y 
   */
  public Expression newAndOp(Expression left, Expression right) throws Exception {
    return new AndOp(left, right);
  }

  /**
   * The parser has seen an operator ||.
   * Example: 
   *          x || y 
   */
  public Expression newOrOp(Expression left, Expression right) throws Exception {
    return new OrOp(left, right);
  }

  /**
   * The parser has seen an assignment.
   * Example: 
   *          x = 5.6;
   */
  public Statement newAssignment(Symbol sym, Expression exp) throws Exception {
    return new Assignment(sym, exp);
  }

  /**
   * The parser is parsing a function declaration
   * Example: 
   *          int foo(...
   */
  public Function openFunction(String name, Type type) throws Exception {
    Function f = new Function(name, type);
    m_root.declare(f);
    m_ctxt = new Scope(m_ctxt);
    return f;
  }

  /**
   * The parser has parsed the arguments of a function.
   * Example: 
   *          int foo(int x, char c)  ...
   */
  public Function setArgs(Function f, IList/*Argument*/ args) throws Exception {
    f.setArgs(args);
    if (args != null) {
      IList.Iterator aiter = args.iterator();
      while (aiter != null && aiter.hasNext()) {
        Argument arg = (Argument) aiter.next();
        Variable var = new Variable(arg.type(), arg.name());
        // System.out.println(" arg=" + var);
        m_ctxt.declare(var);
      }
    }
    return f;
  }

  /**
   * The parser has parsed a function declaration, including its body.
   * Example:
   *    int foo(int x) { return x; }
   */
  public Statement closeFunction(Function f, Block block) throws Exception {
    f.setBody(block);
    m_ctxt = m_ctxt.getParent();
    return new FuncDecl(f);
  }

  /**
   * The parser has seen a new declaration of a variable, with an optional
   * initializer (the expression). 
   * Example: 
   *          int x = 2;
   */
  public Statement newDeclaration(Type type, String name, Expression exp) throws Exception {
    Variable v = new Variable(type, name);
    m_ctxt.declare(v);
    return new VarDecl(type, name, exp);
  }

  /**
   * The parser has seen a return in a block
   * Examples: 
   *          return x;
   *          return; 
   */
  public Statement newReturn(Expression exp) {
    return new Return(exp);
  }

  /**
   * The parser has seen an "if-then-else" statement in a block.
   * Example:
   *            if ( x == 0 ) {
   *              ...
   *            } else {
   *              ...
   *            }
   */
  public Statement newIfThenElse(Expression cond, Block ifBlock, Block elseBlock) {
    return new IfThenElse(cond, ifBlock, elseBlock);
  }

  /**
   * The parser has seen an "while" statement in a block
   */
  public Statement newWhile(Expression cond, Block block) {
    return new While(cond, block);
  }

  /**
   * The parser has seen the beginning of a block with '{'
   */
  public Block openBlock(Block parent) {
    m_ctxt = new Scope(m_ctxt);
    return new Block(parent);
  }

  /**
   * The parser has seen the end of a block with '}'
   */
  public void closeBlock(Block b, IList/*Statement*/ statements) {
    m_ctxt = m_ctxt.getParent();
    if (statements != null) {
      IList.Iterator iter = statements.iterator();
      while (iter.hasNext()) {
        Statement s = (Statement) iter.next();
        b.append(s);
      }
    }
  }

  /**
   * The parser has seen a new type.
   * Example:
   *            int
   *            float
   * @param name of the type
   */
  public Type lookupType(String name) throws Exception {
    if (name.equals("void"))
      return TypeSystem.VOID;
    if (name.equals("int"))
      return TypeSystem.INT;
    if (name.equals("float"))
      return TypeSystem.FLOAT;
    if (name.equals("bool"))
      return TypeSystem.BOOL;
    throw new CalculatorException("PANIC: unknown type " + name);
  }

  /**
   * The parser has seen a cast.
   * Example: 
   *          (int)foo(3.3);
   */
  public Expression newCastOp(Type type, Expression exp) throws Exception {
    return new CastOp(type, exp);
  }

  /**
   * The parser has parsed an argument of a function declaration
   * Example: 
   *          int foo(int x, char c)  ...
   */
  public Argument newArgument(Type type, String name) throws Exception {
    return new Argument(type, name);
  }

  /**
   * The parser has seen an operator ==. (x == y)
   * Example: 
   *          x == y 
   */
  public Expression newEQCond(Expression left, Expression right) throws Exception {
    return new CompOp(left, right, CompOp.OPS.EQ);
  }

  /**
   * The parser has seen an operator !=. 
   * Example: 
   *          x != y 
   */
  public Expression newNECond(Expression left, Expression right) throws Exception {
    return new CompOp(left, right, CompOp.OPS.NE);
  }

  /**
   * The parser has seen an operator <.
   * Example: 
   *          x < y 
   */
  public Expression newLTCond(Expression left, Expression right) throws Exception {
    return new CompOp(left, right, CompOp.OPS.LT);
  }

  /**
   * The parser has seen an operator <=.
   * Example: 
   *          x <= y 
   */
  public Expression newLECond(Expression left, Expression right) throws Exception {
    return new CompOp(left, right, CompOp.OPS.LE);
  }

  /**
   * The parser has seen an operator >. 
   * Example: 
   *          x > y 
   */
  public Expression newGTCond(Expression left, Expression right) throws Exception {
    return new CompOp(left, right, CompOp.OPS.GT);
  }

  /**
   * The parser has seen an operator >=.
   * Example: 
   *          x >= y 
   */
  public Expression newGECond(Expression left, Expression right) throws Exception {
    return new CompOp(left, right, CompOp.OPS.GE);
  }

}
