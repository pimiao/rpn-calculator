package operation.operator.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;

import calculator.Calculator;
import operation.implementation.AddElement;
import operation.implementation.Clear;

public class TestAddition {

	@Test
	public void test() {
		try {
			Calculator calculator = new Calculator();
			AddElement ad = new AddElement(BigDecimal.ONE);
			ad.setCalculator(calculator);
			ad.execute();
			ad = new AddElement(new BigDecimal("2.33"));
			ad.setCalculator(calculator);
			ad.execute();
			Addition addition = new Addition();
			addition.setCalculator(calculator);
			addition.execute();
			assertEquals("3.33", calculator.outputStack());
			Clear clear = new Clear();
			clear.setCalculator(calculator);
			clear.execute();
			assertEquals("", calculator.outputStack());
		} catch (Exception e) {
			fail("Should not get any exception");
		}
	}

}
