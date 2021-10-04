package basics.step5.java;

public class Vector {
		
  public float rho;
  public float theta;

  public Vector(float rho, float theta) {
    this.rho = rho;
    this.theta = theta;
  }

  public Vector(Vector v) {
    this.rho = v.rho;
    this.theta = v.theta;
  }

  public void translate(Point p) {
    p.x = (int)(p.x + rho * Math.cos(theta));
    p.y = (int)(p.y + rho * Math.sin(theta));
  }

  public void translate(Rectangle r) {
    r.x = (int)(r.x + rho * Math.cos(theta));
    r.y = (int)(r.y + rho * Math.sin(theta));
  }
  
  public void stretch(Rectangle r) {
    r.width = (int)(r.width + rho * Math.cos(theta));
    r.height = (int)(r.height + rho * Math.sin(theta));
  }

}
