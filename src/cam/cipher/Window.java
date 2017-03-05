package cam.cipher;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Window {

	static JPanel cipher, database, test, export;
	static JTextArea textArea;
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

		cipher = new JPanel();
		frame.getContentPane().add(cipher, BorderLayout.CENTER);
		database = new JPanel();
		frame.getContentPane().add(database, BorderLayout.CENTER);
		test = new JPanel();
		frame.getContentPane().add(test, BorderLayout.CENTER);
		export = new JPanel();
		frame.getContentPane().add(export, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setText("Well done!");
		textArea.setWrapStyleWord(true);
		export.add(textArea);
		
		// Initializing frames for each mode

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mntmCipher = new JMenu("Cipher");
		mntmCipher.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Methods.switchPanes("cipher");
				System.out.println("Switched to cipher");
			}

		});
		menuBar.add(mntmCipher);

		JMenu mntmDatabase = new JMenu("Database");
		mntmDatabase.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Methods.switchPanes("database");

			}

		});
		menuBar.add(mntmDatabase);

		JMenu mntmTest = new JMenu("Test");
		mntmTest.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Methods.switchPanes("test");
			}

		});
		menuBar.add(mntmTest);

		JMenu mntmExport = new JMenu("Export");
		mntmExport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Methods.switchPanes("export");
			}

		});
		menuBar.add(mntmExport);
		
		//Adding MenuItems with Listeners to change frame.

	}

}
