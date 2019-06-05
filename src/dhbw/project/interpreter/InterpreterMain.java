package dhbw.project.interpreter;

public class InterpreterMain {

	public static void main(String[] args) throws Exception {
		System.err.println("BEGIN");
		InterpreterTest test = new InterpreterTest(args[0]);
		test.testRun();
		System.err.println("END");
	}

}

