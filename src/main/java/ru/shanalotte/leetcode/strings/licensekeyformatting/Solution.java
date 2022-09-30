package ru.shanalotte.leetcode.strings.licensekeyformatting;

public class Solution {
  public String licenseKeyFormatting(String s, int k) {
    s = s.toLowerCase();
    s = s.replace("-", "");
    var result = new StringBuilder(s);
    int pos = result.length() - k;
    while (pos > 0) {
      result.insert(pos, '-');
      pos -= k;
    }
    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(new Solution().licenseKeyFormatting("2-5g-3-J", 2));
  }
}
