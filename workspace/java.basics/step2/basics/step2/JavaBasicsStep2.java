package basics.step2;

public class JavaBasicsStep2 {

  /*
   * This is just a helper function.
   * Please set a breakpoint on the line that calls System.exit().
   * That way, if your program exists, the debugger will suspend the execution 
   * and you will be able to see why the program exited.
   */
  static void exit(int code) {
    System.out.printf("Exit: %d\n", code);
    System.exit(code);
    // the execution flow never comes back 
    // from System.exit.
  }

  static void exit(int code, String msg) {
    System.out.printf("%s\n", msg);
    exit(code);
  }

  /*
   * This is just a helper function.
   */
  static void ensure(boolean cond) {
    if (!cond)
      exit(-1, "Ensure failed.");
  }

  public static void main(String[] args) {

    // Let's create some point objects,
    // from the class Point.
    Point p1 = new Point();
    Point p2 = new Point();
    Point p3 = p2;
    Point p4 = null;

    // Let's ensure we understand which variable
    // refers to which object:
    ensure(p1 != p2);
    ensure(p2 == p3);
    ensure(p4 == null);

    // moreAboutAliasing();

    // aboutLines();
    
    // moreAboutLines();

    System.out.println("That's all folks.");
  }

  static void moreAboutAliasing() {
    /*
     * Same as before...
     */
    Point p1 = new Point();
    Point p2 = new Point();
    Point p3 = p2;
    Point p4 = null;
    /*
     * New stuff below...
     * Let's translate p1, manually.
     */
    p1.x = 10;
    p1.y = 11;

    ensure(p1.x == 10);
    ensure(p1.y == 11);

    // Let's translate p2, by invoking a method
    p2.translate(20, 22);

    ensure(p2.x == 20);
    ensure(p2.y == 22);

    ensure(p3.x == 20);
    ensure(p3.y == 22);

  }

  static void aboutLines() {
    /*
     * Same as before...
     */
    Point p1 = new Point();
    Point p2 = new Point();
    Point p3 = p2;

    p1.x = 10;
    p1.y = 11;

    p2.translate(20, 22);

    /*
     * Let's create a line, from p1 to p2
     */
    Line l1 = new Line();
    l1.start = p1;
    l1.end = p2;

    ensure(p1 == l1.start);
    ensure(p2 == l1.end);
    ensure(p3 == l1.end);

    // Let's translate the line
    l1.translate(2, -2);

    // Let's check that p2 was translated, 
    // since the point p2 is one of the points
    // of the line we just translated.
    // The point p2 moved like this
    //  p2 = new Point(); -> p.x == 0 && p2.y == 0
    //  p2.translate(20,22); -> p.x == 20 && p2.y == 22
    //  l1.translate(2,-2); -> p.x == 22 && p2.y == 20
    ensure(p2.x == 22);
    ensure(p2.y == 20);

    // Now, let's do some checks on the point p3.
    // What did we do to the point p3?
    // Well, p3 is p2, right?
    //    Point p3 = p2;
    // So what did we do to p2?
    //    p2 = new Point(); -> p.x == 0 && p2.y == 0
    //    p2.translate(20,22); -> p.x == 20 && p2.y == 22
    // So we can expect the point p3 to be at (20,22).
    ensure(p3.x == 20);
    ensure(p3.y == 22);
    
    // Oops, not really... what happened?
    // Well, we translate the line l1
    // and because the line and p3 are aliasing
    // the same object, we "translated" p3 as well.
    // See how aliasing can quickly become a major
    // design consideration for your code and a source
    // of sneaky bugs...

  }

  static void moreAboutLines() {
    /*
     * Same as before...
     */
    Point p1 = new Point();
    Point p2 = new Point();
    Point p3 = p2;
    Point p4 = null;
    p1.x = 10;
    p1.y = 11;

    Line l1 = new Line();
    l1.start = p1;
    l1.end = p2;

    p2.translate(20, 22);

    /*
     * Let's create another line, from p2 (since p3 aliases p2)
     * to another point that we instantiate right there.
     */
    Line l2 = new Line();
    l2.start = p3;
    l2.end = new Point();
    ensure(l2.start == p3);
    ensure(l2.start == p2);
    l2.end.x = 30;
    l2.end.y = 33;

    p4 = l2.end;
    ensure(p4.x == 30);
    ensure(p4.y == 33);
    
    /*
     * Now, what would happen if you would rotate l1?
     * It would translate l1.end, right?
     * But since l1.end == p2
     * And p2 == p3
     * And p3 == l2.start
     * We would have also translated l2.start
     */
    l1.rotate(5, 5);
  }

}
