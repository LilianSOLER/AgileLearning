package basics.step7;

public class JavaBasicsStep7 {

  static final int NROUNDS = 4;
  static final int NSMOOTHS = 8;
  static final int DELAY = 500;

  public static void sleep(long delay) {
    try {
      Thread.sleep(delay);
    } catch (InterruptedException ex) {
    }
  }

  /*
   * This is still a simple main.
   * It creates a circle.
   * The Graphical User Interface (GUI)
   * Then enters an infinite loop that
   *    - draws the circle
   *    - improves its smoothness
   *      up to a maximum number of points
   *    - starts all over again with a new circle 
   */
  public static void main(String[] args) {
    int radius = 200;
    GUI gui = new GUI(NROUNDS, NSMOOTHS);
    for (int i = 0; i < NROUNDS; i++) {
      Circle c = new Circle(radius);
      gui.nRound = i;
      gui.circle = c;
      for (int j = 0; j < NSMOOTHS; j++) {
        gui.nSmooth = j;
        gui.repaint();
        sleep(DELAY);
        c.smoother();
      }
    }
    Counters.echo();

    // we are done animating circles on the screen
    // Because we have a window open, just returning from main
    // will not stop the execution.
    System.exit(0);
  }

}
