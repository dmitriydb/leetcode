package ru.shanalotte.leetcode.arrays.maximumnumberofpairsinarray;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int[] numberOfPairs(int[] nums) {
    int[] pairs = new int[100];
    for (int num : nums) {
      pairs[num]++;
    }
    int[] result = new int[2];
    for (int num : pairs) {
      result[0] += num / 2;
      result[1] += num % 2;
    }
    return result;
  }

}
