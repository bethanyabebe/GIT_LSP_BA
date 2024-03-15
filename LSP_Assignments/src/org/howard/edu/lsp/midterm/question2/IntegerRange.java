package org.howard.edu.lsp.midterm.question2;

/**
 * class implementing Range interface
 */
public class IntegerRange implements Range{
	private int lowerBound;
	private int upperBound;
	
    /**
     * constructs an integer range with provided lower and upper bounds
     * @param lowerBound the lower bound of the range
     * @param upperBound the upper bound of the range
     */
	public IntegerRange(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
        this.upperBound = upperBound;
	}
	
	/**
	 * determines whether the range contains the supplied value
	 * @param value the value to check if in range
	 * @return true if in range, false otherwise
	 */
	@Override
	public boolean contains(int value) {
        return value >= lowerBound && value <= upperBound;
	}

	/**
	 * determines if the receiver contains at least one value in common with other
	 * @param other the range to check against
	 * @return true if the receiver contains at least one value in common with other, and false otherwise
	 */
	@Override
	public boolean overlaps(Range other) {
        return this.contains(other.getLowerBound()) || this.contains(other.getUpperBound());
	}
	
	/**
	 * determines size of the range (inclusive)
	 * @return size of range
	 */
	@Override
	public int size() {
        return upperBound - lowerBound + 1;
	}
	
	/**
	 * checks if two ranges are equal 
	 * @param obj the object to check against 
	 * @return true if equal (lower & upper bounds are the same), false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        IntegerRange other = (IntegerRange) obj;
        return lowerBound == other.lowerBound && upperBound == other.upperBound;
	}
	
	/**
	 * gets lower bound
	 * @return lower bound
	 */
    public int getLowerBound() {
        return lowerBound;
    }
    
	/**
	 * gets upper bound
	 * @return upper bound
	 */
    public int getUpperBound() {
        return upperBound;
    }


}