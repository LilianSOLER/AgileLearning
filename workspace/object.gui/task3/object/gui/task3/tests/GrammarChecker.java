package object.gui.task3.tests;

import object.gui.task3.Component;
import object.gui.task3.KeyListener;
import object.gui.task3.MouseListener;

public class GrammarChecker implements MouseListener, KeyListener {

  class ButtonEvent {
    Component source;
    int button;

    ButtonEvent(Component source, int no) {
      this.source = source;
      this.button = no;
    }
  }
  class KeyEvent {
    Component source;
    int code;

    KeyEvent(Component source, int code) {
      this.source = source;
      this.code = code;
    }
  }

  // the history of button events, so that
  // we can pair release events with pressed events
  ButtonEvent m_buttonEvents[];
  int m_nbuttonEvents;

  // the history of keyboard events, so that
  // we can pair release events with pressed events
  // but the automatic repeat limits what we can check.
  KeyEvent m_keyEvents[];
  int m_nkeyEvents;

  // the component that has the focus
  Component m_focus;

  GrammarChecker() {
    // a history of 20 seems enough, if not, you 
    // can grow it, but it may be a sign of a problem
    // in your toolkit code.
    m_keyEvents = new KeyEvent[20];
    m_buttonEvents = new ButtonEvent[20];
  }

  /**
   * An illegal sequence of events has been found.
   */
  private void reportError(String msg) {
    System.out.flush();
    System.err.println(msg);
    System.exit(-1);
  }

  /**
   * Checks that the focus. 
   * @param c
   */
  private void checkFocus(Component c) {
    if (m_focus != c)
      reportError("  ERROR: received an event on a component that is not the focus!");
  }

  @Override
  public void keyPressed(Component c, char k, int code) {
    System.out.println("keyPressed: " + k + "(" + code + ") on " + c.getName());
    checkFocus(c);
    for (int i = 0; i < m_nkeyEvents; i++) {
      KeyEvent evt = m_keyEvents[i];
      if (code == evt.code) {
        // unfortunately, we can't verify anything here because
        // of the auto repeat that sends multiple pressed events
        // without corresponding release events.
        // let's update the source in case the mouse is moved
        // while having an key pressed in automatic repeat
        evt.source = c;
        return;
      }
    }
    m_keyEvents[m_nkeyEvents++] = new KeyEvent(c, code);
  }

  @Override
  public void keyReleased(Component c, char k, int code) {
    System.out.println("keyRelease: " + k + "(" + code + ") on " + c.getName());
    checkFocus(c);
    for (int i = 0; i < m_nkeyEvents; i++) {
      KeyEvent evt = m_keyEvents[i];
      if (code == evt.code) {
        for (i++; i < m_nkeyEvents; i++)
          m_keyEvents[i - 1] = m_keyEvents[i];
        m_keyEvents[i] = null;
        m_nkeyEvents--;
        return;
      }
    }
    reportError("  ERROR: a released key was not pressed!");
  }

  @Override
  public void mouseMoved(Component c, int x, int y) {
    System.out.println("mouseMoved: " + "(" + x + "," + y + ") on " + c.getName());
    checkFocus(c);
    if (!c.contains(x, y))
      reportError("  ERROR: not local coordinates!");
  }

  @Override
  public void mousePressed(Component c, int x, int y, int button) {
    System.out.println("mousePressed: button=" + button + " at (" + x + "," + y + ") on " + c.getName());
    checkFocus(c);
    if (!c.contains(x, y))
      reportError("  ERROR: not local coordinates!");
    for (int i = 0; i < m_nbuttonEvents; i++) {
      ButtonEvent evt = m_buttonEvents[i];
      if (button == evt.button) {
        reportError("  ERROR: a button " + button + " pressed twice!");
        return;
      }
    }
    m_buttonEvents[m_nbuttonEvents++] = new ButtonEvent(c, button);
  }

  @Override
  public void mouseReleased(Component c, int x, int y, int button) {
    System.out.println("mouseReleased: button=" + button + " at (" + x + "," + y + ") on " + c.getName());
    checkFocus(c);
    if (!c.contains(x, y))
      reportError("  ERROR: not local coordinates!");
    for (int i = 0; i < m_nbuttonEvents; i++) {
      ButtonEvent evt = m_buttonEvents[i];
      if (button == evt.button) {
        for (i++; i < m_nbuttonEvents; i++)
          m_buttonEvents[i - 1] = m_buttonEvents[i];
        m_buttonEvents[i] = null;
        m_nbuttonEvents--;
        return;
      }
    }
    reportError("  ERROR: a released button was not pressed!");
  }

  @Override
  public void mouseEntered(Component c, int x, int y) {
    System.out.println("mouseEntered: at (" + x + "," + y + ") on " + c.getName());
    if (m_focus!=null)
      reportError("  ERROR: received an enter-event while already inside!");
    m_focus = c;
  }

  @Override
  public void mouseExited(Component c) {
    System.out.println("mouseExited: " + c.getName());
    if (m_focus==null)
      reportError("  ERROR: received an exit-event while outside!");
    m_focus = null;
  }

}
