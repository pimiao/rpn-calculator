package operation.operator.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;

import calculator.Calculator;
import operation.implementation.AddElement;
import operation.implementation.Clear;

public class TestDivision {

	@Test
	public void test() {
		try {
			Calculator calculator = new Calculator();
			AddElement ad = new AddElement(new BigDecimal("6"));
			ad.setCalculator(calculator);
			ad.execute();
			ad = new AddElement(new BigDecimal("3"));
			ad.setCalculator(calculator);
			ad.execute();
			Division division = new Division();
			division.setCalculator(calculator);
			division.execute();
			assertEquals("2", calculator.outputStack());
			Clear clear = new Clear();
			clear.setCalculator(calculator);
			clear.execute();
			assertEquals("", calculator.outputStack());
		} catch (Exception e) {
			fail("Should not get any exception");
		}

		try {
			Calculator calculator = new Calculator();
			AddElement ad = new AddElement(new BigDecimal("6"));
			ad.setCalculator(calculator);
			ad.execute();
			ad = new AddElement(new BigDecimal("0"));
			ad.setCalculator(calculator);
			ad.execute();
			Division division = new Division();
			division.setCalculator(calculator);
			division.execute();
		} catch (Exception e) {
			assertTrue(e instanceof ArithmeticException);
		}
	}

}
