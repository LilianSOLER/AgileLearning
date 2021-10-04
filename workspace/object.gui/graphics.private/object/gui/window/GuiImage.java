package object.gui.window;

//import java.awt.Image;
//import java.awt.image.BufferedImage;

public class GuiImage extends Image {

  java.awt.image.BufferedImage img;

  GuiImage(java.awt.image.BufferedImage img) {
    this.img = img;
  }
  
  @Override
  public int getWidth() {
    return img.getWidth();
  }

  @Override
  public int getHeight() {
    return img.getHeight();
  }

  @Override
  public Image getSubImage(int x, int y, int w, int h) {
    java.awt.image.BufferedImage bi = img.getSubimage(x, y, w, h);
    Image i = new GuiImage(bi);
    return i;
  }
  
}
