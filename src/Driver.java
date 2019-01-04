import java.io.File;

public class Driver {

	public static void main(String[] args) {
		
		
		//dayOneChronalCalibration(); //Answer: 490
		dayOneFirstDoubleFrequency(); //Answer: 70357
		
		
	}
	
	
	/*
	 * Answer for Day One: Chronal Calibration
	 */
	public static  void dayOneChronalCalibration() {
		int dayOneAnswer = 0;
		DayOne dayOne = new DayOne();
		File dayOneInput = new File("/Users/KyVGuarin/Documents/Programming/AdventOfCode2018/DayOneInput");
		dayOneAnswer = dayOne.findFrequency(dayOneInput);
		System.out.println("Day One Chronal Calibration Answer: " + dayOneAnswer);
	}
	
	
	/*
	 * Day One: Find the first double frequency
	 */
	public static void dayOneFirstDoubleFrequency(){
		int doubleFrequency = 0;
		DayOne dayOne = new DayOne();
		File dayOneInput = new File("/Users/KyVGuarin/Documents/Programming/AdventOfCode2018/DayOneInput");
		doubleFrequency = dayOne.firstDoubleFrequency(dayOneInput);
		System.out.println("Day One First Double Frequency Answer: " + doubleFrequency);
	}
	

}
