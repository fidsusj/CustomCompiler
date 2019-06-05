package dhbw.project.interpreter.compiler;

public class ExprReader extends ExprReaderIntf {

	public ExprReader(SymbolTable symbolTable, LexerIntf lexer, CompileEnv compileEnv) throws Exception {
		super(symbolTable, lexer, compileEnv);
	}
	
	public void getFactor() throws Exception {
		Token token = m_lexer.lookAheadToken(); 
		if (token.m_type == Token.Type.INTEGER) {
			m_lexer.advance();
			InstrIntf instr = new Instr.InstrNumber(token.m_intValue);
			m_compileEnv.addInstr(instr);
		} else if (token.m_type == Token.Type.LPAREN) {
			m_lexer.advance();
			getExpr();
			m_lexer.expect(Token.Type.RPAREN);
		} else if (token.m_type == Token.Type.IDENT) {
			m_lexer.advance();
			Symbol var = m_symbolTable.getSymbol(token.m_stringValue);
			InstrIntf instr = new Instr.InstrVar(var);
			m_compileEnv.addInstr(instr);
		} else {
			throw new ParserException("Unexpected Token: ", token.toString(), m_lexer.getCurrentLocationMsg(), "numerical expression");
		}
	}
	
	public void getExpr() throws Exception {
		getSum();
		Token token = m_lexer.lookAheadToken(); 
		while (
			token.m_type == Token.Type.LESS ||
			token.m_type == Token.Type.GREATER ||
			token.m_type == Token.Type.EQUAL
		) {
			m_lexer.advance();
			getSum();
			InstrIntf instr = (token.m_type == Token.Type.LESS) ?
				new Instr.InstrLess() :
				token.m_type == Token.Type.GREATER ? new Instr.InstrGreater() : new Instr.InstrEqual();
			m_compileEnv.addInstr(instr);
			token = m_lexer.lookAheadToken(); 
		}
	}

	public void getSum() throws Exception {
		getProduct();
		Token token = m_lexer.lookAheadToken(); 
		while (token.m_type == Token.Type.PLUS || token.m_type == Token.Type.MINUS) {
			m_lexer.advance();
			getProduct();
			InstrIntf instr = (token.m_type == Token.Type.PLUS) ? new Instr.InstrAdd() : new Instr.InstrSub();
			m_compileEnv.addInstr(instr);
			token = m_lexer.lookAheadToken(); 
		}
	}

	public void getProduct() throws Exception {
		getFactor();
		Token token = m_lexer.lookAheadToken(); 
		while (token.m_type == Token.Type.MUL) {
			m_lexer.advance();
			getFactor();
			InstrIntf instr = (token.m_type == Token.Type.MUL) ? new Instr.InstrMul() : new Instr.InstrDiv();
			m_compileEnv.addInstr(instr);
			token = m_lexer.lookAheadToken(); 
		}
	}
}
