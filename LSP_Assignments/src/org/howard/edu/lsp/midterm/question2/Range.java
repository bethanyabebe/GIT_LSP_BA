package org.howard.edu.lsp.midterm.question2;

public interface Range {
	
    /**
     * Checks if the range contains a specific value
     * @param value the value to check
     * @return true if v is ≥ lower bound and ≤ upper bound and false otherwise
     */
	public boolean contains( int value ); 
	
    /**
     * Checks if the range overlaps with another range
     * @param other the other range to check
     * @return true if the receiver contains at least one value in common with other, and false otherwise
     */
	public boolean overlaps( Range other );
	
    /**
     * Calculates the number of integers in the range.
     * @return the size of the range
     */
	public int size(); 
	
	/**
	 * Gets the lower bound of the range
	 * @return the lower bound
	 */
	int getLowerBound();
	
	/**
	 * Gets the upper bound of the range
	 * @return the upper bound
	 */
	int getUpperBound();
}