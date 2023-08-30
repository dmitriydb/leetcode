package ru.shanalotte.leetcode.prefixsum.product_except_self;


class Solution {

  public int[] productExceptSelf(int[] nums) {
    int[] product = new int[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      product[i] = (i == nums.length - 1 ? 1 : product[i + 1]) * nums[i];
    }
    int upward = 1;
    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        product[i] = product[1];
      } else if (i == nums.length - 1) {
        product[i] = upward;
      } else {
        product[i] = upward * product[i + 1];
      }
      upward = upward * nums[i];
    }
    return product;
  }

  public static void main(String[] args) {

  }

}