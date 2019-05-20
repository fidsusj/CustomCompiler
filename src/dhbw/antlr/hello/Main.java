package dhbw.antlr.hello;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {

	public static void main(String[] args) throws IOException {
		
		CharStream input = CharStreams.fromFileName(args[0]);
		helloLexer lexer = new helloLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		helloParser parser = new helloParser(tokens);
		parser.setBuildParseTree(true);
		ParseTree tree = parser.r();
		System.out.println(tree.toStringTree(parser));
		
	}

}