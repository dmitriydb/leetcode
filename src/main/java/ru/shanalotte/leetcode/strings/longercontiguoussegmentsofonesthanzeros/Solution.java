package ru.shanalotte.leetcode.strings.longercontiguoussegmentsofonesthanzeros;

public class Solution {
  public boolean checkZeroOnes(String s) {
    int maxZeros = 0;
    int maxOnes = 0;
    int currentZeros = 0;
    int currentOnes = 0;
    for (char c : s.toCharArray()) {
      if (c == '0') {
        currentZeros++;
        if (currentOnes > maxOnes) {
          maxOnes = currentOnes;
        }
        currentOnes = 0;
      } else {
        currentOnes++;
        if (currentZeros > maxZeros) {
          maxZeros = currentZeros;
        }
        currentZeros = 0;
      }
    }
    if (currentZeros > maxZeros) {
      maxZeros = currentZeros;
    }
    if (currentOnes > maxOnes) {
      maxOnes = currentOnes;
    }
    return maxOnes > maxZeros;
  }
}
