package ru.shanalotte.leetcode.sort.sortthestudentsbytheirkthscore;

import java.util.Arrays;

public class Solution {
  public int[][] sortTheStudents(int[][] score, int k) {
    Arrays.sort(score, (row1, row2) -> row2[k] - row1[k]);
    return score;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(new Solution()
        .sortTheStudents(new int[][]{{10,6,9,1},{7,5,11,2},{4,8,3,15}}, 2)));
  }
}
