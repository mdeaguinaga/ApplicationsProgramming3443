package length;
/**
 * Inch is an object that that adds other
 * measurements that were converted to
 * inches, converts inches to meters,
 * returns the name of the length
 * and returns the total amount of inches
 * .
 * @author manueldeaguinaga
 */
public class Inch extends Length{
	/**
	 * 1 inch = 0.0254 meters
	 */
	public static final double METERS_PER_INCH = 0.0254;
	/**
	 * holder variable
	 * will be used in add
	 */
	private double holder = 0;
	
	/**
	 * @param length
	 * calls the super class
	 */
	public Inch(double length) {
		super (length);
	}
	/**
	 * @param other
	 * divides meters over meters per inches add to 
	 * previous value and assign it to setLength
	 */
	public void add(Length other) {
		
		holder += ((other.toMeters())/ METERS_PER_INCH);
		this.setLength(holder);
	}
	/**
	 * @return inch if is singular or inches if plural 
	 */
	public String getUnit() {
		if(this.getLength() == 1)
			return "inch";
		else
			return "inches";
	}
	/**
	 * @return inch to meters
	 */
	public double toMeters() {		
		return this.getLength() * METERS_PER_INCH;
	}

}
