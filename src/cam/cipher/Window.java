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

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener {

	private static final long serialVersionUID = 5081443868281354460L;
	static JComboBox ciphers_selectCipher1, ciphers_selectCipher2, database_selectCiphers;
	JTextArea input, output, inputForUser, outputFromUser;
	JLabel instructions;
	JButton startButton, finish;

	static JFrame frame;
	private JTextField textFieldA;
	private JTextField textFieldB;
	private JTextField textFieldC;
	private JTextField textFieldD;
	private JTextField textFieldE;
	private JTextField textFieldF;
	private JTextField textFieldG;
	private JTextField textFieldH;
	private JTextField textFieldI;
	private JTextField textFieldJ;
	private JTextField textFieldK;
	private JTextField textFieldL;
	private JTextField textFieldM;
	private JTextField textFieldN;
	private JTextField textFieldO;
	private JTextField textFieldP;
	private JTextField textFieldQ;
	private JTextField textFieldR;
	private JTextField textFieldS;
	private JTextField textFieldT;
	private JTextField textFieldU;
	private JTextField textFieldV;
	private JTextField textFieldW;
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldZ;

	private JTextField plainFormat;

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

		Ciphers.emptyCipher = 10;

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
		gbl_export.columnWidths = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0 };
		gbl_export.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_export.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_export.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		export.setLayout(gbl_export);

		plainFormat = new JTextField();
		plainFormat.setText("a;b;c;d;e;f;g;h;i;j;k;l;m;n;o;p;q;r;s;t;u;v;w;x;y;z;");
		GridBagConstraints gbc_plainFormat = new GridBagConstraints();
		gbc_plainFormat.gridwidth = 13;
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
				"Type a character or word for each letter, or seperate each word with a semicolon");
		GridBagConstraints gbc_createInstructions = new GridBagConstraints();
		gbc_createInstructions.gridwidth = 12;
		gbc_createInstructions.insets = new Insets(0, 0, 5, 0);
		gbc_createInstructions.gridx = 1;
		gbc_createInstructions.gridy = 1;
		export.add(createInstructions, gbc_createInstructions);

		textFieldA = new JTextField();
		GridBagConstraints gbc_textFieldA = new GridBagConstraints();
		gbc_textFieldA.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldA.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldA.gridx = 0;
		gbc_textFieldA.gridy = 2;
		export.add(textFieldA, gbc_textFieldA);
		textFieldA.setColumns(10);

		textFieldB = new JTextField();
		GridBagConstraints gbc_textFieldB = new GridBagConstraints();
		gbc_textFieldB.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldB.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldB.gridx = 1;
		gbc_textFieldB.gridy = 2;
		export.add(textFieldB, gbc_textFieldB);
		textFieldB.setColumns(10);

		textFieldC = new JTextField();
		GridBagConstraints gbc_textFieldC = new GridBagConstraints();
		gbc_textFieldC.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldC.gridx = 2;
		gbc_textFieldC.gridy = 2;
		export.add(textFieldC, gbc_textFieldC);
		textFieldC.setColumns(10);

		textFieldD = new JTextField();
		GridBagConstraints gbc_textFieldD = new GridBagConstraints();
		gbc_textFieldD.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldD.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldD.gridx = 3;
		gbc_textFieldD.gridy = 2;
		export.add(textFieldD, gbc_textFieldD);
		textFieldD.setColumns(10);

		textFieldE = new JTextField();
		GridBagConstraints gbc_textFieldE = new GridBagConstraints();
		gbc_textFieldE.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldE.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldE.gridx = 4;
		gbc_textFieldE.gridy = 2;
		export.add(textFieldE, gbc_textFieldE);
		textFieldE.setColumns(10);

		textFieldF = new JTextField();
		GridBagConstraints gbc_textFieldF = new GridBagConstraints();
		gbc_textFieldF.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldF.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldF.gridx = 5;
		gbc_textFieldF.gridy = 2;
		export.add(textFieldF, gbc_textFieldF);
		textFieldF.setColumns(10);

		textFieldG = new JTextField();
		GridBagConstraints gbc_textFieldG = new GridBagConstraints();
		gbc_textFieldG.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldG.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldG.gridx = 6;
		gbc_textFieldG.gridy = 2;
		export.add(textFieldG, gbc_textFieldG);
		textFieldG.setColumns(10);

		textFieldH = new JTextField();
		GridBagConstraints gbc_textFieldH = new GridBagConstraints();
		gbc_textFieldH.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldH.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldH.gridx = 7;
		gbc_textFieldH.gridy = 2;
		export.add(textFieldH, gbc_textFieldH);
		textFieldH.setColumns(10);

		textFieldI = new JTextField();
		GridBagConstraints gbc_textFieldI = new GridBagConstraints();
		gbc_textFieldI.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldI.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldI.gridx = 8;
		gbc_textFieldI.gridy = 2;
		export.add(textFieldI, gbc_textFieldI);
		textFieldI.setColumns(10);

		textFieldJ = new JTextField();
		GridBagConstraints gbc_textFieldJ = new GridBagConstraints();
		gbc_textFieldJ.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldJ.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldJ.gridx = 9;
		gbc_textFieldJ.gridy = 2;
		export.add(textFieldJ, gbc_textFieldJ);
		textFieldJ.setColumns(10);

		textFieldK = new JTextField();
		GridBagConstraints gbc_textFieldK = new GridBagConstraints();
		gbc_textFieldK.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldK.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldK.gridx = 10;
		gbc_textFieldK.gridy = 2;
		export.add(textFieldK, gbc_textFieldK);
		textFieldK.setColumns(10);

		textFieldL = new JTextField();
		GridBagConstraints gbc_textFieldL = new GridBagConstraints();
		gbc_textFieldL.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldL.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldL.gridx = 11;
		gbc_textFieldL.gridy = 2;
		export.add(textFieldL, gbc_textFieldL);
		textFieldL.setColumns(10);

		textFieldM = new JTextField();
		GridBagConstraints gbc_textFieldM = new GridBagConstraints();
		gbc_textFieldM.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldM.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldM.gridx = 12;
		gbc_textFieldM.gridy = 2;
		export.add(textFieldM, gbc_textFieldM);
		textFieldM.setColumns(10);

		JLabel lblA = new JLabel("A");
		GridBagConstraints gbc_lblA = new GridBagConstraints();
		gbc_lblA.insets = new Insets(0, 0, 5, 5);
		gbc_lblA.gridx = 0;
		gbc_lblA.gridy = 3;
		export.add(lblA, gbc_lblA);

		JLabel lblB = new JLabel("B");
		GridBagConstraints gbc_lblB = new GridBagConstraints();
		gbc_lblB.insets = new Insets(0, 0, 5, 5);
		gbc_lblB.gridx = 1;
		gbc_lblB.gridy = 3;
		export.add(lblB, gbc_lblB);

		JLabel lblC = new JLabel("C");
		GridBagConstraints gbc_lblC = new GridBagConstraints();
		gbc_lblC.insets = new Insets(0, 0, 5, 5);
		gbc_lblC.gridx = 2;
		gbc_lblC.gridy = 3;
		export.add(lblC, gbc_lblC);

		JLabel lblD = new JLabel("D");
		GridBagConstraints gbc_lblD = new GridBagConstraints();
		gbc_lblD.insets = new Insets(0, 0, 5, 5);
		gbc_lblD.gridx = 3;
		gbc_lblD.gridy = 3;
		export.add(lblD, gbc_lblD);

		JLabel lblE = new JLabel("E");
		GridBagConstraints gbc_lblE = new GridBagConstraints();
		gbc_lblE.insets = new Insets(0, 0, 5, 5);
		gbc_lblE.gridx = 4;
		gbc_lblE.gridy = 3;
		export.add(lblE, gbc_lblE);

		JLabel lblF = new JLabel("F");
		GridBagConstraints gbc_lblF = new GridBagConstraints();
		gbc_lblF.insets = new Insets(0, 0, 5, 5);
		gbc_lblF.gridx = 5;
		gbc_lblF.gridy = 3;
		export.add(lblF, gbc_lblF);

		JLabel lblG = new JLabel("G");
		GridBagConstraints gbc_lblG = new GridBagConstraints();
		gbc_lblG.insets = new Insets(0, 0, 5, 5);
		gbc_lblG.gridx = 6;
		gbc_lblG.gridy = 3;
		export.add(lblG, gbc_lblG);

		JLabel lblH = new JLabel("H");
		GridBagConstraints gbc_lblH = new GridBagConstraints();
		gbc_lblH.insets = new Insets(0, 0, 5, 5);
		gbc_lblH.gridx = 7;
		gbc_lblH.gridy = 3;
		export.add(lblH, gbc_lblH);

		JLabel lblI = new JLabel("I");
		GridBagConstraints gbc_lblI = new GridBagConstraints();
		gbc_lblI.insets = new Insets(0, 0, 5, 5);
		gbc_lblI.gridx = 8;
		gbc_lblI.gridy = 3;
		export.add(lblI, gbc_lblI);

		JLabel lblJ = new JLabel("J");
		GridBagConstraints gbc_lblJ = new GridBagConstraints();
		gbc_lblJ.insets = new Insets(0, 0, 5, 5);
		gbc_lblJ.gridx = 9;
		gbc_lblJ.gridy = 3;
		export.add(lblJ, gbc_lblJ);

		JLabel lblK = new JLabel("K");
		GridBagConstraints gbc_lblK = new GridBagConstraints();
		gbc_lblK.insets = new Insets(0, 0, 5, 5);
		gbc_lblK.gridx = 10;
		gbc_lblK.gridy = 3;
		export.add(lblK, gbc_lblK);

		JLabel lblL = new JLabel("L");
		GridBagConstraints gbc_lblL = new GridBagConstraints();
		gbc_lblL.insets = new Insets(0, 0, 5, 5);
		gbc_lblL.gridx = 11;
		gbc_lblL.gridy = 3;
		export.add(lblL, gbc_lblL);

		JLabel lblM = new JLabel("M");
		GridBagConstraints gbc_lblM = new GridBagConstraints();
		gbc_lblM.insets = new Insets(0, 0, 5, 0);
		gbc_lblM.gridx = 12;
		gbc_lblM.gridy = 3;
		export.add(lblM, gbc_lblM);

		textFieldN = new JTextField();
		GridBagConstraints gbc_textFieldN = new GridBagConstraints();
		gbc_textFieldN.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldN.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldN.gridx = 0;
		gbc_textFieldN.gridy = 4;
		export.add(textFieldN, gbc_textFieldN);
		textFieldN.setColumns(10);

		textFieldO = new JTextField();
		GridBagConstraints gbc_textFieldO = new GridBagConstraints();
		gbc_textFieldO.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldO.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldO.gridx = 1;
		gbc_textFieldO.gridy = 4;
		export.add(textFieldO, gbc_textFieldO);
		textFieldO.setColumns(10);

		textFieldP = new JTextField();
		GridBagConstraints gbc_textFieldP = new GridBagConstraints();
		gbc_textFieldP.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldP.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldP.gridx = 2;
		gbc_textFieldP.gridy = 4;
		export.add(textFieldP, gbc_textFieldP);
		textFieldP.setColumns(10);

		textFieldQ = new JTextField();
		GridBagConstraints gbc_textFieldQ = new GridBagConstraints();
		gbc_textFieldQ.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldQ.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldQ.gridx = 3;
		gbc_textFieldQ.gridy = 4;
		export.add(textFieldQ, gbc_textFieldQ);
		textFieldQ.setColumns(10);

		textFieldR = new JTextField();
		GridBagConstraints gbc_textFieldR = new GridBagConstraints();
		gbc_textFieldR.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldR.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldR.gridx = 4;
		gbc_textFieldR.gridy = 4;
		export.add(textFieldR, gbc_textFieldR);
		textFieldR.setColumns(10);

		textFieldS = new JTextField();
		GridBagConstraints gbc_textFieldS = new GridBagConstraints();
		gbc_textFieldS.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldS.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldS.gridx = 5;
		gbc_textFieldS.gridy = 4;
		export.add(textFieldS, gbc_textFieldS);
		textFieldS.setColumns(10);

		textFieldT = new JTextField();
		GridBagConstraints gbc_textFieldT = new GridBagConstraints();
		gbc_textFieldT.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldT.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldT.gridx = 6;
		gbc_textFieldT.gridy = 4;
		export.add(textFieldT, gbc_textFieldT);
		textFieldT.setColumns(10);

		textFieldU = new JTextField();
		GridBagConstraints gbc_textFieldU = new GridBagConstraints();
		gbc_textFieldU.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldU.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldU.gridx = 7;
		gbc_textFieldU.gridy = 4;
		export.add(textFieldU, gbc_textFieldU);
		textFieldU.setColumns(10);

		textFieldV = new JTextField();
		GridBagConstraints gbc_textFieldV = new GridBagConstraints();
		gbc_textFieldV.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldV.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldV.gridx = 8;
		gbc_textFieldV.gridy = 4;
		export.add(textFieldV, gbc_textFieldV);
		textFieldV.setColumns(10);

		textFieldW = new JTextField();
		GridBagConstraints gbc_textFieldW = new GridBagConstraints();
		gbc_textFieldW.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldW.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldW.gridx = 9;
		gbc_textFieldW.gridy = 4;
		export.add(textFieldW, gbc_textFieldW);
		textFieldW.setColumns(10);

		textFieldX = new JTextField();
		GridBagConstraints gbc_textFieldX = new GridBagConstraints();
		gbc_textFieldX.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldX.gridx = 10;
		gbc_textFieldX.gridy = 4;
		export.add(textFieldX, gbc_textFieldX);
		textFieldX.setColumns(10);

		textFieldY = new JTextField();
		GridBagConstraints gbc_textFieldY = new GridBagConstraints();
		gbc_textFieldY.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldY.gridx = 11;
		gbc_textFieldY.gridy = 4;
		export.add(textFieldY, gbc_textFieldY);
		textFieldY.setColumns(10);

		textFieldZ = new JTextField();
		GridBagConstraints gbc_textFieldZ = new GridBagConstraints();
		gbc_textFieldZ.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldZ.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldZ.gridx = 12;
		gbc_textFieldZ.gridy = 4;
		export.add(textFieldZ, gbc_textFieldZ);
		textFieldZ.setColumns(10);

		JLabel lblN = new JLabel("N");
		GridBagConstraints gbc_lblN = new GridBagConstraints();
		gbc_lblN.insets = new Insets(0, 0, 0, 5);
		gbc_lblN.gridx = 0;
		gbc_lblN.gridy = 5;
		export.add(lblN, gbc_lblN);

		JLabel lblO = new JLabel("O");
		GridBagConstraints gbc_lblO = new GridBagConstraints();
		gbc_lblO.insets = new Insets(0, 0, 0, 5);
		gbc_lblO.gridx = 1;
		gbc_lblO.gridy = 5;
		export.add(lblO, gbc_lblO);

		JLabel lblP = new JLabel("P");
		GridBagConstraints gbc_lblP = new GridBagConstraints();
		gbc_lblP.insets = new Insets(0, 0, 0, 5);
		gbc_lblP.gridx = 2;
		gbc_lblP.gridy = 5;
		export.add(lblP, gbc_lblP);

		JLabel lblQ = new JLabel("Q");
		GridBagConstraints gbc_lblQ = new GridBagConstraints();
		gbc_lblQ.insets = new Insets(0, 0, 0, 5);
		gbc_lblQ.gridx = 3;
		gbc_lblQ.gridy = 5;
		export.add(lblQ, gbc_lblQ);

		JLabel lblR = new JLabel("R");
		GridBagConstraints gbc_lblR = new GridBagConstraints();
		gbc_lblR.insets = new Insets(0, 0, 0, 5);
		gbc_lblR.gridx = 4;
		gbc_lblR.gridy = 5;
		export.add(lblR, gbc_lblR);

		JLabel lblS = new JLabel("S");
		GridBagConstraints gbc_lblS = new GridBagConstraints();
		gbc_lblS.insets = new Insets(0, 0, 0, 5);
		gbc_lblS.gridx = 5;
		gbc_lblS.gridy = 5;
		export.add(lblS, gbc_lblS);

		JLabel lblT = new JLabel("T");
		GridBagConstraints gbc_lblT = new GridBagConstraints();
		gbc_lblT.insets = new Insets(0, 0, 0, 5);
		gbc_lblT.gridx = 6;
		gbc_lblT.gridy = 5;
		export.add(lblT, gbc_lblT);

		JLabel lblU = new JLabel("U");
		GridBagConstraints gbc_lblU = new GridBagConstraints();
		gbc_lblU.insets = new Insets(0, 0, 0, 5);
		gbc_lblU.gridx = 7;
		gbc_lblU.gridy = 5;
		export.add(lblU, gbc_lblU);

		JLabel lblV = new JLabel("V");
		GridBagConstraints gbc_lblV = new GridBagConstraints();
		gbc_lblV.insets = new Insets(0, 0, 0, 5);
		gbc_lblV.gridx = 8;
		gbc_lblV.gridy = 5;
		export.add(lblV, gbc_lblV);

		JLabel lblW = new JLabel("W");
		GridBagConstraints gbc_lblW = new GridBagConstraints();
		gbc_lblW.insets = new Insets(0, 0, 0, 5);
		gbc_lblW.gridx = 9;
		gbc_lblW.gridy = 5;
		export.add(lblW, gbc_lblW);

		JLabel lblX = new JLabel("X");
		GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.insets = new Insets(0, 0, 0, 5);
		gbc_lblX.gridx = 10;
		gbc_lblX.gridy = 5;
		export.add(lblX, gbc_lblX);

		JLabel lblY = new JLabel("Y");
		GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.insets = new Insets(0, 0, 0, 5);
		gbc_lblY.gridx = 11;
		gbc_lblY.gridy = 5;
		export.add(lblY, gbc_lblY);

		JLabel lblZ = new JLabel("Z");
		GridBagConstraints gbc_lblZ = new GridBagConstraints();
		gbc_lblZ.gridx = 12;
		gbc_lblZ.gridy = 5;
		export.add(lblZ, gbc_lblZ);
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
		Ciphers.testPlaintext = Ciphers
				.punctuationSeperator(Ciphers.exampleText[random.nextInt(Ciphers.exampleText.length)])[0];
		if (!Ciphers.difficulty.equals("Easy")) {
			String plaintextOptions[] = new String[10];
			for (int i = 0; i < plaintextOptions.length; i++) {
				plaintextOptions[i] = Ciphers
						.punctuationSeperator(Ciphers.exampleText[random.nextInt(Ciphers.exampleText.length)])[0];
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
				if (Ciphers.testCipher.equals("Rotational")) {
					instructions.setText("Please " + encipher + " this text in " + Ciphers.testCipher
							+ ", with a magnitude of " + Ciphers.adder + ".");
				}
			}
		} else {
			instructions.setText("Please " + encipher + " this text, written in " + Ciphers.testCipher + ".");
		}
		startButton.setText("Check");
		System.out.println(Ciphers.testCipher + ": " + Ciphers.testPlaintext + "-->" + Ciphers.testCiphertext);
		Ciphers.tasksCompleted++;
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
				Ciphers.testRunning = true;
				Ciphers.tasksCompleted = 0;
				String[] difficulties = { "Easy", "Medium", "Hard" };
				Ciphers.difficulty = (String) JOptionPane.showInputDialog(frame, "Set difficulty", "Set difficulty",
						JOptionPane.PLAIN_MESSAGE, null, difficulties, "Easy");
				boolean success = true;
				while (success) {
					success = false;
					try {
						Ciphers.numberOfTasks = Integer
								.parseInt(JOptionPane.showInputDialog(frame, "How many tasks do you want?"));
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(frame, "Please enter a number, not letters.", "Invalid input",
								JOptionPane.ERROR_MESSAGE);
						success = true;
					}
				}
				nextTask();
			} else if (startButton.getText().equals("Check")) {
				if ((Ciphers.punctuationSeperator(outputFromUser.getText())[0].equals(Ciphers.testPlaintext)
						&& !Ciphers.encipher)
						|| (Ciphers.punctuationSeperator(outputFromUser.getText())[0].equals(Ciphers.testCiphertext)
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
				System.out.println(Ciphers.tasksCompleted + "/" + Ciphers.numberOfTasks);
				if (Ciphers.tasksCompleted < Ciphers.numberOfTasks) {
					nextTask();
				} else {
					startButton.setText("Start");
					JOptionPane.showMessageDialog(frame,
							"Number of tasks completed correctly: " + Ciphers.tasksCorrect + "/" + Ciphers.numberOfTasks
									+ "\nAccuracy: " + ((double) (Ciphers.tasksCorrect / Ciphers.numberOfTasks) * 100),
							"Results", JOptionPane.PLAIN_MESSAGE);
					Ciphers.testRunning = false;
				}
			}
		} else if (event.getSource() == finish) {

			while (Ciphers.emptyCipher < 16 && !Ciphers.namesOfCiphers[Ciphers.emptyCipher].equals("")) {
				Ciphers.emptyCipher++;
			}
			if (Ciphers.emptyCipher == 16) {
				String[] customCiphers = new String[6];
				for (int i = 0; i < customCiphers.length; i++) {
					customCiphers[i] = Ciphers.namesOfCiphers[i + 10];
				}
				String cipherToErase = null;
				while (cipherToErase == null) {
					cipherToErase = (String) JOptionPane.showInputDialog(frame, "Which cipher would you like to erase?",
							"Too many ciphers", JOptionPane.PLAIN_MESSAGE, null, customCiphers, customCiphers[0]);
				}
				for (int i = 10; i < customCiphers.length; i++) {
					if (customCiphers[i].equals(cipherToErase)) {
						Ciphers.emptyCipher = i;
					}
				}
			}
			Ciphers.namesOfCiphers[Ciphers.emptyCipher] = JOptionPane.showInputDialog(frame,
					"What would you like to call your cipher?");
			if (plainFormat.getText().equals("")
					|| plainFormat.getText().equals("a;b;c;d;e;f;g;h;i;j;k;l;m;n;o;p;q;r;s;t;u;v;w;x;y;z;")) {
				plainFormat.setText(textFieldA.getText() + ";" + textFieldB.getText() + ";" + textFieldC.getText() + ";"
						+ textFieldD.getText() + ";" + textFieldE.getText() + ";" + textFieldF.getText() + ";"
						+ textFieldG.getText() + ";" + textFieldH.getText() + ";" + textFieldI.getText() + ";"
						+ textFieldJ.getText() + ";" + textFieldK.getText() + ";" + textFieldL.getText() + ";"
						+ textFieldM.getText() + ";" + textFieldN.getText() + ";" + textFieldO.getText() + ";"
						+ textFieldP.getText() + ";" + textFieldQ.getText() + ";" + textFieldR.getText() + ";"
						+ textFieldS.getText() + ";" + textFieldT.getText() + ";" + textFieldU.getText() + ";"
						+ textFieldV.getText() + ";" + textFieldW.getText() + ";" + textFieldX.getText() + ";"
						+ textFieldY.getText() + ";" + textFieldZ.getText() + ";");
			}
			Ciphers.ciphers[Ciphers.emptyCipher - 5] = plainFormat.getText().split(";");
			ciphers_selectCipher1.removeAllItems();
			ciphers_selectCipher2.removeAllItems();
			database_selectCiphers.removeAllItems();
			for (int i = 0; i < Ciphers.namesOfCiphers.length; i++) {
				ciphers_selectCipher1.addItem(makeObj(Ciphers.namesOfCiphers[i]));
				ciphers_selectCipher2.addItem(makeObj(Ciphers.namesOfCiphers[i]));
				database_selectCiphers.addItem(makeObj(Ciphers.namesOfCiphers[i]));
				// TODO Cipher comboboxes not updating
			}
		}
	}

	private Object makeObj(final String item) {
		return new Object() {
			public String toString() {
				return item;
			}
		};
	}
}