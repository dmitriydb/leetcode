package ru.shanalotte.leetcode.math.powerofthree;

public class Solution {

  public static final double EPSILON = 0.0000000001;

  public boolean isPowerOfThree(int n) {
    double pow = Math.log(n) / Math.log(3);
    double floor = Math.floor(pow);
    double ceil = Math.ceil(pow);
    return Math.abs(pow - floor) <= EPSILON || Math.abs(pow - ceil) <= EPSILON;
  }

}
