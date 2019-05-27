package dhbw.variable.compiler;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;

public class StmtReader implements StmtReaderIntf{

	private LexerIntf lexer;
	private SymbolTable table;
	private ExprReaderIntf reader;
	private OutputStreamWriter stream;

	public StmtReader(LexerIntf lexer, ByteArrayOutputStream stream) throws Exception {
		this.lexer = lexer;
		this.table = new SymbolTable();
		this.reader = new ExprReader(this.table, lexer);
		this.stream = new OutputStreamWriter(stream, "UTF-8");
	}
	
	public void getStmtList() throws Exception {
		while(this.lexer.lookAheadToken().m_type != TokenIntf.Type.EOF) {
			this.getStmt();
		}
		this.stream.flush(); //needed to write from buffer to IO
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
		int value = this.reader.getExpr();
		this.stream.write(String.format("%d\n", value));
	}

}