package aStern;

public class AStar {

	private int node;

	private int estimation;

	public AStar(int node, int distance) {
		this.node = node;
		this.estimation = distance;
	}

	public int getEstimaton() {
		return estimation;
	}

	public void setgetEstimaton(int distance) {
		this.estimation = distance;
	}

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}

	@Override
	public String toString() {
		return "DijkstraElement [node=" + node + ", Estimation=" + estimation + "]";
	}

}
