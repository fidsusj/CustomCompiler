package dhbw.project.conditionals.compiler;

public abstract class ConditionalReaderIntf {
    LexerIntf m_lexer;
    StmtReaderIntf m_stmtreader;
    CompareReaderIntf m_compreader;

	public ConditionalReaderIntf(LexerIntf lexer, StmtReaderIntf stmtreader, CompareReaderIntf compreader) throws Exception {
		m_lexer = lexer;
		m_stmtreader = stmtreader;
		m_compreader = compreader;
	}
	
	// read if
	abstract public void getIf() throws Exception;
	
	// read else if
	abstract public void getElseIf() throws Exception;
	
	// read else
	abstract public void getElse() throws Exception;
	
	// read condition
	abstract public void getCond() throws Exception;
	
}