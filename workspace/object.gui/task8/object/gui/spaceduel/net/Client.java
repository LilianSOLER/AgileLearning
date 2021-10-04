package object.gui.spaceduel.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import object.gui.Component;
import object.gui.Frame;
import object.gui.KeyListener;
import object.gui.Toolkit;
import object.gui.layout.BorderLayout;
import object.gui.widgets.Label;
import object.gui.window.Color;
import object.gui.window.Font;
import object.gui.window.Window;

public class Client implements Runnable, KeyListener {

  Toolkit m_tk;
  Socket m_sock;
  OutputStream m_os;

  public Client(String hostname, int port) {
    
    System.out.print("Attempting to connect.");
    while (true)
      try {
        System.out.print(".");
        m_sock = new Socket(hostname, port);
        m_os = m_sock.getOutputStream();
        break;
      } catch (IOException ex) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException ex2) {
        }
      }
    System.out.println("\nConnected!");
    System.out.println("Now click your mouse within the small gray window,");
    System.out.println("and use the arrows and space bar to control your blue ship.");
    System.out.println("  - Left/right arrows: rotate left/right your ship.");
    System.out.println("  - Up arrow: apply thrust.");
    System.out.println("  - Space bar: fire.");
    System.out.println("Have fun...");
    
    m_tk = new Toolkit(250,80);
    m_tk.setCallback(this);
  }

  private void exit(Throwable th) {
    try {
      m_os.close();
    } catch (IOException ex) {
    }
    if (th != null)
      th.printStackTrace();
    System.exit(-1);
  }

  @Override
  public void run() {
    Window win = Window.getWindow();

    Frame frame = m_tk.getFrame();
    
    frame.setBackgroundColor(Color.gray);
    BorderLayout bl = new BorderLayout();
    frame.layoutManager(bl);

    Label label = new Label(frame);
    label.setText("Click here, then play");

    Font font = win.font(Window.MONOSPACED, 12F);
    font = font.derive(Font.ITALIC | Font.BOLD, 18F);
    label.setFont(font);
    
    bl.setup(label, BorderLayout.CENTER);

    label.setKeyListener(this);
    frame.layout();
    frame.repaint();

  }

  @Override
  public void keyPressed(Component c, char k, int code) {
    try {
      switch (code) {
      case VK_UP:
        m_os.write(VK_UP);
        m_os.write(1);
        m_os.flush();
        break;
      case VK_LEFT:
        m_os.write(VK_LEFT);
        m_os.write(1);
        m_os.flush();
        break;
      case VK_RIGHT:
        m_os.write(VK_RIGHT);
        m_os.write(1);
        m_os.flush();
        break;
      case VK_DOWN:
      case VK_SPACE:
        m_os.write(VK_SPACE);
        m_os.write(1);
        m_os.flush();
        break;
      }
    } catch (IOException ex) {
      exit(ex);
    }
  }

  @Override
  public void keyReleased(Component c, char k, int code) {
    try {
      switch (code) {
      case VK_UP:
        m_os.write(VK_UP);
        m_os.write(0);
        m_os.flush();
        break;
      case VK_LEFT:
        m_os.write(VK_LEFT);
        m_os.write(0);
        m_os.flush();
        break;
      case VK_RIGHT:
        m_os.write(VK_RIGHT);
        m_os.write(0);
        m_os.flush();
        break;
      case VK_SPACE:
        m_os.write(VK_SPACE);
        m_os.write(0);
        m_os.flush();
        break;
      }
    } catch (IOException ex) {
      exit(ex);
    }
  }
}
