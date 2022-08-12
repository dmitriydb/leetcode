package ru.shanalotte.leetcode.arrays.findallkdistantindicesinanarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution {
  public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
    Set<Integer> set = new TreeSet<>();
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == key) {
        for (int j = Math.max(i - k, max); j < i + k + 1; j++) {
          if (j >= 0 && j < nums.length) {
            set.add(j);
          }
        }
        max = i - k;
      }
    }
   return new ArrayList<>(set);
  }
}
