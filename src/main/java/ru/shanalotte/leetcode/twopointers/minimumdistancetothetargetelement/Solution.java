package ru.shanalotte.leetcode.twopointers.minimumdistancetothetargetelement;

public class Solution {
  public int getMinDistance(int[] nums, int target, int start) {
    int p1 = start;
    int p2 = start;
    while (p1 >= 0 && p2 < nums.length) {
      if (p1 >= 0 && nums[p1] == target) {
        return Math.abs(p1 - start);
      }
      if (p2 < nums.length && nums[p2] == target) {
        return Math.abs(p2 - start);
      }
      p1--;
      p2++;
    }
    return 0;
  }
}
