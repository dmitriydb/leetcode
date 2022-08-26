package ru.shanalotte.leetcode.prefixsum;

public class NumArray {

  private final int[] localSums;

  public NumArray(int[] nums) {
    localSums = new int[nums.length];
    int currentSum = 0;
    for (int i = 0; i < nums.length; i++) {
      currentSum += nums[i];
      localSums[i] = currentSum;
    }
  }

  public int sumRange(int left, int right) {
    return localSums[right] - (left - 1 >= 0 ? localSums[left - 1] : 0);
  }

}
