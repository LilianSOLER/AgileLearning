package hanoi.tower;

import java.io.IOException;

public class HanoiTowerPuzzle {

  public static void main(String args[]) throws IOException {
    int ndisks;
    if (args.length > 0)
      ndisks = Integer.parseInt(args[0]);
    else
      ndisks = 5;

    Solver solver = new Solver(ndisks);
    solver.solve();
  }

}
