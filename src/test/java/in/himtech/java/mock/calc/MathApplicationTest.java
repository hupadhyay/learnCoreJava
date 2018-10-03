package in.himtech.java.mock.calc;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTest {

	@Mock
	private CalculatorService calculatorService;

	@InjectMocks
	private MathApplication mathApplication;

	@Test
	public void testAdd() {
		when(mathApplication.add(10.0, 20.0)).thenReturn(30.0);

		double value = mathApplication.add(10.0, 20.0);
		Assert.assertEquals(30.0, value, 0.0);
	}

	@Test
	public void testSubtract() {
		when(mathApplication.subtract(10.0, 20.0)).thenReturn(-10.0);

		double value = mathApplication.subtract(10.0, 20.0);
		Assert.assertEquals(-10.0, value, 0.0);
	}

	@Test
	public void testMultiply() {
		when(mathApplication.multiply(10.0, 20.0)).thenReturn(300.0);

		double value = mathApplication.multiply(10.0, 20.0);
		Assert.assertEquals(300.0, value, 0.0);
	}

	@Test
	public void testDivision() {
		when(mathApplication.divide(100.0, 20.0)).thenReturn(5.0);

		double value = mathApplication.divide(100.0, 20.0);
		Assert.assertEquals(5.0, value, 0.0);

	}

}
