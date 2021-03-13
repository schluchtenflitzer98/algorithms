package string;

import java.util.Scanner;

public class Caesarcode {

	// Replace char with the third, that would follow in the alphabet

	public static void main(String[] args) {
		Scanner ein = new Scanner(System.in);
		System.out.print("Wort: ");
		String wort = ein.nextLine();
		String neu = new String(wort);
		String zwischen = "";
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String blacklist = "";
		int index = 0;

		for (int i = 0; i < wort.length(); i++) {
			zwischen = String.valueOf(wort.charAt(i));
			zwischen = zwischen.toUpperCase();
			if (!blacklist.contains(zwischen)) {
				index = alphabet.indexOf(zwischen);
				if (index + 3 > alphabet.length()) {
					index = 3 - (alphabet.length() - index);
				} else {
					index += 3;
				}
				neu = neu.replace(wort.charAt(i), alphabet.charAt(index));
				blacklist += zwischen;
			}
		}

		System.out.println("Cäsarcode: " + neu);
		blacklist = "";
		StringBuilder Strbuilder = new StringBuilder(neu);

		for (int i = 0; i < neu.length(); i++) {
			zwischen = String.valueOf(neu.charAt(i));
			zwischen = zwischen.toUpperCase();

			index = alphabet.indexOf(zwischen);
			if (index - 3 < 0) {
				index = (index - 3) + alphabet.length();
			} else {
				index -= 3;
			}
			Strbuilder.setCharAt(i, alphabet.charAt(index));
		}

		System.out.println("Wort: " + Strbuilder.toString());
		ein.close();
	}

}
