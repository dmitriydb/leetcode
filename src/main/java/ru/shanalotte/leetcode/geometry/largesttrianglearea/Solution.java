package ru.shanalotte.leetcode.geometry.largesttrianglearea;

public class Solution {
  public double largestTriangleArea(int[][] points) {
    double maxTriangleArea = 0;
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        for (int k = j + 1; k < points.length; k++) {
            double triangleArea = area(points, i, j, k);
            if (triangleArea > maxTriangleArea) {
              maxTriangleArea = triangleArea;
            }
        }
      }
    }
    return maxTriangleArea;
  }

  private double area(int[][] points, int i, int j, int k) {
    double ax = points[i][0];
    double ay = points[i][1];
    double bx = points[j][0];
    double by = points[j][1];
    double cx = points[k][0];
    double cy = points[k][1];
    return Math.abs((ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) / 2);
  }

}
