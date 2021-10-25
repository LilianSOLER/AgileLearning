package basics.step4;

public class Line {
  private Point start;
  private Point end;
  
  public Line(){
	  this.start = new Point();
	  this.end = new Point();
  }
  
  public Line(Point p, Point o){
	  this.start = p;
	  this.end = o;
  }
  
  public Line(Line l){
	  this.start = l.start;
	  this.end = l.end;
  }
  
  public Point getStartPoint() {
	  return this.start;
  }
  
  public Point getEndPoint() {
	  return this.end;
  }
  
  /*
   * Translating a line is just translating both points.
   */
  void translate(int dx, int dy) {
    this.start.translate(dx, dy);
    this.end.translate(dx, dy);
  }

  /*
   * Rotating a line is just translating the end point.
   */
  void rotate(int dx, int dy) {
    this.end.translate(dx, dy);
  }
}
