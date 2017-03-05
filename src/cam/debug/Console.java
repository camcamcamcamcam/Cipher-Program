package cam.debug;

import cam.database.Ciphers;

public class Console {
	public static void main(String args) {
		System.out.println("hello");
		for (int i = 0; i < 5; i++){
			System.out.println(Ciphers.cipherNumbers("hello")[i]);
		}
	}
}
