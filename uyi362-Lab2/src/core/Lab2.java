// Manuel Israel De Aguinaga
// uyi362

package core;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/****************************************************************
 *  @author uyi362 (Manuel de Aguinaga)
 *  Has the main method which reads the input file and sent the
 *  information to Grades Class.
 *  Has the testGrades that basically prints the information by 
 *  calling the method in Grades.
 *
 ****************************************************************/

public class Lab2 {
	
	/************************************************************
	 * @param args 
	 *  The main method creates a String whit the name of student and
	 *  an ArrayList that holds the grades.
	 *  The String read in the outer while loop
	 *  and the grades ArrayList in the intern loop.
	 *  Calls Grades Class to do the math, hold and assign values.
	 *  Calls testGrades to print the information
	 *  
	 ************************************************************/
	public static void main(String[] args) {
		Scanner in = null;
		
		//Open file assign it to in
		try {
		    in = new Scanner(new File("data.txt"));	//in holds the file information
		} 
		catch (FileNotFoundException exception) {	//prints an error for the file 
		    System.err.println("failed to open data.txt");
		    System.exit(1);
		}		
		
		// Transfer data by token to name
		while (in.hasNext()) {
		    String name = in.next();
		    
		    //ArrayList that will holds the grades 
		    ArrayList<Integer> gradeList = new ArrayList<Integer>();  
		 	
		    // Read grades and add them to gradeList. 
		    while (in.hasNextInt()) {
		        int grade = in.nextInt();	//holds a grade temporary
		        gradeList.add(grade);		//Creates a ArrayList for all the grades
		    }	   
		    
		    // Copy gradeList to the gradesArray Array.
		    int[] gradesArray = new int[gradeList.size()];	//Creates an int array whit the same size of gradeList
		    for (int index = 0; index < gradeList.size(); index++) {
		        gradesArray[index] = gradeList.get(index);	//Assign the values from gradeList to gradesArray 
		    }
		    
		    //Calls Grades Class
		    Grades grades = new Grades(name, gradesArray);
		   
		    //Calls the method testGrades
		    testGrades(grades);   
		}
		
		in.close();	//Close file
	}
	
	/********************************************
	 * @param grades
	 * Calls toString method in Grades Class
	 * Pints Information calling different 
	 * methods in Grades Class 
	 * 
	 ********************************************/
	public static void testGrades(Grades grades) {
	    System.out.println(grades.toString()); 
	    System.out.printf("\tName:    %s\n", grades.getName());
	    System.out.printf("\tLength:  %d\n", grades.length());
	    System.out.printf("\tAverage: %.2f\n", grades.average());
	    System.out.printf("\tMedian:  %.1f\n", grades.median());
	    System.out.printf("\tMaximum: %d\n", grades.maximum());
	    System.out.printf("\tMininum: %d\n", grades.minimum());
	}
}
