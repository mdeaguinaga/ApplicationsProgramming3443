package core;

/**
 * 
 * @author uyi362 (Manuel de Aguinaga
 *Grade Class has the following methods:
 *public Grades(String name, int[] gradesArray)
 *public String getName() and public void setName(String name)
 *public int length()
 *public double average()
 *public double median()
 *public int maximum()
 *public int minimum()
 *public static String sPrint(int[] grades)
 *public static int[] sort(int[] grades)
 *public String toString()
 */

public class Grades {
	
	private String name;	// Name of the Student
	private int[] grades;	// Array with the grades

	/**
	 * 
	 * @param name
	 * @param gradesArray
	 * 
	 */
	public Grades(String name, int[] gradesArray){
		this.name = name;				//Assign name to private String name
		this.grades = gradesArray;		//Assign gradesArray to private int Array grades
	}
	
	/**
	 * 
	 * @return name
	 * 
	 */
	public String getName() {
		return name;				
	}

	/**
	 * 
	 * @param name
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return iLength
	 * 
	 */
	public int length(){
		int iLength = 0;
	
		iLength = grades.length;	
		return iLength;
	}
	/**
	 * 
	 * @return iAverage
	 * 
	 */
	public double average(){
		double dAverage = 0;
		// Add all the values on the array to dAverage 
		for(int i = 0; i < grades.length; i++)
			dAverage += grades[i];
		// Divides all the values added of the 
		// array for the length of the array
		dAverage = dAverage/grades.length;
		
		return dAverage;
	}
	
	/**
	 * 
	 * @return dMedia
	 * 
	 */
	public double median(){
		
		sort(grades);
		
		int middle = grades.length/2;		//Divides the length of the array over 2
		
	    if (grades.length%2 == 0) {			//Returns the middle value of the array
	        return grades[middle];
	    } 
	    // Returns the value of two middle numbers in the array divided by 2 
	    else {								
	    	return ((grades[middle] + grades[middle-1])/2.0); 
	    }
	}
	
	/**
	 * 
	 * @return iMaximum
	 * 
	 */
	public int maximum(){
		int iMaximum = 0;
		for(int i = 0; i < grades.length; i++)	//Checks for all values on the array
			//Assign the value to iMaximum if the current 
			//value in the array is grater than iMaximum
			if(iMaximum < grades[i])		
				iMaximum = grades[i];
		
		return iMaximum;
	}

	/**
	 * 
	 * @return iMinimum
	 * 
	 */

	public int minimum(){
		int iMinimum = grades[0];	// holds the first value of the array
		//Switches if the value is greater than 
		//the current value that iMinimum holds
		for(int i = 0; i < grades.length; i++)
			if(grades[i] < iMinimum)	
				iMinimum = grades[i];
		
		return iMinimum;	
	}
	
	/**
	 * 
	 * @param grades
	 * @return nameGraders
	 * Accommodate the format that will 
	 * be printed in toString method
	 */
	public static String sPrint(int[] grades){
		String nameGrades = "";
		
		for(int i = 0; i<grades.length; i++){
			if(i==0)// skips the comma
				nameGrades += grades[i];
			else	//add a come to the String if is not the first value
				nameGrades += ", " + grades[i];
		}
		return nameGrades;
	}
	
	/*********************************************
	 * 
	 * @param grades
	 * @return grades
	 * Algorithm the sort the int Array
	 * grades in order from small to bigger 
	 ********************************************/
	public static int[] sort(int[] grades){
		
		//Bubble sort
	    int i, j;			//Variables for the iner and outer for loops
	    //Loop that will be analyzing 
	    //the values of the array
		for (i = 0; i < grades.length-1; i++){         
			//Reads trough the array comparing 
			//all the values in order to sort 
			//them base on its value
			for (j = 0; j < grades.length-i-1; j++){
				//Switch the values if the value 
				// of j is grader than j+1
       			if ( grades[j] > grades[j+1]){
       				int temp = grades[j];	//Holds the j array value
       				grades[j] = grades[j+1];// assign the smaller value to the array
       				grades[j+1] = temp;		// assign the grater value to the next position
       			}
			}
		}
		return grades;
	}
	
	/*********************************************
	 * 
	 * @return String 
	 * returns an String
	 * with the name of the student
	 * and the information that
	 *  sPrint(grades) method returns
	 ********************************************/
	public String toString(){
		return String.format("%s [%s]", name , sPrint(grades));
	}
	
}
