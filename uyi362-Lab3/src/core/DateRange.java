package core;
/**
 * @author manueldeaguinaga
 *
 */
public class DateRange {
	/**
	 * Current date read
	 */
	private Date current;
	/**
	 * Last date read
	 */
	private Date last;
	/**
	 * Constructor for current and last dates
	 * @param current and other
	 * @param other
	 * 		Both are dates that will be printed
	 */
	public DateRange(Date current, Date last) {
		
		this.current = current;
		this.last = last;
	}
	/**
	 * @return String with current and last dates
	 */
	public String toString(){
		return String.format("DateRange: %s -  %s", this.current, this.last);
	}
	
	
	
}
