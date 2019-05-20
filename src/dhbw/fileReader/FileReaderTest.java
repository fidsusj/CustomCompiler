package dhbw.fileReader;

import java.io.InputStream;
import dhbw.fileReader.compiler.FileReader;
import dhbw.fileReader.compiler.FileReaderIntf;
import dhbw.fileReader.test.TestBase;

public class FileReaderTest extends TestBase {

	public FileReaderTest(String fileName) throws Exception {
		super(fileName);
	}

	public String executeTest(String input) throws Exception {
		InputStream inputStream = stringToInputStream(input);
		FileReaderIntf fileReader = new FileReader(inputStream);
		String output = new String();
		while(fileReader.lookAheadChar() != 0) {
			output += fileReader.lookAheadChar();
			fileReader.advance();
		}
		return output;
	}
}