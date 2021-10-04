package hanoi.tower;

public class Disk {
  int size;
  Peg peg;

  Disk(int size) {
    this.size = size;
  }

  public int size() {
    throw new RuntimeException("Not Yet Implemented");
  }
}
