package ru.shanalotte.leetcode;

import java.util.Arrays;

public class Solution {
  public int countQuadruplets(int[] nums) {
    Arrays.sort(nums);
    int quadrupletsCount = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          for (int l = k + 1; l < n; l++) {
            int a = nums[i];
            int b = nums[j];
            int c = nums[k];
            int d = nums[l];
            System.out.println(a + ":" + b + ":" + c + ":" + d);
            if (b > a && c > b && a + b + c == d) {
              quadrupletsCount++;
            }
          }
        }
      }
    }
    return quadrupletsCount;
  }

  public static void main(String[] args) {
    new Solution().countQuadruplets(new int[]{1,1,1,3,5});
  }

}
