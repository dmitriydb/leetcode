package ru.shanalotte.leetcode.gametheory.divisorgame;

public class Solution {

  public boolean divisorGame(int n) {
    if (n % 2 == 0) {
      return true;
    }
    if (n % 3 == 0) {
      return false;
    }
    if (n % 5 == 0) {
      return false;
    }
    return false;
  }

}
