package basics.step4;

public class Line {
  private Point start;
  private Point end;
  
  public Line(){
	  this.setStart(new Point());
	  this.setEnd(new Point());
  }
  
  public Line(Point p, Point o){
	  this.setStart(p);
	  this.setEnd(o);
  }
  
  public Line(Line l){
	  this.setStart(l.getStart());
	  this.setEnd(l.getEnd());
  }
  
  public Point getStartPoint() {
	  return this.getStart();
  }
  
  public Point getEndPoint() {
	  return this.getEnd();
  }
  
  /*
   * Translating a line is just translating both points.
   */
  void translate(int dx, int dy) {
    this.getStart().translate(dx, dy);
    this.getEnd().translate(dx, dy);
  }

  /*
   * Rotating a line is just translating the end point.
   */
  void rotate(int dx, int dy) {
    this.getEnd().translate(dx, dy);
  }

public Point getStart() {
	return start;
}

public void setStart(Point start) {
	this.start = start;
}

public Point getEnd() {
	return end;
}

public void setEnd(Point end) {
	this.end = end;
}
}
