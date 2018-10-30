package operation.operator.implementation;

import operation.operator.BinaryOperator;

/**
 * Represents a subtraction operation
 * @author pimiao
 *
 */
public class Subtraction extends BinaryOperator {
	
	@Override
	public void doCalculation() {
		getCalculator().getStack().push(left.subtract(right, getCalculator().getMC()));
	}

}
