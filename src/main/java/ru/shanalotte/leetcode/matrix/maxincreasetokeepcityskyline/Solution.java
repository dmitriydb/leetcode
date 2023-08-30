package ru.shanalotte.leetcode.matrix.maxincreasetokeepcityskyline;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int r = grid.length;
    int c = grid[0].length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (map.getOrDefault(i, 0) < grid[i][j]) {
          map.put(i, grid[i][j]);
        }
        if (map.getOrDefault(1000 + j, 0) < grid[i][j]) {
          map.put(1000 + j, grid[i][j]);
        }
      }
    }
    int answer = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        int verticalDelta = map.getOrDefault(i, 0) - grid[i][j];
        int horizontalDelta = map.getOrDefault(1000 + j, 0) - grid[i][j];
        answer += Math.min(verticalDelta, horizontalDelta);
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().maxIncreaseKeepingSkyline(new int[][]{ {3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
  }

}