import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Map;
import java.util.TreeMap;

public class DayFour {

	private Map<String, String> chronMap = new TreeMap<>(); // chronologically
															// organized file

	//Sorts individual guard Sleep times
	private Map<Integer, Map<Integer, Integer>> guardMap = new TreeMap<>();
	
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
		printMap();
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
	private void printMap() {
		for (Map.Entry<String, String> entry : chronMap.entrySet()) {
			System.out.print(entry.getKey());
			System.out.println(entry.getValue());
		}
	}

}
