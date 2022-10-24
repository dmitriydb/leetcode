package ru.shanalotte.leetcode.misc.longestnicestring.v2;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public String longestNiceSubstring(String s) {
    Set<Character> processedCharacters = new HashSet<>();
    Set<Character> unprocessedCharacters = new HashSet<>();
    int max = 0;
    String result = "";
    int currentLength = s.length();
    while (currentLength >= 2) {
      unprocessedCharacters.clear();
      processedCharacters.clear();
      int p1 = 0;
      int p2 = currentLength - 1;
      for (int i = p1; i <= p2; i++) {
        char c = s.charAt(i);
        if (processedCharacters.contains(toLowercase(c))) {
          continue;
        } else {
          if (isLowercase(c) && unprocessedCharacters.contains(toUppercase(c))) {
            unprocessedCharacters.remove(toUppercase(c));
            processedCharacters.add(c);
          } else if (isUppercase(c) && unprocessedCharacters.contains(toLowercase(c))) {
            unprocessedCharacters.remove(toLowercase(c));
            processedCharacters.add(toLowercase(c));
          } else {
            unprocessedCharacters.add(c);
          }
        }

        if (unprocessedCharacters.isEmpty()) {
          int newLen = p2 - p1 + 1;
          if (newLen > max) {
            max = newLen;
            result = s.substring(p1, i+1);
          }
        }
      }
      currentLength--;
    }
    return result;
  }


  private char toUppercase(char lowerCase) {
    return (char) (lowerCase - 32);
  }

  private char toLowercase(char lowerCase) {
    if (isUppercase(lowerCase)) {
      return (char) (lowerCase + 32);
    } else {
      return lowerCase;
    }
  }

  private boolean isUppercase(char character) {
    return character >= 'A' && character <= 'Z';
  }

  private boolean isLowercase(char character) {
    return character >= 'a' && character <= 'z';
  }

  public static void main(String[] args) {
    System.out.println(new Solution().longestNiceSubstring("YazaAay"));
  }

}
