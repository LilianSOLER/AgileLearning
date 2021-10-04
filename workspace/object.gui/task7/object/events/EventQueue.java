
package object.events;

import java.io.PrintStream;
import java.util.Date;

/**
 * This is a classical event queue. 
 * Each event pushes on the queue is given an estimated time of arrival (ETA).
 * When the time comes, the event is triggered, executing the reaction to
 * the event trigger via invoking the method "run" on the event.
 * 
 * The design of this queue is quite straightforward, it uses a single-link
 * lists of events that are kept ordered in growing ETAs. 
 * 
 * This queue relies on the global unique timer provided by the unique
 * instance of the class Window. The timer is always set to the delay
 * remaining to the ETA of the event at the top of the queue, which is
 * the head of the list.
 * 
 * @author Pr. Olivier Gruber
 */
public abstract class EventQueue {

  Event m_head; // ETA-ordered list of events
  int m_count; // count of pending events
  PrintStream m_log;

  protected EventQueue(PrintStream log) {
    if (log != null)
      m_log = log;
    else
      m_log = System.out;
  }

  /**
   * @return the count of pending events
   */
  public int length() {
    return m_count;
  }

  /**
   * Ask to set or reset the timer to the given delay.
   * When the timer will expire, it is expected that
   * the method "timerExpired" is invoked.
   * @param delay
   */
  protected abstract void setTimer(long delay);

  /**
   * Up-called by subclasses when the timer has expired.
   * Here, we make sure that we support reactions to request
   * new timers. Therefore, we first remove all requests 
   * that are due and only then do we invoke their reaction.
   */
  protected void timerExpired() {
    long now = System.currentTimeMillis();
    if (m_head == null) // just to be safe
      return;
    if (m_head.eta > now) { // just to be safe
      setTimer(m_head.eta - now);
      return;
    }
    // now we know we have at least one expired event
    Event head = m_head;
    Event last = m_head;
    while (m_head != null && m_head.eta <= now) {
      last = m_head;
      m_head = m_head.next;
      m_count--;
    }
    last.next = null;
    while (head != null) {
      Event evt = head;
      head = head.next;
      fireEvent(evt);
    }
    if (m_head != null) {
      now = System.currentTimeMillis();
      setTimer(m_head.eta - now);
    }
  }

  public void push(Event r) {
    Event prev = null, pos = m_head;
    while (pos != null) {
      if (pos.equals(r)) {
        if (prev == null)
          m_head = m_head.next;
        else
          prev.next = pos.next;
        m_count--;
        break;
      }
      prev = pos;
      pos = pos.next;
    }
    if (m_head == null) {
      long now = System.currentTimeMillis();
      m_head = r;
      r.next = null;
      m_count++;
      setTimer(m_head.eta - now);
    } else {
      pos = m_head;
      if (r.eta < pos.eta) {
        long now = System.currentTimeMillis();
        r.next = m_head;
        m_head = r;
        m_count++;
        setTimer(m_head.eta - now);
      } else {
        prev = null;
        pos = m_head;
        while (pos != null && pos.eta <= r.eta) {
          prev = pos;
          pos = pos.next;
        }
        m_count++;
        if (prev == null) {
          r.next = pos;
          m_head = r;
        } else {
          prev.next = r;
          r.next = pos;
        }
      }
    }
  }

  private void fireEvent(Event evt) {
    try {
      evt.next = null;
      evt.react();
    } catch (Throwable th) {
      Date d = new Date();
      m_log.println("[" + d + "] an event reaction raised an uncaught exception:");
      th.printStackTrace(m_log);
    }
  }

}
