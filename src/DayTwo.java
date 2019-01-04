import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

/*
 * Written by Kylie Guarin
 * See: https://adventofcode.com/2018/day/2
 */

public class DayTwo {

	TreeMap<String, Integer> freqMap = new TreeMap<String, Integer>();

	/*
	 * Opens the file, and goes line by line and reads it
	 */
	public void parseFile(File txtFile) {

		BufferedReader in;

		try {
			in = new BufferedReader(new FileReader(txtFile));
			String st;
			while ((st = in.readLine()) != null) {
				//
				// frequency += Integer.parseInt(st);
			}
			in.close();

		} catch (FileNotFoundException e) {

			System.out.println("File not Found");
			e.printStackTrace();

		} catch (IOException e) {

			System.out.println("Unhandeled IO Exception");
			e.printStackTrace();
		}

	}

	/*
	 * Goes through each letter in one id and adds each letter into freqMap. If
	 * letter is not in freqMap, then it will add the letter and initialize the
	 * value to 1. If letter is in freqMap, then it will increment the value by
	 * 1.
	 */
	public void addLetters(String id) {

	}

	/*
	 * Goes through freqMap and counts number of letters that appear twice or
	 * appear three times. Then, will calculate the checksum by multiplying
	 * these two numbers together.
	 */
	public void checkSum() {
		int twice;
		int thrice;

	}

}
