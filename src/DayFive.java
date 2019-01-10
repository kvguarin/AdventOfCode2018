import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DayFive {
	// this is a class
	private StringBuilder string = new StringBuilder();

	/**
	 * Parses through the file and saves the contents into a StringBuilder
	 * 
	 * @param file
	 */
	public void makeString(File file) {
		BufferedReader reader;

		String line;
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

		System.out.println(this.string);
		return;
	}

	/**
	 * Parses the string builder and removes the polymers so that no capital
	 * letter is next to it's lower case version of itself
	 */
	public void parseString(int first) {
		Boolean done = true; // checks to see if no stripping of the string was
		
		if(first < this.string.length() -1 ){

//			System.out.println(this.string.length());
			if (checkLetters(this.string.substring(first, first + 2))) {
				// First two letters are a match (Aa or aA), so then it will remove the first
				// two letters
				this.string.delete(first, first + 2);
				done = false;
			}
//			System.out.println(this.string);
			parseString(first + 1);
			
		}
		
		if (done){
			return;
		}
		parseString(0);

//		// Returns if there are no capital/lower case later that is next to one
//		// another
//		if (done) {
//			return;
//		} else {
////			parseString();
//		}
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
		if ( 32 == Math.abs(a-b)) {
			return true;
		}
		return false;
	}
	
	
	public void print(){
		System.out.println(this.string);
	}

}
