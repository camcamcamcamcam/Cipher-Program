package cam.cipher;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import cam.database.Ciphers;

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
		gbl_ciphers.columnWidths = new int[] { 0, 0, 0 };
		gbl_ciphers.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_ciphers.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_ciphers.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		ciphers.setLayout(gbl_ciphers);

		JComboBox ciphers_selectCipher = new JComboBox(Ciphers.namesOfCiphers);
		ciphers_selectCipher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ciphers.selectedCipher = (String) ciphers_selectCipher.getSelectedItem();
			}
		});
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

		ciphers_plaintext.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (ciphers_plaintext.isEditable()) {
					Ciphers.plaintextContents = ciphers_plaintext.getText();
					ciphers_ciphertext.setEditable(Ciphers.plaintextContents.equals(""));
				}
			}
		});
		ciphers_ciphertext.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (ciphers_ciphertext.isEditable()) {
					Ciphers.ciphertextContents = ciphers_ciphertext.getText();
					ciphers_plaintext.setEditable(Ciphers.ciphertextContents.equals(""));
				}
			}
		});

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

		JButton btnGo = new JButton("Go!");
		btnGo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (ciphers_plaintext.isEditable()) {
					Ciphers.plaintextContents = ciphers_plaintext.getText();
				}
				if (ciphers_ciphertext.isEditable()) {
					Ciphers.ciphertextContents = ciphers_ciphertext.getText();
				}
				if (Ciphers.ciphertextContents.equals("") && Ciphers.plaintextContents.equals("")) {
					JOptionPane.showMessageDialog(frame, "Type something in one of the text boxes.",
							"Well, that was easy", JOptionPane.ERROR_MESSAGE);
				}
				// If there is text in the plaintext box

				else if (Ciphers.ciphertextContents.equals("")) {
					switch (Ciphers.selectedCipher) {
					case "Detect":
						break;
					case "Number":
						String ciphertext = "";
						for (int i = 0; i < Ciphers.plaintextToNumbers(Ciphers.plaintextContents).length; i++) {
							ciphertext = ciphertext + Ciphers.plaintextToNumbers(Ciphers.plaintextContents)[i] + "/";
						}
						ciphers_ciphertext.setText(ciphertext);
						break;
					case "Rotational":
						ciphers_ciphertext
								.setText(Ciphers
										.formatter(
												Ciphers.numbersToPlaintext(Ciphers.rotation(
														Ciphers.punctuationSeperator(Ciphers.plaintextContents)[0],
														Integer.parseInt(
																JOptionPane.showInputDialog(frame, "What rotation?"))
																- 1)),
												Ciphers.punctuationSeperator(Ciphers.plaintextContents)[1]));

						break;
					case "Reverse":
						ciphers_ciphertext.setText(Ciphers.formatter(
								Ciphers.numbersToReverse(Ciphers.plaintextToNumbers(
										Ciphers.punctuationSeperator(Ciphers.plaintextContents)[0])),
								Ciphers.punctuationSeperator(Ciphers.plaintextContents)[1]));
						break;
					case "Half-reverse":
						ciphers_ciphertext.setText(Ciphers.formatter(
								Ciphers.halfReverse(Ciphers.punctuationSeperator(Ciphers.plaintextContents)[0]),
								Ciphers.punctuationSeperator(Ciphers.plaintextContents)[1]));
						break;
					case "NATO Phonetic":
						ciphers_ciphertext.setText(Ciphers.numbersToPhonetic(Ciphers
								.plaintextToNumbers(Ciphers.punctuationSeperator(Ciphers.plaintextContents)[0])));
						break;
					case "Morse Code":
						ciphers_ciphertext.setText(Ciphers.numbersToMorseCode(Ciphers
								.plaintextToNumbers(Ciphers.punctuationSeperator(Ciphers.plaintextContents)[0])));
						break;
					case "Vatsyayana":
						ciphers_ciphertext.setText(Ciphers.formatter(
								Ciphers.vatsyayana(Ciphers.punctuationSeperator(Ciphers.plaintextContents)[0],
										JOptionPane.showInputDialog(frame, "Type the order of your paired letters")
												.toCharArray()),
								Ciphers.punctuationSeperator(Ciphers.plaintextContents)[1]));
						break;
					case "Keyword":
						System.out.println(Ciphers.keywordGen("Rhubarb Stewed"));
						ciphers_ciphertext
								.setText(
										Ciphers.formatter(
												Ciphers.keywordCipher(
														Ciphers.keywordGen(Ciphers.punctuationSeperator(JOptionPane
																.showInputDialog(frame, "Type your keyword."))[0]),
														Ciphers.plaintextContents),
												Ciphers.punctuationSeperator(Ciphers.plaintextContents)[1]));
						break;
					case "Vigenere":
						break;
					case "Enigma":
					}
				}
			}
		});
		GridBagConstraints gbc_btnGo = new GridBagConstraints();
		gbc_btnGo.insets = new Insets(0, 0, 5, 0);
		gbc_btnGo.gridx = 1;
		gbc_btnGo.gridy = 0;
		ciphers.add(btnGo, gbc_btnGo);
		JPanel database = new JPanel();
		menu.addTab("Database", null, database, null);
		GridBagLayout gbl_database = new GridBagLayout();
		gbl_database.columnWidths = new int[] { 0, 0, 0 };
		gbl_database.rowHeights = new int[] { 0, 0, 0 };
		gbl_database.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_database.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
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
