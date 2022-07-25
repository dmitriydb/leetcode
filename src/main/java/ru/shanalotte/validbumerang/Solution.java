package ru.shanalotte.validbumerang;

import java.util.Objects;

public class Solution {
  public boolean isBoomerang(int[][] points) {
    return (allDistinct(points) && notInAStraightLine(points));
  }

  private boolean allDistinct(int[][] points) {
    return (Point.from(points[0]).equals(Point.from(points[1])) &&
        !Point.from(points[1]).equals(Point.from(points[2])));
  }

  private boolean notInAStraightLine(int[][] points) {
    double x3 = points[2][0];
    double y3 = points[2][1];
    double x1 = points[0][0];
    double y1 = points[0][1];
    double x2 = points[1][0];
    double y2 = points[1][1];
    return (x3 - x1) * (y2 - y1) != (y3  - y1) * (x2 - x1);
  }

  private static class Point {
    private final int x;
    private final int y;

    private Point(int[] pointArray) {
      this.x = pointArray[0];
      this.y = pointArray[1];
    }

    public static Point from(int[] pointArray) {
      return new Point(pointArray);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Point point = (Point) o;
      return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}
