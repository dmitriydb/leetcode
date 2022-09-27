package ru.shanalotte.leetcode.arrays.occurencesafterbigram;

import java.util.ArrayList;

public class Solution {
  public String[] findOcurrences(String text, String first, String second) {
    var words = text.split(" ");
    var thirds = new ArrayList<>();
    for (int i = 2; i < words.length; i++) {
      if (words[i - 2].equals(first) && words[i - 1].equals(second)) {
        thirds.add(words[i]);
      }
    }
    return thirds.toArray(new String[0]);
  }
}
