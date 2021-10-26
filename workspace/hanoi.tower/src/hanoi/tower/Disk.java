package hanoi.tower;

public class Disk {
	private int size;
	public Peg peg;

	public Disk(int size) {
		if (size < 1) {
			throw new IllegalArgumentException("Illegal size");
		}
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public int size() {
		throw new RuntimeException("Not Yet Implemented");
	}
}
