package object.gui.widgets;

import java.util.Arrays;

/** 
 * Borrowed and adapted class from Java AWT.
 */
public class Polygon {
  public int npoints;
  public int xpoints[];
  public int ypoints[];
  //  protected Rectangle bounds;

  public Polygon(int xpoints[], int ypoints[], int npoints) {
    this.npoints = npoints;
    this.xpoints = Arrays.copyOf(xpoints, npoints);
    this.ypoints = Arrays.copyOf(ypoints, npoints);
  }

  public Rectangle calculateBounds() {
    if (npoints <= 2)
      return null;
    int boundsMinX = Integer.MAX_VALUE;
    int boundsMinY = Integer.MAX_VALUE;
    int boundsMaxX = Integer.MIN_VALUE;
    int boundsMaxY = Integer.MIN_VALUE;

    for (int i = 0; i < npoints; i++) {
      int x = xpoints[i];
      boundsMinX = Math.min(boundsMinX, x);
      boundsMaxX = Math.max(boundsMaxX, x);
      int y = ypoints[i];
      boundsMinY = Math.min(boundsMinY, y);
      boundsMaxY = Math.max(boundsMaxY, y);
    }
    return new Rectangle(boundsMinX, boundsMinY, boundsMaxX - boundsMinX, boundsMaxY - boundsMinY);
  }

  public void translate(int deltaX, int deltaY) {
    for (int i = 0; i < npoints; i++) {
      xpoints[i] += deltaX;
      ypoints[i] += deltaY;
    }
  }

  public void rotate(double angle) {
    double cos = Math.cos(angle);
    double sin = Math.sin(angle);
    rotate(cos, sin);
    calculateBounds();
  }

  public void rotate(double cos, double sin) {

    for (int i = 0; i < npoints; i++) {
      int x = xpoints[i];
      int y = ypoints[i];
      xpoints[i] = (int) (x * cos - y * sin);
      ypoints[i] = (int) (x * sin + y * cos);
    }
  }

  public boolean contains(double x, double y) {
    if (npoints <= 2) {
      return false;
    }
    int hits = 0;

    int lastx = xpoints[npoints - 1];
    int lasty = ypoints[npoints - 1];
    int curx, cury;

    // Walk the edges of the polygon
    for (int i = 0; i < npoints; lastx = curx, lasty = cury, i++) {
      curx = xpoints[i];
      cury = ypoints[i];

      if (cury == lasty) {
        continue;
      }

      int leftx;
      if (curx < lastx) {
        if (x >= lastx) {
          continue;
        }
        leftx = curx;
      } else {
        if (x >= curx) {
          continue;
        }
        leftx = lastx;
      }

      double test1, test2;
      if (cury < lasty) {
        if (y < cury || y >= lasty) {
          continue;
        }
        if (x < leftx) {
          hits++;
          continue;
        }
        test1 = x - curx;
        test2 = y - cury;
      } else {
        if (y < lasty || y >= cury) {
          continue;
        }
        if (x < leftx) {
          hits++;
          continue;
        }
        test1 = x - lastx;
        test2 = y - lasty;
      }

      if (test1 < (test2 / (lasty - cury) * (lastx - curx))) {
        hits++;
      }
    }

    return ((hits & 1) != 0);
  }

}
