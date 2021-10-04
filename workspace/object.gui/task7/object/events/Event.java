package object.events;

/**
 * This is the event class, using a inheritance pattern for 
 * the event reaction.
 */
public abstract class Event {
  Event next;
  long eta;
  protected Event(long eta) {
    this.eta = eta;
  }
  protected Event(int delay) {
    long now = System.currentTimeMillis();
    eta = now + delay;
  }
  
  /**
   * Subclasses will override this method to write
   * the reaction to this event.
   * @throws Exception
   */
  protected abstract void react() throws Exception;
    
  /**
   * Test if two events are the same, it is used to suppress
   * redundant events in the queue. 
   * @throws Exception
   */
  protected abstract boolean equals(Event e);

}