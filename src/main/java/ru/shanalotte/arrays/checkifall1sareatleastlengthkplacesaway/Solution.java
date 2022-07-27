package ru.shanalotte.arrays.checkifall1sareatleastlengthkplacesaway;

class Solution {
  public boolean kLengthApart(int[] nums, int k) {
    int lastPositionOfOne = -1;
    boolean oneIsFound = false;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        if (!oneIsFound) {
          oneIsFound = true;
        } else {
          if (distanceBetweenIndexesLessThenThresholdDistance(lastPositionOfOne, i, k)) return false;
        }
        lastPositionOfOne = i;
      }
    }
    return true;
  }

  private boolean distanceBetweenIndexesLessThenThresholdDistance(int firstOnePosition, int secondOnePosition, int threshold) {
    int distanceBetweenOnes = secondOnePosition - firstOnePosition - 1;
    return distanceBetweenOnes < threshold;
  }
}