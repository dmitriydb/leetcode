package ru.shanalotte.leetcode.misc.removedigitfromnumbertomaximizeresult;

class Solution {

  public String removeDigit(String number, char digit) {
    StringBuilder result = new StringBuilder(number);
    int pos = -1;
    for (int i = 0; i < number.length(); i++) {
      if (number.charAt(i) == digit) {
        pos = i;
        if (i == number.length() - 1 || number.charAt(i + 1) > number.charAt(i)) {
          break;
        }
      }
    }
    result.deleteCharAt(pos);
    return result.toString();
  }
}