package org.howard.edu.lsp.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class IntegerSetTest{
	private IntegerSet setA;
	private IntegerSet setB;
	private IntegerSet setC;

	
	@BeforeEach
	public void setUp() {
		setA = new IntegerSet(new ArrayList<>(Arrays.asList(1,2,3,4)));
		setB = new IntegerSet(new ArrayList<>(Arrays.asList(3,4,5,6)));
		setC = new IntegerSet(new ArrayList<>(Arrays.asList(-2,4,6)));
	}
	
	@Test
	@DisplayName("Test case for toString")
	public void testToString() {
		assertEquals(setA.toString(), "[1, 2, 3, 4]");
		assertEquals(setB.toString(), "[3, 4, 5, 6]");
		assertEquals(setC.toString(), "[-2, 4, 6]");
	}
	
	@Test
	@DisplayName("Test case for clear")
	public void testClear() {
		assertEquals(setA.toString(), "[1, 2, 3, 4]");
		setA.clear();
		assertEquals(setA.toString(), "[]");
		
		assertEquals(setB.toString(), "[3, 4, 5, 6]");
		setB.clear();
		assertEquals(setB.toString(), "[]");
		
		assertEquals(setC.toString(), "[-2, 4, 6]");
		setC.clear();
		assertEquals(setC.toString(), "[]");
		
		// clearing an already cleared set
		setC.clear();
	}
	 
	@Test
	@DisplayName("Test case for length")
	public void testLength() {
		assertEquals(setA.length(), 4);
		assertEquals(setB.length(), 4);
		assertEquals(setC.length(), 3);
		
		// length of empty set
		setA.clear();
		assertEquals(setA.length(), 0);
	}

	@Test
	@DisplayName("Test case for equals")
	public void testEquals() {
		// JUnit test case(s) for equal
	    assertFalse(setA.equals(setB));
	    assertFalse(setB.equals(setC));
	    assertFalse(setC.equals(setA));
	    
		IntegerSet setD = new IntegerSet(new ArrayList<>(Arrays.asList(1,2,3,4)));
		IntegerSet setE = new IntegerSet(new ArrayList<>(Arrays.asList(3,4,5,6)));
		IntegerSet setF = new IntegerSet(new ArrayList<>(Arrays.asList(-2,4,6)));
	    assertTrue(setA.equals(setD));
	    assertTrue(setB.equals(setE));
	    assertTrue(setC.equals(setF));
	}  
	
	@Test
	@DisplayName("Test case for contains")
	public void testContains() {
		assertTrue(setA.contains(2));
		assertTrue(setB.contains(5));
		assertTrue(setC.contains(-2));
		
		assertFalse(setA.contains(0));
		assertFalse(setB.contains(2));
		assertFalse(setC.contains(5));
	}
	
	@Test
	@DisplayName("Test case for largest")
	public void testLargest() {
		assertEquals(setA.largest(), 4);
		assertEquals(setB.largest(), 6);
		assertEquals(setC.largest(), 6);
		
		// Attempting to find the largest value in an empty set.
		setA.clear();
		Throwable exception = assertThrows(Exception.class, () -> setA.largest());
		assertEquals("Set is empty", exception.getMessage());
	} 

	@Test
	@DisplayName("Test case for smallest")
	public void testSmallest() {
		assertEquals(setA.smallest(), 1);
		assertEquals(setB.smallest(), 3);
		assertEquals(setC.smallest(), -2);
		
		// Attempting to find the smallest value in an empty set.
		setA.clear();
		Throwable exception = assertThrows(Exception.class, () -> setA.smallest());
		assertEquals("Set is empty", exception.getMessage());
	} 
	
	@Test
	@DisplayName("Test case for add")
	public void testAdd() {
		setA.add(5);
		setA.add(6);
		assertEquals(setA.toString(), "[1, 2, 3, 4, 5, 6]");
		
		setB.add(7);
		setB.add(8);
		assertEquals(setB.toString(), "[3, 4, 5, 6, 7, 8]");
		
		setC.add(-3);
		setC.add(-1);
		assertEquals(setC.toString(), "[-2, 4, 6, -3, -1]");
	}
	
	@Test
	@DisplayName("Test case for remove")
	public void testRemove() {
		// Attempting to remove value not present (nothing should occur)
		setA.remove(0);
		setB.remove(0);
		setC.remove(0);
		
		setA.remove(3);
		setA.remove(4);
		assertEquals(setA.toString(), "[1, 2]");
		
		setB.remove(3);
		setB.remove(5);
		assertEquals(setB.toString(), "[4, 6]");
		
		setC.remove(6);
		setC.remove(4);
		assertEquals(setC.toString(), "[-2]");
	}
	
	@Test
	@DisplayName("Test case for union")
	public void testUnion() {
		setA.union(setB);
		assertEquals(setA.toString(), "[1, 2, 3, 4, 5, 6]");
		
		setB.union(setC);
		assertEquals(setB.toString(), "[3, 4, 5, 6, -2]");
		
		setC.union(setA);
		assertEquals(setC.toString(), "[-2, 4, 6, 1, 2, 3, 5]");
		
		// union when two sets are equal
		setA.remove(1);
		setA.remove(2);
		setA.remove(6);
		setB.remove(6);
		setB.remove(-2);
		setA.union(setB);
		assertEquals(setB.toString(), "[3, 4, 5]");
		
		// union when two sets are empty
		setA.clear();
		setB.clear();
		setA.union(setB);
		assertEquals(setA.toString(), "[]");
	}
	
	@Test
	@DisplayName("Test case for intersect")
	public void testIntersect() {
		setA.intersect(setB);
		assertEquals(setA.toString(), "[3, 4]");
		
		setB.intersect(setC);
		assertEquals(setB.toString(), "[4, 6]");
		
		setC.intersect(setA);
		assertEquals(setC.toString(), "[4]");
		
		// intersect when two sets are equal
		setB.remove(6);
		setB.intersect(setC);
		assertEquals(setB.toString(), "[4]");
		
		// intersect when two sets are empty
		setA.clear();
		setB.clear();
		setA.intersect(setB);
		assertEquals(setA.toString(), "[]");
	}
	
	@Test
	@DisplayName("Test case for diff")
	public void testDiff() {
		setA.diff(setB);
		assertEquals(setA.toString(), "[1, 2]");
		
		setB.diff(setC);
		assertEquals(setB.toString(), "[3, 5]");
		
		setC.diff(setA);
		assertEquals(setC.toString(), "[-2, 4, 6]");
		
		// difference when two sets are equals
		setB.clear();
		setB.add(1);
		setB.add(2);
		setA.diff(setB);
		assertEquals(setA.toString(), "[]");
	}
	
	@Test
	@DisplayName("Test case for complement")
	public void testComplement() {
		setA.complement(setB);
		assertEquals(setA.toString(), "[5, 6]");
		
		setB.complement(setC);
		assertEquals(setB.toString(), "[-2]");
		
		setC.complement(setA);
		assertEquals(setC.toString(), "[5]");
		
		// complement when two sets are equals
		setB.clear();
		setB.add(5);
		setB.add(6);
		setA.complement(setB);
		assertEquals(setA.toString(), "[]");
	}
	
	@Test
	@DisplayName("Test case for isEmpty")
	public void testIsEmpty() {
		assertFalse(setA.isEmpty());
		assertFalse(setB.isEmpty());
		assertFalse(setC.isEmpty());

		setA.clear();
		setB.clear();
		setC.clear();
		
		assertTrue(setA.isEmpty());
		assertTrue(setB.isEmpty());
		assertTrue(setC.isEmpty());
	}
}
