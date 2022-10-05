package ru.shanalotte.leetcode.hashmap.intersectionoftwoarrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    Arrays.stream(nums1).forEach(num -> map.merge(num, 1, Integer::sum));
    List<Integer> result = new ArrayList<>();
    for (int num : nums2) {
      if (map.getOrDefault(num, 0) > 0) {
        map.merge(num, -1, Integer::sum);
        result.add(num);
      }
    }
    return result.stream().mapToInt(e -> e).toArray();
  }

}
