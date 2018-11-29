package core;
/**
 * Data assign the value from String date in the correct order
 * This include two methods
 * ToString:  used to print in the right format
 * CompareTo: used to analyze two pieces of data.
 * @author manuel de aguinaga
 */
public class Date implements Comparable<Date> {
	
    /**
     * Days corresponding to each month
     */
	private static final int[] DAYS_PER_MONTH = { 31, 28, 31, 30, 31, 30, 31
													,31, 30, 31, 30, 31 };
	/**
	 * Months corresponding to each year
	 */
	private static final String[] MONTH_PER_YEAR = { "January", "February", "March"
													, "April", "May", "June","July"
													, "August", "September", "October"
													, "November", "December"};
	/**
	 * Date that will be analyzed and parse 
	 */
	private String date = "";
	/**
	 * constructor that analyze the date data, divides and recreate an String
	 * @param date
	 * 				Date that was rited 
	 */
	public Date(String date){	
		
	    //Splits the string based on the spaces 
	    String[] splitLine = date.split(" ");
	       	    
	    //Removes the comma from the day in the array
	    splitLine[1] = splitLine[1].substring(0, splitLine[1].length()-1);	    
		
		// This for loop compares the input file month with 
		// the months on the array in order to correct them.
		for(int i = 0; i < MONTH_PER_YEAR.length; i++)
		{
			// If one of the months in the array matches with the month 
			// from the input, it assigns the date 
			if(MONTH_PER_YEAR[i].substring(0,3).compareTo(splitLine[0].substring(0,3)) == 0){
				this.date += MONTH_PER_YEAR[i];
			}
		}
		this.date += " "+ splitLine[1]+ ", " + splitLine[2]; 
	}
	/**
	 * Converts Date to String 
	 * @return String representing the Data object
	 */
	public String toString(){
		return String.format("Date: %s", this.date);
	}
	/**
	 * @param other
	 * 			current date is compared with the last one
	 * @return int
	 */
	public int compareTo (Date other) {
		// Variables for Date other
		int otherDay, otherYear, otherMonth = 0;
		// Variables for this Date
		int thisDay, thisYear, thisMonth = 0;
			
			String[] thisSplit = this.date.split(" ");
			String[] otherSplit = other.date.split(" ");
			//Assigns Days
			thisDay = Integer.parseInt(thisSplit[1].substring(0, thisSplit[1].length()-1));
			otherDay = Integer.parseInt(otherSplit[1].substring(0, otherSplit[1].length()-1));
			//Assigns Years
			thisYear = Integer.parseInt(thisSplit[2]);
			otherYear = Integer.parseInt(otherSplit[2]);
			//Assigns Months
		
			for(int i = 0; i < MONTH_PER_YEAR.length; i++){
				// If one of the months in the array matches with the month 
				// from the input, it assigns the date 
				if(MONTH_PER_YEAR[i].substring(0,3).compareTo(this.date.substring(0,3)) == 0){
					thisMonth = i;
					if(DAYS_PER_MONTH[i] < thisDay)
						return 2;
				}
				if(MONTH_PER_YEAR[i].substring(0,3).compareTo(other.date.substring(0,3)) == 0){
					otherMonth = i;	
				}
			}
		// if this Date is before the other Date,
		if( thisYear < otherYear){
			return -1;
		}
		// if this Date is after the other Date
		else if( thisYear > otherYear){
			return 1;
		}
		// if they are equal
		else {
			// if this Date is before the other Date,
			if( thisMonth < otherMonth){
				return -1;
			}
			// if this Date is after the other Date
			else if( thisMonth > otherMonth){
				return 1;
			}
			// if they are equal
			else{
				// if this Date is before the other Date,
				if( thisDay < otherDay){
					return -1;
				}
				// if this Date is after the other Date
				else if( thisDay > otherDay){
					return 1;
				}
				// if they are equal
				else{
					return 0;
				}
			}
		}
	}
}
