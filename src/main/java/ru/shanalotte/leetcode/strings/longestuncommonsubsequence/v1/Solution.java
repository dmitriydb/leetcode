package ru.shanalotte.leetcode.strings.longestuncommonsubsequence.v1;

public class Solution {

  public int findLUSlength(String a, String b) {
    int p1 = 0;
    int p2 = 0;
    while (p1 < a.length() || p2 < b.length()) {
      if (p1 >= a.length()) {
        return b.length();
      }
      if (p2 >= b.length()) {
        return a.length();
      }
      if (a.charAt(p1) != b.charAt(p2)) {
        return Math.max(a.length(), b.length());
      }
      p1++;
      p2++;
    }
    return -1;
  }

}
