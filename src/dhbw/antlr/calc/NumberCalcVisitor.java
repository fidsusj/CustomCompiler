package dhbw.antlr.calc;

import dhbw.antlr.calc.compiler.calcBaseVisitor;
import dhbw.antlr.calc.compiler.calcParser;

public class NumberCalcVisitor extends calcBaseVisitor<Integer>{

	@Override 
	public Integer visitStart(calcParser.StartContext ctx) { 
		return visit(ctx.getChild(0)); 
	}

	@Override 
	public Integer visitDiv(calcParser.DivContext ctx) { 
		return new Integer(visit(ctx.expr(0)) / visit(ctx.expr(1)));
	}

	@Override 
	public Integer visitNumber(calcParser.NumberContext ctx) { 
		return new Integer(ctx.NUMBER().getText());
	}

	@Override 
	public Integer visitMul(calcParser.MulContext ctx) { 
		return new Integer(visit(ctx.expr(0)) * visit(ctx.expr(1)));
	}

	@Override 
	public Integer visitPlus(calcParser.PlusContext ctx) { 
		return new Integer(visit(ctx.expr(0)) + visit(ctx.expr(1)));
	}

	@Override 
	public Integer visitMinus(calcParser.MinusContext ctx) { 
		return new Integer(visit(ctx.expr(0)) - visit(ctx.expr(1)));
	}
	
}