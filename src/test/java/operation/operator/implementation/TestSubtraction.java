package operation.operator.implementation;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import calculator.Calculator;
import operation.implementation.AddElement;
import operation.implementation.Clear;

public class TestSubtraction {

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
			Subtraction subtraction = new Subtraction();
			subtraction.setCalculator(calculator);
			subtraction.execute();
			assertEquals("-1.33", calculator.outputStack());
			Clear clear = new Clear();
			clear.setCalculator(calculator);
			clear.execute();
			assertEquals("", calculator.outputStack());
		} catch (Exception e) {
			fail("Should not get any exception");
		}
	}

}
