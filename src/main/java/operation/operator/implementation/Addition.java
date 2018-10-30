package operation.operator.implementation;

import operation.operator.BinaryOperator;

/**
 * Represents an addition operation
 * @author pimiao
 *
 */
public class Addition extends BinaryOperator {
	
	@Override
	public void doCalculation() {
		getCalculator().getStack().push(left.add(right, getCalculator().getMC()));
	}

}
