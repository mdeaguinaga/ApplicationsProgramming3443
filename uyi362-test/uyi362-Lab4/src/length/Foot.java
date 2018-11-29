package length;
/**
 * Foot is an object that that adds other
 * measurements that were converted to
 * feet, converts feet to meters,
 * returns the name of the length
 * and returns the total amount of feet.
 * 
 * @author manueldeaguinaga
 */
public class Foot extends Length{
	/**
	 * 1 foot = 0.3048 meters
	 */
	public static final double METERS_PER_FOOT = 0.3048;
	/**
	 * holder variable
	 * will be used in add
	 */
	private double holder = 0;
	/**
	 * 
	 * @param length
	 * calls the super class
	 */
	public Foot(double length){
		super (length);
	}
	/**
	 * @param other
	 * *divides meters over meters per feet add to 
	 * previous value and assign it to setLength
	 */
	public void add(Length other) {
		holder += ((other.toMeters())/ METERS_PER_FOOT);
		this.setLength(holder);
	}
	/**
	 * @return foot if is singular or feet if plural
	 */
	public String getUnit() {
		if(this.getLength() == 1)
			return "foot";
		else
			return "feet";
	}
	/**
	 * @return feet to meters
	 */
	public double toMeters() {
		return this.getLength() * METERS_PER_FOOT;
	}

}
