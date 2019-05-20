package dhbw.antlr.calc;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import dhbw.antlr.calc.compiler.calcLexer;
import dhbw.antlr.calc.compiler.calcParser;

public class Main {

	public static void main(String[] args) throws IOException {
		CharStream input = CharStreams.fromFileName(args[0]);
		calcLexer lexer = new calcLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		calcParser parser = new calcParser(tokens);
		parser.setBuildParseTree(true);
		ParseTree tree = parser.calc();
		NumberCalcVisitor eval = new NumberCalcVisitor();
		System.out.println(eval.visit(tree));
	}

}