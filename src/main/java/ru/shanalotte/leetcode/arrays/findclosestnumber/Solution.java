package ru.shanalotte.leetcode.arrays.findclosestnumber;

public class Solution {
  public int findClosestNumber(int[] nums) {
    int result = Integer.MIN_VALUE;
    for (int num : nums) {
      if (module(num) == module(result)) {
        if (result > num) {
          result = num;
        }
      } else if (module(num) < module(result)) {
        result = num;
      }
    }
    return result;
  }

  private int module (int x) {
    if (x < 0) {
      return -x;
    }
    return x;
  }
}
