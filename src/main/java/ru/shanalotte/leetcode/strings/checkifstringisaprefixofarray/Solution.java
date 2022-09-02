package ru.shanalotte.leetcode.strings.checkifstringisaprefixofarray;

public class Solution {

  public boolean isPrefixString(String s, String[] words) {
    StringBuilder result = new StringBuilder();
    for (String word : words) {
      result.append(word);
      if (result.toString().equals(s)) {
        return true;
      }
    }
    return false;
  }

}
