package ru.shanalotte.leetcode.dynamicprogramming.mincostclimbingstairs;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
      int d0 = cost[0];
      int d1 = cost[1];
      for (int i = 2; i <= cost.length; i++) {
        int c = i < cost.length ? cost[i] : 0;
        int backup = d1;
        d1 = c + Math.min(d0, d1);
        d0 = backup;
      }
      return Math.min(d0, d1);
    }

  public static void main(String[] args) {
    System.out.println(new Solution().minCostClimbingStairs(new int[]{10, 15, 20}));
  }


}
