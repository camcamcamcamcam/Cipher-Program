package cam.cipher;

public class Ciphers {
	// The string array below contains all the explanations of different
	// ciphers. It is formatted like this: {Title, Explanation, Usage}.
	public static String[][] cipherInfo = {
			{ "Plaintext", "This is the name for text that is not enciphered, i.e. readable.",
					"This is the name for text that is not enciphered, i.e. readable." },
			{ "Number cipher",
					"This cipher converts letters to numbers corresponding to their place in the alphabet. For example, 1 stands for A, 2 stands for B, and so on.",
					"This is one of the easiest ciphers and one of the first that children learn." },
			{ "Rotational cipher",
					"This cipher rotates all letters a certain number of places in the alphabet. A ROT-1 cipher would change A to B, B to C, and so on until Z to A.",
					"This is a common cipher used in puzzle books or mystery novels." },
			{ "Reverse cipher",
					"This cipher substitutes all letters with their reverse, so A and Z switch places, B and Y switch, and so on.",
					"This is a common cipher used in puzzle books or mystery novels." },
			{ "Half-reverse cipher",
					"This cipher is laid out with the first 13 letters directly above the last 13, so A = N, B = O, and so on. These are reversed also, so N = A, O = B etc.",
					"This is a common cipher used in puzzle books or mystery novels." },
			{ "NATO Phonetic Alphabet",
					"This replaces all letters with a fixed word with the letter as its inital. For example, A = Alfa, B = Bravo.",
					"This is used in the Air Force as a means of communicating critcal codes regardless of the quality of the communication channel." },
			{ "Morse Code", "This replaces letters with a series of dots and dashes.",
					"This is not a code, but was used in the early days of radios." },
			{ "Vatsyayana cipher",
					"This pairs up random letters to decipher into one another, for example Z could pair up with H, meaning H = Z and Z = H.",
					"This was used in Ancient India for women to send secret messages to attractive men without their wives finding out." },
			{ "Keyword cipher",
					"This is like the Vatsyayana cipher, but the letters do not decipher into another. If H = Z, Z doesn't have to = H. Also, the use of a keyword in the code helps it to be easy to remember. Simply write out the keyword without repeating a letter, then follow the alphabet to fill in all the letters you haven't written yet. For example, 'I love brussels sprouts' would become ILOVEBRUSPTWXYZACDFGHJKMNQ, and A = I, B = L, and so on.",
					"This was used as a more secure and easy to remember approach to ensure messages are private." },
			{ "Vigenere cipher",
					"This cipher uses multiple rotational ciphers for a message, so ROT-4 may be used for every odd-numbered letter, and ROT-13 for the rest. To add security, use more ciphers. All your recipient needs to know is which ciphers you cycle through.",
					"This was used during the American Civil War. It remained unbreakable for 3 centuries after it being invented." },
			{ "Enigma cipher",
					"This is like a Vigenere cipher, but uses several more wheels to scramble the message even more. All the wheels shift everytime, allowing 158,962,555,217,826,360,000 possible combinations.",
					"This cipher was used by Nazi Germany during the Second World War." } };
	// The 2D array below displays all the known substitution ciphers.
	public static String[][] ciphers = {
			{ "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
					"v", "w", "x", "y", "z" },
			{ "Alfa", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliett", "Kilo",
					"Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform",
					"Victor", "Whiskey", "X-ray", "Yankee", "Zulu" },
			{ ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
					".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." },
			{ "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
					"V", "W", "X", "Y", "Z" } };

	// TODO Ciphers: Vigenere, ENIGMA!

	public static String[] namesOfCiphers = { "Plaintext", "Number", "Rotational", "Reverse", "Half-reverse",
			"NATO Phonetic", "Morse Code", "Vatsyayana", "Keyword", "Vigenere", "Enigma" };

	public static String selectedCipher1 = "";
	public static String selectedCipher2 = "";

	public static String textContents1 = "";
	public static String textContents2 = "";
	public static String plaintextContents = "";

	// This code converts a string of numbers and slashes to an int array.
	public static int[] intCaster(String text) {
		// Initializes the array to return, and the two ints to help with
		// substrings and slotting the correct numbers into the array.
		int[] result = new int[text.length()];
		int placeInArray = 0;
		int startingPoint = 0;
		// Goes through entire input string
		for (int i = 0; i < text.length(); i++) {
			// Tries to parse the current character into an int.
			try {
				Integer.parseInt("" + text.charAt(i));
			} catch (NumberFormatException e) {
				// It found a slash, so it slots the characters between the
				// start (or last found slash) and the slash into the next empty
				// place in the array.
				result[placeInArray] = Integer.parseInt(text.substring(startingPoint, i));
				placeInArray++;
				startingPoint = i + 1;
			}
		}
		return result;
	}

