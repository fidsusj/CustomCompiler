package dhbw.project.conditionals;

import java.io.InputStream;
import java.io.ByteArrayOutputStream;

import dhbw.project.conditionals.compiler.CompareReaderIntf;
import dhbw.project.conditionals.compiler.ConditionalReader;
import dhbw.project.conditionals.compiler.FileReader;
import dhbw.project.conditionals.compiler.FileReaderIntf;
import dhbw.project.conditionals.compiler.Lexer;
import dhbw.project.conditionals.compiler.LexerIntf;
import dhbw.project.conditionals.compiler.StmtReader;
import dhbw.project.conditionals.test.TestBase;

public class ConditionalTest extends TestBase {

	public ConditionalTest(String fileName) throws Exception {
		super(fileName);
	}

	public ConditionalTest() throws Exception {	
	}

	public String executeTest(String input) throws Exception {
		InputStream inputStream = stringToInputStream(input);
		FileReaderIntf fileReader = new FileReader(inputStream);
		LexerIntf lexer = new Lexer(fileReader);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        StmtReader stmt = new StmtReader(lexer, outStream);
        CompareReaderIntf comp = new CompareReaderIntf(lexer);  //shortcutted, implemented by someone else
        ConditionalReader cond = new ConditionalReader(lexer, stmt, comp);
        cond.getIf();
        String output = outStream.toString("UTF-8");
        return output;
	}	
}
