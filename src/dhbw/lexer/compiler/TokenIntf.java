package dhbw.lexer.compiler;

abstract class TokenIntf {
	public enum Type {
		EOF,
		IDENT,
		INTEGER,
		PLUS,
		MINUS,
		MUL,
		DIV,
		LPAREN,
		RPAREN,
		ASSIGN,
	}

	public Type m_type;
	public int m_intValue; 
	public String m_stringValue;

	// returns a string representation of the current token
	public abstract String toString();
	
	// returns a string representation of the given token type
	public static String type2String(Type type) {
		return type.toString();
	}
}