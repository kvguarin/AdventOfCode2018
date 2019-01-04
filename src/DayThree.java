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
	private Map<Point, Integer> map = new TreeMap<Point, Integer>();
	
	
	/*
	 * Reads the file and makes the grid
	 */
	public void makeGrid(File file){
		BufferedReader reader;
		int claimNumber = 0;
		int pointX;
		int pointY;
		int width;
		int height;

		try {
			reader = new BufferedReader(new FileReader(file));
			String line;

			while ((line = reader.readLine()) != null) {
				claimNumber++;
				System.out.println(line);
				pointX = getPointX(line);
				pointY = getPointY(line);
				width = getWidth(line);
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
	
	private int getHeight(String line){
		int height = 0;
		int index1 = line.indexOf("x");
		height = Integer.parseInt(line.substring(index1, line.length() - 1));
		return height;
	}

}
