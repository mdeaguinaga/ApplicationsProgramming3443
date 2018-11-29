package testing;

/**
 * @author uyi362 Manuel de Aguinaga
 * TestGradeBook test 3 different methods from Grades
 * median, average, and minimum
 * Each method contains 4 different 
 * ways to test the different scenarios 
 * 
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import core.Grades;

public class TestGradeBook {
	
	/* notes just for reference 
	@Before
	public void setUp() throws Exception{
		Grades gb1 = new Grades("test", null);
		Grades gb2 = new Grades("test", grades);
	}
	
	@After
	public void tearDown() throws Exception{
		
	}
	*/
	
	/*********************************************
	 * 					median					 *	
	 *********************************************/
	
	@Test
	/**
	 * testMedianNull method tests case using null grade array. The correct behavior is
	 * a runtime error.
	 */
	public void testMedianNull() {
		Grades gb = new Grades("test", null);
		boolean nullError = false;
		try {
			gb.median();
		} catch (NullPointerException e) {
			nullError = true;
		}
		assertTrue("should be a NullPointerException", nullError);
	}
	
	@Test
	/**
     * testMedian2Elements method tests case using 2 elements (even array), 0 and 1 ( small amount of entries ). 
     * The correct behavior is the median number.	
     */
    public void testMedian2Elements() {
        int[] grades = { 0, 1};
        Grades gb = new Grades("test", Grades.sort(grades));
        double median = grades[grades.length/2];
        assertEquals("0 and 1 element test failed", median, gb.median(), 0.00);
    }

	@Test
	/**
     * testMedian15Element method tests case using a large array of 15 elements (and odd array), The correct behavior is the
     * median number, in this case the sum of all numbers divided by the length in a sorted array
     */
    public void testMedian15Element() {
        int[] grades = { 87, 99, 96, 99, 86, 96, 77, 95, 70, 88, 66, 11, 100, 88, 99 };
        Grades gb = new Grades("test", Grades.sort(grades));
        double median = grades[grades.length/2];
        assertEquals("15 element test failed", median, gb.median(),
                0.000001);
    }

	@Test
	/**
     * testMedianNotSameObject method tests two objects to make sure
     * they are not the same. The correct behavior is the asertNotSame
     * will check that is not doing the same algorithm 
     */
    public void testMedianNotSameObject() {
		int[] grades = { 87, 99, 96, 99, 86, 96, 77, 95, 70, 88 };
		Grades gb = new Grades("test", grades);
        assertNotSame(gb.average(), gb.median());
    }

	/*********************************************
	 * 					average					 *	
	 *********************************************/
	
	@Test
	/**
     * testAverageNull method tests case using null grade array. The correct behavior is
     * a runtime error.
     */
    public void testAverageNull() {
        Grades gb = new Grades("test", null);
        boolean nullError = false;
        try {
            gb.average();
        } catch (NullPointerException e) {
            nullError = true;
        }
        assertTrue("should be a NullPointerException", nullError);
    }
	
	@Test
	/**
     * testAverage15Element method tests case using 15 elements. The correct behavior is the
     * the sum of the numbers divided by the average of the numbers.
     */
    public void testAverage15Element() {
        int[] grades = { 87, 99, 96, 99, 86, 96, 77, 95, 70, 88, 66, 11, 100, 88, 99 };
        Grades gb = new Grades("test", grades);
        double average = 0;
        for (int grade : grades) {
            average += grade;
        }
        average /= grades.length;
        assertEquals("15 element test failed", average, gb.average(),
                0.000001);
    }

	@Test
	/**
     * testAverage2Elements method tests case using 2 elements, 0 and 1. The correct behavior is the
     * gb.average should be the same as average, in this case 0.5
     */
    public void testAverage2Elements() {
        int[] grades = { 1, 0};
        Grades gb = new Grades("test", grades);
        double average = 0;
        for (int grade : grades) {
            average += grade;
        }  
        average /= grades.length;
        assertEquals("0 and 1 element test failed", average, gb.average(), 0.00);
    }

	@Test
	/**
     * testAverageNotSameObject method tests two objects to make sure
     * they are not the same. The correct behavior is the asertNotSame
     * will check that is not doing the same algorithm 
     */
    public void testAverageNotSameObject() {
        int[] grades = { 87, 99, 96, 99, 86, 96, 77, 95, 70, 88 };
        Grades gb = new Grades("test", grades);
        assertNotSame(gb.minimum(), gb.average());
    }
	
	
	/*********************************************
	 * 					minimum					 *	
	 *********************************************/
	
	@Test
	/**
	 * testMinimumNul method tests case using null grade array. The correct behavior is
	 * a runtime error.
	 */
	public void testMinimumNull() {
		Grades gb = new Grades("test", null);
		boolean nullError = false;
		try {
			gb.minimum();
		} catch (NullPointerException e) {
			nullError = true;
		}
		assertTrue("should be a NullPointerException", nullError);
	}

	@Test
	/**
     * testMinimum2Elements method tests case using 2 elements, 0 and 1. The correct behavior is the
     * minimum number, in this case 0.	
     */
    public void testMinimum2Elements() {
        int[] grades = { 1, 0};
        Grades gb = new Grades("test", grades);
        double minimum = 0;
        
        assertEquals("0 and 1 element test failed", minimum, gb.minimum(), 0.00);
    }

	@Test
	/**
     * testMinimum15Element method tests case using 10 elements. The correct behavior is the
     * minimum number should be the same as the minimum number in the array.
     */
    public void testMinimum15Element() {
        int[] grades = { 87, 99, 96, 99, 86, 96, 77, 95, 70, 88, 66, 11, 100, 88, 99 };
        Grades gb = new Grades("test", grades);
        int minimum = grades[1];
        for (int grade : grades) {
            if(minimum > grade)
            	 minimum = grade;
        }
        assertEquals("10 element test failed", minimum, gb.minimum(),
                0.000001);
    }

	@Test
	/**
     * testMinimumNotSameObject method tests two objects to make sure
     * they are not the same. The correct behavior is the asertNotSame
     * will check that is not doing the same algorithm.
     */
	public void testMinimumNotSameObject() {
        int[] grades = { 87, 99, 96, 99, 86, 96, 77, 95, 70, 88 };
        Grades gb = new Grades("test", grades);
        assertNotSame(gb.maximum(), gb.minimum());
    }
}