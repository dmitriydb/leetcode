package ru.shanalotte.leetcode.misc.bestpokerhand.v2;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public String bestHand(int[] ranks, char[] suits) {
    if (isFlush(suits)) {
      return "Flush";
    }
    int[] ranksArray = new int[14];
    int max = 0;
    for (int rank : ranks) {
      ranksArray[rank]++;
      if (ranksArray[rank] > max) {
        max = ranksArray[rank];
      }
    }
    if (max >= 3) {
      return "Three of a Kind";
    }
    if (max >= 2) {
      return "Pair";
    }
    return "High Card";
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
