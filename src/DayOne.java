import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
	
	
	/*
	 * Saves the frequencies into an array. Keeps parsing over the file
	 * until it finds the first repeated double frequency. Returns the 
	 * first repeated frequency as an integer
	 */
	public int firstDoubleFrequency(File txtfile) {
		int frequency = 0;
		BufferedReader in;
		ArrayList<Integer> freqList = new ArrayList<Integer>();
		Boolean found = false;
		//open file
		
		//Reads the file over and over again until the first
		//double frequency is found
		while (!found){
			try {
				in = new BufferedReader(new FileReader(txtfile));
				 String st; 
				  while ((st = in.readLine()) != null){
				    frequency += Integer.parseInt(st);
			    	
				    //Checks to see if frequency has been reached twice
				    if (freqList.contains(frequency)){
						found = true;
				    	break;
				    }else{
				    	freqList.add(frequency);
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
		return frequency;
	}
}
