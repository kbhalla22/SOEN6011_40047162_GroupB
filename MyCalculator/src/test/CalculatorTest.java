package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Calculator_package.Calculator;

/**
 * Class that contains the test cases for Calculator.java
 * 
 * @author karanbhalla
 *
 */
public class CalculatorTest {
	// Object of the calculator class
	private static Calculator calculator;

	/**
	 * This method is executed before every method & it initializes the object of
	 * the Calculator class
	 */
	@Before
	public void setupObject() {
		calculator = new Calculator();
	}

	/**
	 * This method tests the add function.
	 */
	@Test
	public void testAdd() {

		double x = 5;
		double y = 10;
		double ans = calculator.add(x, y);
		assertEquals(15, ans, 0.0f);

	}

	/**
	 * This method tests the error divide by zero.
	 */
	@Test
	public void divideByZero() {
		// ArrayList containing a list of error messages
		List<String> al2 = new ArrayList<String>();
		double x = 5;
		double y = 0;
		// test case passes if error message is present in the arraylist
		String error = "Please enter a number other than 0";
		calculator.divide(x, y, al2);
		assertTrue(al2.contains(error));

	}

	/**
	 * This method tests the subtract method.
	 */
	@Test
	public void testSubtract() {
		double x = 3;
		double y = 2;
		double ans = calculator.subtract(x, y);
		assertEquals(1, ans, 0.0f);
	}

	/**
	 * This method tests the multiply method.
	 */
	@Test
	public void test_multiply() {
		double x = 3;
		double y = 2;
		double ans = calculator.multiply(x, y);
		assertEquals(6, ans, 0.0f);
	}

	/**
	 * This method tests the divide method.
	 */
	@Test
	public void testDivide() {
		double x = 10;
		List<String> al3 = new ArrayList<String>();
		double y = 2;
		double ans = calculator.divide(x, y, al3);
		assertEquals(5, ans, 0.0f);
	}

	/**
	 * First method that calculates the value returned by the Tan function.
	 */
	@Test
	public void testCalculateTan1() {
		double x = 5;
		double ans = calculator.calculateTan(x);
		assertEquals(-3.3805150062465894, ans, 0.0f);
	}

	/**
	 * Second method that calculates the value returned by the Tan function.
	 */
	@Test
	public void testCalculateTan2() {
		double x = 95;
		double ans = calculator.calculateTan(x);
		assertEquals(0.9357524720632461, ans, 0.0f);
	}

	/**
	 * Third method that calculates the value returned by the Tan function.
	 */
	@Test
	public void testCalculateTan3() {
		double x = 45;
		double ans = calculator.calculateTan(x);
		assertEquals(1.6197751905438684, ans, 0.0f);
	}

	/**
	 * Fourth method that calculates the value returned by the Tan function.
	 */
	@Test
	public void testCalculateTan4() {
		double x = 89;
		double ans = calculator.calculateTan(x);
		assertEquals(1.6858253705060295, ans, 0.0f);
	}

	/**
	 * Fifth method that calculates the value returned by the Tan function.
	 */
	@Test
	public void testCalculateTan5() {
		double x = 275;
		double ans = calculator.calculateTan(x);
		assertEquals(-9.001181796295986, ans, 0.0f);
	}

	/**
	 * Sixth method that calculates the value returned by the Tan function.
	 */
	@Test
	public void testCalculateTan6() {
		double x = 11;
		double ans = calculator.calculateTan(x);
		assertEquals(-225.95084645035038, ans, 0.0f);
	}

	/**
	 * Seventh method that calculates the value returned by the Tan function.
	 */
	@Test
	public void testCalculateTan7() {
		double x = 58;
		double ans = calculator.calculateTan(x);
		assertEquals(8.330856852490644, ans, 0.0f);
	}

	/**
	 * Eight method that calculates the value returned by the Tan function.
	 */
	@Test
	public void testCalculateTan8() {
		double x = 69;
		double ans = calculator.calculateTan(x);
		assertEquals(-0.1155485457945267, ans, 0.0f);
	}

	/**
	 * Ninth method that calculates the value returned by the Tan function.
	 */
	@Test
	public void testCalculateTan9() {
		double x = 68;
		double ans = calculator.calculateTan(x);
		assertEquals(-2.04008159801594, ans, 0.0f);
	}

	/**
	 * Tenth method that calculates the value returned by the Tan function.
	 */
	@Test
	public void testCalculateTan10() {
		double x = 364;
		double ans = calculator.calculateTan(x);
		assertEquals(-0.452279348366655, ans, 0.0f);
	}

}
