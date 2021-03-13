
public class BinarySearch {

	public static void main(String[] args) {
		char term = 'B';
		// Java erkennt angeblich (lt. Heitzer) die Reihenfolge des Alphabets wegen der
		// dahinterarbeitenden ASCII Tabelle
		char[] array = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		int left = 0; // Turn left
		int right = array.length; // Turn right
		int currIndex = 0; // Turn around you could tell what I like
		boolean found = false;

		do {
			currIndex = left + ((int) Math.floor(((double) (right - left) / 2)));

			if (array[currIndex] > term) {
				right = currIndex;
			} else if (array[currIndex] < term) {
				left = currIndex;
			} else if (array[currIndex] == term) {
				found = true;
			}

		} while (!found);

		System.out.println("Wert " + term + " hat Index " + currIndex);

	}

}
