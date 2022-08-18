package ru.shanalotte.leetcode.strings.studentattendancerecord;

public class Solution {

  public boolean checkRecord(String s) {
    int consecutiveLates = 0;
    int totalAbsenses = 0;
    for (char c : s.toCharArray()) {
      if (c == 'A') {
        totalAbsenses++;
        if (totalAbsenses >= 2) {
          return false;
        }
      }
      if (c == 'L') {
        consecutiveLates++;
        if (consecutiveLates >= 3) {
          return false;
        }
      } else {
        consecutiveLates = 0;
      }
    }
    return true;
  }
}
