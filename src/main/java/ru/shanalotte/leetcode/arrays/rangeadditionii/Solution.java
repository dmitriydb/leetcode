package ru.shanalotte.leetcode.arrays.rangeadditionii;

public class Solution {

  public int maxCount(int m, int n, int[][] ops) {
    int a = Integer.MAX_VALUE;
    int b = Integer.MAX_VALUE;
    for (int[] s : ops) {
      int x = s[0];
      int y = s[1];
      if (x < a) {
        x = a;
      }
      if (y < b) {
        b = y;
      }
    }
    return a * b;
  }

}
