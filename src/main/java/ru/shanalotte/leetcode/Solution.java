package ru.shanalotte.leetcode;


public class Solution {

  public int maximum69Number (int num) {
    int backup = num;
    int pos = -1;
    int i = 0;
    while (num != 0) {
      int digit = num % 10;
      if (digit == 6) {
        pos = i;
      }
      i++;
      num = num / 10;
    }
    if (pos != -1) {
      backup += 3 * Math.pow(10, pos);
    }
    return backup;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().maximum69Number(9669));
  }

}