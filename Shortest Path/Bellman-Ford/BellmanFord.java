package bellman;

import java.util.ArrayList;

import bellman.Bellman;

public class BellmanFord {

	// hypothesis: (A->B != 0)
	// BellmanFord must only run in one direction!!!!
	// In case you use both direction (A->B && B->A) you (likely) get wrong data!!!

	static int[][] routes = new int[6][6];

	public static void main(String[] args) {
		int start = 0;
		ArrayList<Bellman> data = new ArrayList<Bellman>();
		Bellman[] result = new Bellman[routes.length];

		init();

		// Building data ArrayList
		for (int x = 0; x < routes.length; x++) {
			for (int y = 0; y < routes[x].length; y++) {
				if (routes[x][y] != 0) {
					data.add(new Bellman(y, routes[x][y], x));
				}
			}
		}

		for (Bellman x : data) {
			System.out.println(x.toString());
		}
		System.out.println();

		// starting node has distance zero
		result[0] = new Bellman(start, 0, start, false);
		// all others are infinity
		for (int i = 1; i < routes.length; i++) {
			result[i] = new Bellman(i, 0, 0);
		}

		// Starting Bellman phases
		for (int p = 0; p < result.length; p++) {

			for (Bellman x : data) {

				if (!result[x.getAnchestor()].isInfinity()) {// just relevant, if there is any route to the node

					if (result[x.getNode()].isInfinity()) {
						// Node is unknown
						// Distance to Node: Anchestor + Distance
						result[x.getNode()].setDistance(result[x.getAnchestor()].getDistance() + x.getDistance());
						result[x.getNode()].setInfinity(false);
						result[x.getNode()].setAnchestor(x.getAnchestor());
						// }
					} else {
						// Node is known
						if (result[x.getAnchestor()].getDistance() + x.getDistance() < result[x.getNode()]
								.getDistance()) {
							result[x.getNode()].setDistance(result[x.getAnchestor()].getDistance() + x.getDistance());
							result[x.getNode()].setAnchestor(x.getAnchestor());
						}

					}
				}

			}

		}

		for (Bellman x : result) {
			System.out.println(x.toString());
		}
		// For shortest route just read table, ala Dijkstra...

	}

	public static void init() {
		// structure: route[fromNode][toNode] = "Distance"

		routes[0][1] = 10;
		routes[0][2] = 20;
		routes[1][3] = 50;
		routes[1][4] = 10;
		routes[2][4] = 33;
		routes[2][3] = 20;
		routes[4][5] = 1;
		routes[3][4] = -20;
		routes[3][5] = -2;

	}

}
