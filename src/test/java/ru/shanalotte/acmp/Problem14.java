package ru.shanalotte.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

public class Problem14 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out, true);
    int n = in.nextInt();
    int m = in.nextInt();

    out.println(lcd(n, m));

    in.close();
    out.close();
  }

  public static int gcd(int a, int b) {
    if (a < b) {
      int temp = a;
      a = b;
      b = temp;
    }

    while (b > 0) {
      a %= b;
      int temp = a;
      a = b;
      b = temp;
    }
    return a;
  }

  public static long lcd(int a, int b) {
    return (long) a * b / gcd(a, b);
  }

}
