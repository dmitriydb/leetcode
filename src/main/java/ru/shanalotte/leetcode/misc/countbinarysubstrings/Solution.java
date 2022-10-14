package ru.shanalotte.leetcode.misc.countbinarysubstrings;

class Solution {
  public int countBinarySubstrings(String s) {
    int zero = 0;
    int ones = 0;
    if (s.charAt(0) == '0') {
      zero++;
    } else {
      ones++;
    }
    int count = 0;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == '1') {
        if (s.charAt(i - 1) != '1') {
          ones = 0;
        }
        ones++;
        if (ones <= zero) {
          count++;
        }
      } else
      if (s.charAt(i) == '0') {
        if (s.charAt(i - 1) != '0') {
          zero = 0;
        }
        zero++;
        if (zero <= ones) {
          count++;
        }
      }
    }
    return count;
  }

}