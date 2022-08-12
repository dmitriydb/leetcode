package ru.shanalotte.leetcode.arrays.minmaxgame;

import java.sql.Timestamp;
import java.util.Date;

class Solution {
  public int minMaxGame(int[] nums) {
    int op = -1;
    int step = 1;
    while (step != nums.length) {
      for (int i = 0; i < nums.length - step; i += step * 2) {
        int n1 = nums[i];
        int n2 = nums[i + step];
        if (op == -1) {
          nums[i] = Math.min(n1, n2);
        } else {
          nums[i] = Math.max(n1, n2);
        }
        nums[i + step] = 0;
        op = -op;
      }
      step = step * 2;
    }
    return nums[0];
  }

  public static void main(String[] args) {
    Timestamp date = new Timestamp(1660289267000L);
    System.out.println(date.toString());
  }
}