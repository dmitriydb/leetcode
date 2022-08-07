package ru.shanalotte.leetcode.arrays.relativeranks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
  public String[] findRelativeRanks(int[] score) {
    List<Integer> ranks = prepareInitialRelativeRanks(score);
    sortRelativeRanks(score, ranks);
    return relativeRanksToStrings(score, ranks);
  }

  private String[] relativeRanksToStrings(int[] score, List<Integer> ranks) {
    String[] result = new String[score.length];
    for (int i = 0; i < score.length; i++) {
      if (i == 0) {
        result[ranks.get(0)] = "Gold Medal";
      } else
      if (i == 1) {
        result[ranks.get(1)] = "Silver Medal";
      } else if (i == 2) {
        result[ranks.get(2)] = "Bronze Medal";
      } else {
        result[ranks.get(i)] = String.valueOf(i + 1);
      }
    }
    return result;
  }

  private void sortRelativeRanks(int[] score, List<Integer> ranks) {
    Comparator<Integer> comparator = (r1, r2) -> score[r2] - score[r1];
    ranks.sort(comparator);
  }

  private List<Integer> prepareInitialRelativeRanks(int[] score) {
    List<Integer> ranks = new ArrayList<>();
    for (int i = 0; i < score.length; i++) {
      ranks.add(i);
    }
    return ranks;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().findRelativeRanks(new int[]{1,2,3,4,5})));
  }
}
