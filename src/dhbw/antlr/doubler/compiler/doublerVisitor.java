// Generated from doubler.g4 by ANTLR 4.7.2
package dhbw.antlr.doubler.compiler;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link doublerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface doublerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Start}
	 * labeled alternative in {@link doublerParser#doubler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(doublerParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Lines}
	 * labeled alternative in {@link doublerParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLines(doublerParser.LinesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link doublerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(doublerParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link doublerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(doublerParser.StringContext ctx);
}