package cam.cipher;

public class Methods {

	public static void switchPanes(String pane) {
		boolean[] setPanes = { false, false, false, false };
		switch (pane) {
		default:
			System.err.println("Invalid String input for switchPanes");
			break;
		case "cipher":
			setPanes[0] = true;
			break;
		case "database":
			setPanes[1] = true;
			break;
		case "test":
			setPanes[2] = true;
			break;
		case "export":
			setPanes[3] = true;
		}
		Window.cipher.setVisible(setPanes[0]);
		Window.textArea.setVisible(setPanes[0]);
		Window.database.setVisible(setPanes[1]);
		Window.test.setVisible(setPanes[2]);
		Window.export.setVisible(setPanes[3]);
		
	}
}
