import java.io.File;
import java.util.concurrent.ThreadPoolExecutor;

import org.omg.PortableServer.ServantActivator;

public class Driver {

	public static void main(String[] args) {

		// dayOnePartOne(); //Answer: 490
		// dayOnePartTwo(); //Answer: 70357
		// dayTwoPartOne(); // Answer: 7470
		// dayTwoPartTwo(); //Answer: kqzxdenujwcstybmgvyiofrrd
		// dayThreePartOne(); // Answer: 105231
		// dayThreePartTwo(); //Answer: 164
		// dayFourPartOne(); //Answer: 98640
		// dayFourPartTwo(); // Answer: 9763
		dayFivePartOne(); // Answer: 11252
		dayFivePartTwo(); //Answer 6118

	}

	/*
	 * Day One Part One: Chronal Calibration
	 */
	public static void dayOnePartOne() {
		int dayOneAnswer = 0;
		DayOne dayOne = new DayOne();
		File dayOneInput = new File("/Users/KyVGuarin/Documents/Programming/AdventOfCode2018/Inputs/DayOneInput");
		dayOneAnswer = dayOne.findFrequency(dayOneInput);
		System.out.println("Day One Part One: " + dayOneAnswer);
		return;
	}

	/*
	 * Day One Part Two: Find the first double frequency
	 */
	public static void dayOnePartTwo() {
		int doubleFrequency = 0;
		DayOne dayOne = new DayOne();
		File dayOneInput = new File("/Users/KyVGuarin/Documents/Programming/AdventOfCode2018/Inputs/DayOneInput");
		doubleFrequency = dayOne.firstDoubleFrequency(dayOneInput);
		System.out.println("Day One Part Two: " + doubleFrequency);
		return;
	}

	/*
	 * Day Two Part One: Find checksum of box IDs
	 */
	public static void dayTwoPartOne() {
		DayTwo dayTwo = new DayTwo();
		File dayTwoInput = new File("/Users/KyVGuarin/Documents/Programming/AdventOfCode2018/Inputs/DayTwoInput");
		dayTwo.findCheckSum(dayTwoInput);
		System.out.println("Day Two Part One " + dayTwo.getCheckSum());
		return;
	}

	/*
	 * Day Two Part Two: Common Letters between the two correct box IDs
	 */
	public static void dayTwoPartTwo() {
		DayTwo dayTwo = new DayTwo();
		File file = new File("/Users/KyVGuarin/Documents/Programming/AdventOfCode2018/Inputs/DayTwoInput");
		dayTwo.commonLetters(file);
		System.out.println("Day Two Part Two " + dayTwo.getidLetters());
		return;
	}

	/*
	 * Day Three Part One: No Matter How You Slice It
	 */
	public static void dayThreePartOne() {
		DayThree dayThree = new DayThree();
		File file = new File("/Users/KyVGuarin/Documents/Programming/AdventOfCode2018/Inputs/DayThreeInput");
		dayThree.initializeGrid();
		dayThree.makeGrid(file);
		System.out.println("Day Three Part One: " + dayThree.countDoubleClaims());
		return;
	}

	/*
	 * Day Three Part Two: No Matter How You Slice It
	 */
	public static void dayThreePartTwo() {
		DayThree dayThree = new DayThree();
		File file = new File("/Users/KyVGuarin/Documents/Programming/AdventOfCode2018/Inputs/DayThreeInput");
		dayThree.initializeGrid();
		dayThree.makeGrid(file);
		dayThree.findUniqueClaim(file);
		System.out.println("Day Three Part Three: " + dayThree.getUniqueClaim());
		return;
	}

	/*
	 * Day Four Part One: Repose Record
	 */
	public static void dayFourPartOne() {
		DayFour dayFour = new DayFour();
		File file = new File("/Users/KyVGuarin/Documents/Programming/AdventOfCode2018/Inputs/DayFourInput");
		dayFour.organizeFile(file);
		dayFour.createGuardMap();
		dayFour.findLazyGuard();
		return;
	}

	/**
	 * Day Four Part Two: Repose Record
	 */
	public static void dayFourPartTwo() {
		DayFour dayFour = new DayFour();
		File file = new File("/Users/KyVGuarin/Documents/Programming/AdventOfCode2018/Inputs/DayFourInput");
		dayFour.organizeFile(file);
		dayFour.createGuardMap();
		dayFour.findMinuteMan();
		return;
	}

	/**
	 * Day Five Part One: Alchemical Reduction
	 */
	public static void dayFivePartOne() {
		DayFive dayFive = new DayFive();
		File file = new File("/Users/KyVGuarin/Documents/Programming/AdventOfCode2018/Inputs/DayFiveInput");
		dayFive.makeString(file);
		dayFive.parseString(0);
		System.out.println("Day Five Part One: " + dayFive.getCount());
		return;
	}
	
	
	public static void dayFivePartTwo(){
		DayFive dayFive = new DayFive();
		char c;
		int answer = 1000000;
		File file = new File("/Users/KyVGuarin/Documents/Programming/AdventOfCode2018/Inputs/DayFiveInput");
//		File file = new File("/Users/KyVGuarin/Documents/Programming/AdventOfCode2018/TestInputs/DayFiveInputTest1");
		
		for(int i = 65 ; i < 91;i++){//< 91; i++){
			dayFive.makeString(file);
			dayFive.removeLetter(i);
			dayFive.parseString(0);
			dayFive.parseString(0);
			dayFive.parseString(0);
			
			if (dayFive.getCount() < answer){
				answer = dayFive.getCount();
			}
//			System.out.print("polymers: ");
//			dayFive.printPolymers();
//			System.out.println("Letter "+ (char)i + " count: " + dayFive.getCount());
		}
		System.out.println("Day Five Part Two: " + answer);
		return;
	}

}
