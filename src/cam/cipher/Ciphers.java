package cam.cipher;

import javax.swing.JOptionPane;
import java.util.Random;

public class Ciphers {

	// TODO Do MASSIVE bug testing.

	// TODO Put comments everywhere in Window class

	// TODO Allow ciphering between non-letters and vatsyayana

	// The string array below contains all the explanations of different
	// ciphers. It is formatted like this: {Title, Explanation, Usage}.
	public static final String[][] cipherInfo = {
			{ "Plaintext", "This is the name for text that is not enciphered, i.e. readable.",
					"This is the name for text that is not enciphered, i.e. readable." },
			{ "Number cipher",
					"This cipher converts letters to numbers corresponding to their place in the alphabet. For example, 1 stands for A, 2 stands for B, and so on.",
					"This is one of the easiest ciphers and one of the first that children learn." },
			{ "Rotational cipher",
					"This cipher rotates all letters a certain number of places in the alphabet. A ROT-1 cipher would change A to B, B to C, and so on until Z to A.",
					"This is a common cipher used in puzzle books or mystery novels." },
			{ "Reverse cipher",
					"This cipher substitutes all letters with their reverse, so A and Z switch places, B and Y switch, and so on.",
					"This is a common cipher used in puzzle books or mystery novels." },
			{ "Half-reverse cipher",
					"This cipher is laid out with the first 13 letters directly above the last 13, so A = N, B = O, and so on. These are reversed also, so N = A, O = B etc.",
					"This is a common cipher used in puzzle books or mystery novels." },
			{ "NATO Phonetic Alphabet",
					"This replaces all letters with a fixed word with the letter as its inital. For example, A = Alfa, B = Bravo.",
					"This is used in the Air Force as a means of communicating critcal codes regardless of the quality of the communication channel." },
			{ "Morse Code", "This replaces letters with a series of dots and dashes.",
					"This is not a code, but was used in the early days of radios." },
			{ "Vatsyayana cipher",
					"This pairs up random letters to decipher into one another, for example Z could pair up with H, meaning H = Z and Z = H.",
					"This was used in Ancient India for women to send secret messages to attractive men without their wives finding out." },
			{ "Keyword cipher",
					"This is like the Vatsyayana cipher, but the letters do not decipher into another. If H = Z, Z doesn't have to = H. Also, the use of a keyword in the code helps it to be easy to remember. Simply write out the keyword without repeating a letter, then follow the alphabet to fill in all the letters you haven't written yet. For example, 'I love brussels sprouts' would become ILOVEBRUSPTWXYZACDFGHJKMNQ, and A = I, B = L, and so on.",
					"This was used as a more secure and easy to remember approach to ensure messages are private." },
			{ "Vigenere cipher",
					"This cipher uses multiple rotational ciphers. It employs the use of a passphrase that determines what each letter is cycled through.",
					"This was used during the American Civil War. It remained unbreakable for 3 centuries after it being invented." } };

	// The 2D array below displays all the known substitution ciphers.
	public static final String[][] ciphers = {
			{ "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
					"v", "w", "x", "y", "z" },
			{ "Alfa", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliett", "Kilo",
					"Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform",
					"Victor", "Whiskey", "X-ray", "Yankee", "Zulu" },
			{ ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
					".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." },
			{ "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
					"V", "W", "X", "Y", "Z" },
			{ "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" },
			{ "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" },
			{ "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" },
			{ "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" },
			{ "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" },
			{ "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
					"" } };

	public static final String[] namesOfCiphers = { "Plaintext", "Number", "Rotational", "Reverse", "Half-reverse",
			"NATO Phonetic", "Morse Code", "Vatsyayana", "Keyword", "Vigenere", "", "", "", "", "", "" };

