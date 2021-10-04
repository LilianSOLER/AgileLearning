package object.gui;

public class Toolkit2 extends Toolkit {

  public Toolkit2() {
    super();
  }

  public Toolkit2(int width, int height) {
    super(width,height);
  }

  @Override
  public void setTimer(int delay, final TimerListener listener) {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public void expired() {
    throw new RuntimeException("Not Yet Implemented");
  }

}
