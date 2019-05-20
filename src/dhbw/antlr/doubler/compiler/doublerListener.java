// Generated from doubler.g4 by ANTLR 4.7.2
package dhbw.antlr.doubler.compiler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link doublerParser}.
 */
public interface doublerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Start}
	 * labeled alternative in {@link doublerParser#doubler}.
	 * @param ctx the parse tree
	 */
	void enterStart(doublerParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Start}
	 * labeled alternative in {@link doublerParser#doubler}.
	 * @param ctx the parse tree
	 */
	void exitStart(doublerParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lines}
	 * labeled alternative in {@link doublerParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLines(doublerParser.LinesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lines}
	 * labeled alternative in {@link doublerParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLines(doublerParser.LinesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link doublerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumber(doublerParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link doublerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumber(doublerParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link doublerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(doublerParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link doublerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(doublerParser.StringContext ctx);
}