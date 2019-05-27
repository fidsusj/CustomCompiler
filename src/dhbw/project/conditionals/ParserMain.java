package dhbw.project.conditionals;

public class ParserMain {

	public static void main(String[] args) throws Exception {
		System.err.println("BEGIN");
		ParserTest test = new ParserTest(args[0]);
		test.testRun();
		System.err.println("END");
	}

}
