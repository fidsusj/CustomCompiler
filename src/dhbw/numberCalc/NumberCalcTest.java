package dhbw.numberCalc;

import java.io.InputStream;
import dhbw.numberCalc.test.TestBase;
import dhbw.numberCalc.compiler.NumberCalc;
import dhbw.numberCalc.compiler.NumberCalcIntf;
import dhbw.fileReader.compiler.FileReader;
import dhbw.fileReader.compiler.FileReaderIntf;

public class NumberCalcTest extends TestBase {

	public NumberCalcTest(String fileName) throws Exception {
		super(fileName);
	}

	public String executeTest(String input) throws Exception {
		InputStream inputStream = stringToInputStream(input);
		FileReaderIntf fileReader = new FileReader(inputStream);
		String output = new String();
		NumberCalcIntf numberCalc = new NumberCalc(fileReader);
		int number = (int) numberCalc.getSum();
		output += Integer.toString(number);
		output += '\n';
		return output;
	}
}