package dhbw.numberAdder;

public class NumberAdderMain {

	public static void main(String[] args) throws Exception {
		System.err.println("BEGIN");
		NumberAdderTest test = new NumberAdderTest(args[0]);
		test.testRun();
		System.err.println("END");
	}

}