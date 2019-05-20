package dhbw.numberReader.compiler;

import dhbw.fileReader.compiler.FileReaderIntf;

public class NumberReader implements NumberReaderIntf {

	private FileReaderIntf reader;
	
	public NumberReader(FileReaderIntf fileReader) {
		this.reader = fileReader;
	}
	
	public int getNumber() throws Exception {
		int number = 0;
		if(!this.isDigit(this.reader.lookAheadChar())) {
			throw new Exception("not a number");
		}
		while(this.isDigit(this.reader.lookAheadChar())) {
			number *= 10;
			number += (int)(this.reader.lookAheadChar() - '0');
			this.reader.advance();
		}
		return number;
	}

	public boolean isDigit(char c) {
		return '0' <= c && c <= '9';
	}
	
}