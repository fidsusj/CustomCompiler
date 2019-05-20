package dhbw.numberAdder;

import java.io.InputStream;
import dhbw.numberAdder.test.TestBase;
import dhbw.numberAdder.compiler.NumberAdder;
import dhbw.numberAdder.compiler.NumberAdderIntf;
import dhbw.fileReader.compiler.FileReader;
import dhbw.fileReader.compiler.FileReaderIntf;

public class NumberAdderTest extends TestBase {

	public NumberAdderTest(String fileName) throws Exception {
		super(fileName);
	}

	public String executeTest(String input) throws Exception {
		InputStream inputStream = stringToInputStream(input);
		FileReaderIntf fileReader = new FileReader(inputStream);
		String output = new String();
		NumberAdderIntf numberAdder = new NumberAdder(fileReader);
		int number = numberAdder.getSum();
		output += Integer.toString(number);
		output += '\n';
		return output;
	}
}