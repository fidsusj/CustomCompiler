package dhbw.project.interpreter;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import dhbw.project.interpreter.compiler.FileReaderIntf;
import dhbw.project.interpreter.compiler.FileReader;
import dhbw.project.interpreter.test.TestBase;
import dhbw.project.interpreter.compiler.CompileEnv;


public class InterpreterTest extends TestBase {

	public InterpreterTest(String fileName) throws Exception {
		super(fileName);
	}

	public InterpreterTest() throws Exception {
		super();
	}

	public String executeTest(String input) throws Exception {
		InputStream inputStream = stringToInputStream(input);
		FileReaderIntf fileReader = new FileReader(inputStream);
		CompileEnv compiler = new CompileEnv(fileReader);
		compiler.compile();
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		compiler.execute(outStream);
        String output = outStream.toString("UTF-8");
        return output;
	}
}
