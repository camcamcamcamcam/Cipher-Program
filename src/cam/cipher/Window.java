package cam.cipher;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.FlowLayout;

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
		
		JTabbedPane menu = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(menu, BorderLayout.CENTER);
		
		JPanel ciphers = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) ciphers.getLayout();
		menu.addTab("Ciphers", null, ciphers, null);
		
		JPanel database = new JPanel();
		FlowLayout flowLayout = (FlowLayout) database.getLayout();
		menu.addTab("Database", null, database, null);
		
		JPanel test = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) test.getLayout();
		menu.addTab("Test", null, test, null);
		
		JPanel export = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) export.getLayout();
		menu.addTab("Export", null, export, null);
	}

}
