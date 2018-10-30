package operation.operator.implementation;

import java.math.BigDecimal;

import calculator.Calculator;
import operation.operator.BinaryOperator;

/**
 * Represents a division operation
 * @author pimiao
 *
 */
public class Division extends BinaryOperator {
	
	@Override
	public void doCalculation() {
		if (right.equals(BigDecimal.ZERO)) {
			getCalculator().getStack().push(left);
			getCalculator().getStack().push(right);
			throw new ArithmeticException(Calculator.EXCEPTION_OF_DIVISION_BY_ZERO);
		}
		getCalculator().getStack().push(left.divide(right, getCalculator().getMC()));
	}

}
