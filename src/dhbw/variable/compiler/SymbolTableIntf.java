package dhbw.variable.compiler;

public interface SymbolTableIntf {

    // construct an empty symbol table	
	// public SymbolTableIntf();

	// create symbol for given symbolName, returns the new symbol
	public Symbol createSymbol(String symbolName, int value);

	// get symbol for given symbolName, returns null if no symbol with the given name was found
	public Symbol getSymbol(String symbolName);
}