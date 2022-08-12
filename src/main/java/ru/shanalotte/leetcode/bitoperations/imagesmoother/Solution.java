package ru.shanalotte.leetcode.bitoperations.imagesmoother;

public class Solution {
    private static int[][] DIRS = new int[][]{{-1, 0}, {+1, 0}, {0, -1}, {0, +1}, {-1, -1}, {-1, +1}, {+1, -1}, {+1, +1}};

    public int[][] imageSmoother(int[][] img) {
      int n = img.length;
      int m = img[0].length;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          int sum = img[i][j] & 0xFF;
          int qty = 1;
          for (int[] dir : DIRS) {
            if (inMatrix(i, j, dir, n, m)) {
              sum += (img[i + dir[0]][j + dir[1]] & 0xFF);
              qty++;
            }
          }
          img[i][j] |= (sum / qty << 8);
        }
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          img[i][j] >>>= 8;
        }
      }
      return img;
    }

  private boolean inMatrix(int i, int j, int[] dir, int n, int m) {
      return (i + dir[0] >= 0 && j + dir[1] >= 0 && i + dir[0] < n && j + dir[1] < m);
  }
}
