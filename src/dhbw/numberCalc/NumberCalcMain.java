package dhbw.numberCalc;

public class NumberCalcMain {

	public static void main(String[] args) throws Exception {
		System.err.println("BEGIN");
		NumberCalcTest test = new NumberCalcTest(args[0]);
		test.testRun();
		System.err.println("END");
	}

}