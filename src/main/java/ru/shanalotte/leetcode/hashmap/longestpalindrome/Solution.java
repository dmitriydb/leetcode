package ru.shanalotte.leetcode.hashmap.longestpalindrome;

import java.util.HashMap;
import java.util.Map;

public class Solution {
 
  public int longestPalindrome(String s) {
    Map<Character, Integer> map = prepareMapFromString(s);
    int minimalPossibleLength = calculateMinimalPossibleLength(map);
    int maxLength = minimalPossibleLength;
    for (char c : map.keySet()) {
      int possibleLengthWithSymbolInMiddle = minimalPossibleLength - (map.get(c) - (map.get(c) % 2));
      if (possibleLengthWithSymbolInMiddle + map.get(c) > maxLength) {
        maxLength = possibleLengthWithSymbolInMiddle + map.get(c);
      }
    }
    return maxLength;
  }

  private int calculateMinimalPossibleLength(Map<Character, Integer> map) {
    int minimalPossibleLength = 0;
    for (char c : map.keySet()) {
      minimalPossibleLength += (map.get(c) - (map.get(c) % 2));
    }
    return minimalPossibleLength;
  }

  private Map<Character, Integer> prepareMapFromString(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.merge(c, 1, Integer::sum);
    }
    return map;
  }

}
