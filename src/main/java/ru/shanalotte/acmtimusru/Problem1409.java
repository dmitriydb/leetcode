package ru.shanalotte.acmtimusru;

import java.io.PrintWriter;
import java.util.Scanner;

public class Problem1409 {

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int a = in.nextInt();
    int b = in.nextInt();
    int bottlesQty = a + b - 1;
    out.print((bottlesQty - a) + " " + (bottlesQty - b));
    out.flush();
    in.close();
    out.close();
  }
}
