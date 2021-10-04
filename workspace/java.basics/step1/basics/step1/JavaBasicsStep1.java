package basics.step1;

public class JavaBasicsStep1 {

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
      exit(-1,"Ensure failed.");
  }

  public static void main(String[] args) {
    Point p = new Point();

    p.translate(5, 10);

    ensure(p.x == 5);
    ensure(p.y == 10);

    System.out.println("That's all folks.");
  }
}
