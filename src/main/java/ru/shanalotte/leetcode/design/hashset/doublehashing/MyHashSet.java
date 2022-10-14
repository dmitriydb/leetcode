package ru.shanalotte.leetcode.design.hashset.doublehashing;

public class MyHashSet {

    private static final int INITIAL_CAPACITY = 32;
    private final static double LOAD_FACTOR = 0.8d;
    private final static int DELETED_VALUE = -1;
    private final static int CONST = 5;
    private int currentLoad = 0;

    private Integer[] hash = new Integer[INITIAL_CAPACITY];

    public MyHashSet() {

    }

    public void add(int key) {
      if (contains(key)) {
        return;
      }
      int position = position(key);
      while (hash[position] != null) {
        int step = CONST - (key % CONST);
        position += step;
        position = position % hash.length;
      }
      hash[position] = key;
      currentLoad++;
      if (currentLoad > LOAD_FACTOR * hash.length) {
        rehash();
      }
    }

    private void rehash() {
      currentLoad = 0;
      Integer[] newArray = new Integer[hash.length * 3];
      for (Integer key : hash) {
        if (key != null && key != -1) {
          int position = key % newArray.length;
          while (newArray[position] != null) {
            int step = CONST - (key % CONST);
            position += step;

            position = position % newArray.length;
          }
          newArray[position] = key;
          currentLoad++;
        }
      }
      hash = newArray;
    }

    private int position(int key) {
      return key % hash.length;
    }

    public void remove(int key) {
      int position = position(key);
      while (hash[position] != null) {
        if (hash[position] == key) {
          hash[position] = -1;
          return;
        }
        int step = CONST - (key % CONST);
        position += step;

        position = position % hash.length;
      }
    }

    public boolean contains(int key) {
      int position = position(key);
      boolean found = false;
      while (hash[position] != null) {
        if (hash[position] == key) {
          found = true;
          break;
        }
        int step = CONST - (key % CONST);
        position += step;

        position = position % hash.length;
      }
      return found;
    }


  }


