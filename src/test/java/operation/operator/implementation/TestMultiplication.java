package operation.operator.implementation;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import calculator.Calculator;
import operation.implementation.AddElement;
import operation.implementation.Clear;

public class TestMultiplication {

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
			Multiplication m = new Multiplication();
			m.setCalculator(calculator);
			m.execute();
			assertEquals("18", calculator.outputStack());
			Clear clear = new Clear();
			clear.setCalculator(calculator);
			clear.execute();
			assertEquals("", calculator.outputStack());
		} catch (Exception e) {
			fail("Should not get any exception");
		}
	}

}
