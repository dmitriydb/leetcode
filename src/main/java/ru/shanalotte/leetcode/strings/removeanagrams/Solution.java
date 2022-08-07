package ru.shanalotte.leetcode.strings.removeanagrams;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<String> removeAnagrams(String[] words) {
   List<String> result = new ArrayList<>();
   result.add(words[0]);
    for (int i = 1; i < words.length; i++) {
      if (!anagrams(words[i], words[i - 1])) {
        result.add(words[i]);
      }
    }
    return result;
  }

  private boolean anagrams(String word, String word1) {
    int[] arr = new int[26];
    for (char c : word.toCharArray()) {
      arr[c - 'a']++;
    }
    for (char c : word1.toCharArray()) {
      arr[c - 'a']++;
    }
    for (int x : arr) {
      if (x != 0) {
        return false;
      }
    }
    return true;
  }

}
