package dhbw.numberAdder.compiler;

import dhbw.fileReader.compiler.FileReaderIntf;
import dhbw.numberReader.compiler.NumberReader;
import dhbw.numberReader.compiler.NumberReaderIntf;

public class NumberAdder implements NumberAdderIntf{

	private FileReaderIntf reader;
	private NumberReaderIntf numberReader;
	
	public NumberAdder(FileReaderIntf reader) {
		this.reader = reader;
		this.numberReader = new NumberReader(this.reader);
	}
	
	public int getSum() throws Exception {
		return this.numberReader.getNumber() + this.getRemainingSum();
	}

	public int getRemainingSum() throws Exception {
		if(this.reader.lookAheadChar() == '\n') {
			return 0;
		}
		this.reader.expect('+');
		return this.getSum();
	}

}