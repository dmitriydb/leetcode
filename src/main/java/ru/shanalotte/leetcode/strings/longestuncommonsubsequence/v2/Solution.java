package ru.shanalotte.leetcode.strings.longestuncommonsubsequence.v2;

public class Solution {

  public int findLUSlength(String a, String b) {
    if (!a.equals(b)) {
      return Math.max(a.length(), b.length());
    } else {
      return -1;
    }
  }
}
