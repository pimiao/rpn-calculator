package operation.operator.implementation;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import calculator.Calculator;
import operation.implementation.AddElement;
import operation.implementation.Clear;

public class TestSquareRoot {

	@Test
	public void test() {
		try {
			Calculator calculator = new Calculator();
			AddElement ad = new AddElement(new BigDecimal("4"));
			ad.setCalculator(calculator);
			ad.execute();
			SquareRoot sr = new SquareRoot();
			sr.setCalculator(calculator);
			sr.execute();
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
			AddElement ad = new AddElement(new BigDecimal("-2"));
			ad.setCalculator(calculator);
			ad.execute();
			SquareRoot sr = new SquareRoot();
			sr.setCalculator(calculator);
			sr.execute();
		} catch (Exception e) {
			assertTrue(e instanceof ArithmeticException);
		}
	}

}
