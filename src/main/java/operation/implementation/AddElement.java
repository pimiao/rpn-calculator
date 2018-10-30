package operation.implementation;

import java.math.BigDecimal;

/**
 * Operation for a number insertion into the stack
 * @author pimiao
 *
 */
public class AddElement extends AbstractOperation {
	
	private BigDecimal element = BigDecimal.ZERO;
	
	/**
	 * Base constructor with the argument as the number
	 * @param bigDecimal the number to be inserted
	 */
	public AddElement(BigDecimal bigDecimal) {
		element = bigDecimal;
	}

	@Override
	protected void doTask() {
		getCalculator().getStack().push(element);
	}

}
