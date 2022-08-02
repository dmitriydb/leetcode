package ru.shanalotte.leetcode.strings.strongpasswordchecker2;

class Solution {
  public boolean strongPasswordCheckerII(String password) {
    if (password.length() < 8) {
      return false;
    }
    boolean containsLowercase = false;
    boolean containsUppercase = false;
    boolean containsDigit = false;
    boolean containsSpecialCharacter = false;
    for (int i = 0; i < password.length(); i++) {
      char nextPasswordCharacter = password.charAt(i);
      containsLowercase = isLowercase(nextPasswordCharacter) || containsLowercase;
      containsUppercase = isUppercase(nextPasswordCharacter) || containsUppercase;
      containsDigit = isDigit(nextPasswordCharacter) || containsDigit;
      containsSpecialCharacter = isSpecialCharacter(nextPasswordCharacter) || containsSpecialCharacter;
      if (i > 0 && nextPasswordCharacter == password.charAt(i - 1)) {
        return false;
      }
    }
    return containsDigit && containsLowercase && containsUppercase && containsSpecialCharacter;
  }

  private boolean isLowercase(char c) {
    return c >= 'a' && c <= 'z';
  }

  private boolean isUppercase(char c) {
    return c >= 'A' && c <= 'Z';
  }

  private boolean isSpecialCharacter(char c) {
    return "!@#$%^&*()-+".indexOf(c) != -1;
  }

  private boolean isDigit(char c) {
    return c >= '0' && c <= '9';
  }
}