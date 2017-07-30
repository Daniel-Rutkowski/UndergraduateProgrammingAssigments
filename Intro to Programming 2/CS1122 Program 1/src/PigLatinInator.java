
/**
 * This program translates English words and strings into pig Latin.
 * 
 * Date Last Modified: 01 / 21 / 2017
 * 
 * @author Daniel Rutkowski
 *
 *         CS1122, Spring 2017
 */

public class PigLatinInator implements PigLatinAble {

	@Override
	public String pigLatinify(String text) {
		text = text.trim();
		String[] temp = text.split(" "); // array of each word in text
		String[] newString = new String[temp.length]; // array of strings to be translated
		for (int i = 0; i < temp.length; i++) {
			newString[i] = pigLatinifyWord(temp[i]);
		}
		String result = "";
		result = newString[0]; // string to be filled with the values of newString
		for (int i = 1; i < newString.length; i++) {
			result += " " + newString[i];
		}
		return result;
	}

	@Override
	public String pigLatinifyWord(String word) {
		if (word.isEmpty()) {
			return "";
		}
		char firstLetter = word.charAt(0); // first letter of the word
		char[] temp = word.toCharArray(); // array of each letter of the word
		if (temp[0] == 'a' || temp[0] == 'e' || temp[0] == 'i' || temp[0] == 'o' || temp[0] == 'u') {
			for (int i = 1; i < temp.length; i++) {
				if (temp[i] == ' ') {
					return null;
				}
			}
			String result1 = String.valueOf(temp) + "way"; // the translated word that starts with a vowel
			return result1;

		} else {
			for (int i = 1; i < temp.length; i++) {
				if (temp[i] == ' ') {
					return null;
				} else {
					temp[i - 1] = temp[i];
				}
			}
			temp[temp.length - 1] = firstLetter;
			String result2 = String.valueOf(temp) + "ay"; // the translated word that starts with a consonants
			return result2;
		}
	}

	public static void main(String[] args) {

		PigLatinInator test = new PigLatinInator();
		System.out.println(test.pigLatinifyWord("thanksgiving"));
		System.out.println(test.pigLatinifyWord("eat"));
		System.out.println(test.pigLatinifyWord("fat man"));
		System.out.println(test.pigLatinify("cat man fan dan an"));
		System.out.println(test.pigLatinify(" cat man fan dan an"));
	}

}
