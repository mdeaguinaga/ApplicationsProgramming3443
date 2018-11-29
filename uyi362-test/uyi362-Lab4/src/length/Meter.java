package length;
/**
 * Meter is an object that that adds other
 * measurements that were converted to
 * meters, returns the name of the length
 * and returns the total amount of meters.
 * 
 * @author manueldeaguinaga
 */
public class Meter extends Length{
	/**
	 * holder variable
	 * will be used in add
	 */
	private double holder = 0;
	/**
	 * @param length
	 * calls the super class
	 */
	public Meter(double length){
		super(length);
	}
	/**
	 * @param other
	 * adds the total of meters
	 */
	public void add(Length other) {
		holder += (other.toMeters());
		this.setLength(holder);
	}
	/**
	 * @return meter if is singular or meters if plural 
	 */
	public String getUnit() {
		if(this.getLength() == 1)
			return "meter";
		else
			return "meters";
	}
	/**
	 * @return this.getLength
	 * since the measurements are in meters
	 * there is not necessity to convert 
	 */
	public double toMeters() {
		return this.getLength();
	}
}
