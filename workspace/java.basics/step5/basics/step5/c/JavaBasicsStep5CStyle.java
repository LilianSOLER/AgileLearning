package basics.step5.c;

/*
 * A class that represents the concept of a point,
 * positioned at the coordinates (x,y).
 * Note: this class only defines a structure, with two fields.
 * No behavior is defined.
 */
class Point {
  int x, y;
}

/*
 * A class that represents the concept of a rectangle,
 * positioned at the coordinates (x,y)
 * and dimensioned by (width,height).
 * Note: this class only defines a structure, with four fields.
 * No behavior is defined.
 */
class Rectangle {
  int x, y, width, height;
}

/*
 * A class that represents the concept of a vector,
 * in the mathematical sense of it.
 * A cartesien representation would be a pair (x,y)
 * of coordinates.
 * We chose a polar representation, just to show
 * something different.
 */
class Vector {
  float rho;
  float theta;
}

class Operations {

  // Function to initialize a point
  static void init_point(Point p, int x, int y) {
    p.x = x;
    p.y = y;
  }

  // Function to initialize a rectangle
  static void init_rectangle(Rectangle r, int x, int y, int w, int h) {
    r.x = x;
    r.y = y;
    r.width = w;
    r.height = h;
  }
  
  /* We respected the C naming style, where function names 
   * are "decorated" with labels to distinguish them.
   * So here, we need to distinguish between translate 
   * on a point and translate on a rectangle.
   * Nota Bene:
   * Java permits name overloading, so this is not necessary
   * in Java, but we are coding C-style here.
   */  
  static void translate_point(Point p, int dx, int dy) {
    p.x += dx;
    p.y += dy;
  }

  static void translate_rectangle(Rectangle r, int dx, int dy) {
    r.x += dx;
    r.y += dy;
  }

  static boolean rectangle_contains_point(Rectangle r, Point p) {
    if (p.x < r.x || p.x >= (r.x+r.width))
      return false;
    if (p.y < r.y || p.y >= (r.y+r.height))
      return false;
    return true;
  }
  
  /* And again here... some more decorated names for the function
   * on vectors, points, and rectangles.
   * So here, we need to distinguish again between translate 
   * on a point and translate on a rectangle.
   * Nota Bene:
   * Java permits name overloading, so this is not necessary
   * in Java, but we are coding C-style here.
   */
  static void vector_translate_point(Vector v, Point p) {
    p.x += v.rho * Math.cos(v.theta);
    p.y += v.rho * Math.sin(v.theta);
  }

  static void vector_translate_rectangle(Vector v, Rectangle r) {
    r.x += v.rho * Math.cos(v.theta);
    r.y += v.rho * Math.sin(v.theta);
  }

}


public class JavaBasicsStep5CStyle {

  /* Some "global variables"...
   * Indeed, static variables are like global variables
   * with a fancy name: package name + class name + variable name.
   */
  static Point p1;
  static Rectangle rect1;
  static Rectangle rect2;
  
  public static void initialize() {

    // Let's construct a point (x=10,y=23)
    p1 = new Point();
    Operations.init_point(p1,10,23);
    
    // Let's construct a first rectangle (x=22,y=35,w=12,h=16).
    rect1 = new Rectangle();
    Operations.init_rectangle(rect1,22,35, 12,16);
    
    // Let's construct another rectangle (x=5,y=4,w=100,h=150).
    rect2 = new Rectangle();
    Operations.init_rectangle(rect2,5,4, 100,150);
  }
  
  /*
   * Given the values, we should have:
   * 
   *  rect1 does not contain the point.
   *  rect2 does contain the point.
   */
  public static boolean doChecks() {
    if (Operations.rectangle_contains_point(rect1,p1)) {
      System.out.println("Error: Rect1 contains the point P1.");
      return false;
    }
    if (!Operations.rectangle_contains_point(rect2,p1)) {
      System.out.println("Error: Rect2 does not contain the point P1.");    
      return false;
    }
    System.out.println("Correct: Rect2 contains the point P1.");    
    return true;
  }
  
  public static void main(String[] args) {

    // Let's initialize the "global" variables
    initialize();
    
    doChecks();
  }

}
