import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Reads the file then returns
 * the frequency 
 */
public class DayOne {
	
	
	/*
	 * Opens the file and parses it. Adds each
	 * individual line in order to calculate the
	 * frequency. Returns the Frequency.
	 */
	public int findFrequency(File txtfile) {
		int frequency = 0;
		BufferedReader in;
		
		//open file
		try {
			in = new BufferedReader(new FileReader(txtfile));
			 String st; 
			  while ((st = in.readLine()) != null){
			    frequency += Integer.parseInt(st);
			  } 
			  in.close();
			  
		} catch (FileNotFoundException e) {
			
			System.out.println("File not Found");
			e.printStackTrace();
			
		} catch (IOException e) {
			
			System.out.println("Unhandeled IO Exception");
			e.printStackTrace();
		}
		
		return frequency;
		
	}
}
