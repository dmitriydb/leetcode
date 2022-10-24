package ru.shanalotte.leetcode.binarysearch.specialarraywithxelementsgreaterthanorequalx;

public class Solution {

  private int result = -1;
  
  public int specialArray(int[] nums) {
      check(nums, 0, nums.length);
      return result;
  }

  private void check(int[] nums, int startIndex, int endIndex) {
    if (startIndex > endIndex) {
      return;
    }
    int testValue = (startIndex + endIndex) / 2;
    int hits = 0;
    for (int num : nums) {
      if (num >= testValue) {
        hits++;
      }
    }
    if (hits == testValue) {
      result = testValue;
    } else if (hits > testValue) {
      check(nums, startIndex + 1, endIndex);
    } else {
      check(nums, startIndex, endIndex - 1);
    }
  }

}
