import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DayFive {
	// this is a class
	StringBuilder builder = new StringBuilder();
	
	
	

/**
 * Parses through the file and saves the contents into a StringBuilder
 * @param file
 */
public void makeString(File file){
	BufferedReader reader;

	String line;
	try {
		reader = new BufferedReader(new FileReader(file));

		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}
		reader.close();

	} catch (FileNotFoundException e) {
		System.out.println("File not Found");
		e.printStackTrace();

	} catch (IOException e) {
		System.out.println("Unhandeled IO Exception");
		e.printStackTrace();
	}
	
	System.out.println(builder);
	return;
}

}
