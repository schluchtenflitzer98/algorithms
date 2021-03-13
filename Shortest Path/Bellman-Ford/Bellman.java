package bellman;

public class Bellman {

	private int node;

	private int distance;

	private int anchestor;

	private boolean infinity;

	public Bellman(int node, int distance, int anchestor, boolean infinity) {
		super();
		this.node = node;
		this.distance = distance;
		this.anchestor = anchestor;
		this.infinity = infinity;
	}

	public Bellman(int node, int distance, int anchestor) {
		super();
		this.node = node;
		this.distance = distance;
		this.anchestor = anchestor;
		this.infinity = true;
	}

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getAnchestor() {
		return anchestor;
	}

	public void setAnchestor(int anchestor) {
		this.anchestor = anchestor;
	}

	public boolean isInfinity() {
		return infinity;
	}

	public void setInfinity(boolean infinity) {
		this.infinity = infinity;
	}

	@Override
	public String toString() {
		return "Bellman [node=" + node + ", distance=" + distance + ", anchestor=" + anchestor + ", infinity="
				+ infinity + "]";
	}

}
