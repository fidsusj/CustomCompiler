package dhbw.antlr.doubler;

import dhbw.antlr.doubler.compiler.doublerBaseVisitor;
import dhbw.antlr.doubler.compiler.doublerParser;
import dhbw.antlr.doubler.compiler.doublerParser.ExprContext;
import dhbw.antlr.doubler.compiler.doublerParser.LineContext;

public class DoublerVisitor extends doublerBaseVisitor<String>{

	//Merke: Für jedes Terminal in der Regel gibt es (auch hier) eine Methode im Kontextobjekt
	//Kein Iterieren über alle Kinder mit Typprüfung notwendig
	
	//Statt einen String zurück zu geben, könnte auch ein CSVToken Objekt zurück gegeben werden (hier aber zusätzlicher Overhead)
	//Siehe Lösung
	
	@Override 
	public String visitStart(doublerParser.StartContext ctx) { 
		StringBuilder line = new StringBuilder();
		for(LineContext element: ctx.line()) {
			line.append(element.accept(this)).append("\n");
		}
		return line.toString(); 
	}

	@Override 
	public String visitLines(doublerParser.LinesContext ctx) { 
		StringBuilder line = new StringBuilder();
		for(ExprContext element: ctx.expr()) {
			line.append(element.accept(this)).append(",");
		}
		return line.substring(0, line.length()-1); 
	}

	@Override 
	public String visitNumber(doublerParser.NumberContext ctx) { 
		Integer number = Integer.valueOf(ctx.getText());
		number *= 2;
		return number.toString();
	}

	@Override 
	public String visitString(doublerParser.StringContext ctx) { 
		return ctx.getText();
	}
	
}