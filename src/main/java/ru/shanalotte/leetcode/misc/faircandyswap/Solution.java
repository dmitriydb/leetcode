package ru.shanalotte.leetcode.misc.faircandyswap;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
    int s1 = 0;
    int s2 = 0;
    Set<Integer> map1 = new HashSet<>();
    Set<Integer> map2 = new HashSet<>();
    s1 = createMap(aliceSizes, s1, map1);
    s2 = createMap(bobSizes, s2, map2);
    int[] result = new int[2];
    for (int key : map1) {
      if (s1 - key > s2 + key) {
        continue;
      }
      int diff = Math.abs(s1 - key - (s2 + key)) / 2;
      if (map2.contains(diff)) {
        result[0] = key;
        result[1] = diff;
        break;
      }
    }
    return result;
  }

  private int createMap(int[] aliceSizes, int s1, Set<Integer> map1) {
    for (int num : aliceSizes) {
      map1.add(num);
      s1 += num;
    }
    return s1;
  }

}
