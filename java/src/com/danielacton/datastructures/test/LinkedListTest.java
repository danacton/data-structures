package com.danielacton.datastructures.test;

import junit.framework.TestCase;

import com.danielacton.datastructures.LinkedList;

/**
 * Tests the LinkedList class
 * 
 * @author Daniel Acton (code@danielacton.com)
 *
 */
public class LinkedListTest extends TestCase {

  /**
   * Test that the LinkedList is constructed. Result is a list with 0 elements.
   */
  public void testCreation() {
    LinkedList<Integer> list = new LinkedList<Integer>();
    assertEquals(0, list.size());
  }

  /**
   * Test that creating with a single element works Result is a list with 1
   * element with a certain value
   */
  public void testCreationWithOneElement() {
    LinkedList<String> list = new LinkedList<String>("a");
    assertEquals(1, list.size());
    assertEquals("a", list.elementAt(0));
  }

  /**
   * Test that creating with many elements works Result is a list with 4
   * elements with certain values
   */
  public void testCreationWithManyElements() {
    LinkedList<String> list = new LinkedList<String>(new String[] { "a", "b",
        "c", "d" });

    assertEquals("a", list.elementAt(0));
    assertEquals("b", list.elementAt(1));
    assertEquals("c", list.elementAt(2));
    assertEquals("d", list.elementAt(3));
    assertEquals(4, list.size());
  }

  /**
   * Test that adding a single element works Result is a list with 1 elements
   * with a certain value
   */
  public void testAddSingle() {
    LinkedList<String> list = new LinkedList<String>();

    list.add("a");

    assertEquals("a", list.elementAt(0));
    assertEquals(1, list.size());
  }

  /**
   * Test that adding many elements works Result is a list with many elements
   * with certain values
   */
  public void testAddMany() {
    LinkedList<String> list = new LinkedList<String>();

    list.add(new String[] { "x", "y", "z" });

    assertEquals("x", list.elementAt(0));
    assertEquals("y", list.elementAt(1));
    assertEquals("z", list.elementAt(2));

    assertEquals(3, list.size());
  }

  /**
   * Test that removing a single element from the start of the list works Result
   * is a list moved "one to the left" with first item replaced
   */
  public void testRemoveSingleStart() {
    LinkedList<String> list = new LinkedList<String>();

    list.add(new String[] { "x", "y", "z" });
    list.remove("x");

    assertEquals("y", list.elementAt(0));
    assertEquals("z", list.elementAt(1));
    assertEquals(2, list.size());
  }

  /**
   * Test that removing a single element from anywhere in the list works Result
   * is a list moved "one to the left" with item replaced
   */
  public void testRemoveSingleMiddle() {
    LinkedList<String> list = new LinkedList<String>();

    list.add(new String[] { "x", "y", "z" });
    list.remove("y");

    assertEquals("x", list.elementAt(0));
    assertEquals("z", list.elementAt(1));
    assertEquals(2, list.size());
  }

  /**
   * Test that removing a single element from the end of the list works Result
   * is a list that is 1 element shorter
   */
  public void testRemoveSingleEnd() {
    LinkedList<String> list = new LinkedList<String>();

    list.add(new String[] { "x", "y", "z" });
    list.remove("z");

    assertEquals("x", list.elementAt(0));
    assertEquals("y", list.elementAt(1));
    assertEquals(2, list.size());
  }

  /**
   * Test that removing all elements works Result is an empty list
   */
  public void testRemoveAll() {
    LinkedList<String> list = new LinkedList<String>();

    list.add(new String[] { "x", "y", "z" });
    list.remove(new String[] { "x", "y", "z" });

    assertEquals(0, list.size());
  }

  /**
   * Test that removing many elements from the start of the list works Result is
   * a list moved "N to the left"
   */
  public void testRemoveManyFromBeginning() {
    LinkedList<String> list = new LinkedList<String>();

    list.add(new String[] { "x", "y", "z", "a", "b", "c" });
    list.remove(new String[] { "x", "y", "z" });

    assertEquals("a", list.elementAt(0));
    assertEquals("b", list.elementAt(1));
    assertEquals("c", list.elementAt(2));
    assertEquals(3, list.size());
  }

