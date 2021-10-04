package object.gui.spaceduel;

import object.gui.window.Color;

/**
 * This is the model for the Model-View-Controller architecture. 
 * This is your model of the universe.
 * It contains all the entities of your universe,
 * at least the ships and the shots.
 * 
 */
public class Model {

  Ship m_ships[];
  int m_width;
  int m_height;
  
  public Model(int w, int h) {
    m_width = w;
    m_height = h;
    m_ships = new Ship[2];
    m_ships[0] = new Ship(this, w / 4, h / 2, 0, Color.green);
    m_ships[1] = new Ship(this, 3 * w / 4, h / 2, Math.PI, Color.blue);
  }

  /**
   * Called at startup once the view knows its size on the screen
   * or later on when the window on the screen is resized by the player.
   * @param view
   * @param width
   * @param height
   */
  public void setDimension(View view, int width, int height) {
    throw new RuntimeException("NYI");
  }


}
