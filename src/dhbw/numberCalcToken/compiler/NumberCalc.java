package dhbw.numberCalcToken.compiler;

import java.util.Arrays;

import dhbw.lexer.compiler.FileReaderIntf;
import dhbw.lexer.compiler.Lexer;
import dhbw.lexer.compiler.LexerIntf;
import dhbw.lexer.compiler.Token;

public class NumberCalc implements NumberCalcIntf{

	private LexerIntf lexer;
	
	public NumberCalc(FileReaderIntf reader) throws Exception {
		this.lexer = new Lexer(reader);
	}
	
	public double getSum() throws Exception {
		return this.getProduct() + this.getRemainingSum();
	}
	
	public double getRemainingSum() throws Exception {
		String currentToken = this.lexer.lookAheadToken().m_type.toString();
		if(Arrays.asList(new String[]{"PLUS", "MINUS"}).contains(currentToken)) {
			this.lexer.advance();
			return currentToken == "PLUS" ? this.getSum() : -1*this.getSum();
		}
		return 0;
	}

	public double getProduct() throws Exception {
		return this.getFactor() * this.getRemainingProduct();
	}
	
	public double getRemainingProduct() throws Exception {
		String currentToken = this.lexer.lookAheadToken().m_type.toString();
		if(Arrays.asList(new String[]{"MUL", "DIV"}).contains(currentToken)) {
			this.lexer.advance();
			return currentToken == "MUL" ? this.getProduct() : (1/this.getProduct());
		}
		return 1;
	}

	public double getFactor() throws Exception {
		double number = 0;
		Token currentToken = this.lexer.lookAheadToken();
		if(Token.Type.LPAREN == currentToken.m_type) {
			this.lexer.advance();
			number = this.getSum();
			this.lexer.expect(Token.Type.RPAREN);
		} else {
			this.lexer.expect(Token.Type.INTEGER);
			number = currentToken.m_intValue;
		}
		return number;
	}

}