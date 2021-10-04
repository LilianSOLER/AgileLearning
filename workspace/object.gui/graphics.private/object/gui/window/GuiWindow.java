package object.gui.window;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;

public class GuiWindow extends Window implements MouseListener, MouseMotionListener, KeyListener, WindowListener {

  private JFrame m_frame;
  private java.awt.Window m_window;
  private int m_width, m_height;
  private java.awt.Canvas m_canvas;
  private object.gui.window.KeyListener m_kl;
  private object.gui.window.MouseListener m_ml;
  object.gui.window.WindowListener m_wl;
  protected Runnable m_callback;
  protected Graphics m_graphics;

  public boolean m_doExit;
  private boolean m_inside;

  public GuiWindow(int width, int height) {
    m_width = width;
    m_height = height;
    m_doExit = true;
    self = this;
    createWindow();
    m_frame.setFocusable(true);
    m_frame.requestFocus();
  }

  @Override
  public void setCallback(Runnable callback) {
    m_callback = callback;
    m_canvas.repaint();
  }

  public void keyPressed(int code, char key) {
    long now = System.currentTimeMillis();
    m_frame.dispatchEvent(new KeyEvent(m_frame, KeyEvent.KEY_PRESSED, now, 0, code, key));
  }

  public void keyReleased(int code, char key) {
    long now = System.currentTimeMillis();
    m_frame.dispatchEvent(new KeyEvent(m_frame, KeyEvent.KEY_RELEASED, now, 0, code, key));
  }

  @Override
  public void close() {
    if (m_doExit) {
      m_frame.setVisible(false);
      m_frame.dispose();
    }
  }

  @Override
  public int getWidth() {
    return m_width;
  }

  javax.swing.Timer m_timer;

