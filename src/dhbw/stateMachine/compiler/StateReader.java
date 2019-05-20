package dhbw.stateMachine.compiler;

import dhbw.fileReader.compiler.FileReaderIntf;

public class StateReader implements StateReaderIntf {

	private FileReaderIntf reader;
	private StateMap statemap;
	
	public StateReader(FileReaderIntf reader) {
		this.reader = reader;
		this.statemap = new StateMap();
	}
	
	public void readState() throws Exception {
		String identifier = this.readIdent();
		State state = statemap.getState(identifier);
		this.reader.expect(':');
		while(this.reader.lookAheadChar() == '(') {
			this.readTransition(state);
		}
		if(this.reader.lookAheadChar() == '!') {
			state.setFinal();
			this.reader.advance();
		}
		this.reader.expect('\n');
	}

	public void readTransition(State state) throws Exception {
		this.reader.expect('(');
		char transition = this.reader.lookAheadChar();
		this.reader.advance();
		this.reader.expect(',');
		String transitionState = this.readIdent();
		this.reader.expect(')');
		state.addTransition(transition, this.statemap.getState(transitionState));
	}
	
	public String readIdent() throws Exception {
		StringBuilder identifier = new StringBuilder();
		identifier.append(this.reader.lookAheadChar());
		if(!isIdentifierStart(identifier.charAt(0)))
			throw new Exception("Identifier expected");
		this.reader.advance();
		while(isIdentifierPart(this.reader.lookAheadChar())) {
			identifier.append(this.reader.lookAheadChar());
			this.reader.advance();
		}
		return identifier.toString();
	}

	public boolean isIdentifierStart(char c) {
		return ('a' <= c && c <= 'z');
	}

	public boolean isIdentifierPart(char c) {
		return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
	}

	public StateMap getStateMap() {
		return statemap;
	}

}