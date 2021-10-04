package object.gui.spaceduel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import object.gui.Container;
import object.gui.layout.BorderLayout;
import object.gui.layout.FlowLayout;
import object.gui.widgets.Label;
import object.gui.widgets.Meter;
import object.gui.window.Color;
import object.gui.window.Font;
import object.gui.window.Graphics;
import object.gui.window.Sprite;
import object.gui.window.Window;

/**
 * This is the view for the Model-View-Controller architecture. 
 * The view manages the canvas where the game is played but also
 * the other elements of the graphical user interface. 
 */
public class View extends Container {

  static Sprite loadSprite(String path, int nrows, int ncols) {
    Window win = Window.getWindow();
    try {
      InputStream is = new FileInputStream(new File(path));
      return win.loadSprite(is, nrows, ncols);
    } catch (Exception ex) {
      return null;
    }
  }

  Model m_model;
  Meter m_meters[];
  Canvas m_canvas;
  Explosion m_explosion;
  
  public View(Window win, Container parent, Model model) {
    super(parent);
    m_model = model;
    
    Font font = win.font(Window.MONOSPACED, 12F);
    font = font.derive(Font.ITALIC | Font.BOLD, 24F);

    setBackgroundColor(Color.black);
    BorderLayout bl = new BorderLayout();
    layoutManager(bl);

    // West:
    Container west = new Container(this);
    west.setBackgroundColor(Color.gray);
    bl.setup(west, BorderLayout.WEST);

    FlowLayout fl = new FlowLayout(FlowLayout.VERTICAL);
    west.layoutManager(fl);
    m_meters = new Meter[2];
    m_meters[0] = new Meter(west, 0, 100, 100);
    m_meters[0].setForegroundColor(Color.green);
    m_meters[1] = new Meter(west, 0, 100, 100);
    m_meters[1].setForegroundColor(Color.blue);

    // North:
    Label label = new Label(this);
    label.setText("Space Duel");
    label.setFont(font);
    label.setBackgroundColor(Color.gray);
    label.setForegroundColor(Color.white);
    bl.setup(label, BorderLayout.NORTH);

    m_canvas = new Canvas(this, this, 24);
    m_canvas.setBackgroundColor(Color.black);
    bl.setup(m_canvas, BorderLayout.CENTER);
  }
  
  @Override
  public void paint(Graphics g) {
    throw new RuntimeException("NYI");
  }

  void setCanvasDimension(int w, int h) {
    m_model.setDimension(this, w, h);
  }

}
