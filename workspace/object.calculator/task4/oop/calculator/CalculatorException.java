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
package oop.calculator;

public class CalculatorException extends Exception {
  private static final long serialVersionUID = 1L;

  int m_line=-1;
  int m_col=-1;
  
  public CalculatorException() {
  }

  public CalculatorException(String reason) {
    super(reason);
  }

  public CalculatorException(String reason, Throwable cause) {
    super(reason,cause);
  }

  public void setLocation(int line, int col) {
    m_line = line;
    m_col = col;
  }

  @Override
  public String getMessage() {
    if (m_line!=-1) {
      String msg = "Line "+m_line+" column "+m_col+"\n";
      return msg+super.getMessage();
    }
    return super.getMessage();
  }
}
