package ru.shanalotte.leetcode.arrays.countspecialquadruplets.v1;

class Solution {
  public int countQuadruplets(int[] nums) {
    int quadrupletsCount = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          for (int l = 0; l < n; l++) {
            if (i < j && j < k && k < l && nums[l] == nums[i] + nums[j] + nums[k]) {
              quadrupletsCount++;
            }
          }
        }
      }
    }
    return quadrupletsCount;
  }
}