package dhbw.variable;

import java.io.InputStream;
import dhbw.variable.compiler.FileReader;
import dhbw.variable.compiler.FileReaderIntf;
import dhbw.variable.compiler.Lexer;
import dhbw.variable.compiler.LexerIntf;
import dhbw.variable.compiler.StmtReader;
import dhbw.variable.compiler.StmtReaderIntf;
import dhbw.variable.test.TestBase;

import java.io.ByteArrayOutputStream;

public class VariableTest extends TestBase {

	public VariableTest(String fileName) throws Exception {
		super(fileName);
	}

	public VariableTest() throws Exception {	
	}

	public String executeTest(String input) throws Exception {
		InputStream inputStream = stringToInputStream(input);
		FileReaderIntf fileReader = new FileReader(inputStream);
		LexerIntf lexer = new Lexer(fileReader);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        StmtReaderIntf stmt = new StmtReader(lexer, outStream);
        stmt.getStmtList();
        String output = outStream.toString("UTF-8");
        return output;
	}	
}
