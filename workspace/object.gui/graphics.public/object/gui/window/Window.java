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
 *  Created on: November, 2019
 *      Author: Pr. Olivier Gruber <olivier dot gruber at acm dot org>
 */
package object.gui.window;

import java.io.InputStream;

/**
 * A window is a rectangular surface of pixels, showing on a screen
 * and managed by the window manager of the operating system.
 */
public abstract class Window {

  protected static Window self;

  public static Window getWindow() {
    return self;
  }

  public static Window InitWindow() {
    if (self == null) 
      self = new GuiWindow(640, 480);
    return self;
  }

  public static Window InitWindow(int width, int height) {
    if (self == null) 
      self = new GuiWindow(width, height);
    return self;
  }

  public abstract void setCallback(Runnable callback);

  public abstract void close();

  public abstract void setKeyListener(object.gui.window.KeyListener kl);

  public abstract void setMouseListener(object.gui.window.MouseListener ml);

  public abstract void setWindowListener(object.gui.window.WindowListener pl);

  public abstract void repaint();

  public abstract int getWidth();

  public abstract int getHeight();

  public abstract Image loadImage(InputStream is);

  public abstract Sprite loadSprite(InputStream is, int nrows, int ncolumns);

  /**
   * A String constant for the canonical family name of the
   * logical font "Dialog". It is useful in Font construction
   * to provide compile-time verification of the name.
   * @since 1.6
   */
  public static final String DIALOG = "Dialog";

  /**
   * A String constant for the canonical family name of the
   * logical font "DialogInput". It is useful in Font construction
   * to provide compile-time verification of the name.
   * @since 1.6
   */
  public static final String DIALOG_INPUT = "DialogInput";

  /**
   * A String constant for the canonical family name of the
   * logical font "SansSerif". It is useful in Font construction
   * to provide compile-time verification of the name.
   * @since 1.6
   */
  public static final String SANS_SERIF = "SansSerif";

  /**
   * A String constant for the canonical family name of the
   * logical font "Serif". It is useful in Font construction
   * to provide compile-time verification of the name.
   * @since 1.6
   */
  public static final String SERIF = "Serif";

  /**
   * A String constant for the canonical family name of the
   * logical font "Monospaced". It is useful in Font construction
   * to provide compile-time verification of the name.
   * @since 1.6
   */
  public static final String MONOSPACED = "Monospaced";

  public abstract Font font(String name, float size);

  /**
   * This method sets the unique timer to the given delay.
   * Until the timer expires, you may not set another timer,
   * but you may cancel the current one and set a new one.
   * @param delay
   * @param listener
   * @throws IllegalStateException if you try to set a second timer.
   */
  public abstract void setTimer(int delay);

  /**
   * Cancel the previously-set timer, calling its cancelled 
   * You may set a new timer after calling this method.
   * It is safe to call this method even if there is no timer
   * currently set.
   */
  public abstract void cancelTimer();

}