	// This code removes all punctuation and capital letters.
	public static String[] punctuationSeperator(String text) {
		String[] plaintext = { text.toLowerCase(), text };
		plaintext[0] = simpleConverter(plaintext[0]);
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < 26; j++) {
				if (("" + text.charAt(i)).equals(ciphers[0][j])) {
					// If character is a letter, it is set to space.
					plaintext[1] = plaintext[1].substring(0, i) + " " + plaintext[1].substring(i + 1);
					break;
				}
				if (("" + text.charAt(i)).equals(ciphers[3][j])) {
					// If character is a capital letter, it is set to `.
					plaintext[1] = plaintext[1].substring(0, i) + "`" + plaintext[1].substring(i + 1);
					break;
				}
				if (("" + text.charAt(i)).equals(" ")) {
					// If character is a space, it is set to ~.
					plaintext[1] = plaintext[1].substring(0, i) + "~" + plaintext[1].substring(i + 1);
					break;
				}
			}
		}
		return plaintext;
	}

	public static String formatter(String text, String format) {
		System.out.println("CIPHER: " + text);
		for (int i = 0; i < text.length(); i++) {
			System.out.println(i + text + text.length());
			if (format.charAt(i) == '~') {
				// If the formatting has a ~, it replaces the character with a
				// space.
				text = text.substring(0, i) + " " + text.substring(i + 1);
			} else if (format.charAt(i) == '`') {
				// If the formatting has a `, it replaces the character with its
				// capital.
				text = text.substring(0, i) + ciphers[3][plaintextToNumbers("" + text.charAt(i))[0] - 1]
						+ text.substring(i + 1);
			} else if (format.charAt(i) != ' ') {
				// If the formatting isn't space, ` or ~, then it replaces it.
				text = text.substring(0, i) + format.charAt(i) + text.substring(i + 1);
			}
		}
		return text;
	}

	// The method below converts a string of text to an array of numbers. For
	// example, "hello" would translate to {8, 5, 12, 12, 15}.
	public static int[] plaintextToNumbers(String text) {

		// Sets plaintext to lowercase.
		text = text.toLowerCase();

		int[] cipherNumbers = new int[text.length()];

		// Goes through String and finds its place in the ciphers[][] array.
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < 26; j++) {
				if (("" + text.charAt(i)).equals(ciphers[0][j])) {
					// Sets cell to the number + 1, so a = 1, not 0.
					cipherNumbers[i] = j + 1;
					break;
				}
			}
		}
		// Characters that are not found are left as 0.
		return cipherNumbers;
	}

	// The method below converts an array of numbers to a string of text. For
	// example, {8, 5, 12, 12, 15} would translate to "hello".
	public static String numbersToPlaintext(int[] cipherNumbers) {
		String plaintext = "";
		// Goes through entire int[] array
		for (int i = 0; i < cipherNumbers.length; i++) {
			if (cipherNumbers[i] == 0) {
				// Zeros are interpreted as spaces.
				plaintext = plaintext + " ";
			} else {
				// Adds the corresponding letter to plaintext.
				plaintext = plaintext + ciphers[0][cipherNumbers[i] - 1];
			}
		}
		return plaintext;
	}

	// The method below rotates an array of numbers through a count of
	// (rotationNumber). For example, {8, 5, 12, 12, 15} rotated through a count
	// of 2 would become {10, 7, 14, 14, 17}.

	public static int[] rotation(String text, int rotationNumber) {
		// Turns string to lowercase letters
		int[] cipherNumbers = plaintextToNumbers(text);
		for (int i = 0; i < text.length(); i++) {
			// If the character isn't a space, it rotates the character through
			// the intended number of letters.
			if (cipherNumbers[i] != 0) {
				// They are rotated through the 26 letters i.e. % 26.
				cipherNumbers[i] = (cipherNumbers[i] + rotationNumber) % 26 + 1;
			}
		}
		return cipherNumbers;
	}

	public static String simpleConverter(String text) {
		int[] cipherNumbers = plaintextToNumbers(text);
		System.out.println("Running simple Converter");
		String output = "";
		char zero = ' ';
		int adder = -1;
		int multiplier = 1;
		int type = 0;
		String natoSpace = "";
		String cipher = selectedCipher1;
		System.out.println(selectedCipher1 + selectedCipher2);
		// Establishes what to do for each cipher
		for (int i = 0; i < 2; i++) {
			output = "";
			System.out.println(cipher);
			switch (cipher) {
			default:
				return "Haha, there's an error somewhere!";
			case "Half-reverse":
				// Shifts variables 13 places forward.
				adder = 12;
				multiplier = 1;
				type = 0;
				natoSpace = "";
				zero = ' ';
				break;
			case "Reverse":
				// Changes variables so that the character will be reversed.
				adder = 26;
				multiplier = -1;
				type = 0;
				natoSpace = "";
				zero = ' ';
				break;
			case "NATO Phonetic":
				// Switches output alphabet to be NATO Phonetic.
				adder = -1;
				multiplier = 1;
				type = 1;
				zero = '.';
				natoSpace = " ";
				break;
			case "Morse Code":
				// Switches output alphabet to be Morse Code.
				adder = -1;
				multiplier = 1;
				type = 2;
				zero = '/';
				natoSpace = "";
				break;
			case "Plaintext":
			}
			// Goes through entire int[] array
			for (int j = 0; j < cipherNumbers.length; j++) {
				if (cipherNumbers[j] == 0) {
					// Zeros are interpreted as determined above.
					output = output + zero;
				} else {
					// Adds the corresponding letter.
					System.out.println("adder: " + adder + "j: " + j + "i: " + i);
					System.out.println(
							"Adding this: " + natoSpace + ciphers[type][(multiplier * cipherNumbers[j] + adder) % 26]);
					output = output + natoSpace + ciphers[type][(multiplier * cipherNumbers[j] + adder) % 26];
					System.out.println("Output: " + output);
				}
			}
			cipher = selectedCipher2;
			System.out.println("Switching cipher...");
			cipherNumbers = plaintextToNumbers(output);
		}
		System.out.println("Output: " + output);
		return output;
	}

	public static String vatsyayana(String text, char[] decrypter) {
		String enciphered = "";
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < decrypter.length; j++) {

				// If the character is a space, it adds a space.
				if (text.charAt(i) == ' ') {
					enciphered = enciphered + " ";
					break;
				}

				// When character is found in the decrypter array
				if (text.charAt(i) == decrypter[j]) {
					// If it is the first of a pair it changes it to the next,
					// if it is the second it changes to the previous. This is
					// how the 'paired' behaviour works.
					if (j % 2 == 0) {
						enciphered = enciphered + decrypter[j + 1];
					} else {
						enciphered = enciphered + decrypter[j - 1];
					}
				}
			}
		}
		return enciphered;
	}

	public static String keywordGen(String key) {
		// Makes keyphrase lowercase and removes spaces
		key = key.toLowerCase();
		key = key.replaceAll(" ", "");

		// Records character to remove duplicates of, removes all instances of
		// it, then adds the first one back in. Does for all characters.
		for (int i = 0; i < key.length(); i++) {
			char charToReplace = key.charAt(i);
			key = key.replaceAll("" + charToReplace, "");
			key = key.substring(0, i) + charToReplace + key.substring(i);
		}

		boolean letterFound = false;
		// endOfAlphabet records where the keyword ends. This ensures rest of
		// key is generated from the last letter, not from the start of the
		// alphabet. The int is constant.
		int endOfAlphabet = plaintextToNumbers("" + key.charAt(key.length() - 1))[0];

		for (int i = endOfAlphabet; i < 26 + endOfAlphabet; i++) {
			for (int j = 0; j < key.length(); j++) {
				letterFound = ("" + key.charAt(j)).equals(ciphers[0][i % 26]);
				if (letterFound) {
					// If letter is found, it moves on to the next letter.
					break;
				}
			}
			if (!letterFound) {
				// If letter is never found, it adds it to the end.
				key = key + ciphers[0][i % 26];
			}
		}
		return key;
	}

	public static String keywordCipher(String keyword, String text) {
		int[] cipherNumbers = plaintextToNumbers(text);
		String enciphered = "";
		// Scrolls through the message and adds the corresponding letter from
		// the keyword to the final string.
		for (int i = 0; i < cipherNumbers.length; i++) {
			enciphered = enciphered + keyword.charAt((cipherNumbers[i] + 25) % 26);
		}
		return enciphered;
	}

}