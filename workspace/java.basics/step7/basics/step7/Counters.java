package basics.step7;

public class Counters {

  static int nPoints; // counts the number of points created
  static int nLines; // counts the number of lines created
  static int nPolygons; // counts the number of polygons created
  static int nCircles; // counts the number of circles created
  static int nPointArrays; // counts the number of arrays of points created

  static int nCircleDraws; // counts the number of times a circle was drawn
  static int nPolygonDraws; // counts the number of times a polygon was drawn
  static int nLineDraws; // counts the number of times a line was drawn
  static int nCircleSmooths; // counts the number of times a circle was made smoother

  static long elapsedCircleDraws; // account for the total elapsed time drawing circles
  static long elapsedCircleSmooths; // account for the total elapsed time making circles smoother
  static long elapsedPolygonDraws; // account for the total elapsed time drawing polygons

  static void echo() {
    long elapsed;
    System.out.println("  nPoints=" + nPoints);
    System.out.println("  nLines=" + nLines);
    System.out.println("  nPolygons=" + nPolygons);
    System.out.println("     nPointArrays=" + nPointArrays);
    System.out.println("  nCircles=" + nCircles);
    System.out.println();
    System.out.println("  nCircleDraws=" + nCircleDraws);
    elapsed = elapsedCircleDraws / 1000;
    System.out.println("     elapsed=" + elapsed + "us");
    System.out.println("  nPolygonDraws=" + nPolygonDraws);
    System.out.println("     nLineDraws=" + nLineDraws);
    elapsed = elapsedPolygonDraws / 1000;
    System.out.println("     elapsed=" + elapsed + "us");
    System.out.println();
    System.out.println("  nCircleSmooths=" + nCircleSmooths);
    elapsed = elapsedCircleSmooths / 1000;
    System.out.println("    elapsed=" + elapsed + "us");

  }
}
