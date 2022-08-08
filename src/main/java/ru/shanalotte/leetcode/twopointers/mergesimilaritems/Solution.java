package ru.shanalotte.leetcode.twopointers.mergesimilaritems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
  public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
    Arrays.sort(items1, Comparator.comparingInt(a -> a[0]));
    Arrays.sort(items2, Comparator.comparingInt(a -> a[0]));
    List<List<Integer>> result = new ArrayList<>();
    int p1 = 0;
    int p2 = 0;
    while (p1 < items1.length || p2 < items2.length) {
      if (p1 >= items1.length) {
        addToList(result, items2[p2][0], items2[p2][1]);
        p2++;
        continue;
      }
      if (p2 >= items2.length) {
        addToList(result, items1[p1][0], items1[p1][1]);
        p1++;
        continue;
      }
      int item1Value = items1[p1][0];
      int item2Value = items2[p2][0];
      int item1Quantity = items1[p1][1];
      int item2Quantity = items2[p2][1];
      if (item1Value != item2Value) {
        if (item1Value < item2Value) {
          addToList(result, item1Value, item1Quantity);
          p1++;
        } else {
          addToList(result, item2Value, item2Quantity);
          p2++;
        }
      } else {
        addToList(result, item1Value, item1Quantity);
        addToList(result, item2Value, item2Quantity);
        p1++;
        p2++;
      }
    }
    return result;
  }

  private void addToList(List<List<Integer>> result, int v1, int a1) {
    if (listHasThatValueInTheEnd(result, v1)) {
      mergeQuantity(result, a1);
    } else {
      addNewEntry(result, v1, a1);
    }
  }

  private void addNewEntry(List<List<Integer>> result, int v1, int a1) {
    List<Integer> list = new ArrayList<>();
    list.add(v1);
    list.add(a1);
    result.add(list);
  }

  private Integer mergeQuantity(List<List<Integer>> result, int a1) {
    return result.get(result.size() - 1).set(1, result.get(result.size() - 1).get(1) + a1);
  }

  private boolean listHasThatValueInTheEnd(List<List<Integer>> result, int v1) {
    return !result.isEmpty() && result.get(result.size() - 1).get(0) == v1;
  }

}
