import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DayFour {
	
	
	public void organizeFile(File file){
		BufferedReader reader;

		String line;
		try {
			reader = new BufferedReader(new FileReader(file));

			// gets x, y coordinate from line and inserts claim into the grid
			while ((line = reader.readLine()) != null) {
				//TODO: need a put the information into a map.
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

}
