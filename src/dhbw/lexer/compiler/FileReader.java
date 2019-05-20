package dhbw.lexer.compiler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
public class FileReader implements FileReaderIntf {

	private Reader reader;
	private char lookAheadChar;
	private String currentLine;
	private int row;
	private int position;
	
	public FileReader(InputStream inputStream) throws Exception {
		this.reader = new InputStreamReader(inputStream);
		this.readNextLine();
		this.advance();
	}
	
	public char lookAheadChar() {
		return this.lookAheadChar;
	}

	public void advance() throws Exception {
		if(this.position == this.currentLine.length()) {
			this.readNextLine();
			this.position = 1;
		} else {
			this.position += 1;
		}
		this.lookAheadChar = this.currentLine.charAt(this.position - 1);
	}

	public void expect(char c) throws Exception {
		if(this.lookAheadChar != c) {
			throw new Exception(String.format("unexpected character: '%s'\n Expected: '%s'\n %s", 
								this.lookAheadChar, c, this.getCurrentLocationMsg()));
		}
		this.advance();
	}

	public void readNextLine() throws IOException {
		StringBuilder line = new StringBuilder();
		char currentChar;
		do {
			int nextChar = this.reader.read();
			currentChar = (nextChar == -1) ? 0 : (char) nextChar;
			line.append(currentChar);
		} 
		while(currentChar != 0 && currentChar != '\n');
		this.currentLine = line.toString();
		this.row += 1;
	}
	
	public String getCurrentLocationMsg() {
		StringBuilder errorMessage = new StringBuilder();
		errorMessage.append(this.currentLine);
		for(int i = 0; i < this.position-1; i++) {
			errorMessage.append(" ");
		}
		errorMessage.append("^\n");
		errorMessage.append("Error in line " + this.row + " at position " + this.position);
		return errorMessage.toString();
	}
	
}