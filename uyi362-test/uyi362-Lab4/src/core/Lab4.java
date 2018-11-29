package core;
import length.*;
import java.io.File;
import java.io.*;
import java.util.*;
/**
 * Lab 4 reads an input file called data.txt
 * based on the data that is read, does a 
 * series of operations in order to manipulate
 * it and print in the order required
 * 
 * @author manueldeaguinaga
 */
public class Lab4 {
/**
 * main creates an ArrayList that will store the different
 * measurements that the input file reads, based on 
 * the type of measurement, it prints, compares, and adds
 * the different values calling a series of objects.
 * @param args
 */
	public static void main(String[] args) {
		Scanner in = null;
		ArrayList<Length> lengthList = new ArrayList<Length>();
		
		// Checks for error in the input file
		try {
		    in = new Scanner(new File("data.txt"));
		} catch (FileNotFoundException exception) {
		    throw new RuntimeException("failed to open data.txt");
		}
		// Imports the file
		while (in.hasNextDouble()) {
		    double value = in.nextDouble();
		    String unit = in.next();
		    unit = unit.toLowerCase();
		    
		    //switch that checks kind of length
		    switch( unit.substring(0, 4)){
		    	// If the case is or are inches
		    	case "inch":
		    		Length inch = new Inch(value);
		    		lengthList.add(inch);
		    		inch.toString();
		    		break;		
		    	// If the case is or are foot
		    	case "foot":
		    	case "feet":
		    		Length feet = new Foot(value);
		    		lengthList.add(feet); 		
		    		break;
		    	// If the case is or are yards
		    	case "yard":
		    		Length yard = new Yard(value);
		    		lengthList.add(yard);
		    		break;
		    	// If is or are meters
		    	case "mete":
		    		Length meter = new Meter(value);
		    		lengthList.add(meter);
		    		break;		
		    }
		}
		
		//Objects.
		Inch sumInch = new Inch(0);
		Foot sumFoot = new Foot(0);
		Yard sumYard = new Yard(0);
		Meter sumMeter = new Meter(0);
		//Max and min objects.
		Length max = null;
		Length min = null;
				
		//Prints lengthList and check for max and min value
		for(Length length : lengthList)
		{
			// Prints lengthList
			System.out.println(length.toString());
			// Add the first value of the array to max and min
			if(max == null && min == null){
				max = length;
				min = length;
			}
			// Checks for the greater value
			else if(max.toMeters() < length.toMeters()){
				max = length;
			}
			// Checks for the lower value
			else if(min.toMeters() > length.toMeters()){
				min = length;
			}
		}
		
		// Prints Minimum and Maximum
		System.out.println("\nMinimum is "+ min.toString());
		System.out.println("Maximum is "+ max.toString());
		
		// Adds the total length of each object first to last
		for(Length length : lengthList)
		{	
			sumInch.add(length);
			sumFoot.add(length);
			sumYard.add(length);
			sumMeter.add(length);
		}
		
		// Prints header and length from first to last
		System.out.println("\nSum of Lengths Adding from First to Last");
		System.out.println(sumMeter.toString());
		System.out.println(sumInch.toString());
		System.out.println(sumFoot.toString());
		System.out.println(sumYard.toString());
		
		// Objects that will be used 
		Inch sumInch2 = new Inch(0);
		Foot sumFoot2 = new Foot(0);
		Yard sumYard2 = new Yard(0);
		Meter sumMeter2 = new Meter(0);
		
		// Adds the total length of each object last to first
		for(int i = lengthList.size() - 1; i >= 0; i--){
			sumMeter2.add(lengthList.get(i));
			sumInch2.add(lengthList.get(i));
			sumFoot2.add(lengthList.get(i));
			sumYard2.add(lengthList.get(i));
		}
		
		// Prints header and length from last to first
		System.out.println("\nSum of Lengths Adding from Last to First");
		System.out.println(sumMeter2.toString());
		System.out.println(sumInch2.toString());
		System.out.println(sumFoot2.toString());
		System.out.println(sumYard2.toString());
		
		// Close input file
		in.close();
	}
}