	public static final String[] exampleText = { "Humans have a long period of development after birth",
			"Their life depends less on instinct than other animals, and more on learning",
			"Humans are also born with their brains not so well developed as those of other mammals",
			"This makes for an unusually long childhood, and this which makes family life important",
			"There is a good reason for this",
			"If their brains were better developed they would be larger, and this would make birth more difficult",
			"In birth, the baby's head has to get through the 'birth canal', a passageway through the mother's pelvis",
			"Many animals use signs and sounds to communicate with each other",
			"But humans have a complex system called language", "It allows them to express ideas by using words",
			"Humans are capable of making abstract ideas and communicating them to others",
			"Human language can express things that are not present, or talk about events that are not happening at that time",
			"The things might be elsewhere, and the events may also have occurred at another place or time",
			"No known animals have a system of communication that is as elaborate as human language",
			"By using words to communicate with each other, humans make complex communities with laws, traditions and customs",
			"Humans like to understand the world around them",
			"They try to explain things through myth, science and philosophy",
			"Wanting to understand things has helped many humans make important discoveries",
			"Humans are the only species living today known to build fires, to cook their food and wear clothes",
			"Humans use more technology than any other animal on Earth ever has",
			"Humans like things that are beautiful and like to make art, literature and music",
			"Humans use education and teaching to pass on skills, ideas and customs to the next generations",
			"Humans are part of the animal kingdom",
			"They are mammals, which means that they give birth to their young ones, rather than laying eggs like reptiles or birds, and females feed their babies with breast milk",
			"Humans belong to the order of primates", "Apes like gorillas and orangutans are also primates",
			"The closest living relatives of humans are the two chimpanzee species: the common chimpanzee and the bonobo",
			"Scientists have examined the genes of humans and chimpanzees, and compared their DNA",
			"The studies showed that nine five per cent to nine nine per cent of the DNA of humans and chimpanzees is the same",
			"Biologists explain the similarity between humans and other apes by their descent from a common ancestor",
			"In two zero zero one, a hominid skull was discovered in Chad",
			"The skull is about seven million years old, and has been classified as Sahelanthropus tchadensis",
			"This skull may show that the date at which humans started to evolve (develop differently) from other primates is two million years earlier than scientists had previously thought",
			"Humans are part of a subfamily called the Homininae (or hominins), inside the hominids or great apes",
			"Long ago, there used to be other types of hominins on Earth",
			"They were like modern humans, but not the same",
			"Homo sapiens are the only type of hominins who are alive today",
			"The earliest known fossils of genus Homo have been called Homo habilis (handy man)",
			"The first fossils of Homo habilis were found in Tanzania",
			"Homo hablilis is thought to have lived about two .two to one .seven million years ago",
			"Another human species thought to be an ancestor of the modern human is Homo erectus",
			"There are other extinct species of Homo known today",
			"Many of them were likely our 'cousins', as they developed differently than our ancestors",
			"A theory called the Sahara pump theory has been used to tell how different species of plants and animals moved from Africa to the Middle East, and then elsewhere",
			"Early humans may have moved from Africa to other parts of the world in the same way",
			"The first truly modern humans seem to have appeared between two zero zero, zero zero zero and one three zero, zero zero zero years ago",
			"These early humans later moved out from Africa",
			"By about nine zero, zero zero zero years ago they had moved into Eurasia and the Middle East",
			"This was the area where Neanderthals, Homo neanderthalensis, had been living for a long time (at least three five zero, zero zero zero years)",
			"By about four two to four four, zero zero zero years ago Homo sapiens had reached western Europe, including Britain",
			"In Europe and western Asia, Homo sapiens replaced the neanderthals by about three five, zero zero zero years ago",
			"The details of this event are not known", "At roughly the same time Homo sapiens arrived in Australia",
			"Their arrival in the Americas was much later, about one five, zero zero zero years ago",
			"All these earlier groups of modern man were hunter-gatherers",
			"Early human history is commonly divided into three ages",
			"The time periods are labeled with the material used for tools",
			"The Stone Age The Bronze Age The Iron Age",
			"The Stone Age is commonly subdivided into the Paleolithic, Mesolithic, and Neolithic periods",
			"Up to about one zero thousand years ago most humans were hunter-gatherers",
			"They did not live in one place, but moved around as the seasons changed",
			"The start of planting crops for food, called farming made the Neolithic revolution",
			"Some people chose to live in settlements",
			"This also led to the invention of metal tools and the training of animals",
			"About six zero zero zero years ago the first proper civilizations began in places like Egypt, India, and Syria",
			"The people formed governments and armies for protection",
			"They competed for area to live and resources and sometimes they fought with each other",
			"About four zero zero zero years ago some states took over or conquered other states and made empires",
			"Examples include ancient Greece and the Roman Empire",
			"Some modern day religions also began at this time such as Judaism and Hinduism",
			"From the Middle Ages and beyond humanity saw an explosion of new technology and inventions",
			"The printing press, the car, the train, and electricity are all examples of this kind of invention",
			"As a result of the developments in technology, modern humans live in a world where everyone is connected, for example by telephone or by internet",
			"People now control and change the environment around them in many different ways",
			"In early times, humans usually settled near to water and other natural resources",
			"In modern times if people need things they can transport them from somewhere else",
			"So basing a settlement close to resources is no longer as important as it once was",
			"Since one eight zero zero, the number of humans, or population, has increased by six billion",
			"Most humans (six one per cent ) live in Asia",
			"The rest live in the Americas (one four per cent ), Africa (one four per cent ), Europe (one one per cent ), and Oceania (zero .five per cent )",
			"Most people live in towns and cities", "This number is expected to get higher",
			"In two zero zero five the United Nations said that by the end of that year, over half the world would be living in cities",
			"This is an important change in human settlement patterns: a century earlier in one nine zero zero only one four per cent of people lived in cities, in two zero zero zero four seven per cent of the world's population lived in cities",
			"In developed countries, like the United States, eight zero per cent of the population live in cities",
			"Humans have a large effect on the world",
			"Humans are at the top of the food chain and are generally not eaten by any animals",
			"Humans have been described as super predators because of this",
			"Because of industry and other reasons humans are said to be a big cause of global climate change",
			"Human body types can be very different from each other",
			"The average height of an adult human is between five and six feet",
			"The average weight is between seven six and eight three kg for males and five four –six four kg for females",
			"Human longer hair grows on the underarms, the genitals, and the top of the head in adults of both genders, and on the legs and face of all adult males, and on the chest and back of many adult males",
			"In human children of both genders, long hair grows only on the top of the head",
			"Although it might look like humans have fewer hairs than most primates, they actually do not",
			"The average human has more hair follicles, where hair grows from, than most chimpanzees have",
			"Human hair can be brown, red, blond, or most commonly, black",
			"Modern humans can also have their hair in many different colors by using dye",
			"When humans get older hair can turn grey or even white", "Human skin colors vary greatly",
			"They can be a very pale pink all the way to dark brown",
			"There is a reason why people in tropical areas have dark skins",
			"The dark pigment (melanin) in the skin protects them against ultraviolet rays in sunlight",
			"The damage caused by UV rays can and does cause skin cancer in some people",
			"Therefore, natural selection favors darker skin color",
			"Sun tanning has nothing to do with this issue, because it is just a temporary process which is not inherited",
			"In colder climates the advantage of light-colored skin is that it radiates less heat",
			"Humans are not as strong as other primates of the same size",
			"An average female orangutan is at least three times as strong as an average human man",
			"The average human male needs seven to eight hours sleep a day",
			"People who sleep less than this are generally not as healthy",
			"A child needs more sleep, nine to one zero hours on average",
			"The human life cycle is quite like most other mammals",
			"The young grow inside the female mother for nine months",
			"After this time the baby is pushed out of the woman's vagina",
			"Unlike most other animals, human childbirth is somewhat dangerous",
			"Because human brains are so big, babies' heads are wide",
			"The mothers pelvis bones are also not very wide because people walk on two legs",
			"This combination means that sometimes either mother or baby die in childbirth",
			"The number of mothers dying in childbirth is less in the two one st century",
			"This is because of better medication and treatment",
			"In many poor countries the number of mothers dying is higher",
			"Sometimes it is up to one zero times as many as richer countries",
			"The average human baby weighs three – four kg at birth and is five zero –six zero cm tall",
			"This is often less in poorer countries", "Many babies in poor countries often die early because of this",
			"Humans have four stages in their lives: childhood, adolescence, adulthood and old age",
			"Life expectancy is how long you are expected to live for",
			"This depends on many things including where you live",
			"The highest life expectancy is for people from Monaco, eight nine .five two years",
			"The lowest is for people from Chad where life expectancy is only four nine .eight one years",
			"Psychology is the study of how the human mind works",
			"The human brain is the main controller of what a person does",
			"Everything from moving and breathing to thinking is done by the brain",
			"The human neocortex is huge compared with other mammals, and gives us our thinking ability, and the ability to speak and understand language",
			"Neurology is the study of how the brain works, psychology is the study of how and why people think and feel",
			"Many aspects of life are also influenced by the hormone system, including growth and sexual development",
			"The hormonal system (especially the pituitary gland) is partly controlled by the brain",
			"Human behaviour is hard to understand, so sometimes psychologists study animals because they may be simpler and easier to understand",
			"Psychology overlaps with many other sciences including medicine, biology, computer science and linguistics",
			"Language at its most basic is talking, reading and writing", "The study of language is called linguistics",
			"Humans have the most complicated languages on Earth",
			"Although almost all animals communicate, human language is unique",
			"Its use of syntax, and its huge learnt vocabulary are its main features",
			"There are over seven, three zero zero languages spoken around the world",
			"The world's most spoken first language is Mandarin Chinese, and the most spoken language is English",
			"This includes speakers of English as a second language", "Art has existed almost as long as humans",
			"People have been doing some types of art for thousands of years as the picture on the right shows",
			"Art represents how someone feels in the form of a painting, a sculpture or a photograph",
			"Music has also been around for thousands of years",
			"Music can be made with only your voice but most of the time people use instruments",
			"Music can be made using simple instruments only such as simple drums all the way up to electric guitars, keyboards and violins",
			"Music can be loud, fast, quiet, slow or many different styles",
			"Music represents how the people who are playing the music feel",
			"Literature is anything made or written using language",
			"This includes books, poetry, legends, myths and fairy tales",
			"Literature is important as without it many of the things we use today, such as Wikipedia, would not exist",
			"Humans often categorize themselves by race or ethnicity",
			"Human races are questionable as valid biological categories",
			"Human racial categories are based on both ancestry and visible traits such as skin color and facial features",
			"These categories may also carry some information on non-visible biological traits, such as the risk of developing particular diseases such as sickle-cell disease",
			"Current genetic and archaeological evidence generally support a recent single origin of modern humans in East Africa",
			"Current genetic studies show that humans from Africa are most genetically diverse",
			"But, human gene sequences are very similar compared to many other animals",
			"Ethnic groups are often linked by linguistic, cultural, ancestral, and national or regional ties",
			"Race and ethnicity can lead to different social treatment called racism",
			"Religion is a belief of faith in a higher being, spirit, or any system of ideas that a group of people believe in",
			"To have faith in a belief is to have the belief without proof that it is true",
			"Faith can bring people together because they all believe in the same thing",
			"Some of the things religions talk about are what happens after death, why humans exist, how humans came to exist (creation), and what is good to do and not to do (morality)",
			"Some people are very religious",
			"Many people believe in one all-powerful god; some people believe in more than one god; some people are atheists, who do not believe in a god; and some people are agnostics, who are not sure if there is a god",
			"People who believe in one or more gods, but do not belong to a religion, are called deists",
			"Technology are the things and methods which humans use to make tasks easier",
			"Science is understanding how the universe and the things in it work", "Technology used to be quite simple",
			"It was passed on by people telling others, until writing was invented",
			"This allowed technology to develop much quicker",
			"Now people understand more and more about the world and the universe",
			"The use of the telescope by Galileo, Einstein's theory of relativity, lasers, and computing are all scientific discoveries",
			"Technology is of great importance to science, to medicine, and to everyday life",
			"A war is a lethal fight between large groups of people, usually countries or states",
			"A war involves the use of lethal weapons as both sides try to kill the other",
			"It is estimated that during the two zero th century, between one six seven and one eight eight million humans died because of war",
			"The people who fight for a state in wars are called soldiers",
			"The people who fight in wars, but not for a state, are usually called 'fighters'",
			"Modern wars are very different from wars a thousand or even a hundred years ago",
			"Modern war involves sabotage, terrorism, propaganda, and guerrilla warfare",
			"In modern-day wars, civilians (people who are not soldiers) are often targets",
			"An example of this is the nuclear bomb dropped on Hiroshima and Nagasaki at the end of World War II",
			"The bombs killed as many as one four zero, zero zero zero people in Hiroshima and eight zero, zero zero zero in Nagasaki by the end of one nine four five, about half on the days of the bombings",
			"Since then, thousands more have died from wounds or illness because of exposure to radiation released by the bombs",
			"In both cities, the overwhelming majority of the dead were civilians",
			"In Germany, Austria, and Great Britain, conventional bombs were used",
			"About six zero, five nine five British, and five five zero, zero zero zero German, civilians were killed by planes bombing cities." };

