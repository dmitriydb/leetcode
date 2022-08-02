package ru.shanalotte.leetcode.hashmap.decodethemessage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  public String decodeMessage(String key, String message) {
    Map<Character, Character> decodingTable = prepareDecodingTable(key);
    return decodeMessage(message, decodingTable);
  }

  private String decodeMessage(String message, Map<Character, Character> decodingTable) {
    StringBuilder decodedMessage = new StringBuilder(message);
    for (int i = 0; i < message.length(); i++) {
      if (message.charAt(i) == ' ') {
        continue;
      }
      decodedMessage.setCharAt(i, decodingTable.get(message.charAt(i)));
    }
    return decodedMessage.toString();
  }

  private Map<Character, Character> prepareDecodingTable(String key) {
    Set<Character> alreadySubstitutedCharacters = new HashSet<>();
    Map<Character, Character> decodingTable = new HashMap<>();
    char nextSubstitute = 'a';
    for (char nextKeyCharacter : key.toCharArray()) {
      if (nextKeyCharacter == ' ' || alreadySubstitutedCharacters.contains(nextKeyCharacter)) {
        continue;
      }
      alreadySubstitutedCharacters.add(nextKeyCharacter);
      decodingTable.put(nextKeyCharacter, nextSubstitute++);
    }
    return decodingTable;
  }
}
