package ru.shanalotte.leetcode.slidingwindow.minimumdifferencebetweenhighestandlowestofkscores;

import java.util.Arrays;

public class Solution {

  public int minimumDifference(int[] nums, int k) {
    Arrays.sort(nums);
    int p1 = 0;
    int p2 = p1 + k - 1;
    int result = nums[p2] - nums[p1];
    while (p2 + 1 < nums.length) {
      p1 += 1;
      p2 += 1;
      int localResult = nums[p2] - nums[p1];
      if (localResult < result) {
        result = localResult;
      }
    }
    return result;
  }

}
