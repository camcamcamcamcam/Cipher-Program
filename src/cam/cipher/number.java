package cam.cipher;

public class number {

	public static void main(String[] args) {
		while (true) {
			String s = IBIO.inputString("Hello");
			boolean b;
			String c;
			for (int i = 0; i < s.length(); i++) {
				b = false;
				try {
					Integer.parseInt("" + s.charAt(i));
				} catch (NumberFormatException e) {
					b = true;
					System.out.println("not a number");
				}
				if (s.charAt(i) == '%') {
					s = s.substring(0, i) + " per cent " + s.substring(i + 1, s.length());
				}
				if (!b) {
					switch (s.charAt(i)) {
					default:
						c = "";
						System.out.println("argh");
					case '0':
						c = "zero ";
						break;
					case '1':
						c = "one ";
						break;
					case '2':
						c = "two ";
						break;
					case '3':
						c = "three ";
						break;
					case '4':
						c = "four ";
						break;
					case '5':
						c = "five ";
						break;
					case '6':
						c = "six ";
						break;
					case '7':
						c = "seven ";
						break;
					case '8':
						c = "eight ";
						break;
					case '9':
						c = "nine ";
						break;

					}
					System.out.println("c: " + c);
					s = s.substring(0, i) + c + s.substring(i + 1, s.length());
				}
			}
			System.out.println(s);
		}
		
	}
}
