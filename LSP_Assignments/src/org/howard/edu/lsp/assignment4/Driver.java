package org.howard.edu.lsp.assignment4;

import java.util.ArrayList;

public class Driver {
	public static void main (String[] args)
	{
		/*IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);

		System.out.println("Value of Set1 is:" + set1.toString());
		System.out.println("Smallest value in Set1 is:" + set1.smallest());
		System.out.println("Largest value in Set1 is:" + set1.largest());

		IntegerSet set2 = new IntegerSet();
		set2.add(3);
		set2.add(4);
		set2.add(5);

		System.out.println("Union of Set1 and Set2");
		System.out.println("Value of Set1 is:" + set1.toString());
		// Set1: [1,2,3]
		System.out.println("Value of Set2 is:" + set2.toString());
		// Set2: [3,4,5]
		set1.union(set2);	// union of set1 and set2
		System.out.println("Result of union of Set1 and Set2:" + set1.toString()); // result of union of set1 and set2
		// Result: [1,2,3,4,5]
		
		// Removing from empty set
		IntegerSet set3 = new IntegerSet();
		set3.remove(1);
		
        set3.add(2);
        set3.add(4);
        set3.add(6);

        System.out.println("Intersection of Set1 and Set3");
        System.out.println("Value of Set1 is: " + set1.toString());
        //Set1: [1,2,3,4,5]
        System.out.println("Value of Set3 is: " + set3.toString());
        //Set3: [2,4,6]
        set1.intersect(set3);  // intersection of set1 and set3
        System.out.println("Result of intersection of Set1 and Set3: " + set1.toString());
        //Result: [2,4]

        IntegerSet set4 = new IntegerSet();
        set4.add(3);
        set4.add(5);

        System.out.println("Difference of Set1 and Set4");
        System.out.println("Value of Set1 is: " + set1.toString());
        //Set1: [2,4]
        System.out.println("Value of Set4 is: " + set4.toString());
        //Set4: [3,5]
        set1.diff(set4);    // difference of set1 and set4
        System.out.println("Result of difference of Set1 and Set4: " + set1.toString());
        //Result: [2,4]

        IntegerSet set5 = new IntegerSet();
        set5.add(1);
        set5.add(2);
        set5.add(3);

        System.out.println("Complement of Set5 with respect to Set1");
        System.out.println("Value of Set1 is: " + set1.toString());
        //Set1: [2,4]
        System.out.println("Value of Set5 is: " + set5.toString());
        //Set5: [1,2,3]
        set1.complement(set5);    // complement of set5 with respect to set1
        System.out.println("Result of complement of Set5 with respect to Set1: " + set1.toString());
        //Result: [1,3]
        */
        
        
        IntegerSet setA = new IntegerSet();
        System.out.println("Is SetA empty?: " + setA.isEmpty());
        // Expected: True
        setA.add(0);
        setA.add(1);
        setA.add(2);
        System.out.println("After adding, is SetA empty?: " + setA.isEmpty());
        // Expected: False
        
        
        ArrayList<Integer> initializedSet = new ArrayList<Integer>();
        initializedSet.add(0);
        initializedSet.add(1);
        initializedSet.add(2);
        IntegerSet setB = new IntegerSet(initializedSet);
        
        System.out.println("Are setA & setB equal? " + setA.equals(setB));
        // Expected: True 
        setA.clear();
        System.out.println("After clearing setA, are setA & setB equal? " + setA.equals(setB));
        // Expected: False
        
        setA.add(-2);
        setA.add(2);
        setA.add(4);
        setA.add(6);
        
        System.out.println("setA: " + setA.toString());
        // Expected: [-2,2,4,6]
        System.out.println("setB: " + setB.toString());
        // Excepted: [0,1,2]


        System.out.println("Does setA contain -2? " + setA.contains(-2));
        // Expected: True 
        System.out.println("Does setB contain -2? " + setB.contains(-2));
        // Expected: False 
        System.out.println("Does setB contain 2? " + setB.contains(2));
        // Expected: True
        
        System.out.println("Length of setA: " + setA.length());
        // Expected: 4
        System.out.println("Length of setB: " + setB.length());
        // Expected: 3
        
        System.out.println("Largest value in setA: " + setA.largest());
        // Expected: 6
        System.out.println("Smallest value in setA: " + setA.smallest());
        // Expected: -2
        System.out.println("Largest value in setB: " + setB.largest());
        // Expected: 2
        System.out.println("Smallest value in setB: " + setB.smallest());
        // Expected: 0
        
        IntegerSet emptySet = new IntegerSet();
        try {
            System.out.println("Attempting to find the largest value in an empty set.");
            System.out.println("Largest value in emptySet is: " + emptySet.largest());
        } catch (IntegerSet.IntegerSetException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        try {
            System.out.println("Attempting to find the smallest value in an empty set.");
            System.out.println("Smallest value in Empty Set is: " + emptySet.smallest());
        } catch (IntegerSet.IntegerSetException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Removing value not present & present
        setA.remove(10);
        setA.remove(6);
        
        System.out.println("setA: " + setA.toString());
        // Expected: [-2,2,4]
        System.out.println("setB: " + setB.toString());
        // Expected: [0,1,2]
        
        setA.union(setB);
        System.out.println("Union of setA & setB: " + setA.toString());
        // Expected: [-2,2,4,0,1]

        System.out.println("setA: " + setA.toString());
        // Expected: [-2,2,4,0,1]
        System.out.println("setB: " + setB.toString());
        // Expected: [0,1,2]
        
        setA.intersect(setB);
        System.out.println("Intersection of setA & setB: " + setA.toString());
        // Expected: [2,0,1]

        System.out.println("setA: " + setA.toString());
        // Expected: [2,0,1]
        System.out.println("setB: " + setB.toString());
        // Expected: [0,1,2]
        
        setA.diff(setB);
        System.out.println("Difference of setA & setB: " + setA.toString());
        // Expected: []
        
        setA.add(2);
        setA.add(4);
        setA.add(6);
        
        setB.clear();
        setB.add(2);
        setB.add(3);
        setB.add(4);
        System.out.println("setA: " + setA.toString());
        // Expected: [2,4,6]
        System.out.println("setB: " + setB.toString());
        // Expected: [2,3,4]
        
        setA.diff(setB);
        System.out.println("Difference of setA & setB: " + setA.toString());
        // Expected: [6]
        
       
        setA.clear();
        setB.clear();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);
        setA.add(5);
        setB.add(3);
        setB.add(4);
        setB.add(5);
        setB.add(6);
        setB.add(7);
        
        System.out.println("setA: " + setA.toString());
        // Expected: [1,2,3,4,5]
        System.out.println("setB: " + setB.toString());
        // Expected: [3,4,5,6,7]
        
        setA.complement(setB);
        System.out.println("Complement of setA: " + setA.toString());
        // Expected: [6,7]
        
        setA.clear();
        setB.clear();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);
        setA.add(5);
        setB.add(3);
        setB.add(4);
        setB.add(5);
        setB.add(6);
        setB.add(7);
        
        setA.diff(setB);
        System.out.println("Diff of setA: " + setA.toString());
        // Expected: [1,2]
        
        setA.clear();
        setB.clear();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);
        setA.add(5);
        setB.add(3);
        setB.add(4);
        setB.add(5);
        setB.add(6);
        setB.add(7);
        setB.diff(setA);
        System.out.println("Diff of setB: " + setB.toString());
        // Expected: [6,7]
        
	}
}
