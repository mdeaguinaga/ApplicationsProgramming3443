//Manuel Israel De Aguinaga
//uyi362

package core;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

/***********************************************************************
 * @author uyi362
 * Has the main method which reads a file
 * checks for doubles and non doubles
 * add the number of doubles 
 * add the number of non doubles
 * add the value of doubles
 * prints the results and closes the file
 *
 * ********************************************************************/

public class Lab1 {
	
	/******************** Main Method **********************************
	 * @param args
	 * @return void
	 * Reads the information from a file and assign it into a variable,
	 * otherwise print an error message.
	 * Verifies if the information is a Double data type or a String.
	 * The program will count the number of Doubles and add its value.
	 * Also it will count the number of non numeric characters.
	********************************************************************/
	public static void main(String[] args) {
		
		/*Variables*/
		int NumberOfDoubles = 0;						//Total of Double
		int NumberOfNonDoubles = 0;						//Total of Characters
		double totalSum = 0;							//Total of the sum
		DecimalFormat dF = new DecimalFormat("0.##");	//Decimal Format
		Scanner in = null;								//Scanner input file
		
		/* Imports the file into the Scanner in (variable)
		(assuming that the name of the file is "data") */
		try {
		    in = new Scanner(new File("data.txt"));
		} 
		/* is the file is not found an error message will be executed*/
		catch (FileNotFoundException e) {
		    System.err.println("failed to open data.txt");
		    System.exit(1);
		}
		
		/*Loop that will be keeping running if 
		 * a token is found and in still having 
		 * information to transfer  */
		while (in.hasNext()) {
		    String token = in.next();					//data token 
		    
		  /* if token is a number, try will 
		   * convert string to double and assign
		   * the value to variable d */
			try {
				// if the token is a Double data type, it will be added to d
				// add one to NumberOfDoubles and add the value to totalSum
			    double d = Double.parseDouble(token);	// assign the token to d
			    NumberOfDoubles += 1;
			    totalSum += d;   
			}
			// if the token is not a Number, it will add 1 to NumberOfNonDoubles
			catch (NumberFormatException e) {			
				NumberOfNonDoubles += 1;				
			}
		}
			
		/* Prints the result */
		System.out.println(NumberOfDoubles+" "
				+NumberOfNonDoubles +" "
				+dF.format(totalSum));

		// Close file
		in.close();
	}
}
