package dhbw.project.conditionals;

public class ConditionalMain {

	public static void main(String[] args) throws Exception {
		System.err.println("BEGIN");
		ConditionalTest test = new ConditionalTest(args[0]);
		test.testRun();
		System.err.println("END");
	}

}