package operation.implementation;

/**
 * Operation to clear the stack
 * @author pimiao
 *
 */
public class Clear extends AbstractOperation {

	@Override
	public void doTask() {
		getCalculator().getStack().clear();
	}

}
