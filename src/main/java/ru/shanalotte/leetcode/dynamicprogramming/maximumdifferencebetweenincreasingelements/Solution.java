package ru.shanalotte.leetcode.dynamicprogramming.maximumdifferencebetweenincreasingelements;

class Solution {

  public int maximumDifference(int[] nums) {
    int result = -1;
    int localMin = nums[0];
    for (int current : nums) {
      int localResult = current - localMin;
      if (localResult > result && localResult > 0) {
        result = localResult;
      }
      if (current < localMin) {
        localMin = current;
      }
    }
    return result;
  }

}