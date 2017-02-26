package cam.cipher;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;

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

		JPanel cipher = new JPanel();
		frame.getContentPane().add(cipher, BorderLayout.CENTER);
		JPanel database = new JPanel();
		frame.getContentPane().add(database, BorderLayout.CENTER);
		JPanel test = new JPanel();
		frame.getContentPane().add(test, BorderLayout.CENTER);
		JPanel export = new JPanel();
		frame.getContentPane().add(export, BorderLayout.CENTER);
		
		// Initializing frames for each mode

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mntmCipher = new JMenu("Cipher");
		mntmCipher.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				export.setVisible(true);
				database.setVisible(false);
				test.setVisible(false);
				export.setVisible(false);

			}

		});
		menuBar.add(mntmCipher);

		JMenu mntmDatabase = new JMenu("Database");
		mntmDatabase.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				export.setVisible(false);
				database.setVisible(true);
				test.setVisible(false);
				export.setVisible(false);

			}

		});
		menuBar.add(mntmDatabase);

		JMenu mntmTest = new JMenu("Test");
		mntmTest.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				export.setVisible(false);
				database.setVisible(false);
				test.setVisible(true);
				export.setVisible(false);

			}

		});
		menuBar.add(mntmTest);

		JMenu mntmExport = new JMenu("Export");
		mntmExport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				export.setVisible(false);
				database.setVisible(false);
				test.setVisible(false);
				export.setVisible(true);

			}

		});
		menuBar.add(mntmExport);
		
		//Adding MenuItems with Listeners to change frame.

	}

}
