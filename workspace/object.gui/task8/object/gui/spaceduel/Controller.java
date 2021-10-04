package object.gui.spaceduel;

import object.gui.Component;
import object.gui.KeyListener;

/**
 * This is the controller for the Model-View-Controller architecture. 
 * This is the controller for the game, it interprets
 * the actions of the player and drives the model or
 * the view.
 * 
 * Nota Bene: this class is fully functional.
 */
public class Controller implements KeyListener{

  static final double ROTATION_ANGLE = Math.PI / 18.0;
  Model m_model;
  View m_view;

  public Controller(View view, Model model) {
    m_model = model;
    m_view = view;
    m_view.m_canvas.setKeyListener(this);
  }

  @Override
  public void keyPressed(Component src, char key, int code) {
    switch (code) {
    case VK_UP:
      m_model.m_ships[0].thrust(true);
      break;
    case VK_LEFT:
      m_model.m_ships[0].startRotate(true);
      break;
    case VK_RIGHT:
      m_model.m_ships[0].startRotate(false);
      break;
    case VK_DOWN:
    case VK_SPACE:
      m_model.m_ships[0].fire();
      break;
    case VK_W:
      m_model.m_ships[1].thrust(true);
      break;
    case VK_A:
      m_model.m_ships[1].startRotate(true);
      break;
    case VK_D:
      m_model.m_ships[1].startRotate(false);
      break;
    case VK_S:
    case VK_Q:
      m_model.m_ships[1].fire();
      break;
    }
  }

  @Override
  public void keyReleased(Component c, char key, int code) {
    switch (code) {
    case VK_UP:
      m_model.m_ships[0].thrust(false);
      break;
    case VK_LEFT:
      m_model.m_ships[0].endRotate();
      break;
    case VK_RIGHT:
      m_model.m_ships[0].endRotate();
      break;
    case VK_W:
      m_model.m_ships[1].thrust(false);
      break;
    case VK_A:
      m_model.m_ships[1].endRotate();
      break;
    case VK_D:
      m_model.m_ships[1].endRotate();
      break;
    }
  }
}