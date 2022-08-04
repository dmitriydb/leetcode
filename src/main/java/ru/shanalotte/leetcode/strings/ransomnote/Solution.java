package ru.shanalotte.leetcode.strings.ransomnote;

public class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] magazineCharOccurences = new int['z' - 'a' + 1];
    for (char c : magazine.toCharArray()) {
      magazineCharOccurences[c - 'a']++;
    }
    for (char c : ransomNote.toCharArray()) {
      if (magazineCharOccurences[c - 'a'] <= 0) {
        return false;
      }
      magazineCharOccurences[c - 'a']--;
    }
    return true;
  }

}
