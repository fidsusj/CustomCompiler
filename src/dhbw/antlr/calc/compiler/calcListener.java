// Generated from calc.g4 by ANTLR 4.7.2
package dhbw.antlr.calc.compiler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link calcParser}.
 */
public interface calcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code start}
	 * labeled alternative in {@link calcParser#calc}.
	 * @param ctx the parse tree
	 */
	void enterStart(calcParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code start}
	 * labeled alternative in {@link calcParser#calc}.
	 * @param ctx the parse tree
	 */
	void exitStart(calcParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Div}
	 * labeled alternative in {@link calcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDiv(calcParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link calcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDiv(calcParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link calcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumber(calcParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link calcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumber(calcParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link calcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMul(calcParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link calcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMul(calcParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link calcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlus(calcParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link calcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlus(calcParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link calcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMinus(calcParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link calcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMinus(calcParser.MinusContext ctx);
}