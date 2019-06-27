package dhbw.project.interpreter.compiler;

public class StmtReader implements StmtReaderIntf {
	private SymbolTable m_symbolTable;
	private LexerIntf m_lexer;
    private ExprReader m_exprReader;
    private FunctionReader m_functionReader;
    private CompileEnvIntf m_compileEnv;

	public StmtReader(LexerIntf lexer, CompileEnv compileEnv) throws Exception {
		m_lexer = lexer;
		m_exprReader = new ExprReader(compileEnv.getSymbolTable(), m_lexer, compileEnv);
		m_functionReader = new FunctionReader(compileEnv.getSymbolTable(), m_lexer, this); 
		m_compileEnv = compileEnv;
		m_symbolTable = compileEnv.getSymbolTable();
	}
	
	public void getBlockStmt() throws Exception {
		m_lexer.expect(Token.Type.LBRACE);
		getStmtList();
		m_lexer.expect(Token.Type.RBRACE);
	}
	
	public void getStmtList() throws Exception {
		while (m_lexer.lookAheadToken().m_type != Token.Type.EOF && m_lexer.lookAheadToken().m_type != Token.Type.RBRACE) {
			getStmt();
		}
	}

	public void getStmt() throws Exception {
		Token token = m_lexer.lookAheadToken();
		if (token.m_type == Token.Type.IDENT) {
			getAssign();
		} else if (token.m_type == Token.Type.PRINT) {
			getPrint();
		} else if (token.m_type == Token.Type.LBRACE) {
			getBlockStmt();
		} else if (token.m_type == Token.Type.CALL) {
			getCallStmt();
		} else if (token.m_type == Token.Type.WHILE) {
			getWhileStmt();
		} else if (token.m_type == Token.Type.DO) {
			getDoWhileStmt();
		} else if (token.m_type == Token.Type.FOR) {
			getForStmt();
		} else if (token.m_type == Token.Type.IF) {
			getIfStmt();
		} else if (token.m_type == Token.Type.ELSE) {
			getElseOrElseIfStmt();
		} else if (token.m_type == Token.Type.FUNCTION) {
			m_functionReader.getFunction();
		} else {
			throw new ParserException("Unexpected Token: ", token.toString(), m_lexer.getCurrentLocationMsg(), "begin of statement");
		}
	}
	
	public void getAssign() throws Exception {
		Token token = m_lexer.lookAheadToken();
		String varName = token.m_stringValue;
		m_lexer.advance();
		m_lexer.expect(Token.Type.ASSIGN);
		m_exprReader.getExpr();
		Symbol var = m_symbolTable.getOrCreateSymbol(varName);
		m_lexer.expect(Token.Type.SEMICOL);
		InstrIntf instr = new Instr.InstrAssign(var);
		m_compileEnv.addInstr(instr);
	}

	public void getPrint() throws Exception {
		m_lexer.advance(); // PRINT
		m_exprReader.getExpr();
		m_lexer.expect(Token.Type.SEMICOL);
		InstrIntf instr = new Instr.InstrPrint();
		m_compileEnv.addInstr(instr);
	}

	public void getCallStmt() throws Exception {
		m_lexer.advance(); // CALL
		m_lexer.expect(Token.Type.IDENT);
		m_lexer.expect(Token.Type.LPAREN);
		if (m_lexer.lookAheadToken().m_type != Token.Type.RPAREN) {
			m_exprReader.getExpr();		
			while (m_lexer.lookAheadToken().m_type == Token.Type.COMMA) {
				m_lexer.advance(); // COMMA
				m_exprReader.getExpr();
			}
		}
		m_lexer.expect(Token.Type.RPAREN);
		m_lexer.expect(Token.Type.SEMICOL);
	}

	// while statement
    // WHILE (EXPR) { STMTLIST }
    public void getWhileStmt() throws Exception {
		m_lexer.advance();
		
		// Prepare (read) condition
		m_lexer.expect(Token.Type.LPAREN);
		m_exprReader.getExpr();
		m_lexer.expect(Token.Type.RPAREN);
		getStmtList();
    }

	// do while statement
    // DO { STMTLIST } WHILE (EXPR);
    public void getDoWhileStmt() throws Exception {
    	InstrBlock doWhileBlock = new InstrBlock();
    	InstrBlock followBlock = new InstrBlock();
    	
	    InstrIntf jumpDo = new Instr.InstrJump(doWhileBlock);
	    m_compileEnv.addInstr(jumpDo);
    	m_compileEnv.setCurrentBlock(doWhileBlock);
    	
	    m_lexer.advance();
	    // Prepare (read) loop body
	    getBlockStmt();
	    
	    m_lexer.expect(Token.Type.WHILE);
	
	    // Prepare (read) condition
	    m_lexer.expect(Token.Type.LPAREN);
	    m_exprReader.getExpr();
	    m_lexer.expect(Token.Type.RPAREN);
	    m_lexer.expect(Token.Type.SEMICOL);
	    
	    InstrIntf jumpCond = new Instr.InstrCondJump(doWhileBlock, followBlock);
	    m_compileEnv.addInstr(jumpCond);
	    m_compileEnv.setCurrentBlock(followBlock);
    }

	// for statement
	public void getForStmt() throws Exception {
		m_lexer.advance();
		m_lexer.expect(Token.Type.LPAREN);
		getStmt();
		
    	InstrBlock conditionBlock = new InstrBlock();
    	InstrBlock incBlock = new InstrBlock();
    	InstrBlock bodyBlock = new InstrBlock();
    	InstrBlock followBlock = new InstrBlock();
    	
	    InstrIntf jumpCond = new Instr.InstrJump(conditionBlock);
	    m_compileEnv.addInstr(jumpCond);
    	m_compileEnv.setCurrentBlock(conditionBlock);
		
		m_exprReader.getExpr();
		m_lexer.expect(Token.Type.SEMICOL);
		
		InstrIntf jumpAfterCond = new Instr.InstrCondJump(bodyBlock, followBlock);
		m_compileEnv.addInstr(jumpAfterCond);
		m_compileEnv.setCurrentBlock(incBlock);

		getStmt();
		m_lexer.expect(Token.Type.RPAREN);
		
		m_compileEnv.addInstr(jumpCond);
		m_compileEnv.setCurrentBlock(bodyBlock);
		
		getBlockStmt();
		
	    InstrIntf jumpInc = new Instr.InstrJump(incBlock);
	    m_compileEnv.addInstr(jumpInc);
	    
	    m_compileEnv.setCurrentBlock(followBlock);
	    
	}

	public void getIfStmt() throws Exception {
		this.m_lexer.expect(Token.Type.IF);
		this.m_lexer.expect(Token.Type.LPAREN);
		this.m_exprReader.getExpr();
		this.m_lexer.expect(Token.Type.RPAREN);
		this.getBlockStmt();
		this.getElseOrElseIfStmt();
	}
	
	public void getElseIfStmt() throws Exception {
		this.m_lexer.expect(Token.Type.LPAREN);
		this.m_exprReader.getExpr();
		this.m_lexer.expect(Token.Type.RPAREN);
		this.getBlockStmt();
		this.getElseOrElseIfStmt();
	}

	public void getElseStmt() throws Exception {
		this.getBlockStmt();
	}

	public void getElseOrElseIfStmt() throws Exception {
		if(this.m_lexer.lookAheadToken().m_type == Token.Type.ELSE) {
			this.m_lexer.advance();
			if(this.m_lexer.lookAheadToken().m_type == Token.Type.IF) {
				this.m_lexer.advance();
				this.getElseIfStmt();
			} else {
				this.getElseStmt();
			}
		}
	}

}
