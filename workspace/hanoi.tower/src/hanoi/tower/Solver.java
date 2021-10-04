package hanoi.tower;

public class Solver {

  // our three pegs
  private Peg pegA, pegB, pegC;

  // keep track of how many times we move a disk
  private int nmoves;

  // remember the number of disks
  private int ndisks;

  /*
   * The constructor is pretty simple, create the three pegs and 
   * initialize one as a neat stack of disk of decreasing size.
   */
  public Solver(int ndisks) {
    pegA = new Peg(ndisks);
    pegB = new Peg(ndisks);
    pegC = new Peg(ndisks);

    this.ndisks = ndisks;

    int size = ndisks;
    for (int i = 0; i < ndisks; i++, size--)
      pegA.push(new Disk(size));
  }

  /*
   * The game completes when pegA and pegB are empty.
   * This is correct given the invariants we will maintain
   * while we solve the puzzle.
   */
  boolean completed() {
    // check that we are not taking too many moves
    // to complete the puzzle.
    assert (nmoves <= ((1 << ndisks) - 1));
    return (pegA.size() == 0 && (pegB.size() == 0 || pegC.size() == 0));
  }

  /*
   * This is to print the current state of the puzzle, 
   * neatly showing the disks on the pegs.
   */
  void echo() {
    System.out.println("------------------------------------------");
    System.out.println("Step " + nmoves);
    for (int d = ndisks - 1; d >= 0; d--) {
      Disk a = pegA.peekAt(d);
      Disk b = pegB.peekAt(d);
      Disk c = pegC.peekAt(d);
      if (a == null && b == null && c == null)
        continue;
      if (a != null)
        System.out.printf("\t[%d]", a.size());
      else
        System.out.printf("\t   ");
      if (b != null)
        System.out.printf("\t[%d]", b.size());
      else
        System.out.printf("\t   ");
      if (c != null)
        System.out.printf("\t[%d]", c.size());
      else
        System.out.printf("\t   ");
      System.out.println();
    }
    System.out.printf("\t A\t B\t C\n");
  }

  public void solve() {
    boolean even = 2 * (ndisks / 2) == ndisks;
    echo();
    if (even)
      evenSolution();
    else
      oddSolution();

    System.out.println("Resolved in " + nmoves + " moves.");
  }

  /*
   * Solution for an even number of disks:
   *
   *  - make the legal move between pegs A and B (in either direction)
   *  - make the legal move between pegs A and C (in either direction) 
   *  - make the legal move between pegs B and C (in either direction) 
   *  - repeat until complete
   */
  private void evenSolution() {
    while (true) {
      // make the legal move between pegs A and B (in either direction)
      if (pegA.legalMove(pegB))
        pegB.push(pegA.pop());
      else {
        assert (pegB.legalMove(pegA));
        pegA.push(pegB.pop());
      }
      nmoves++;
      echo();
      if (completed())
        break;
      // make the legal move between pegs A and C (in either direction)
      if (pegA.legalMove(pegC))
        pegC.push(pegA.pop());
      else {
        assert (pegC.legalMove(pegA));
        pegA.push(pegC.pop());
      }
      nmoves++;
      echo();
      if (completed())
        break;
      // make the legal move between pegs B and C (in either direction)
      if (pegB.legalMove(pegC))
        pegC.push(pegB.pop());
      else {
        assert (pegC.legalMove(pegB));
        pegB.push(pegC.pop());
      }
      nmoves++;
      echo();
      if (completed())
        break;
    }
    return;
  }

  /*
   * Solution for an odd number of disks:
   *
   *  - make the legal move between pegs A and C (in either direction)
   *  - make the legal move between pegs A and B (in either direction) 
   *  - make the legal move between pegs B and C (in either direction) 
   *  - repeat until complete
   */
  private void oddSolution() {
    while (true) {
      // make the legal move between pegs A and C (in either direction)
      if (pegA.legalMove(pegC))
        pegC.push(pegA.pop());
      else {
        assert (pegC.legalMove(pegA));
        pegA.push(pegC.pop());
      }
      nmoves++;
      echo();
      if (completed())
        break;
      // make the legal move between pegs A and B (in either direction)
      if (pegA.legalMove(pegB))
        pegB.push(pegA.pop());
      else {
        assert (pegB.legalMove(pegA));
        pegA.push(pegB.pop());
      }
      nmoves++;
      echo();
      if (completed())
        break;
      // make the legal move between pegs B and C (in either direction)
      if (pegB.legalMove(pegC))
        pegC.push(pegB.pop());
      else {
        assert (pegC.legalMove(pegB));
        pegB.push(pegC.pop());
      }
      nmoves++;
      echo();
      if (completed())
        break;
    }
  }

}
