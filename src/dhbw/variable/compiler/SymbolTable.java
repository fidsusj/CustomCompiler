package dhbw.variable.compiler;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable implements SymbolTableIntf{

	private Map<String, Symbol> symbolTable;
	
	public SymbolTable() {
		this.symbolTable = new HashMap<>();
	}
	
	public Symbol createSymbol(String symbolName, int value) {
		return this.symbolTable.put(symbolName, new Symbol(symbolName, value));
	}

	public Symbol getSymbol(String symbolName) {
		return this.symbolTable.get(symbolName);
	}
	
}