  @Override
  public void setTimer(int delay) {
    //    int id = AWTEvent.RESERVED_ID_MAX + 1;
    //    AWTEvent evt = new AWTEvent(this,id);
    //    EventQueue q; q.postEvent(evt);
    //    Runnable r;
    //    q.invokeLater(r);
    if (m_timer != null)
      throw new IllegalStateException("You may not set another timer, the current timer has not expired.");

    m_timer = new Timer(delay, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        boolean canceled;
        synchronized (this) {
          if (m_timer != null) {
            m_timer.stop();
            m_timer = null;
            canceled = false;
          } else
            canceled = true;
        }
        if (!canceled && m_wl!=null)
          m_wl.expired();
      }
    });
    m_timer.setRepeats(false);
    m_timer.start();
  }

  @Override
  public void cancelTimer() {
    synchronized (this) {
      if (m_timer != null) {
        m_timer.stop();
        m_timer = null;
      }
    }
  }

  @Override
  public int getHeight() {
    return m_height;
  }

  @Override
  public void setKeyListener(object.gui.window.KeyListener kl) {
    m_kl = kl;
  }

  @Override
  public void setMouseListener(object.gui.window.MouseListener ml) {
    m_ml = ml;
  }

  @Override
  public void setWindowListener(object.gui.window.WindowListener pl) {
    m_wl = pl;
    if (m_wl != null)
      m_wl.resized(m_canvas.getWidth(), m_canvas.getHeight());
  }

  @Override
  public void repaint() {
    m_canvas.repaint();
  }

  @Override
  public Image loadImage(InputStream is) {
    // File imageFile = new File("game.sample/sprites/winchester.png");
    BufferedImage img = null;
    try {
      img = ImageIO.read(is);
      return new GuiImage(img);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return null;
  }

  @Override
  public Sprite loadSprite(InputStream is, int nrows, int ncolumns) {
    try {
      return new Sprite(is, nrows, ncolumns);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return null;
  }

  java.awt.EventQueue eventQueue;

  private void createWindow() {

    eventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
    m_frame = new WindowFrame();
    java.awt.Window[] windows = JFrame.getWindows();
    m_window = windows[0];

    m_window.addWindowListener(this);

    m_frame.addComponentListener(new ComponentAdapter() {
      public void componentResized(ComponentEvent componentEvent) {
        java.awt.Container cont = m_frame.getContentPane();
        m_width = cont.getWidth();
        m_height = cont.getHeight();
        m_canvas.setBounds(0, 0, m_width, m_height);
      }
    });

    m_frame.setTitle("Sample Canvas");
    m_frame.setLayout(new BorderLayout());
    // m_canvas = new GuiCanvas(this);
    m_canvas = new BufferedGuiCanvas(this);
    m_canvas.setBackground(Color.black);
    m_canvas.setSize(m_width, m_height);
    m_frame.add(m_canvas, BorderLayout.CENTER);

    m_frame.setSize(m_width, m_height);
    m_frame.doLayout();
    m_frame.setVisible(true);

    m_canvas.addKeyListener(this);
    m_canvas.addMouseListener(this);
    m_canvas.addMouseMotionListener(this);

    // grab the focus on this JPanel, meaning keyboard events
    // are coming to our controller. Indeed, the focus controls
    // which part of the overall GUI receives the keyboard events.
    m_canvas.setFocusable(true);
    // m_canvas.requestFocus();
    m_canvas.requestFocusInWindow();
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (m_kl != null)
      m_kl.keyPressed(e.getKeyChar(), e.getKeyCode());
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (m_kl != null)
      m_kl.keyReleased(e.getKeyChar(), e.getKeyCode());
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    if (m_ml == null)
      return;
    m_ml.mouseMoved(e.getX(), e.getY());
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    if (m_ml == null)
      return;
    if (!m_inside) {
      m_inside = true;
      m_ml.mouseEntered(e.getX(), e.getY());
    }
    m_ml.mouseMoved(e.getX(), e.getY());
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mousePressed(MouseEvent e) {
    if (m_ml == null)
      return;
    m_ml.mousePressed(e.getX(), e.getY(), e.getButton());
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    if (m_ml == null)
      return;
    m_ml.mouseReleased(e.getX(), e.getY(), e.getButton());
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    if (m_ml == null || m_inside)
      return;
    m_inside = true;
    m_ml.mouseEntered(e.getX(), e.getY());
  }

  @Override
  public void mouseExited(MouseEvent e) {
    if (m_ml == null || !m_inside)
      return;
    m_inside = false;
    m_ml.mouseExited();
  }

  @Override
  public Font font(String name, float size) {
    GuiFont font = null;
    java.awt.Font f;
    f = java.awt.Font.decode(name + "-PLAIN-" + size);
    if (f != null) {
      m_graphics.setFont(f);
      java.awt.FontMetrics fm = m_graphics.getFontMetrics();
      font = new GuiFont(this, fm);
    }
    return font;
  }

  @Override
  public void windowOpened(WindowEvent e) {
  }

  @Override
  public void windowClosing(WindowEvent e) {
    if (m_doExit)
      System.exit(0);
  }

  @Override
  public void windowClosed(WindowEvent e) {
    if (m_doExit)
      System.exit(0);
  }

  @Override
  public void windowIconified(WindowEvent e) {
  }

  @Override
  public void windowDeiconified(WindowEvent e) {
  }

  @Override
  public void windowActivated(WindowEvent e) {
  }

  @Override
  public void windowDeactivated(WindowEvent e) {
  }

  class WindowFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    WindowFrame() {
      enableEvents(RunnableEvent.EVENT_ID);
    }

    @Override
    public final void paint(Graphics g) {
    }
  }

  class RunnableEvent extends AWTEvent {
    private static final long serialVersionUID = 1L;
    public static final int EVENT_ID = AWTEvent.RESERVED_ID_MAX + 1;
    Runnable runnable;

    RunnableEvent(Object target, Runnable runnable) {
      super(target, EVENT_ID);
      this.runnable = runnable;
    }

    void run() {
      runnable.run();
    }
  }

  public void post(Runnable r) {
    eventQueue.postEvent(new RunnableEvent(m_canvas, r));
  }
}
