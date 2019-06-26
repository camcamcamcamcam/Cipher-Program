package cam.cipher;

public class Plaintext {

	private String text;
	private String format;

	public Plaintext(String text, String format) {

		this.text = text;
		this.format = format;

	}

	// This code removes all punctuation and capital letters.
	public Plaintext(String text) {
		this.text = text.toLowerCase();
		String format = "";
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < 26; j++) {
				if (("" + text.charAt(i)).equals(Ciphers.ciphers[0][j])) {
					// If character is a letter, it is set to space.
					format = format.substring(0, i) + " " + format.substring(i + 1);
					break;
				}
				if (("" + text.charAt(i)).equals(Ciphers.ciphers[3][j])) {
					// If character is a capital letter, it is set to `.
					format = format.substring(0, i) + "`" + format.substring(i + 1);
					break;
				}
				if (("" + text.charAt(i)).equals(" ")) {
					// If character is a space, it is set to ~.
					format = format.substring(0, i) + "~" + format.substring(i + 1);
					break;
				}
			}
		}
		this.format = format;
	}

	public String toString() {
		for (int i = 0; i < text.length(); i++) {
			if (format.charAt(i) == '~') {
				// If the formatting has a ~, it replaces the character with a
				// space.
				text = text.substring(0, i) + " " + text.substring(i + 1);
			} else if (format.charAt(i) == '`') {
				// If the formatting has a `, it replaces the character with its
				// capital.
				String temp = Ciphers.selectedCipher1;
				Ciphers.selectedCipher1 = "Plaintext";
				text = text.substring(0, i)
						+ Ciphers.ciphers[3][(Ciphers.inputToPlaintext("" + text.charAt(i))[0] + 25) % 26]
						+ text.substring(i + 1);
				Ciphers.selectedCipher1 = temp;
			} else if (format.charAt(i) != ' ') {
				// If the formatting isn't space, ` or ~, then it replaces it.
				text = text.substring(0, i) + format.charAt(i) + text.substring(i + 1);
			}
		}
		return text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
}