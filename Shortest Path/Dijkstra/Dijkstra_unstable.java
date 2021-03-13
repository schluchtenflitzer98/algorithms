package dijkstra;

import java.util.Scanner;

public class Dijkstra {

	// static int[][] strecken = new int[18][18];
	static int[][] strecken = new int[6][6];

	public static void main(String[] args) {
		Scanner ein = new Scanner(System.in);
		int von;
		int nach;
		int[][] dijkstra = new int[strecken.length][strecken.length];
		int[][] dijkstraindex = new int[strecken.length][strecken.length];
		int[][] weg = new int[strecken.length][strecken.length];
		int[] dijkstradone = new int[strecken.length];

		init();

		System.out.print("Von: ");
		 von = ein.nextInt();
		//von = 0;
		System.out.print("Nach: ");
		 nach = ein.nextInt();
	//	nach = 4;

		// weg[0] = von;

		int xdisk = 0;
		int ydisk = 0;
		dijkstra[xdisk][ydisk] = strecken[von][von]; // Strecke von A nach A = immer 0
		dijkstraindex[xdisk][ydisk] = von; // Startposition/Index = A
		dijkstradone[0] = 1;
		ydisk++;
		int curr = von; // aktueller Standort
		int min = 0;
		int minindex = 0;

		for (int i = 0; i < dijkstra.length; i++) {
			for (int x = 0; x < strecken.length; x++) {
				for (int y = 0; y < strecken[x].length; y++) {

					// if ((x == curr || y == curr) && strecken[x][y] != 0) {

					if ((x == curr) && strecken[x][y] != 0) {

						dijkstra[xdisk][ydisk] = strecken[x][y] + min;

						if (x != curr) {
							dijkstraindex[xdisk][ydisk] = x;
						}
						if (y != curr) {
							dijkstraindex[xdisk][ydisk] = y;
						}

						// weg[i] = curr;
						// if(xdisk > 0) {
						weg[xdisk][ydisk] = curr;
						// }

						if (ydisk < strecken[x].length - 1) {
							ydisk++;
						}
					}

				}
			}

			int zwischen;
			for (int x = 0; x < dijkstraindex[xdisk].length; x++) {
				if (dijkstraindex[xdisk][x] != 0 && xdisk > 0) {
					zwischen = dijkstra[xdisk][dijkstraindex[xdisk][x]];
					if (zwischen > dijkstra[xdisk][x] || zwischen == 0) {
						dijkstra[xdisk][dijkstraindex[xdisk][x]] = dijkstra[xdisk][x];
						dijkstra[xdisk][x] = 0;
						
						weg[xdisk][dijkstraindex[xdisk][x]] = weg[xdisk][x];
						weg[xdisk][x] = 0;

						
						
						dijkstraindex[xdisk][dijkstraindex[xdisk][x]] = dijkstraindex[xdisk][x];
						dijkstraindex[xdisk][x] = 0;


					}
				}
			}

			// Ergaenze Werte aus vorheriger Zeile falls keine neuen Wege gefunden && pr�fen
			// ob der vorherige kleiner

			for (int z = 0; z < dijkstra[xdisk].length; z++) {
				if (xdisk > 0 && dijkstra[xdisk][z] != 0 && dijkstra[xdisk - 1][z] < dijkstra[xdisk][z]
						&& dijkstra[xdisk - 1][z] != 0) {
					dijkstra[xdisk][z] = dijkstra[xdisk - 1][z];
					weg[xdisk][z] = weg[xdisk - 1][z];
				}
				if (xdisk > 0 && dijkstra[xdisk][z] == 0 && dijkstra[xdisk - 1][z] > dijkstra[xdisk][z]) {
					dijkstra[xdisk][z] = dijkstra[xdisk - 1][z];
					dijkstraindex[xdisk][z] = dijkstraindex[xdisk - 1][z];
					weg[xdisk][z] = weg[xdisk - 1][z];
				}
			}

			int lastindex = 0;
			// ermittle den naechsten punkt
			for (int s = 0; s < dijkstra[xdisk].length; s++) {
				min = min > dijkstra[xdisk][s] ? min : dijkstra[xdisk][s];
			}

			for (int s = 0; s < dijkstra[xdisk].length; s++) {
				if (dijkstra[xdisk][s] != 0) {
					if (dijkstradone[s] != 1) {

						if (dijkstra[xdisk][s] < min) {
							min = dijkstra[xdisk][s] < min ? dijkstra[xdisk][s] : min; // Wertupdate
							minindex = dijkstraindex[xdisk][s]; // Indexupdate
							lastindex = s;
						}
					}

				}
			}
			curr = minindex;
			dijkstradone[lastindex] = 1;

			if (xdisk < strecken.length - 1) {
				xdisk++;
			}

		}

		// Ermittlung des Ergebnisses
		int sum = 0;
		int search = nach;
		String output = "Strecke: ";
		String zwischen = "";
		String[] ausgabe;
		boolean exit = false;
		// Letze Zeile holen
		
		sum += dijkstra[dijkstra.length - 1][search];
		
		do {
			//sum += dijkstra[dijkstra.length - 1][search];
			zwischen += search + ";";
			if (search == von) {
				exit = true;
				continue;
			}
			search = weg[dijkstraindex.length - 1][search];
		} while (exit != true);

		// Ausgabegeschichte
		ausgabe = zwischen.split(";");
		for (int i = (ausgabe.length - 1); i >= 0; i--) {
			if (i == 0) {
				output += ausgabe[i];
			} else {
				output += ausgabe[i] + "->";
			}
		}

		ein.close();
		System.out.println();
		System.out.println("Summe: " + sum);
		System.out.println(output);
	}

