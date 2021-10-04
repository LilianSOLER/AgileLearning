package basics.step5.java;

/*
 * A class that represents the concept of a point,
 * positioned at the coordinates (x,y)
 * In terms of structure, that is, in terms of fields,
 * a class is close to a C struct, as far as we know.
 * Later, we will see that a class is far more, but 
 * this is for the second semester when we will look
 * at inheritance in object-oriented programming languages.
 */
public class Point {
  public int x;
  public int y;

  /*
   * Constructors are an easy-to-use concept.
   * Look, you can have multiple constructors,
   * one for each way that you can construct an object
   * of this class.
   *    Point p1 = new Point(2,3);
   *    Point p2 = new Point(p1);
   */
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  public Point(Point p) {
    this.x = p.x;
    this.y = p.y;
  }

  /*
   * Isn't this nicer than to have to write
   * 
   *    translate_point(Point receiver, int dx, int dy);
   *    
   * The "this" variable is automatically managed for you.
   * Remember that you can use "this.x" or just "x", 
   * unless there is a name conflict between a field and 
   * a local variable or an argument. Look at the class 
   * Rectangle for examples of such cases.
   */
  public void translate(int dx, int dy) {
    this.x += dx;
    y += dy;  // this is equivalent to "this.y += dy;"
  }
}
