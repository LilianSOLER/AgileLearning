package object.gui.spaceduel;

import object.gui.Frame;
import object.gui.Toolkit;
import object.gui.Toolkit2;
import object.gui.layout.BorderLayout;
import object.gui.spaceduel.net.Client;
import object.gui.spaceduel.net.Server;
import object.gui.window.Color;
import object.gui.window.Window;

/**
 * This is the entry point for our game.
 * Nothing to change here, unless you have a small screen
 * and a starting window size of 1600x980 is too big.
 * 
 * This class works as a singleton, meaning there is always
 * only a single instance of this class per Java Runtime Environment (JRE).
 * 
 * @author Pr. Olivier Gruber.
 */
public class SpaceDuel implements Runnable {

  // Size of the window, you may want to change it to 
  // adapt it to the size of your computer screen. 
  private static final int WIDTH=1600;
  private static final int HEIGHT=980;

  static SpaceDuel gm;

  static boolean connect = false;
  static boolean accept = false;
  static int port = 6666;
 
  /**
   * You can ignore the parameter parsing as the game works
   * standalone when no parameters are given. The possible parameters
   * will be explained at the very end of this task.
   * @param args
   * @throws Exception
   */
  public static void main(String args[]) throws Exception {
    String hostname = "localhost";
    for (int i = 0; i < args.length; i++) {
      if ("-c".equals(args[i])) {
        connect = true;
        hostname = args[++i];
      } else if ("-p".equals(args[i])) {
        port = Integer.valueOf(args[++i]);
      } else if ("-a".equals(args[i]))
        accept = true;
    }

    if (connect)
      new Client(hostname,port);
    else {
      gm = new SpaceDuel();
    }
  }

  Toolkit m_tk;
  Model m_model;
  View m_view;
  Controller m_ctr;

  SpaceDuel() {
    m_tk = new Toolkit2(WIDTH,HEIGHT);
    m_tk.setCallback(this);
  }

  /**
   * This is the real beginning, the first callback from
   * the toolkit. It creates the model-view-controller 
   * architecture.
   */
  @Override
  public void run() {
    Window win = Window.getWindow();
    Frame frame = m_tk.getFrame();
    frame.setBackgroundColor(Color.gray);
    BorderLayout bl = new BorderLayout();
    frame.layoutManager(bl);

    m_model = new Model(WIDTH,HEIGHT);
    m_view = new View(win,frame,m_model);
    m_ctr = new Controller(m_view, m_model);

    bl.setup(m_view, BorderLayout.CENTER);

    frame.layout();
    frame.repaint();

    // you can ignore the following lines until the 
    // very end of this task when you will try
    // to play with two networked computers.
    if (accept)
      new Server(m_view, m_ctr,port);
  }

}