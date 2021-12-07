package object.collections.step1;

import java.util.Random;

public class CollectionsStep1 {

  /* These are constants, since they are static and final.
   * Because they are static, these variables are global variables.
   * Because they are final, they cannot be changed.
   * So they can be considered as constants.
   * 
   * This is the Java equivalent to the C #define construct
   * for defining constants:
   *    #define POINT     0
   *    #define LINE      1
   *    #define RECTANGLE 2
   */
  static final int UNKNOWN = -1;
  static final int POINT = 0;
  static final int LINE = 1;
  static final int RECTANGLE = 2;

  /**
   * Constructs an array of objects, <br>
   * containing a mix of points, lines, and rectangles.
   * 
   * Notice the use of the class Random. The class Random is a random number
   * generator. See the JavaDoc in the class Random for more details.
   * 
   * @return an array of objects with a random mix of points, lines, and
   *         rectangles.
   */
  static Object[] build() {
    Object[] array;
    Random rand = new Random();
    array = new Object[10 + rand.nextInt(10)];

    for (int i = 0; i < array.length; i++) {
      int n = rand.nextInt(3);
      switch (n) {
      case 0:
        array[i] = new Point();
        break;
      case 1:
        array[i] = new Line();
        break;
      case 2:
        array[i] = new Rectangle(0, 0, 0, 0);
        break;
      }
    }
    return array;
  }

  /**
   * This is one way to tell if an object is of a given class. This is certainly
   * not the preferred way, but there are cases where it is the most practical
   * one, especially when you have the name of the class as a string in your
   * program.
   * 
   * <b>Nota Bene:</b><br>
   * The name is a fully qualified name, including the package name. Indeed, you
   * can verify that the method Class.getName() returns a fully qualified name.
   * So for example, the class object for the class Object would return
   * java.lang.Object. The class object for this class would return
   * oop.collections.step1.CollectionsStep1.
   * 
   * @param classname
   * @param o
   * @return
   */
  static boolean instanceOf(String classname, Object o) {
    Class cls = o.getClass(); // remember? an object always knows it class object.
    						  // the class object is the object at runtime describing
                              // the class that you defined in a source file (.java).
                              // the class object knows its name, the fields you defined, 
                              // and the methods. But that is another story...
    boolean res = false;
    
    switch (classname) {
    	case "Point":
    		res = o instanceof Point;
    		break;
    	case "Line":
    		res = o instanceof Line;
    		break;
    	case "Rectangle":
    		res = o instanceof Rectangle;
    		break;
    	default:
    		break;
    }
    		
    return res;
    
  }

  static boolean isPoint(Object o) {
	  return (o instanceof Point);
  }
  
  static boolean isLine(Object o) {
	  return (o instanceof Line);
  }
  
  static boolean isRectangle(Object o) {
	  return (o instanceof Rectangle);
  }
  /**
   * This static method identifies the elements of the array. It scans the array
   * and for each element, typed as an Object, it tests if it is a point, a
   * line, or a rectangle.
   * 
   * @param array
   *          of mixed objects (points, lines, and rectangles)
   * @return an array of integers telling what is the corresponding element in
   *         the given array.
   */
  static int[] identify(Object array[]) {
    int[] kinds = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      Object o = array[i];
      if (instanceOf("Point", o)) { 
        kinds[i] = POINT;
      } else if (instanceOf("Line", o)) {
        kinds[i] = LINE;
      } else if (instanceOf("Rectangle", o)) {
        kinds[i] = RECTANGLE;
      } else
        kinds[i] = UNKNOWN;
    }
    return kinds;
  }

  /**
   * This is a static method that verifies if the description of the kinds of
   * objects in the given array is correct or not.
   * 
   * Notice the Java construct to get a class object when you do not have an
   * instance:
   * 
   * 1) Class cls = oop.collections.step1.Point.class
   * 
   * 2) Class cls = Point.class
   * 
   * At runtime, there is a dynamic lookup to search for the class with the
   * given name. You can give the fully qualified name (1), or the name you
   * would in your code (2).
   *
   * <b>Nota Bene:</b>
   * 
   * For a given class name, there is only one class object. So we have the
   * following
   * 
   * Point p = new Point(); Point.class == p.getClass()
   * 
   * @param array
   * @param kinds
   */
  static void verify(Object array[], int[] kinds) {
    for (int i = 0; i < kinds.length; i++) {
      Class cls = array[i].getClass();
      switch (kinds[i]) {
      case POINT:
        if (cls != object.collections.step1.Point.class)
          throw new RuntimeException(" array[" + i + "]: NOT a Point --> " + cls.getSimpleName());
        break;
      case LINE:
        if (cls != object.collections.step1.Line.class)
          throw new RuntimeException(" array[" + i + "]: NOT a Line --> " + cls.getSimpleName());
        break;
      case RECTANGLE:
        if (cls != object.collections.step1.Rectangle.class)
          throw new RuntimeException(" array[" + i + "]: NOT a Rectangle --> " + cls.getSimpleName());
        break;
      default:
        /*
         * DO NOT REMOVE THIS THROW OF AN EXCEPTION.
         * Removing the throw is not the solution to the bug.
         * Hiding under the rug a problem is never a good solution.
         * So the question is the following: how come some elements of the array 
         * was not identified properly?
         */
        throw new RuntimeException(" array[" + i + "]: unknown --> " + cls.getSimpleName());
      }
    }
  }

  /**
   * A simple echo of the classes of objects in the given array, based on the
   * given kinds.
   */
  static void echo(Object array[], int[] kinds) {
    for (int i = 0; i < kinds.length; i++) {
      switch (kinds[i]) {
      case POINT:
        System.out.printf(" array[%d]: Point\n", i);
        break;
      case LINE:
        System.out.printf(" array[%d]: Line\n", i);
        break;
      case RECTANGLE:
        System.out.printf(" array[%d]: Rectangle\n", i);
        break;
      }
    }
  }

  public static void main(String args[]) {
    int[] kinds;
    Object[] array;
    try {
      array = build();         // first, let's build an array of mixed objects.
      kinds = identify(array); // second, let's identify that mix, the kind of each entry in the mixed array.
      verify(array, kinds);    // third,  let's verify that we identified the mix correctly.
      echo(array,kinds);       // finally, we echo how we identified the objects in the mixed array.
    } catch (RuntimeException ex) {
      System.err.println("Oops... You didn't fix the bug yet.");
      ex.printStackTrace(System.err);
      System.exit(-1); // exiting with an error code.
    }
    System.out.println("That's all folks");
  }

}
