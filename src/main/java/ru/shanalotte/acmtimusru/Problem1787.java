package ru.shanalotte.acmtimusru;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem1787 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int k = in.nextInt();
    int n = in.nextInt();
    out.println(
        IntStream
        .rangeClosed(1, n)
        .map(e -> in.nextInt())
        .reduce(0, (acc, elem) -> Math.max(0, acc += (elem - k)))
    );
    out.flush();
  }
}