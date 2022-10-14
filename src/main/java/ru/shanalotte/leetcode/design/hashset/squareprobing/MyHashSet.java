package ru.shanalotte.leetcode.design.hashset.squareprobing;


public class MyHashSet {

  private static final int INITIAL_CAPACITY = 37;
  private final static double LOAD_FACTOR = 0.8d;
  private final static int DELETED_VALUE = -1;
  private int currentLoad = 0;

  private Integer[] hash = new Integer[INITIAL_CAPACITY];

  public MyHashSet() {

  }

  private boolean isPrime(int n) {
    for (int i = 3; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }

    }
    return true;
  }

  public void add(int key) {
    if (contains(key)) {
      return;
    }
    int position = position(key);
    int step = 1;
    while (hash[position] != null) {
      position += (step * step);
      step++;
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
    int newSize = hash.length * 3;
    while (!isPrime(newSize)) {
      newSize++;
    }
    Integer[] newArray = new Integer[newSize];
    for (Integer key : hash) {
      if (key != null && key != DELETED_VALUE) {
        int position = key % newArray.length;
        int step = 1;

        while (newArray[position] != null) {
          position += (step * step);
          step++;
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
    int step = 1;

    while (hash[position] != null) {
      if (hash[position] == key) {
        hash[position] = DELETED_VALUE;
        return;
      }
      position += (step * step);
      step++;
      position = position % hash.length;
    }
  }

  public boolean contains(int key) {
    int position = position(key);
    boolean found = false;
    int step = 1;
    while (hash[position] != null) {
      if (hash[position] == key) {
        found = true;
        break;
      }
      position += (step * step);
      step++;
      position = position % hash.length;
    }
    return found;
  }


}


