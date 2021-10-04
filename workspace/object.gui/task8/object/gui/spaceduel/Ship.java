package object.gui.spaceduel;

import object.gui.window.Color;

/**
 * This class models a ship, at a given position in the universe,
 * facing a certain direction, and with a dominant color. 
 * A ship can fire, rotate, and accelerate in the direction 
 * it is facing when thrust is on.
 */
public class Ship { 

  Model m_model;
  int m_x, m_y;
  double m_angle;
  Color m_color;

  public Ship(Model model, int x, int y, double angle, Color c) {
    m_model = model;
    m_color = c;
    m_x = x;
    m_y = y;
    m_angle = angle;
  }

  public void fire() {
    throw new RuntimeException("NYI");
  }

  public void startRotate(boolean left) {
    throw new RuntimeException("NYI");
  }

  public void endRotate() {
    throw new RuntimeException("NYI");
  }

  public void thrust(boolean on) {
    throw new RuntimeException("NYI");
  }
}
