package cam.cipher;

public class Console {

	public static void main(String[] args) {
		Ciphers.selectedCipher1 = "Plaintext";
		Ciphers.selectedCipher2 = "Reverse";
		System.out.println("HELLO!" + Ciphers.plaintextToOutput(Ciphers.inputToPlaintext("Hello, my name is Cameron.")));

	}

}
