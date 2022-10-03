package ru.shanalotte.leetcode.arrays.teemoattacking;

public class Solution {
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    int result = 0;
    int threshold = 0;
    for (int time : timeSeries) {
      if (threshold < time) {
        result += duration;
        threshold = time + duration - 1;
      } else {
        int delta = duration - (threshold - time + 1);
        result += delta;
        threshold += delta;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().findPoisonedDuration(new int[]{1, 4}, 2));
  }
}
