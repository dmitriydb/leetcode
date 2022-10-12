package ru.shanalotte.leetcode.math.gcdofstrings;

public class Solution {

  public String gcdOfStrings(String str1, String str2) {
    while (!str2.equals("")) {
      System.out.println(str1 + ":" + str2);
      if (str1.equals(str2)) {
        return str1;
      }
      if (str1.length() < str2.length()) {
        String backup = str1;
        str1 = str2;
        str2 = backup;
      }
      if (!str1.startsWith(str2)) {
        return "";
      } else {
        String r = str1.substring(str2.length());
        str1 = str2;
        str2 = r;
      }
    }
  return "";
  }

  public static void main(String[] args) {
    System.out.println(new Solution().gcdOfStrings("abcabcabc", "abcabc"));
  }

}
