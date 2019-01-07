import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.spi.FileSystemProvider;
import java.util.Map.Entry;

import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.sound.midi.VoiceStatus;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.omg.CORBA.portable.ValueBase;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DayFour {

	private Map<String, String> chronMap = new TreeMap<>(); // chronologically
															// organized file

	// Sorts individual guard Sleep times
	private Map<Integer, Map<Integer, Integer>> guardMap = new TreeMap<>();
	private int worstGuard = 0; // guard that is asleep the most
	private int guardSleepTime = 0; // Number of minutes the worst guard is
									// asleep

	public void organizeFile(File file) {
		BufferedReader reader;

		String line;
		try {
			reader = new BufferedReader(new FileReader(file));

			while ((line = reader.readLine()) != null) {
				addEntry(line);
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

	/*
	 * Adds each line from the file into the map in order to organize the shifts
	 * in chronological order
	 */
	private void addEntry(String line) {
		String[] line2 = line.split("]");
		chronMap.put(line2[0] + "]", line2[1]);

	}

	/*
	 * Prints the contents of the map
	 */
	public void printMap() {
		for (Map.Entry<String, String> entry : chronMap.entrySet()) {
			System.out.print(entry.getKey());
			System.out.println(entry.getValue());
		}
	}

	/*
	 * Organizes the information of the guards' shifts. Sorts it by guard, and
	 * number of times the guard is asleep during each minute
	 */
	public void createGuardMap() {
		// go through each entry in the chronMap
		int guard = 0; // guard number
		int fallsAsleep = 0; // time guard falls asleep
		int wakesUp = 0; // time guard wakes up
		String[] value;

		for (Map.Entry<String, String> entry : chronMap.entrySet()) {
			// three cases: guard begins shift, guard sleeps, guard wakes up

			// get guard number
			if (entry.getValue().startsWith(" Guard")) {
				value = entry.getValue().replaceAll("#", "").split(" ");
				guard = Integer.parseInt(value[2]);

			} else if (entry.getValue().startsWith(" falls")) {
				// time guard falls asleep
				System.out.println(entry.getKey());
				System.out.println(entry.getKey().substring(entry.getKey().length() - 3, entry.getKey().length() - 1));
				fallsAsleep = Integer
						.parseInt(entry.getKey().substring(entry.getKey().length() - 3, entry.getKey().length() - 1));

			} else {
				// time guard wakes up Save this onto the tree
				System.out.println(entry.getValue());
				wakesUp = Integer
						.parseInt(entry.getKey().substring(entry.getKey().length() - 3, entry.getKey().length() - 1));
				// TODO: save value into tree
				insertSleepTime(guard, fallsAsleep, wakesUp);
			}
		}

		return;

	}

	/*
	 * Inserts the times that the guard was asleep into the map. If the guard
	 * has already fallen asleep during those times, then increments the amount
	 * of times said guard was asleep at that time by 1
	 */
	private void insertSleepTime(int guard, int fallsAsleep, int wakesUp) {

		// Check if map contains guard already
		if (guardMap.containsKey(guard)) {
			// add sleep times into map

			Map<Integer, Integer> minutesAsleep = guardMap.get(guard);

			// for (Map.Entry<Integer, Integer> entry :
			// minutesAsleep.entrySet()){
			//
			// }
			for (int i = fallsAsleep; i < wakesUp; i++) {
				if (minutesAsleep.containsKey(i)) {
					int count = minutesAsleep.get(i);
					minutesAsleep.put(i, count + 1);
				} else {
					minutesAsleep.put(i, 1);
				}
			}

			guardMap.put(guard, minutesAsleep);

		} else {
			// add new guard and sleep times
			// guardMap.
			Map<Integer, Integer> minutesAsleep = new HashMap<>();
			for (int i = fallsAsleep; i < wakesUp; i++) {
				minutesAsleep.put(i, 1);
			}
			guardMap.put(guard, minutesAsleep);

		}
		return;
	}

	/*
	 * Prints out the times the guard fell asleep
	 */
	public void printGuardMap() {

		for (Map.Entry<Integer, Map<Integer, Integer>> entry : guardMap.entrySet()) {
			for (Map.Entry<Integer, Integer> entry2 : entry.getValue().entrySet()) {
				System.out.print("Guard: " + entry.getKey() + " ");
				System.out.print("Minute: " + entry2.getKey() + " ");
				System.out.println("Times Asleep: " + entry2.getValue());
			}
			System.out.println();
		}
		return;
	}

	/*
	 * Finds the guard that slept the most, Along with the most likely time the
	 * guard will be asleep
	 */
	public void findLazyGuard() {
		int lazyGuard = 0; // Guard with the most sleepmins
		int totalMins = 0; // Number of minutes guard was asleep
		int minute = 0; // Most Likely minute Guard will be asleep

		int currGuard;
		int curTotalMins; // Number of mins guard was asleep
		int curMinute = 0; // Most likely minute current guard will be asleep
		int curNumTimes; // Number of times asleep at minute
		// int

		// first calculate the sleepMins
		// if More than current sleepMins, then update lazyGuard, sleepMins, and
		// mins

		for (Map.Entry<Integer, Map<Integer, Integer>> entry : guardMap.entrySet()) {

			currGuard = entry.getKey();
			curTotalMins = 0;
			curNumTimes = 0;
			for (Map.Entry<Integer, Integer> entry2 : entry.getValue().entrySet()) {

				System.out.print("Guard: " + entry.getKey() + " ");
				System.out.print("Minute: " + entry2.getKey() + " ");
				System.out.println("Number of Times Asleep: " + entry2.getValue());

				// increment total minutes guard was asleep
				curTotalMins += entry2.getValue();

				// If number of times asleep is more than current number of
				// times, then it will change the current number of times this
				// guard was alseep at said time
				if (entry2.getValue() > curNumTimes) {
					curNumTimes = entry2.getValue();
					curMinute = entry2.getKey();
				}
			}

			if (curTotalMins > totalMins) {
				totalMins = curTotalMins;
				lazyGuard = currGuard;
				minute = curMinute;

			}

		}
		
		System.out.println("Guard: " + lazyGuard);
		System.out.println("Total mins " + totalMins);
		System.out.println("Most likely minute " + minute);

	}

}