	// ciphering variables
	public static String selectedCipher1 = "";
	public static String selectedCipher2 = "";
	public static String textContents = "";
	public static int[] plaintextContents;

	// testing variables
	public static String difficulty;
	public static int numberOfTasks;
	public static int tasksCompleted;
	public static int tasksCorrect;
	public static int adder;
	public static boolean testRunning;
	public static boolean encipher;
	public static String testCipher;
	public static String testPlaintext;
	public static String testCiphertext;

	// create variables
	public static int emptyCipher;

	// This code converts a string of numbers, NATO keywords or Morse code and
	// seperator to an int array.
	public static int[] caster(String text) {
		// Initializes the array to return, and the two ints to help with
		// substrings and slotting the correct numbers into the array.
		int[] result = new int[text.length()];
		for (int i = 0; i < result.length; i++) {
			result[i] = -1;
		}
		int placeInArray = 0;
		int startingPoint = 0;
		String output = "";
		// Goes through entire input string
		switch (selectedCipher1) {
		case "Number":
			for (int i = 0; i < text.length(); i++) {
				// Tries to parse the current character into an int.
				try {
					Integer.parseInt("" + text.charAt(i));
				} catch (NumberFormatException e) {
					// It found a slash, so it slots the characters between the
					// start (or last found slash) and the slash into the next
					// empty
					// place in the array.
					result[placeInArray] = Integer.parseInt(text.substring(startingPoint, i));
					if (result[placeInArray] == 26) {
						result[placeInArray] = 0;
						// Switches the 26s back to 0s for the computer 'z'
					}
					if (result[placeInArray] == 0) {
						result[placeInArray] = -1;
						// Switches the 0s back to -1s for the computer ' '
					}
					placeInArray++;
					startingPoint = i + 1;
				}
			}
			break;
		case "NATO Phonetic":
			// Takes the first letter of every word.
			for (int i = 0; i < text.length(); i++) {
				if ((text.charAt(i) == ' ' || text.charAt(i) == '.') && i != text.length() - 1) {
					output += text.charAt(i + 1);
				}

			}
			result = inputToPlaintext(output.toLowerCase());
			break;
		case "Morse Code":
			// Finds characters between two slashes and compares them to the
			// list of morse code letters.
			text = text.replaceAll("///", "//");
			for (int i = 1; i < text.length(); i++) {
				if (text.charAt(i) == '/') {
					for (int j = 0; j < ciphers[2].length; j++) {
						if (text.substring(startingPoint + 1, i).equals(ciphers[2][j])) {
							result[placeInArray] = j + 1;
							j = 0;
							placeInArray++;
							if (text.substring(i, i + 2).equals("//")) {
								placeInArray++;
								i++;
							}
							startingPoint = i;
							i++;
						}
					}
				}
			}
		}
		return result;
	}

