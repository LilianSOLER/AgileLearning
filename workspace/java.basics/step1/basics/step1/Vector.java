package basics.step1;

public class Vector {
	float rho;
    float theta;
    
    Point toPoint(Point origin) {
    	Point p = new Point();
    	p.x = origin.x + (int)( rho * Math.cos(theta));
    	p.y = origin.y + (int)(rho * Math.sin(theta));
    	return p;
    }
    
    int toX() {
        return (int)(rho * Math.cos(theta));
      }
      int toY() {
        return (int)(rho * Math.sin(theta));
      }
    
    void translate(Point p) {
    	p.x += (int)( rho * Math.cos(theta));
    	p.y += (int)(rho * Math.sin(theta));
    }
}
