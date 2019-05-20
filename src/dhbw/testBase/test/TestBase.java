package dhbw.testBase.test;

public abstract class TestBase extends TestBaseIntf{
	
	public TestBase(String fileName) throws Exception {
		super(fileName);
	}

	public void readAndExecuteTestSequence() throws Exception {
		if(this.m_fileReader.lookAheadChar() != 0) {
			this.readAndExecuteTestCase();
			this.readAndExecuteTestSequence();	
		}
	}

	public void readAndExecuteTestCase() throws Exception {
		this.readDollarIn();
		String input = this.readTestContent();
		this.readDollarOut();
		String output = this.readTestContent();
		this.executeTestCase(input, output);
	}

	public String readTestContent() throws Exception {
		StringBuilder content = new StringBuilder();
		while(this.m_fileReader.lookAheadChar() != '$' && this.m_fileReader.lookAheadChar() != 0) {
			content.append(this.m_fileReader.lookAheadChar());
			this.m_fileReader.advance();
		}
		return new StringBuilder(content.toString().replace(System.lineSeparator(),"\n")).toString();
	}

	public void readDollarIn() throws Exception {
		this.m_fileReader.expect('$');
		this.m_fileReader.expect('I');
		this.m_fileReader.expect('N');
		this.m_fileReader.expect('\r');
		this.m_fileReader.expect('\n');
	}

	public void readDollarOut() throws Exception {
		this.m_fileReader.expect('$');
		this.m_fileReader.expect('O');
		this.m_fileReader.expect('U');
		this.m_fileReader.expect('T');
		this.m_fileReader.expect('\r');
		this.m_fileReader.expect('\n');
	}

	protected abstract String executeTest(String input) throws Exception;

}