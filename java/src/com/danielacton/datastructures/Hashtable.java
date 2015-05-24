package com.danielacton.datastructures;

public class Hashtable<K extends Comparable<K>, V extends Comparable<V>> {
  private final int tableSize = 20;
  private int numElements;

  private Object[] table;

  public Hashtable() {
    this.numElements = 0;
    this.table = new Object[tableSize];
  }

  public Hashtable(K initialKey, V initialData) {
    this();
    this.add(initialKey, initialData);
  }

  public Hashtable(K[] initialKeys, V[] initialData) {
    this();

    // Don't do stuff with differently sized input arrays
    if (initialKeys.length != initialData.length) {
      System.err
          .println("ERROR: The size of the keys and data arrays are different");
    }

    this.add(initialKeys, initialData);
  }

  /**
   * Add an item to the hash table.
   * 
   * @param key The key for the data.
   * @param data The data to store.
   */
  @SuppressWarnings("unchecked")
  public void add(K key, V data) {
    if (data == null || key == null) {
      System.err.println("ERROR: Either the key or the data are null");
      return;
    }

    /* Don't add duplicate keys */
    if (this.contains(key)) {
      return;
    }

    /* Find out where in our array the item should go */
    int position = this.hash(key);

    /* If nothing exists in the position, create a new linked list there */
    if (this.table[position] == null) {
      this.table[position] = new LinkedList<HashtableNode<K, V>>();
    }

    /* Add to the linked list in the appropriate position */
    LinkedList<HashtableNode<K, V>> list = (LinkedList<HashtableNode<K, V>>) this.table[position];
    list.add(new HashtableNode<K, V>(key, data));
    this.numElements++;
  }

  /**
   * Add a an array of items to the hash table with corresponding keys. The
   * given arrays of keys and data must have corresponding indexes. So if you
   * have a key at index 2 in the input key array, the data at index 2 of the
   * input data array is what will be put in the Hasthable.
   * 
   * @param keys The keys for the data.
   * @param inputData The data to add.
   */
  public void add(K[] keys, V[] inputData) {
    for (int i = 0; i < inputData.length; i++) {
      this.add(keys[i], inputData[i]);
    }
  }

  /**
   * Remove an item from the hashtable
   * 
   * @param key The item to remove
   */
  @SuppressWarnings("unchecked")
  public void remove(K key) {
    int hashVal = this.hash(key);
    LinkedList<HashtableNode<K, V>> list = (LinkedList<HashtableNode<K, V>>) this.table[hashVal];

    if (list != null) {
      HashtableNode<K, V> node = new HashtableNode<K, V>();
      node.setKey(key);

      if (list.indexOf(node) > -1) {
        list.remove(node);
        this.numElements--;
      }
    }
  }

  /**
   * Remove many items from the hashtable.
   * 
   * @param inputData The array of items to remove.
   */
  public void remove(K[] keys) {
    for (int i = 0; i < keys.length; i++) {
      this.remove(keys[i]);
    }
  }

  /**
   * Calculate the hash for an object being stored. Use the toString() method to
   * get a string from the Object and then add the ASCII values of the string
   * (unless it's a-f, in which case we'll use it as hex).
   * 
   * @param key The key for which to compute a hash.
   * @return The hash, an integer to be used for the data's position in the
   *         backing array.
   */
  private int hash(K key) {

    // Start with a base, just so that it's not 0 for empty strings
    int result = 42;

    String inputString = key.toString().toLowerCase();

    char[] characters = inputString.toCharArray();
    for (int i = 0; i < characters.length; i++) {
      char currentChar = characters[i];

      if (currentChar == 'a' || currentChar == 'b' || currentChar == 'c'
          || currentChar == 'e' || currentChar == 'e' || currentChar == 'f') {
        result += Integer.parseInt("" + currentChar, 16);
      }

      int j = (int) currentChar;
      result += j;
    }

    return (result % this.tableSize);
  }

  /**
   * Give a string representation of the hash table.
   * 
   * @return A string representation of the contents of the Hashtable.
   */
  public String toString() {
    StringBuffer buffer = new StringBuffer();

    buffer.append(System.getProperty("line.separator"));
    buffer.append("{");
    buffer.append(System.getProperty("line.separator"));

    for (int i = 0; i < this.table.length; i++) {
      if (this.table[i] != null) {
        buffer.append("\t" + this.table[i]);
        buffer.append(System.getProperty("line.separator"));
      }
    }

    buffer.append("}");

    return buffer.toString();
  }

  /**
   * Get the number of elements in the Hashtable.
   * 
   * @return The number of elements in the Hasthable.
   */
  public int getNumElements() {
    return this.numElements;
  }

  /**
   * Check if the table contains a certain element or not.
   * 
   * @param data The data to search for.
   * @return Whether or not the element exists.
   */
  @SuppressWarnings("unchecked")
  public boolean contains(K key) {
    boolean result = false;
    int hash = this.hash(key);

    LinkedList<HashtableNode<K, V>> list = (LinkedList<HashtableNode<K, V>>) this.table[hash];

    if (list != null) {
      HashtableNode<K, V> node = new HashtableNode<K, V>();
      node.setKey(key);
      if (list.indexOf(node) > -1) {
        result = true;
      }
    }

    return result;
  }

  /**
   * An inner class to represent an entry in the Hashtable. Bascially just holds
   * the key/data pair. This is here because we need to keep the key as well as
   * the data so that we can address a particular entry in the hashtable rather
   * than just a particular entry in the backing array.
   * 
   */
  private class HashtableNode<A extends Comparable<A>, B extends Comparable<B>>
      implements Comparable<HashtableNode<A, B>> {
    private A key;
    private B data;

    public HashtableNode() {
      this.key = null;
      this.data = null;
    }

    public HashtableNode(A key, B data) {
      this.key = key;
      this.data = data;
    }

    public B getData() {
      return data;
    }

    public void setData(B data) {
      this.data = data;
    }

    public A getKey() {
      return key;
    }

    public void setKey(A key) {
      this.key = key;
    }

    /*
     * Equality can be based on key alone because there can't be 2 nodes with
     * the same key in the table
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
      if (obj instanceof HashtableNode) {
        HashtableNode<A, B> node = (HashtableNode<A, B>) obj;
        return this.key.equals(node.getKey());
      } else {
        return false;
      }
    }

    public String toString() {
      return "Key: [" + this.key + "] data: [" + this.data + "]";
    }

    @Override
    public int compareTo(Hashtable<K, V>.HashtableNode<A, B> other) {
      if (this.key != null) {
        return this.key.compareTo(other.getKey());
      } else {
        return 1;
      }
    }
  }
}
