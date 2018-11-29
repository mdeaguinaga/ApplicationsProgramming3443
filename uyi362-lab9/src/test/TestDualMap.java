package test;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import dualHashMap.DualMap;
import dualHashMap.DualMapTest;
import dualHashMap.DualHashMap;

public class TestDualMap {
	
	String[] months1 = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };
	String[] months2 = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

	private DualMapTest dualMapTest;
	private DualHashMap dualHashMap;
	private DualMap dualMap;
	@Test
	/**
	 * testdualHashMapToNull() assign inches value
	 * and it is compared with a null to make a null error
	 */
	public void testdualHashMapToNull() {
	
		
		boolean nullError = false;
		try {
			dualHashMap.put(null, null);
		} catch (NullPointerException e) {
			nullError = true;
		}
		assertTrue("should be a NullPointerException", nullError);
	}
	
	@Test
	/**
	 * testReverseGetToNull() assign inches value
	 * and it is compared with a null to make a null error
	 */
	public void testReverseGetToNull() {
		
		boolean nullError = false;
		try {
			dualHashMap.reverseGet(null);
		} catch (NullPointerException e) {
			nullError = true;
		}
		assertTrue("should be a NullPointerException", nullError);
	}
	
	@Test
	/**
	 * testDualMapToNull() assign inches value
	 * and it is compared with a null to make a null error
	 */
	public void testDualMapToNull() {
		
		boolean nullError = false;
		try {
			dualMap.remove(null, null);
		} catch (NullPointerException e) {
			nullError = true;
		}
		assertTrue("should be a NullPointerException", nullError);
	}
	
	@Test
	/**
	 * testRemove() will add and remove some of the months 
	 * from the array and it will be verified if it was removed
	 */
	public void testRemove() {
	        DualMap<String, String> map = new DualHashMap<String, String>();
	        map.put(months1[1],months2[1]);
	        map.put(months1[5],months2[5]);
	        assertNotNull(map);

	        assertEquals(null, map.get(months1[3]));
	    
	        map.remove(months1[5],months2[5]);
	        assertEquals(null, map.get(months1[5]));
	        assertEquals(null, map.get(months2[5]));

	        assertEquals(map.get(months1[1]), map.get(months1[1]));
	}
}
