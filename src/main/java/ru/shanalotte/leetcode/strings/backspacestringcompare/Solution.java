package ru.shanalotte.leetcode.strings.backspacestringcompare;

public class Solution {

  public boolean backspaceCompare(String s, String t) {
    StringBuilder a = processString(s);
    StringBuilder b = processString(t);
    return a.toString().equals(b.toString());
  }

  private StringBuilder processString(String s) {
    StringBuilder a = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == '#' && a.length() != 0) {
        a.deleteCharAt(a.length() - 1);
      }
      if (c != '#') {
        a.append(c);
      }
    }
    return a;
  }

}
