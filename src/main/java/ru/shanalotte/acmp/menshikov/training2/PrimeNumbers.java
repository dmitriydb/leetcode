package ru.shanalotte.acmp.menshikov.training2;

import java.io.PrintWriter;
import java.util.Scanner;

public class PrimeNumbers {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    int m = in.nextInt();
    int n = in.nextInt();

    boolean wasFound = false;

    for (int i = m; i <= n; i++) {
      if (isPrime(i)) {
        out.println(i);
        wasFound = true;
      }
    }

    if (!wasFound) {
      out.println("Absent");
    }

    in.close();
    out.close();
  }

  private static boolean isPrime(int number) {
    int squareRoot = (int) Math.sqrt(number);
    for (int i = 2; i <= squareRoot; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }

}
