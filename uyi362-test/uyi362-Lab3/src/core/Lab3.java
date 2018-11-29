package core;
import java.io.*;
import java.util.Scanner;
/**
 * @author manueldeaguinaga
 * Lab3 reads the information from the file
 * calls Date and DateRange objects
 * Contains the main method 
 */
public class Lab3 {
/**
 * @param args
 * Reads the file that is being input
 * set Objects variables to analyze the data
 * finally prints the data already analyzed
 */
	public static void main(String[] args){
		// Objects variables
		Date oldDate = null; 
		DateRange dateRange = null;
		
		//Input file Scanner
		Scanner in = null;	
		
		// Error Catcher 
		try {
		    in = new Scanner(new File("dates.txt"));
		} catch (FileNotFoundException exception) {
		    System.err.println("failed to open dates.txt");
		    System.exit(1);
		}
		// If in the input file still reading information, 
		// The while loop will continue occuring
		while (in.hasNextLine()) {
			// Read the file
		    String line = in.nextLine();
		    
		    // Calls Date Class
		    Date date = new Date(line);
		    
		    //Checks if oldDate is null, if it is
		    //olDate is being set equal to date
		    if(oldDate == null)
		    {
		   		oldDate = date;	
		   	}
		    //Compares the last date with the current 
		    //being analyzed in the method date
	    	int compareResult = date.compareTo(oldDate);
	    	
	    	//Prints an error if the value 
	    	//matches with the error number
	    	if(compareResult == 2)
	    		System.out.println("Invalid Date");
	    	//Otherwise prints the current information
	    	else	
	    		System.out.println(date.toString());
	    	
	    	//Based on the information, it calls and
	    	//prints DateRange method
		   	if(compareResult == 1){
		   		dateRange = new DateRange(oldDate , date);
		   		System.out.println(dateRange.toString());
		   	}
		   	// Assign the data in dates to old Date
		    oldDate = date;
	    }	       
		//Close buffer for file
		in.close();	
	}
}


