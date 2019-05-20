package dhbw.fileReader.compiler;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
public class FileReader implements dhbw.fileReader.compiler.FileReaderIntf {

	private Reader reader;
	private char lookAheadChar;
	
	public FileReader(InputStream inputStream) throws Exception {
		this.reader = new InputStreamReader(inputStream);
		this.advance();
	}
	
	public char lookAheadChar() {
		return this.lookAheadChar;
	}

	public void advance() throws Exception {
		int nextChar = this.reader.read();
		this.lookAheadChar = (nextChar == -1) ? 0 : (char) nextChar;
	}

	public void expect(char c) throws Exception {
		if(this.lookAheadChar != c) {
			throw new Exception(String.format("unexpected character: '%s' expected: '%s'", this.lookAheadChar, c));
		}
		advance();
	}

}