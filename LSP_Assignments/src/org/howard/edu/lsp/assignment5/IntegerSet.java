package org.howard.edu.lsp.assignment5;
import java.util.ArrayList;
import java.util.List;

/**
 * The IntegerSet represents a set of integers and provides various operations on the set.
 */
public class IntegerSet  {
	
	// Store the set elements in an ArrayList
	private List<Integer> set = new ArrayList<>();

    /**
     * Default Constructor for IntegerSet.
     */
	public IntegerSet() {

	}

    /**
     * Constructor for IntegerSet with an already initialized set.
     *
     * @param set An ArrayList of integers representing the set.
     */
	public IntegerSet(ArrayList<Integer> set) {
		this.set = set;
	}

    /**
     * Clears the internal representation of the set.
     */
	public void clear() {
		set.clear();
	}

    /**
     * Returns the length of the set.
     *
     * @return The length of the set.
     */
	public int length() {
		return set.size(); // returns the length
	} 

    /**
     * Checks if two sets are equal. Two sets are equal if they contain all the same values in ANY order.
     *
     * @param o The object to compare with.
     * @return True if the two sets are equal, false otherwise.
     */
	@Override
	public boolean equals(Object o) {
		// The two objects are the same
		if (this == o) return true;
		// The object is null or not a set 
		if (o == null || getClass() != o.getClass()) return false;
		// Create instance of o where instance.set is o
		IntegerSet oInstance = (IntegerSet) o;
		// Check if all values of set is in o and vice versa
		return set.containsAll(oInstance.set) && oInstance.set.containsAll(set);
	}

    /**
     * Checks if the set contains a specific value.
     *
     * @param value The value to check for in the set.
     * @return True if the set contains the value, false otherwise.
     */
	public boolean contains(int value) {
		return set.contains(value);
	}

    /**
     * Returns the largest item in the set. Throws an IntegerSetException if the set is empty.
     *
     * @return The largest item in the set.
     * @throws IntegerSetException If the set is empty.
     */
	public int largest() throws IntegerSetException {
		// throw IntegerSetException exception if set is empty
		if (isEmpty()) {
			throw new IntegerSetException("Set is empty");
		}
		int max = set.get(0);
		for (int value : set) {
			if (value > max) {
				max = value;
			}
		}
		return max;
	}

    /**
     * Returns the smallest item in the set. Throws an IntegerSetException if the set is empty.
     *
     * @return The smallest item in the set.
     * @throws IntegerSetException If the set is empty.
     */
	public int smallest() throws IntegerSetException {
		if (isEmpty()) {
			throw new IntegerSetException("Set is empty");
		}
		int min = set.get(0);
		for (int value : set) {
			if (value < min) {
				min = value;
			}
		}
		return min;
	}

    /**
     * Adds an item to the set or does nothing if it already exists in the set.
     *
     * @param item The item to be added to the set.
     */
	public void add(int item) {
 		if(!set.contains(item)) {
 			set.add(item);  // adds item to the set or does nothing if it is in set
 		}
 	} 

    /**
     * Removes an item from the set or does nothing if it is not present in the set.
     *
     * @param item The item to be removed from the set.
     */
	public void remove(int item) {
 		set.remove((Integer) item);
 	}

    /**
     * Performs the union of two sets, without duplicates.
     *
     * @param intSetb The IntegerSet to be unioned with the current set.
     */
	public void union(IntegerSet intSetb) {
		// Only adds intSetb values to set if not already in set.
	    for (int value : intSetb.set) {
	        if (!set.contains(value)) {
	            set.add(value);
	        }
	    }
	}
	
    /**
     * Performs the intersection of two sets.
     *
     * @param intSetb The IntegerSet to be intersected with the current set.
     */
	public void intersect(IntegerSet intSetb) {
		set.retainAll(intSetb.set);
	} 
	
    /**
     * Performs the difference of two sets (s1 - s2).
     *
     * @param intSetb The IntegerSet to be subtracted from the current set.
     */
	public void diff(IntegerSet intSetb) {
		set.removeAll(intSetb.set);
	}; 
	
    /**
     * Computes the complement of the set with respect to another set.
     *
     * @param intSetb The IntegerSet to compute the complement against.
     */
	public void complement(IntegerSet intSetb) {
        List<Integer> complement = new ArrayList<>(intSetb.set);
        complement.removeAll(set);
        set = complement;
	}
	
    /**
     * Checks if the set is empty.
     *
     * @return True if the set is empty, false otherwise.
     */
	boolean isEmpty() {
		return set.isEmpty();
	}
	
    /**
     * Returns the String representation of the set.
     *
     * @return The String representation of the set.
     */
	@Override
	public String toString() {
		return set.toString(); // return String representation of your set
	}
}
