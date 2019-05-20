// Generated from calc.g4 by ANTLR 4.7.2
package dhbw.antlr.calc.compiler;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link calcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface calcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code start}
	 * labeled alternative in {@link calcParser#calc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(calcParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link calcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(calcParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link calcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(calcParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link calcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(calcParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link calcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(calcParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link calcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(calcParser.MinusContext ctx);
}