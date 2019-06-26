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
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener {

	private static final long serialVersionUID = 5081443868281354460L;
	static JComboBox ciphers_selectCipher1, ciphers_selectCipher2, database_selectCiphers;
	JTextArea input, output, inputForUser, outputFromUser;
	JLabel instructions;
	JButton startButton, finish;

	static JFrame frame;
	private JTextField[] textField = new JTextField[28];
	private GridBagConstraints[] gbc_textField = new GridBagConstraints[28];
	private JLabel[] lbl = new JLabel[28];
	private GridBagConstraints[] gbc_lbl = new GridBagConstraints[28];

	private JTextField plainFormat;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setTitle("Cipher Program");
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
		frame.setBounds(100, 100, 640, 480);
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
		ciphers_selectCipher1.setEditable(true);
		ciphers_selectCipher1.addActionListener(this);
		GridBagConstraints gbc_ciphers_selectCipher = new GridBagConstraints();
		gbc_ciphers_selectCipher.insets = new Insets(0, 0, 5, 5);
		gbc_ciphers_selectCipher.fill = GridBagConstraints.HORIZONTAL;
		gbc_ciphers_selectCipher.gridx = 0;
		gbc_ciphers_selectCipher.gridy = 0;
		ciphers.add(ciphers_selectCipher1, gbc_ciphers_selectCipher);

		ciphers_selectCipher2 = new JComboBox(Ciphers.namesOfCiphers);
		ciphers_selectCipher2.setEditable(true);
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

		database_selectCiphers = new JComboBox(Ciphers.namesOfCiphers);
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
		gbl_test.rowHeights = new int[] { 0, 0, 0 };
		gbl_test.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_test.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
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
		gbc_inputForUser.insets = new Insets(0, 0, 0, 5);
		gbc_inputForUser.fill = GridBagConstraints.BOTH;
		gbc_inputForUser.gridx = 0;
		gbc_inputForUser.gridy = 1;
		test.add(inputForUser, gbc_inputForUser);

		outputFromUser = new JTextArea();
		outputFromUser.setWrapStyleWord(true);
		outputFromUser.setLineWrap(true);
		GridBagConstraints gbc_outputFromUser = new GridBagConstraints();
		gbc_outputFromUser.fill = GridBagConstraints.BOTH;
		gbc_outputFromUser.gridx = 1;
		gbc_outputFromUser.gridy = 1;
		test.add(outputFromUser, gbc_outputFromUser);

		JPanel export = new JPanel();
		menu.addTab("Create", null, export, null);
		GridBagLayout gbl_export = new GridBagLayout();
		gbl_export.columnWidths = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0, 0 };
		gbl_export.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_export.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_export.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		export.setLayout(gbl_export);

		plainFormat = new JTextField();
		plainFormat.setText("a;b;c;d;e;f;g;h;i;j;k;l;m;n;o;p;q;r;s;t;u;v;w;x;y;z;; ;");
		GridBagConstraints gbc_plainFormat = new GridBagConstraints();
		gbc_plainFormat.gridwidth = 14;
		gbc_plainFormat.insets = new Insets(0, 0, 5, 5);
		gbc_plainFormat.fill = GridBagConstraints.HORIZONTAL;
		gbc_plainFormat.gridx = 0;
		gbc_plainFormat.gridy = 0;
		export.add(plainFormat, gbc_plainFormat);
		plainFormat.setColumns(10);

		finish = new JButton("Finish");
		finish.addActionListener(this);
		GridBagConstraints gbc_finish = new GridBagConstraints();
		gbc_finish.insets = new Insets(0, 0, 5, 5);
		gbc_finish.gridx = 0;
		gbc_finish.gridy = 1;
		export.add(finish, gbc_finish);

		JLabel createInstructions = new JLabel(
				"Type a unique character or word for each letter, or separate each word with a semicolon");
		GridBagConstraints gbc_createInstructions = new GridBagConstraints();
		gbc_createInstructions.gridwidth = 13;
		gbc_createInstructions.insets = new Insets(0, 0, 5, 5);
		gbc_createInstructions.gridx = 1;
		gbc_createInstructions.gridy = 1;
		export.add(createInstructions, gbc_createInstructions);

		textField[1] = new JTextField();
		gbc_textField[1] = new GridBagConstraints();
		gbc_textField[1].insets = new Insets(0, 0, 5, 5);
		gbc_textField[1].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[1].gridx = 0;
		gbc_textField[1].gridy = 2;
		export.add(textField[1], gbc_textField[1]);
		textField[1].setColumns(10);

		textField[2] = new JTextField();
		gbc_textField[2] = new GridBagConstraints();
		gbc_textField[2].insets = new Insets(0, 0, 5, 5);
		gbc_textField[2].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[2].gridx = 1;
		gbc_textField[2].gridy = 2;
		export.add(textField[2], gbc_textField[2]);
		textField[2].setColumns(10);

		textField[3] = new JTextField();
		gbc_textField[3] = new GridBagConstraints();
		gbc_textField[3].insets = new Insets(0, 0, 5, 5);
		gbc_textField[3].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[3].gridx = 2;
		gbc_textField[3].gridy = 2;
		export.add(textField[3], gbc_textField[3]);
		textField[3].setColumns(10);

		textField[4] = new JTextField();
		gbc_textField[4] = new GridBagConstraints();
		gbc_textField[4].insets = new Insets(0, 0, 5, 5);
		gbc_textField[4].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[4].gridx = 3;
		gbc_textField[4].gridy = 2;
		export.add(textField[4], gbc_textField[4]);
		textField[4].setColumns(10);

		textField[5] = new JTextField();
		gbc_textField[5] = new GridBagConstraints();
		gbc_textField[5].insets = new Insets(0, 0, 5, 5);
		gbc_textField[5].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[5].gridx = 4;
		gbc_textField[5].gridy = 2;
		export.add(textField[5], gbc_textField[5]);
		textField[5].setColumns(10);

		textField[6] = new JTextField();
		gbc_textField[6] = new GridBagConstraints();
		gbc_textField[6].insets = new Insets(0, 0, 5, 5);
		gbc_textField[6].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[6].gridx = 5;
		gbc_textField[6].gridy = 2;
		export.add(textField[6], gbc_textField[6]);
		textField[6].setColumns(10);

		textField[7] = new JTextField();
		gbc_textField[7] = new GridBagConstraints();
		gbc_textField[7].insets = new Insets(0, 0, 5, 5);
		gbc_textField[7].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[7].gridx = 6;
		gbc_textField[7].gridy = 2;
		export.add(textField[7], gbc_textField[7]);
		textField[7].setColumns(10);

		textField[8] = new JTextField();
		gbc_textField[8] = new GridBagConstraints();
		gbc_textField[8].insets = new Insets(0, 0, 5, 5);
		gbc_textField[8].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[8].gridx = 7;
		gbc_textField[8].gridy = 2;
		export.add(textField[8], gbc_textField[8]);
		textField[8].setColumns(10);

		textField[9] = new JTextField();
		gbc_textField[9] = new GridBagConstraints();
		gbc_textField[9].insets = new Insets(0, 0, 5, 5);
		gbc_textField[9].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[9].gridx = 8;
		gbc_textField[9].gridy = 2;
		export.add(textField[9], gbc_textField[9]);
		textField[9].setColumns(10);

		textField[10] = new JTextField();
		gbc_textField[10] = new GridBagConstraints();
		gbc_textField[10].insets = new Insets(0, 0, 5, 5);
		gbc_textField[10].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[10].gridx = 9;
		gbc_textField[10].gridy = 2;
		export.add(textField[10], gbc_textField[10]);
		textField[10].setColumns(10);

		textField[11] = new JTextField();
		gbc_textField[11] = new GridBagConstraints();
		gbc_textField[11].insets = new Insets(0, 0, 5, 5);
		gbc_textField[11].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[11].gridx = 10;
		gbc_textField[11].gridy = 2;
		export.add(textField[11], gbc_textField[11]);
		textField[11].setColumns(10);

		textField[12] = new JTextField();
		gbc_textField[12] = new GridBagConstraints();
		gbc_textField[12].insets = new Insets(0, 0, 5, 5);
		gbc_textField[12].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[12].gridx = 11;
		gbc_textField[12].gridy = 2;
		export.add(textField[12], gbc_textField[12]);
		textField[12].setColumns(10);

		textField[13] = new JTextField();
		gbc_textField[13] = new GridBagConstraints();
		gbc_textField[13].insets = new Insets(0, 0, 5, 5);
		gbc_textField[13].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[13].gridx = 12;
		gbc_textField[13].gridy = 2;
		export.add(textField[13], gbc_textField[13]);
		textField[13].setColumns(10);

		textField[0] = new JTextField();
		gbc_textField[0] = new GridBagConstraints();
		gbc_textField[0].insets = new Insets(0, 0, 5, 0);
		gbc_textField[0].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[0].gridx = 13;
		gbc_textField[0].gridy = 2;
		export.add(textField[0], gbc_textField[0]);
		textField[0].setColumns(10);

		lbl[1] = new JLabel("A");
		gbc_lbl[1] = new GridBagConstraints();
		gbc_lbl[1].insets = new Insets(0, 0, 5, 5);
		gbc_lbl[1].gridx = 0;
		gbc_lbl[1].gridy = 3;
		export.add(lbl[1], gbc_lbl[1]);

		lbl[2] = new JLabel("B");
		gbc_lbl[2] = new GridBagConstraints();
		gbc_lbl[2].insets = new Insets(0, 0, 5, 5);
		gbc_lbl[2].gridx = 1;
		gbc_lbl[2].gridy = 3;
		export.add(lbl[2], gbc_lbl[2]);

		lbl[3] = new JLabel("C");
		gbc_lbl[3] = new GridBagConstraints();
		gbc_lbl[3].insets = new Insets(0, 0, 5, 5);
		gbc_lbl[3].gridx = 2;
		gbc_lbl[3].gridy = 3;
		export.add(lbl[3], gbc_lbl[3]);

		lbl[4] = new JLabel("D");
		gbc_lbl[4] = new GridBagConstraints();
		gbc_lbl[4].insets = new Insets(0, 0, 5, 5);
		gbc_lbl[4].gridx = 3;
		gbc_lbl[4].gridy = 3;
		export.add(lbl[4], gbc_lbl[4]);

		lbl[5] = new JLabel("E");
		gbc_lbl[5] = new GridBagConstraints();
		gbc_lbl[5].insets = new Insets(0, 0, 5, 5);
		gbc_lbl[5].gridx = 4;
		gbc_lbl[5].gridy = 3;
		export.add(lbl[5], gbc_lbl[5]);

		lbl[6] = new JLabel("F");
		gbc_lbl[6] = new GridBagConstraints();
		gbc_lbl[6].insets = new Insets(0, 0, 5, 5);
		gbc_lbl[6].gridx = 5;
		gbc_lbl[6].gridy = 3;
		export.add(lbl[6], gbc_lbl[6]);

		lbl[7] = new JLabel("G");
		gbc_lbl[7] = new GridBagConstraints();
		gbc_lbl[7].insets = new Insets(0, 0, 5, 5);
		gbc_lbl[7].gridx = 6;
		gbc_lbl[7].gridy = 3;
		export.add(lbl[7], gbc_lbl[7]);

		lbl[8] = new JLabel("H");
		gbc_lbl[8] = new GridBagConstraints();
		gbc_lbl[8].insets = new Insets(0, 0, 5, 5);
		gbc_lbl[8].gridx = 7;
		gbc_lbl[8].gridy = 3;
		export.add(lbl[8], gbc_lbl[8]);

		lbl[9] = new JLabel("I");
		gbc_lbl[9] = new GridBagConstraints();
		gbc_lbl[9].insets = new Insets(0, 0, 5, 5);
		gbc_lbl[9].gridx = 8;
		gbc_lbl[9].gridy = 3;
		export.add(lbl[9], gbc_lbl[9]);

		lbl[10] = new JLabel("J");
		gbc_lbl[10] = new GridBagConstraints();
		gbc_lbl[10].insets = new Insets(0, 0, 5, 5);
		gbc_lbl[10].gridx = 9;
		gbc_lbl[10].gridy = 3;
		export.add(lbl[10], gbc_lbl[10]);

		lbl[11] = new JLabel("K");
		gbc_lbl[11] = new GridBagConstraints();
		gbc_lbl[11].insets = new Insets(0, 0, 5, 5);
		gbc_lbl[11].gridx = 10;
		gbc_lbl[11].gridy = 3;
		export.add(lbl[11], gbc_lbl[11]);

		lbl[12] = new JLabel("L");
		gbc_lbl[12] = new GridBagConstraints();
		gbc_lbl[12].insets = new Insets(0, 0, 5, 5);
		gbc_lbl[12].gridx = 11;
		gbc_lbl[12].gridy = 3;
		export.add(lbl[12], gbc_lbl[12]);

		lbl[13] = new JLabel("M");
		gbc_lbl[13] = new GridBagConstraints();
		gbc_lbl[13].insets = new Insets(0, 0, 5, 5);
		gbc_lbl[13].gridx = 12;
		gbc_lbl[13].gridy = 3;
		export.add(lbl[13], gbc_lbl[13]);

		lbl[0] = new JLabel("SPACE");
		gbc_lbl[0] = new GridBagConstraints();
		gbc_lbl[0].insets = new Insets(0, 0, 5, 0);
		gbc_lbl[0].gridx = 13;
		gbc_lbl[0].gridy = 3;
		export.add(lbl[0], gbc_lbl[0]);

		lbl[14] = new JLabel("N");
		gbc_lbl[14] = new GridBagConstraints();
		gbc_lbl[14].insets = new Insets(0, 0, 0, 5);
		gbc_lbl[14].gridx = 0;
		gbc_lbl[14].gridy = 5;
		export.add(lbl[14], gbc_lbl[14]);

		lbl[15] = new JLabel("O");
		gbc_lbl[15] = new GridBagConstraints();
		gbc_lbl[15].insets = new Insets(0, 0, 0, 5);
		gbc_lbl[15].gridx = 1;
		gbc_lbl[15].gridy = 5;
		export.add(lbl[15], gbc_lbl[15]);

		lbl[16] = new JLabel("P");
		gbc_lbl[16] = new GridBagConstraints();
		gbc_lbl[16].insets = new Insets(0, 0, 0, 5);
		gbc_lbl[16].gridx = 2;
		gbc_lbl[16].gridy = 5;
		export.add(lbl[16], gbc_lbl[16]);

		lbl[17] = new JLabel("Q");
		gbc_lbl[17] = new GridBagConstraints();
		gbc_lbl[17].insets = new Insets(0, 0, 0, 5);
		gbc_lbl[17].gridx = 3;
		gbc_lbl[17].gridy = 5;
		export.add(lbl[17], gbc_lbl[17]);

		lbl[18] = new JLabel("R");
		gbc_lbl[18] = new GridBagConstraints();
		gbc_lbl[18].insets = new Insets(0, 0, 0, 5);
		gbc_lbl[18].gridx = 4;
		gbc_lbl[18].gridy = 5;
		export.add(lbl[18], gbc_lbl[18]);

		lbl[19] = new JLabel("S");
		gbc_lbl[19] = new GridBagConstraints();
		gbc_lbl[19].insets = new Insets(0, 0, 0, 5);
		gbc_lbl[19].gridx = 5;
		gbc_lbl[19].gridy = 5;
		export.add(lbl[19], gbc_lbl[19]);

		lbl[20] = new JLabel("T");
		gbc_lbl[20] = new GridBagConstraints();
		gbc_lbl[20].insets = new Insets(0, 0, 0, 5);
		gbc_lbl[20].gridx = 6;
		gbc_lbl[20].gridy = 5;
		export.add(lbl[20], gbc_lbl[20]);

		lbl[21] = new JLabel("U");
		gbc_lbl[21] = new GridBagConstraints();
		gbc_lbl[21].insets = new Insets(0, 0, 0, 5);
		gbc_lbl[21].gridx = 7;
		gbc_lbl[21].gridy = 5;
		export.add(lbl[21], gbc_lbl[21]);

		lbl[22] = new JLabel("V");
		gbc_lbl[22] = new GridBagConstraints();
		gbc_lbl[22].insets = new Insets(0, 0, 0, 5);
		gbc_lbl[22].gridx = 8;
		gbc_lbl[22].gridy = 5;
		export.add(lbl[22], gbc_lbl[22]);

		lbl[23] = new JLabel("W");
		gbc_lbl[23] = new GridBagConstraints();
		gbc_lbl[23].insets = new Insets(0, 0, 0, 5);
		gbc_lbl[23].gridx = 9;
		gbc_lbl[23].gridy = 5;
		export.add(lbl[23], gbc_lbl[23]);

		lbl[24] = new JLabel("X");
		gbc_lbl[24] = new GridBagConstraints();
		gbc_lbl[24].insets = new Insets(0, 0, 0, 5);
		gbc_lbl[24].gridx = 10;
		gbc_lbl[24].gridy = 5;
		export.add(lbl[24], gbc_lbl[24]);

		lbl[25] = new JLabel("Y");
		gbc_lbl[25] = new GridBagConstraints();
		gbc_lbl[25].insets = new Insets(0, 0, 0, 5);
		gbc_lbl[25].gridx = 11;
		gbc_lbl[25].gridy = 5;
		export.add(lbl[25], gbc_lbl[25]);

		lbl[26] = new JLabel("Z");
		gbc_lbl[26] = new GridBagConstraints();
		gbc_lbl[26].insets = new Insets(0, 0, 0, 5);
		gbc_lbl[26].gridx = 12;
		gbc_lbl[26].gridy = 5;
		export.add(lbl[26], gbc_lbl[26]);

		lbl[27] = new JLabel("SEPARATOR");
		lbl[27].setToolTipText("What character separates each letter");
		gbc_lbl[27] = new GridBagConstraints();
		gbc_lbl[27].gridx = 13;
		gbc_lbl[27].gridy = 5;
		export.add(lbl[27], gbc_lbl[27]);

		textField[14] = new JTextField();
		gbc_textField[14] = new GridBagConstraints();
		gbc_textField[14].insets = new Insets(0, 0, 5, 5);
		gbc_textField[14].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[14].gridx = 0;
		gbc_textField[14].gridy = 4;
		export.add(textField[14], gbc_textField[14]);
		textField[14].setColumns(10);

		textField[15] = new JTextField();
		gbc_textField[15] = new GridBagConstraints();
		gbc_textField[15].insets = new Insets(0, 0, 5, 5);
		gbc_textField[15].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[15].gridx = 1;
		gbc_textField[15].gridy = 4;
		export.add(textField[15], gbc_textField[15]);
		textField[15].setColumns(10);

		textField[16] = new JTextField();
		gbc_textField[16] = new GridBagConstraints();
		gbc_textField[16].insets = new Insets(0, 0, 5, 5);
		gbc_textField[16].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[16].gridx = 2;
		gbc_textField[16].gridy = 4;
		export.add(textField[16], gbc_textField[16]);
		textField[16].setColumns(10);

		textField[17] = new JTextField();
		gbc_textField[17] = new GridBagConstraints();
		gbc_textField[17].insets = new Insets(0, 0, 5, 5);
		gbc_textField[17].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[17].gridx = 3;
		gbc_textField[17].gridy = 4;
		export.add(textField[17], gbc_textField[17]);
		textField[17].setColumns(10);

		textField[18] = new JTextField();
		gbc_textField[18] = new GridBagConstraints();
		gbc_textField[18].insets = new Insets(0, 0, 5, 5);
		gbc_textField[18].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[18].gridx = 4;
		gbc_textField[18].gridy = 4;
		export.add(textField[18], gbc_textField[18]);
		textField[18].setColumns(10);

		textField[19] = new JTextField();
		gbc_textField[19] = new GridBagConstraints();
		gbc_textField[19].insets = new Insets(0, 0, 5, 5);
		gbc_textField[19].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[19].gridx = 5;
		gbc_textField[19].gridy = 4;
		export.add(textField[19], gbc_textField[19]);
		textField[19].setColumns(10);

		textField[20] = new JTextField();
		gbc_textField[20] = new GridBagConstraints();
		gbc_textField[20].insets = new Insets(0, 0, 5, 5);
		gbc_textField[20].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[20].gridx = 6;
		gbc_textField[20].gridy = 4;
		export.add(textField[20], gbc_textField[20]);
		textField[20].setColumns(10);

		textField[21] = new JTextField();
		gbc_textField[21] = new GridBagConstraints();
		gbc_textField[21].insets = new Insets(0, 0, 5, 5);
		gbc_textField[21].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[21].gridx = 7;
		gbc_textField[21].gridy = 4;
		export.add(textField[21], gbc_textField[21]);
		textField[21].setColumns(10);

		textField[22] = new JTextField();
		gbc_textField[22] = new GridBagConstraints();
		gbc_textField[22].insets = new Insets(0, 0, 5, 5);
		gbc_textField[22].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[22].gridx = 8;
		gbc_textField[22].gridy = 4;
		export.add(textField[22], gbc_textField[22]);
		textField[22].setColumns(10);

		textField[23] = new JTextField();
		gbc_textField[23] = new GridBagConstraints();
		gbc_textField[23].insets = new Insets(0, 0, 5, 5);
		gbc_textField[23].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[23].gridx = 9;
		gbc_textField[23].gridy = 4;
		export.add(textField[23], gbc_textField[23]);
		textField[23].setColumns(10);

		textField[24] = new JTextField();
		gbc_textField[24] = new GridBagConstraints();
		gbc_textField[24].insets = new Insets(0, 0, 5, 5);
		gbc_textField[24].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[24].gridx = 10;
		gbc_textField[24].gridy = 4;
		export.add(textField[24], gbc_textField[24]);
		textField[24].setColumns(10);

		textField[25] = new JTextField();
		gbc_textField[25] = new GridBagConstraints();
		gbc_textField[25].insets = new Insets(0, 0, 5, 5);
		gbc_textField[25].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[25].gridx = 11;
		gbc_textField[25].gridy = 4;
		export.add(textField[25], gbc_textField[25]);
		textField[25].setColumns(10);

		textField[26] = new JTextField();
		gbc_textField[26] = new GridBagConstraints();
		gbc_textField[26].insets = new Insets(0, 0, 5, 5);
		gbc_textField[26].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[26].gridx = 12;
		gbc_textField[26].gridy = 4;
		export.add(textField[26], gbc_textField[26]);
		textField[26].setColumns(10);

		textField[27] = new JTextField();
		gbc_textField[27] = new GridBagConstraints();
		gbc_textField[27].insets = new Insets(0, 0, 5, 0);
		gbc_textField[27].fill = GridBagConstraints.HORIZONTAL;
		gbc_textField[27].gridx = 13;
		gbc_textField[27].gridy = 4;
		export.add(textField[27], gbc_textField[27]);
		textField[27].setColumns(10);

	}

	public boolean customChecker(String customCipher) {
		if (!customCipher.endsWith(";")) {
			return false;
		}
		System.out.println("running");
		if (customCipher.isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Type something in the text box", "Invalid input",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		int numberOfSemicolons = 0;
		for (int i = 0; i < customCipher.length(); i++) {
			System.out.println(customCipher.charAt(i));
			if (customCipher.charAt(i) == ';') {
				numberOfSemicolons++;
			}
		}
		System.out.println("semicolons found:" + numberOfSemicolons);
		if (numberOfSemicolons != 28) {
			JOptionPane.showMessageDialog(frame, "There must be 28 semicolons in the input", "Invalid input",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		String customCipherLetters[] = customCipher.split(";");
		for (int i = 0; i < customCipherLetters.length; i++) {
			System.out.println(customCipherLetters[i]);
		}
		for (int i = 0; i < customCipherLetters.length; i++) {
			for (int j = 0; j < customCipherLetters.length; j++) {
				if ((customCipherLetters[i].contains(customCipherLetters[j]) && j != i
						&& (("" + customCipherLetters[customCipherLetters.length - 2]).equals(""))
						&& !customCipherLetters[j].equals(""))
						|| customCipherLetters[i].equals(customCipherLetters[j])) {
					System.out.println(customCipherLetters[i] + " contains " + customCipherLetters[j]);
					JOptionPane.showMessageDialog(frame, "Duplicate or partial duplicate of characters",
							"Invalid input", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
		}
		if (customCipherLetters[customCipherLetters.length - 2].length() > 1) {
			System.out.println("Letter separator" + customCipherLetters[customCipherLetters.length - 2]);
			JOptionPane.showMessageDialog(frame, "Letter separator is more than one character", "Invalid input",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (customCipherLetters[customCipherLetters.length - 1].length() > 1) {
			JOptionPane.showMessageDialog(frame, "Word separator is more than one character", "Invalid input",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (customCipherLetters[customCipherLetters.length - 1].length() == 0) {
			JOptionPane.showMessageDialog(frame, "Word separator is not valid", "Invalid input",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	public void nextTask() {
		// Randomises whether there is text to encipher, which sample
		// text is to be used and which cipher is to be used (out of
		// Rotational, Half-reverse, Reverse, Number, Morse Code and NATO
		// Phonetic).
		outputFromUser.setBackground(Color.WHITE);
		outputFromUser.setText("");
		String encipher = "";
		Random random = new Random();
		Ciphers.encipher = random.nextBoolean();
		
		Plaintext testPlaintext = new Plaintext(Ciphers.exampleText[random.nextInt(Ciphers.exampleText.length)]);
		Ciphers.testPlaintext = testPlaintext.getText();

		if (!Ciphers.difficulty.equals("Easy")) {
			String plaintextOptions[] = new String[10];
			for (int i = 0; i < plaintextOptions.length; i++) {
				Plaintext option = new Plaintext(Ciphers.exampleText[random.nextInt(Ciphers.exampleText.length)]);
				plaintextOptions[i] = option.getText();
			}
			int maxLength = 0;
			int maxText = 0;
			for (int i = 0; i < plaintextOptions.length; i++) {
				if (plaintextOptions[i].length() > maxLength) {
					maxLength = plaintextOptions[i].length();
					maxText = i;
				}
			}
			Ciphers.testPlaintext = plaintextOptions[maxText];
		}
		Ciphers.testCipher = Ciphers.namesOfCiphers[random.nextInt(6) + 1];
		Ciphers.testCiphertext = performCiphering("Plaintext", Ciphers.testCipher, Ciphers.testPlaintext);
		if (Ciphers.encipher) {
			// You have been instructed to encipher it. You are given the
			// plaintext.
			encipher = "encipher";
			inputForUser.setText(Ciphers.testPlaintext);
		} else {
			// You have been instructed to decipher it. You are given the
			// ciphertext.
			encipher = "decipher";
			inputForUser.setText(Ciphers.testCiphertext);
		}
		if (Ciphers.difficulty.equals("Hard")) {
			instructions.setText("Please " + encipher + " this text.");
			if (Ciphers.encipher) {
				instructions.setText("Please " + encipher + " this text in " + Ciphers.testCipher + ".");

			}
		} else {
			instructions.setText("Please " + encipher + " this text, written in " + Ciphers.testCipher + ".");
		}
		if (Ciphers.testCipher.equals("Rotational") && Ciphers.encipher) {
			System.out.println(Ciphers.testCipher);
			instructions.setText("Please " + encipher + " this text in " + Ciphers.testCipher + ", with a magnitude of "
					+ Ciphers.adder + ".");
		}
		startButton.setText("Check");
		Ciphers.tasksCompleted++;
	}

	public String performCiphering(String local_selectCipher1, String local_selectCipher2, String local_input) {
		// Fetches selected ciphers and text entered.
		Ciphers.selectedCipher1 = local_selectCipher1;
		Ciphers.selectedCipher2 = local_selectCipher2;
		Ciphers.textContents = local_input;
		Ciphers.plaintextContents = new int[Ciphers.textContents.length()];

		boolean simpleCipher = false;

		// Checks to see if custom cipher is being used.
		Ciphers.cipher1isCustom = customChecker(Ciphers.selectedCipher1);
		Ciphers.cipher2isCustom = customChecker(Ciphers.selectedCipher2);
		System.out.println("cipher1 " + Ciphers.cipher1isCustom + ", cipher2 " + Ciphers.cipher2isCustom);

		// Converts to plaintext.
		
		Plaintext plaintext = new Plaintext(Ciphers.textContents);
		
		if (Ciphers.cipher1isCustom) {
			simpleCipher = true;
			Ciphers.plaintextContents = Ciphers.caster(Ciphers.textContents);
		} else {
			switch (Ciphers.selectedCipher1) {
			default:
				// Default is used for plaintext, reverse, half-reverse and
				// rotational.
				Ciphers.plaintextContents = Ciphers.inputToPlaintext(plaintext.getText());
				break;
			case "Number":
				try {
					Integer.parseInt("" + Ciphers.textContents.charAt(0));
				} catch (NumberFormatException e) {
					Ciphers.textContents = Ciphers.textContents.substring(1);
				}
				try {
					Integer.parseInt("" + Ciphers.textContents.charAt(Ciphers.textContents.length() - 1));
				} catch (NumberFormatException e) {
					Ciphers.textContents = Ciphers.textContents.substring(0, Ciphers.textContents.length() - 1);
				}
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
				Ciphers.keyword1 = "";
				while (Ciphers.keyword1.equals("")) {
					Ciphers.keyword1 = JOptionPane.showInputDialog(frame,
							"Type the order of the paired letters used in enciphering this message");
					if (Ciphers.keyword1.equals("")) {
						JOptionPane.showMessageDialog(frame, "Please type a valid keyword.", "Invalid input",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				Ciphers.plaintextContents = Ciphers
						.inputToPlaintext(Ciphers.vatsyayana(plaintext.getText(),
								Ciphers.keywordGen(Ciphers.keyword1).toCharArray()));
				break;
			case "Keyword":
				Ciphers.keyword1 = JOptionPane.showInputDialog(frame,
						"Type the keyword that was used to encipher this message.", Ciphers.keyword1);
				Ciphers.plaintextContents = Ciphers.inputToPlaintext(
						Ciphers.keywordCipher(Ciphers.keyReversal(Ciphers.keywordGen(Ciphers.keyword1)),
								Ciphers.inputToPlaintext(plaintext.getText())));
				break;
			case "Vigenere":
				Ciphers.keyword1 = JOptionPane.showInputDialog(frame,
						"Type the passphrase that was used to encipher this message.", Ciphers.keyword1);
				Ciphers.plaintextContents = Ciphers.inputToPlaintext(Ciphers.vigenere(Ciphers.keyword1,
						plaintext.getText(), false));
			}
			if (simpleCipher) {
				// Used for Morse Code, NATO Phonetic and Number.
				Ciphers.plaintextContents = Ciphers.caster(Ciphers.textContents);
			}
		}
		if (Ciphers.cipher2isCustom) {
			String customCipherLetters[] = Ciphers.selectedCipher2.split(";");
			String output = "";
			for (int i = 0; i < Ciphers.plaintextContents.length; i++) {
				System.out.println("i = " + i);
				if (Ciphers.plaintextContents[i] == -1) {
					output += customCipherLetters[customCipherLetters.length - 1];
				} else if (Ciphers.plaintextContents[i] == 0) {
					output += customCipherLetters[customCipherLetters.length - 3];
				} else {
					output += customCipherLetters[(Ciphers.plaintextContents[i] + customCipherLetters.length - 1)
							% customCipherLetters.length] + customCipherLetters[customCipherLetters.length - 2];
				}
			}
			return output;
		}
		switch (Ciphers.selectedCipher2) {
		default:
			// default is for Reverse, Half Reverse, Rotational, and
			// Plaintext.
			if (simpleCipher) {
				return Ciphers.plaintextToOutput(Ciphers.plaintextContents).trim();
			} else {
				plaintext.setText(Ciphers.plaintextToOutput(Ciphers.plaintextContents));
				return plaintext.toString();
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
			Ciphers.keyword2 = "";
			while (Ciphers.keyword2.equals("")) {
				Ciphers.keyword2 = JOptionPane.showInputDialog(frame, "Type the order of your paired letters");
				if (Ciphers.keyword2.equals("")) {
					JOptionPane.showMessageDialog(frame, "Please type a valid keyword.", "Invalid input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			if (simpleCipher) {
				return Ciphers.vatsyayana(Ciphers.plaintextToOutput(Ciphers.plaintextContents),
						Ciphers.keywordGen(Ciphers.keyword2).toCharArray());
			} else {
				plaintext.setText(Ciphers.vatsyayana(Ciphers.plaintextToOutput(Ciphers.plaintextContents),
						Ciphers.keywordGen(Ciphers.keyword2).toCharArray()));
				return plaintext.toString();
			}
		case "Keyword":
			Ciphers.keyword2 = "";
			while (Ciphers.keyword2.equals("")) {
				Ciphers.keyword2 = JOptionPane.showInputDialog(frame, "Type your keyword.");
				if (Ciphers.keyword2.equals("")) {
					JOptionPane.showMessageDialog(frame, "Please type a valid keyword.", "Invalid input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			if (simpleCipher) {
				return Ciphers.keywordCipher(Ciphers.keywordGen(Ciphers.keyword2),
						Ciphers.inputToPlaintext(Ciphers.plaintextToOutput(Ciphers.plaintextContents)));
			} else {
				plaintext.setText(Ciphers.keywordCipher(Ciphers.keywordGen(Ciphers.keyword2),
								Ciphers.inputToPlaintext(Ciphers.plaintextToOutput(Ciphers.plaintextContents))));
				return plaintext.toString();
			}
		case "Vigenere":
			Ciphers.keyword2 = "";
			while (Ciphers.keyword2.equals("")) {
				Ciphers.keyword2 = JOptionPane.showInputDialog(frame, "Type your passphrase");
				if (Ciphers.keyword2.equals("")) {
					JOptionPane.showMessageDialog(frame, "Please type a valid passphrase.", "Invalid input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			if (simpleCipher) {
				return Ciphers.vigenere(Ciphers.keyword2, Ciphers.plaintextToOutput(Ciphers.plaintextContents), true);
			} else {
				plaintext.setText(Ciphers.vigenere(Ciphers.keyword2, Ciphers.plaintextToOutput(Ciphers.plaintextContents), true));
				return plaintext.toString();
			}
		}
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == ciphers_selectCipher1 || event.getSource() == ciphers_selectCipher2) {
			output.setText(performCiphering((String) ciphers_selectCipher1.getSelectedItem(),
					(String) ciphers_selectCipher2.getSelectedItem(), input.getText()));

		} else if (event.getSource() == startButton) {
			if (startButton.getText().equals("Start")) {
				Ciphers.testRunning = true;
				Ciphers.tasksCompleted = 0;
				String[] difficulties = { "Easy", "Medium", "Hard" };
				boolean failure = true;
				while (failure) {
					failure = false;
					Ciphers.difficulty = (String) JOptionPane.showInputDialog(frame, "Set difficulty", "Set difficulty",
							JOptionPane.PLAIN_MESSAGE, null, difficulties, "Easy");
					try {
						Ciphers.difficulty.equals("");
					} catch (NullPointerException e) {
						JOptionPane.showMessageDialog(frame, "Please select a difficulty setting.", "Invalid input",
								JOptionPane.ERROR_MESSAGE);
						failure = true;
					}
				}
				failure = true;
				while (failure) {
					failure = false;
					try {
						Ciphers.numberOfTasks = Integer
								.parseInt(JOptionPane.showInputDialog(frame, "How many tasks do you want?"));
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(frame, "Please enter a number, not letters.", "Invalid input",
								JOptionPane.ERROR_MESSAGE);
						failure = true;
					}
				}
				nextTask();
			} else if (startButton.getText().equals("Check")) {
				Plaintext testPlaintext = new Plaintext(outputFromUser.getText());
				if ((testPlaintext.getText().equals(Ciphers.testPlaintext)
						&& !Ciphers.encipher)
						|| (testPlaintext.getText().equals(Ciphers.testCiphertext)
								&& Ciphers.encipher)) {
					Ciphers.tasksCorrect++;
					outputFromUser.setBackground(Color.GREEN);
				} else {
					outputFromUser.setBackground(Color.RED);
					if (Ciphers.encipher) {
						outputFromUser.setText(outputFromUser.getText() + "\n\n\n" + Ciphers.testCiphertext);
					} else {
						outputFromUser.setText(outputFromUser.getText() + "\n\n\n" + Ciphers.testPlaintext);
					}
				}
				startButton.setText("Next");
			} else if (startButton.getText().equals("Next")) {
				if (Ciphers.tasksCompleted < Ciphers.numberOfTasks) {
					nextTask();
				} else {
					startButton.setText("Start");
					JOptionPane.showMessageDialog(frame,
							"Number of tasks completed correctly: " + Ciphers.tasksCorrect + "/" + Ciphers.numberOfTasks
									+ "\nAccuracy: " + ((double) (Ciphers.tasksCorrect / Ciphers.numberOfTasks) * 100)
									+ "%",
							"Results", JOptionPane.PLAIN_MESSAGE);
					Ciphers.testRunning = false;
				}
			}
		} else if (event.getSource() == finish) {
			System.out.println("Finish button pressed.");
			if (plainFormat.getText().equals("")
					|| plainFormat.getText().equals("a;b;c;d;e;f;g;h;i;j;k;l;m;n;o;p;q;r;s;t;u;v;w;x;y;z;; ;")) {
				String plainFormatTemp = "";
				for (int i = 1; i < textField.length + 1; i++) {
					plainFormatTemp += textField[(i % textField.length)].getText() + ";";
				}
				plainFormat.setText(plainFormatTemp);
				JOptionPane.showMessageDialog(frame,
						"Copy the text from the text box and paste it in the cipher list on the Cipher window.");
			}
		}
	}
}