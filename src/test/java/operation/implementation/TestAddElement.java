package operation.implementation;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

import calculator.Calculator;
import exceptions.WrongNumberOfOperandsException;

public class TestAddElement {

	@Test
	public void test() {
		try {
			Calculator calculator = new Calculator();
			AddElement ad = new AddElement(BigDecimal.ONE);
			ad.setCalculator(calculator);
			ad.execute();
			assertEquals("1", calculator.outputStack());
		} catch (WrongNumberOfOperandsException e) {
			fail("Should not get any exception");
		}
	}

}
