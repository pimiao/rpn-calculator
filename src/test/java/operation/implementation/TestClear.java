package operation.implementation;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import calculator.Calculator;
import exceptions.WrongNumberOfOperandsException;

public class TestClear {

	@Test
	public void test() {
		try {
			Calculator calculator = new Calculator();
			AddElement ad = new AddElement(BigDecimal.ONE);
			ad.setCalculator(calculator);
			ad.execute();
			assertEquals("1", calculator.outputStack());
			Clear clear = new Clear();
			clear.setCalculator(calculator);
			clear.execute();
			assertEquals("", calculator.outputStack());
		} catch (WrongNumberOfOperandsException e) {
			fail("Should not get any exception");
		}
	}

}
