package dijkstra;

public class DijkstraElement {

	private int node;

	private int distance;

	private int anchestor;

	public DijkstraElement(int node, int distance, int anchestor) {
		this.node = node;
		this.distance = distance;
		this.anchestor = anchestor;
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

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}

	@Override
	public String toString() {
		return "DijkstraElement [node=" + node + ", distance=" + distance + ", anchestor=" + anchestor + "]";
	}

}
