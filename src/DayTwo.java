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
	String idLetters = "";
	Boolean idsFound = false;

	/*
	 * Opens the file, and goes line by line and calculates how many letters
	 * appear two or three times.
	 */
	public void findCheckSum(File txtFile) {

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
				if (!doubleLetter) { // Check if other letter appears twice
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

	/*
	 * Goes through the file and finds the two correct box IDs with the common
	 * letters, each box ID differing only by one character
	 */
	public void commonLetters(File txtFile) {
		BufferedReader in;

		try {
			in = new BufferedReader(new FileReader(txtFile));
			String id1;

			while ((id1 = in.readLine()) != null && !idsFound) {
				// TODO: code goes here. need to call second function
				findCommonID(id1, txtFile);
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
	 * Takes one box ID and finds the boxID that differs by only one letter. If
	 * it finds it, then it will return the two IDs
	 */
	public void findCommonID(String id1, File txtFile) {
		BufferedReader in;

		try {
			in = new BufferedReader(new FileReader(txtFile));
			String id2;

			while ((id2 = in.readLine()) != null && !idsFound) {
				// does nothing if the ids are the same
				if (id1.compareTo(id2) != 0) {

					// compare the two box IDs
					compareIDs(id1, id2);
				}
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
	 * Compares two IDs. If the IDs differ by only one letter, then it prints
	 * out those IDs.
	 */
	public void compareIDs(String id1, String id2) {
		int difference = 0;
		for (int i = 0; i < id1.length(); i++) {
			if (id1.charAt(i) != id2.charAt(i)) {
				difference++;
			}
		}
		if (difference == 1) {
			idsFound = true;
			System.out.println("Box ID One: " + id1);
			System.out.println("Box ID Two: " + id2);
			commonLetters(id1, id2);
		}
	}

	/*
	 * Takes the two box IDs that differ by only one letter and finds the common
	 * letters between the two of them
	 */
	public void commonLetters(String id1, String id2) {
		for (int i = 0; i < id1.length(); i++){
			if (id1.charAt(i) == id2.charAt(i)){
				idLetters+= id1.charAt(i);
			}
		}

	}

}
