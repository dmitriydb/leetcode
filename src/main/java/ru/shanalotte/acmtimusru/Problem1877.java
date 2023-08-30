package ru.shanalotte.acmtimusru;

import java.io.PrintWriter;
import java.util.Scanner;

public class Problem1877
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    int a1 = Integer.parseInt(in.nextLine());
    int b1 = Integer.parseInt(in.nextLine());
    if (a1 % 2 == 0 || b1 % 2 != 0) {
      out.println("yes");
    } else {
      out.println("no");
    }
    out.flush();
  }
}