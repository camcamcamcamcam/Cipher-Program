package cam.debug;

import cam.database.Ciphers;

public class Console {
	public static void main(String args[]) {
		while (true) {
			String input = IBIO.input("Plaintext:");
			switch (IBIO.inputInt(
					"1: Number cipher, 2: Rotational cipher, 3: Reverse cipher, 4: Half-reverse cipher, 5: NATO Phonetic Alphabet, 6, Morse Code, 7: Vatsyayana Cipher, 8: Keyword Cipher, 9: Vigenere Cipher, 10: Enigma.")) {
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
					System.out.println(Ciphers.numbersToPlaintext(Ciphers.rotation(input, i)));
				}
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				for (int i = 0; i < 27; i++) {
					System.out.println(Ciphers.numbersToPhonetic(Ciphers.rotation(input, i)));
				}
				break;
			case 6:
				for (int i = 0; i < 27; i++) {
					System.out.println(Ciphers.numbersToMorseCode(Ciphers.rotation(input, i)));
				}
				break;
			case 7:
				char[] key = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
						's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
				System.out.println(Ciphers.vatsyayana(input, key));
			}

		}
	}
}