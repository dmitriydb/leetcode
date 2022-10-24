package ru.shanalotte.leetcode.misc.longestnicestring.v1;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public String longestNiceSubstring(String s) {
    String result = "";
    for (int i = 0; i < s.length(); i++) {
      int j = i + 1;
      while (j < s.length()) {
        String subString = s.substring(i, j + 1);
        if (isNice(subString) && subString.length() > result.length()) {
          result = subString;
        }
        j++;
      }
    }
    return result;
  }

  private boolean isNice(String subString) {
    Set<Character> lowerCases = new HashSet<>();
    Set<Character> upperCases = new HashSet<>();
    for (char c : subString.toCharArray()) {
      if (isLowercase(c)) {
        lowerCases.add(c);
      } else {
        upperCases.add(c);
      }
    }
    for (char lowerCase : lowerCases) {
      if (!upperCases.contains(toUppercase(lowerCase))) {
        return false;
      }
    }
    for (char upperCase : upperCases) {
      if (!lowerCases.contains(toLowercase(upperCase))) {
        return false;
      }
    }
return true;
  }

  private char toUppercase(char lowerCase) {
    return (char) (lowerCase - 32);
  }

  private char toLowercase(char lowerCase) {
    return (char) (lowerCase + 32);
  }


  private void addCharacter(Set<Character> lowerCases, Set<Character> upperCases, char currentCharacter) {
    if (isLowercase(currentCharacter)) {
      lowerCases.add(currentCharacter);
    } else {
      upperCases.add(currentCharacter);
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
