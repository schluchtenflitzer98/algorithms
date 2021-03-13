package dijkstra;

import java.util.ArrayList;
import dijkstra.DijkstraElement;

public class Dijkstra {

	// hypothesis: (A->B != 0)?
	// null = no direct route (yet)

	// static int[][] routes = new int[18][18];
	static int[][] routes = new int[6][6];

	public static void main(String[] args) {
		int start = 0;
		int destination = 4;
		ArrayList<DijkstraElement> data = new ArrayList<DijkstraElement>();

		init();

		// Build ArrayList data
		for (int y = 0; y < routes.length; y++) {
			for (int x = 0; x < routes[y].length; x++) {
				if (routes[y][x] != 0) {
					DijkstraElement element = new DijkstraElement(x, routes[y][x], y);
					data.add(element);
				}
			}
		}

		System.out.println(data.toString());

		// Starting evaluate data ArrayList
		int position = start;
		int nextPos = start;
		DijkstraElement[] result = new DijkstraElement[routes.length];
		ArrayList<DijkstraElement> queue = new ArrayList<DijkstraElement>();

		// Mark Startingnode with distance 0
		result[0] = new DijkstraElement(start, 0, start);

		// Starting Dijkstra

		do {

			for (DijkstraElement x : data) {
				if (x.getNode() == position || x.getAnchestor() == position) {

					if (x.getNode() == position) {
						nextPos = x.getAnchestor();
					}
					if (x.getAnchestor() == position) {
						nextPos = x.getNode();
					}

					if (checkOnElement(result, nextPos)) {
						// node exists
						int lindex = getElement(result, nextPos);
						if (result[lindex].getDistance() > getDistanceBack(result, start, x.getAnchestor())
								+ x.getDistance()) {
							result[lindex]
									.setDistance(getDistanceBack(result, start, x.getAnchestor()) + x.getDistance());
							result[lindex].setAnchestor(x.getAnchestor());
						}
					} else {
						// add node
						for (int i = 0; i < result.length; i++) {
							if (result[i] == null) {
								DijkstraElement newElement = new DijkstraElement(nextPos,
										getDistanceBack(result, start, x.getAnchestor()) + x.getDistance(), position);
								result[i] = newElement;
								queue.add(newElement);
								break;
							}
						}
					}

				}
			}

			// Modifying the queue
			// Delete the current Node (postion)
			for (int i = 0; i < queue.size(); i++) {
				if (queue.get(i).getNode() == position) {
					queue.remove(i);
				}
			}

			// get next (closest) Node
			if (queue.size() > 0) {
				int ldistance = queue.get(0).getDistance();
				position = queue.get(0).getNode();
				for (int i = 0; i < queue.size(); i++) {
					position = queue.get(i).getDistance() < ldistance ? queue.get(i).getNode() : position;
					ldistance = queue.get(i).getDistance()  < ldistance ? queue.get(i).getDistance() : ldistance;
				}
			}

		} while (!queue.isEmpty());

		for (DijkstraElement x : result) {
			System.out.println(x.toString());
		}

		System.out.println();

		// OUPUT: As long as start node stays the same, you can always use result
		System.out.println("Total Distance: " + getDistanceBack(result, start, destination));
		System.out.println("Route (Dest. -> Start): " + outputRoute(result, start, destination));

	}

	public static boolean checkOnElement(DijkstraElement[] result, int term) {
		for (DijkstraElement x : result) {
			if (x != null && x.getNode() == term) {
				return true;
			}
		}

		return false;

	}

	public static int getElement(DijkstraElement[] result, int term) {
		for (int i = 0; i < result.length; i++) {
			if (result[i].getNode() == term) {
				return i;
			}
		}
		// Must not happen, check first
		return 0;
	}

	public static int getDistanceBack(DijkstraElement[] result, int start, int position) {
		int sum = 0;
		int curpos = position;

		for (DijkstraElement x : result) {
			if (x != null && x.getNode() == curpos) {
				sum += x.getDistance();
				curpos = x.getAnchestor();
				break;
			}
		}

		return sum;
	}

	public static String outputRoute(DijkstraElement[] result, int start, int position) {
		String output = position + "";
		int curpos = position;

		while (curpos != start) {
			for (DijkstraElement x : result) {
				if (x != null && x.getNode() == curpos) {
					output += " -> " + x.getAnchestor();
					curpos = x.getAnchestor();
				}
			}
		}

		return output;
	}

	public static void init() {
		// structure: route[fromNode][toNode] = "Distance"
		/*
		 * routes[10][10] = 0; routes[11][11] = 0; routes[12][12] = 0; routes[13][13] =
		 * 0; routes[14][14] = 0; routes[15][15] = 0; routes[16][16] = 0; routes[17][17]
		 * = 0; routes[0][1] = 36; routes[0][2] = 22; routes[0][3] = 36; routes[0][7] =
		 * 69; routes[1][4] = 12; routes[1][5] = 31; routes[1][6] = 43; routes[2][3] =
		 * 20; routes[2][8] = 30; routes[2][4] = 29; routes[3][9] = 95; routes[3][7] =
		 * 64; routes[4][5] = 23; routes[4][7] = 26; routes[5][6] = 40; routes[6][7] =
		 * 34; routes[6][12] = 55; routes[6][10] = 66; routes[7][8] = 32; routes[7][10]
		 * = 30; routes[8][9] = 40; routes[8][11] = 23; routes[9][10] = 100;
		 * routes[9][13] = 58; routes[10][11] = 29; routes[10][12] = 34; routes[10][14]
		 * = 31; routes[11][13] = 30; routes[11][14] = 20; routes[12][14] = 25;
		 * routes[12][15] = 57; routes[12][17] = 91; routes[13][14] = 58; routes[13][16]
		 * = 60; routes[14][15] = 29; routes[14][16] = 31; routes[15][16] = 79;
		 * routes[15][17] = 14; routes[16][17] = 102;
		 */

		routes[0][1] = 20;
		routes[0][2] = 40;
		routes[0][3] = 30;
		routes[1][5] = 10;
		routes[1][3] = 34;
		routes[3][5] = 24;
		routes[3][4] = 30;
		routes[3][2] = 10;
		routes[2][4] = 50;
		routes[5][4] = 10;

	}

}
