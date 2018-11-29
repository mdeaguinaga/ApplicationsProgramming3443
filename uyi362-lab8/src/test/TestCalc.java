package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import application.model.Calculator;
public class TestCalc {

	double d = 4;
	private Calculator calc;

	@Test
	/**
	 * testTestFactorialToNull() pass a value
	 * to get the factorial number and check for 
	 * null object 
	 */
	public void testFactorialToNull() {
	
		calc = null;
		boolean nullError = false;
		try {
			calc.factorial(d);
		} catch (NullPointerException e) {
			nullError = true;
		}
		assertTrue("should be a NullPointerException", nullError);
	}
	
	@Test
	/**
	 * testTestUpdateToNull() pass a value
	 * to get the factorial number and check for 
	 * null object 
	 */
	public void testUpdateToNull() {
	
		calc = null;
		String text = "3+2";
		boolean nullError = false;
		try {
			calc.update(text);
		} catch (NullPointerException e) {
			nullError = true;
		}
		assertTrue("should be a NullPointerException", nullError);
	}
	
	@Test
	/**
	 * testForEquealNotNull () checks for
	 * calc to don't be a null object
	 * 
	 */
	public void testForEquealNotNull () {
		calc = new Calculator();
		assertNotNull(calc);
	}
	
	@Test
	/**
	 * testForFactorial check that the factorial
	 * result to be the same as expected 
	 * 
	 */
	public void testForFactorial () {
		double factorial = 4;
		calc = new Calculator();
		double result = calc.factorial(factorial);
		System.out.println("24.0 = " + result );
	}


}
