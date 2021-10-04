package object.gui.spaceduel;

import object.gui.TimerListener;
import object.gui.Toolkit;
import object.gui.window.Graphics;

/**
 * An animation is a sequence of images, displayed
 * at a given frequency, specified as a delay between
 * two consecutive images.
 * The listener is informed when the animation is over.
 */
public abstract class Animation {

  public interface AnimationListener {
    void done(Animation a);
  }

  AnimationListener m_listener;
  int m_delay;

  public Animation(int delay, AnimationListener l) {
    m_listener = l;
    m_delay = delay;
    new _AnimationListener();
  }

  /**
   * Sets the position and scale of the animation
   * @param x
   * @param y
   * @param scale
   */
  public abstract void setPosition(int x, int y, float scale);

  /**
   * @return true if the animation is done.
   */
  public abstract boolean done();

  /**
   * Moves onto the next image.
   * @return true is the animation has more images.
   */
  protected abstract boolean nextImage();

  /*
   * Paints the current image at the given position
   * and scale.
   */
  protected abstract void paint(Graphics g);

  private class _AnimationListener implements TimerListener {

    _AnimationListener() {
      Toolkit tk = Toolkit.getToolkit();
      tk.setTimer(m_delay, this);
    }

    @Override
    public void expired() {
      if (nextImage()) {
        Toolkit tk = Toolkit.getToolkit();
        tk.setTimer(m_delay, this);
      } else {
        if (m_listener != null)
          m_listener.done(Animation.this);
      }
    }

  }

}
