package dhbw.project.conditionals.compiler;

public class ConditionalReader extends ConditionalReaderIntf{

	public ConditionalReader(LexerIntf lexer, StmtReaderIntf stmtreader, CompareReaderIntf compreader) throws Exception {
		super(lexer, stmtreader, compreader);
	}

	public void getIf() throws Exception {
		this.m_lexer.expect(Token.Type.IF);
		this.m_lexer.expect(Token.Type.LPAREN);
		this.getCond();
		this.m_lexer.expect(Token.Type.RPAREN);
		this.m_stmtreader.getBlockStmt();
		this.parseElseOrElseIf();
	}
	
	public void getElseIf() throws Exception {
		this.m_lexer.expect(Token.Type.LPAREN);
		this.getCond();
		this.m_lexer.expect(Token.Type.RPAREN);
		this.m_stmtreader.getBlockStmt();
		this.parseElseOrElseIf();
	}

	public void getElse() throws Exception {
		this.m_stmtreader.getBlockStmt();
	}

	@Override
	public void getCond() throws Exception {
		if(this.m_lexer.lookAheadToken().m_type == Token.Type.LPAREN) {
			this.m_lexer.advance();
			this.getCond();
			this.m_lexer.expect(Token.Type.RPAREN);
		} else {
			this.m_compreader.getCompStmt();
			Token logicalOperator = this.m_lexer.lookAheadToken();
			if(logicalOperator.m_type == Token.Type.BITWISEAND || 
			   logicalOperator.m_type == Token.Type.AND ||
			   logicalOperator.m_type == Token.Type.BITWISEOR ||
			   logicalOperator.m_type == Token.Type.OR ) {
				this.m_lexer.advance();
				this.getCond();
			}
		}
	}
	
	private void parseElseOrElseIf() throws Exception {
		if(this.m_lexer.lookAheadToken().m_type == Token.Type.ELSE) {
			this.m_lexer.advance();
			if(this.m_lexer.lookAheadToken().m_type == Token.Type.IF) {
				this.m_lexer.advance();
				this.getElseIf();
			} else {
				this.getElse();
			}
		}
	}
}