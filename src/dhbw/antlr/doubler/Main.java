package dhbw.antlr.doubler;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import dhbw.antlr.doubler.compiler.doublerLexer;
import dhbw.antlr.doubler.compiler.doublerParser;

public class Main {

	public static void main(String[] args) throws IOException {
		CharStream input = CharStreams.fromFileName(args[0]);
		doublerLexer lexer = new doublerLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		doublerParser parser = new doublerParser(tokens);
		parser.setBuildParseTree(true);
		ParseTree tree = parser.doubler();
		DoublerVisitor eval = new DoublerVisitor();
		System.out.println(eval.visit(tree));
	}

}