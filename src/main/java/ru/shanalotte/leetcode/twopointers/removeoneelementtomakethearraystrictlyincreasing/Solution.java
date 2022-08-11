package ru.shanalotte.leetcode.twopointers.removeoneelementtomakethearraystrictlyincreasing;

public class Solution {

  public boolean canBeIncreasing(int[] nums) {
    int p1 = 0;
    int p2 = nums.length - 1;
    while (p1 < nums.length - 1 && nums[p1 + 1] > nums[p1]) {
      p1++;
    }
    while (p2 > 0 && nums[p2 - 1] < nums[p2]) {
      p2--;
    }
    if (p2 == 0 && p1 == nums.length - 1) {
      return true;
    }
    return (p2 - p1 == 1 && couldBeDeleted(nums, p1, p2));
  }

  private boolean couldBeDeleted(int[] nums, int p1, int p2) {
    int a = nums[p1];
    int b = nums[p2];
    int l = p1 > 0 ? nums[p1 - 1]: Integer.MIN_VALUE;
    int r = p2 < nums.length - 1 ? nums[p2 + 1] : Integer.MAX_VALUE;
    return (l < a && a < r) || (l < b && b < r);
  }
}
