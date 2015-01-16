package com.danielacton.datastructures.test;

import junit.framework.TestCase;

import com.danielacton.datastructures.Hashtable;

/**
 * Tests the Hashtable class
 * @author Daniel Acton
 *
 */
public class HashtableTest extends TestCase {
	
	/**
	 * Test that the Hashtable is constructed. 
	 * Result is a hash table with 0 elements.
	 */
	public void testCreation() {
		Hashtable table = new Hashtable();
		assertEquals(0, table.getNumElements());
	}
	
	/**
	 * Test that creating with a single element works 
	 * Result is a table with 1 element
	 */
	public void testCreationWithOneElement() {
		Hashtable table = new Hashtable("Key 1", "a");
		assertEquals(1, table.getNumElements());
		assertTrue(table.contains("Key 1"));
	}
	
	/**
	 * Test that creating with many elements works 
	 * Result is a table with 4 elements
	 */
	public void testCreationWithManyElements() {
		Hashtable table = new Hashtable(new Object [] {"Key 1", "Key 2", "Key 3", "Key 4"}, new Object [] {"a", "b", "c", "d"});
		assertTrue(table.contains("Key 1"));
		assertTrue(table.contains("Key 2"));
		assertTrue(table.contains("Key 3"));
		assertTrue(table.contains("Key 4"));
		assertEquals(4, table.getNumElements());
	}

	/**
	 * Test that adding a single element works
	 * Result is a table with 1 element
	 */
	public void testAddSingle() {
		Hashtable table = new Hashtable();
		table.add("Key 1", "a");
		assertTrue(table.contains("Key 1"));
		assertEquals(1, table.getNumElements());
	}

	/**
	 * Test that adding many elements works
	 * Result is a table with many elements 
	 */
	public void testAddMany() {
		Hashtable table = new Hashtable();
		table.add(new Object [] {"Key 1", "Key 2", "Key 3", "Key 4"}, new Object [] {"a", "b", "c", "d"});
		assertTrue(table.contains("Key 1"));
		assertTrue(table.contains("Key 2"));
		assertTrue(table.contains("Key 3"));
		assertTrue(table.contains("Key 4"));
		assertEquals(4, table.getNumElements());
	}
	
	/**
	 * Test that removing a single element works
	 * Result is a table with 1 less element
	 */
	public void testRemoveSingle() {
		Hashtable table = new Hashtable();
		table.add("Key 1", "a");
		table.add("Key 2", "b");
		table.add("Key 3", "c");
		table.add("Key 4", "d");
		
		table.remove("Key 1");
		
		assertFalse(table.contains("Key 1"));
		assertTrue(table.contains("Key 2"));
		assertTrue(table.contains("Key 3"));
		assertTrue(table.contains("Key 4"));
		assertEquals(3, table.getNumElements());	
	}

	/**
	 * Test that removing many elements works
	 * Result is a table with N less elements
	 */
	public void testRemoveMultiple() {
		Hashtable table = new Hashtable();
		table.add("Key 1", "a");
		table.add("Key 2", "b");
		table.add("Key 3", "c");
		table.add("Key 4", "d");
		table.add("Key 5", "e");
		table.add("Key 6", "f");
		
		table.remove(new Object [] {"Key 1", "Key 2", "Key 3"});
		
		assertFalse(table.contains("Key 1"));
		assertFalse(table.contains("Key 2"));
		assertFalse(table.contains("Key 3"));
		assertTrue(table.contains("Key 4"));
		assertTrue(table.contains("Key 5"));
		assertTrue(table.contains("Key 6"));
		assertEquals(3, table.getNumElements());	
	}

	/**
	 * Test that removing all elements works
	 * Result is a table with 0 elements
	 */
	public void testRemoveAllOneByOne() {
		Hashtable table = new Hashtable();
		table.add("Key 1", "a");
		table.add("Key 2", "b");
		table.add("Key 3", "c");
		table.add("Key 4", "d");
		table.add("Key 5", "e");
		table.add("Key 6", "f");
		
		table.remove("Key 1");
		table.remove("Key 2");
		table.remove("Key 3");
		table.remove("Key 4");
		table.remove("Key 5");
		table.remove("Key 6");
		
		assertFalse(table.contains("Key 1"));
		assertFalse(table.contains("Key 2"));
		assertFalse(table.contains("Key 3"));
		assertFalse(table.contains("Key 4"));
		assertFalse(table.contains("Key 5"));
		assertFalse(table.contains("Key 6"));
		assertEquals(0, table.getNumElements());	
	}

	/**
	 * Test that removing all elements works
	 * Result is a table with 0 elements
	 */
	public void testRemoveAllAtOnce() {
		Hashtable table = new Hashtable();
		table.add("Key 1", "a");
		table.add("Key 2", "b");
		table.add("Key 3", "c");
		table.add("Key 4", "d");
		table.add("Key 5", "e");
		table.add("Key 6", "f");
		
		table.remove(new Object [] {"Key 1", "Key 2", "Key 3", "Key 4", "Key 5", "Key 6"});
		
		assertFalse(table.contains("Key 1"));
		assertFalse(table.contains("Key 2"));
		assertFalse(table.contains("Key 3"));
		assertFalse(table.contains("Key 4"));
		assertFalse(table.contains("Key 5"));
		assertFalse(table.contains("Key 6"));
		assertEquals(0, table.getNumElements());	
	}
	
	/**
	 * Test that removing an element that doesn't exist works
	 * Result is the same 
	 */
	public void testRemoveNonexisting() {
		Hashtable table = new Hashtable();
		table.add("Key 1", "a");
		table.add("Key 2", "b");
		table.add("Key 3", "c");
		table.add("Key 4", "d");
		table.add("Key 5", "e");
		table.add("Key 6", "f");
		table.add(new Object [] {"Key 7", "Key 8", "Key 9", "Key 10"}, new Object [] {"g", "h", "i", "j"});
		table.remove("Key 99");
		table.remove(new Object [] {"Key 98", "Key 97", "Key 96"});
		assertEquals(10, table.getNumElements());
	}
	
	/**
	 * Test that adding duplicate keys does not work
	 * Result is a list that doesn't change when you add the same key twice
	 */
	public void testAddDuplicateKeys() {
		Hashtable table = new Hashtable();
		table.add("Key 1", "a");
		table.add("Key 2", "b");
		table.add("Key 3", "c");
		table.add("Key 4", "d");
		table.add("Key 1", "e");
		table.add("Key 2", "f");
		table.add("Key 3", "g");
		table.add("Key 4", "h");
		
		assertEquals(4, table.getNumElements());
		
	}
}
