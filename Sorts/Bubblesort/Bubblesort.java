public class Bubblesort {

	public static void main(String[] args) {
		int[] array = { 5, -4, 56, 22, 4, 3, 58, 8, 9, 1, 7, 7, 2 };
		int copy = 0;
		boolean stillgotBubbles = false;

		do {
			stillgotBubbles = false;
			for (int i = 0; i < array.length; i++) {
				if (i < (array.length - 1) && array[i] > array[i + 1]) {
					copy = array[i];
					array[i] = array[i + 1];
					array[i + 1] = copy;
					stillgotBubbles = true;
				}
			}

		} while (stillgotBubbles);

		for (int x : array) {
			System.out.print(x + " ");
		}

	}

}
