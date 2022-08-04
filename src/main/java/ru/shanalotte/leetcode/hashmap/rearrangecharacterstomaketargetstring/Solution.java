package ru.shanalotte.leetcode.hashmap.rearrangecharacterstomaketargetstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int rearrangeCharacters(String s, String target) {
    Map<Character, Integer> availableCharacters = new HashMap<>();
    for (char c : s.toCharArray()) {
      availableCharacters.merge(c, 1, Integer::sum);
    }
    Map<Character, Integer> requiredCharacters = new HashMap<>();
    for (char c : target.toCharArray()) {
      requiredCharacters.merge(c, 1, Integer::sum);
    }
    int max = Integer.MAX_VALUE;
    for (char requiredCharacter : requiredCharacters.keySet()) {
      int availableWords = availableCharacters.getOrDefault(requiredCharacter, 0) / requiredCharacters.get(requiredCharacter);
      if (availableWords < max) {
        max = availableWords;
      }
    }
    return max;
  }
}
