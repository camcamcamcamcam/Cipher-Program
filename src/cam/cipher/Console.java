package cam.cipher;

public class Console {

	public static void main(String[] args) {
		Ciphers.selectedCipher1 = "Plaintext";
		Ciphers.selectedCipher2 = "Half-reverse";
		System.out.println("HELLO!" + Ciphers.simpleConverter("Hello, my name is Cameron."));

	}

}
