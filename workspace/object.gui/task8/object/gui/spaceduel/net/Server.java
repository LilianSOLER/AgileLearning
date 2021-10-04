package object.gui.spaceduel.net;


import java.io.IOException;
import java.io.InputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

import object.gui.KeyListener;
import object.gui.spaceduel.Controller;
import object.gui.spaceduel.View;
import object.gui.window.GuiWindow;
import object.gui.window.Window;

public class Server extends Thread {

  ServerSocket m_ssock;
  Controller m_ctr;
  View m_view;
  GuiWindow m_win;
  int m_port;

  public Server(View view, Controller ctr, int port) {
    m_ctr = ctr;
    m_view = view;
    m_port = port;
    start();
  }

  public void run() {
    try {
      m_win = (GuiWindow)Window.getWindow();
      m_ssock = new ServerSocket(m_port);
      while (true)
        accept();
    } catch (BindException ex) {
      System.err.println("PANIC: cannot accept on port "+m_port);
      System.exit(-1);
    } catch (Exception ex) {
      ex.printStackTrace(System.err);
      System.err.println("PANIC: unexpected exception trying to accept on port "+m_port);
      System.exit(-1);
    }
  }

  class Event implements Runnable  {
    char m_key;
    int m_code;
    boolean m_pressed;
    Event(char key, int code, boolean pressed) {
      m_key = key;
      m_code = code;
      m_pressed = pressed;
    }
    @Override
    public void run() {
      if (m_pressed)
        m_ctr.keyPressed(m_view, m_key, m_code);
      else
        m_ctr.keyReleased(m_view, m_key, m_code);
    }    
  }
  private void accept() {
    Socket sock;
    Event e;
    try {
      System.out.println("Accepting...");
      sock = m_ssock.accept();//establishes connection   
      System.out.println("Accepted connection.");
      InputStream is = sock.getInputStream();
      for (;;) {
        int code = is.read();
        if (code == -1)
          return;
        boolean pressed = (is.read()==1);
        switch (code) {
        case KeyListener.VK_UP:
          e = new Event('w',KeyListener.VK_W,pressed);
          m_win.post(e);
//          if (pressed == 1)
//            m_ctr.keyPressed(m_view, 'w', KeyListener.VK_W);
//          else
//            m_ctr.keyReleased(m_view, 'w', KeyListener.VK_W);
          break;
        case KeyListener.VK_LEFT:
          e = new Event('a',KeyListener.VK_A,pressed);
          m_win.post(e);
//          if (pressed == 1)
//            m_ctr.keyPressed(m_view, 'a', KeyListener.VK_A);
//          else
//            m_ctr.keyReleased(m_view, 'a', KeyListener.VK_A);
          break;
        case KeyListener.VK_RIGHT:
          e = new Event('d',KeyListener.VK_D,pressed);
          m_win.post(e);
//          if (pressed == 1)
//            m_ctr.keyPressed(m_view, 'd', KeyListener.VK_D);
//          else
//            m_ctr.keyReleased(m_view, 'd', KeyListener.VK_D);
          break;
        case KeyListener.VK_SPACE:
          e = new Event('s',KeyListener.VK_S,pressed);
          m_win.post(e);
//          if (pressed == 1)
//            m_ctr.keyPressed(m_view, 's', KeyListener.VK_S);
//          else
//            m_ctr.keyReleased(m_view, 's', KeyListener.VK_S);
//          break;
        }
      }
    } catch (IOException ex) {
      return;
    }
  }
}
