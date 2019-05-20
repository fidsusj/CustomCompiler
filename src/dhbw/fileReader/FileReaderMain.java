package dhbw.fileReader;

public class FileReaderMain {

	public static void main(String[] args) throws Exception {
		System.err.println("BEGIN");
		FileReaderTest test = new FileReaderTest(args[0]);
		test.testRun();
		System.err.println("END");
	}

}