import java.io.File;

public class Driver {

	public static void main(String[] args) {
		dayOneChronalCalibration();
		
		
	}
	
	
	/*
	 * Answer for Day One: Chronal Calibration
	 */
	public static  void dayOneChronalCalibration() {
		int dayOneAnswer = 0;
		DayOne dayOne = new DayOne();
		File dayOneInput = new File("/Users/KyVGuarin/Documents/Programming/AdventOfCode2018/DayOneInput");
		dayOneAnswer = dayOne.findFrequency(dayOneInput);
		System.out.println("Day One Answer: " + dayOneAnswer);
		
	}
	

}
