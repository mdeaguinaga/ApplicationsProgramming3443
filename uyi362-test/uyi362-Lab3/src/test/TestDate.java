package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

/**
 * 
 * @author manueldeaguinaga
 *
 */
public class TestDate {
	
	
	@Test
	/**
	 * testCompareToNull() test for null data
	 */
	public void testCompareToNull() {
		Date date = new Date();
		boolean nullError = false;
		try {
			date.compareTo(null);
		} catch (NullPointerException e) {
			nullError = true;
		}
		assertTrue("should be a NullPointerException", nullError);
	}
	@SuppressWarnings("deprecation")
	@Test
	/**
	 * testCompareToCurrent() test for what year goes first and
	 * which goes second, if current goes after the other, compareTo 
	 * should be returning 1
	 */
	public void testCompareToCurrent() {
		Date current = new Date("Aug 21, 1987");
		Date other = new Date("Nov 25, 1976");
		assertEquals(current.compareTo(other), 1);
	}
	@SuppressWarnings("deprecation")
	@Test
	/**
	 * testCompareToSameYear()test for what month goes first and
	 * which goes second, if current goes before the other, compareTo
	 * should be returning -1
	 */
	public void testCompareToSameYear() {
		Date current = new Date("April 19, 1987");
		Date other = new Date("Aug 21, 1987");
		assertEquals(current.compareTo(other), -1);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	/**
	 * testCompareToSameYearAndMonth() test for what day goes first and
	 * which goes second, if current goes after the other, compareTo
	 * should be returning 1
	 */
	public void testCompareToSameYearAndMonth() {
		Date current = new Date("Aug 21, 1987");
		Date other = new Date("Aug 19, 1987");
		assertEquals(current.compareTo(other), 1);
	}
	@SuppressWarnings("deprecation")
	@Test
	/**
	 * testCompareToSameYDate() test for the dates 
	 * that should be equals, if so, compareTo 
	 * returns 0
	 */
	public void testCompareToSameYDate() {
		Date current = new Date("Apr 19, 1985");
		Date other = new Date("Apr 19, 1985");
		assertEquals(current.compareTo(other), 0);
	}
	

}
