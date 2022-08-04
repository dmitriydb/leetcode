package ru.shanalotte.leetcode.strings.thousandseparator.v2;

public class Solution {
  public String thousandSeparator(int n) {
    String original = String.valueOf(n);
    StringBuilder result = new StringBuilder(original);
    int i = 1;
    while (original.length() - 3 * i > 0) {
      result.insert(original.length() - 3 * i, '.');
      i++;
    }
    return result.toString();
  }
}
