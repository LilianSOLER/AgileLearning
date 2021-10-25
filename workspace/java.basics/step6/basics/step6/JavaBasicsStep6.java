package basics.step6;

public class JavaBasicsStep6 {

  /*
   * A few static variables, to hold 
   * created polygons.
   */
  static Polygon poly1, poly2, poly3;

  /*
   * Create a polygon, that is a rectangle in fact.
   */
  static Polygon createPolygon(int x, int y, int w, int h) {
    Point p, points[];
    points = new Point[4];
    p = new Point(x,y);
    points[0] = p;
    p = new Point(p);
    p.translate(0, h);
    points[1] = p;
    p = new Point(p);
    p.translate(w,0);  // w,h isn't this translation suspicious?
    points[2] = p;
    p = new Point(p);
    p.translate(0,-h);  // and what about this one?
    points[3] = p;

    return new Polygon(points);
  }

  /*
   * Creates the three polygons of this
   * simple test program.
   */
  static void createPolygons() {
    Point points[];
    points = new Point[4];

    points[0] = new Point(22, 35);
    points[1] = new Point(22, 35 + 16);
    points[2] = new Point(22 + 12, 35 + 16);
    points[3] = new Point(22 + 12, 35);

    poly1 = new Polygon(points);

    int x = 22;
    int y = 35;
    int w = 12;
    int h = 16;
    
    Point points2[] = new Point[4];
    Point p = new Point(22, 35);
    points2[0] = p;
    points2[1] = new Point(p);
    points2[1].translate(0, h);
    points2[2] = new Point(p);
    points2[2].translate(w, h);
    points2[3] = new Point(p);
    points2[3].translate(w, 0);

    poly2 = new Polygon(points2);

    poly3 = createPolygon(x, y, w, h);
  }

  /*
   * Checks if our three polygons are identical
   * mathematical polygons or not.
   */
  static boolean checkIdentical() {
    if (!poly1.same(poly2))
      return false;
    if (!poly1.same(poly3))
      return false;
    return true;
  }

  static void check1() {

    System.out.println("We just created three polygons");
    System.out.println("   they all should be representing the same mathematical polygon");
    echo("p1", poly1);
    echo("p2", poly2);
    echo("p3", poly3);

    if (!checkIdentical()) {
      /*
       * What is going on?
       * 
       *   - Figure out which polygons are not the same?
       *   
       * Explain why the object referenced by the variable p1 is not the same 
       * polygon as the object referenced by the variable p3.
       * Of course, the variable p1 and p3 reference different objects, 
       * both instances of the class Polygon... but their points are not
       * at the same location, but that is what we wanted.
       * 
       *    - Identity the problem.
       *    - Fix the problem.    
       * Hint: 
       *   compare how p2 and p3 were created... 
       *   what is different?
       *   look at how the points are created and translated...
       *   can you tell what is wrong?
       */
      System.out.println("PANIC: all three polygons are not the same!");
      System.out.println("TODO: FIX THIS");
      System.out.println("  ---> look at createPolygon() ... ");
      System.exit(-1);
    }
    System.out.println("Cool, all three polygons are the same...");
  }

  static void check2() {
    System.out.println("We just translated the polygon p2");
    System.out.println("We should have:");
    System.out.println("  p1 different than p2: false == p1.same(p2)");
    System.out.println("  p1 as the same as p3: true == p1.same(p3)");
    echo("p1", poly1);
    echo("p2", poly2);
    echo("p3", poly3);

    if (poly1.same(poly2)) {
      System.out.println("PANIC: p1 and p2 are still representing the same polygon!");
      /*
       * Understand why p1 and p2 are still representing the same polygon,
       * even though we translated p2 and not p1?
       */
      System.out.println("TODO: FIX THIS");
      System.exit(-1);
    }
    if (!poly1.same(poly3)) {
      System.out.println("PANIC: p1 and p3 are not representing the same polygon!");
      System.out.println("TODO: FIX THIS");
      System.exit(-1);
    }

  }

  public static void main(String[] args) {

    // Let's construct three polygons, 
    // all three are the same rectangle (x=22,y=35,w=12,h=16).
    createPolygons();

    check1();

    /*
     * So the three objects, referenced by the variables p1, p2, p3,
     * are three different objects, but they are instances of the same class Polygon.
     * And, although they are different objects, they all represent the same mathematical polygon,
     * in the sense of having their points at identical locations.
     * 
     * Summary: 
     *   - not the same objects.
     *   - instances of the same class Polygon
     *   - representing the same mathematical polygon (would draw on the screen on top of each other).
     */

    /*
     * Let's translate p2 and check than now we have:
     *    ! p1.same(p2)
     *      p1.same(p3)
     */
    poly2.translate(1, 1);

    check2();
    
    System.out.println("Congrats, you fixed this program.");
    System.out.println("That's all folks.");
  }

  static void echo(String name, Polygon p) {
    System.out.print("  Polygon(" + name + "): ");
    p.print(System.out);
    System.out.println();
  }
}
