import java.awt.RenderingHints.Key;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/*
 * Written by Kylie Guarin
 * See: https://adventofcode.com/2018/day/2
 */

public class DayTwo {

	int twice = 0;
	int thrice = 0;

	/*
	 * Opens the file, and goes line by line and reads it
	 */
	public void parseFile(File txtFile) {

		BufferedReader in;

		try {
			in = new BufferedReader(new FileReader(txtFile));
			String id;
			TreeMap<Character, Integer> freqMap = new TreeMap<Character, Integer>();

			while ((id = in.readLine()) != null) {
				// adds each letter to freqMap
				// then calculates the check sum
				// will iterate values twice and thrice
				addLetters(id, freqMap);
				checkSum(freqMap);
				freqMap.clear(); // clears map for next line
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
	public void addLetters(String id, TreeMap<Character, Integer> freqMap) {
		System.out.println("the id is " + id);
		for (int i = 0; i < id.length(); i++) {
			if (freqMap.containsKey(id.charAt(i))) {
				freqMap.put(id.charAt(i), freqMap.get(id.charAt(i)) + 1);
			} else {
				freqMap.put(id.charAt(i), 1);
			}
		}
	}

	/*
	 * Goes through freqMap and counts number of letters that appear twice or
	 * appear three times. Then, will calculate the checksum by multiplying
	 * these two numbers together. If two letters appears twice/thrice, will
	 * only iterate twice/thrice once.
	 */
	public void checkSum(TreeMap<Character, Integer> freqMap) {

		Boolean doubleLetter = false;
		Boolean trippleLetter = false;
		Integer value;

		for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
			value = entry.getValue();
			if (value == 2) {
				if (!doubleLetter) {
					twice++;
					doubleLetter = true;
				}
			} else if (value == 3) {
				if (!trippleLetter) {
					thrice++;
					trippleLetter = true;
				}
			}
		}
	}

}
