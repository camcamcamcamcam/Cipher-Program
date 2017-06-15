package cam.cipher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Window extends JFrame implements ActionListener {

	private static final long serialVersionUID = 5081443868281354460L;
	static JComboBox<?> ciphers_selectCipher1, ciphers_selectCipher2;
	JTextArea input, output, inputForUser, outputFromUser;
	JLabel instructions, timer, correct;
	JButton startButton;

	static JFrame frame;

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

	public Window() {
		initialize();
	}

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
		ciphers_selectCipher1.addActionListener(this);
		GridBagConstraints gbc_ciphers_selectCipher = new GridBagConstraints();
		gbc_ciphers_selectCipher.insets = new Insets(0, 0, 5, 5);
		gbc_ciphers_selectCipher.fill = GridBagConstraints.HORIZONTAL;
		gbc_ciphers_selectCipher.gridx = 0;
		gbc_ciphers_selectCipher.gridy = 0;
		ciphers.add(ciphers_selectCipher1, gbc_ciphers_selectCipher);

		ciphers_selectCipher2 = new JComboBox(Ciphers.namesOfCiphers);
		ciphers_selectCipher2.addActionListener(this);
		GridBagConstraints gbc_ciphers_selectcipher2 = new GridBagConstraints();
		gbc_ciphers_selectcipher2.insets = new Insets(0, 0, 5, 0);
		gbc_ciphers_selectcipher2.fill = GridBagConstraints.HORIZONTAL;
		gbc_ciphers_selectcipher2.gridx = 1;
		gbc_ciphers_selectcipher2.gridy = 0;
		ciphers.add(ciphers_selectCipher2, gbc_ciphers_selectcipher2);

		input = new JTextArea();
		input.setLineWrap(true);
		input.setWrapStyleWord(true);
		GridBagConstraints gbc_input = new GridBagConstraints();
		gbc_input.insets = new Insets(0, 0, 5, 5);
		gbc_input.fill = GridBagConstraints.BOTH;
		gbc_input.gridx = 0;
		gbc_input.gridy = 1;
		ciphers.add(input, gbc_input);

		output = new JTextArea();
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		output.setEditable(false);
		GridBagConstraints gbc_output = new GridBagConstraints();
		gbc_output.insets = new Insets(0, 0, 5, 0);
		gbc_output.fill = GridBagConstraints.BOTH;
		gbc_output.gridx = 1;
		gbc_output.gridy = 1;
		ciphers.add(output, gbc_output);

		JLabel lblInput = new JLabel("Input");
		GridBagConstraints gbc_lblInput = new GridBagConstraints();
		gbc_lblInput.insets = new Insets(0, 0, 0, 5);
		gbc_lblInput.gridx = 0;
		gbc_lblInput.gridy = 2;
		ciphers.add(lblInput, gbc_lblInput);

		JLabel lblOutput = new JLabel("Output");
		GridBagConstraints gbc_lblOutput = new GridBagConstraints();
		gbc_lblOutput.gridx = 1;
		gbc_lblOutput.gridy = 2;
		ciphers.add(lblOutput, gbc_lblOutput);

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
		GridBagLayout gbl_test = new GridBagLayout();
		gbl_test.columnWidths = new int[] { 0, 0, 0 };
		gbl_test.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_test.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_test.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		test.setLayout(gbl_test);

		instructions = new JLabel("Press Start to start the test.");
		GridBagConstraints gbc_instructions = new GridBagConstraints();
		gbc_instructions.insets = new Insets(0, 0, 5, 5);
		gbc_instructions.gridx = 0;
		gbc_instructions.gridy = 0;
		test.add(instructions, gbc_instructions);

		startButton = new JButton("Start");
		startButton.addActionListener(this);
		GridBagConstraints gbc_testButton = new GridBagConstraints();
		gbc_testButton.fill = GridBagConstraints.BOTH;
		gbc_testButton.insets = new Insets(0, 0, 5, 0);
		gbc_testButton.gridx = 1;
		gbc_testButton.gridy = 0;
		test.add(startButton, gbc_testButton);

		inputForUser = new JTextArea();
		inputForUser.setWrapStyleWord(true);
		inputForUser.setLineWrap(true);
		inputForUser.setEditable(false);
		GridBagConstraints gbc_inputForUser = new GridBagConstraints();
		gbc_inputForUser.insets = new Insets(0, 0, 5, 5);
		gbc_inputForUser.fill = GridBagConstraints.BOTH;
		gbc_inputForUser.gridx = 0;
		gbc_inputForUser.gridy = 1;
		test.add(inputForUser, gbc_inputForUser);

		outputFromUser = new JTextArea();
		outputFromUser.setWrapStyleWord(true);
		outputFromUser.setLineWrap(true);
		GridBagConstraints gbc_outputFromUser = new GridBagConstraints();
		gbc_outputFromUser.insets = new Insets(0, 0, 5, 0);
		gbc_outputFromUser.fill = GridBagConstraints.BOTH;
		gbc_outputFromUser.gridx = 1;
		gbc_outputFromUser.gridy = 1;
		test.add(outputFromUser, gbc_outputFromUser);

		timer = new JLabel("");
		GridBagConstraints gbc_timer = new GridBagConstraints();
		gbc_timer.insets = new Insets(0, 0, 0, 5);
		gbc_timer.gridx = 0;
		gbc_timer.gridy = 2;
		test.add(timer, gbc_timer);

		correct = new JLabel("");
		GridBagConstraints gbc_correct = new GridBagConstraints();
		gbc_correct.gridx = 1;
		gbc_correct.gridy = 2;
		test.add(correct, gbc_correct);

		JPanel export = new JPanel();
		menu.addTab("Export", null, export, null);
	}

	public String performCiphering(String local_selectCipher1, String local_selectCipher2, String local_input) {
		// Fetches selected ciphers and text entered.
		Ciphers.selectedCipher1 = local_selectCipher1;
		Ciphers.selectedCipher2 = local_selectCipher2;
		Ciphers.textContents = local_input;
		Ciphers.plaintextContents = new int[Ciphers.textContents.length()];

		boolean simpleCipher = false;

		// Converts to plaintext.
		switch (Ciphers.selectedCipher1) {
		default:
			// Default is used for plaintext, reverse, half-reverse and
			// rotational.
			Ciphers.plaintextContents = Ciphers.inputToPlaintext(Ciphers.punctuationSeperator(Ciphers.textContents)[0]);
			break;
		case "Number":
			System.out.println(Ciphers.textContents.charAt(0));
			try {
				Integer.parseInt("" + Ciphers.textContents.charAt(0));
			} catch (NumberFormatException e) {
				System.out.println("Exception");
				Ciphers.textContents = Ciphers.textContents.substring(1);
			}
			try {
				Integer.parseInt("" + Ciphers.textContents.charAt(Ciphers.textContents.length() - 1));
			} catch (NumberFormatException e) {
				System.out.println("Exception");
				Ciphers.textContents = Ciphers.textContents.substring(0, Ciphers.textContents.length() - 1);
			}
			System.out.println(Ciphers.textContents);
			if (Ciphers.textContents.charAt(Ciphers.textContents.length() - 1) != '/') {
				Ciphers.textContents += "/";
			}
			simpleCipher = true;
			break;
		case "NATO Phonetic":
			if (Ciphers.textContents.charAt(0) != ' ') {
				Ciphers.textContents = " " + Ciphers.textContents;
			}
		case "Morse Code":
			simpleCipher = true;
			break;
		case "Vatsyayana":
			Ciphers.plaintextContents = Ciphers
					.inputToPlaintext(Ciphers.vatsyayana(Ciphers.punctuationSeperator(Ciphers.textContents)[0],
							JOptionPane
									.showInputDialog(frame,
											"Type the order of the paired letters used in enciphering this message")
									.toCharArray()));
			break;
		case "Keyword":
			Ciphers.plaintextContents = Ciphers.inputToPlaintext(Ciphers.keywordCipher(
					Ciphers.keyReversal(Ciphers.keywordGen(JOptionPane.showInputDialog(frame,
							"Type the keyword that was used to encipher this message."))),
					Ciphers.punctuationSeperator(Ciphers.textContents)[0]));
			break;
		case "Vigenere":
			Ciphers.plaintextContents = Ciphers.inputToPlaintext(Ciphers.vigenere(
					JOptionPane.showInputDialog(frame, "Type the passphrase that was used to encipher this message."),
					Ciphers.punctuationSeperator(Ciphers.textContents)[0], false));
		}
		if (simpleCipher) {
			// Used for Morse Code, NATO Phonetic and Number.
			Ciphers.plaintextContents = Ciphers.caster(Ciphers.textContents);
		}
		switch (Ciphers.selectedCipher2) {
		default:
			// default is for Reverse, Half Reverse, Rotational, and
			// Plaintext.
			if (simpleCipher) {
				return Ciphers.plaintextToOutput(Ciphers.plaintextContents).trim();
			} else {
				return Ciphers.formatter(Ciphers.plaintextToOutput(Ciphers.plaintextContents),
						Ciphers.punctuationSeperator(Ciphers.textContents)[1]);
			}
		case "Number":
			String ciphertext = "";
			for (int i = 0; i < Ciphers.plaintextContents.length; i++) {
				// Switches the 'z's and ' 's to the numbers recognised by a
				// user.
				if (Ciphers.plaintextContents[i] == 0) {
					Ciphers.plaintextContents[i] = 26;
				}
				if (Ciphers.plaintextContents[i] == -1) {
					Ciphers.plaintextContents[i] = 0;
				}
				ciphertext = ciphertext + Ciphers.plaintextContents[i] + "/";
			}
			while (ciphertext.substring(ciphertext.length() - 3, ciphertext.length()).equals("-1/")) {
				// Removes all unnecessary spaces at the end of the text.
				ciphertext = ciphertext.substring(0, ciphertext.length() - 3);
			}
			return ciphertext;
		case "NATO Phonetic":
			return Ciphers.plaintextToOutput(Ciphers.plaintextContents);
		case "Morse Code":
			return Ciphers.plaintextToOutput(Ciphers.plaintextContents);
		case "Vatsyayana":
			return Ciphers.formatter(
					Ciphers.vatsyayana(Ciphers.punctuationSeperator(Ciphers.textContents)[0],
							JOptionPane.showInputDialog(frame, "Type the order of your paired letters").toCharArray()),
					Ciphers.punctuationSeperator(Ciphers.textContents)[1]);
		case "Keyword":
			return Ciphers.formatter(
					Ciphers.keywordCipher(Ciphers.keywordGen(JOptionPane.showInputDialog(frame, "Type your keyword.")),
							Ciphers.punctuationSeperator(Ciphers.textContents)[0]),
					Ciphers.punctuationSeperator(Ciphers.textContents)[1]);
		case "Vigenere":
			return Ciphers.formatter(
					Ciphers.vigenere(JOptionPane.showInputDialog(frame, "Type your passphrase"),
							Ciphers.plaintextToOutput(Ciphers.plaintextContents), true),
					Ciphers.punctuationSeperator(Ciphers.textContents)[1]);
		}
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == ciphers_selectCipher1 || event.getSource() == ciphers_selectCipher2) {
			output.setText(performCiphering((String) ciphers_selectCipher1.getSelectedItem(),
					(String) ciphers_selectCipher2.getSelectedItem(), input.getText()));

		} else if (event.getSource() == startButton) {
			if (startButton.getText().equals("Start")) {
				String[] difficulties = { "Easy", "Medium", "Hard" };
				Ciphers.difficulty = (String) JOptionPane.showInputDialog(frame, "Set difficulty", "Set difficulty",
						JOptionPane.PLAIN_MESSAGE, null, difficulties, "Easy");
				// Randomises whether there is text to encipher, which sample
				// text
				// is to be used and which cipher is to be used (out of
				// Rotational,
				// Half-reverse, Reverse, Number, Morse Code and NATO Phonetic).
				String encipher = "";
				Random random = new Random();
				Ciphers.encipher = random.nextBoolean();
				Ciphers.testPlaintext = Ciphers
						.punctuationSeperator(Ciphers.exampleText[random.nextInt(Ciphers.exampleText.length)])[0];
				Ciphers.testCipher = Ciphers.namesOfCiphers[random.nextInt(6) + 1];
				Ciphers.testCiphertext = performCiphering("Plaintext", Ciphers.testCipher, Ciphers.testPlaintext);
				if (Ciphers.encipher) {
					// You have been instructed to encipher it. You are given
					// the
					// plaintext.
					encipher = "encipher";
					inputForUser.setText(Ciphers.testPlaintext);
				} else {
					// You have been instructed to decipher it. You are given
					// the
					// ciphertext.
					encipher = "decipher";
					inputForUser.setText(Ciphers.testCiphertext);
				}
				instructions.setText("Please " + encipher + " this text, written in " + Ciphers.testCipher + ".");
				startButton.setText("Check");
				System.out.println(Ciphers.testCipher + ": " + Ciphers.testPlaintext + "-->" + Ciphers.testCiphertext);
				// TODO Keep working on this
			} else if (startButton.getText().equals("Check")) {
				if ((Ciphers.punctuationSeperator(outputFromUser.getText())[0].equals(Ciphers.testPlaintext)
						&& !Ciphers.encipher)
						|| (Ciphers.punctuationSeperator(outputFromUser.getText())[0].equals(Ciphers.testCiphertext)
								&& Ciphers.encipher)) {
					correct.setText("Correct!");
					outputFromUser.setBackground(Color.GREEN);

				} else {
					correct.setText("Incorrect");
					if (Ciphers.encipher) {
						outputFromUser.setText(outputFromUser.getText() + "\n\n\n" + Ciphers.testCiphertext);
					} else {
						outputFromUser.setText(outputFromUser.getText() + "\n\n\n" + Ciphers.testPlaintext);
					}
				}
			}
		}
	}
}