package basics.step4;

/**
 * A class that represents the concept of a point, positioned at the coordinates
 * (x,y) on a plane.
 */
public class Point {
  public int x, y;
  
  public Point(){
	  this.x = 0;
	  this.y = 0;
  }
  
  public Point(int x, int y){
	 this.x = x;
	 this.y = y;
  }
  
  public Point(Point p){
	  this.x = p.x;
	  this.y = p.y;
  }  
    
  void translate(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }
  
}
