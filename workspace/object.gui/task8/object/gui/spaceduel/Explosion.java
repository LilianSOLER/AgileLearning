/*
 * Educational software for a basic game development
 * Copyright (C) 2018  Pr. Olivier Gruber
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package object.gui.spaceduel;

import object.gui.window.Graphics;
import object.gui.window.Image;
import object.gui.window.Sprite;

/**
 * This is an animation for an explosion.
 *
 *     String path = "sprites/explosion01_set_64.png";
 *     Sprite sprite = View.loadSprite(path, 11, 10);
 *     Animation a = new Explosion(sprite, null, 20);
 *     a.setPosition(5, 5, 2F);
 *
 */
public class Explosion extends Animation {

  int m_x, m_y;
  int m_idx;
  float m_scale;
  Sprite m_sprite;

  Explosion(Sprite sprite, AnimationListener l, int delay) {
    super(delay, l);
    m_sprite = sprite;
  }

  @Override
  public boolean done() {
    throw new RuntimeException("NYI");
  }

  @Override
  public void setPosition(int x, int y, float scale) {
    throw new RuntimeException("NYI");
  }

  /**
   * paints this square on the screen.
   * 
   * @param g
   */
  @Override
  protected void paint(Graphics g) {
    throw new RuntimeException("NYI");
  }

  @Override
  protected boolean nextImage() {
    throw new RuntimeException("NYI");
  }
}
