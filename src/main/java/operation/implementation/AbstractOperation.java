package operation.implementation;

import java.math.BigDecimal;
import java.util.Stack;

import calculator.Calculator;
import exceptions.WrongNumberOfOperandsException;
import operation.Operation;

/**
 * Abstract implementation for Operation. It adds the undo functionality based on a previously saved stack before operation execution.
 * @author pimiao
 *
 */
public abstract class AbstractOperation implements Operation {
	
	private Calculator calculator;
	
	private Stack<BigDecimal> before = new Stack<BigDecimal>();

	@Override
	public Calculator getCalculator() {
		return calculator;
	}

	@Override
	public void setCalculator(Calculator c) {
		calculator = c;
	}
	
	/* (non-Javadoc)
	 * @see operation.Operation#undo()
	 */
	@Override
	public void undo() {
		getCalculator().setStack((Stack<BigDecimal>)before.clone());
	}
	
	@Override
	public void execute() throws WrongNumberOfOperandsException {
		before = (Stack<BigDecimal>)calculator.getStack().clone();
		this.doTask();
	}
	
	/**
	 * Do the job here
	 * @throws WrongNumberOfOperandsException when there're not enough operands for the operation
	 */
	protected abstract void doTask() throws WrongNumberOfOperandsException;

}
