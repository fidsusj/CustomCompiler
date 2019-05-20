package dhbw.numberReader;
import java.io.InputStream;

import dhbw.fileReader.compiler.FileReader;
import dhbw.fileReader.compiler.FileReaderIntf;
import dhbw.numberReader.compiler.NumberReader;
import dhbw.numberReader.compiler.NumberReaderIntf;
import dhbw.numberReader.test.TestBase;

public class NumberReaderTest extends TestBase {

	public NumberReaderTest(String fileName) throws Exception {
		super(fileName);
	}

	public String executeTest(String input) throws Exception {
		InputStream inputStream = stringToInputStream(input);
		FileReaderIntf fileReader = new FileReader(inputStream);
		String output = new String();
		NumberReaderIntf numberReader = new NumberReader(fileReader);
		int number = numberReader.getNumber();
		output += Integer.toString(number);
		output += '\n';
		return output;
	}
}