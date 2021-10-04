package object.gui.window;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Sprite {

  public int m_width;
  public int m_height;
  public Image[] m_images;

  Sprite(Image[] images, int width, int height) {
    m_images = images;
    m_width = width;
    m_height = height;
  }

  Sprite(InputStream is, int nrows, int ncolumns) throws IOException {
    BufferedImage bi;
    bi = ImageIO.read(is);
    m_width = bi.getWidth(null) / ncolumns;
    m_height = bi.getHeight(null) / nrows;

    m_images = new Image[nrows * ncolumns];
    for (int i = 0; i < nrows; i++) {
      for (int j = 0; j < ncolumns; j++) {
        int x = j * m_width;
        int y = i * m_height;
        m_images[(i * ncolumns) + j] = new GuiImage(bi.getSubimage(x, y, m_width, m_height));
      }
    }
  }

}
