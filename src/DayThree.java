import java.awt.List;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.border.LineBorder;

public class DayThree {
	
//	private Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
	private int gridWidth = 1000;
	private int gridHeight = 1000;
	private String[][] grid = new String[gridWidth][gridHeight]; 
	private int xInches = 0;
	
	
	/*
	 * Reads the file and makes the grid
	 */
	public void makeGrid(File file){
		BufferedReader reader;
		Integer claimNumber = 0;
		int x;
		int y;
		int width;
		int height;

		try {
			reader = new BufferedReader(new FileReader(file));
			String line;

			while ((line = reader.readLine()) != null) {
				claimNumber++;
				System.out.println(line);
				x = getPointX(line);
				y = getPointY(line);
				width = getWidth(line);
				height = getHeight(line);
				insertClaim(claimNumber.toString(), x, y, width, height);
//				break;
//				System.out.println(getPointY(line));
				//TODO: write method to get claimID
				//TODO: write method to get claimPOINT
				//TODO: write method to insert rectangle into Map (5x4)
				
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
	private String getClaimID(String line){
		int atIndex = line.indexOf("@");
		System.out.println("the @ is index " + atIndex);
		return line.substring(1, atIndex - 1);
	}
	
	/*
	 * Returns the X coordinate of the claim
	 */
	private int getPointX(String line){
		int point = 0;
		int index1 = line.indexOf("@") + 2;
		int index2 = line.indexOf(",");
		point = Integer.parseInt(line.substring(index1, index2));
		System.out.println("point x is " + point);
		return point;
	}
	
	/*
	 * Returns the Y coordinate of the claim
	 */
	private int getPointY(String line){
		int point = 0;
		int index1 = line.indexOf(",") + 1;
		int index2 = line.indexOf(":");
		point = Integer.parseInt(line.substring(index1, index2));
		System.out.println("point Y is " + point);
		return point;
	}
	
	/*
	 * Returns the width of the claim
	 */
	private int getWidth(String line){
		int width = 0;
		int index1 = line.indexOf(":") + 2;
		int index2 = line.indexOf("x");
		width = Integer.parseInt(line.substring(index1, index2));
		System.out.println("Width: " + width);
		return width;
	}
	
	/*
	 * Returns the height of the claim
	 */
	private int getHeight(String line){
		int height = 0;
		int index1 = line.indexOf("x") + 1;
		System.out.println(line.substring(index1, line.length()));
		height = Integer.parseInt(line.substring(index1, line.length()));
		System.out.println("Height: " + height);
		return height;
	}
	
	/*
	 * Inserts the claim into the grid
	 */
	private void insertClaim(String claimNumber, int x, int y, int width, int height){
		System.out.println("INSIDE INSERT CLAIM");
		System.out.println("X is " + x);
		System.out.println("Y is : " + y);
		System.out.println("Width is : " + width);
		System.out.println("Height is : " + height);
		System.out.println();
		for(int i = x; i < x + width; i++){
			for (int j = y; j < y + height; j++){
				if (grid[j][i].compareTo(".") == 0){
					
					grid[j][i] = claimNumber;
					System.out.println("INSIDE INSERT CLAIM");
					System.out.println("X is " + x);
					System.out.println("Y is : " + y);
					System.out.println("i is : " + i);
					System.out.println("j is : " + j);
					System.out.println();
				}else {
					grid[j][i] = "X";
				}
//				return;
			}
		}
	}
	
	/*
	 * Makes the grid have values of "."
	 */
	public void initializeGrid(){
		for(int i = 0; i < gridWidth; i++){
			for(int j = 0; j < gridHeight; j++){
				grid[i][j] = ".";
			}
		}
	}
	
	
	/*
	 * Prints the Grid
	 */
	public void printGrid(){
		for(int i = 0; i < gridWidth; i++){
			for (int j = 0; j <gridHeight; j++){
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
	
	
	public void countDoubleClaims(){
		int x = 0;
		for(int i = 0; i < gridWidth; i++){
			for (int j = 0; j <gridHeight; j++){
				if (grid[i][j].compareTo("X") == 0){
					x++;
				}
			}
		}
		System.out.println(x);
	}

}
