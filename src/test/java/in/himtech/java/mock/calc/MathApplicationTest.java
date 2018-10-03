package in.himtech.java.mock.calc;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTest {

	@Mock
	private CalculatorService calculatorService;

	@InjectMocks
	private MathApplication mathApplication;

	@Test
	public void testAdd() {
		when(calculatorService.add(10.0, 20.0)).thenReturn(30.0);

		double value = mathApplication.add(10.0, 20.0);
		Assert.assertEquals(30.0, value, 0.0);

		// This verify will test weather the function is called with same argument or
		// not.
		verify(calculatorService).add(10.0, 20.0);

		// check if add function is called minimum 1 times
		verify(calculatorService, atLeast(1)).add(10.0, 20.0);
	}

	@Test
	public void testSubtract() {
		when(calculatorService.subtract(10.0, 20.0)).thenReturn(-10.0);

		double value = mathApplication.subtract(10.0, 20.0);
		double value1 = mathApplication.subtract(10.0, 20.0);
		Assert.assertEquals(-10.0, value, 0.0);
		Assert.assertEquals(-10.0, value1, 0.0);

		// This verify the number of calls to subtract method on mock object.
		verify(calculatorService, times(2)).subtract(10.0, 20.0);

		// check if subtract function is called maximum 2 times
		verify(calculatorService, atMost(2)).subtract(10.0, 20.0);
	}

	@Test
	public void testMultiply() {
		when(calculatorService.multiply(10.0, 20.0)).thenReturn(300.0);

		double value = mathApplication.multiply(10.0, 20.0);
		Assert.assertEquals(300.0, value, 0.0);

		// This will verify the method is not called a single times on mock object.
		// verify(calculatorService, never()).multiply(10.0, 20.0);
	}

	@Test
	public void testDivision() {
		when(calculatorService.divide(100.0, 20.0)).thenReturn(5.0);

		double value = mathApplication.divide(100.0, 20.0);
		Assert.assertEquals(5.0, value, 0.0);

		// check a minimum 1 call count
		verify(calculatorService, atLeastOnce()).divide(100.0, 20.0);
	}

}
