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
 *  Created on: Jan 19, 2017
 *      Author: Pr. Olivier Gruber <olivier dot gruber at acm dot org>
 */
package edu.java.debug;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Utils {

  static Reader reader = new InputStreamReader(System.in, Charset.defaultCharset());
  static char[] rcb = new char[64];

  static char[] readline() {
    int len;
    try {
      len = reader.read(rcb, 0, rcb.length);
      if (len < 0)
        return null; //EOL
    } catch (IOException ex) {
      return null;
    }
    if (rcb[len - 1] == '\r')
      len--; //remove CR at end;
    else if (rcb[len - 1] == '\n') {
      len--; //remove LF at end;
      if (len > 0 && rcb[len - 1] == '\r')
        len--; //remove the CR, if there is one
    }
    char[] b = new char[len];
    if (len > 0) {
      System.arraycopy(rcb, 0, b, 0, len);
      Arrays.fill(rcb, 0, len, ' ');
    }
    return b;
  }

}
