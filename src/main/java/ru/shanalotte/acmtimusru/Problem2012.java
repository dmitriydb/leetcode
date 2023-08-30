package ru.shanalotte.acmtimusru;

import java.io.PrintWriter;
import java.util.Scanner;

public class Problem2012
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int f = in.nextInt();
    out.println(12 - f <= 5 ? "YES": "NO");
    out.flush();
  }
}