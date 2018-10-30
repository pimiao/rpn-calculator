package operation.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import calculator.Calculator;
import operation.Operation;
import operation.implementation.AddElement;
import operation.operator.implementation.Multiplication;

public class TestFactory {

	@Test
	public void test() {
		try {
			Calculator calculator = new Calculator();
			Operation o = OperationFactory.createOperation(calculator, "5");
			assertTrue(o instanceof AddElement);
			AddElement ad = (AddElement) o;
			ad.execute();
			assertEquals("5", calculator.outputStack());
			o = OperationFactory.createOperation(calculator, "2");
			assertTrue(o instanceof AddElement);
			ad = (AddElement) o;
			ad.execute();
			assertEquals("5 2", calculator.outputStack());
			o = OperationFactory.createOperation(calculator, "*");
			assertTrue(o instanceof Multiplication);
			Multiplication m = (Multiplication) o;
			m.execute();
			assertEquals("10", calculator.outputStack());
		} catch (Exception e) {
			fail("Should not get any exception");
		}
	}

}
