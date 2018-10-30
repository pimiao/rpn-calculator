package calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCalculator {

	@Test
	public void test() {
		Calculator calculator = new Calculator();
		String input = "5 2";
		assertEquals("", calculator.evaluate(input));
		assertEquals("5 2", calculator.outputStack());
	}

}
