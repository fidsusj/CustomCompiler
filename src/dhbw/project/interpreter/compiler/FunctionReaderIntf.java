package dhbw.project.interpreter.compiler;

abstract public class FunctionReaderIntf {

    SymbolTable m_symbolTable;
    LexerIntf m_lexer;
    StmtReaderIntf m_stmtReader;

    public FunctionReaderIntf(SymbolTable symbolTable, LexerIntf lexer, StmtReaderIntf stmtReader) throws Exception {
        m_symbolTable = symbolTable;
        m_lexer = lexer;
        m_stmtReader = stmtReader;
    }

    // read factor
    abstract public void getFunction() throws Exception;

    // read expression
    abstract public void getParamListEntry() throws Exception;

    // read product
    abstract public void getParamList() throws Exception;
}
