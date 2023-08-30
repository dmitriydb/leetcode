package ru.shanalotte.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

public class Problem763 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out, true);
    int x = in.nextInt();
    int y = in.nextInt();
    if (x == 1 && y == 1) {
      out.println(0);
    } else {
      out.println(x == y ? 2 : 1);
    }
    in.close();
    out.close();
  }

  private static boolean isEven(int i) {
    return i % 2 == 0;
  }

}
