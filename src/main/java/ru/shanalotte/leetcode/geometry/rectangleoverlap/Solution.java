package ru.shanalotte.leetcode.geometry.rectangleoverlap;


public class Solution {

  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    int x1 = rec1[0], y1 = rec1[1];
    int x2 = rec1[2], y2 = rec1[3];
    int a1 = rec2[0], b1 = rec2[1];
    int a2 = rec2[2], b2 = rec2[3];
    return overlaps(x1, x2, a1, a2) && overlaps(y1, y2, b1, b2);
  }

  private boolean overlaps(int a1, int a2, int a3, int a4) {
    return !(a3 >= a2 || a1 >= a4);
  }

}
