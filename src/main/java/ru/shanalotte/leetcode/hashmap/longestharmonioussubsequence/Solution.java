package ru.shanalotte.leetcode.hashmap.longestharmonioussubsequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int findLHS(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    for (int num : nums) {
      map.merge(num, 1, Integer::sum);
      int b = map.get(num);
      int a = map.getOrDefault(num - 1, -b);
      int c = map.getOrDefault(num + 1, -b);
      if (a + b > max) {
        max = a + b;
      }
      if (b + c > max) {
        max = b + c;
      }
    }
    return max;
  }

}
