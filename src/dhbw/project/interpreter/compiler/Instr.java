package dhbw.project.interpreter.compiler;

public abstract class Instr implements InstrIntf {

	static class InstrNumber extends Instr {
		private int m_number;

		public InstrNumber(int number) {
			m_number = number;
		}
		public void execute(ExecutionEnvIntf env) {
			env.pushNumber(m_number);
		}
	}
	
	static class InstrVar extends Instr {
		private Symbol m_symbol;
		
		public InstrVar(Symbol symbol) {
			m_symbol = symbol;
		}

		public void execute(ExecutionEnvIntf env) {
			env.pushNumber(m_symbol.m_number);
		}
	}

	static class InstrAdd extends Instr {
		public void execute(ExecutionEnvIntf env) {
			int op0 = env.popNumber();
			int op1 = env.popNumber();
			int result = op0 + op1;
			env.pushNumber(result);
		}
	}
	
	static class InstrSub extends Instr {
		public void execute(ExecutionEnvIntf env) {
			int op0 = env.popNumber();
			int op1 = env.popNumber();
			int result = op1 - op0;
			env.pushNumber(result);
		}
	}
	
	static class InstrMul extends Instr {
		public void execute(ExecutionEnvIntf env) {
			int op0 = env.popNumber();
			int op1 = env.popNumber();
			int result = op0 * op1;
			env.pushNumber(result);
		}
	}
	
	static class InstrDiv extends Instr {
		public void execute(ExecutionEnvIntf env) {
			int op0 = env.popNumber();
			int op1 = env.popNumber();
			int result = op1 / op0;
			env.pushNumber(result);
		}
	}

	static class InstrLess extends Instr {
		public void execute(ExecutionEnvIntf env) {
			int op0 = env.popNumber();
			int op1 = env.popNumber();
			int result = op1 < op0 ? 1 : 0;
			env.pushNumber(result);
		}
	}

	static class InstrGreater extends Instr {
		public void execute(ExecutionEnvIntf env) {
			int op0 = env.popNumber();
			int op1 = env.popNumber();
			int result = op1 > op0 ? 1 : 0;
			env.pushNumber(result);
		}
	}

	static class InstrEqual extends Instr {
		public void execute(ExecutionEnvIntf env) {
			int op0 = env.popNumber();
			int op1 = env.popNumber();
			int result = op1 == op0 ? 1 : 0;
			env.pushNumber(result);
		}
	}

	static class InstrAssign extends Instr {
		private Symbol m_symbol;
		
		public InstrAssign(Symbol symbol) {
			m_symbol = symbol;
		}

		public void execute(ExecutionEnvIntf env) {
			int expr = env.popNumber();
			m_symbol.m_number = expr;
		}
	}
	
	static class InstrPrint extends Instr {
		public void execute(ExecutionEnvIntf env) {
			int expr = env.popNumber();
			try {
			  env.getOutputStream().write(Integer.toString(expr));
			  env.getOutputStream().write('\n');
			  env.getOutputStream().flush();
			} catch (Exception e) {
			  System.err.println(e.getStackTrace());
			}
		}		
	}
	
	static class InstrJump extends Instr {
		private InstrBlock m_target;
		
		InstrJump(InstrBlock target) {
			m_target = target;
		}

		public void execute(ExecutionEnvIntf env) {
			env.setInstrIter(m_target.getIterator());
		}		
	}
	
	static class InstrCondJump extends Instr {
		private InstrBlock m_targetTrue;
		private InstrBlock m_targetFalse;
		
		InstrCondJump(InstrBlock targetTrue, InstrBlock targetFalse) {
			m_targetTrue = targetTrue;
			m_targetFalse = targetFalse;
		}

		public void execute(ExecutionEnvIntf env) {
			int cond = env.popNumber();
			if (cond == 0) {
				env.setInstrIter(m_targetFalse.getIterator());				
			} else {
				env.setInstrIter(m_targetTrue.getIterator());								
			}
		}		
	}
}
