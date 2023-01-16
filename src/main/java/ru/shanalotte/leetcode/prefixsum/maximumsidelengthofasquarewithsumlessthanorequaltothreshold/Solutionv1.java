package ru.shanalotte.leetcode.prefixsum.maximumsidelengthofasquarewithsumlessthanorequaltothreshold;

class Solutionv1 {

  public int maxSideLength(int[][] mat, int threshold) {
    int n = mat.length;
    int m = mat[0].length;
    int maxSideLength = 0;
    int maxPossibleSideLength = Math.min(n,m );
    int[][] prefixHorizontal = new int[n][m];
    int[][] prefixVertical = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (j == 0) {
          prefixHorizontal[i][j] = mat[i][j];
        } else {
          prefixHorizontal[i][j] = mat[i][j] + prefixHorizontal[i][j - 1];
        }
        if (i == 0) {
          prefixVertical[i][j] = mat[i][j];
        } else {
          prefixVertical[i][j] = mat[i][j] + prefixVertical[i - 1][j];
        }
      }
    }
    for (int x = 0; x < n; x++) {
      for (int y = 0; y < m; y++) {
        if (n - x < maxSideLength && m - y < maxSideLength) {
          break;
        }
        if (maxSideLength == maxPossibleSideLength) {
          break;
        }
        int maxPossible = Math.max(m - y + 1, n - x + 1);
        if (maxPossible < maxSideLength) {
          continue;
        }
        int x2 = x;
        int y2 = y;
        int sum = mat[x][y];
        if (sum <= threshold) {
          int localSide = 1;
          while (true) {
            x2++;
            y2++;
            if (x2 >= n || y2 >= m) {
              break;
            }
            int newVerticalSum = prefixVertical[x2 - 1][y2] - (x == 0 ? 0: prefixVertical[x - 1][y2]);
            int newHorizontalSum = prefixHorizontal[x2][y2 - 1] - (y == 0? 0 : prefixHorizontal[x2][y - 1]);
            sum = sum + newVerticalSum + newHorizontalSum + mat[x2][y2];
            if (sum <= threshold) {
              localSide++;
            } else {
              break;
            }
          }
          if (localSide > maxSideLength) {
            maxSideLength = localSide;
          }
        }
      }
    }
  return maxSideLength;
  }

}