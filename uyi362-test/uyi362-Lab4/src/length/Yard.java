package length;
/**
 * Yard is an object that that adds other
 * measurements that were converted to
 * yards, converts yards to meters,
 * returns the name of the length
 * and returns the total amount of yards.
 * 
 * @author manueldeaguinaga
 */
public class Yard extends Length{
	/**
	 * 1 yard = 0.9144 meters
	 */
	public static final double METERS_PER_YARD = 0.9144;
	/**
	 * holder variable
	 * will be used in add
	 */
	private double holder = 0;
	/**
	 * @param length
	 *calls the super class
	 */
	public Yard(double length){
		super (length);
	}
	/**
	 * @param other
	 * * divides meters over meters per yard add to 
	 * previous value and assign it to setLength
	 */
	public void add(Length other) {
		holder += ((other.toMeters())/ METERS_PER_YARD);
		this.setLength(holder);	
	}
	/**
	 * @return yard if is singular or yards if plural
	 */
	public String getUnit() {
		if(this.getLength() == 1)
			return "yard";
		else
			return "yards";
	}
	/**
	 * @return yards to meters
	 */
	public double toMeters() {
		return this.getLength() * METERS_PER_YARD ;
	}
}
