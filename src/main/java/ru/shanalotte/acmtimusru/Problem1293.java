package ru.shanalotte.acmtimusru;

import java.io.PrintWriter;
import java.util.Scanner;

public class Problem1293 {
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    int a = in.nextInt();
    int b = in.nextInt();
    int n = in.nextInt();
    out.println(a * b * n * 2);
    out.flush();
    in.close();
    out.close();
  }
}
