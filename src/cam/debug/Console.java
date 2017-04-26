package cam.debug;

import cam.database.Ciphers;

public class Console {
	public static void main(String args[]) {
		while (true) {
			String input = IBIO.input("Plaintext:");
			switch (IBIO.inputInt(
					"1: Number cipher, 2: Rotational cipher, 3: Reverse cipher, 4: Half-reverse cipher, 5: NATO Phonetic Alphabet, 6, Morse Code, 7: Vatsyayana Cipher, 8: Keyword Cipher, 9: Vigenere Cipher, 10: Enigma, 11: Formatter.")) {
			default:
				System.err.println("Invalid selection");
				break;
			case 1:
				for (int i = 0; i < Ciphers.plaintextToNumbers(input).length; i++) {
					System.out.print(Ciphers.plaintextToNumbers(input)[i] + "/");
				}
				break;
			case 2:
				for (int i = 0; i < 27; i++) {
					System.out.println(Ciphers.simpleConverter(Ciphers.rotation(input, i), "Plaintext"));
					System.out.println(Ciphers.formatter(
							Ciphers.simpleConverter(Ciphers.rotation(Ciphers.punctuationSeperator(input)[0], i), "Plaintext"),
							Ciphers.punctuationSeperator(input)[1]));
				}
				break;
			case 3:
				System.out.println(Ciphers.simpleConverter(Ciphers.plaintextToNumbers(input), "Reverse"));
				break;
			case 4:
				System.out.println(Ciphers.simpleConverter(Ciphers.plaintextToNumbers(input), "Half-Reverse"));
				break;
			case 5:
				System.out.println(Ciphers.simpleConverter(Ciphers.plaintextToNumbers(input), "NATO Phonetic"));
				break;
			case 6:
				System.out.println(Ciphers.simpleConverter(Ciphers.plaintextToNumbers(input), "Morse Code"));
				break;
			case 7:
				char[] key = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
						's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
				System.out.println(Ciphers.vatsyayana(input, key));
				break;
			case 8:
				System.out.println(Ciphers.keywordGen(input));
				System.out.println(Ciphers.keywordCipher(Ciphers.keywordGen(input), IBIO.input("Message")));
				break;
			case 11:
				System.out.println(Ciphers.punctuationSeperator(input)[0]);
				System.out.println(Ciphers.formatter(Ciphers.punctuationSeperator(input)[0],
						Ciphers.punctuationSeperator(input)[1]));
			}

		}
	}
}