package dhbw.lexer.compiler;

public class Token extends TokenIntf{

	public Token(Type type, int intValue) {
		this.m_type = type;
		this.m_intValue = intValue;
	}
	
	public Token(Type type, String stringValue) {
		this.m_type = type;
		this.m_stringValue = stringValue;
	}
	
	public Token(Type type) {
		this.m_type = type;
	}
	
	public String toString() {
		String output = TokenIntf.type2String(this.m_type);
		if(this.m_type == Type.IDENT) {
			output += " " + this.m_stringValue;
		} else if(this.m_type == Type.INTEGER) {
			output += " " + this.m_intValue;
		}
		return output;
	}
	
}