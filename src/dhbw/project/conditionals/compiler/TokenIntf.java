package dhbw.project.conditionals.compiler;

abstract class TokenIntf {
	public enum Type {
		EOF,
		IDENT,
		INTEGER,
		PLUS,
		MUL,
		BITWISEAND,
		BITWISEOR,
		AND,
		OR,
		LPAREN,
		RPAREN,
		ASSIGN,
		COMMA,
		SEMICOL,
		PRINT,
		IF,
		ELSE,
		WHILE,
		DO,
		FOR,
		CALL,
		LBRACE,
		RBRACE,
		LESS,
		EQUAL,
		GREATER
	}

	public Type m_type;
	public int m_intValue; 
	public String m_stringValue;

	// returns a string representation of the current token
	public abstract String toString();
	
	// returns a string representaiton of the given token type
	// static String type2String(Type type);		
}
