package dhbw.lexer.compiler;

import dhbw.lexer.compiler.TokenIntf.Type;

public class Lexer implements LexerIntf{
	
	private FileReaderIntf reader;
	private Token lookAheadToken;
	
	public Lexer(FileReaderIntf reader) throws Exception {
		this.reader = reader;
		this.advance();
	}
	
	public Token lookAheadToken() {
		return this.lookAheadToken;
	}

	public void advance() throws Exception {
		Type type = this.getTokenType(this.reader.lookAheadChar());
		if(type.equals(Type.IDENT)) {
			this.lookAheadToken = new Token(type, this.getIdent());
		} else if(type.equals(Type.INTEGER)) {
			this.lookAheadToken = new Token(type, this.getNumber());
		} else {
			this.lookAheadToken = new Token(type);
			this.reader.advance();
		}
		
		while(this.isWhiteSpace(this.reader.lookAheadChar())) {
			this.reader.advance();
		}
	}

	public void expect(Type tokenType) throws Exception {
		if(this.lookAheadToken.m_type != tokenType) {
			throw new Exception(String.format("unexpected token: '%s' expected: '%s'", this.lookAheadToken.m_type, tokenType));
		}
		advance();
	}

	public Type getTokenType(char firstChar) throws Exception {
		if(this.isDigit(firstChar)) {
			return Token.Type.INTEGER;
		} else if (this.isIdentifierPart(firstChar)) {
			return Token.Type.IDENT;
		} else {
			switch(firstChar) {
				case '+': return Token.Type.PLUS;
				case '-': return Token.Type.MINUS;
				case '*': return Token.Type.MUL;
				case '/': return Token.Type.DIV;
				case '(': return Token.Type.LPAREN;
				case ')': return Token.Type.RPAREN;
				case '=': return Token.Type.ASSIGN;
				case 0: return Token.Type.EOF;
				default: throw new ParserException("Unexpected character: ", Character.toString(firstChar), this.reader.getCurrentLocationMsg(), "");
			}
		}
	}

	public String getIdent() throws Exception {
		StringBuilder identifier = new StringBuilder();
		while(this.isIdentifierPart(this.reader.lookAheadChar())) {
			identifier.append(this.reader.lookAheadChar());
			this.reader.advance();
		}
		return identifier.toString();
	}

	public int getNumber() throws Exception {
		int number = 0;
		while(this.isDigit(this.reader.lookAheadChar())) {
			number *= 10;
			number += (int)(this.reader.lookAheadChar() - '0');
			this.reader.advance();
		}
		return number;
	}
	
	public boolean isIdentifierPart(char c) {
		return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
	}

	public boolean isDigit(char c) {
		return '0' <= c && c <= '9';
	}

	public boolean isWhiteSpace(char c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t';
	}

}