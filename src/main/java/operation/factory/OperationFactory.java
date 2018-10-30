package operation.factory;

import java.math.BigDecimal;

import calculator.Calculator;
import operation.Operation;
import operation.implementation.AddElement;
import operation.implementation.Clear;
import operation.operator.implementation.Addition;
import operation.operator.implementation.Division;
import operation.operator.implementation.Multiplication;
import operation.operator.implementation.SquareRoot;
import operation.operator.implementation.Subtraction;

/**
 * A factory class to generate variant Operation objects based on the input entry.
 * @author pimiao
 *
 */
public class OperationFactory {
	
	private static final String CLEAR = "clear";
	private static final String SQRT = "sqrt";
	private static final String ADDITION = "+";
	private static final String SUBSTRACTION = "-";
	private static final String MULTIPLICATIN = "*";
	private static final String DIVISION = "/";

	private OperationFactory() {};
	
	/**
	 * Factory method to generate Operation objects.
	 * @param calculator
	 * @param entry
	 * @param position
	 * @return
	 * @throws NumberFormatException
	 */
	public static Operation createOperation(Calculator calculator, String entry) throws NumberFormatException {
		Operation o;
		if (CLEAR.equals(entry)) {
			o = new Clear();
		} else if (SQRT.equals(entry)) {
			o = new SquareRoot();
		} else if (ADDITION.equals(entry)){
			o = new Addition();
		} else if (SUBSTRACTION.equals(entry)) {
			o = new Subtraction();
		} else if (MULTIPLICATIN.equals(entry)) {
			o = new Multiplication();
		} else if (DIVISION.equals(entry)) {
			o = new Division();
		} else {
			o = new AddElement(new BigDecimal(entry, calculator.getMC()));
		}
		o.setCalculator(calculator);
		return o;
	}

}
