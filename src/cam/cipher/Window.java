package cam.cipher;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
					window.frame.setExtendedState(window.frame.getExtendedState() | Frame.MAXIMIZED_BOTH);
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
		FlowLayout ciphers_flowLayout = (FlowLayout) ciphers.getLayout();
		menu.addTab("Ciphers", null, ciphers, null);
		
		JPanel database = new JPanel();
		FlowLayout database_flowLayout = (FlowLayout) database.getLayout();
		menu.addTab("Database", null, database, null);
		
		JPanel test = new JPanel();
		FlowLayout test_flowLayout = (FlowLayout) test.getLayout();
		menu.addTab("Test", null, test, null);
		
		JPanel export = new JPanel();
		FlowLayout export_flowLayout = (FlowLayout) export.getLayout();
		menu.addTab("Export", null, export, null);
	}

}
