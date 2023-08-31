package ru.shanalotte.acmtimusru;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class Problem2100
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = in.nextInt();
    in.nextLine();
    int sum = 2 + Stream.generate(in::nextLine).
                    limit(n)
                    .map(s -> s.contains("+") ? 2 : 1)
                    .mapToInt(e -> e)
                    .sum();
    out.println(sum == 13 ? "1400" : sum * 100);
    in.close();
    out.close();
  }
}