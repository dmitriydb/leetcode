package ru.shanalotte.acmtimusru;

import java.io.PrintWriter;
import java.util.Scanner;

public class Problem1820 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = in.nextInt();
    int k = in.nextInt();
    if (k > n) {
      k = n;
    }
    out.println((int)Math.ceil((double) n * 2 / k));
    out.flush();
  }
}