package operation.operator.implementation;

import java.math.BigDecimal;

import calculator.Calculator;
import operation.operator.UnaryOperator;

/**
 * Represents a square root operation
 * @author pimiao
 *
 */
public class SquareRoot extends UnaryOperator {
	
	@Override
	public void doCalculation() {
		if (operand.compareTo(BigDecimal.ZERO) < 0) {
			getCalculator().getStack().push(operand);
			throw new ArithmeticException(Calculator.EXCEPTION_OF_NEGATIVE_SQUARE_ROOT);
		}
		getCalculator().getStack().push(operand.sqrt(getCalculator().getMC()));
	}

}
