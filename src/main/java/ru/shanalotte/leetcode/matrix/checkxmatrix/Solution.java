package ru.shanalotte.leetcode.matrix.checkxmatrix;

public class Solution {
  public boolean checkXMatrix(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        boolean isOnDiagonal = onDiagonal(i, j, grid.length);
        if (isOnDiagonal && grid[i][j] == 0) {
          return false;
        }
        if (!isOnDiagonal && grid[i][j] != 0) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean onDiagonal(int i, int j, int length) {
    return i == j || i == length - j - 1;
  }
}
