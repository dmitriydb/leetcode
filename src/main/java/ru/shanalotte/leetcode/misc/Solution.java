package ru.shanalotte.leetcode.misc;

public class Solution {
  public int[] getNoZeroIntegers(int n) {
    int a = 1;
    int b = n - 1;
    while (containsZero(a) || containsZero(b)) {
      a++;
      b--;
    }
    return new int[]{a, b};
  }

  private boolean containsZero(int a) {
    if (a == 0) {
      return true;
    }
    while (a > 10) {
      if (a % 10 == 0) {
        return true;
      }
      a = a / 10;
    }
    return false;
  }



}
