package ru.shanalotte.leetcode.bitoperations.findarray;

import java.util.Arrays;

public class Solution {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().findArray(
        new int[]{5, 2, 0, 3, 1}
    )));

  }

  public int[] findArray(int[] pref) {
    int prev = pref[0];
    int current = 0;
    for (int i = 1; i < pref.length; i++) {
      current = pref[i];
      pref[i] = pref[i] ^ prev;
      prev = current;
    }
    return pref;
  }


}
