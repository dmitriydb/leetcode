package ru.shanalotte.leetcode.hashmap.shortestcompletingword;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public String shortestCompletingWord(String licensePlate, String[] words) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : licensePlate.toCharArray()) {
      if ((c >= 'a' && c <= 'z')) {
        map.merge(c, 1, Integer::sum);
      }
      if ((c >= 'A' && c <= 'Z')) {
        c = (char) (c + 32);
        map.merge(c, 1, Integer::sum);
      }
    }
    int min = Integer.MAX_VALUE;
    String result = "";
    outer: for (String word : words) {
      Map<Character, Integer> map2 = new HashMap<>();
      for (char c : word.toCharArray()) {
        map2.merge(c, 1, Integer::sum);
      }
      for (char c : map.keySet()) {
        if (!map2.containsKey(c) || map2.get(c) < map.get(c)) {
          continue outer;
        }
      }
      if (word.length() < min) {
        min = word.length();
        result = word;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    char c = 'Z';
    c = (char) (c + 32);
    System.out.println(c);
  }

}
