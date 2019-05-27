package dhbw.project.conditionals.compiler;

public class CompareReaderIntf {

	LexerIntf m_lexer;
	
	public CompareReaderIntf(LexerIntf lexer) {
		this.m_lexer = lexer;
	}
	
	public void getCompStmt() throws Exception {
		this.m_lexer.expect(Token.Type.IDENT);
	}
	
}