package ru.shanalotte.leetcode.slidingwindow.maximumaveragesubarray1;

public class Solution {
  public double findMaxAverage(int[] nums, int k) {
    int p1 = 0;
    int p2 = k - 1;
    double localAverage = calculateStartAverage(nums, p1, p2);
    double maxAverage = localAverage;
    p1++;
    p2++;
    while (p2 < nums.length) {
      localAverage -= nums[p1 - 1];
      localAverage += nums[p2];
      if (localAverage > maxAverage) {
        maxAverage = localAverage;
      }
      p1++;
      p2++;
    }
    return maxAverage / k;
  }

  private double calculateStartAverage(int[] nums, int p1, int p2) {
    double result = 0.0d;
    for (int i = p1; i <= p2; i++) {
      result += nums[i];
    }
    return result;
  }
}
