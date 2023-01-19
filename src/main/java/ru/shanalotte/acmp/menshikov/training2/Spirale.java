package ru.shanalotte.acmp.menshikov.training2;

import java.io.PrintWriter;
import java.util.Scanner;

public class Spirale {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    int n = in.nextInt();

    Vector d = Vector.startingDirection();
    int[][] matrix = new int[n][n];
    int x = 0;
    int y = 0;
    int number = 1;
    while (true) {
      matrix[x][y] = number;
      int x2 = x + d.x;
      int y2 = y + d.y;
      boolean canMove = false;
      for (int i = 0; i < 3; i++) {
        if (outOfBounds(x2, y2, n) || isOccupied(x2, y2, matrix)) {
          d = d.flip();
          x2 = x + d.x;
          y2 = y + d.y;
        } else {
          canMove = true;
          break;
        }
      }
      if (!canMove) {
        break;
      }
      x = x2;
      y = y2;
      number++;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        out.print(matrix[i][j] + " ");
      }
      out.println();
    }
    out.close();
  }

  private static boolean isOccupied(int x, int y, int[][] matrix) {
    return matrix[x][y] != 0;
  }

  private static boolean outOfBounds(int x, int y, int n) {
    return (x < 0 || y < 0 || x >= n || y >= n);
  }

  static class Vector {
    private final int x;
    private final int y;
    private final Direction direction;

    private enum Direction {
      RIGHT, DOWN, UP, LEFT;
    }

    public Vector(int x, int y, Direction direction) {
      this.x = x;
      this.y = y;
      this.direction = direction;
    }

    static Vector startingDirection() {
      return new Vector(0, +1);
    }

    Vector flip() {
      switch (direction) {
        case RIGHT: return new Vector(+1, 0, Direction.DOWN);
        case DOWN: return new Vector(0, -1, Direction.LEFT);
        case UP: return new Vector(0, +1, Direction.RIGHT);
        case LEFT: return new Vector(-1, 0, Direction.UP);
      }
      return null;
    }

    public Vector(int x, int y) {
      this.x = x;
      this.y = y;
      this.direction = Direction.RIGHT;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }
  }

}
