package ru.shanalotte.leetcode.hashmap.verifyinganaliendictionary;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean isAlienSorted(String[] words, String order) {
    Map<Character, Integer> comparingOrder = prepareComparingOrder(order);
    return allWordsSorted(words, comparingOrder);
  }

  private boolean allWordsSorted(String[] words, Map<Character, Integer> comparingOrder) {
    for (int i = 0; i < words.length - 1; i++) {
      if (!twoWordsAreSorted(words[i], words[i + 1], comparingOrder)) {
        return false;
      }
    }
    return true;
  }

  private Map<Character, Integer> prepareComparingOrder(String order) {
    Map<Character, Integer> comparingOrder = new HashMap<>();
    for (int i = 0; i < order.length(); i++) {
      comparingOrder.put(order.charAt(i), i);
    }
    return comparingOrder;
  }

  private boolean twoWordsAreSorted(String word1, String word2, Map<Character, Integer> comparingOrder) {
    for (int i = 0; i < Math.max(word1.length(), word2.length()); i++) {
      int firstWordCharacterRank = calculateSymbolRank(word1, comparingOrder, i);
      int secondWordCharacterRank = calculateSymbolRank(word2, comparingOrder, i);
      if (firstWordCharacterRank < secondWordCharacterRank) {
        return true;
      }
      if (firstWordCharacterRank > secondWordCharacterRank) {
        return false;
      }
    }
    return true;
  }

  private int calculateSymbolRank(String word1, Map<Character, Integer> comparingOrder, int i) {
    char c1 = i < word1.length() ? word1.charAt(i) : '\0';
    return c1 == '\0' ? -1 : comparingOrder.get(c1);
  }
}