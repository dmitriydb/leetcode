package ru.shanalotte.leetcode.hashmap.pathcrossing;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public boolean isPathCrossing(String path) {
    Set<Long> visitedCellsHashCodes = new HashSet<>();
    visitedCellsHashCodes.add(0L);
    long x = 0;
    long y = 0;
    for (char c : path.toCharArray()) {
      if (c == 'N') {
        x--;
      }
      if (c == 'E') {
        y++;
      }
      if (c == 'W') {
        y--;
      }
      if (c == 'S') {
        x++;
      }
      long cellHashCode = calculateCellHashCode(x, y);
      if (visitedCellsHashCodes.contains(cellHashCode)) {
        return false;
      }
      visitedCellsHashCodes.add(cellHashCode);
    }
    return true;
  }

  private long calculateCellHashCode(long x, long y) {
    return 1_000_00 * x + y;
  }
}
