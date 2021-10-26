package hanoi.tower;

public class Peg {
	private int max;
	private Disk[] disks;
	private int numberOfDisk;

  public Peg(int max) {
	assert(max > 0);
    this.max = max;
    this.disks = new Disk[max];
    this.numberOfDisk = 0;
  }
  
  public int getMax() {
	  return max;
  }
  
  public void setMax(int max) {
	  this.max = max;
  }
    
  public void push(Disk d) {
	assert(size() < this.max);
	if(this.numberOfDisk > 0) {
		assert(d.getSize() < this.disks[this.numberOfDisk-1].getSize());
	}
	this.numberOfDisk++;
	this.disks[size()-1] = d;
  }

  public Disk pop() {
	  assert(1 <= this.numberOfDisk);
	  this.numberOfDisk--;	
	  return this.disks[this.numberOfDisk];
  }

  //======================================

  public int size() {
    return this.numberOfDisk;
  }

  Disk peekAt(int depth) {
	  assert(depth >= 0);
	  assert(depth < this.max);
	  return this.disks[depth];
  }

  boolean legalMove(Peg dst) {
    if(this.numberOfDisk == 0) {
    	return false;
    }
    if(dst.size() == 0) {
    	return true;
    }
    if(dst.peekAt(dst.size()-1).getSize() > this.disks[this.numberOfDisk -1].getSize()) {
    	return true;
    }
    return false;
  }

}
