package dhbw.variable.compiler;

public abstract class ExprReaderIntf {
	SymbolTable m_symbolTable;
    LexerIntf m_lexer;

	public ExprReaderIntf(SymbolTable symbolTable, LexerIntf lexer) throws Exception {
		m_symbolTable = symbolTable;
		m_lexer = lexer;
	}
	
	// read factor
	abstract public int getFactor() throws Exception;
	
	// read expression
	abstract public int getExpr() throws Exception;

	// read product
	abstract public int getProduct() throws Exception;
}