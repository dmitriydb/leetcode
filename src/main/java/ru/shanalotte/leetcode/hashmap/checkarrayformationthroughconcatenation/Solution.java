package ru.shanalotte.leetcode.hashmap.checkarrayformationthroughconcatenation;

public class Solution {

  public boolean canFormArray(int[] arr, int[][] pieces) {
    int[][] pieceMap = new int[101][1];
    for (int[] piece : pieces) {
      pieceMap[piece[0]] = piece;
    }
    for (int i = 0; i < arr.length; i++) {
      int num = arr[i];
      if (pieceMap[num] == null) {
        return false;
      }
      for (int j = 0; j < pieceMap[num].length; j++) {
        if (pieceMap[num][j] != arr[i]) {
          return false;
        }
        i++;
      }
      i--;
    }
    return true;
  }

}
