package operation.operator;

import java.math.BigDecimal;

import exceptions.WrongNumberOfOperandsException;

/**
 * Represents a binary operator like addition.
 * @author pimiao
 *
 */
public abstract class BinaryOperator extends AbstractOperator {
	
	protected BigDecimal left = BigDecimal.ONE;
	
	protected BigDecimal right = BigDecimal.ONE;

	@Override
	public Integer requiredOperand() {
		return 2;
	}
	
	@Override
	protected void doTask() throws WrongNumberOfOperandsException {
		validateOperands();
		right = getCalculator().getStack().pop();
		left = getCalculator().getStack().pop();
		doCalculation();
	}
	
}
