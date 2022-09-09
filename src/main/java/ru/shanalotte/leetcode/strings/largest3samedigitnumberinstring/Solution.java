package ru.shanalotte.leetcode.strings.largest3samedigitnumberinstring;

public class Solution {

  public String largestGoodInteger(String num) {
    int max = -1;
    for (int i = 1; i < num.length() - 1; i++) {
      if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i + 1)) {
        if (num.charAt(i) - '0' > max) {
          max = num.charAt(i) - '0';
        }
      }
    }
    return max == -1 ? "" : String.valueOf(max).repeat(3);
  }
}
