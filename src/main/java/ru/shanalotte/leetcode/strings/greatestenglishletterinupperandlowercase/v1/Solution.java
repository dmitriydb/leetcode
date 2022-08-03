package ru.shanalotte.leetcode.strings.greatestenglishletterinupperandlowercase.v1;

import java.util.HashSet;
import java.util.Set;

// O (n logn)
public class Solution {
  public String greatestLetter(String s) {
    Set<Character> processedCharacters = new HashSet<>();
    char foundChar = '\0';
    for (char nextChar : s.toCharArray()) {
      processedCharacters.add(nextChar);
      if (isLowerCase(nextChar) && processedCharacters.contains(toUpperCase(nextChar))) {
        if (toUpperCase(nextChar) > foundChar) {
          foundChar = toUpperCase(nextChar);
        }
      }
      if (isUpperCase(nextChar) && processedCharacters.contains(toLowerCase(nextChar))) {
        if (nextChar > foundChar) {
          foundChar = nextChar;
        }
      }
    }
    return foundChar == '\0' ? "" : String.valueOf(foundChar);
  }

  private boolean isLowerCase(char c) {
    return c >= 'a' && c <= 'z';
  }

  private boolean isUpperCase(char c) {
    return c >= 'A' && c <= 'Z';
  }

  private char toUpperCase(char c) {
    return (char)(c - 32);
  }

  private char toLowerCase(char c) {
    return (char)(c + 32);
  }

}
