package cam.cipher;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Window {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
					window.frame.setExtendedState(window.frame.getExtendedState() | window.frame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JTabbedPane ciphers = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Ciphers", null, ciphers, null);
		
		JTabbedPane database = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Database", null, database, null);
		
		JTabbedPane test = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Test", null, test, null);
		
		JTabbedPane export = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Export", null, export, null);
	}

}
