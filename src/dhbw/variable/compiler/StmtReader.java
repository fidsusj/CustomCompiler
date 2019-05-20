package dhbw.variable.compiler;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;

public class StmtReader implements StmtReaderIntf{

	private LexerIntf lexer;
	private SymbolTable table;
	private ExprReaderIntf reader;
	private ByteArrayOutputStream stream;

	public StmtReader(LexerIntf lexer, ByteArrayOutputStream stream) throws Exception {
		this.lexer = lexer;
		this.table = new SymbolTable();
		this.reader = new ExprReader(table, lexer);
		this.stream = stream;
	}
	
	public void getStmtList() throws Exception {
		while(this.lexer.lookAheadToken().m_type != TokenIntf.Type.EOF) {
			this.getStmt();
		}
	}

	public void getStmt() throws Exception {
		if(this.lexer.lookAheadToken().m_type == TokenIntf.Type.PRINT) {
			this.getPrint();
		} else {
			this.getAssign();
		}
		this.lexer.expect(TokenIntf.Type.SEMICOL);
	}

	public void getAssign() throws Exception {
		String var = this.lexer.lookAheadToken().m_stringValue;
		this.lexer.advance();
		this.lexer.expect(TokenIntf.Type.ASSIGN);
		int value = this.reader.getExpr();
		this.table.createSymbol(var, value);
	}

	public void getPrint() throws Exception {
		this.lexer.expect(TokenIntf.Type.PRINT);
		Token token = this.lexer.lookAheadToken();
		int value = token.m_type == TokenIntf.Type.IDENT ? this.table.getSymbol(token.m_stringValue).m_number : token.m_intValue;
		this.lexer.advance();
		
		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(this.stream))) {
			writer.write(String.format("%d\n", value));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}