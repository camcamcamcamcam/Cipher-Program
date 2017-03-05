package cam.database;

public class Ciphers {
	public static String[][] ciphers = { { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
			"p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" }, {}, {} };

	public static int[] plaintextToNumbers(String cipher) {
		cipher = cipher.toLowerCase();
		int[] cipherNumbers = new int[cipher.length()];
		for (int i = 0; i < cipher.length(); i++) {
			// System.out.println("Character " + i);
			for (int j = 0; j < 26; j++) {
				// System.out.print("Trying rot " + j + ": " + ciphers[0][j]);
				if (("" + cipher.charAt(i)).equals(ciphers[0][j])) {
					cipherNumbers[i] = j + 1;
					/*
					 * if (cipherNumbers[i] == 1) { cipherNumbers[i] = 0; }
					 */
					// System.out.println("Success");
					break;
				}
			}
		}
		return cipherNumbers;
	}

	public static String numbersToPlaintext(int[] cipherNumbers) {
		String plaintext = "";
		for (int i = 0; i < cipherNumbers.length; i++) {
			if (cipherNumbers[i] == 0) {
				plaintext = plaintext + " ";
			} else {
				plaintext = plaintext + ciphers[0][cipherNumbers[i] - 1];
			}
		}
		return plaintext;
	}

	public static int[] rotation(String cipher, int rotationNumber) {
		int[] cipherNumbers = plaintextToNumbers(cipher);
		for (int i = 0; i < cipher.length(); i++) {
			if (cipherNumbers[i] != 0) {
				cipherNumbers[i] = (cipherNumbers[i] + rotationNumber) % 26;
			}
		}
		return cipherNumbers;
	}
}
