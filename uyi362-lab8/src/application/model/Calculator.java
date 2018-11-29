package application.model;
import java.math.*;

/**
 * Calculator class handles the model for a basic Java calculator.
 * 
 * @author Dr. T. Bylander	- Java Swing version
 * @author Dr. A. Fernandez	- updated to JavaFX Fall 2017
 * @author Manuel Deaguinaga - adding some binary and unit operations
 */
public class Calculator {

    private double displayValue;		// the numeric value of the number the user is entering, or the number that was just calculated
	private double internalValue;		// the previous value entered or calculated
	private String displayString;		// the String corresponding to what the user is entering
	private String operation;			// the last operation entered by the user
	private boolean start;				// true if the next digit entered starts a new value
    private boolean dot;				// true if a decimal dot has been entered for the current value

	public Calculator() {
		displayValue = 0.0;
		displayString = "" + displayValue;
		internalValue = 0;
		dot = false;
		start = true;
		operation = "";
	}

	/**
	 * @return the String value of what was just calculated or what the user is entering
	 */
	public String getValue() {
		return displayString;
	}
	
	/**
	 * @return the result of the factorial number.
	 */
	public double factorial(double d){
		if (d==1 || d==0)
			return 1;
		else{
			return factorial(d-1)*d;
		}
	}

	/**
	 * Updates the values maintained by the calculator based on the
	 * button that the user has just clicked.
	 * 
	 * @param text is the name of the button that the user has just clicked
	 */
	public void update(String text) {
		if (start) {	
			internalValue = displayValue;
			displayValue = 0;
			displayString = "";
			start = false;
			dot = false;	
		}
		if (text.length() == 1 && "0123456789".indexOf(text) >= 0) {
			displayString += text;
			displayValue = Double.valueOf(displayString);
		} else if (text.equals(".")) {
			if (! dot) {	
				dot = true;	
				if (displayString.equals("")) {
					displayString = "0";
				}
				displayString += ".";
			}
		}
		/**
		 * Changes from positive to negative and from negative to positive "+/-".
		 */
		else if(text.equals("+/-")){
			displayValue = displayValue*(-1);
			displayString = "" + displayValue;
			internalValue = displayValue;
		}
		/**
		 * Reset the calculator "c".
		 */
		else if(text.equals("c")){
			displayValue = 0.0;
			displayString = "" + displayValue;
			internalValue = 0;
			dot = false;
			start = true;
			operation = "";
		}
		else {
		    if (operation.equals("+")) {
				displayValue = internalValue + displayValue;
			} else if (operation.equals("-")) {
				displayValue = internalValue - displayValue;
			} else if (operation.equals("*")) {
				displayValue = internalValue * displayValue;
			} else if (operation.equals("/")) {
				displayValue = internalValue / displayValue;
			} else if( operation.equals("=") ) {
				displayValue = internalValue;
			} 
			
		   
			/**
			 * Does the percent operation "%".
			 */
			else if( operation.equals("%")){
				if (displayValue == 0)
					displayValue = internalValue*(internalValue *0.01);	
				else 
					displayValue = displayValue*(internalValue *0.01);
			} 
			/**
			 * Does the exponential operation "x^".
			 */
			else if( operation.equals("x^")){	
				 displayValue = Math.pow(internalValue, displayValue);
			} 
		    /**
		     * Does the natural log operation "ln".
		     */
			else if (text.equals("ln")){
				if (displayValue == 0)
					displayValue = Math.log(internalValue);
				else 
					displayValue = Math.log(displayValue);
			}
		    /**
			 * Does the logarithm operation "log".
			 */
			else if(text.equals("log")){
				if (displayValue == 0)
					displayValue = Math.log10(internalValue);
				else 
					displayValue = Math.log10(displayValue);
			}
		    /**
			 * Does the square root operation "√".
			 */
			else if(text.equals("√")){
				if(displayValue == 0)
					displayValue = Math.sqrt(internalValue);
				else
					displayValue = Math.sqrt(displayValue);
			}
		    /**
		     * Does the decimal operation 1/x.
		     */
			else if (text.equals("1/x")){
				if(displayValue == 0)
					displayValue = 1/internalValue;
				else 
					displayValue = 1/displayValue;
			}
		    /**
			 * Does the factorial operation x!.
			 */
			else if( text.equals("x!")){
				if (displayValue == 0)
					displayValue = factorial(internalValue);
				else 
					displayValue = factorial(displayValue);
			}
		    
			displayString = "" + displayValue;
			internalValue = displayValue;
			operation = text;
			start = true;
		} 
	}
}
