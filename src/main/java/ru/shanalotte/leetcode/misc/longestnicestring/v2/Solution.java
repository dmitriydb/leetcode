package ru.shanalotte.leetcode.misc.longestnicestring.v2;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    System.out.println(new Solution().longestNiceSubstring("YazaAay"));
  }

  public String longestNiceSubstring(String s) {
    String result = "";
    Set<Character> validCharacters = new HashSet<>();
    Set<Character> unprocessedCharacters = new HashSet<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (validCharacters.contains(toLowercase(c))) {
        continue;
      } else {
        if (isLowercase(c) && unprocessedCharacters.contains(toUppercase(c))) {
          unprocessedCharacters.remove(toUppercase(c));
          validCharacters.add(c);
        } else if (isUppercase(c) && unprocessedCharacters.contains(toLowercase(c))) {
          unprocessedCharacters.remove(toLowercase(c));
          validCharacters.add(toLowercase(c));
        } else {
          unprocessedCharacters.add(c);
        }
      }
    }
    unprocessedCharacters.clear();
    Set<Character> processedCharacters = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (validCharacters.contains(toLowercase(c))) {
        continue;
      } else {
        if (isLowercase(c) && unprocessedCharacters.contains(toUppercase(c))) {
          unprocessedCharacters.remove(toUppercase(c));
          validCharacters.add(c);
        } else if (isUppercase(c) && unprocessedCharacters.contains(toLowercase(c))) {
          unprocessedCharacters.remove(toLowercase(c));
          validCharacters.add(toLowercase(c));
        } else {
          unprocessedCharacters.add(c);
        }
      }
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

}
