package operation;

import calculator.Calculator;
import exceptions.WrongNumberOfOperandsException;

/**
 * All supported operations include the following:
 * 1. AddElement operation when an entry is a number
 * 2. "+" for Addition
 * 3. "-" for Subtraction
 * 4. "*" for Multiplication
 * 5. "/" for Division
 * 6. "sqrt" for SquareRoot
 * 7. "clear" for Clear
 * This operation supports undo.
 * @author pimiao
 *
 */
public interface Operation {
	
	Calculator getCalculator();
	
	/**
	 * Set the calculator before execution
	 * @param c
	 */
	void setCalculator(Calculator c);
	
	/**
	 * Execute the operation.
	 * @throws WrongNumberOfOperandsException when there're not enough operands for the operation
	 */
	void execute() throws WrongNumberOfOperandsException;
	
	/**
	 * Undo current operation
	 */
	void undo();

}
