package dhbw.variable;

public class VariableMain {

	public static void main(String[] args) throws Exception {
		System.err.println("BEGIN");
		VariableTest test = new VariableTest(args[0]);
		test.testRun();
		System.err.println("END");
	}

}
