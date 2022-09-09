package ru.shanalotte.leetcode.arrays.checkifarrayissortedandrotated;

public class Solution {

  public boolean check(int[] nums) {
    int discrepancies = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        discrepancies++;
      }
    }
    if (nums[nums.length - 1] > nums[0]) {
      discrepancies++;
    }
    return  (discrepancies == 1) ;
  }

}
