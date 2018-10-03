package in.himtech.java.mock.calc;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.timeout;

import java.util.Arrays;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

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

		//verify call to add method to be completed within 100 ms
		verify(calculatorService, timeout(100)).divide(100.0, 20.0);
		
		// invocation count can be added to ensure multiplication invocations
		// can be checked within given timeframe
		verify(calculatorService, timeout(100).times(1)).divide(100.0, 20.0);

	}

	@Test(expected = RuntimeException.class)
	public void testAgainAdd() {
		when(calculatorService.add(10.0, 20.0)).thenThrow(new RuntimeException("Addition is not possible."));

		double value = mathApplication.add(10.0, 20.0);
		Assert.assertEquals(30.0, value, 0.0);

	}

	@Test(expected = RuntimeException.class)
	public void testExcepAdd() {
		doThrow(new ArithmeticException("Addition is not possible.")).when(calculatorService.add(10.0, 20.0));

		double value = mathApplication.add(10.0, 20.0);
		Assert.assertEquals(30.0, value, 0.0);
	}

	@Test
	public void testAddAndSubtract() {

		// add the behavior to add numbers
		when(calculatorService.add(20.0, 10.0)).thenReturn(30.0);

		// subtract the behavior to subtract numbers
		when(calculatorService.subtract(20.0, 10.0)).thenReturn(10.0);

		// test the add functionality
		Assert.assertEquals(30.0, mathApplication.add(20.0, 10.0), 0);

		// test the subtract functionality
		Assert.assertEquals(10.0, mathApplication.subtract(20.0, 10.0), 0);

		// create an inOrder verifier for a single mock
		InOrder inOrder = inOrder(calculatorService);

		// following will make sure that add is first called then subtract is called.
		inOrder.verify(calculatorService).add(20.0, 10.0);
		inOrder.verify(calculatorService).subtract(20.0, 10.0);
	}

	@Test
	public void testAnswerAdd() {

		// add the behavior to add numbers
		when(calculatorService.add(20.0, 10.0)).thenAnswer(new Answer<Double>() {

			@Override
			public Double answer(InvocationOnMock invocation) throws Throwable {
				// get the arguments passed to mock
				Object[] args = invocation.getArguments();
				System.out.println("method arguments are: " + Arrays.toString(args));

				// get the mock
				Object mock = invocation.getMock();
				System.out.println("Mock Object: " + mock.toString());

				// return the result
				return 30.0;
			}
		});

		// test the add functionality
		Assert.assertEquals(30.0, mathApplication.add(20.0, 10.0), 0);
	}

	/**
	 * Mockito provides the capability to a reset a mock so that it can be reused
	 * later. Take a look at the following code snippet.
	 * <code>reset(calcService); </code> Here we've reset mock object.
	 * MathApplication makes use of calcService and after reset the mock, using
	 * mocked method will fail the test.
	 */

}
