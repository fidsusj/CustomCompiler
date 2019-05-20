package dhbw.variable;

import java.nio.file.Files;
import java.nio.file.Paths;

public class VariableManualMain {

	public static void main(String[] args) throws Exception {
		System.err.println("BEGIN");
		VariableTest test = new VariableTest();
		byte[] fileBytes = Files.readAllBytes(Paths.get(args[0]));
		String s = test.executeTest(new String(fileBytes));
		System.err.print(s);
		System.err.println("END");
	}

}
