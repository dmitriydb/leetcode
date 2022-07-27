package ru.shanalotte.leetcode.arrays.detectpatternoflengthmrepeatedkormoretimes.v1;

class Solution {
  public boolean containsPattern(int[] arr, int m, int k) {
    for (int i = 0; i <= arr.length - m * k; i++) {
      if (checkIfPatternExists(arr, i, m, k)) {
        return true;
      }
    }
    return false;
  }

  private boolean checkIfPatternExists(int[] arr, int startIndex, int patternLength, int patternRepeats) {
    for (int i = startIndex + patternLength; i < startIndex + patternLength * patternRepeats; i++) {
      if (arr[i] != arr[i - patternLength]) {
        return false;
      }
    }
    return true;
  }

}