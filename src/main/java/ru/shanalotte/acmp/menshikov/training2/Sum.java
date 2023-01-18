package ru.shanalotte.acmp.menshikov.training2;

import java.io.PrintWriter;
import java.util.Scanner;

public class Sum {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    String a = in.nextLine();
    String b = in.nextLine();
    out.println(sum(a, b));
    out.flush();
    out.close();
  }

  private static String sum(String a, String b) {
    int remainder = 0;
    int p1 = a.length() - 1;
    int p2 = b.length() - 1;
    StringBuilder sum = new StringBuilder();
    while (p1 >= 0 || p2 >= 0) {
      int firstDigit = p1 >= 0 ? (int) (a.charAt(p1) - '0') : 0;
      int secondDigit = p2 >= 0 ? (int) (b.charAt(p2) - '0') : 0;
      int localSum = firstDigit + secondDigit + remainder;
      remainder = 0;
      if (localSum >= 10) {
        localSum = localSum % 10;
        remainder = 1;
      }
      sum.insert(0, (char) ('0' + localSum));
      p1--;
      p2--;
    }
    if (remainder == 1) {
      sum.insert(0, '1');
    }
    return sum.toString();
  }

}
