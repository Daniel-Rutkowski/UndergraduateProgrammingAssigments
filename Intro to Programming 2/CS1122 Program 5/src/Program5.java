import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Program5 {

	/**
	 * This program runs a 20 question game through a linked binary tree node.
	 * 
	 * Date Last Modified: 04 /21 / 2017
	 * 
	 * @author Daniel Rutkowski
	 *
	 *         CS1122, Spring 2017
	 * 
	 */

	private LinkedBinaryTreeNode<String> root; // the root of the tree
	private int count = 0; // counter to see how many questions have been asked
	private boolean victory = false; // used to trigger a correct guess of an animal

	/**
	 * This method starts and runs the game.
	 */
	public void startUp() {
		root = new Answer<String>("an elephant");
		LinkedBinaryTreeNode<String> current = null; // The current node the game is at

		System.out.println("Welcome to the 20 Question Animal Guessing Game!");
		System.out.println();
		System.out.println("Instructions: Think of an animal and see if the computer can guess it.");
		System.out.println("    For answering questions, input yes or y for yes and no or n for no.");
		System.out.println("    For adding an answer, add an article a or an before the word. (Ex: a cat)");
		System.out.println("    For adding a question, capitalize the first letter and add a question mark at the end. ");
		System.out.println();
		System.out.println("Would you like to play?");

		// This loads in the data for each new game.
		try {
			loadData("tree.data");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// This contains the main logic of the game.
		try (Scanner input = new Scanner(System.in);) {
			String reply1 = input.nextLine();
			current = root;
			while (reply1.equals("y") || reply1.equals("yes")) {
				String reply2 = "";

				// This loop progresses through each question.
				while (current instanceof Question) {
					System.out.println(current.getData());
					reply2 = input.nextLine();
					if (reply2.equals("y") || reply2.equals("yes")) {
						current = (LinkedBinaryTreeNode<String>) current.getRight();
					} else {
						current = (LinkedBinaryTreeNode<String>) current.getLeft();
					}
					count++;
					break;
				}

				// This block of code handles hitting an answer node.
				if (current instanceof Answer) {
					System.out.println("Were you thinking of " + current.getData() + "?");
					String reply3 = input.nextLine();
					if (reply3.equals("y") || reply3.equals("yes")) {
						victory = true;
						break;
					} else {
						System.out.println("Oops. What were you thinking of?");
						String reply4 = input.nextLine();
						System.out.println("What question separates " + reply4 + " from " + current.getData() + "?");
						String reply5 = input.nextLine();
						System.out.println("What is the correct answer for this animal?");
						String reply6 = input.nextLine();
						Question<String> newQuestion = new Question<String>(reply5,
								(Question<String>) current.getParent());
						Answer<String> newAnswer = new Answer<String>(reply4, newQuestion);
						if (current.getParent() == null) {
							root = newQuestion;
						}

						if (reply6.equals("y") || reply6.equals("yes")) {
							newQuestion.setRight(newAnswer);
							newQuestion.setLeft(current);
						} else {
							newQuestion.setLeft(newAnswer);
							newQuestion.setRight(current);
						}
						if (reply2.equals("y") || reply2.equals("yes")) {
							newQuestion.getParent().setRight(newQuestion);
						} else if (reply2.equals("n") || reply2.equals("no")) {
							newQuestion.getParent().setLeft(newQuestion);
						}
						System.out.println("I was not able to guess the animal. You win!");
						System.out.println("Thanks for Playing!");
						break;
					}
				}
			}
		}
		if (victory) {
			System.out.println("Sweet! I got it.");
			System.out.println("I guessed correctly in " + count + " tries.");
			if (count <= 20) {
				System.out.println("I win!");
				System.out.println("Thanks for Playing!");
			} else {
				System.out.println("You win. Good Job!");
				System.out.println("Thanks for Playing!");
			}
		}
		saveData();

	}

	/**
	 * This method saves the data to a data file at the end of the game.
	 */
	private void saveData() {
		try (PrintWriter pwt = new PrintWriter(new File("tree.data"))) {
			root.traversePreorder(new BinaryTreeNode.Visitor() {
				public <E> void visit(BinaryTreeNode<E> node) {
					if (node instanceof Question) {
						pwt.println("Q:" + node.getData());
					} else {
						pwt.println("A:" + node.getData());
					}
				}
			});
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method loads the data in at the beginning of the game.
	 * 
	 * @param filename : The file containing the data of past games
	 */
	private void loadData(String filename) throws FileNotFoundException {
		LinkedBinaryTreeNode<String> current = null; // the current position of
														// the data in the tree
		try (Scanner scan = new Scanner(new File(filename))) {
			scan.useDelimiter("");

			// This loop sets the root the first time
			while (scan.hasNext()) {
				String type = scan.next() + scan.next(); // The type of node the line is
				type = type.substring(0, 1);
				String value = scan.nextLine(); // The value to be put in the node
				if (type.equals("Q")) {
					root = new Question<String>(value, null);
					current = root;
				} else if (type.equals("A")) {
					root = new Answer<String>(value, null);
					current = root;
				}
				break;
			}

			// This loop sets the rest of the tree
			while (scan.hasNext()) {
				String type = scan.next() + scan.next(); // The type of node the line is
				type = type.substring(0, 1);
				String value = scan.nextLine(); // The value to be put in the node

				while (current.hasRight() && current.hasParent()) {
					current = (LinkedBinaryTreeNode<String>) current.getParent();
				}

				if (type.equals("Q")) {
					if (current.getLeft() != null) {
						current.setRight(new Question<String>(value, (Question<String>) current));
						current = (LinkedBinaryTreeNode<String>) current.getRight();
					} else {
						current.setLeft(new Question<String>(value, (Question<String>) current));
						current = (LinkedBinaryTreeNode<String>) current.getLeft();
					}
				} else if (type.equals("A")) {
					if (current.getLeft() != null) {
						current.setRight(new Answer<String>(value, (Question<String>) current));
					} else {
						current.setLeft(new Answer<String>(value, (Question<String>) current));
					}
				}

				if (current == root) {
					if (type.equals("Q")) {
						current.setLeft(new Question<String>(value, (Question<String>) current));
						current = (LinkedBinaryTreeNode<String>) current.getLeft();
					} else if (type.equals("A")) {
						if (current.getLeft() != null) {
							current.setRight(new Answer<String>(value, (Question<String>) current));
						} else {
							current.setLeft(new Answer<String>(value, (Question<String>) current));
						}
					}
				}

			}

		}
	}

	/**
	 * This main method initializes the program.
	 */
	public static void main(String[] args) {
		Program5 game = new Program5();
		game.startUp();
	}

}
