package ru.shanalotte.leetcode.bitoperations.firstlettertoappeartwice;

class Solution {
  public char repeatedCharacter(String s) {
    long appearedCharactersBitFlag = 0;
    for (char nextChar : s.toCharArray()) {
      if (bitSetForCharacter(appearedCharactersBitFlag, nextChar)) {
        return nextChar;
      }
      appearedCharactersBitFlag = setBitForCharacter(appearedCharactersBitFlag, nextChar);
    }
    throw new IllegalStateException("That should not happen.");
  }

  private long setBitForCharacter(long appearedCharactersBitFlag, char nextChar) {
    appearedCharactersBitFlag = appearedCharactersBitFlag | 1L << nextChar - 'a';
    return appearedCharactersBitFlag;
  }

  private boolean bitSetForCharacter(long appearedCharactersBitFlag, char c) {
    return (appearedCharactersBitFlag | 1L << c - 'a') == appearedCharactersBitFlag;
  }
}
