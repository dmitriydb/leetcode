package ru.shanalotte.leetcode.arrays.counthillsandvalleys;

public class Solution {

  public int countHillValley(int[] nums) {
    int count = 0;
    outer:
    for (int i = 1; i < nums.length - 1; i++) {
      int rightIndex = i + 1;
      while (nums[rightIndex] == nums[i]) {
        rightIndex++;
        if (rightIndex >= nums.length) {
          break outer;
        }
      }
      if (nums[i] < nums[i - 1] && nums[i] < nums[rightIndex]) {
        count++;
      }
      if (nums[i] > nums[i - 1] && nums[i] > nums[rightIndex]) {
        count++;
      }
      i = rightIndex - 1;
    }
    return count;
  }
}
