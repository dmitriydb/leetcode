package ru.shanalotte.leetcode.arrays.ranktransformofanarray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int[] arrayRankTransform(int[] arr) {
    int[] sortedBackedArray = createSortedBackupArray(arr);
    Map<Integer, Integer> ranks = calculateRanks(sortedBackedArray);
    transformArray(arr, ranks);
    return arr;
  }

  private void transformArray(int[] arr, Map<Integer, Integer> ranks) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = ranks.get(arr[i]);
    }
  }

  private Map<Integer, Integer> calculateRanks(int[] sortedBackedArray) {
    Map<Integer, Integer> ranks = new HashMap<>();
    int nextRank = 1;
    for (int i = 0; i < sortedBackedArray.length; i++) {
      if (i == 0) {
        ranks.put(sortedBackedArray[i], 1);
      } else {
        if (sortedBackedArray[i] != sortedBackedArray[i - 1]) {
          nextRank++;
          ranks.put(sortedBackedArray[i], nextRank);
        }
      }
    }
    return ranks;
  }

  private int[] createSortedBackupArray(int[] arr) {
    int[] sortedBackedArray = Arrays.copyOf(arr, arr.length);
    Arrays.sort(sortedBackedArray);
    return sortedBackedArray;
  }
}
