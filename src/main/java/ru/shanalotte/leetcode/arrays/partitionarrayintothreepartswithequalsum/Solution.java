package ru.shanalotte.leetcode.arrays.partitionarrayintothreepartswithequalsum;

import java.util.Arrays;

public class Solution {

  public boolean canThreePartsEqualSum(int[] arr) {
    long sum = Arrays.stream(arr).sum();
    int equalThirdsQty = 0;
    long partialSum = 0;
    if (sum % 3 != 0) {
      return false;
    }
    long oneThirdValue = sum / 3;
    for (int num : arr) {
      partialSum += num;
      if (partialSum == oneThirdValue) {
        equalThirdsQty++;
        if (equalThirdsQty >= 3) {
          break;
        }
        partialSum = 0;
      }
    }
    return equalThirdsQty >= 3;
  }

}