	// This code removes all punctuation and capital letters.
	public static String[] punctuationSeperator(String text) {
		String[] plaintext = { text.toLowerCase(), text };
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < 26; j++) {
				if (("" + text.charAt(i)).equals(ciphers[0][j])) {
					// If character is a letter, it is set to space.
					plaintext[1] = plaintext[1].substring(0, i) + " " + plaintext[1].substring(i + 1);
					break;
				}
				if (("" + text.charAt(i)).equals(ciphers[3][j])) {
					// If character is a capital letter, it is set to `.
					plaintext[1] = plaintext[1].substring(0, i) + "`" + plaintext[1].substring(i + 1);
					break;
				}
				if (("" + text.charAt(i)).equals(" ")) {
					// If character is a space, it is set to ~.
					plaintext[1] = plaintext[1].substring(0, i) + "~" + plaintext[1].substring(i + 1);
					break;
				}
			}
		}
		return plaintext;
	}

	public static String formatter(String text, String format) {
		for (int i = 0; i < text.length(); i++) {
			if (format.charAt(i) == '~') {
				// If the formatting has a ~, it replaces the character with a
				// space.
				text = text.substring(0, i) + " " + text.substring(i + 1);
			} else if (format.charAt(i) == '`') {
				// If the formatting has a `, it replaces the character with its
				// capital.
				String temp = selectedCipher1;
				selectedCipher1 = "Plaintext";
				text = text.substring(0, i) + ciphers[3][(inputToPlaintext("" + text.charAt(i))[0] + 25) % 26]
						+ text.substring(i + 1);
				selectedCipher1 = temp;
			} else if (format.charAt(i) != ' ') {
				// If the formatting isn't space, ` or ~, then it replaces it.
				text = text.substring(0, i) + format.charAt(i) + text.substring(i + 1);
			}
		}
		return text;
	}

	// The method below converts a string of text to an array of numbers. For
	// example, "hello" would translate to {8, 5, 12, 12, 15}.
	public static int[] inputToPlaintext(String text) {

		int[] cipherNumbers = new int[text.length()];
		for (int i = 0; i < cipherNumbers.length; i++) {
			cipherNumbers[i] = -1;
		}
		int adder = -1;
		int multiplier = 1;
		int type = 0;
		switch (selectedCipher1) {
		case "Rotational":
			try {
				if (testRunning) {
					Random random = new Random();
					adder = random.nextInt(25) + 1;
					Ciphers.adder = adder;
				} else {
					adder = Integer.parseInt(JOptionPane.showInputDialog(Window.frame, "What rotation?")) - 1;
				}
			} catch (NumberFormatException e) {
				adder = -1;
			}
			multiplier = 1;
			type = 0;
			break;
		case "Half-reverse":
			// Shifts variables 13 places forward.
			adder = 12;
			multiplier = 1;
			type = 0;
			break;
		case "Reverse":
			// Changes variables so that the character will be reversed.
			adder = 26;
			multiplier = -1;
			type = 0;
		}
		// Goes through String and finds its place in the ciphers[][] array.
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < 26; j++) {
				if (("" + text.charAt(i)).equals(ciphers[type][j])) {
					cipherNumbers[i] = ((j - adder) * multiplier + 26) % 26;
					break;
				}
			}
		}
		// Characters that are not found are left as -1.
		return cipherNumbers;
	}

	// The method below converts an array of numbers to a string of text. For
	// example, {8, 5, 12, 12, 5) would translate to "hello".
	public static String plaintextToOutput(int[] cipherNumbers) {
		String output = "";
		char zero = ' ';
		int adder = -1;
		int multiplier = 1;
		int type = 0;
		String natoSpace = "";
		String letterBreak = "";
		switch (selectedCipher2) {
		case "Rotational":
			try {
				if (testRunning) {
					Random random = new Random();
					adder = random.nextInt(25) + 1;
					Ciphers.adder = adder;
				} else {
					adder = Integer.parseInt(JOptionPane.showInputDialog(Window.frame, "What rotation?")) - 1;
				}
			} catch (NumberFormatException e) {
				adder = -1;
			}
			break;
		case "Half-reverse":
			// Shifts variables 13 places forward.
			adder = 12;
			break;
		case "Reverse":
			// Changes variables so that the character will be reversed.
			adder = 26;
			multiplier = -1;
			break;
		case "NATO Phonetic":
			// Switches output alphabet to be NATO Phonetic.
			type = 1;
			zero = '.';
			natoSpace = " ";
			break;
		case "Morse Code":
			// Switches output alphabet to be Morse Code.
			type = 2;
			zero = '/';
			letterBreak = "/";
		}
		// Goes through entire int[] array
		for (int i = 0; i < cipherNumbers.length; i++) {
			if (cipherNumbers[i] == -1) {
				// Zeros are interpreted as determined above.
				output = output + zero;
			} else {
				// Adds the corresponding letter.
				output = output + natoSpace + letterBreak
						+ ciphers[type][(multiplier * cipherNumbers[i] + adder + 26) % 26];
			}

		}
		output += letterBreak;
		return output;
	}

	// The method below takes an input and replaces it with the letter paired
	// with it in the decrypter
	public static String vatsyayana(String text, char[] decrypter) {
		String enciphered = "";
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < decrypter.length; j++) {

				// If the character is not a letter, it adds a space.
				boolean found = false;
				for (int k = 0; k < ciphers[0].length; k++) {
					if (text.charAt(i) == ciphers[0][k].toCharArray()[0]) {
						found = true;
					}
				}
				if (!found) {
					enciphered = enciphered + " ";
					break;
				}

				// When character is found in the decrypter array
				if (text.charAt(i) == decrypter[j]) {
					// If it is the first of a pair it changes it to the next,
					// if it is the second it changes to the previous. This is
					// how the 'paired' behaviour works.
					if (j % 2 == 0) {
						enciphered = enciphered + decrypter[j + 1];
					} else {
						enciphered = enciphered + decrypter[j - 1];
					}
				}
			}
		}
		return enciphered;
	}

	// The method below takes a keyword, removes all duplicates and adds the
	// rest of the alphabet on the end.
	public static String keywordGen(String key) {
		// Makes keyphrase lowercase and removes spaces
		key = key.toLowerCase();
		key = key.replaceAll(" ", "");

		// Records character to remove duplicates of, removes all instances of
		// it, then adds the first one back in. Does for all characters.
		for (int i = 0; i < key.length(); i++) {
			char charToReplace = key.charAt(i);
			key = key.replaceAll("" + charToReplace, "");
			key = key.substring(0, i) + charToReplace + key.substring(i);
		}

		boolean letterFound = false;
		// endOfAlphabet records where the keyword ends. This ensures rest of
		// key is generated from the last letter, not from the start of the
		// alphabet. The int is constant.
		int endOfAlphabet = inputToPlaintext("" + key.charAt(key.length() - 1))[0];

		for (int i = endOfAlphabet; i < 26 + endOfAlphabet; i++) {
			for (int j = 0; j < key.length(); j++) {
				letterFound = ("" + key.charAt(j)).equals(ciphers[0][i % 26]);
				if (letterFound) {
					// If letter is found, it moves on to the next letter.
					break;
				}
			}
			if (!letterFound) {
				// If letter is never found, it adds it to the end.
				key = key + ciphers[0][i % 26];
			}
		}
		return key;
	}

	// Converts the keyword generated using keyGen(String key) to a keyword that
	// will reverse its effects.
	public static String keyReversal(String key) {
		int[] keyNumbers = inputToPlaintext(key);
		// Ensures there are no negative values
		for (int i = 0; i < key.length(); i++) {
			keyNumbers[i] = (keyNumbers[i] + 25) % 26;
		}

		// Searches through array and sorts it according to the alphabet.
		int[] reverseNumbers = new int[keyNumbers.length];
		for (int i = 0; i < reverseNumbers.length; i++) {
			for (int j = 0; j < keyNumbers.length; j++) {
				if (keyNumbers[j] == i) {
					reverseNumbers[i] = j + 1;
					break;
				}
			}
		}
		key = plaintextToOutput(reverseNumbers);
		return key;
	}

	// The method below takes plaintext and converts into ciphertext using a
	// keyword.
	public static String keywordCipher(String keyword, String text) {
		int[] cipherNumbers = inputToPlaintext(text);
		String enciphered = "";
		// Scrolls through the message and adds the corresponding letter from
		// the keyword to the final string.
		for (int i = 0; i < cipherNumbers.length; i++) {
			enciphered = enciphered + keyword.charAt((cipherNumbers[i] + 25) % 26);
		}
		return enciphered;
	}

	// The method below switches between ciphertext and plaintext (determined by
	// the boolean encode) using a passphrase.
	public static String vigenere(String passphrase, String text, boolean encode) {
		// Makes the passphrase nice and big.
		passphrase = punctuationSeperator(passphrase)[0];
		passphrase = passphrase.replaceAll(" ", "");
		if (passphrase.equals("")) {
			return text;
		}
		for (int i = 0; i < (text.length() / passphrase.length()) + 1; i++) {
			passphrase += passphrase + passphrase;
			System.out.println(passphrase);
		}
		// Shortens it to the appropriate length.
		passphrase = passphrase.substring(0, text.length());
		int[] passNumbers = inputToPlaintext(passphrase);

		// Prepares it for adding it
		for (int i = 0; i < passNumbers.length; i++) {
			passNumbers[i]++;
		}

		// Determines whether to encode or decode it
		if (!encode) {
			for (int i = 0; i < passNumbers.length; i++) {
				passNumbers[i] = -passNumbers[i];
			}
		}

		// Adds the corresponding letter of the passphrase.
		int[] cipherNumbers = inputToPlaintext(text);
		for (int i = 0; i < cipherNumbers.length; i++) {
			cipherNumbers[i] = (cipherNumbers[i] + passNumbers[i] + 26) % 26;
		}
		text = plaintextToOutput(cipherNumbers);
		return text;
	}
}