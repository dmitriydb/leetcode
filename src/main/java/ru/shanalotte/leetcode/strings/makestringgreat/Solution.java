package ru.shanalotte.leetcode.strings.makestringgreat;

public class Solution {
  public String makeGood(String s) {
    StringBuilder result = new StringBuilder(s);
    int i = 0;
    while (i < result.length()) {
      if (i < result.length() - 1 && Math.abs(result.charAt(i) - result.charAt(i + 1)) == 32) {
        result.deleteCharAt(i);
        result.deleteCharAt(i);
        i--;
        if (i < 0) {
          i = 0;
        }
      } else {
        i++;
      }
    }
    return result.toString();
  }

}
