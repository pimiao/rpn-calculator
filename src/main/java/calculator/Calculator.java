package calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

import exceptions.WrongNumberOfOperandsException;
import operation.Operation;
import operation.factory.OperationFactory;

/**
 * The main calculator class and entry point.
 * The main method reads input from console then passes it to the calculator for evaluation.
 * After it, the current state of the calculator stack will be printed to console unless it's empty.
 * If there's any error, it will be printed before the stack status.
 * @author pimiao
 *
 */
public class Calculator {
	
	public static final String EXCEPTION_OF_NEGATIVE_SQUARE_ROOT = "Attempted square root of negative BigDecimal";
	
	public static final String EXCEPTION_OF_DIVISION_BY_ZERO = "Division by zero";

	private static final String UNDO = "undo";
	
	private static final String EM_INVALID_ENTRY = "Invalid entry %s (position: %s)";
	
	private static final String EM_DIVISION_BY_ZERO = "Division by zero (position: %s)";

	private static final String EM_NEGATIVE_SQUARE_ROOT = "Attempted squre root of negative number (position: %s)";

	private static final String EM_NOT_ENOUGH_OPERANDS = "operator %s (position: %s): insucient parameters";

	private Stack<BigDecimal> stack = new Stack<>();
	
	private Stack<Operation> lastTwo = new Stack<>();
	
	private MathContext MC = new MathContext(15, RoundingMode.HALF_EVEN);

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Calculator calculator = new Calculator();
		while(scan.hasNextLine()) {
			String input = scan.nextLine();
			String output = calculator.evaluate(input);
			if (!"".equals(output)) {
				System.out.println(output);
			}
			if (calculator.getStack().size() > 0)
				System.out.println(calculator.outputStack());
		}
	}
	
	/**
	 * Format the calculator stack and return it.
	 * @return the formatted string that represents the current stack status
	 */
	public String outputStack() {
		StringBuilder sb = new StringBuilder();
		for (BigDecimal bd : stack) {
			BigDecimal temp = bd.setScale(10, RoundingMode.FLOOR).stripTrailingZeros();
			sb.append(temp.toPlainString()).append(" ");
		}
		return sb.toString().trim();
	}

	/**
	 * Evaluate the input and do the calculation based on it
	 * @param input input string
	 * @return error string if any issue or an empty string otherwise
	 */
	public String evaluate(String input) {
		List<String> entries = Arrays.stream(input.split(" ")).collect(Collectors.toList());
		int position = 1;
		for (String entry : entries) {
			if (UNDO.equals(entry)) {
				if (lastTwo.size() > 0) {
					lastTwo.pop().undo();
				} else {
					return "Only two consecutive undos are supported";
				}
			} else if ("".equals(entry)) {
				// do nothing;
			} else {
				try {
					Operation operation = OperationFactory.createOperation(this, entry);
					operation.execute();
					if (lastTwo.size() == 2) {
						lastTwo.remove(0);
					}
					lastTwo.push(operation);
				} catch (WrongNumberOfOperandsException e) {
					return String.format(EM_NOT_ENOUGH_OPERANDS, entry, position);
				} catch (NumberFormatException ex) {
					return String.format(EM_INVALID_ENTRY, entry, position);
				} catch (ArithmeticException exx) {
					if (exx.getMessage().equals(EXCEPTION_OF_NEGATIVE_SQUARE_ROOT)) {
						return String.format(EM_NEGATIVE_SQUARE_ROOT, position);
					}
					return String.format(EM_DIVISION_BY_ZERO, position);
				}
			}
			position += entry.length() + 1;
		}
		return "";
	}

	public Stack<BigDecimal> getStack() {
		return stack;
	}

	public void setStack(Stack<BigDecimal> stack) {
		this.stack = stack;
	}

	public MathContext getMC() {
		return MC;
	}

}