	public static void init() {
		/*
		 * strecken[0][0] = 0; strecken[1][1] = 0; strecken[2][2] = 0; strecken[3][3] =
		 * 0; strecken[4][4] = 0; strecken[5][5] = 0; strecken[6][6] = 0; strecken[7][7]
		 * = 0; strecken[8][8] = 0; strecken[9][9] = 0;
		 */
		// Unötiger, aber die einzigen "gültigen" 0en
		/*
		 * strecken[10][10] = 0; strecken[11][11] = 0; strecken[12][12] = 0;
		 * strecken[13][13] = 0; strecken[14][14] = 0; strecken[15][15] = 0;
		 * strecken[16][16] = 0; strecken[17][17] = 0; strecken[0][1] = 36;
		 * strecken[0][2] = 22; strecken[0][3] = 36; strecken[0][7] = 69; strecken[1][4]
		 * = 12; strecken[1][5] = 31; strecken[1][6] = 43; strecken[2][3] = 20;
		 * strecken[2][8] = 30; strecken[2][4] = 29; strecken[3][9] = 95; strecken[3][7]
		 * = 64; strecken[4][5] = 23; strecken[4][7] = 26; strecken[5][6] = 40;
		 * strecken[6][7] = 34; strecken[6][12] = 55; strecken[6][10] = 66;
		 * strecken[7][8] = 32; strecken[7][10] = 30; strecken[8][9] = 40;
		 * strecken[8][11] = 23; strecken[9][10] = 100; strecken[9][13] = 58;
		 * strecken[10][11] = 29; strecken[10][12] = 34; strecken[10][14] = 31;
		 * strecken[11][13] = 30; strecken[11][14] = 20; strecken[12][14] = 25;
		 * strecken[12][15] = 57; strecken[12][17] = 91; strecken[13][14] = 58;
		 * strecken[13][16] = 60; strecken[14][15] = 29; strecken[14][16] = 31;
		 * strecken[15][16] = 79; strecken[15][17] = 14; strecken[16][17] = 102;
		 */

		strecken[0][1] = 20;
		strecken[0][2] = 40;
		strecken[0][3] = 30;
		strecken[1][5] = 10;
		strecken[1][3] = 34;
		strecken[3][5] = 24;
		strecken[3][4] = 30;
		strecken[3][2] = 10;
		strecken[2][4] = 50;
		strecken[5][4] = 10;

	}

}
