package ru.shanalotte.leetcode.arrays.valid_sudoku;


class Solution {
  public boolean isValidSudoku(char[][] board) {
    int[] rows = new int[100];
    int[] cols = new int[100];
    int[] sections = new int[100];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        char c = board[i][j];
        if (c == '.') {
          continue;
        }
        int digit = c - '0';
        if (rows[10 * i + digit] != 0) {
          return false;
        }
        if (cols[10 * j + digit] != 0) {
          return false;
        }
        if (sections[10 * section(i, j) + digit] != 0) {
          return false;
        }
        rows[10 * i + digit] = digit;
        cols[10 * j + digit] = digit;
        sections[10 * section(i, j) + digit] = digit;
      }
    }
    return true;

  }

  private int section(int i, int j) {
    int x = i / 3;
    int y = j / 3;
    return x * 3 + y;
  }
}