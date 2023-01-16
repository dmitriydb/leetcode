package ru.shanalotte.leetcode.combinatorics.permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] numberUsed = new boolean[nums.length];
    createPermutation(nums, result, new ArrayList<>(), numberUsed, 0);
    return result;
  }

  private void createPermutation(int[] nums, List<List<Integer>> result, List<Integer> currentPermutation, boolean[] numberUsed, int currentPermutationLength) {
    if (currentPermutationLength == nums.length) {
      result.add(new ArrayList<>(currentPermutation));
      return;
    }
    for (int j = 0; j < nums.length; j++) {
      if (!numberUsed[j]) {
        numberUsed[j] = true;
        currentPermutation.add(nums[j]);
        createPermutation(nums, result, currentPermutation, numberUsed, currentPermutationLength + 1);
        currentPermutation.remove(currentPermutation.size() - 1);
        numberUsed[j] = false;
      }
    }
  }

}
