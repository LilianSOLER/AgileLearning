package object.gui.window;

public abstract class Robot {

  public abstract Image createScreenCapture(int x, int y, int w, int h);
  public abstract void delay(int ms);

  /**
   * Waits until all events currently on the event queue have been processed.
   * @throws  IllegalThreadStateException if called on the AWT event dispatching thread
   */
  public abstract void waitForIdle();

  /**
   * Returns the color of a pixel at the given screen coordinates.
   * @param   x       X position of pixel
   * @param   y       Y position of pixel
   * @return  Color of the pixel
   */
  public abstract Color getPixelColor(int x, int y);

  /**
   * Presses a given key.  The key should be released using the
   * <code>keyRelease</code> method.
   *
   * @param   keycode Key to press (e.g. KeyEvent.VK_A)
   * @see     #keyRelease(int)
   * @see     java.awt.event.KeyEvent
   */
  public abstract void keyPress(int keycode);

  /**
   * Releases a given key.
   * @param   keycode Key to release (e.g. KeyListener.VK_A)
   * @throws  IllegalArgumentException if keycode is not a
   *          valid key
   * @see  #keyPress(int)
   * @see     java.awt.event.KeyEvent
   */
  public abstract void keyRelease(int keycode);

  /**
   * Moves mouse pointer to given screen coordinates.
   * @param x         X position
   * @param y         Y position
   */
  public abstract void mouseMove(int x, int y);

  /**
   * Presses one or more mouse buttons.  The mouse buttons should
   * be released using the {@link #mouseRelease(int)} method.
   *
   * @param buttons the Button mask; a combination of one or more
   * mouse button masks :BUTTON1, BUTTON2, BUTTON3
   */
  public abstract void mousePress(int buttons);

  /**
   * The Mouse Button1 extended modifier constant.
   */
  public static final int BUTTON1 = 1 << 10;

  /**
   * The Mouse Button2 extended modifier constant.
   */
  public static final int BUTTON2 = 1 << 11;

  /**
   * The Mouse Button3 extended modifier constant.
   */
  public static final int BUTTON3 = 1 << 12;

  /**
   * Releases one or more mouse buttons.
   * @param buttons the Button mask; a combination of one or more
   * mouse button masks :BUTTON1, BUTTON2, BUTTON3
   */
  public abstract void mouseRelease(int buttons);

  /**
   * Rotates the scroll wheel on wheel-equipped mice.
   *
   * @param wheelAmt  number of "notches" to move the mouse wheel
   *                  Negative values indicate movement up/away from the user,
   *                  positive values indicate movement down/towards the user.
   */
  public abstract void mouseWheel(int wheelAmt);

}

