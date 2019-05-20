package dhbw.numberCalcToken;

import java.io.InputStream;
import dhbw.numberCalcToken.test.TestBase;
import dhbw.numberCalcToken.compiler.NumberCalc;
import dhbw.numberCalcToken.compiler.NumberCalcIntf;
import dhbw.lexer.compiler.FileReader;
import dhbw.lexer.compiler.FileReaderIntf;

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