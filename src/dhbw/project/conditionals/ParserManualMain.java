package dhbw.project.conditionals;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ParserManualMain {

	public static void main(String[] args) throws Exception {
		System.err.println("BEGIN");
		ParserTest test = new ParserTest();
		byte[] fileBytes = Files.readAllBytes(Paths.get(args[0]));
		String s = test.executeTest(new String(fileBytes));
		System.err.print(s);
		System.err.println("END");
	}

}
