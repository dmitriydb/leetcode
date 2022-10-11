package ru.shanalotte.leetcode.math.minimumamountoftimetofillcups;

public class Solution {

  public int fillCups(int[] amount) {
    sortArray(amount);
    int needed = Math.min(amount[2], amount[1] + amount[0]);
    int delta = amount[1] - amount[0];
    needed -= delta;
    int a = needed % 2 == 0 ? needed / 2 : needed / 2 + 1;
    int b = needed / 2;
    if (amount[2] - needed - delta != 0) {
      return amount[2];
    } else {
      int x = Math.min(amount[1] - delta - a, amount[0]);
      return amount[1] - a + amount[0] - b - x + needed;
    }
  }

  private void sortArray(int[] amount) {
    if (amount[0] > amount[1]) {
      swap(amount, 0, 1);
    }
    if (amount[1] > amount[2]) {
      swap(amount, 1, 2);
    }
    if (amount[0] > amount[1]) {
      swap(amount, 0, 1);
    }
  }

  private void swap(int[] amount, int a, int b) {
    int backup = amount[a];
    amount[a] = amount[b];
    amount[b] = backup;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().fillCups(new int[]{5,4,4}));
  }
}
