package cam.cipher;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
	
	JComboBox ciphers_selectCipher1, ciphers_selectcipher2;
	JTextArea ciphers_ciphertext, ciphers_plaintext;

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

		ciphers_selectCipher1 = new JComboBox(Ciphers.namesOfCiphers);
		ciphers_selectCipher1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ciphers.selectedCipher = (String) ciphers_selectCipher1.getSelectedItem();
			}
		});
		GridBagConstraints gbc_ciphers_selectCipher = new GridBagConstraints();
		gbc_ciphers_selectCipher.insets = new Insets(0, 0, 5, 5);
		gbc_ciphers_selectCipher.fill = GridBagConstraints.HORIZONTAL;
		gbc_ciphers_selectCipher.gridx = 0;
		gbc_ciphers_selectCipher.gridy = 0;
		ciphers.add(ciphers_selectCipher1, gbc_ciphers_selectCipher);
		
		ciphers_selectcipher2 = new JComboBox(Ciphers.namesOfCiphers);
		GridBagConstraints gbc_ciphers_selectcipher2 = new GridBagConstraints();
		gbc_ciphers_selectcipher2.insets = new Insets(0, 0, 5, 0);
		gbc_ciphers_selectcipher2.fill = GridBagConstraints.HORIZONTAL;
		gbc_ciphers_selectcipher2.gridx = 1;
		gbc_ciphers_selectcipher2.gridy = 0;
		ciphers.add(ciphers_selectcipher2, gbc_ciphers_selectcipher2);

		ciphers_ciphertext = new JTextArea();
		ciphers_ciphertext.setLineWrap(true);
		ciphers_ciphertext.setWrapStyleWord(true);
		GridBagConstraints gbc_ciphers_ciphertext = new GridBagConstraints();
		gbc_ciphers_ciphertext.insets = new Insets(0, 0, 5, 5);
		gbc_ciphers_ciphertext.fill = GridBagConstraints.BOTH;
		gbc_ciphers_ciphertext.gridx = 0;
		gbc_ciphers_ciphertext.gridy = 1;
		ciphers.add(ciphers_ciphertext, gbc_ciphers_ciphertext);

		ciphers_plaintext = new JTextArea();
		ciphers_plaintext.setLineWrap(true);
		ciphers_plaintext.setWrapStyleWord(true);
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

		JPanel database = new JPanel();
		menu.addTab("Database", null, database, null);
		GridBagLayout gbl_database = new GridBagLayout();
		gbl_database.columnWidths = new int[] { 0, 0, 0 };
		gbl_database.rowHeights = new int[] { 0, 0, 0 };
		gbl_database.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_database.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		database.setLayout(gbl_database);

		JTextArea database_history = new JTextArea();
		database_history.setText(Ciphers.cipherInfo[0][1]);
		database_history.setLineWrap(true);
		database_history.setWrapStyleWord(true);
		database_history.setEditable(false);
		GridBagConstraints gbc_database_history = new GridBagConstraints();
		gbc_database_history.insets = new Insets(0, 0, 0, 5);
		gbc_database_history.fill = GridBagConstraints.BOTH;
		gbc_database_history.gridx = 0;
		gbc_database_history.gridy = 1;
		database.add(database_history, gbc_database_history);

		JTextArea database_howTo = new JTextArea();
		database_howTo.setText(Ciphers.cipherInfo[0][2]);
		database_howTo.setLineWrap(true);
		database_howTo.setWrapStyleWord(true);
		database_howTo.setEditable(false);
		GridBagConstraints gbc_database_howTo = new GridBagConstraints();
		gbc_database_howTo.fill = GridBagConstraints.BOTH;
		gbc_database_howTo.gridx = 1;
		gbc_database_howTo.gridy = 1;
		database.add(database_howTo, gbc_database_howTo);

		JComboBox database_selectCiphers = new JComboBox(Ciphers.namesOfCiphers);
		database_selectCiphers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int cipherNumber = 0;
				switch ((String) database_selectCiphers.getSelectedItem()) {
				case "Plaintext":
					cipherNumber = 0;
					break;
				case "Number":
					cipherNumber = 1;
					break;
				case "Rotational":
					cipherNumber = 2;
					break;
				case "Reverse":
					cipherNumber = 3;
					break;
				case "Half-reverse":
					cipherNumber = 4;
					break;
				case "NATO Phonetic":
					cipherNumber = 5;
					break;
				case "Morse Code":
					cipherNumber = 6;
					break;
				case "Vatsyayana":
					cipherNumber = 7;
					break;
				case "Keyword":
					cipherNumber = 8;
					break;
				case "Vigenere":
					cipherNumber = 9;
					break;
				case "Enigma":
					cipherNumber = 10;
				}
				database_howTo.setText(Ciphers.cipherInfo[cipherNumber][1]);
				database_history.setText(Ciphers.cipherInfo[cipherNumber][2]);
			}

		});
		GridBagConstraints gbc_database_selectCiphers = new GridBagConstraints();
		gbc_database_selectCiphers.insets = new Insets(0, 0, 5, 0);
		gbc_database_selectCiphers.fill = GridBagConstraints.HORIZONTAL;
		gbc_database_selectCiphers.gridx = 1;
		gbc_database_selectCiphers.gridy = 0;
		database.add(database_selectCiphers, gbc_database_selectCiphers);
		JPanel test = new JPanel();
		menu.addTab("Test", null, test, null);

		JPanel export = new JPanel();
		menu.addTab("Export", null, export, null);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == ciphers_selectCipher1){
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
				default:
					// If it is Reverse, Half-reverse, NATO Phonetic or
					// Morse Code.
					if (Ciphers.selectedCipher.equals("Reverse") || Ciphers.selectedCipher.equals("Half-reverse")) {
						ciphers_ciphertext.setText(Ciphers.formatter(
								Ciphers.simpleConverter(
										Ciphers.plaintextToNumbers(
												Ciphers.punctuationSeperator(Ciphers.plaintextContents)[0]),
										Ciphers.selectedCipher),
								Ciphers.punctuationSeperator(Ciphers.plaintextContents)[1]));
					} else {
						ciphers_ciphertext.setText(Ciphers.simpleConverter(
								Ciphers.plaintextToNumbers(
										Ciphers.punctuationSeperator(Ciphers.plaintextContents)[0]),
								Ciphers.selectedCipher));
					}

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
											Ciphers.simpleConverter(Ciphers.rotation(
													Ciphers.punctuationSeperator(Ciphers.plaintextContents)[0],
													Integer.parseInt(
															JOptionPane.showInputDialog(frame, "What rotation?"))
															- 1),
													"Plaintext"),
											Ciphers.punctuationSeperator(Ciphers.plaintextContents)[1]));

					break;
				case "Vatsyayana":
					ciphers_ciphertext.setText(Ciphers.formatter(
							Ciphers.vatsyayana(Ciphers.punctuationSeperator(Ciphers.plaintextContents)[0],
									JOptionPane.showInputDialog(frame, "Type the order of your paired letters")
											.toCharArray()),
							Ciphers.punctuationSeperator(Ciphers.plaintextContents)[1]));
					break;
				case "Keyword":
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
				// If there is text in the ciphertext box
			} else {
				switch (Ciphers.selectedCipher) {
				default:
					// If it is Reverse or Half-reverse
					if (Ciphers.selectedCipher.equals("Reverse") || Ciphers.selectedCipher.equals("Half-reverse")) {
						ciphers_plaintext
								.setText(
										Ciphers.formatter(
												Ciphers.simpleConverter(
														Ciphers.plaintextToNumbers(Ciphers.punctuationSeperator(
																Ciphers.ciphertextContents)[0]),
														Ciphers.selectedCipher),
												Ciphers.punctuationSeperator(Ciphers.ciphertextContents)[1]));
					} else {
						ciphers_plaintext.setText(Ciphers.simpleConverter(
								Ciphers.plaintextToNumbers(
										Ciphers.punctuationSeperator(Ciphers.ciphertextContents)[0]),
								Ciphers.selectedCipher));
					}
				case "Detect":
					break;
				case "Number":
					ciphers_plaintext.setText(Ciphers
							.simpleConverter(Ciphers.intCaster(Ciphers.ciphertextContents), "Plaintext").trim());
					break;
				case "Rotational":
					// TODO will need to add dictionary.
					break;
				case "Vatsyayana":
					break;
				case "Keyword":
					break;
				case "Vigenere":
					break;
				case "Enigma":
				}
			}
		}
		}
	}

