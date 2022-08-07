package ru.shanalotte.leetcode.binarysearch.searchinsertposition;

public class Solution {
  public int searchInsert(int[] nums, int target) {
    return search(nums, target, 0, nums.length );
  }

  private int search(int[] nums, int target, int leftBound, int rightBound) {
    int middle = (leftBound + rightBound) / 2;
    int rightElement = middle + 1 < nums.length ? nums[middle + 1] : Integer.MAX_VALUE;
    int leftElement = middle - 1 >= 0 ? nums[middle - 1] : Integer.MIN_VALUE;
    if (target <= leftElement) {
      return search(nums, target, leftBound, middle - 1);
    } else if (target > rightElement) {
      return search(nums, target, middle, rightBound);
    }
    if (target <= nums[middle]) {
      return middle;
    } else {
      return middle + 1;
    }
  }

}
