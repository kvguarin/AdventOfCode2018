import java.io.File;

public class Driver {

	public static void main(String[] args) {

		// dayOnePartOne(); //Answer: 490
		// dayOnePartTwo(); //Answer: 70357
		// dayTwoPartOne(); // Answer: 7470
		// dayTwoPartTwo(); //Answer: kqzxdenujwcstybmgvyiofrrd
		 dayThreePartOne();

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
	}

	/*
	 * Day Two Part One: Find checksum of box IDs
	 */
	public static void dayTwoPartOne() {
		DayTwo dayTwo = new DayTwo();
		Integer checksum;
		File dayTwoInput = new File("/Users/KyVGuarin/Documents/Programming/AdventOfCode2018/Inputs/DayTwoInput");
		dayTwo.findCheckSum(dayTwoInput);
		System.out.println("Day Two Part One " + dayTwo.getCheckSum());
	}

	/*
	 * Day Two Part Two: Common Letters between the two correct box IDs
	 */
	public static void dayTwoPartTwo() {
		DayTwo dayTwo = new DayTwo();
		File txtFile = new File("/Users/KyVGuarin/Documents/Programming/AdventOfCode2018/Inputs/DayTwoInput");
		dayTwo.commonLetters(txtFile);
		System.out.println("Day Two Part Two " + dayTwo.getidLetters());
	}

	/*
	 * Day Three Part One: No Matter How You Slice It
	 */
	public static void dayThreePartOne() {
		DayThree dayThree = new DayThree();
		File file = new File(
				"/Users/KyVGuarin/Documents/Programming/AdventOfCode2018/TestInputs/DayThreeInputTest1");
		dayThree.makeGrid(file);
	}

}
