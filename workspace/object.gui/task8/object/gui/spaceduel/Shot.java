package object.gui.spaceduel;

/**
 * This class models a shot fired by a ship.
 * The shot travels at a certain speed in a given direction.
 * A shot will explode on the bounds of the universe or when
 * hitting a ship, but not the ship that fired it.
 */
public class Shot {

  Ship m_ship;

  public Shot(Ship ship, int x, int y, double angle) {
    m_ship = ship;
  }

}
