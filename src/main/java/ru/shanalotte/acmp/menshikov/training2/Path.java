package ru.shanalotte.acmp.menshikov.training2;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Path {

  static class Pair {
    final int x;
    final int y;

    private Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public static Pair of(int x, int y) {
      return new Pair(x, y);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Pair pair = (Pair) o;
      return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    int size = Integer.parseInt(in.nextLine());
    int[][] field = prepareField(in, size);
    calculateWeights(size, field);
    Set<Pair> route = findRoute(size, field);
    printRoute(out, size, route);

    in.close();
    out.close();
  }

  private static void printRoute(PrintWriter out, int size, Set<Pair> route) {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (route.contains(Pair.of(i, j))) {
          out.print("#");
        } else {
          out.print("-");
        }
      }
      out.println();
    }
  }

  private static Set<Pair> findRoute(int size, int[][] field) {
    Set<Pair> route = new HashSet<>();
    int y = size - 1;
    int x = size - 1;
    route.add(Pair.of(x, y));
    route.add(Pair.of(0, 0));
    while (x != 0 || y != 0) {
      int top = (x == 0) ? Integer.MAX_VALUE: field[x - 1][y];
      int left = (y == 0) ? Integer.MAX_VALUE: field[x][y - 1];
      if (top < left) {
        x--;
      } else {
        y --;
      }
      route.add(Pair.of(x, y));
    }
    return route;
  }

  private static void calculateWeights(int size, int[][] field) {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        int minTop = 0;
        if (i == 0 && j != 0) {
          minTop = Integer.MAX_VALUE;
        }
        if (i != 0) {
          minTop = field[i - 1][j];
        }
        int minLeft = (j == 0)? Integer.MAX_VALUE : field[i][j-1];
        field[i][j] = field[i][j] + Math.min(minTop, minLeft);
      }
    }
  }

  private static int[][] prepareField(Scanner in, int n) {
    int[][] field = new int[n][n];
    for (int i = 0; i < n; i++) {
      String line = in.nextLine();
      for (int j = 0; j < n; j++) {
        char c = line.charAt(j);
        int digit = c - '0';
        field[i][j] = digit;
      }
    }
    return field;
  }

}
