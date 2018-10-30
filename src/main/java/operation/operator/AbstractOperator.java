package operation.operator;

import exceptions.WrongNumberOfOperandsException;
import operation.implementation.AbstractOperation;

/**
 * Abstract base class for arithmatic operations
 * @author pimiao
 *
 */
/**
 * @author pimiao
 *
 */
public abstract class AbstractOperator extends AbstractOperation {
	
	/**
	 * Return the number of required operands
	 * @return
	 */
	protected abstract Integer requiredOperand();
	
	protected void validateOperands() throws WrongNumberOfOperandsException {
		if (getCalculator().getStack().size() != requiredOperand()) {
			throw new WrongNumberOfOperandsException();
		}
	}

	/**
	 * Do the calculation here
	 */
	protected abstract void doCalculation();
	
}
