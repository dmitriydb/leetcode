package ru.shanalotte.leetcode.strings.greatestenglishletterinupperandlowercase.v2;

// O (n)
public class Solution {

  public static void main(String[] args) {
    System.out.println(new Solution().greatestLetter("lEeTcOdE"));
  }

  public String greatestLetter(String s) {
    int[] charOccurencesBitFlags = new int['z' - 'a' + 1];
    for (char c : s.toCharArray()) {
      int index = isLowerCase(c) ? c - 'a' : toLowerCase(c) - 'a';
      charOccurencesBitFlags[index] |= isLowerCase(c) ? 1 : 2;
    }
    for (char c = 'z'; c >= 'a'; c--) {
      if (charOccurencesBitFlags[c - 'a'] == 3) {
        return String.valueOf(toUpperCase(c));
      }
    }
    return "";
  }

  private char toUpperCase(char c) {
    return (char) (c - 32);
  }

  private char toLowerCase(char c) {
    return (char) (c + 32);
  }

  private boolean isLowerCase(char c) {
    return c >= 'a' && c <= 'z';
  }

  private boolean isUpperCase(char c) {
    return c >= 'A' && c <= 'Z';
  }


}
