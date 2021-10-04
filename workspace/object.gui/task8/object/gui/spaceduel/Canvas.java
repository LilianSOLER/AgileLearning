package object.gui.spaceduel;

import java.io.File;
import java.io.FileInputStream;

import object.gui.Component;
import object.gui.Container;
import object.gui.window.Graphics;
import object.gui.window.Image;
import object.gui.window.Window;

/**
 * This is the drawing surface for the game,
 * drawing the universe, the ships, and shots. 
 * This is where the "Game Over" screen will be
 * displayed.
 */
public class Canvas extends Component {

  View m_view;
  Model m_model;
  Image m_image;

  public Canvas(Container parent, View view, int fps) {
    super(parent);
    m_view = view;
    m_model = view.m_model;
    loadImage("images/gameOver_400x400.png");
  }

  /**
   * we override this method so to be aware of any dimension
   * change of the canvas, keeping the dimension of the 2D-universe
   * in synch with the canvas dimension.
   */
  @Override
  public void setBounds(int x, int y, int w, int h) {
    super.setBounds(x, y, w, h);
    m_view.setCanvasDimension(w, h);
  }

  private void loadImage(String path) {
    try {
      Window win = Window.getWindow();
      if (m_image == null)
        m_image = win.loadImage(new FileInputStream(new File(path)));
    } catch (Exception ex) {
    }
  }

  @Override
  public void paint(Graphics g) {
    throw new RuntimeException("NYI");
  }

}
