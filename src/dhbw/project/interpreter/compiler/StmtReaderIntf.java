package dhbw.project.interpreter.compiler;

public interface StmtReaderIntf {

	// constructs a statement reader from a given lexer
	// public StmtIntf(LexerIntf lexer, CompileEnvIntf compileEnv) throws Exception;
	
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
	
	// while statement
	public void getWhileStmt() throws Exception;

	// do while statement
	public void getDoWhileStmt() throws Exception;

	// for statement
	public void getForStmt() throws Exception;

	// read if
	public void getIfStmt() throws Exception;
	
	// read else if
	public void getElseOrElseIfStmt() throws Exception;

	// read else if
	public void getElseIfStmt() throws Exception;
	
	// read else
	public void getElseStmt() throws Exception;
	
}
