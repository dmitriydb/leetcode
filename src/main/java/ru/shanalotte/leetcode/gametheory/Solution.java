package ru.shanalotte.leetcode.gametheory;

public class Solution {

  public boolean canWinNim(int n) {
    if (n < 4) {
      return true;
    }
    return n % 4 != 0;

  }
}
