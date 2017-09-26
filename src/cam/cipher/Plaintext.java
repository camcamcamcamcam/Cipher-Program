package cam.cipher;

public class Plaintext {
	
	private String text;
	private String format;
	
	public Plaintext(String text, String format) {
		
		this.text = text;
		this.format = format;
		
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
