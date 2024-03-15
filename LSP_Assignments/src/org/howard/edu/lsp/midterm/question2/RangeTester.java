package org.howard.edu.lsp.midterm.question2;

public class RangeTester {
	public static void main(String[] args) {
		// creating two integer ranges
        Range range1 = new IntegerRange(1, 5);
        Range range2 = new IntegerRange(4, 8);

        // testing contains method
        System.out.println("Range 1 contains 3: " + range1.contains(3)); 
        // Expected: true
        System.out.println("Range 2 contains 10: " + range2.contains(10)); 
        // Expected: false

        // testing overlaps method
        System.out.println("Range 1 overlaps with range 2: " + range1.overlaps(range2)); 
        // Expected: true

        // testing size method
        System.out.println("Size of range 1: " + range1.size()); 
        // Expected: 5
        System.out.println("Size of range 2: " + range2.size()); 
        // Expected: 5

        // testing equals method
        Range range3 = new IntegerRange(1, 5);
        System.out.println("Range 1 equals range 3: " + range1.equals(range3)); 
        // Expected: true
	}
}
