import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.omg.CORBA.IntHolder;

public class DayThree {

	// private Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
	private int gridWidth = 1000;
	private int gridHeight = 1000;
	private String[][] grid = new String[gridWidth][gridHeight];
	private int uniqueClaim = 0;

	/*
	 * Reads the file and makes the grid
	 */
	public void makeGrid(File file) {
		BufferedReader reader;
		Integer claimID = 0;
		int x;
		int y;
		int width;
		int height;

		try {
			reader = new BufferedReader(new FileReader(file));
			String line;

			// gets x, y coordinate from line and inserts claim into the grid
			while ((line = reader.readLine()) != null) {
				claimID++;
				x = getPointX(line);
				y = getPointY(line);
				width = getWidth(line);
				height = getHeight(line);
				insertClaim(claimID.toString(), x, y, width, height);
			}
			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
			e.printStackTrace();

		} catch (IOException e) {
			System.out.println("Unhandeled IO Exception");
			e.printStackTrace();
		}
	}

	/*
	 * Returns claim number
	 */
	private String getClaimID(String line) {
		int atIndex = line.indexOf("@");
		return line.substring(1, atIndex - 1);
	}

	/*
	 * Returns the X coordinate of the claim
	 */
	private int getPointX(String line) {
		int index1 = line.indexOf("@") + 2;
		int index2 = line.indexOf(",");
		return Integer.parseInt(line.substring(index1, index2));
	}

	/*
	 * Returns the Y coordinate of the claim
	 */
	private int getPointY(String line) {
		int index1 = line.indexOf(",") + 1;
		int index2 = line.indexOf(":");
		return Integer.parseInt(line.substring(index1, index2));
	}

	/*
	 * Returns the width of the claim
	 */
	private int getWidth(String line) {
		int index1 = line.indexOf(":") + 2;
		int index2 = line.indexOf("x");
		return Integer.parseInt(line.substring(index1, index2));
	}

	/*
	 * Returns the height of the claim
	 */
	private int getHeight(String line) {
		int index1 = line.indexOf("x") + 1;
		return Integer.parseInt(line.substring(index1, line.length()));
	}

	/*
	 * Inserts the claim into the grid. If quadrant was already claimed, then
	 * will change the value to X. Otherwise, will insert the claim number
	 */
	private void insertClaim(String claimNumber, int x, int y, int width, int height) {
		// Boolean overlap = false;
		for (int i = x; i < x + width; i++) {
			for (int j = y; j < y + height; j++) {

				// Checks if quadrant was already claimed
				if (grid[j][i].compareTo(".") == 0) {
					grid[j][i] = claimNumber;
				} else {
					// overlap = true;
					grid[j][i] = "X";
				}
			}
		}

		// if (!overlap){
		// uniqueClaim = Integer.parseInt(claimNumber);
		// System.out.println("Unique claim is now "+ claimNumber);
		// }

	}

	/*
	 * Makes the grid have values of "."
	 */
	public void initializeGrid() {
		for (int i = 0; i < gridWidth; i++) {
			for (int j = 0; j < gridHeight; j++) {
				grid[i][j] = ".";
			}
		}
	}

	/*
	 * Prints the Grid
	 */
	public void printGrid() {
		for (int i = 0; i < gridWidth; i++) {
			for (int j = 0; j < gridHeight; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}

	/*
	 * Counts the number of qudrants that were claimed more than twice and
	 * returns that number
	 */
	public int countDoubleClaims() {
		int x = 0;
		for (int i = 0; i < gridWidth; i++) {
			for (int j = 0; j < gridHeight; j++) {
				if (grid[i][j].compareTo("X") == 0) {
					x++;
				}
			}
		}
		return x;
	}

	/*
	 * Passes over each claim again and checks if it is unique
	 */
	public void findUniqueClaim(File file) {
		BufferedReader reader;
		Integer claimID = 0;
		int x;
		int y;
		int width;
		int height;

		try {
			reader = new BufferedReader(new FileReader(file));
			String line;

			// gets x, y coordinate from line and inserts claim into the grid
			while ((line = reader.readLine()) != null) {
				claimID++;
				x = getPointX(line);
				y = getPointY(line);
				width = getWidth(line);
				height = getHeight(line);
				// insertClaim(claimID.toString(), x, y, width, height);
				checkClaim(claimID, x, y, width, height);
			}
			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
			e.printStackTrace();

		} catch (IOException e) {
			System.out.println("Unhandeled IO Exception");
			e.printStackTrace();
		}

	}

	/*
	 * Checkes to see if claim is unique
	 */
	private void checkClaim(Integer claimID, int x, int y, int width, int height) {
		for (int i = x; i < x + width; i++) {
			for (int j = y; j < y + height; j++) {

				// Checks if quadrant was already claimed
				if (grid[j][i].compareTo(claimID.toString()) != 0) {
					return;
				}
			}
		}
		uniqueClaim = claimID;
	}

	/*
	 * Returns the unique claim
	 */
	public int getUniqueClaim() {
		return uniqueClaim;
	}

}
