package dhbw.project.conditionals.compiler;

public interface StmtReaderIntf {

	// constructs a statement reader from a given lexer
	// public StmtIntf(LexerIntf lexer, OutputStream out) throws Exception;
	
    // get statement list
	public void getStmtList() throws Exception;

	// get next statement
	public void getStmt() throws Exception;
	
	// get assign statement
	public void getAssign() throws Exception;

	// get print statement
	public void getPrint() throws Exception;

	// get block statement
	public void getBlockStmt() throws Exception;

	// get call statement
	public void getCallStmt() throws Exception;
}