  /**
   * Test that removing many elements from the end of the list works Result is a
   * list that is N elements shorter
   */
  public void testRemoveManyFromEnd() {
    LinkedList<String> list = new LinkedList<String>();

    list.add(new String[] { "x", "y", "z", "a", "b", "c" });
    list.remove(new String[] { "a", "b", "c" });

    assertEquals("x", list.elementAt(0));
    assertEquals("y", list.elementAt(1));
    assertEquals("z", list.elementAt(2));
    assertEquals(3, list.size());
  }

  /**
   * Test that removing many elements from the end of the list works Result is a
   * list that is N elements shorter, keeping start and end bits
   */
  public void testRemoveManyFromInside() {
    LinkedList<String> list = new LinkedList<String>();

    list.add(new String[] { "x", "y", "z", "a", "b", "c" });
    list.remove(new String[] { "y", "z", "a", "b" });

    assertEquals("x", list.elementAt(0));
    assertEquals("c", list.elementAt(1));
    assertEquals(2, list.size());
  }

  /**
   * Test that searching for an element works Result is the correct position of
   * the elements added
   */
  public void testIndexOf() {
    LinkedList<String> list = new LinkedList<String>();

    list.add(new String[] { "x", "y", "z", "a", "b", "c" });

    assertEquals(0, list.indexOf("x"));
    assertEquals(1, list.indexOf("y"));
    assertEquals(2, list.indexOf("z"));
    assertEquals(3, list.indexOf("a"));
    assertEquals(4, list.indexOf("b"));
    assertEquals(5, list.indexOf("c"));
    assertEquals(-1, list.indexOf("g"));
  }

  /**
   * Concatenate lists A and B where A is empty Result is B
   */
  public void testConcatenationEmptyA() {
    LinkedList<String> listA = new LinkedList<String>();
    LinkedList<String> listB = new LinkedList<String>();

    listB.add(new String[] { "x", "y", "z", "a", "b", "c" });

    listA.concatenate(listB);
    assertEquals(0, listA.indexOf("x"));
    assertEquals(1, listA.indexOf("y"));
    assertEquals(2, listA.indexOf("z"));
    assertEquals(3, listA.indexOf("a"));
    assertEquals(4, listA.indexOf("b"));
    assertEquals(5, listA.indexOf("c"));
    assertEquals(listA.size(), listB.size());
  }

  /**
   * Concatenate lists A and B where B is empty Result is A
   */
  public void testConcatenationEmptyB() {
    LinkedList<String> listA = new LinkedList<String>();
    LinkedList<String> listB = new LinkedList<String>();

    listA.add(new String[] { "x", "y", "z", "a", "b", "c" });

    int i = listA.size();

    listA.concatenate(listB);
    assertEquals(0, listA.indexOf("x"));
    assertEquals(1, listA.indexOf("y"));
    assertEquals(2, listA.indexOf("z"));
    assertEquals(3, listA.indexOf("a"));
    assertEquals(4, listA.indexOf("b"));
    assertEquals(5, listA.indexOf("c"));

    assertEquals(listA.size(), i);
  }

  /**
   * Concatenate lists A and B where neither is empty Result is A+B
   */
  public void testConcatenationABNonEmpty() {
    LinkedList<String> listA = new LinkedList<String>();
    LinkedList<String> listB = new LinkedList<String>();

    listA.add(new String[] { "x", "y", "z" });

    int i = listA.size();

    listB.add(new String[] { "a", "b", "c" });

    listA.concatenate(listB);
    assertEquals(0, listA.indexOf("x"));
    assertEquals(1, listA.indexOf("y"));
    assertEquals(2, listA.indexOf("z"));
    assertEquals(3, listA.indexOf("a"));
    assertEquals(4, listA.indexOf("b"));
    assertEquals(5, listA.indexOf("c"));

    assertEquals(listA.size(), listB.size() + i);
  }

  /**
   * Concatenate lists A and B where both are empty Result is empty
   */
  public void testConcatenationABBothEmpty() {
    LinkedList<String> listA = new LinkedList<String>();
    LinkedList<String> listB = new LinkedList<String>();

    listA.concatenate(listB);
    assertEquals(0, listA.size());
  }

}
