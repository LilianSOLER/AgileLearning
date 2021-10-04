package object.gui.window;

import java.awt.AWTException;
import java.awt.Toolkit;

public class GuiRobot extends Robot {
  java.awt.Robot m_robot;
  BufferedGuiCanvas m_canvas;
  volatile int m_eventCount;

  GuiRobot(BufferedGuiCanvas canvas) throws AWTException {
    m_canvas = canvas;
    m_robot = new java.awt.Robot();
  }

  synchronized void eventNotify() {
    if (m_eventCount > 0)
      m_eventCount--;
  }

  @Override
  public Image createScreenCapture(int x, int y, int w, int h) {
    java.awt.image.BufferedImage img;
    java.awt.Point loc = m_canvas.getLocationOnScreen();
    x += loc.x;
    y += loc.y;
    img = m_robot.createScreenCapture(new java.awt.Rectangle(x, y, w, h));
    return new GuiImage(img);
  }

  @Override
  public void delay(int ms) {
    m_robot.delay(ms);
  }

  @Override
  public void waitForIdle() {
    m_robot.waitForIdle();
    Toolkit.getDefaultToolkit().sync();
    while (m_eventCount > 0) {
      try {
        Thread.sleep(1);
      } catch (InterruptedException ex) {
      }
    }
  }

  @Override
  public Color getPixelColor(int x, int y) {
    java.awt.Point loc = m_canvas.getLocationOnScreen();
    x += loc.x;
    y += loc.y;
    java.awt.Color c = m_robot.getPixelColor(x, y);
    return new Color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
  }

  @Override
  public synchronized void keyPress(int keycode) {
    m_eventCount++;
    m_robot.keyPress(keycode);
  }

  @Override
  public synchronized void keyRelease(int keycode) {
    m_eventCount++;
    m_robot.keyRelease(keycode);
  }

  @Override
  public synchronized void mouseMove(int x, int y) {
    java.awt.Point loc = m_canvas.getLocationOnScreen();
    x += loc.x;
    y += loc.y;
    m_eventCount++;
    m_robot.mouseMove(x, y);
  }

  @Override
  public synchronized void mousePress(int buttons) {
    m_eventCount++;
    m_robot.mousePress(buttons);
  }

  @Override
  public synchronized void mouseRelease(int buttons) {
    m_eventCount++;
    m_robot.mouseRelease(buttons);
  }

  @Override
  public synchronized void mouseWheel(int wheelAmt) {
    m_eventCount++;
    m_robot.mouseWheel(wheelAmt);
  }
}
