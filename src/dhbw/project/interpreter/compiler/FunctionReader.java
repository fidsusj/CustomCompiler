package dhbw.project.interpreter.compiler;

public class FunctionReader extends FunctionReaderIntf {


    public FunctionReader(SymbolTable symbolTable, LexerIntf lexer, StmtReaderIntf stmtReader) throws Exception {
        super(symbolTable, lexer, stmtReader);
    }

    public void getFunction() throws Exception {
        m_lexer.advance();

        Token tokenFunctionName = m_lexer.lookAheadToken();
        m_lexer.expect(Token.Type.IDENT);
        @SuppressWarnings("unused")
		String functionName = tokenFunctionName.m_stringValue;

        m_lexer.expect(Token.Type.LPAREN);
        getParamListEntry();
        m_lexer.expect(Token.Type.RPAREN);
        m_lexer.expect(Token.Type.LBRACE);
        m_stmtReader.getStmtList();
        m_lexer.expect(Token.Type.RBRACE);
    }

    public void getParamListEntry() throws Exception{
        Token param =  m_lexer.lookAheadToken();

        if(param.m_type == Token.Type.IDENT){
            getParamList();
        }
    }

    public void getParamList() throws Exception {

        boolean repeat;

        do{
            repeat = false;
            Token param =  m_lexer.lookAheadToken();
            m_lexer.expect(Token.Type.IDENT);
            String paramName = param.m_stringValue;
            m_symbolTable.getOrCreateSymbol(paramName);

            Token nextToken = m_lexer.lookAheadToken();
            if(nextToken.m_type == Token.Type.COMMA){
                m_lexer.advance();
                repeat = true;
            }

        }while (repeat);

    }
}

