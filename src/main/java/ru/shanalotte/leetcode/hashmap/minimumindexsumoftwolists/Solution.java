package ru.shanalotte.leetcode.hashmap.minimumindexsumoftwolists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < list1.length; i++) {
      map.put(list1[i], -i);
    }
    int minSum = Integer.MAX_VALUE;
    for (int i = 0; i < list2.length; i++) {
      if (map.containsKey(list2[i])) {
        int sum = -map.get(list2[i]) + i;
        map.put(list2[i], sum);
        if (sum < minSum) {
          minSum = sum;
        }
      }
    }
    List<String> result = new ArrayList<>();
    for (String key : map.keySet()) {
      if (map.get(key) == minSum) {
        result.add(key);
      }
    }
    return result.toArray(new String[0]);
  }

}
