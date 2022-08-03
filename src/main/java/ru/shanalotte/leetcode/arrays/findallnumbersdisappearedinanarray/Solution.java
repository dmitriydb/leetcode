package ru.shanalotte.leetcode.arrays.findallnumbersdisappearedinanarray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> result = new ArrayList<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      result.add(0);
    }
    for (int num : nums) {
      result.set(num - 1, 1);
    }
    int next = 0;
    for (int i = 0; i < nums.length; i++) {
      if (result.get(i) == 0) {
        result.set(next++, i + 1);
      }
    }
    return result.subList(0, next);
  }
}
