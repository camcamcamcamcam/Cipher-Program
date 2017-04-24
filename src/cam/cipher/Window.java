package cam.cipher;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import cam.database.Ciphers;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;

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
		menu.addTab("Ciphers", null, ciphers, null);
		GridBagLayout gbl_ciphers = new GridBagLayout();
		gbl_ciphers.columnWidths = new int[]{0, 0, 0};
		gbl_ciphers.rowHeights = new int[]{0, 0, 0, 0};
		gbl_ciphers.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_ciphers.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		ciphers.setLayout(gbl_ciphers);
		
		JComboBox ciphers_selectCipher = new JComboBox(Ciphers.namesOfCiphers);
		GridBagConstraints gbc_ciphers_selectCipher = new GridBagConstraints();
		gbc_ciphers_selectCipher.insets = new Insets(0, 0, 5, 5);
		gbc_ciphers_selectCipher.fill = GridBagConstraints.HORIZONTAL;
		gbc_ciphers_selectCipher.gridx = 0;
		gbc_ciphers_selectCipher.gridy = 0;
		ciphers.add(ciphers_selectCipher, gbc_ciphers_selectCipher);
		
		JTextArea ciphers_ciphertext = new JTextArea();
		GridBagConstraints gbc_ciphers_ciphertext = new GridBagConstraints();
		gbc_ciphers_ciphertext.insets = new Insets(0, 0, 5, 5);
		gbc_ciphers_ciphertext.fill = GridBagConstraints.BOTH;
		gbc_ciphers_ciphertext.gridx = 0;
		gbc_ciphers_ciphertext.gridy = 1;
		ciphers.add(ciphers_ciphertext, gbc_ciphers_ciphertext);
		
		JTextArea ciphers_plaintext = new JTextArea();
		GridBagConstraints gbc_ciphers_plaintext = new GridBagConstraints();
		gbc_ciphers_plaintext.insets = new Insets(0, 0, 5, 0);
		gbc_ciphers_plaintext.fill = GridBagConstraints.BOTH;
		gbc_ciphers_plaintext.gridx = 1;
		gbc_ciphers_plaintext.gridy = 1;
		ciphers.add(ciphers_plaintext, gbc_ciphers_plaintext);
		
		JLabel ciphers_LabelCiphertext = new JLabel("Ciphertext");
		GridBagConstraints gbc_ciphers_LabelCiphertext = new GridBagConstraints();
		gbc_ciphers_LabelCiphertext.insets = new Insets(0, 0, 0, 5);
		gbc_ciphers_LabelCiphertext.gridx = 0;
		gbc_ciphers_LabelCiphertext.gridy = 2;
		ciphers.add(ciphers_LabelCiphertext, gbc_ciphers_LabelCiphertext);
		
		JLabel ciphers_LabelPlaintext = new JLabel("Plaintext");
		GridBagConstraints gbc_ciphers_LabelPlaintext = new GridBagConstraints();
		gbc_ciphers_LabelPlaintext.gridx = 1;
		gbc_ciphers_LabelPlaintext.gridy = 2;
		ciphers.add(ciphers_LabelPlaintext, gbc_ciphers_LabelPlaintext);
		
		JPanel database = new JPanel();
		menu.addTab("Database", null, database, null);
		GridBagLayout gbl_database = new GridBagLayout();
		gbl_database.columnWidths = new int[]{0, 0, 0};
		gbl_database.rowHeights = new int[]{0, 0, 0};
		gbl_database.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_database.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		database.setLayout(gbl_database);
		
		JComboBox database_selectCiphers = new JComboBox(Ciphers.namesOfCiphers);
		GridBagConstraints gbc_database_selectCiphers = new GridBagConstraints();
		gbc_database_selectCiphers.insets = new Insets(0, 0, 5, 0);
		gbc_database_selectCiphers.fill = GridBagConstraints.HORIZONTAL;
		gbc_database_selectCiphers.gridx = 1;
		gbc_database_selectCiphers.gridy = 0;
		database.add(database_selectCiphers, gbc_database_selectCiphers);
		
		JTextArea database_history = new JTextArea();
		database_history.setEditable(false);
		GridBagConstraints gbc_database_history = new GridBagConstraints();
		gbc_database_history.insets = new Insets(0, 0, 0, 5);
		gbc_database_history.fill = GridBagConstraints.BOTH;
		gbc_database_history.gridx = 0;
		gbc_database_history.gridy = 1;
		database.add(database_history, gbc_database_history);
		
		JTextArea database_howTo = new JTextArea();
		database_howTo.setEditable(false);
		GridBagConstraints gbc_database_howTo = new GridBagConstraints();
		gbc_database_howTo.fill = GridBagConstraints.BOTH;
		gbc_database_howTo.gridx = 1;
		gbc_database_howTo.gridy = 1;
		database.add(database_howTo, gbc_database_howTo);
		
		JPanel test = new JPanel();
		FlowLayout test_flowLayout = (FlowLayout) test.getLayout();
		menu.addTab("Test", null, test, null);
		
		JPanel export = new JPanel();
		FlowLayout export_flowLayout = (FlowLayout) export.getLayout();
		menu.addTab("Export", null, export, null);
	}

}
