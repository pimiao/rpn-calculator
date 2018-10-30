package operation.operator;

import java.math.BigDecimal;

import exceptions.WrongNumberOfOperandsException;

/**
 * Represents a unary operation like square root
 * @author pimiao
 *
 */
public abstract class UnaryOperator extends AbstractOperator {
	
	protected BigDecimal operand = BigDecimal.ONE;
	
	@Override
	public Integer requiredOperand() {
		return 1;
	}

	@Override
	public void doTask() throws WrongNumberOfOperandsException {
		validateOperands();
		operand = getCalculator().getStack().pop();
		doCalculation();
	}
	
}
