package operation.operator.implementation;

import operation.operator.BinaryOperator;

/**
 * Represents a multiplication operation
 * @author pimiao
 *
 */
public class Multiplication extends BinaryOperator {
	
	@Override
	public void doCalculation() {
		getCalculator().getStack().push(left.multiply(right, getCalculator().getMC()));
	}

}
