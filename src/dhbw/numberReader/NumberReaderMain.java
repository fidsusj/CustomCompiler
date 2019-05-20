package dhbw.numberReader;

public class NumberReaderMain {

	public static void main(String[] args) throws Exception {
		System.err.println("BEGIN");
		NumberReaderTest test = new NumberReaderTest(args[0]);
		test.testRun();
		System.err.println("END");
	}

}