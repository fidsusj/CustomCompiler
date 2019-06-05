package dhbw.project.interpreter.compiler;

public abstract class ExprReaderIntf {
	SymbolTable m_symbolTable;
    LexerIntf m_lexer;
    CompileEnv m_compileEnv;

	public ExprReaderIntf(SymbolTable symbolTable, LexerIntf lexer, CompileEnv compileEnv) throws Exception {
		m_symbolTable = symbolTable;
		m_lexer = lexer;
		m_compileEnv = compileEnv;
	}
	
	// read factor
	abstract public void getFactor() throws Exception;
	
	// read expression
	abstract public void getExpr() throws Exception;

	// read sum
	abstract public void getSum() throws Exception;

	// read product
	abstract public void getProduct() throws Exception;
}
