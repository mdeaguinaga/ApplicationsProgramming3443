package length;


/**
 * A Length is an object that has a length and a unit, can be converted to
 * meters, can be added to other Lengths, and can be compared to other
 * Lengths.
 * 
 * @author Tom Bylander
 */
public abstract class Length implements Comparable<Length> {
	
	
    /**
     * The length in the units of this object.
     */
    private double length;
    
    /**
     * Store the length in this Length.
     * @param length
     */
    public Length(double length) {
        this.length = length;
    }
    
    /**
     * This should add the other Length to this Length object.
     * 
     * @param other
     */
    public abstract void add(Length other);
    
    /**
     * This should return a different String if the length is exactly 1.0.
     * 
     * @return the correct name of the unit of this Length object.
     */
    public abstract String getUnit();
    
    /**
     * @return the length in meters
     */
    public abstract double toMeters();

    /**
     * @return the length of this Length object.
     */
    public double getLength() {
        return length;
    }
    
    /**
     * Set the length of this Length object.
     * @param length length in the units of this object
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Compare this Length object to the other one.
     */
    public int compareTo(Length other) {
    	
    	if (this.toMeters() < other.toMeters()){
    		return -1;
    	}
    	if (this.toMeters() > other.toMeters()){
    		return 1;
    	}
    	else
    		return 0;
    }

    /**
     * @return a String that includes the class name, the length, and the unit.
     */
    public String toString() {
        return this.getClass() + ": " + getLength() + " " + getUnit();
    }
}
