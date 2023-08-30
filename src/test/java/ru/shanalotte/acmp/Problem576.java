package ru.shanalotte.acmp;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem576 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out, true);
    int n = in.nextInt();
    out.println(IntStream.range(1, n).map(i -> gcd(i, n)).filter(e -> e == 1).count());
    in.close();
    out.close();
  }
  
  public static  int gcd(int a, int b) {
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

}
