package ru.shanalotte.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

public class Problem2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out, true);
    double n = in.nextInt();
    in.nextLine();
    if (n <= 0) {
      out.println(1 - mySum(-n));
    } else {
      out.println(mySum(n));
    }
    in.close();
    out.close();
  }

  public static long mySum(double n) {
    return (long) (((1 + n) / 2) * n);
  }

}
