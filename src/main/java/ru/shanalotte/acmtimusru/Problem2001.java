package ru.shanalotte.acmtimusru;

import java.io.PrintWriter;
import java.util.Scanner;

public class Problem2001
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int a1 = in.nextInt();
    int b1 = in.nextInt();
    int a2 = in.nextInt();
    int b2 = in.nextInt();
    int a3 = in.nextInt();
    int b3 = in.nextInt();
    out.println((b3 - b1) + " " + (a2 - a1));
    out.flush();
  }
}