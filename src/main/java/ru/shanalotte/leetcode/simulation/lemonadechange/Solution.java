package ru.shanalotte.leetcode.simulation.lemonadechange;

public class Solution {

  public boolean lemonadeChange(int[] bills) {
    int fives = 0;
    int tens = 0;
    for (int bill : bills) {
      if (bill == 5) {
        fives++;
      } else if (bill == 10) {
        tens++;
        if (fives == 0) {
          return false;
        } else {
          fives--;
        }
      } else if (bill == 20) {
        if (tens > 0 && fives > 0) {
          fives--;
          tens--;
        } else if (fives >= 3) {
          fives -= 3;
        } else {
          return false;
        }
      }
    }
    return true;
  }

}
