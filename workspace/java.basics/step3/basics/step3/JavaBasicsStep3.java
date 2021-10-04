package basics.step3;

public class JavaBasicsStep3 {

  static Point p1; 
  static Point p2;
  static Line l1;
  
  public static void main(String[] args) {

    p1 = new Point();
    p2 = new Point();

    p1.x = 10;
    p1.y = 11;

    Operations.translate(p2,20, 22);

    Line l1 = new Line();
    l1.start = p1;
    l1.end = p2;

    Operations.translate(l1,2, -2);
  }

}
