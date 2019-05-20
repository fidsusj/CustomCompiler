package dhbw.numberCalc.compiler;

import java.util.Arrays;

import dhbw.fileReader.compiler.FileReaderIntf;
import dhbw.numberReader.compiler.NumberReader;
import dhbw.numberReader.compiler.NumberReaderIntf;

public class NumberCalc implements NumberCalcIntf{

	private FileReaderIntf reader;
	private NumberReaderIntf numberReader;
	
	public NumberCalc(FileReaderIntf reader) {
		this.reader = reader;
		this.numberReader = new NumberReader(this.reader);
	}
	
	public double getSum() throws Exception {
		return this.getProduct() + this.getRemainingSum();
	}
	
	public double getRemainingSum() throws Exception {
		char currentChar = this.reader.lookAheadChar();
		if(Arrays.asList(new Character[]{'+', '-'}).contains(currentChar)) {
			this.reader.advance();
			return currentChar == '+' ? this.getSum() : -1*this.getSum();
		}
		return 0;
	}

	public double getProduct() throws Exception {
		return this.getFactor() * this.getRemainingProduct();
	}
	
	public double getRemainingProduct() throws Exception {
		char currentChar = this.reader.lookAheadChar();
		if(Arrays.asList(new Character[]{'*', '/'}).contains(currentChar)) {
			this.reader.advance();
			return currentChar == '*' ? this.getProduct() : 1/this.getProduct();
		}
		return 1;
	}

	public double getFactor() throws Exception {
		double number = 0;
		char currentChar = this.reader.lookAheadChar();
		if(Arrays.asList(new Character[]{'(', '['}).contains(currentChar)) {
			this.reader.advance();
			number = this.getSum();
			this.reader.expect('(' == currentChar ? ')' : ']');
		}
		return number == 0 ? this.numberReader.getNumber() : number;
	}

}