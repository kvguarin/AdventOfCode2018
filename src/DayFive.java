import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * @author KyVGuarin
 *
 */
public class DayFive {

	private StringBuilder string; // string of individual
									// polymers

	/**
	 * Parses through the file and saves the contents into a StringBuilder
	 * 
	 * @param file
	 */
	public void makeString(File file) {
		BufferedReader reader;
		String line;
		this.string = new StringBuilder();
		this.string.delete(0, this.string.length());
		try {
			reader = new BufferedReader(new FileReader(file));

			while ((line = reader.readLine()) != null) {
				this.string.append(line);
			}
			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
			e.printStackTrace();

		} catch (IOException e) {
			System.out.println("Unhandeled IO Exception");
			e.printStackTrace();
		}

		return;
	}

	/**
	 * Parses the string builder and removes the polymers so that no capital
	 * letter is next to it's lower case version of itself
	 * 
	 * @param first
	 *            index of first letter
	 */
	/**
	 * @param first
	 */
	public void parseString(int first) {
		Boolean done = true; // checks to see if no stripping of the string was

		for (int i = 0; i < this.string.length() - 1; i++) {
			if (checkLetters(this.string.substring(i, i + 2))) {
				// First two letters are a match (Aa or aA), so then it will
				// remove the first two letters
				this.string.delete(i, i + 2);
				done = false;
				i--; // TODO: check if there is a better way to do this
//				i = 0;
			}
		}

		// Returns if there are no more letters that match that are adjacent to
		// one another
		if (!done) {
			parseString(0);
		}
		return;
	}

	/**
	 * Checks if two letters are the same letter, but one is capitalized and one
	 * is lower case. I they are both the same, then it returns true.
	 * 
	 * @param letters
	 *            two letters that we will be comparing
	 * @return - True or false
	 * 
	 */
	private Boolean checkLetters(String letters) {
		int a = letters.charAt(0);
		int b = letters.charAt(1);
		// if the letters are the same (Aa or aA), then it will return true
		if (32 == Math.abs(a - b)) {
			return true;
		} 
		return false;
	}

	/**
	 * Returns the number of polymers
	 * 
	 * @return
	 */
	public int getCount() {
		return this.string.length();
	}

	/**
	 * Removes all letters that are lowercase or uppercase char a
	 * 
	 * @param a
	 */
	public void removeLetter(int a) {
		String string = this.string.toString();
		string = string.replaceAll(Character.toString((char) a), "");
		string = string.replaceAll(Character.toString((char) (a + 32)), "");
		this.string.replace(0, this.string.length(), string);
		return;
	}

	public void printPolymers() {
		System.out.println(this.string);
	}

}
