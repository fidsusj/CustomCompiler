package dhbw.project.interpreter;

import dhbw.project.interpreter.compiler.CompileEnv;

public class InterpreterManualMain {

	public static void main(String[] args) throws Exception {
		System.out.println("BEGIN");
		CompileEnv compiler = new CompileEnv(args[0]);
		compiler.compile();
		compiler.execute(System.out);
		System.out.println("END");
	}

}
