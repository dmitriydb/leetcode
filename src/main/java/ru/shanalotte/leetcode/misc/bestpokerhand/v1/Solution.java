package ru.shanalotte.leetcode.misc.bestpokerhand.v1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public String bestHand(int[] ranks, char[] suits) {
    if (isFlush(suits)) {
      return "Flush";
    }
    return checkRanks(ranks);
  }

  private String checkRanks(int[] ranks) {
    Map<Integer, Integer> ranksMap = new HashMap<>();
    for (int rank : ranks) {
      ranksMap.merge(rank, 1, Integer::sum);
    }
    if (ranksMap.containsValue(3) || ranksMap.containsValue(4)) {
      return "Three of a Kind";
    }
    if (ranksMap.containsValue(2)) {
      return "Pair";
    }
    return "High card";
  }

  private boolean isFlush(char[] suits) {
    int first = suits[0];
    for (int i = 1; i < suits.length; i++) {
      if (first != suits[i]) {
        return false;
      }
    }
    return true;
  }

}
