package test;

import static org.junit.Assert.*;

import org.junit.Test;

import length.Foot;
import length.Inch;
import length.Length;
import length.Meter;
import length.Yard;

/**
 * 
 * @author Manuel Deaguinaga
 *
 */
public class TestUnits {

	private Length length;
	private Length other;

	@Test
	/**
	 * testCompareToNullCompareTo() assign inches value
	 * and it is compared with a null to make a null error
	 */
	public void testInchesCompareToNull() {
	
		length = new Inch(33.5);
		boolean nullError = false;
		try {
			length.compareTo(null);
		} catch (NullPointerException e) {
			nullError = true;
		}
		assertTrue("should be a NullPointerException", nullError);
	}
	@Test
	/**
	 * testCompareToNullLength() assign null to length and it 
	 * is used to be compared with yard invoking a null error
	 */
	public void testYardCompareToNullLength() {
	
		length = null;
		other = new Yard(33.5);
		
		boolean nullError = false;
		try {
			length.compareTo(other);
		} catch (NullPointerException e) {
			nullError = true;
		}
		assertTrue("should be a NullPointerException", nullError);
	}
	
	@Test
	/**
	 * testFoot() Foot is compared with Meters, 
	 * since the total of Foot is greater than 
	 * Meter it should be returning 1
	 */
	public void testFoot() {
		length = new Foot(199.32);
		other  = new Meter(1.25);
		
		assertEquals(length.compareTo(other), 1);
	}
	
	@Test
	/**
	 * testInch() Inch is compared with Meters, 
	 * since the total of Inches is greater than 
	 * Meter it should be returning 1
	 */
	public void testInch() {
		length = new Inch(1846.32); 
		other = new Meter(9);
		
		assertEquals(length.compareTo(other), 1);
	}
	
	@Test
	/**
	 * testMeter() Meters is compared with Meters, 
	 * since the total of Meters equals 
	 * the other Meters it should be returning 0
	 */
	public void testMeter() {
		length = new Meter(15.20);
		other = new Meter(15.20);
		
		assertEquals(length.compareTo(other), 0);
	}
	
	@Test
	/**
	 * testYard() Yard is compared with Meters, 
	 * since the total of Yards is less than 
	 * Meter it should be returning -1
	 */
	public void testYard() {
		length = new Yard(1.32);
		other = new Meter(15.32);
		
		assertEquals(length.compareTo(other), -1);
	}
	
	
	@Test
	/**
	 * testYardNotTheSameInch() verify that 
	 * Yard and Inch that are not the same objects
	 */
	public void testYardNotTheSameInch() {
		length = new Yard(15.32); 
		other = new Inch(15.32);
		
		assertNotEquals(other, length);
	}
	
	@Test
	/**
	 * testMeterNotTheSameFoot() test Meter and Foot
	 * that are not the same objects
	 */
	public void testMeterNotTheSameFoot() {
		length = new Meter(95.123); 
		other = new Foot(95.123);
		
		assertNotEquals(other, length);
	}
	
	@Test
	/**
	 * testCompareToNullCompareTo() assign meter value
	 * and it is compared with a null to make a null error
	 */
	public void testCompareToNullMeterCompareTo() {
	
		length = new Meter(33.5);
		boolean nullError = false;
		try {
			length.compareTo(null);
		} catch (NullPointerException e) {
			nullError = true;
		}
		assertTrue("should be a NullPointerException", nullError);
	}
	@Test
	/**
	 * testCompareToNullCompareTo() assign null to length and it 
	 * is used to be compared with foot invoking a null error
	 */
	public void testCompareToNullFootCompareTo() {
	
		length = null;
		other = new Foot(200);
		boolean nullError = false;
		try {
			length.compareTo(other);
		} catch (NullPointerException e) {
			nullError = true;
		}
		assertTrue("should be a NullPointerException", nullError);
	}
}
